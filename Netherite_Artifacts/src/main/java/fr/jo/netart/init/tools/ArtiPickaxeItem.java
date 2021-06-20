package fr.jo.netart.init.tools;

import com.sun.jna.platform.win32.Kernel32;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.ModelBakery;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class ArtiPickaxeItem extends PickaxeItem
{
    public ArtiPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
    {

        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack stack = playerIn.getHeldItem(handIn);
        stack.setDamage(stack.getDamage()+3);
        CompoundNBT nbt;
        if (stack.hasTag())
        {
            nbt = stack.getTag();
        }
        else
        {
            nbt = new CompoundNBT();
        }
        BlockPos block_dest;
        BlockState block_state;
        final String[] ores = {"Block{minecraft:redstone_ore}", "Block{minecraft:lapis_ore}",  "Block{minecraft" +
                ":emerald_ore}", "Block{minecraft:diamond_ore}", "Block{minecraft:gold_ore}", "Block{minecraft" +
                ":iron_ore}"};
        List<String> list = Arrays.asList(ores);
        String closest = "None";
        outer:
        for (int i = 1; i < 10; i++)
        {
            for (int j = -(i); j < i; j++)
            {
                for (int k = -(i); k < i; k++)
                {

                    block_dest = new BlockPos(playerIn.getPosX() - i, playerIn.getPosY() + j, playerIn.getPosZ() + k);
                    block_state = worldIn.getBlockState(block_dest);
                    if (list.contains(block_state.getBlock().toString()))
                    {
                        closest = block_state.getBlock().toString();
                        break outer;
                    }


                }
                for (int k = -(i); k < i; k++)
                {

                    block_dest = new BlockPos(playerIn.getPosX() + i, playerIn.getPosY() + j, playerIn.getPosZ() + k);
                    block_state = worldIn.getBlockState(block_dest);
                    if (list.contains(block_state.getBlock().toString()))
                    {
                        closest = block_state.getBlock().toString();
                        break outer;
                    }
                }
                for (int k = -(i); k < i; k++)
                {

                    block_dest = new BlockPos(playerIn.getPosX() + j, playerIn.getPosY() + i, playerIn.getPosZ() + k);
                    block_state = worldIn.getBlockState(block_dest);
                    if (list.contains(block_state.getBlock().toString()))
                    {
                        closest = block_state.getBlock().toString();
                        break outer;
                    }
                }
                for (int k = -(i); k < i; k++)
                {

                    block_dest = new BlockPos(playerIn.getPosX() + j, playerIn.getPosY() - i, playerIn.getPosZ() + k);
                    block_state = worldIn.getBlockState(block_dest);
                    if (list.contains(block_state.getBlock().toString()))
                    {
                        closest = block_state.getBlock().toString();
                        break outer;
                    }
                }
                for (int k = -(i); k < i; k++)
                {
                    block_dest = new BlockPos(playerIn.getPosX() + k, playerIn.getPosY() + j, playerIn.getPosZ() + i);
                    block_state = worldIn.getBlockState(block_dest);
                    if (list.contains(block_state.getBlock().toString()))
                    {
                        closest = block_state.getBlock().toString();
                        break outer;
                    }
                }
                for (int k = -(i); k < i; k++)
                {
                    block_dest = new BlockPos(playerIn.getPosX() + k, playerIn.getPosY() + j, playerIn.getPosZ() - i);
                    block_state = worldIn.getBlockState(block_dest);
                    if (list.contains(block_state.getBlock().toString()))
                    {
                        closest = block_state.getBlock().toString();
                        break outer;
                    }
                }
            }
        }
        int val = 1;
        for (int i = 0; i < 6; i++)
        {
            if (closest.equals(list.get(i)))
            {
                val += 1 + i;
            }
        }
        nbt.putInt("CustomModelData",  val);
        stack.setTag(nbt);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}