package net.davebalda.pacocraft.item;

import net.davebalda.pacocraft.PacoCraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
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


    //--- <METHODS> ---//
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(PacoCraft.MOD_ID, name), item);
    }

    public static void registerModItems(){
        PacoCraft.LOGGER.info("Registering Mod Items for: " + PacoCraft.MOD_ID);
    }

}
