package net.davebalda.pacocraft;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.entity.ModEntities;
import net.davebalda.pacocraft.entity.client.GiangolemModel;
import net.davebalda.pacocraft.entity.client.GiangolemRenderer;
import net.davebalda.pacocraft.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class PacoCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHECHEN_ARTICHOKE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORLEGNO_LEAVES, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.GIANGOLEM, GiangolemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GIANGOLEM, GiangolemModel::getTexturedModelData);
    }
}
