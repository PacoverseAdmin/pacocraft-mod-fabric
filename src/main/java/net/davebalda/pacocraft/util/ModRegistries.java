package net.davebalda.pacocraft.util;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.command.EClearCommand;
import net.davebalda.pacocraft.command.HealCommand;
import net.davebalda.pacocraft.entity.ModEntities;
import net.davebalda.pacocraft.entity.custom.AbominemEntity;
import net.davebalda.pacocraft.entity.custom.GiangolemEntity;
import net.davebalda.pacocraft.entity.custom.ObsidianGolemEntity;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModRegistries {
    public static void registerModStuff(){
        registerCommands();
        registerFlammables();
        registerEntities();
        registerStrippables();
    }

    private static void registerCommands(){
        CommandRegistrationCallback.EVENT.register(HealCommand::register);
        CommandRegistrationCallback.EVENT.register(EClearCommand::register);
    }

    private static void registerFlammables(){
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ORLEGNO_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ORLEGNO_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORLEGNO_STAIRS, 5, 20);
    }

    private static void registerStrippables(){
        StrippableBlockRegistry.register(ModBlocks.ORLEGNO_LOG, ModBlocks.STRIPPED_ORLEGNO_LOG);
        StrippableBlockRegistry.register(ModBlocks.ORLEGNO_WOOD, ModBlocks.STRIPPED_ORLEGNO_WOOD);
    }

    private static void registerEntities(){
        FabricDefaultAttributeRegistry.register(ModEntities.GIANGOLEM, GiangolemEntity.createGiangolemAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.OBSIDIAN_GOLEM, ObsidianGolemEntity.createObsidianGolemAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ABOMINEM, AbominemEntity.createAbominemAttributes());
    }
}
