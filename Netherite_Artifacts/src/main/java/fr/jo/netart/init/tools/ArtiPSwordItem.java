package fr.jo.netart.init.tools;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ArtiPSwordItem extends SwordItem {
    public ArtiPSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {

        if (target instanceof MonsterEntity && !(target instanceof CreeperEntity))
            target.addPotionEffect(new EffectInstance(Effects.WITHER, 150));
        else
            target.addPotionEffect(new EffectInstance(Effects.POISON, 100));
        return super.hitEntity(stack, target, attacker);

    }
}