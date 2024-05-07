package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.block.custom.ChechenArtichokeCropBlock;
import net.davebalda.pacocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ETNITE_BLOCK);
        addDrop(ModBlocks.ETNITE_ORE, oreDrops(ModBlocks.ETNITE_ORE, ModItems.ETNITE_GEM));
        addDrop(ModBlocks.DEEPSLATE_ETNITE_ORE, oreDrops(ModBlocks.DEEPSLATE_ETNITE_ORE, ModItems.ETNITE_GEM));
        addDrop(ModBlocks.PALERMIUM_ORE, oreDrops(ModBlocks.PALERMIUM_ORE, ModItems.RAW_PALERMIUM));
        addDrop(ModBlocks.DEEPSLATE_PALERMIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_PALERMIUM_ORE, ModItems.RAW_PALERMIUM));
        addDrop(ModBlocks.NETHER_PALERMIUM_ORE, oreDrops(ModBlocks.NETHER_PALERMIUM_ORE, ModItems.RAW_PALERMIUM));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.CHECHEN_ARTICHOKE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(ChechenArtichokeCropBlock.AGE, 3));
        addDrop(ModBlocks.CHECHEN_ARTICHOKE_CROP, cropDrops(
                ModBlocks.CHECHEN_ARTICHOKE_CROP,
                ModItems.CHECHEN_ARTICHOKE,
                ModItems.CHECHEN_ARTICHOKE,
                builder));

        addDrop(ModBlocks.ORLEGNO_LOG);
        addDrop(ModBlocks.ORLEGNO_WOOD);
        addDrop(ModBlocks.STRIPPED_ORLEGNO_LOG);
        addDrop(ModBlocks.STRIPPED_ORLEGNO_WOOD);
        addDrop(ModBlocks.ORLEGNO_PLANKS);
        addDrop(ModBlocks.ORLEGNO_STAIRS);
        addDrop(ModBlocks.ORLEGNO_FENCE);
        addDrop(ModBlocks.ORLEGNO_FENCE_GATE);
        addDrop(ModBlocks.ORLEGNO_TRAPDOOR);
        addDrop(ModBlocks.ORLEGNO_BUTTON);
        addDrop(ModBlocks.ORLEGNO_PRESSURE_PLATE);
        addDrop(ModBlocks.ORLEGNO_SIGN);
        addDrop(ModBlocks.ORLEGNO_HANGING_SIGN);
        addDrop(ModBlocks.ORLEGNO_SAPLING);

        addDrop(ModBlocks.ORLEGNO_DOOR, doorDrops(ModBlocks.ORLEGNO_DOOR));
        addDrop(ModBlocks.ORLEGNO_SLAB, slabDrops(ModBlocks.ORLEGNO_SLAB));

        addDrop(ModBlocks.ORLEGNO_LEAVES, leavesDrops(ModBlocks.ORLEGNO_LEAVES, ModBlocks.ORLEGNO_SAPLING, 0.0025f));
    }
}
