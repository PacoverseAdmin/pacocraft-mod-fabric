package net.davebalda.pacocraft.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class GiangolemEntity extends GolemEntity implements Angerable {

    private int angerTime;
    private UUID angryAt;

    public GiangolemEntity(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createGiangolemAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.50)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.6, 240, false));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
    }

    @Override
    public int getAngerTime() {
        return this.angerTime;
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.angerTime = angerTime;
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    public void chooseRandomAngerTime() {

    }

    @Override
    public void writeAngerToNbt(NbtCompound nbt) {
        Angerable.super.writeAngerToNbt(nbt);
    }

    @Override
    public void readAngerFromNbt(World world, NbtCompound nbt) {
        Angerable.super.readAngerFromNbt(world, nbt);
    }

    @Override
    public void tickAngerLogic(ServerWorld world, boolean angerPersistent) {
        Angerable.super.tickAngerLogic(world, angerPersistent);
    }

    @Override
    public boolean shouldAngerAt(LivingEntity entity) {
        return Angerable.super.shouldAngerAt(entity);
    }

    @Override
    public boolean isUniversallyAngry(World world) {
        return Angerable.super.isUniversallyAngry(world);
    }

    @Override
    public boolean hasAngerTime() {
        return Angerable.super.hasAngerTime();
    }

    @Override
    public void forgive(PlayerEntity player) {
        Angerable.super.forgive(player);
    }

    @Override
    public void universallyAnger() {
        Angerable.super.universallyAnger();
    }

    @Override
    public void stopAnger() {
        Angerable.super.stopAnger();
    }
}
