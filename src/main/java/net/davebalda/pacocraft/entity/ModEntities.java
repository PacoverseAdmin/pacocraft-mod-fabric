package net.davebalda.pacocraft.entity;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.entity.custom.GiangolemEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<GiangolemEntity> GIANGOLEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(PacoCraft.MOD_ID, "giangolem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GiangolemEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 2.5f)).build());

    public static void registerModEntities(){
        PacoCraft.LOGGER.info("Registering Mod Entities for: " + PacoCraft.MOD_ID);
    }
}
