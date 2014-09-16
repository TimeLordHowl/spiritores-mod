package howl01.spiritores.items;

import howl01.spiritores.SpiritOres;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class SpiritSpade extends ItemSpade {
	public SpiritSpade(int par1, ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
		setCreativeTab(SpiritOres.tabSpiritOres);
		this.setTextureName("spiritoresmod:"+this.getUnlocalizedName().substring(5));
	}
}
