package net.davebalda.pacocraft.block;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.custom.ChechenArtichokeCropBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    //---- <MOD BLOCK LIST> ----//
    public static final Block ETNITE_BLOCK = registerBlock("etnite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).mapColor(MapColor.RED)));

    public static final Block ETNITE_ORE = registerBlock("etnite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)
                    .mapColor(MapColor.RED)));

    public static final Block DEEPSLATE_ETNITE_ORE = registerBlock("deepslate_etnite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE)
                    .mapColor(MapColor.RED)));

    public static final Block CHECHEN_ARTICHOKE_CROP = Registry.register(Registries.BLOCK,
            new Identifier(PacoCraft.MOD_ID, "chechen_artichoke_crop"),
            new ChechenArtichokeCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block ORLEGNO_LOG = registerBlock("orlegno_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block ORLEGNO_WOOD = registerBlock("orlegno_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_ORLEGNO_LOG = registerBlock("stripped_orlegno_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_ORLEGNO_WOOD = registerBlock("stripped_orlegno_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block ORLEGNO_PLANKS = registerBlock("orlegno_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public static final Block ORLEGNO_LEAVES = registerBlock("orlegno_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static final Block ORLEGNO_STAIRS = registerBlock("orlegno_stairs",
            new StairsBlock(ModBlocks.ORLEGNO_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public static final Block ORLEGNO_SLAB = registerBlock("orlegno_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
    public static final Block ORLEGNO_BUTTON = registerBlock("orlegno_button",
            new ButtonBlock(BlockSetType.OAK, 30, FabricBlockSettings.copyOf(Blocks.OAK_BUTTON)));
    public static final Block ORLEGNO_PRESSURE_PLATE = registerBlock("orlegno_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)));
    public static final Block ORLEGNO_FENCE = registerBlock("orlegno_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public static final Block ORLEGNO_FENCE_GATE = registerBlock("orlegno_fence_gate",
            new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)));
    public static final Block ORLEGNO_DOOR = registerBlock("orlegno_door",
            new DoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_DOOR)));
    public static final Block ORLEGNO_TRAPDOOR = registerBlock("orlegno_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)));


    //---- <METHODS ----//
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PacoCraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(PacoCraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        PacoCraft.LOGGER.info("Registering Mod Blocks for: " + PacoCraft.MOD_ID);
    }
}
