package fr.jo.netart.init.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

public class ArtiFSwordItem extends SwordItem {
    public ArtiFSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn)
    {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand)
    {
        if (target instanceof TameableEntity)
        {
            stack.setDamage(stack.getDamage()+5);
            if (!((TameableEntity) target).isTamed())
            {
                ((TameableEntity) target).setTamed(true);
                ((TameableEntity) target).setOwnerId(playerIn.getUniqueID());
            }
        }
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}