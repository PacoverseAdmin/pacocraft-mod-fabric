package net.davebalda.pacocraft.entity.client;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.entity.custom.GiangolemEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GiangolemRenderer extends MobEntityRenderer<GiangolemEntity, GiangolemModel<GiangolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(PacoCraft.MOD_ID, "textures/entity/giangolem.png");

    public GiangolemRenderer(EntityRendererFactory.Context context) {
        super(context, new GiangolemModel<>(context.getPart(ModModelLayers.GIANGOLEM)), 0.8f);
    }

    @Override
    public Identifier getTexture(GiangolemEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GiangolemEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
