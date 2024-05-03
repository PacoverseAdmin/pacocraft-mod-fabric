package net.davebalda.pacocraft.world;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ETNITE_ORE_KEY = registerKey("etnite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALERMIUM_ORE_KEY = registerKey("palermium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_PALERMIUM_ORE_KEY = registerKey("nether_palermium_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        //---- <LISTS> ----//
        List<OreFeatureConfig.Target> EtniteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ETNITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_ETNITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldPalermiumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PALERMIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_PALERMIUM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherPalermiumOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_PALERMIUM_ORE.getDefaultState()));

        register(context, ETNITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(EtniteOres, 9));
        register(context, PALERMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPalermiumOres, 3));
        register(context, NETHER_PALERMIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherPalermiumOres, 4));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(PacoCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
