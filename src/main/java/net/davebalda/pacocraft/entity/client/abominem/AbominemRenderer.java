package net.davebalda.pacocraft.entity.client.abominem;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.entity.client.ModModelLayers;
import net.davebalda.pacocraft.entity.client.giangolem.GiangolemModel;
import net.davebalda.pacocraft.entity.custom.AbominemEntity;
import net.davebalda.pacocraft.entity.custom.GiangolemEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AbominemRenderer extends MobEntityRenderer<AbominemEntity, AbominemModel<AbominemEntity>> {
    private static final Identifier TEXTURE = new Identifier(PacoCraft.MOD_ID, "textures/entity/abominem.png");

    public AbominemRenderer(EntityRendererFactory.Context context) {
        super(context, new AbominemModel<>(context.getPart(ModModelLayers.ABOMINEM)), 0.8f);
    }

    @Override
    public Identifier getTexture(AbominemEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AbominemEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
