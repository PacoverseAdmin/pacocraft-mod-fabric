// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.davebalda.pacocraft.entity.client;

import net.davebalda.pacocraft.entity.animation.ModAnimations;
import net.davebalda.pacocraft.entity.custom.GiangolemEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class GiangolemModel<T extends GiangolemEntity> extends SinglePartEntityModel<T> {
	private final ModelPart giangolem;
	private final ModelPart head;

	public GiangolemModel(ModelPart root) {
		this.giangolem = root.getChild("giangolem");
		this.head = giangolem.getChild("upperbody").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData giangolem = modelPartData.addChild("giangolem", ModelPartBuilder.create(),
				ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData upperbody = giangolem.addChild("upperbody", ModelPartBuilder.create(),
				ModelTransform.of(0.0F, -19.0F, 1.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData head = upperbody.addChild("head", ModelPartBuilder.create(),
				ModelTransform.pivot(0.0F, -22.0F, -3.0F));

		ModelPartData skull = head.addChild("skull", ModelPartBuilder.create().uv(41, 44)
				.cuboid(-4.0F, -5.0F, -3.0F, 8.0F, 8.0F, 7.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData beard = head.addChild("beard", ModelPartBuilder.create().uv(44, 59)
				.cuboid(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 2).cuboid(-4.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(1.0F, 0.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(48, 41).cuboid(-4.0F, 1.0F, 0.0F, 8.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(60, 30).cuboid(-3.0F, 2.0F, 0.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(42, 30).cuboid(-2.0F, 3.0F, 0.0F, 4.0F, 1.0F, 1.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 1.0F, -4.0F));

		ModelPartData torso = upperbody.addChild("torso", ModelPartBuilder.create().uv(0, 0)
				.cuboid(-8.0F, -19.0F, -4.0F, 16.0F, 20.0F, 8.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData arms = upperbody.addChild("arms", ModelPartBuilder.create(),
				ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData r_arm = arms.addChild("r_arm", ModelPartBuilder.create(),
				ModelTransform.pivot(-11.0F, 1.0F, 0.0F));

		ModelPartData r_upperarm = r_arm.addChild("r_upperarm", ModelPartBuilder.create().uv(0, 28)
				.cuboid(-3.0F, -1.0F, -3.0F, 6.0F, 17.0F, 6.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData r_forearm = r_arm.addChild("r_forearm", ModelPartBuilder.create(),
				ModelTransform.pivot(0.0F, 16.0F, 0.0F));

		ModelPartData r_forearm_r1 = r_forearm.addChild("r_forearm_r1", ModelPartBuilder.create().uv(0, 51)
				.cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)),
				ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData l_arm = arms.addChild("l_arm", ModelPartBuilder.create(),
				ModelTransform.pivot(11.0F, 1.0F, 0.0F));

		ModelPartData l_upperarm = l_arm.addChild("l_upperarm", ModelPartBuilder.create().uv(24, 28)
				.cuboid(-3.0F, -1.0F, -3.0F, 6.0F, 17.0F, 6.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData l_forearm = l_arm.addChild("l_forearm", ModelPartBuilder.create(),
				ModelTransform.pivot(0.0F, 17.0F, 0.0F));

		ModelPartData l_forearm_r1 = l_forearm.addChild("l_forearm_r1", ModelPartBuilder.create().uv(16, 51)
				.cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)),
				ModelTransform.of(0.0F, -1.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData lowerbody = giangolem.addChild("lowerbody", ModelPartBuilder.create(),
				ModelTransform.pivot(0.0F, -18.0F, 1.0F));

		ModelPartData legs = lowerbody.addChild("legs", ModelPartBuilder.create(),
				ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData r_leg = legs.addChild("r_leg", ModelPartBuilder.create(),
				ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

		ModelPartData r_upperleg = r_leg.addChild("r_upperleg", ModelPartBuilder.create().uv(48, 15)
				.cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData r_foreleg = r_leg.addChild("r_foreleg", ModelPartBuilder.create(),
				ModelTransform.pivot(0.0F, 9.0F, 0.0F));

		ModelPartData r_foreleg_r1 = r_foreleg.addChild("r_foreleg_r1", ModelPartBuilder.create().uv(32, 59)
				.cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)),
				ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData r_foot = r_leg.addChild("r_foot", ModelPartBuilder.create().uv(18, 28)
				.cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 16.0F, 0.0F));

		ModelPartData l_leg = legs.addChild("l_leg", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, 0.0F, 0.0F));

		ModelPartData l_upperleg = l_leg.addChild("l_upperleg", ModelPartBuilder.create().uv(48, 0)
				.cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData l_foreleg = l_leg.addChild("l_foreleg", ModelPartBuilder.create(),
				ModelTransform.pivot(0.0F, 9.0F, 0.0F));

		ModelPartData l_foreleg_r1 = l_foreleg.addChild("l_foreleg_r1", ModelPartBuilder.create().uv(48, 30)
				.cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F)),
				ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		ModelPartData l_foot = l_leg.addChild("l_foot", ModelPartBuilder.create().uv(40, 0)
				.cuboid(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)),
				ModelTransform.pivot(0.0F, 16.0F, 0.0F));

		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(GiangolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.GIANGOLEM_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.GIANGOLEM_ATTACK, ageInTicks, 1f);;
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		giangolem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return giangolem;
	}
}