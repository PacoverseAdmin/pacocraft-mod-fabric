package net.davebalda.pacocraft.item;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //---- <MOD CREATIVE TABS> ----//
    public static final ItemGroup ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PacoCraft.MOD_ID, "items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pacocraft.items"))
                    .icon(() -> new ItemStack(ModItems.ETNITE_GEM)).entries((displayContext, entries) -> {

                        //Entries for "Paco Craft Items" tab
                        entries.add(ModItems.ETNITE_GEM);
                        entries.add(ModItems.RAW_PALERMIUM);
                        entries.add(ModItems.PURE_PALERMIUM);
                        entries.add(ModItems.PROTEIN_SHAKE);
                        entries.add(ModItems.CHECHEN_ARTICHOKE);
                        entries.add(ModItems.MUSIC_DISC_FACCETTA_NERA);
                        entries.add(ModItems.MUSIC_DISC_CHECHNYA);
                        entries.add(ModItems.GIANGOLEM_SPAWN_EGG);

                    }).build());

    public static final ItemGroup TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PacoCraft.MOD_ID, "tools"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pacocraft.tools"))
                    .icon(() -> new ItemStack(ModItems.ETNITE_PICKAXE)).entries((displayContext, entries) -> {

                        //Entries for "Paco Craft Tools & Armor" tab
                        entries.add(ModItems.ETNITE_SWORD);
                        entries.add(ModItems.ETNITE_PICKAXE);
                        entries.add(ModItems.ETNITE_AXE);
                        entries.add(ModItems.ETNITE_SHOVEL);
                        entries.add(ModItems.ETNITE_HOE);
                        entries.add(ModItems.ETNITE_HELMET);
                        entries.add(ModItems.ETNITE_CHESTPLATE);
                        entries.add(ModItems.ETNITE_LEGGINGS);
                        entries.add(ModItems.ETNITE_BOOTS);

                    }).build());

    public static final ItemGroup BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PacoCraft.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pacocraft.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.ETNITE_BLOCK)).entries((displayContext, entries) -> {

                        //Entries for "Paco Craft Blocks" tab
                        entries.add(ModBlocks.ETNITE_BLOCK);
                        entries.add(ModBlocks.ETNITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ETNITE_ORE);
                        entries.add(ModBlocks.PALERMIUM_BLOCK);
                        entries.add(ModBlocks.PALERMIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PALERMIUM_ORE);
                        entries.add(ModBlocks.NETHER_PALERMIUM_ORE);
                        entries.add(ModBlocks.ORLEGNO_LOG);
                        entries.add(ModBlocks.ORLEGNO_WOOD);
                        entries.add(ModBlocks.STRIPPED_ORLEGNO_LOG);
                        entries.add(ModBlocks.STRIPPED_ORLEGNO_WOOD);
                        entries.add(ModBlocks.ORLEGNO_PLANKS);
                        entries.add(ModBlocks.ORLEGNO_LEAVES);
                        entries.add(ModBlocks.ORLEGNO_SAPLING);
                        entries.add(ModBlocks.ORLEGNO_STAIRS);
                        entries.add(ModBlocks.ORLEGNO_SLAB);
                        entries.add(ModBlocks.ORLEGNO_PRESSURE_PLATE);
                        entries.add(ModBlocks.ORLEGNO_BUTTON);
                        entries.add(ModBlocks.ORLEGNO_FENCE);
                        entries.add(ModBlocks.ORLEGNO_FENCE_GATE);
                        entries.add(ModBlocks.ORLEGNO_DOOR);
                        entries.add(ModBlocks.ORLEGNO_TRAPDOOR);
                        entries.add(ModBlocks.ORLEGNO_SIGN);
                        entries.add(ModBlocks.ORLEGNO_HANGING_SIGN);

                    }).build());

    //---- <METHODS> ----//
    public static void registerItemGroups(){
        PacoCraft.LOGGER.info("Registering Item Groups for: " + PacoCraft.MOD_ID);
    }

}
