package net.davebalda.pacocraft.painting;

import net.davebalda.pacocraft.PacoCraft;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPaintings {
    public static final PaintingVariant TORTELLI_PANNA = registerPainting("tortelli_panna",
            new PaintingVariant(32, 32));


    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(PacoCraft.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        PacoCraft.LOGGER.info("Registering Paintings for: " + PacoCraft.MOD_ID);
    }
}
