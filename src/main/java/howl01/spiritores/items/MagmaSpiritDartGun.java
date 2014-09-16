package howl01.spiritores.items;

import howl01.spiritores.SpiritOres;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;


public class MagmaSpiritDartGun extends Item {
	String uln;
	int speed;

	public MagmaSpiritDartGun(int par1, int speed, int dmg, String uln) {
		super();
		setCreativeTab(SpiritOres.tabSpiritOres);
		setFull3D();
		this.uln = uln;
		this.speed = speed;
		setMaxDamage(dmg);
		setUnlocalizedName(uln);
		this.setTextureName("spiritoresmod:"+this.uln);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		ArrowNockEvent nevent = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
        MinecraftForge.EVENT_BUS.post(nevent);
		
		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, speed);
        MinecraftForge.EVENT_BUS.post(event);

        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem((Item) Item.itemRegistry.getObject("arrow")))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            if (!par3EntityPlayer.capabilities.isCreativeMode) {
            	par3EntityPlayer.inventory.consumeInventoryItem((Item) Item.itemRegistry.getObject("arrow"));
            }
            float f = (float)speed / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, f * 2.0F);
            entityarrow.setFire(100);
            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            par1ItemStack.damageItem(1, par3EntityPlayer);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            
            if (par3EntityPlayer.capabilities.isCreativeMode) {
            	entityarrow.canBePickedUp=2;
            }
            
            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(entityarrow);
            }

        }

        return par1ItemStack;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 1000;
    }
	
	
}
