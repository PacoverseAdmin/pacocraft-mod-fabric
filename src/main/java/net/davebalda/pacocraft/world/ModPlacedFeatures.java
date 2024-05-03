package net.davebalda.pacocraft.world;

import net.davebalda.pacocraft.PacoCraft;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> ETNITE_ORE_PLACED_KEY = registerKey("etnite_ore_placed");
    public static final RegistryKey<PlacedFeature> PALERMIUM_ORE_PLACED_KEY = registerKey("palermium_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_PALERMIUM_ORE_PLACED_KEY = registerKey("nether_palermium_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ETNITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ETNITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, //Veins per chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(32))));

        register(context, PALERMIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PALERMIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, //Veins per chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(16))));

        register(context, NETHER_PALERMIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_PALERMIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(2, //Veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(128))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(PacoCraft.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
