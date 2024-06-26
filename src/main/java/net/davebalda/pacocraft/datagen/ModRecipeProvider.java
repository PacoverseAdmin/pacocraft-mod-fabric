package net.davebalda.pacocraft.datagen;

import net.davebalda.pacocraft.block.ModBlocks;
import net.davebalda.pacocraft.item.ModItems;
import net.davebalda.pacocraft.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> PALERMIUM_SMELTABLES = List.of(ModItems.RAW_PALERMIUM);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    /**
     * Generates the recipes
     * @param exporter
     */
    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, PALERMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_PALERMIUM,
                0.7f, 200, "palermium");

        offerBlasting(exporter, PALERMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_PALERMIUM,
                0.7f, 100, "palermium");

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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORLEGNO_PLANKS, 4)
                .input(ModTags.Items.ORLEGNO_LOGS)
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_PLANKS)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORLEGNO_BUTTON, 1)
                .input(ModBlocks.ORLEGNO_PLANKS)
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_BUTTON)));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORLEGNO_SLAB, Ingredient.ofItems(ModBlocks.ORLEGNO_PLANKS))
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_SLAB)));

        createStairsRecipe(ModBlocks.ORLEGNO_STAIRS, Ingredient.ofItems(ModBlocks.ORLEGNO_PLANKS))
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_STAIRS)));

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORLEGNO_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.ORLEGNO_PLANKS))
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_PRESSURE_PLATE)));

        createFenceRecipe(ModBlocks.ORLEGNO_FENCE, Ingredient.ofItems(ModBlocks.ORLEGNO_PLANKS))
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_FENCE)));

        createFenceGateRecipe(ModBlocks.ORLEGNO_FENCE_GATE, Ingredient.ofItems(ModBlocks.ORLEGNO_PLANKS))
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_FENCE_GATE)));

        createDoorRecipe(ModBlocks.ORLEGNO_DOOR, Ingredient.ofItems(ModBlocks.ORLEGNO_PLANKS))
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_DOOR)));

        createTrapdoorRecipe(ModBlocks.ORLEGNO_TRAPDOOR, Ingredient.ofItems(ModBlocks.ORLEGNO_PLANKS))
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_TRAPDOOR)));

        createSignRecipe(ModBlocks.ORLEGNO_SIGN, Ingredient.ofItems(ModBlocks.ORLEGNO_PLANKS))
                .criterion(hasItem(ModBlocks.ORLEGNO_PLANKS), conditionsFromItem(ModBlocks.ORLEGNO_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ORLEGNO_SIGN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModItems.ORLEGNO_HANGING_SIGN, 6)
                .pattern("C C")
                .pattern("LLL")
                .pattern("LLL")
                .input('C', Items.CHAIN)
                .input('L', ModBlocks.STRIPPED_ORLEGNO_LOG)
                .criterion(hasItem(ModBlocks.STRIPPED_ORLEGNO_LOG), conditionsFromItem(ModBlocks.STRIPPED_ORLEGNO_LOG))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ORLEGNO_HANGING_SIGN)));

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ETNITE_HELMET, 1)
                .pattern("EEE")
                .pattern("E E")
                .input('E', ModItems.ETNITE_GEM)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ETNITE_CHESTPLATE, 1)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', ModItems.ETNITE_GEM)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ETNITE_LEGGINGS, 1)
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .input('E', ModItems.ETNITE_GEM)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ETNITE_BOOTS, 1)
                .pattern("E E")
                .pattern("E E")
                .input('E', ModItems.ETNITE_GEM)
                .criterion(hasItem(ModItems.ETNITE_GEM), conditionsFromItem(ModItems.ETNITE_GEM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ETNITE_BOOTS)));
    }
}
