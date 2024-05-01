package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.davebalda.pacocraft.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ETNITE_HELMET)
                .add(ModItems.ETNITE_CHESTPLATE)
                .add(ModItems.ETNITE_LEGGINGS)
                .add(ModItems.ETNITE_BOOTS);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_FACCETTA_NERA)
                .add(ModItems.MUSIC_DISC_CHECHNYA);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.ORLEGNO_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ORLEGNO_LOG.asItem())
                .add(ModBlocks.STRIPPED_ORLEGNO_LOG.asItem())
                .add(ModBlocks.ORLEGNO_WOOD.asItem())
                .add(ModBlocks.STRIPPED_ORLEGNO_WOOD.asItem());

        getOrCreateTagBuilder(ModTags.Items.ORLEGNO_LOGS)
                .add(ModBlocks.ORLEGNO_LOG.asItem())
                .add(ModBlocks.ORLEGNO_WOOD.asItem())
                .add(ModBlocks.STRIPPED_ORLEGNO_LOG.asItem())
                .add(ModBlocks.STRIPPED_ORLEGNO_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.ORLEGNO_FENCE.asItem());

        getOrCreateTagBuilder(ItemTags.FENCE_GATES)
                .add(ModBlocks.ORLEGNO_FENCE_GATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.ORLEGNO_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.ORLEGNO_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.ORLEGNO_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.ORLEGNO_BUTTON.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.ORLEGNO_DOOR.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.ORLEGNO_TRAPDOOR.asItem());
    }
}
