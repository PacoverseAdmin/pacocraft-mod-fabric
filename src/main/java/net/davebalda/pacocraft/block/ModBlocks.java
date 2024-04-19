package net.davebalda.pacocraft.block;

import net.davebalda.pacocraft.PacoCraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block ETNITE_BLOCK = registerBlock("etnite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK).mapColor(MapColor.RED)));

    public static final Block ETNITE_ORE = registerBlock("etnite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.EMERALD_ORE).mapColor(MapColor.RED)));

    public static final Block DEEPSLATE_ETNITE_ORE = registerBlock("deepslate_etnite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE).mapColor(MapColor.RED)));

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
