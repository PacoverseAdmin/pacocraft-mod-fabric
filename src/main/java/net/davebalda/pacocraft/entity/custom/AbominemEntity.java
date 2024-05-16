package net.davebalda.pacocraft.entity.custom;

import net.davebalda.pacocraft.entity.ai.AbominemAttackGoal;
import net.davebalda.pacocraft.sound.ModSounds;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AbominemEntity extends HostileEntity {

    private int ticks = 0;
    private int darknessEffectTicks = 0;
    private int alertSoundTicks = 0;

    private boolean playAlertSound = true;

    private static final TargetPredicate PLAYER_CLOSE = TargetPredicate.createAttackable().setBaseMaxDistance(35.0D);

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(AbominemEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState sprintingAnimationState = new AnimationState();
    private int sprintingAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public AbominemEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAbominemAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 150)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.40)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0);
    }

    private boolean checkIfPlayerInDistance(int distance, PlayerEntity player){
        double distanceToPlayer = this.distanceTo(player);
        return distanceToPlayer <= distance;
    }

    private void applyAbominemDarknessEffect(){
        List<? extends PlayerEntity> players = this.getWorld().getPlayers();

        for (PlayerEntity player : players) {
            if(checkIfPlayerInDistance(20, player))
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 230, 1));
        }
    }

    private void playAbominemSound(SoundEvent sound, int distance){
        List<? extends PlayerEntity> players = this.getWorld().getPlayers();

        for (PlayerEntity player : players) {
            if(checkIfPlayerInDistance(distance, player)) {
                this.getWorld().playSound(
                        null,
                        player.getBlockPos(),
                        sound,
                        SoundCategory.NEUTRAL,
                        2.0F,
                        1.0F
                );
            }
        }
    }

    private void decreaseTickCounters(){
        if(ticks > 0)
            ticks = ticks - 1;
        if(darknessEffectTicks > 0)
            darknessEffectTicks = darknessEffectTicks - 1;
        if(sprintingAnimationTimeout > 0)
            sprintingAnimationTimeout = sprintingAnimationTimeout - 1;
        if(alertSoundTicks > 0)
            alertSoundTicks = alertSoundTicks - 1;
    }

    private void setupAnimationStates(){
        if(this.getTarget() != null) {
            if (sprintingAnimationTimeout <= 0) {
                idleAnimationState.stop();
                sprintingAnimationTimeout = 20;
                sprintingAnimationState.start(this.age);
            }
        }
        else {
            if(sprintingAnimationState.isRunning()){
                sprintingAnimationState.stop();
                this.idleAnimationTimeout = 0;
            }
        }

        if(this.idleAnimationTimeout <= 0 && this.getTarget() == null){
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else{
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationTimeout = 19;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!isAttacking()){
            attackAnimationState.stop();
        }
    }

    @Override
    public void tick() {
        super.tick();

        System.out.println("IDLE ANIM: " + idleAnimationState.isRunning());
        System.out.println("SPRINTING ANIM: " + sprintingAnimationState.isRunning());
        System.out.println("ATTACCKING ANIM: " + attackAnimationState.isRunning());

        if(this.getTarget() != null){
            if(!this.getWorld().isClient && playAlertSound && alertSoundTicks <= 0){
                alertSoundTicks = 200;
                playAbominemSound(ModSounds.ABOMINEM_ALERT, 35);
                playAlertSound = false;
            }
        }
        else
            playAlertSound = true;

        if(this.getWorld().isClient)
            setupAnimationStates();

        if(darknessEffectTicks <= 0) {
            applyAbominemDarknessEffect();
            darknessEffectTicks = 200;
        }

        if (!this.getWorld().isClient && ticks <= 0) {
            playAbominemSound(ModSounds.ABOMINEM_AMBIENT, 50);
            ticks = 321;
        }

        decreaseTickCounters();
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AbominemAttackGoal(this, 1D, true));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(3, new WanderAroundGoal(this, 0.6, 240, false));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ABOMINEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ABOMINEM_DEATH;
    }

    @Nullable
    @Override
    public LivingEntity getTarget() {
        LivingEntity target = getWorld().getClosestPlayer(PLAYER_CLOSE, this);

        if (target != null && target.isAlive()){ return target; }

        return super.getTarget();
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
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
        super.updateLimbs(posDelta);
    }
}