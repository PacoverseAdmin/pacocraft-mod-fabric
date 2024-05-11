package net.davebalda.pacocraft.world.biome;

import net.davebalda.pacocraft.PacoCraft;
import net.davebalda.pacocraft.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(PacoCraft.MOD_ID, "overworld"), 4)); //How often the biomes appears
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, PacoCraft.MOD_ID, ModMaterialRules.makeRules());
    }
}
