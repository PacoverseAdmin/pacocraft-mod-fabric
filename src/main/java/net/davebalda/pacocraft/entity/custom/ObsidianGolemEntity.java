package net.davebalda.pacocraft.entity.custom;

import net.davebalda.pacocraft.entity.ai.ObsidianGolemAttackGoal;
import net.davebalda.pacocraft.item.ModItems;
import net.davebalda.pacocraft.util.EnchantmentHandler;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ObsidianGolemEntity extends GolemEntity {
    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(ObsidianGolemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState sprintingAnimationState = new AnimationState();

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public ObsidianGolemEntity(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createObsidianGolemAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 300)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.25);
    }

    private void setupAnimationStates(){
        if(this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else{
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationTimeout = 29;
            attackAnimationState.start(this.age);
            sprintingAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!isAttacking()){
            attackAnimationState.stop();
            sprintingAnimationState.stop();
        }
    }

    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    @Override
    protected void updateLimbs(float posDelta){
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new ObsidianGolemAttackGoal(this, 1D, true));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(3, new WanderAroundGoal(this, 0.6, 240, false));

        this.targetSelector.add(1, new RevengeGoal(this));
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_IRON_GOLEM_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if(source.isOf(DamageTypes.IN_FIRE) || source.isOf(DamageTypes.ON_FIRE))
            return false;

        return super.damage(source, amount);
    }

    @Override
    public void onDeath(DamageSource damageSource) {

        if(!this.getWorld().isClient() && this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_LOOT)){
            // Generates a random number between 0 and 2 and adds 1 to ensure the drops amount
            // sits between 1 and 3
            int dropAmount = random.nextInt(3) + 1;
            int lootingLevel = EnchantmentHandler.getLootingLevel(damageSource);

            if(lootingLevel != 0)
                dropAmount = dropAmount + (lootingLevel - random.nextInt(1));

            ItemStack itemToDrop = new ItemStack(Items.OBSIDIAN, dropAmount);
            this.dropStack(itemToDrop);
        }

        super.onDeath(damageSource);
    }
}
