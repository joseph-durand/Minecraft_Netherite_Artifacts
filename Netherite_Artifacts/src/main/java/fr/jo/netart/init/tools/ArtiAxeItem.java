package fr.jo.netart.init.tools;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LightningBoltRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.NBTTextComponent;
import net.minecraft.world.World;
import org.lwjgl.system.CallbackI;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;

public class ArtiAxeItem extends AxeItem
{
    public ArtiAxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder)
    {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    void break_that_block(int x, int y, int z, World worldIn, List<String> list)
    {
        BlockPos block_dest = new BlockPos(x, y, z);
        BlockState block_state = worldIn.getBlockState(block_dest);
        if (list.contains(block_state.getBlock().toString()))
        {
            worldIn.destroyBlock(block_dest, true);
            break_that_block(x+1, y, z, worldIn, list);
            break_that_block(x-1, y, z, worldIn, list);
            break_that_block(x, y+1, z, worldIn, list);
            break_that_block(x, y-1, z, worldIn, list);
            break_that_block(x, y, z+1, worldIn, list);
            break_that_block(x, y, z-1, worldIn, list);
        }
    }



    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
    {

        final String[] logs = {"Block{minecraft:dark_oak_log}", "Block{minecraft:oak_log}", "Block{minecraft" +
                ":spruce_log}", "Block{minecraft:birch_log}", "Block{minecraft:jungle_log}", "Block{minecraft" +
                ":acacia_log}", "Block{minecraft:stripped_oak_log}", "Block{minecraft:stripped_spruce_log}", "Block{minecraft" +
                ":stripped_birch_log}",
                "Block{minecraft:stripped_jungle_log}", "Block{minecraft:stripped_acacia_log}", "Block{minecraft" +
                ":stripped_dark_oak_log}"};
        List<String> list = Arrays.asList(logs);
        break_that_block(pos.getX(), pos.getY(), pos.getZ(), worldIn, list);
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }




}