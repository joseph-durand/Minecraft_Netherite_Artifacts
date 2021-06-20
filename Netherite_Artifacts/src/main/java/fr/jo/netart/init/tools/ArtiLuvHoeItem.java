package fr.jo.netart.init.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

public class ArtiLuvHoeItem extends HoeItem {

    public ArtiLuvHoeItem(IItemTier itemTier, int attackDamage, float attackSpeed, Properties properties)
    {
        super(itemTier, attackDamage, attackSpeed, properties);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand)
    {
        if (target instanceof AnimalEntity)
        {
            stack.setDamage(stack.getDamage()+5);
            if (!((AnimalEntity) target).isInLove())
            {
                ((AnimalEntity) target).setInLove(playerIn);
            }
        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}