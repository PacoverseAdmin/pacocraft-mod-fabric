package net.davebalda.pacocraft.util;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

public class EnchantmentHandler {

    public static int getLootingLevel(DamageSource damageSource){
        if(damageSource.getAttacker() instanceof LivingEntity){
            LivingEntity attacker = (LivingEntity) damageSource.getAttacker();
            return EnchantmentHelper.getLevel(Enchantments.LOOTING, attacker.getMainHandStack());
        }

        return 0;
    }

}
