package howl01.spiritores.blocks;

import howl01.spiritores.SpiritOres;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SpiritOre extends net.minecraft.block.Block {
	String unlocalizedName;
	public SpiritOre(int par1, Material par2Material, int blockHarvestLevel) {
		super(par2Material);
		setStepSound(soundTypeStone);
		setCreativeTab(SpiritOres.tabSpiritOres);
		this.setBlockTextureName("spiritoresmod:"+this.unlocalizedName);
		if (blockHarvestLevel != -1) {
			this.setHarvestLevel("pickaxe",blockHarvestLevel);
		}
	}
}
