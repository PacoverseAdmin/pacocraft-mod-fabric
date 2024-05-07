package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.block.custom.ChechenArtichokeCropBlock;
import net.davebalda.pacocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //---- <ETNITE> ----//
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ETNITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ETNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ETNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PALERMIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PALERMIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PALERMIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PALERMIUM_ORE);

        //---- <CHECH.ART> ----//
        blockStateModelGenerator.registerCrop(ModBlocks.CHECHEN_ARTICHOKE_CROP,
                ChechenArtichokeCropBlock.AGE, 0, 1, 2, 3);

        //---- <ORLEGNO> ----//
        BlockStateModelGenerator.BlockTexturePool orlegnoPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ORLEGNO_PLANKS);

        blockStateModelGenerator.registerLog(ModBlocks.ORLEGNO_LOG)
                .log(ModBlocks.ORLEGNO_LOG).wood(ModBlocks.ORLEGNO_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ORLEGNO_LOG)
                .log(ModBlocks.STRIPPED_ORLEGNO_LOG).wood(ModBlocks.STRIPPED_ORLEGNO_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORLEGNO_LEAVES);
        blockStateModelGenerator.registerDoor(ModBlocks.ORLEGNO_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ORLEGNO_TRAPDOOR);

        blockStateModelGenerator.registerTintableCross(ModBlocks.ORLEGNO_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        orlegnoPool.stairs(ModBlocks.ORLEGNO_STAIRS);
        orlegnoPool.slab(ModBlocks.ORLEGNO_SLAB);
        orlegnoPool.button(ModBlocks.ORLEGNO_BUTTON);
        orlegnoPool.pressurePlate(ModBlocks.ORLEGNO_PRESSURE_PLATE);
        orlegnoPool.fence(ModBlocks.ORLEGNO_FENCE);
        orlegnoPool.fenceGate(ModBlocks.ORLEGNO_FENCE_GATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ETNITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PALERMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_PALERMIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.PROTEIN_SHAKE, Models.GENERATED);

        itemModelGenerator.register(ModItems.MUSIC_DISC_CHECHNYA, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_FACCETTA_NERA, Models.GENERATED);

        itemModelGenerator.register(ModItems.ETNITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETNITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETNITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETNITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ETNITE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ETNITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ETNITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ETNITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ETNITE_BOOTS));

        itemModelGenerator.register(ModItems.GIANGOLEM_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
