package net.davebalda.pacocraft.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen(){
        //KEEP THEM IN ORDER! (look in GenerationStep.java)
        ModOreGeneration.generateOres();
        //ModTreeGeneration.generateTrees();
    }
}
