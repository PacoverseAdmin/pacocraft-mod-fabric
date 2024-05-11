package net.davebalda.pacocraft;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.entity.ModEntities;
import net.davebalda.pacocraft.entity.client.giangolem.GiangolemModel;
import net.davebalda.pacocraft.entity.client.giangolem.GiangolemRenderer;
import net.davebalda.pacocraft.entity.client.ModModelLayers;
import net.davebalda.pacocraft.entity.client.obsigolem.ObsidianGolemModel;
import net.davebalda.pacocraft.entity.client.obsigolem.ObsidianGolemRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

public class PacoCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHECHEN_ARTICHOKE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORLEGNO_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORLEGNO_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORLEGNO_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORLEGNO_TRAPDOOR, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.GIANGOLEM, GiangolemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GIANGOLEM, GiangolemModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.OBSIDIAN_GOLEM, ObsidianGolemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.OBSIDIANGOLEM, ObsidianGolemModel::getTexturedModelData);

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.ORLEGNO_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.ORLEGNO_HANGING_SIGN_TEXTURE));
    }
}
