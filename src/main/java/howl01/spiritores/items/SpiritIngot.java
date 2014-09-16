package howl01.spiritores.items;

import howl01.spiritores.SpiritOres;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SpiritIngot extends Item {

	public SpiritIngot(int par1) {
		super();
		setCreativeTab(SpiritOres.tabSpiritOres);
		setMaxStackSize(64);
		this.setTextureName("spiritoresmod:"+this.getUnlocalizedName().substring(5));
	}

}
