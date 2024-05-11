package net.davebalda.pacocraft.entity.client.obsigolem;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.entity.client.ModModelLayers;
import net.davebalda.pacocraft.entity.custom.ObsidianGolemEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ObsidianGolemRenderer extends MobEntityRenderer<ObsidianGolemEntity, ObsidianGolemModel<ObsidianGolemEntity>> {

    private static final Identifier TEXTURE = new Identifier(PacoCraft.MOD_ID, "textures/entity/obsidiangolem.png");

    public ObsidianGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new ObsidianGolemModel<>(context.getPart(ModModelLayers.OBSIDIANGOLEM)), 0.8f);
    }

    @Override
    public Identifier getTexture(ObsidianGolemEntity entity) { return TEXTURE; }

    @Override
    public void render(ObsidianGolemEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
