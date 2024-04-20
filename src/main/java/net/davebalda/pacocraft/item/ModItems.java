package net.davebalda.pacocraft.item;

import net.davebalda.pacocraft.PacoCraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //---- <MOD ITEM LIST> ----//
    public static final Item ETNITE_GEM = registerItem("etnite_gem", new Item(new FabricItemSettings()));
    public static final Item PROTEIN_SHAKE = registerItem("protein_shake", new Item(new FabricItemSettings()
            .food(ModFoodComponents.PROTEIN_SHAKE)));
    public static final Item CHECHEN_ARTICHOKE = registerItem("chechen_artichoke", new Item(new FabricItemSettings()
            .food(ModFoodComponents.CHECHEN_ARTICHOKE)));

    //---- <MOD TOOL LIST> ----//
    public static final Item ETNITE_SWORD = registerItem("etnite_sword",
            new SwordItem(ModToolMaterial.ETNITE, 4, -2.4f, new FabricItemSettings()));
    public static final Item ETNITE_PICKAXE = registerItem("etnite_pickaxe",
            new PickaxeItem(ModToolMaterial.ETNITE, 1, -2.8f, new FabricItemSettings()));
    public static final Item ETNITE_AXE = registerItem("etnite_axe",
            new AxeItem(ModToolMaterial.ETNITE, 7.0f, -3.1f, new FabricItemSettings()));
    public static final Item ETNITE_SHOVEL = registerItem("etnite_shovel",
            new ShovelItem(ModToolMaterial.ETNITE, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item ETNITE_HOE = registerItem("etnite_hoe",
            new HoeItem(ModToolMaterial.ETNITE, -2, -1.0f, new FabricItemSettings()));

    //---- <MOD ARMOR LIST> ----//
    public static final Item ETNITE_HELMET = registerItem("etnite_helmet",
            new ArmorItem(ModArmorMaterial.ETNITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ETNITE_CHESTPLATE = registerItem("etnite_chestplate",
            new ArmorItem(ModArmorMaterial.ETNITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ETNITE_LEGGINGS = registerItem("etnite_leggings",
            new ArmorItem(ModArmorMaterial.ETNITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ETNITE_BOOTS = registerItem("etnite_boots",
            new ArmorItem(ModArmorMaterial.ETNITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    //--- <METHODS> ---//
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(PacoCraft.MOD_ID, name), item);
    }

    public static void registerModItems(){
        PacoCraft.LOGGER.info("Registering Mod Items for: " + PacoCraft.MOD_ID);
    }

}
