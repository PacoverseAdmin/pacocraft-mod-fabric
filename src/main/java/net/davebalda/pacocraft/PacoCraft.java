package net.davebalda.pacocraft;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.entity.ModEntities;
import net.davebalda.pacocraft.item.ModItemGroups;
import net.davebalda.pacocraft.item.ModItems;
import net.davebalda.pacocraft.painting.ModPaintings;
import net.davebalda.pacocraft.sound.ModSounds;
import net.davebalda.pacocraft.util.ModRegistries;
import net.davebalda.pacocraft.world.gen.ModWorldGeneration;
import net.davebalda.pacocraft.world.tree.ModTrunkPlacersType;
import net.fabricmc.api.ModInitializer;

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
		ModEntities.registerModEntities();
		ModWorldGeneration.generateModWorldGen();
		ModPaintings.registerPaintings();
		ModTrunkPlacersType.registerTrunkPlacers();

		//---- <REGISTRIES> ----//
		ModRegistries.registerModStuff();
	}
}