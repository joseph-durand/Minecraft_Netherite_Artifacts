package fr.jo.netart.init.tools;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ArtiTAxeItem extends AxeItem
{

    public ArtiTAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {

        RayTraceResult result = playerIn.pick(100f, 1, true);
        double x = result.getHitVec().getX();
        double y = result.getHitVec().getY();
        double z = result.getHitVec().getZ();
        LightningBoltEntity eclair = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, worldIn);
        eclair.setPosition(x, y, z);
        worldIn.addEntity(eclair);
        return super.onItemRightClick(worldIn, playerIn, handIn);

    }
}