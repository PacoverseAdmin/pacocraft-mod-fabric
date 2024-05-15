package net.davebalda.pacocraft.world.biome.surface;

import net.davebalda.pacocraft.world.biome.ModBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final MaterialRules.MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final MaterialRules.MaterialRule STONE = makeStateRule(Blocks.STONE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface =
                MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(

                        MaterialRules.condition(
                                MaterialRules.verticalGradient("bedrock_floor", YOffset.aboveBottom(5),YOffset.aboveBottom(0)), BEDROCK
                        ),

                        MaterialRules.condition(MaterialRules.biome(ModBiomes.GORZANO),
                                MaterialRules.sequence(
                                        MaterialRules.condition(
                                                MaterialRules.not(MaterialRules.aboveY(YOffset.aboveBottom(64),0)),
                                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, DEEPSLATE)
                                        ),
                                        MaterialRules.condition(
                                                MaterialRules.not(MaterialRules.aboveY(YOffset.aboveBottom(94),0)),
                                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, STONE)
                                        )
                                )
                        ),

                        MaterialRules.condition(
                                MaterialRules.verticalGradient("deepslate_floor", YOffset.fixed(8),YOffset.fixed(0)), DEEPSLATE
                        ),

                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)

                )
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
