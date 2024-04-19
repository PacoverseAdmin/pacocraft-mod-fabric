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
                        entries.add(ModItems.PROTEIN_SHAKE);
                        entries.add(ModItems.CHECHEN_ARTICHOKE);

                    }).build());

    public static final ItemGroup TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PacoCraft.MOD_ID, "tools"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pacocraft.tools"))
                    .icon(() -> new ItemStack(Items.BARRIER)).entries((displayContext, entries) -> {

                        //Entries for "Paco Craft Tools & Armor" tab
                        entries.add(Blocks.BARRIER);

                    }).build());

    public static final ItemGroup BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(PacoCraft.MOD_ID, "blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pacocraft.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.ETNITE_BLOCK)).entries((displayContext, entries) -> {

                        //Entries for "Paco Craft Blocks" tab
                        entries.add(ModBlocks.ETNITE_BLOCK);
                        entries.add(ModBlocks.ETNITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ETNITE_ORE);

                    }).build());

    //---- <METHODS> ----//
    public static void registerItemGroups(){
        PacoCraft.LOGGER.info("Registering Item Groups for: " + PacoCraft.MOD_ID);
    }

}
