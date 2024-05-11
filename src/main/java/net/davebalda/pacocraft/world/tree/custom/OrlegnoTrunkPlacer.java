package net.davebalda.pacocraft.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.davebalda.pacocraft.world.tree.ModTrunkPlacersType;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class OrlegnoTrunkPlacer extends TrunkPlacer {

    public static final Codec<OrlegnoTrunkPlacer> CODEC = RecordCodecBuilder.create(objectInstance ->
            fillTrunkPlacerFields(objectInstance).apply(objectInstance, OrlegnoTrunkPlacer::new));

    public OrlegnoTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacersType.ORLEGNO_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer,
                                                 Random random, int height, BlockPos startPos, TreeFeatureConfig config) {

        setToDirt(world, replacer, random, startPos.down(), config);
        int height_ = height + random.nextBetween(firstRandomHeight, firstRandomHeight + 2) +
                random.nextBetween(secondRandomHeight - 1, secondRandomHeight + 1);

        for (int i = 0; i < height_; i++){
            getAndSetState(world, replacer, random, startPos.up(i), config);

            if((i % 2 == 0 && i != 0) && random.nextBoolean()){
                if(random.nextFloat() >= 0.75f){
                    for(int j = 1; j <= 2; j++){
                        replacer.accept(startPos.up(i).offset(Direction.NORTH, j), (BlockState) Function.identity()
                                .apply(config.trunkProvider
                                .get(random, startPos.up(i).offset(Direction.NORTH, j))
                                        .with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }
            }

            if(i % 2 == 0 && random.nextBoolean()){
                if(random.nextFloat() >= 0.50f && random.nextFloat() < 0.75f){
                    for(int j = 1; j <= 4; j++){
                        replacer.accept(startPos.up(i).offset(Direction.SOUTH, j), (BlockState) Function.identity()
                                .apply(config.trunkProvider
                                        .get(random, startPos.up(i).offset(Direction.SOUTH, j))
                                        .with(PillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }
            }

            if(i % 2 == 0 && random.nextBoolean()){
                if(random.nextFloat() > 0.50f){
                    for(int j = 1; j <= 4; j++){
                        replacer.accept(startPos.up(i).offset(Direction.EAST, j), (BlockState) Function.identity()
                                .apply(config.trunkProvider
                                        .get(random, startPos.up(i).offset(Direction.EAST, j))
                                        .with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                }
            }

            if(i % 2 == 0 && random.nextBoolean()){
                if(random.nextFloat() > 0.50f){
                    for(int j = 1; j <= 4; j++){
                        replacer.accept(startPos.up(i).offset(Direction.WEST, j), (BlockState) Function.identity()
                                .apply(config.trunkProvider
                                        .get(random, startPos.up(i).offset(Direction.WEST, j))
                                        .with(PillarBlock.AXIS, Direction.Axis.X)));
                    }
                }
            }
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height_), 0, false));
    }
}
