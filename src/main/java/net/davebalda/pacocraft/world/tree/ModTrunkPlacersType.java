package net.davebalda.pacocraft.world.tree;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.mixin.TrunkPlacerTypeInvoker;
import net.davebalda.pacocraft.world.tree.custom.OrlegnoTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacersType {
    public static final TrunkPlacerType<?> ORLEGNO_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister(
            "orlegno_trunk_placer", OrlegnoTrunkPlacer.CODEC);



    public static void registerTrunkPlacers(){
        PacoCraft.LOGGER.info("Registering Trunk Placers for: " + PacoCraft.MOD_ID);
    }
}
