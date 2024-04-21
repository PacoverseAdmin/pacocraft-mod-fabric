package net.davebalda.pacocraft;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItemGroups;
import net.davebalda.pacocraft.item.ModItems;
import net.davebalda.pacocraft.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacoCraft implements ModInitializer {
	public static final String MOD_ID = "pacocraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();

		//---- <REGISTRIES> ----//
		StrippableBlockRegistry.register(ModBlocks.ORLEGNO_LOG, ModBlocks.STRIPPED_ORLEGNO_LOG);
		StrippableBlockRegistry.register(ModBlocks.ORLEGNO_WOOD, ModBlocks.STRIPPED_ORLEGNO_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ORLEGNO_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ORLEGNO_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_LEAVES, 30, 60);
	}
}