package howl01.spiritores.items;

import howl01.spiritores.SpiritOres;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class SpiritArmor extends ItemArmor {
	String armortype;
	public SpiritArmor(int par1, ArmorMaterial par2EnumArmorMaterial,
			int par3, int par4, String armortype) {
		super(par2EnumArmorMaterial, par3, par4);
		setCreativeTab(SpiritOres.tabSpiritOres);
		this.armortype = armortype;
		this.setTextureName("spiritoresmod:"+this.getUnlocalizedName().substring(5));
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		if (slot==2) {
			return "spiritoresmod:textures/armor/"+this.armortype+"_layer_2.png";
		} else {
			return "spiritoresmod:textures/armor/"+this.armortype+"_layer_1.png";
		}
	}
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack) {

        if (player.getCurrentArmor(4) != null && player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null) {
                ItemStack helmet = player.getCurrentArmor(4);
                ItemStack plate = player.getCurrentArmor(3);
                ItemStack legs = player.getCurrentArmor(2);
                ItemStack boots = player.getCurrentArmor(1); 

                if (helmet.getItem() == SpiritOres.amethystHelmet && plate.getItem() == SpiritOres.amethystChestplate && legs.getItem() == SpiritOres.amethystLeggings && boots.getItem() == SpiritOres.amethystBoots) 
                {
                       player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,1));
                } else if (helmet.getItem() == SpiritOres.charredLeadHelmet && plate.getItem() == SpiritOres.charredLeadChestplate && legs.getItem() == SpiritOres.charredLeadLeggings && boots.getItem() == SpiritOres.charredLeadBoots) {
                	if (player.isPotionActive(Potion.poison.id)) {
                		player.removePotionEffect(Potion.poison.id);
                	}
                } else if (helmet.getItem() == SpiritOres.lilithiteHelmet && plate.getItem() == SpiritOres.lilithiteChestplate && legs.getItem()==SpiritOres.lilithiteLeggings && boots.getItem()==SpiritOres.lilithiteBoots) {
                	player.addPotionEffect(new PotionEffect(Potion.jump.id,1));
                } else if (helmet.getItem() == SpiritOres.enderSpiritHelmet && plate.getItem() == SpiritOres.enderSpiritChestplate && legs.getItem()==SpiritOres.enderSpiritLeggings && boots.getItem()==SpiritOres.enderSpiritBoots) {
                	player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1));
                } else if (helmet.getItem() == SpiritOres.magmaSpiritHelmet && plate.getItem() == SpiritOres.magmaSpiritChestplate && legs.getItem() == SpiritOres.magmaSpiritLeggings && boots.getItem() == SpiritOres.magmaSpiritBoots) {
                	player.addPotionEffect(new PotionEffect(Potion.fireResistance.id,1));
                } else if (helmet.getItem() == SpiritOres.spiritedHelmet && plate.getItem() == SpiritOres.spiritedChestplate && legs.getItem() == SpiritOres.spiritedLeggings && boots.getItem() == SpiritOres.spiritedBoots) {
                	player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id,1));
                } else if (helmet.getItem() == SpiritOres.dimensionForgedHelmet && plate.getItem() == SpiritOres.dimensionForgedChestplate && legs.getItem()==SpiritOres.dimensionForgedLeggings && boots.getItem() == SpiritOres.dimensionForgedBoots) {
                	player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1));
                	player.addPotionEffect(new PotionEffect(Potion.fireResistance.id,1));
                	player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id,1));
                } else if (helmet.getItem()== SpiritOres.iriditeHelmet && plate.getItem() == SpiritOres.iriditeChestplate && legs.getItem() == SpiritOres.iriditeLeggings && boots.getItem() == SpiritOres.iriditeBoots) {
                	player.addPotionEffect(new PotionEffect(Potion.nightVision.id,1));
                } else if (helmet.getItem()==SpiritOres.teleniumHelmet && plate.getItem()==SpiritOres.teleniumChestplate && legs.getItem()==SpiritOres.teleniumLeggings && boots.getItem()==SpiritOres.teleniumBoots) {
                	player.addPotionEffect(new PotionEffect(5,1));//strength
                } 
        }
}
}
