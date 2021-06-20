package fr.jo.netart.init.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import static java.lang.Math.abs;

public class ArtiBigShovelItem extends ShovelItem {
    public ArtiBigShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
    {
        Vector3d look = entityLiving.getLookVec();
        if (abs(look.x) > abs(look.z))
        {
            BlockPos block_dest = new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1);
            BlockState block_state = worldIn.getBlockState(block_dest);
            if (block_state.getHarvestTool() == ToolType.SHOVEL)
                worldIn.destroyBlock(block_dest, true);

            block_dest = new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1);
            block_state = worldIn.getBlockState(block_dest);
            if (block_state.getHarvestTool() == ToolType.SHOVEL)
                worldIn.destroyBlock(block_dest, true);
        }
        else
        {
            BlockPos block_dest = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ());
            BlockState block_state = worldIn.getBlockState(block_dest);
            if (block_state.getHarvestTool() == ToolType.SHOVEL)
                worldIn.destroyBlock(block_dest, true);

            block_dest = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ());
            block_state = worldIn.getBlockState(block_dest);
            if (block_state.getHarvestTool() == ToolType.SHOVEL)
                worldIn.destroyBlock(block_dest, true);
        }
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }
}