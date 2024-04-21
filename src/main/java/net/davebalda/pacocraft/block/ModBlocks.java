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
