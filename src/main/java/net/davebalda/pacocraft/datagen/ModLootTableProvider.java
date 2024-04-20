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

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.CHECHEN_ARTICHOKE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(ChechenArtichokeCropBlock.AGE, 3));
        addDrop(ModBlocks.CHECHEN_ARTICHOKE_CROP, cropDrops(
                ModBlocks.CHECHEN_ARTICHOKE_CROP,
                ModItems.CHECHEN_ARTICHOKE,
                ModItems.CHECHEN_ARTICHOKE,
                builder));
    }
}
