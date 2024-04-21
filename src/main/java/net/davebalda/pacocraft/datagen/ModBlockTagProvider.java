package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //---- <MINEABLE & SWORD EFF.> ----//
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ETNITE_BLOCK)
                .add(ModBlocks.ETNITE_ORE)
                .add(ModBlocks.DEEPSLATE_ETNITE_ORE);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE);

        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT);


        //---- <NEEDS_TOOL> ----//
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ETNITE_BLOCK)
                .add(ModBlocks.ETNITE_ORE)
                .add(ModBlocks.DEEPSLATE_ETNITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")));


        //---- <WOOD CREATION> ----//
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ORLEGNO_LOG)
                .add(ModBlocks.STRIPPED_ORLEGNO_LOG)
                .add(ModBlocks.ORLEGNO_WOOD)
                .add(ModBlocks.STRIPPED_ORLEGNO_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.ORLEGNO_LOGS)
                .add(ModBlocks.ORLEGNO_LOG)
                .add(ModBlocks.STRIPPED_ORLEGNO_LOG)
                .add(ModBlocks.ORLEGNO_WOOD)
                .add(ModBlocks.STRIPPED_ORLEGNO_WOOD);

    }
}
