package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ETNITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ETNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ETNITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ETNITE_GEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.PROTEIN_SHAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHECHEN_ARTICHOKE, Models.GENERATED);

        itemModelGenerator.register(ModItems.ETNITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETNITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETNITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETNITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETNITE_HOE, Models.HANDHELD);
    }
}
