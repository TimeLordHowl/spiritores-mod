package howl01.spiritores;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class SpiritOresGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
		if (world.provider.isHellWorld == true)
		{
			  WorldGenMinable worldgenminable = new WorldGenMinable(SpiritOres.charredLeadOre, 7, (Block)Block.blockRegistry.getObject("netherrack"));

		        int posX;
		        int posY;
		        int posZ;
		        int k = chunkX * 16;
		        int l = chunkZ * 16;
		        int x;

		       
		        for (x = 0; x < 30; ++x)
		        {
		            posX = k + random.nextInt(16);
		            posY = random.nextInt(108) + 10;
		            posZ = l + random.nextInt(16);
		            worldgenminable.generate(world, random, posX, posY, posZ);
		        
		        }
		        
		        WorldGenMinable amethystgen = new WorldGenMinable(SpiritOres.amethystOre,7, (Block)Block.blockRegistry.getObject("netherrack"));
		        for(int i = 0; i < 10; i++) {
		        	posX = k + random.nextInt(16);
		        	posY = random.nextInt(108) + 10;
		        	posZ = l + random.nextInt(16);
		        	amethystgen.generate(world, random, posX, posY, posZ);	
		        }
		        
		        WorldGenMinable magnetitegen = new WorldGenMinable(SpiritOres.magnetiteOre,7,(Block)Block.blockRegistry.getObject("netherrack"));
		        for(int i = 0; i < 20; i++) {
		        	posX = k + random.nextInt(16);
		        	posY = random.nextInt(108) + 10;
		        	posZ = l + random.nextInt(16);
		        	magnetitegen.generate(world, random, posX, posY, posZ);
		        }
		        
		        WorldGenMinable magmaspiritgen = new WorldGenMinable(SpiritOres.magmaSpiritOre,5, (Block)Block.blockRegistry.getObject("netherrack"));
		        for (int i = 0; i < 5; i++) {
		        	posX = k + random.nextInt(16);
		        	posY = random.nextInt(108) + 10;
		        	posZ = l + random.nextInt(16);
		        	magmaspiritgen.generate(world, random, posX, posY, posZ);
		        }
		}
		
		if (world.provider.getDimensionName()=="The End") {
			int posX;
	        int posY;
	        int posZ;
	        int k = chunkX * 16;
	        int l = chunkZ * 16;
	        
			WorldGenMinable iriditegen = new WorldGenMinable(SpiritOres.iriditeOre,7,(Block)Block.blockRegistry.getObject("end_stone"));
			for (int i = 0; i < 5; i++) {
				posX = k + random.nextInt(16);
				posY = random.nextInt(64) + 10;
				posZ = l + random.nextInt(16);
				iriditegen.generate(world, random, posX, posY, posZ);
			}
			
			WorldGenMinable lilithitegen = new WorldGenMinable(SpiritOres.lilithiteOre,7,(Block)Block.blockRegistry.getObject("end_stone"));
			for (int i = 0; i < 5; i++) {
				posX = k + random.nextInt(16);
				posY = random.nextInt(64) + 10;
				posZ = l + random.nextInt(16);
				lilithitegen.generate(world,random,posX,posY,posZ);
			}
			
			WorldGenMinable enderspiritgen = new WorldGenMinable(SpiritOres.enderspiritOre, 5, (Block)Block.blockRegistry.getObject("end_stone"));
			for (int i = 0; i < 3; i++) {
				posX=k + random.nextInt(16);
				posY = random.nextInt(64) + 10;
				posZ = l + random.nextInt(16);
				enderspiritgen.generate(world, random, posX, posY, posZ);
			}
			
			WorldGenMinable teleniumgen = new WorldGenMinable(SpiritOres.teleniumOre,7,(Block)Block.blockRegistry.getObject("end_stone"));
			for (int i = 0; i < 4; i++) {
				posX = k + random.nextInt(16);
				posY = random.nextInt(64) + 10;
				posZ = l + random.nextInt(16);
				teleniumgen.generate(world, random, posX, posY, posZ);
			}
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {
		
	}

	private void generateSurface(World world, Random random, int i, int j) {
		for(int k = 0; k < 20; k++) {
			int aluminumOreXCoord = i + random.nextInt(16);
			int aluminumOreYCoord = random.nextInt(64);
			int aluminumOreZCoord = j + random.nextInt(16);
			(new WorldGenMinable(SpiritOres.aluminumOre, 6)).generate(world, random, aluminumOreXCoord, aluminumOreYCoord, aluminumOreZCoord);
		}
		
		for(int k = 0; k < 20; k++) {
			int copperOreXCoord = i + random.nextInt(16);
			int copperOreYCoord = random.nextInt(64);
			int copperOreZCoord = j + random.nextInt(16);
			(new WorldGenMinable(SpiritOres.copperOre, 6)).generate(world, random, copperOreXCoord, copperOreYCoord, copperOreZCoord);
		}
		
		for(int k = 0; k < 20; k++) {
			int steelOreXCoord = i + random.nextInt(16);
			int steelOreYCoord = random.nextInt(42);
			int steelOreZCoord = j + random.nextInt(16);
			(new WorldGenMinable(SpiritOres.steelOre, 5)).generate(world, random, steelOreXCoord, steelOreYCoord, steelOreZCoord);
		}
		
		for(int k = 0; k < 20; k++) {
			int spiritOreXCoord = i + random.nextInt(16);
			int spiritOreYCoord = random.nextInt(20);
			int spiritOreZCoord = j + random.nextInt(16);
			(new WorldGenMinable(SpiritOres.spiritOre, 3)).generate(world, random, spiritOreXCoord, spiritOreYCoord, spiritOreZCoord);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {
		WorldGenMinable worldgenminable = new WorldGenMinable(SpiritOres.charredLeadOre, 7, (Block)Block.blockRegistry.getObject("netherrack"));

        int posX;
        int posY;
        int posZ;
        int x;
        for (x = 0; x < 7; ++x)
        {
            posX = i + random.nextInt(16);
            posY = random.nextInt(108) + 10;
            posZ = j + random.nextInt(16);
            worldgenminable.generate(world, random, posX, posY, posZ);
        }
	}
}


