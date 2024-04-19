package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ETNITE_BLOCK);
        addDrop(ModBlocks.ETNITE_ORE, oreDrops(ModBlocks.ETNITE_ORE, ModItems.ETNITE_GEM));
        addDrop(ModBlocks.DEEPSLATE_ETNITE_ORE, oreDrops(ModBlocks.DEEPSLATE_ETNITE_ORE, ModItems.ETNITE_GEM));
    }
}
