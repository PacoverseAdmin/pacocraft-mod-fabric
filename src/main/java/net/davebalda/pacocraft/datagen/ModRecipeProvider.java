package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    /**
     * Generates the recipes
     * @param exporter
     */
    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ETNITE_BLOCK, 1)
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', ModItems.ETNITE_GEM)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .criterion(hasItem(ModBlocks.ETNITE_BLOCK), conditionsFromItem(ModBlocks.ETNITE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ETNITE_BLOCK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PROTEIN_SHAKE, 1)
                .input(Items.GLASS_BOTTLE)
                .input(Items.GLOWSTONE_DUST)
                .input(Items.GUNPOWDER)
                .input(Items.REDSTONE)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .criterion(hasItem(Items.GLOWSTONE_DUST), conditionsFromItem(Items.GLOWSTONE_DUST))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROTEIN_SHAKE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ETNITE_GEM, 9)
                .input(ModBlocks.ETNITE_BLOCK)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .criterion(hasItem(ModBlocks.ETNITE_BLOCK), conditionsFromItem(ModBlocks.ETNITE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_GEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ETNITE_SWORD, 1)
                .pattern("E")
                .pattern("E")
                .pattern("S")
                .input('E', ModItems.ETNITE_GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETNITE_PICKAXE, 1)
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .input('E', ModItems.ETNITE_GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETNITE_AXE, 1)
                .pattern("EE")
                .pattern("SE")
                .pattern("S ")
                .input('E', ModItems.ETNITE_GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETNITE_SHOVEL, 1)
                .pattern("E")
                .pattern("S")
                .pattern("S")
                .input('E', ModItems.ETNITE_GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ETNITE_HOE, 1)
                .pattern("EE")
                .pattern("S ")
                .pattern("S ")
                .input('E', ModItems.ETNITE_GEM)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_HOE)));
    }
}
