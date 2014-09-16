package howl01.spiritores.items;

import howl01.spiritores.SpiritOres;

import java.util.Random;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class SpiritSword extends ItemSword {

	public SpiritSword(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		setCreativeTab(SpiritOres.tabSpiritOres);
		this.setTextureName("spiritoresmod:"+this.getUnlocalizedName().substring(5));
	}
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        if (this.getUnlocalizedName() == SpiritOres.amethystSword.getUnlocalizedName()) {
        	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,1000));
        } else if (this.getUnlocalizedName() == SpiritOres.charredLeadSword.getUnlocalizedName()) {
        	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id,1000));
        } else if (this.getUnlocalizedName() == SpiritOres.lilithiteSword.getUnlocalizedName()) {
        	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.confusion.id,1000));
        } else if (this.getUnlocalizedName() == SpiritOres.teleniumSword.getUnlocalizedName()) {
        	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.weakness.id, 1000));
        } else if (this.getUnlocalizedName() == SpiritOres.magmaSpiritSword.getUnlocalizedName()) {
        	par2EntityLivingBase.setFire(5);
        } else if (this.getUnlocalizedName() == SpiritOres.dimensionForgedSword.getUnlocalizedName()) {
        	par2EntityLivingBase.setFire(5);
        	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 1000));
        } else if (this.getUnlocalizedName() == SpiritOres.iriditeSword.getUnlocalizedName()) {
        	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.blindness.id,1000));
        } else if (this.getUnlocalizedName() == SpiritOres.enderspiritSword.getUnlocalizedName()) {
        	par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 1000));
        }
        return true;
    }

}
