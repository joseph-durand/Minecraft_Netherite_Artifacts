package fr.jo.netart.init;

import fr.jo.netart.NETART;
import fr.jo.netart.init.tools.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NETART.MODID);

    public static final RegistryObject<Item> ARTI_AXE = ITEMS.register("timber",
            () -> new ArtiAxeItem(ItemTier.NETHERITE, 5, -3f,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ARTI_PICKAXE = ITEMS.register("ore_seaker",
            () -> new ArtiPickaxeItem(ItemTier.NETHERITE, 1, -2.8f,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ARTI_PICKAXE_MELT = ITEMS.register("melter",
            () -> new ArtiMelterItem(ItemTier.NETHERITE, 1, -2.8f,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ARTI_POISON_SWORD = ITEMS.register("poison_sword",
            () -> new ArtiPSwordItem(ItemTier.NETHERITE, 3, -2.4F,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> ARTI_FRIEND_SWORD = ITEMS.register("friend_sword",
            () -> new ArtiFSwordItem(ItemTier.NETHERITE, 3, -2.4F,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> ARTI_LUV_HOE = ITEMS.register("luv_hoe",
            () -> new ArtiLuvHoeItem(ItemTier.NETHERITE, -4, 0,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ARTI_BIG_SHOVEL = ITEMS.register("big_shovel",
            () -> new ArtiBigShovelItem(ItemTier.NETHERITE, 1.5f, -3f,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> ARTI_THUNDER_AXE = ITEMS.register("thunder_axe",
            () -> new ArtiTAxeItem(ItemTier.NETHERITE, 5f, -3f,
                    new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));

    public static final RegistryObject<Item> POISON_HEART = ITEMS.register("poison_heart",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> PINK_HEART = ITEMS.register("pink_heart",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> ORB_SEAKER = ITEMS.register("orb_seaker",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));
    public static final RegistryObject<Item> BLAZE_HEART = ITEMS.register("blaze_heart",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)));





}