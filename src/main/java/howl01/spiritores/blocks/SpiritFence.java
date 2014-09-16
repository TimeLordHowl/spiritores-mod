package howl01.spiritores.blocks;

import howl01.spiritores.SpiritOres;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class SpiritFence extends BlockFence {
	String texturename;
	public SpiritFence(int par1, Material par3Material,String texturename,int harvestLevel) {
		super("wood", par3Material);
		setCreativeTab(SpiritOres.tabSpiritOres);
		this.setBlockTextureName("spiritoresmod:"+texturename+"Block");
		this.setHarvestLevel("pickaxe",harvestLevel);
	}
	public boolean canConnectFenceTo(IBlockAccess p_149826_1_, int p_149826_2_, int p_149826_3_, int p_149826_4_)
    {
        Block block = p_149826_1_.getBlock(p_149826_2_, p_149826_3_, p_149826_4_);
        return block != this && block != Blocks.fence_gate && !(block instanceof SpiritFenceGate) && !(block instanceof SpiritFence) && !(block instanceof BlockFence)  ? (block.isOpaqueCube() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
    }
}
