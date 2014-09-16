package howl01.spiritores.blocks;

import net.minecraft.block.BlockFenceGate;

public class SpiritFenceGate extends BlockFenceGate {
	public SpiritFenceGate(int harvestLevel) {
		super();
		this.setHarvestLevel("pickaxe", harvestLevel);
	}
}
