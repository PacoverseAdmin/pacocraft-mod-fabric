package net.davebalda.pacocraft.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent PROTEIN_SHAKE = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 400), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 400), 1f)
            .hunger(4).saturationModifier(0.3f).alwaysEdible().build();

    public static final FoodComponent CHECHEN_ARTICHOKE = new FoodComponent.Builder()
            .hunger(2).saturationModifier(0.6f).build();

}
