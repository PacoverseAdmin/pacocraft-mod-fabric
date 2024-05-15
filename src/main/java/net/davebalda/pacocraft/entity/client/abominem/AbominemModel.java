// Made with Blockbench 4.10.0
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.davebalda.pacocraft.entity.client.abominem;

import net.davebalda.pacocraft.entity.animation.abominem.AbominemAnimations;
import net.davebalda.pacocraft.entity.custom.AbominemEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class AbominemModel<T extends AbominemEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Abominem;
	private final ModelPart head;

	public AbominemModel(ModelPart root) {
		this.Abominem = root.getChild("Abominem");
		this.head = Abominem.getChild("Head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Abominem = modelPartData.addChild("Abominem", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -3.0F, -6.0F));

		ModelPartData Head = Abominem.addChild("Head", ModelPartBuilder.create().uv(0, 7).cuboid(-6.0F, -7.0F, -6.0F, 12.0F, 13.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -56.0F, -0.5F));

        Head.addChild("Jaw", ModelPartBuilder.create().uv(120, 34).cuboid(-5.0F, 0.0F, 0.0F, 10.0F, 14.0F, 2.0F, new Dilation(0.0F))
                .uv(118, 124).cuboid(-5.0F, 0.0F, -3.0F, 1.0F, 14.0F, 5.0F, new Dilation(0.0F))
                .uv(52, 89).cuboid(4.0F, 0.0F, -3.0F, 1.0F, 14.0F, 5.0F, new Dilation(0.0F))
                .uv(83, 136).cuboid(4.0F, 0.0F, -5.0F, 1.0F, 5.0F, 3.0F, new Dilation(0.0F))
                .uv(93, 133).cuboid(-5.0F, 0.0F, -5.0F, 1.0F, 5.0F, 3.0F, new Dilation(0.0F))
                .uv(52, 19).cuboid(-5.0F, 13.0F, -3.0F, 10.0F, 2.0F, 3.0F, new Dilation(0.0F))
                .uv(21, 61).cuboid(1.0F, 0.0F, -5.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 61).cuboid(1.0F, 10.0F, -3.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 40).cuboid(-3.0F, 10.0F, -3.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(50, 44).cuboid(2.0F, 8.0F, -3.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(46, 19).cuboid(2.0F, 5.0F, -3.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(38, 19).cuboid(-5.0F, 5.0F, -3.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 19).cuboid(-5.0F, 8.0F, -3.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(38, 7).cuboid(-3.0F, 0.0F, -5.0F, 2.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

        ModelPartData Body = Abominem.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -27.0F, 5.0F));

		ModelPartData Upper_Body = Body.addChild("Upper_Body", ModelPartBuilder.create().uv(100, 0).cuboid(-4.0F, -18.0F, 1.0F, 8.0F, 28.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 40).cuboid(-11.0F, -6.0F, -2.25F, 22.0F, 15.0F, 6.0F, new Dilation(0.0F))
		.uv(122, 0).cuboid(-10.0F, -6.0F, -4.0F, 8.0F, 15.0F, 2.0F, new Dilation(0.0F))
		.uv(28, 61).cuboid(2.0F, -6.0F, -4.0F, 8.0F, 15.0F, 2.0F, new Dilation(0.0F))
		.uv(110, 124).cuboid(-1.0F, -18.0F, 3.0F, 2.0F, 26.0F, 2.0F, new Dilation(0.0F))
		.uv(74, 116).cuboid(-4.0F, -26.0F, -2.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 34).cuboid(-16.0F, -8.0F, 1.0F, 32.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-16.0F, -10.0F, 0.0F, 32.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -6.0F, 2.0F, 0.2182F, 0.0F, 0.0F));

		ModelPartData Rib_Cage = Upper_Body.addChild("Rib_Cage", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 37.0F, -3.0F));

        Rib_Cage.addChild("Rib_Left", ModelPartBuilder.create().uv(130, 128).cuboid(13.0F, -41.0F, 4.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(84, 130).cuboid(17.0F, -41.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(74, 138).cuboid(16.0F, -40.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(136, 19).cuboid(13.0F, -40.25F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(122, 21).cuboid(7.0F, -41.0F, 5.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(122, 17).cuboid(8.0F, -40.0F, -4.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        Rib_Cage.addChild("Rib_Left2", ModelPartBuilder.create().uv(74, 130).cuboid(13.0F, -41.0F, 4.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(36, 129).cuboid(17.0F, -41.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(137, 80).cuboid(16.0F, -40.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(135, 109).cuboid(13.0F, -40.25F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(120, 58).cuboid(7.0F, -41.0F, 5.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(120, 54).cuboid(8.0F, -40.0F, -4.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, 0.0F));

        Rib_Cage.addChild("Rib_Left3", ModelPartBuilder.create().uv(125, 124).cuboid(13.0F, -41.0F, 4.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(28, 127).cuboid(17.0F, -41.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(137, 76).cuboid(16.0F, -40.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(135, 105).cuboid(13.0F, -40.25F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(120, 50).cuboid(7.0F, -41.0F, 5.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(119, 105).cuboid(8.0F, -40.0F, -4.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 8.0F, -1.0F));

        Rib_Cage.addChild("Rib_Left4", ModelPartBuilder.create().uv(125, 82).cuboid(13.0F, -41.0F, 4.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(16, 127).cuboid(17.0F, -41.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(137, 66).cuboid(16.0F, -40.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(36, 135).cuboid(13.0F, -40.25F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(24, 112).cuboid(7.0F, -41.0F, 5.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(59, 89).cuboid(8.0F, -40.0F, -4.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 12.0F, -1.0F));

        Rib_Cage.addChild("Rib_Right", ModelPartBuilder.create().uv(125, 78).cuboid(-4.0F, -37.0F, 4.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(125, 72).cuboid(-5.0F, -37.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(24, 127).cuboid(-4.0F, -36.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(74, 134).cuboid(-3.0F, -36.25F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(83, 2).cuboid(1.0F, -37.0F, 5.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(28, 78).cuboid(0.0F, -36.0F, -4.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -4.0F, 0.0F));

        Rib_Cage.addChild("Rib_Right2", ModelPartBuilder.create().uv(125, 68).cuboid(-4.0F, -37.0F, 4.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(125, 62).cuboid(-5.0F, -37.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(62, 106).cuboid(-4.0F, -36.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(134, 52).cuboid(-3.0F, -36.25F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(69, 0).cuboid(1.0F, -37.0F, 5.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(56, 48).cuboid(0.0F, -36.0F, -4.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

        Rib_Cage.addChild("Rib_Right3", ModelPartBuilder.create().uv(85, 10).cuboid(-4.0F, -37.0F, 4.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(89, 87).cuboid(-5.0F, -37.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(18, 95).cuboid(-4.0F, -36.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(133, 72).cuboid(-3.0F, -36.25F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(56, 44).cuboid(1.0F, -37.0F, 5.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(52, 28).cuboid(0.0F, -36.0F, -4.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 4.0F, -1.0F));

        Rib_Cage.addChild("Rib_Right4", ModelPartBuilder.create().uv(85, 6).cuboid(-4.0F, -37.0F, 4.0F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(70, 53).cuboid(-5.0F, -37.0F, 1.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(92, 14).cuboid(-4.0F, -36.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(40, 112).cuboid(-3.0F, -36.25F, -3.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(52, 24).cuboid(1.0F, -37.0F, 5.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(50, 40).cuboid(0.0F, -36.0F, -4.0F, 6.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 8.0F, -1.0F));

        ModelPartData Arms = Upper_Body.addChild("Arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.0F, -5.0F));

		ModelPartData Arm_Left = Arms.addChild("Arm_Left", ModelPartBuilder.create().uv(113, 110).cuboid(-3.0F, -6.0F, -4.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F))
		.uv(133, 59).cuboid(-1.0F, -10.0F, -2.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(44, 78).cuboid(-1.0F, -13.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(26, 133).cuboid(3.0F, -8.0F, -2.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 13).cuboid(0.0F, -4.0F, 1.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(68, 29).cuboid(4.0F, -11.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(18.0F, 3.0F, 8.0F));

        Arm_Left.addChild("Arm_r1", ModelPartBuilder.create().uv(105, 59).cuboid(-1.0F, -2.0F, -2.0F, 5.0F, 23.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 3.0F, -1.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData Lower_Arm = Arm_Left.addChild("Lower_Arm", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, 23.0F, 0.0F));

		ModelPartData f1 = Lower_Arm.addChild("f1", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, -3.0F));

        f1.addChild("Forearm1_r1", ModelPartBuilder.create().uv(66, 124).cuboid(3.0F, 23.0F, 4.0F, 2.0F, 29.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -23.0F, -5.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData f2 = Lower_Arm.addChild("f2", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 0.0F, -3.0F));

        f2.addChild("Forearm2_r1", ModelPartBuilder.create().uv(58, 124).cuboid(0.0F, 22.0F, 6.0F, 2.0F, 29.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -23.0F, -5.0F, -0.0873F, 0.0F, 0.0F));

        Lower_Arm.addChild("f3", ModelPartBuilder.create().uv(50, 124).cuboid(1.0F, 0.0F, 0.0F, 2.0F, 29.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Arm_Right = Arms.addChild("Arm_Right", ModelPartBuilder.create().uv(46, 110).cuboid(-5.0F, -6.0F, -4.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F))
		.uv(16, 133).cuboid(-1.0F, -10.0F, -2.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(68, 24).cuboid(0.0F, -13.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(130, 132).cuboid(-5.0F, -8.0F, -2.0F, 2.0F, 4.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 7).cuboid(-3.0F, -4.0F, 1.0F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, -11.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-18.0F, 3.0F, 8.0F));

        Arm_Right.addChild("Arm_r2", ModelPartBuilder.create().uv(100, 31).cuboid(-4.0F, -2.0F, -2.0F, 5.0F, 23.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 3.0F, -1.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData Lower_Arm2 = Arm_Right.addChild("Lower_Arm2", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 23.0F, 0.0F));

		ModelPartData f4 = Lower_Arm2.addChild("f4", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, 0.0F, -3.0F));

        f4.addChild("Forearm1_r2", ModelPartBuilder.create().uv(8, 124).cuboid(3.0F, 23.0F, 4.0F, 2.0F, 29.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -23.0F, -5.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData f5 = Lower_Arm2.addChild("f5", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 0.0F, -3.0F));

        f5.addChild("Forearm2_r2", ModelPartBuilder.create().uv(0, 124).cuboid(0.0F, 22.0F, 6.0F, 2.0F, 29.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -23.0F, -5.0F, -0.0873F, 0.0F, 0.0F));

        Lower_Arm2.addChild("f6", ModelPartBuilder.create().uv(102, 116).cuboid(-3.0F, 0.0F, 0.0F, 2.0F, 29.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Center_Body = Body.addChild("Center_Body", ModelPartBuilder.create(), ModelTransform.of(0.0F, 3.0F, 0.75F, -0.0873F, 0.0F, 0.0F));

        Center_Body.addChild("Body_Center_Low_r1", ModelPartBuilder.create().uv(119, 87).cuboid(-4.0F, -26.0F, 6.0F, 8.0F, 15.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 24.0F, -5.0F, -0.1309F, 0.0F, 0.0F));

        ModelPartData Lower_Body = Abominem.addChild("Lower_Body", ModelPartBuilder.create().uv(38, 7).cuboid(-10.0F, 0.0F, -4.25F, 20.0F, 5.0F, 7.0F, new Dilation(0.0F))
		.uv(18, 118).cuboid(1.0F, 4.0F, -4.0F, 10.0F, 3.0F, 6.0F, new Dilation(0.0F))
		.uv(116, 25).cuboid(-11.0F, 4.0F, -4.0F, 10.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -12.0F, 8.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData Legs = Lower_Body.addChild("Legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Leg_Left_Front = Legs.addChild("Leg_Left_Front", ModelPartBuilder.create(), ModelTransform.pivot(12.0F, 4.0F, -4.0F));

        Leg_Left_Front.addChild("Upper_Leg_r1", ModelPartBuilder.create().uv(77, 53).cuboid(8.0F, 3.0F, -3.0F, 7.0F, 27.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -4.0F, 4.0F, -0.9599F, 0.0F, 0.0F));

        ModelPartData Low = Leg_Left_Front.addChild("Low", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 15.0F, -18.0F));

        Low.addChild("Lower_Leg_r1", ModelPartBuilder.create().uv(95, 87).cuboid(8.0F, 16.0F, -28.0F, 6.0F, 23.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -19.0F, 22.0F, 0.0873F, 0.0F, 0.0F));

        ModelPartData Leg_Right_Front = Legs.addChild("Leg_Right_Front", ModelPartBuilder.create(), ModelTransform.pivot(-12.0F, 4.0F, -4.0F));

        Leg_Right_Front.addChild("Upper_Leg_r2", ModelPartBuilder.create().uv(49, 54).cuboid(8.0F, 3.0F, -3.0F, 7.0F, 28.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, -4.0F, 4.0F, -0.9599F, 0.0F, 0.0F));

        ModelPartData Low4 = Leg_Right_Front.addChild("Low4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 15.0F, -18.0F));

        Low4.addChild("Lower_Leg_r2", ModelPartBuilder.create().uv(0, 95).cuboid(8.0F, 16.0F, -29.0F, 6.0F, 23.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, -19.0F, 22.0F, 0.0873F, 0.0F, 0.0F));

        ModelPartData Leg_Left_Rear = Legs.addChild("Leg_Left_Rear", ModelPartBuilder.create(), ModelTransform.pivot(12.0F, 4.0F, 4.0F));

        Leg_Left_Rear.addChild("Upper_Leg_r3", ModelPartBuilder.create().uv(72, 19).cuboid(8.0F, -40.0F, -24.0F, 7.0F, 27.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -4.0F, 42.0F, 1.1345F, 0.0F, 0.0F));

        ModelPartData Low3 = Leg_Left_Rear.addChild("Low3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 18.0F));

        Low3.addChild("Lower_Leg_r3", ModelPartBuilder.create().uv(71, 87).cuboid(8.0F, 13.0F, -25.0F, 6.0F, 23.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -16.0F, 24.0F, 0.0873F, 0.0F, 0.0F));

        ModelPartData Leg_Right_Rear = Legs.addChild("Leg_Right_Rear", ModelPartBuilder.create(), ModelTransform.pivot(-12.0F, 4.0F, 4.0F));

        Leg_Right_Rear.addChild("Upper_Leg_r4", ModelPartBuilder.create().uv(0, 61).cuboid(8.0F, -40.0F, -24.0F, 7.0F, 27.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, -4.0F, 42.0F, 1.1345F, 0.0F, 0.0F));

        ModelPartData Low2 = Leg_Right_Rear.addChild("Low2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 18.0F));

        Low2.addChild("Lower_Leg_r4", ModelPartBuilder.create().uv(28, 83).cuboid(8.0F, 13.0F, -25.0F, 6.0F, 23.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-11.0F, -16.0F, 24.0F, 0.0873F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 256, 256);
	}
	@Override
	public void setAngles(AbominemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(AbominemAnimations.ABOMINEM_WALK, limbSwing, limbSwingAmount, 1f, 1f);
		this.updateAnimation(entity.idleAnimationState, AbominemAnimations.ABOMINEM_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, AbominemAnimations.ABOMINEM_ATTACK, ageInTicks, 1f);
		this.updateAnimation(entity.sprintingAnimationState, AbominemAnimations.ABOMINEM_CHASE, ageInTicks, 1f);

	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Abominem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public ModelPart getPart() { return Abominem; }
}