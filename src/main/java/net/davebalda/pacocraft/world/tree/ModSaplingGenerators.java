package net.davebalda.pacocraft.world.tree;

import net.davebalda.pacocraft.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator ORLEGNO =
            new SaplingGenerator("orlegno", 0f, Optional.empty(),
                    Optional.empty(), Optional.of(ModConfiguredFeatures.ORLEGNO_KEY),
                    Optional.empty(), Optional.empty(), Optional.empty());
}
