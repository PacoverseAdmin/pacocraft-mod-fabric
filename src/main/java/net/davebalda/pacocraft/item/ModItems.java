package net.davebalda.pacocraft.item;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.entity.ModEntities;
import net.davebalda.pacocraft.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    //---- <MOD ITEM LIST> ----//
    public static final Item ETNITE_GEM = registerItem("etnite_gem", new Item(new FabricItemSettings()));
    public static final Item RAW_PALERMIUM = registerItem("raw_palermium", new Item(new FabricItemSettings()));
    public static final Item PURE_PALERMIUM = registerItem("pure_palermium", new Item(new FabricItemSettings()));
    public static final Item PROTEIN_SHAKE = registerItem("protein_shake", new Item(new FabricItemSettings()
            .food(ModFoodComponents.PROTEIN_SHAKE)));
    public static final Item CHECHEN_ARTICHOKE = registerItem("chechen_artichoke", new AliasedBlockItem(
            ModBlocks.CHECHEN_ARTICHOKE_CROP, new FabricItemSettings()
            .food(ModFoodComponents.CHECHEN_ARTICHOKE)));
    public static final Item ORLEGNO_SIGN = registerItem("orlegno_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.ORLEGNO_SIGN, ModBlocks.ORLEGNO_WALL_SIGN));
    public static final Item ORLEGNO_HANGING_SIGN = registerItem("orlegno_hanging_sign",
            new HangingSignItem(ModBlocks.ORLEGNO_HANGING_SIGN, ModBlocks.ORLEGNO_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));

    //---- <MOD MOBS LIST> ----//
    public static final Item GIANGOLEM_SPAWN_EGG = registerItem("giangolem_spawn_egg",
            new SpawnEggItem(ModEntities.GIANGOLEM, 0xf2f5f3, 0x181a19, new FabricItemSettings()));
    public static final Item OBSIDIANGOLEM_SPAWN_EGG = registerItem("obsidiangolem_spawn_egg",
            new SpawnEggItem(ModEntities.OBSIDIAN_GOLEM, 0x451fad, 0xba4c11, new FabricItemSettings()));

    //---- <MOD DISC LIST> ----//
    public static final Item MUSIC_DISC_FACCETTA_NERA = registerItem("music_disc_faccetta_nera",
            new MusicDiscItem(7, ModSounds.FACCETTA_NERA, new FabricItemSettings()
                    .maxCount(1).rarity(Rarity.RARE), 138));
    public static final Item MUSIC_DISC_CHECHNYA = registerItem("music_disc_chechnya",
            new MusicDiscItem(7, ModSounds.CHECHNYA, new FabricItemSettings()
                    .maxCount(1).rarity(Rarity.RARE), 186));

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
