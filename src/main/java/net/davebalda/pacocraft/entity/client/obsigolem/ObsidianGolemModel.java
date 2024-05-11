package net.davebalda.pacocraft.entity.client.obsigolem;

import net.davebalda.pacocraft.entity.animation.ModAnimations;
import net.davebalda.pacocraft.entity.custom.ObsidianGolemEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ObsidianGolemModel<T extends ObsidianGolemEntity> extends SinglePartEntityModel<T> {
    private final ModelPart obsidiangolem;
    private final ModelPart head;

    public ObsidianGolemModel(ModelPart root) {
        this.obsidiangolem = root.getChild("Obsidian_Golem");
        this.head = obsidiangolem.getChild("Upperbody").getChild("Head");

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Obsidian_Golem = modelPartData.addChild("Obsidian_Golem", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -41.0F, -3.0F));

        ModelPartData Upperbody = Obsidian_Golem.addChild("Upperbody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 32.0F, 7.0F));

        ModelPartData Head = Upperbody.addChild("Head", ModelPartBuilder.create().uv(46, 44).cuboid(-6.0F, -11.0F, -7.0F, 12.0F, 11.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -28.0F, -6.0F));

        Head.addChild("Head2_r1", ModelPartBuilder.create().uv(0, 119).cuboid(-6.0F, -7.2898F, 1.7402F, 12.0F, 8.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

        Head.addChild("Jaw", ModelPartBuilder.create().uv(110, 24).cuboid(-7.0F, -1.0F, -7.0F, 14.0F, 2.0F, 8.0F, new Dilation(0.0F))
                .uv(102, 74).cuboid(-6.75F, -3.0F, -7.25F, 13.5F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F));

        Head.addChild("Eyes", ModelPartBuilder.create().uv(0, 75).cuboid(2.0F, -3.0F, -7.5F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F))
                .uv(32, 66).cuboid(-4.0F, -3.0F, -7.5F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

        ModelPartData Horns = Head.addChild("Horns", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -6.0F, 0.0F));

        ModelPartData Horn1 = Horns.addChild("Horn1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

        Horn1.addChild("Top_r1", ModelPartBuilder.create().uv(68, 69).cuboid(-16.0F, -13.0F, -2.0F, 3.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

        Horn1.addChild("Mid_r1", ModelPartBuilder.create().uv(0, 58).cuboid(-7.0F, -18.0F, -3.0F, 4.0F, 7.0F, 3.0F, new Dilation(0.0F))
                .uv(126, 103).cuboid(-7.0F, -11.0F, -4.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        ModelPartData Horn2 = Horns.addChild("Horn2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

        Horn2.addChild("Top_r2", ModelPartBuilder.create().uv(0, 28).cuboid(13.0F, -13.0F, -2.0F, 3.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

        Horn2.addChild("Mid_r2", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, -18.0F, -3.0F, 4.0F, 7.0F, 3.0F, new Dilation(0.0F))
                .uv(124, 0).cuboid(2.0F, -11.0F, -4.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

        Upperbody.addChild("Body", ModelPartBuilder.create().uv(0, 0).cuboid(-14.0F, -14.0F, -7.0F, 28.0F, 14.0F, 14.25F, new Dilation(0.0F))
                .uv(0, 28).cuboid(-10.0F, -1.75F, -2.75F, 20.0F, 19.5F, 9.5F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -14.0F, 0.0F));

        ModelPartData Arms = Upperbody.addChild("Arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -23.0F, -1.0F));

        ModelPartData Arm1 = Arms.addChild("Arm1", ModelPartBuilder.create().uv(42, 109).cuboid(-1.0F, 3.0F, -7.0F, 8.0F, 12.0F, 9.0F, new Dilation(0.0F))
                .uv(122, 34).cuboid(-1.0F, 4.0F, 1.0F, 8.0F, 14.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(17.0F, 1.0F, 2.0F));

        Arm1.addChild("Shoulder_r1", ModelPartBuilder.create().uv(0, 100).cuboid(13.0F, -3.75F, 4.0F, 12.0F, 10.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-17.0F, -6.0F, -9.0F, 0.0F, 0.0F, 0.2618F));

        ModelPartData L_Lower_Arm = Arm1.addChild("L_Lower_Arm", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 19.0F, -3.0F));

        L_Lower_Arm.addChild("Other_Fingers_Closed_r1", ModelPartBuilder.create().uv(38, 130).cuboid(16.0F, 42.0F, 2.0F, 6.0F, 6.0F, 3.0F, new Dilation(0.0F))
                .uv(32, 58).cuboid(21.0F, 42.0F, 3.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
                .uv(70, 0).cuboid(16.0F, 37.0F, 3.0F, 7.0F, 7.0F, 5.0F, new Dilation(0.0F))
                .uv(128, 120).cuboid(17.0F, 31.0F, 2.0F, 6.0F, 7.0F, 8.0F, new Dilation(0.0F))
                .uv(104, 104).cuboid(17.0F, 17.0F, 2.0F, 6.0F, 14.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-18.0F, -25.0F, -5.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData Arm2 = Arms.addChild("Arm2", ModelPartBuilder.create().uv(105, 82).cuboid(-5.75F, 3.0F, -7.0F, 8.0F, 12.0F, 9.0F, new Dilation(0.0F))
                .uv(76, 121).cuboid(-5.75F, 4.0F, 1.0F, 8.0F, 14.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(-18.0F, 1.0F, 2.0F));

        Arm2.addChild("Shoulder_r2", ModelPartBuilder.create().uv(98, 55).cuboid(-25.0F, -3.75F, 4.0F, 12.0F, 10.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(18.0F, -6.0F, -9.0F, 0.0F, 0.0F, -0.2618F));

        ModelPartData R_Lower_Arm2 = Arm2.addChild("R_Lower_Arm2", ModelPartBuilder.create(), ModelTransform.pivot(0.25F, 19.0F, -2.0F));

        R_Lower_Arm2.addChild("Other_Fingers_Closed_r2", ModelPartBuilder.create().uv(94, 0).cuboid(-26.0F, 42.0F, 2.0F, 6.0F, 6.0F, 3.0F, new Dilation(0.0F))
                .uv(50, 28).cuboid(-28.0F, 42.0F, 3.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
                .uv(60, 31).cuboid(-27.0F, 37.0F, 3.0F, 7.0F, 7.0F, 5.0F, new Dilation(0.0F))
                .uv(106, 128).cuboid(-27.0F, 31.0F, 2.0F, 6.0F, 7.0F, 8.0F, new Dilation(0.0F))
                .uv(102, 0).cuboid(-27.0F, 17.0F, 2.0F, 6.0F, 14.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(22.0F, -25.0F, -6.0F, -0.0873F, 0.0F, 0.0F));

        ModelPartData Legs = Obsidian_Golem.addChild("Legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 36.0F, 7.0F));

        Legs.addChild("Leg1", ModelPartBuilder.create().uv(68, 74).cuboid(-6.0F, -2.0F, -5.0F, 11.0F, 5.0F, 12.0F, new Dilation(0.0F))
                .uv(84, 31).cuboid(-3.0F, 3.0F, -6.0F, 7.0F, 12.0F, 12.0F, new Dilation(0.0F))
                .uv(76, 91).cuboid(-3.0F, 15.0F, -6.0F, 7.0F, 11.0F, 12.0F, new Dilation(0.0F))
                .uv(70, 14).cuboid(-4.0F, 26.0F, -8.0F, 9.0F, 3.0F, 14.0F, new Dilation(0.0F))
                .uv(130, 79).cuboid(-3.0F, 13.0F, -7.0F, 7.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(6, 11).cuboid(2.0F, 28.0F, -8.75F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(8.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        Legs.addChild("Leg2", ModelPartBuilder.create().uv(34, 69).cuboid(-5.0F, -2.0F, -5.0F, 11.0F, 5.0F, 12.0F, new Dilation(0.0F))
                .uv(0, -8).cuboid(-4.0F, 3.0F, -6.0F, 7.0F, 12.0F, 12.0F, new Dilation(0.0F))
                .uv(38, 86).cuboid(-4.0F, 15.0F, -6.0F, 7.0F, 11.0F, 12.0F, new Dilation(0.0F))
                .uv(0, 58).cuboid(-5.0F, 26.0F, -8.0F, 9.0F, 3.0F, 14.0F, new Dilation(0.0F))
                .uv(56, 130).cuboid(-4.0F, 13.0F, -7.0F, 7.0F, 6.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(-4.0F, 28.0F, -8.75F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, -1.0F, 0.0F));
        return TexturedModelData.of(modelData, 256, 256);
    }
    @Override
    public void setAngles(ObsidianGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ModAnimations.OBSIGOLEM_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.OBSIGOLEM_IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.OBSIGOLEM_ATTACK, ageInTicks, 1f);
        this.updateAnimation(entity.sprintingAnimationState, ModAnimations.OBSIGOLEM_SPRINT, ageInTicks, 1f);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        obsidiangolem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    private void setHeadAngles(float headYaw, float headPitch){
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public ModelPart getPart() { return obsidiangolem; }
}
