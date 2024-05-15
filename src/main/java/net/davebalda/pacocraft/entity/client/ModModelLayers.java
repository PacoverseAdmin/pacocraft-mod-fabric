package net.davebalda.pacocraft.entity.client;

import net.davebalda.pacocraft.PacoCraft;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer GIANGOLEM =
            new EntityModelLayer(new Identifier(PacoCraft.MOD_ID, "giangolem"), "main");

    public static final EntityModelLayer OBSIDIANGOLEM =
            new EntityModelLayer(new Identifier(PacoCraft.MOD_ID, "obsidiangolem"), "main");

    public static final EntityModelLayer ABOMINEM =
            new EntityModelLayer(new Identifier(PacoCraft.MOD_ID, "abominem"), "main");

}
