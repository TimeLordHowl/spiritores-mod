package howl01.spiritores;

import howl01.spiritores.blocks.BlockSpiritOre;
import howl01.spiritores.blocks.SpiritFence;
import howl01.spiritores.blocks.SpiritFenceGate;
import howl01.spiritores.blocks.SpiritOre;
import howl01.spiritores.items.DimensionForgedDartGun;
import howl01.spiritores.items.MagmaSpiritDartGun;
import howl01.spiritores.items.SpiritArmor;
import howl01.spiritores.items.SpiritAxe;
import howl01.spiritores.items.SpiritDartGun;
import howl01.spiritores.items.SpiritHoes;
import howl01.spiritores.items.SpiritIngot;
import howl01.spiritores.items.SpiritPickaxe;
import howl01.spiritores.items.SpiritSpade;
import howl01.spiritores.items.SpiritSword;
import howl01.spiritores.items.SpiritedSpiritDartGun;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid="SpiritOresMod", name="TimeLordHowl's SpiritOres",version="2.0.1 beta") //mod id, version //you have to have it on your client to play on servers with this mod
public class SpiritOres {
	@Instance(value="SpiritOresMod") // Has to match modid above
	public static SpiritOres instance; //instance of the mod
	
	@SidedProxy(clientSide="howl01.spiritores.client.ClientProxy",serverSide="howl01.spiritores.CommonProxy")
	public static CommonProxy proxy; //proxy - rendering stuff
	
	public static CreativeTabs tabSpiritOres = new CreativeTabs("tabSpiritOres") { //creative tab
		@Override
		public Item getTabIconItem() {
			return dimensionForgedSword;
		}
	};
	
	//booleans
	static boolean enableFences;
	static boolean enableFenceGates;
	static boolean enableBlowguns;
	
	int aluminumIngotId;
	int copperIngotId;
	int steelIngotId;
	int spiritCrystalId;
	int spiritedIngotId;
	int charredLeadChunkId;
	int amethystGemId;
	int magnetiteChunkId;
	int magmaSpiritCrystalId;
	int magmaSpiritedIngotId;
	int iriditeShardId;
	int lilithiteGemId;
	int teleniumIngotId;
	int enderSpiritCrystalId;
	int enderSpiritedIngotId;
	int dimensionForgedIngotId;
	
	int aluminumPickaxeId;
	int copperPickaxeId;
	int steelPickaxeId;
	int spiritedPickaxeId;
	int charredLeadPickaxeId;
	int amethystPickaxeId;
	int magnetitePickaxeId;
	int magmaSpiritedPickaxeId;
	int iriditePickaxeId;
	int lilithitePickaxeId;
	int teleniumPickaxeId;
	int enderSpiritPickaxeId;
	int dimensionForgedPickaxeId;
	
	int aluminumAxeId;
	int copperAxeId;
	int steelAxeId;
	int spiritedAxeId;
	int charredLeadAxeId;
	int amethystAxeId;
	int magnetiteAxeId;
	int magmaSpiritedAxeId;
	int iriditeAxeId;
	int lilithiteAxeId;
	int teleniumAxeId;
	int enderSpiritAxeId;
	int dimensionForgedAxeId;
	
	int aluminumShovelId;
	int copperShovelId;
	int steelShovelId;
	int spiritedShovelId;
	int charredLeadShovelId;
	int amethystShovelId;
	int magnetiteShovelId;
	int magmaSpiritedShovelId;
	int iriditeShovelId;
	int lilithiteShovelId;
	int teleniumShovelId;
	int enderSpiritShovelId;
	int dimensionForgedShovelId;
	
	int aluminumHoeId;
	int copperHoeId;
	int steelHoeId;
	int spiritedHoeId;
	int charredLeadHoeId;
	int amethystHoeId;
	int magnetiteHoeId;
	int magmaSpiritedHoeId;
	int iriditeHoeId;
	int lilithiteHoeId;
	int teleniumHoeId;
	int enderSpiritedHoeId;
	int dimensionForgedHoeId;
	
	int aluminumSwordId;
	int copperSwordId;
	int steelSwordId;
	int spiritedSwordId;
	int charredLeadSwordId;
	int amethystSwordId;
	int magnetiteSwordId;
	int magmaSpiritedSwordId;
	int iriditeSwordId;
	int lilithiteSwordId;
	int teleniumSwordId;
	int enderSpiritedSwordId;
	int dimensionForgedSwordId;
	
	int basicDartGunId;
	int aluminumDartGunId;
	int spiritedDartGunId;
	int amethystDartGunId;
	int magmaSpiritedDartGunId;
	int teleniumDartGunId;
	int enderSpiritedDartGunId;
	int dimensionForgedDartGunId;
	
	int aluminumHelmetId;
	int aluminumChestplateId;
	int aluminumLeggingsId;
	int aluminumBootsId;
	
	int copperHelmetId;
	int copperChestplateId;
	int copperLeggingsId;
	int copperBootsId;
	
	int steelHelmetId;
	int steelChestplateId;
	int steelLeggingsId;
	int steelBootsId;
	
	int spiritedHelmetId;
	int spiritedChestplateId;
	int spiritedLeggingsId;
	int spiritedBootsId;
	
	int charredLeadHelmetId;
	int charredLeadChestplateId;
	int charredLeadLeggingsId;
	int charredLeadBootsId;
	
	int amethystHelmetId;
	int amethystChestplateId;
	int amethystLeggingsId;
	int amethystBootsId;
	
	int magnetiteHelmetId;
	int magnetiteChestplateId;
	int magnetiteLeggingsId;
	int magnetiteBootsId;
	
	int magmaSpiritedHelmetId;
	int magmaSpiritedChestplateId;
	int magmaSpiritedLeggingsId;
	int magmaSpiritedBootsId;
	
	int iriditeHelmetId;
	int iriditeChestplateId;
	int iriditeLeggingsId;
	int iriditeBootsId;
	
	int lilithiteHelmetId;
	int lilithiteChestplateId;
	int lilithiteLeggingsId;
	int lilithiteBootsId;
	
	int enderSpiritedHelmetId;
	int enderSpiritedChestplateId;
	int enderSpiritedLeggingsId;
	int enderSpiritedBootsId;
	
	int teleniumHelmetId;
	int teleniumChestplateId;
	int teleniumLeggingsId;
	int teleniumBootsId;
	
	int dimensionForgedHelmetId;
	int dimensionForgedChestplateId;
	int dimensionForgedLeggingsId;
	int dimensionForgedBootsId;
	
	int aluminumOreId;
	int copperOreId;
	int steelOreId;
	int spiritOreId;
	int charredLeadOreId;
	int amethystOreId;
	int magnetiteOreId;
	int magmaSpiritOreId;
	int iriditeOreId;
	int lilithiteOreId;
	int teleniumOreId;
	int enderSpiritOreId;
	
	int aluminumBlockId;
	int copperBlockId;
	int steelBlockId;
	int spiritStoneId;
	int spiritedBlockId;
	int charredLeadBlockId;
	int amethystBlockId;
	int magnetiteBlockId;
	int magmaSpiritedBlockId;
	int iriditeBlockId;
	int lilithiteBlockId;
	int teleniumBlockId;
	int enderSpiritedBlockId;
	int dimensionForgedBlockId;
	
	int aluminumFenceId;
	int copperFenceId;
	int steelFenceId;
	int spiritedFenceId;
	int charredLeadFenceId;
	int amethystFenceId;
	int magnetiteFenceId;
	int magmaSpiritedFenceId;
	int iriditeFenceId;
	int lilithiteFenceId;
	int teleniumFenceId;
	int enderSpiritedFenceId;
	int dimensionForgedFenceId;
	
	int aluminumFenceGateId;
	int copperFenceGateId;
	int steelFenceGateId;
	int spiritedFenceGateId;
	int charredLeadFenceGateId;
	int amethystFenceGateId;
	int magnetiteFenceGateId;
	int magmaSpiritedFenceGateId;
	int iriditeFenceGateId;
	int lilithiteFenceGateId;
	int teleniumFenceGateId;
	int enderSpiritedFenceGateId;
	int dimensionForgedFenceGateId;

	//ToolMaterials
	static ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", 2, 200, 4.0F, 1.5F, 8); //copper tools
	static ToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL",2,400,6.0F, 2.5F,14); //steel tools
	static ToolMaterial SPIRITED = EnumHelper.addToolMaterial("SPIRITED", 4, 1600, 9.0F, 4F, 17); //spirited tools
	static ToolMaterial CHARREDLEAD = EnumHelper.addToolMaterial("CHARREDLEAD",2, 240, 6.0F, 2.0F, 13);
	static ToolMaterial AMETHYST = EnumHelper.addToolMaterial("AMETHYST",3, 1571, 8.0F, 3.0F, 10);
	static ToolMaterial MAGNETITE = EnumHelper.addToolMaterial("MAGNETITE",2,300,4.0F,1.5F,8);
	static ToolMaterial MAGMASPIRIT = EnumHelper.addToolMaterial("MAGMASPIRITED",5,1800,10.0F,5F,18);
	static ToolMaterial IRIDITE = EnumHelper.addToolMaterial("IRIDITE",3, 450, 6.5f, 3.0F, 15);
	static ToolMaterial ENDERSPIRIT = EnumHelper.addToolMaterial("ENDERSPIRITED", 6, 2800,11.0F,5.5F,20);
	static ToolMaterial LILITHITE = EnumHelper.addToolMaterial("LILITHITE",4, 1571, 8.2f, 3.0f,11);
	static ToolMaterial TELENIUM = EnumHelper.addToolMaterial("TELENIUM",4,900, 9.5f, 2F, 18);
	static ToolMaterial DIMENSIONFORGED = EnumHelper.addToolMaterial("DIMENSIONFORGED", 7, 3000,14.0F,7.0F,25);
	
	//EnumArmorMaterials
	static ArmorMaterial COPPER_A = EnumHelper.addArmorMaterial("COPPER",14,new int[] {2,5,4,2},8); //copper armor
	static ArmorMaterial STEEL_A = EnumHelper.addArmorMaterial("STEEL",22,new int[] {3,8,6,2},10); //steel armor
	static ArmorMaterial SPIRITED_A = EnumHelper.addArmorMaterial("SPIRITED",35,new int[] {4,9,7,4},14); //spirited armor
	static ArmorMaterial CHARREDLEAD_A = EnumHelper.addArmorMaterial("CHARREDLEAD",15, new int[]{2, 6, 5, 1}, 8);
	static ArmorMaterial AMETHYST_A = EnumHelper.addArmorMaterial("AMETHYST",34, new int[]{3, 8, 6, 3}, 10);
	static ArmorMaterial MAGNETITE_A = EnumHelper.addArmorMaterial("MAGNETITE",14, new int[]{2,5,4,2},9);
	static ArmorMaterial MAGMASPIRIT_A = EnumHelper.addArmorMaterial("MAGMASPIRITED", 37, new int[] {5,10,7,4}, 15);
	static ArmorMaterial IRIDITE_A = EnumHelper.addArmorMaterial("IRIDITE",25,new int[]{3,9,6,3},11);
	static ArmorMaterial ENDERSPIRIT_A = EnumHelper.addArmorMaterial("ENDERSPIRITED", 40, new int[] {6,11,8,5}, 16);
	static ArmorMaterial LILITHITE_A = EnumHelper.addArmorMaterial("LILITHITE",35, new int[]{4,8,6,3},11);
	static ArmorMaterial TELENIUM_A = EnumHelper.addArmorMaterial("TELENIUM", 17, new int[]{4,9,7,4}, 11);
	static ArmorMaterial DIMENSIONFORGED_A = EnumHelper.addArmorMaterial("DIMENSIONFORGED",50, new int[] {8,13,10,7}, 18);
	
	// Ingots
	public static Item aluminumIngot;
	public static Item copperIngot;
	public static Item steelIngot;
	public static Item spiritIngot;
	public static Item spiritedIngot;
	public static Item charredLeadChunk;
	public static Item amethystGem;
	public static Item magnetiteChunk;
	public static Item magmaSpiritCrystal;
	public static Item magmaSpiritIngot;
	public static Item iriditeShard;
	public static Item lilithiteGem;
	public static Item enderSpiritCrystal;
	public static Item enderSpiritIngot;
	public static Item teleniumIngot;
	public static Item dimensionForgedIngot;
	
	//Pickaxes
	public static Item aluminumPickaxe;
	public static Item copperPickaxe;
	public static Item steelPickaxe;
	public static Item spiritedPickaxe;
	public static Item charredLeadPickaxe;
	public static Item amethystPickaxe;
	public static Item magnetitePickaxe;
	public static Item magmaSpiritPickaxe;
	public static Item iriditePickaxe;
	public static Item lilithitePickaxe;
	public static Item enderspiritPickaxe;
	public static Item teleniumPickaxe;
	public static Item dimensionForgedPickaxe;
	
	//Axes
	public static Item aluminumAxe;
	public static Item copperAxe;
	public static Item steelAxe;
	public static Item spiritedAxe;
	public static Item charredLeadAxe;
	public static Item amethystAxe;
	public static Item magnetiteAxe;
	public static Item magmaSpiritAxe;
	public static Item iriditeAxe;
	public static Item lilithiteAxe;
	public static Item enderspiritAxe;
	public static Item teleniumAxe;
	public static Item dimensionForgedAxe;
	
	//Shovels
	public static Item aluminumShovel;
	public static Item copperShovel;
	public static Item steelShovel;
	public static Item spiritedShovel;
	public static Item charredLeadShovel;
	public static Item amethystShovel;
	public static Item magnetiteShovel;
	public static Item magmaSpiritShovel;
	public static Item iriditeShovel;
	public static Item lilithiteShovel;
	public static Item enderspiritShovel;
	public static Item teleniumShovel;
	public static Item dimensionForgedShovel;
	
	//Hoes
	public static Item aluminumHoe;
	public static Item copperHoe;
	public static Item steelHoe;
	public static Item spiritedHoe;
	public static Item charredLeadHoe;
	public static Item amethystHoe;
	public static Item magnetiteHoe;
	public static Item magmaSpiritHoe;
	public static Item iriditeHoe;
	public static Item lilithiteHoe;
	public static Item enderspiritHoe;
	public static Item teleniumHoe;
	public static Item dimensionForgedHoe;
	
	//Swords
	public static Item aluminumSword;
	public static Item copperSword;
	public static Item steelSword;
	public static Item spiritedSword;
	public static Item charredLeadSword;
	public static Item amethystSword;
	public static Item magnetiteSword;
	public static Item magmaSpiritSword;
	public static Item iriditeSword;
	public static Item lilithiteSword;
	public static Item enderspiritSword;
	public static Item teleniumSword;
	public static Item dimensionForgedSword;
	

	public static Item basicDartGun;
	public static Item aluminumDartGun;
	public static Item spiritedDartGun;
	public static Item amethystDartGun;
	public static Item magmaSpiritDartGun;
	public static Item enderspiritDartGun;
	public static Item teleniumDartGun;
	public static Item dimensionForgedDartGun;
	
	//Armor
	public static Item aluminumHelmet;
	public static Item aluminumChestplate;
	public static Item aluminumLeggings;
	public static Item aluminumBoots;
	
	public static Item copperHelmet;
	public static Item copperChestplate;
	public static Item copperLeggings;
	public static Item copperBoots;
	
	public static Item steelHelmet;
	public static Item steelChestplate;
	public static Item steelLeggings;
	public static Item steelBoots;
	
	public static Item spiritedHelmet;
	public static Item spiritedChestplate;
	public static Item spiritedLeggings;
	public static Item spiritedBoots;
	
	public static Item charredLeadHelmet;
	public static Item charredLeadChestplate;
	public static Item charredLeadLeggings;
	public static Item charredLeadBoots;
	
	public static Item amethystHelmet;
	public static Item amethystChestplate;
	public static Item amethystLeggings;
	public static Item amethystBoots;
	
	public static Item magnetiteHelmet;
	public static Item magnetiteChestplate;
	public static Item magnetiteLeggings;
	public static Item magnetiteBoots;
	
	public static Item magmaSpiritHelmet;
	public static Item magmaSpiritChestplate;
	public static Item magmaSpiritLeggings;
	public static Item magmaSpiritBoots;
	
	public static Item iriditeHelmet;
	public static Item iriditeChestplate;
	public static Item iriditeLeggings;
	public static Item iriditeBoots;
	
	public static Item lilithiteHelmet;
	public static Item lilithiteChestplate;
	public static Item lilithiteLeggings;
	public static Item lilithiteBoots;
	
	public static Item enderSpiritHelmet;
	public static Item enderSpiritChestplate;
	public static Item enderSpiritLeggings;
	public static Item enderSpiritBoots;
	
	public static Item teleniumHelmet;
	public static Item teleniumChestplate;
	public static Item teleniumLeggings;
	public static Item teleniumBoots;
	
	public static Item dimensionForgedHelmet;
	public static Item dimensionForgedChestplate;
	public static Item dimensionForgedLeggings;
	public static Item dimensionForgedBoots;
	
	// Ores
	public static Block aluminumOre;
	public static Block copperOre;
	public static Block steelOre;
	
	//Spirit Ores
	public static Block spiritOre;
	public static Block charredLeadOre;
	public static Block amethystOre;
	public static Block magnetiteOre;
	public static Block magmaSpiritOre;
	
	public static Block iriditeOre;
	public static Block lilithiteOre;
	public static Block enderspiritOre;	
	public static Block teleniumOre;

	// Material blocks
	public static Block aluminumBlock;
	public static Block copperBlock;
	public static Block steelBlock;
	public static Block spiritStone;
	public static Block spiritedBlock;
	public static Block charredLeadBlock;
	public static Block amethystBlock;
	public static Block magnetiteBlock;
	public static Block magmaSpiritBlock;
	public static Block iriditeBlock;
	public static Block lilithiteBlock;
	public static Block enderSpiritBlock;
	public static Block teleniumBlock;
	public static Block dimensionForgedBlock;
	
	//fences
	public static Block aluminumFence;
	public static Block copperFence;
	public static Block steelFence;
	public static Block spiritedFence;
	public static Block charredLeadFence;
	public static Block amethystFence;
	public static Block magnetiteFence;
	public static Block magmaSpiritFence;
	public static Block iriditeFence;
	public static Block lilithiteFence;
	public static Block enderSpiritFence;
	public static Block teleniumFence;
	public static Block dimensionForgedFence;

	
	//fence gates
	public static Block aluminumFenceGate;
	public static Block copperFenceGate;
	public static Block steelFenceGate;
	public static Block spiritedFenceGate;
	public static Block charredLeadFenceGate;
	public static Block amethystFenceGate;
	public static Block magnetiteFenceGate;
	public static Block magmaSpiritFenceGate;
	public static Block iriditeFenceGate;
	public static Block lilithiteFenceGate;
	public static Block enderSpiritFenceGate;
	public static Block teleniumFenceGate;
	public static Block dimensionForgedFenceGate;
	//Oh, darnit - tonight maybe?
    
    //sure
    //Wait - sorry...I have to go for dinner
    //My mom is asking me to go set the table
    //I might be back this evening tho
    
    
    @EventHandler 
    public void preInit(FMLPreInitializationEvent event)
    {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		enableFences = config.get(Configuration.CATEGORY_GENERAL, "Enable SpiritOres's Fences for each ore", true).getBoolean(enableFences);
		enableFenceGates = config.get(Configuration.CATEGORY_GENERAL, "Enable SpiritOres's Fencegates for each ore", true).getBoolean(enableFenceGates);
		
		aluminumIngotId = config.get("Ingots", "Aluminum Ingot", 2000).getInt();
		copperIngotId = config.get("Ingots", "Copper Ingot", 2001).getInt();
		steelIngotId = config.get("Ingots", "Steel Ingot", 2002).getInt();
		spiritCrystalId = config.get("Ingots", "Spirit Crystal", 2003).getInt();
		spiritedIngotId = config.get("Ingots", "Spirited Ingot",2004).getInt();
		charredLeadChunkId = config.get("Ingots","Charred Lead Chunk",4500).getInt();
		amethystGemId = config.get("Ingots","Amethyst Gem", 4600).getInt();
		magnetiteChunkId = config.get("Ingots","Magnetite Chunk", 4700).getInt();
		magmaSpiritCrystalId = config.get("Ingots", "Magma Spirit Crystal", 4799).getInt();
		magmaSpiritedIngotId = config.get("Ingots", "Magma Spirited Ingot", 4800).getInt();
		iriditeShardId = config.get("Ingots", "Iridite Shard", 4900).getInt();
		lilithiteGemId = config.get("Ingots", "Lilithite Gem", 5000).getInt();
		teleniumIngotId = config.get("Ingots", "Telenium Ingot", 5200).getInt();
		enderSpiritCrystalId = config.get("Ingots", "Ender Spirit Crystal", 5001).getInt();
		enderSpiritedIngotId = config.get("Ingots", "Ender Spirited Ingot", 5002).getInt();
		dimensionForgedIngotId = config.get("Ingots", "Dimensionforged Ingot", 5300).getInt();
		
		aluminumPickaxeId = config.get("Picks", "Aluminum Pick", 2100).getInt();
		copperPickaxeId = config.get("Picks", "Copper Pick",2101).getInt();
		steelPickaxeId = config.get("Picks", "Steel Pick",2102).getInt();
		spiritedPickaxeId = config.get("Picks", "Spirited Pick", 2103).getInt();
		charredLeadPickaxeId = config.get("Picks","Charred Lead Pick", 4510).getInt();
		amethystPickaxeId = config.get("Picks", "Amethyst Pick", 4610).getInt();
		magnetitePickaxeId = config.get("Picks", "Magnetite Pick", 4710).getInt();
		magmaSpiritedPickaxeId = config.get("Picks", "Magma Spirited Pick", 4810).getInt();
		iriditePickaxeId = config.get("Picks", "Iridite Pick", 4910).getInt();
		lilithitePickaxeId = config.get("Picks", "Lilithite Pick", 5010).getInt();
		enderSpiritPickaxeId = config.get("Picks", "Ender Spirit Pick", 5110).getInt();
		teleniumPickaxeId = config.get("Picks", "Telenium Pick", 5210).getInt();
		dimensionForgedPickaxeId = config.get("Picks", "Dimensionforged Pick", 5310).getInt();
		
		aluminumAxeId = config.get("Axes", "Aluminum Axe", 2103).getInt();
		copperAxeId = config.get("Axes", "Copper Axe", 2104).getInt();
		steelAxeId = config.get("Axes", "Steel Axe", 2105).getInt();
		spiritedAxeId = config.get("Axes", "Spirited Axe", 3001).getInt();
		charredLeadAxeId = config.get("Axes", "Charred Lead Axe",4511).getInt();
		amethystAxeId = config.get("Axes", "Amethyst Axe",4611).getInt();
		magnetiteAxeId = config.get("Axes","Magnetite Axe",4711).getInt();
		magmaSpiritedAxeId = config.get("Axes", "Magma Spirited Axe",4811).getInt();
		iriditeAxeId = config.get("Axes", "Iridite Axe",4911).getInt();
		lilithiteAxeId = config.get("Axes", "Lilithite Axe",5011).getInt();
		enderSpiritAxeId = config.get("Axes", "Ender Spirit Axe",5111).getInt();
		teleniumAxeId = config.get("Axes", "Telenium Axe",5211).getInt();
		dimensionForgedAxeId = config.get("Axes","Dimensionforged Axe",5311).getInt();
		
		aluminumShovelId = config.get("Shovels","Aluminum Shovel", 2106).getInt();
		copperShovelId = config.get("Shovels","Copper Shovel",2107).getInt();
		steelShovelId = config.get("Shovels", "Steel Shovel",2108).getInt();
		spiritedShovelId = config.get("Shovels", "Spirited Shovel",3002).getInt();
		charredLeadShovelId = config.get("Shovels", "Charred Lead Shovel",4512).getInt();
		amethystShovelId = config.get("Shovels","Amethyst Shovel",4612).getInt();
		magnetiteShovelId = config.get("Shovels","Magnetite Shovel",4712).getInt();
		magmaSpiritedShovelId = config.get("Shovels", "Magma Spirited Shovel",4812).getInt();
		iriditeShovelId = config.get("Shovels","Iridite Shovel",4912).getInt();
		lilithiteShovelId = config.get("Shovels","Lilithite Shovel",5012).getInt();
		enderSpiritShovelId = config.get("Shovels","Ender Spirited Shovel",5112).getInt();
		teleniumShovelId = config.get("Shovels","Telenium Shovel",5212).getInt();
		dimensionForgedShovelId = config.get("Shovels","Dimensionforged Shovel",5312).getInt();
		
		aluminumHoeId = config.get("Hoes","Aluminum Hoe",2109).getInt();
		copperHoeId = config.get("Hoes","Copper Hoe",2110).getInt();
		steelHoeId = config.get("Hoes","Steel Hoe",2111).getInt();
		spiritedHoeId = config.get("Hoes","Spirited Hoe",3003).getInt();
		charredLeadHoeId = config.get("Hoes","Charred Lead Hoe",4513).getInt();
		amethystHoeId = config.get("Hoes","Amethyst Hoe",4613).getInt();
		magnetiteHoeId = config.get("Hoes","Magnetite Hoe",4713).getInt();
		magmaSpiritedHoeId = config.get("Hoes","Magma Spirited Hoe",4813).getInt();
		iriditeHoeId = config.get("Hoes","Iridite Hoe",4913).getInt();
		lilithiteHoeId = config.get("Hoes","Lilithite Hoe",5013).getInt();
		enderSpiritedHoeId = config.get("Hoes","Ender Spirited Hoe",5113).getInt();
		teleniumHoeId = config.get("Hoes","Telenium Hoe",5213).getInt();
		dimensionForgedHoeId=config.get("Hoes","Dimensionforged Hoe",5313).getInt();
		
		aluminumSwordId = config.get("Swords","Aluminum Sword",2112).getInt();
		copperSwordId = config.get("Swords","Copper Sword",2113).getInt();
		steelSwordId = config.get("Swords","Steel Sword",2114).getInt();
		spiritedSwordId = config.get("Swords","Spirited Sword",3004).getInt();
		charredLeadSwordId = config.get("Swords","Charred Lead Sword",4514).getInt();
		amethystSwordId = config.get("Swords","Amethyst Sword",4614).getInt();
		magnetiteSwordId = config.get("Swords","Magnetite Sword",4714).getInt();
		magmaSpiritedSwordId = config.get("Swords", "Magma Spirited Sword",4814).getInt();
		iriditeSwordId = config.get("Swords","Iridite Sword",4914).getInt();
		lilithiteSwordId = config.get("Swords","Lilithite Sword",5014).getInt();
		enderSpiritedSwordId = config.get("Swords","Ender Spirited Sword",5114).getInt();
		teleniumSwordId = config.get("Swords","Telenium Sword",5214).getInt();
		dimensionForgedSwordId = config.get("Swords","Dimensionforged Sword",5314).getInt();
		
		basicDartGunId = config.get("Dart Guns","Basic Dart Gun",3100).getInt();
		aluminumDartGunId = config.get("Dart Guns","Aluminum Dart Gun",3101).getInt();
		spiritedDartGunId = config.get("Dart Guns","Spirited Dart Gun",3103).getInt();
		amethystDartGunId = config.get("Dart Guns","Amethyst Dart Gun",4615).getInt();
		magmaSpiritedDartGunId = config.get("Dart Guns","Magma Spirited Dart Gun",4715).getInt();
		enderSpiritedDartGunId = config.get("Dart Guns", "Ender Spirited Dart Gun",4815).getInt();
		teleniumDartGunId=config.get("Dart Guns","Telenium Dart Gun",5215).getInt();
		dimensionForgedDartGunId = config.get("Dart Guns","Dimensionforged Dart Gun",5315).getInt();
		
		aluminumHelmetId = config.get("Armor","Aluminum Helmet",2120).getInt();
		aluminumChestplateId = config.get("Armor","Aluminum Chestplate",2121).getInt();
		aluminumLeggingsId = config.get("Armor","Aluminum Leggings",2122).getInt();
		aluminumBootsId = config.get("Armor","Aluminum Boots",2123).getInt();
		
		copperHelmetId = config.get("Armor","Copper Helmet",2124).getInt();
		copperChestplateId = config.get("Armor","Copper Chestplate",2125).getInt();
		copperLeggingsId = config.get("Armor","Copper Leggings",2126).getInt();
		copperBootsId = config.get("Armor","Copper Boots",2127).getInt();
		
		steelHelmetId = config.get("Armor","Steel Helmet",2128).getInt();
		steelChestplateId = config.get("Armor","Steel Chestplate",2129).getInt();
		steelLeggingsId = config.get("Armor","Steel Leggings",2130).getInt();
		steelBootsId = config.get("Armor","Steel Boots",2131).getInt();
		
		spiritedHelmetId = config.get("Armor","Spirited Helmet",3010).getInt();
		spiritedChestplateId = config.get("Armor","Spirited Chestplate",3011).getInt();
		spiritedLeggingsId = config.get("Armor","Spirited Leggings",3012).getInt();
		spiritedBootsId = config.get("Armor","Spirited Boots",3013).getInt();
		
		charredLeadHelmetId = config.get("Armor","Charred Lead Helmet",4516).getInt();
		charredLeadChestplateId = config.get("Armor","Charred Lead Chestplate",4517).getInt();
		charredLeadLeggingsId = config.get("Armor","Charred Lead Leggings",4518).getInt();
		charredLeadBootsId = config.get("Armor","Charred Lead Boots",4519).getInt();
		
		amethystHelmetId = config.get("Armor","Amethyst Helmet",4616).getInt();
		amethystChestplateId = config.get("Armor","Amethyst Chestplate",4617).getInt();
		amethystLeggingsId = config.get("Armor","Amethyst Leggings",4618).getInt();
		amethystBootsId = config.get("Armor","Amethyst Boots",4619).getInt();
		
		magnetiteHelmetId = config.get("Armor","Magnetite Helmet",4716).getInt();
		magnetiteChestplateId = config.get("Armor","Magnetite Chestplate",4717).getInt();
		magnetiteLeggingsId = config.get("Armor","Magnetite Leggings",4718).getInt();
		magnetiteBootsId = config.get("Armor","Magnetite Boots",4719).getInt();
		
		magmaSpiritedHelmetId = config.get("Armor","Magma Spirited Helmet",4816).getInt();
		magmaSpiritedChestplateId = config.get("Armor","Magma Spirited Chestplate",4817).getInt();
		magmaSpiritedLeggingsId = config.get("Armor","Magma Spirited Leggings",4818).getInt();
		magmaSpiritedBootsId = config.get("Armor","Magma Spirited Boots",4819).getInt();
		
		iriditeHelmetId = config.get("Armor","Iridite Helmet",4916).getInt();
		iriditeChestplateId = config.get("Armor","Iridite Chestplate",4917).getInt();
		iriditeLeggingsId = config.get("Armor","Iridite Leggings",4918).getInt();
		iriditeBootsId = config.get("Armor","Iridite Boots",4919).getInt();
		
		lilithiteHelmetId = config.get("Armor","Lilithite Helmet",5016).getInt();
		lilithiteChestplateId = config.get("Armor","Lilithite Chestplate",5017).getInt();
		lilithiteLeggingsId=config.get("Armor","Lilithite Leggings",5018).getInt();
		lilithiteBootsId = config.get("Armor","Lilithite Boots",5019).getInt();
		
		enderSpiritedHelmetId = config.get("Armor","Ender Spirited Helmet",5116).getInt();
		enderSpiritedChestplateId = config.get("Armor","Ender Spirited Chestplate",5117).getInt();
		enderSpiritedLeggingsId = config.get("Armor", "Ender Spirited Leggings",5118).getInt();
		enderSpiritedBootsId = config.get("Armor", "Ender Spirited Boots",5119).getInt();
		
		teleniumHelmetId = config.get("Armor","Telenium Helmet",5216).getInt();
		teleniumChestplateId = config.get("Armor","Telenium Chestplate",5217).getInt();
		teleniumLeggingsId = config.get("Armor","Telenium Leggings",5218).getInt();
		teleniumBootsId = config.get("Armor","Telenium Boots",5219).getInt();
		
		dimensionForgedHelmetId = config.get("Armor","Dimensionforged Helmet",5316).getInt();
		dimensionForgedChestplateId = config.get("Armor","Dimensionforged Chestplate",5317).getInt();
		dimensionForgedLeggingsId = config.get("Armor","Dimensionforged Leggings",5318).getInt();
		dimensionForgedBootsId = config.get("Armor","Dimensionforged Boots",5319).getInt();
		
		
		aluminumOreId = config.get("Ores","Aluminum Ore",2010).getInt();
		copperOreId = config.get("Ores","Copper Ore",2011).getInt();
		steelOreId = config.get("Ores","Steel Ore",2012).getInt();
		spiritOreId = config.get("Ores","Spirit Ore",2013).getInt();
		
		charredLeadOreId = config.get("Ores","Charred Lead Ore",4000).getInt();
		amethystOreId = config.get("Ores", "Amethyst Ore",4004).getInt();
		magnetiteOreId = config.get("Ores","Magnetite Ore",3999).getInt();
		magmaSpiritOreId = config.get("Ores","Magma Spirit Ore",3980).getInt();
		
		iriditeOreId = config.get("Ores","Iridite Ore",1000).getInt();
		lilithiteOreId = config.get("Ores","Lilithite Ore",1004).getInt();
		teleniumOreId = config.get("Ores","Telenium Ore",1200).getInt();
		enderSpiritOreId = config.get("Ores","Ender Spirit Ore",1300).getInt();
		
		aluminumBlockId = config.get("Blocks","Aluminum Block",2020).getInt();
		copperBlockId = config.get("Blocks","Copper Block", 2021).getInt();
		steelBlockId = config.get("Blocks","Steel Block",2022).getInt();
		spiritStoneId = config.get("Blocks","Spirit Stone",2023).getInt();
		spiritedBlockId = config.get("Blocks","Spirited Block",3014).getInt();
		charredLeadBlockId = config.get("Blocks","Charred Lead Block",4001).getInt();
		amethystBlockId = config.get("Blocks","Amethyst Block",4006).getInt();
		magnetiteBlockId = config.get("Blocks","Magnetite Block",3998).getInt();
		magmaSpiritedBlockId = config.get("Blocks","Magma Spirited Block",3981).getInt();
		iriditeBlockId = config.get("Blocks","Iridite Block",1001).getInt();
		lilithiteBlockId = config.get("Blocks","Lilithite Block",1005).getInt();
		teleniumBlockId = config.get("Blocks","Telenium Block",1301).getInt();
		enderSpiritedBlockId = config.get("Blocks","Ender Spirited Block",1201).getInt();
		dimensionForgedBlockId = config.get("Blocks","Dimensionforged Block",1401).getInt();
		
		aluminumFenceId = config.get("Blocks","Aluminum Fence",2024).getInt();
		copperFenceId = config.get("Blocks","Copper Fence",2025).getInt();
		steelFenceId = config.get("Blocks","Steel Fence",2026).getInt();
		spiritedFenceId = config.get("Blocks","Spirited Fence",2027).getInt();
		charredLeadFenceId = config.get("Blocks","Charred Lead Fence",4002).getInt();
		amethystFenceId = config.get("Blocks","Amethyst Fence",4005).getInt();
		magnetiteFenceId = config.get("Blocks","Magnetite Fence",3997).getInt();
		magmaSpiritedFenceId = config.get("Blocks","Magma Spirited Fence",3982).getInt();
		iriditeFenceId = config.get("Blocks","Iridite Fence",1002).getInt();
		lilithiteFenceId = config.get("Blocks","Lilithite Fence",1006).getInt();
		teleniumFenceId = config.get("Blocks", "Telenium Fence",1302).getInt();
		enderSpiritedFenceId = config.get("Blocks","Ender Spirited Fence",1202).getInt();
		dimensionForgedFenceId = config.get("Blocks","Dimensionforged Fence",1402).getInt();
		
		aluminumFenceGateId = config.get("Blocks","Aluminum Fence Gate",4024).getInt();
		copperFenceGateId = config.get("Blocks","Copper Fence Gate",4025).getInt();
		steelFenceGateId = config.get("Blocks","Steel Fence Gate",4026).getInt();
		spiritedFenceGateId = config.get("Blocks","Spirited Fence Gate",4027).getInt();
		charredLeadFenceGateId = config.get("Blocks", "Charred Lead Fence Gate",4003).getInt();
		amethystFenceGateId = config.get("Blocks","Amethyst Fence Gate",4010).getInt();
		magnetiteFenceGateId = config.get("Blocks","Magnetite Fence Gate",3996).getInt();
		magmaSpiritedFenceGateId = config.get("Blocks","Magma Spirited Fence Gate",3983).getInt();
		iriditeFenceGateId = config.get("Blocks","Iridite Fence Gate",1003).getInt();
		lilithiteFenceGateId = config.get("Blocks","Lilithite Fence Gate",1007).getInt();
		teleniumFenceGateId = config.get("Blocks","Telenium Fence Gate",1303).getInt();
		enderSpiritedFenceGateId = config.get("Blocks","Ender Spirited Fence Gate",1203).getInt();
		dimensionForgedFenceGateId = config.get("Blocks", "Dimensionforged Fence Gate",1403).getInt();
		config.save();
		
		
	
    }
    
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		
		//load items
		
		aluminumIngot = new SpiritIngot(aluminumIngotId).setUnlocalizedName("aluminumIngot").setTextureName("spiritoresmod:aluminumIngot");
		copperIngot = new SpiritIngot(copperIngotId).setUnlocalizedName("copperIngot").setTextureName("spiritoresmod:copperIngot");
		steelIngot = new SpiritIngot(steelIngotId).setUnlocalizedName("steelIngot").setTextureName("spiritoresmod:steelIngot");
		spiritIngot = new SpiritIngot(spiritCrystalId).setUnlocalizedName("spiritIngot").setTextureName("spiritoresmod:spiritIngot");
		spiritedIngot = new SpiritIngot(spiritedIngotId).setUnlocalizedName("spiritedIngot").setTextureName("spiritoresmod:spiritedIngot");
		charredLeadChunk = new SpiritIngot(charredLeadChunkId).setUnlocalizedName("charredLeadChunk").setTextureName("spiritoresmod:charredLeadChunk");
		amethystGem = new SpiritIngot(amethystGemId).setUnlocalizedName("amethystGem").setTextureName("spiritoresmod:amethystGem");
		magnetiteChunk = new SpiritIngot(magnetiteChunkId).setUnlocalizedName("magnetiteChunk").setTextureName("spiritoresmod:magnetiteChunk");
		magmaSpiritCrystal = new SpiritIngot(magmaSpiritCrystalId).setUnlocalizedName("magmaSpiritCrystal").setTextureName("spiritoresmod:magmaSpiritCrystal");
		magmaSpiritIngot = new SpiritIngot(magmaSpiritedIngotId).setUnlocalizedName("magmaSpiritIngot").setTextureName("spiritoresmod:magmaSpiritIngot");
		iriditeShard = new SpiritIngot(iriditeShardId).setUnlocalizedName("iriditeShard").setTextureName("spiritoresmod:iriditeShard");
		lilithiteGem = new SpiritIngot(lilithiteGemId).setUnlocalizedName("lilithiteGem").setTextureName("spiritoresmod:lilithiteGem");
		teleniumIngot = new SpiritIngot(teleniumIngotId).setUnlocalizedName("teleniumIngot").setTextureName("spiritoresmod:teleniumIngot");
		enderSpiritCrystal = new SpiritIngot(enderSpiritCrystalId).setUnlocalizedName("enderSpiritCrystal").setTextureName("spiritoresmod:enderspiritCrystal");
		enderSpiritIngot = new SpiritIngot(enderSpiritedIngotId).setUnlocalizedName("enderspiritedIngot").setTextureName("spiritoresmod:enderspiritedIngot");
		dimensionForgedIngot = new SpiritIngot(dimensionForgedIngotId).setUnlocalizedName("dimensionForgedIngot").setTextureName("spiritoresmod:dimensionForgedIngot");
		
		aluminumPickaxe = new SpiritPickaxe(aluminumPickaxeId,COPPER).setUnlocalizedName("aluminumPickaxe").setTextureName("spiritoresmod:aluminumPickaxe");
		copperPickaxe = new SpiritPickaxe(copperPickaxeId,COPPER).setUnlocalizedName("copperPickaxe").setTextureName("spiritoresmod:copperPickaxe");
		steelPickaxe = new SpiritPickaxe(steelPickaxeId,STEEL).setUnlocalizedName("steelPickaxe").setTextureName("spiritoresmod:steelPickaxe");
		spiritedPickaxe = new SpiritPickaxe(spiritedPickaxeId, SPIRITED).setUnlocalizedName("spiritedPickaxe").setTextureName("spiritoresmod:spiritedPickaxe");
		charredLeadPickaxe = new SpiritPickaxe(charredLeadPickaxeId, CHARREDLEAD).setUnlocalizedName("charredLeadPickaxe").setTextureName("spiritoresmod:charredLeadPickaxe");
		amethystPickaxe = new SpiritPickaxe(amethystPickaxeId, AMETHYST).setUnlocalizedName("amethystPickaxe").setTextureName("spiritoresmod:amethystPickaxe");
		magnetitePickaxe = new SpiritPickaxe(magnetitePickaxeId, MAGNETITE).setUnlocalizedName("magnetitePickaxe").setTextureName("spiritoresmod:magnetitePickaxe");
		magmaSpiritPickaxe = new SpiritPickaxe(magmaSpiritedPickaxeId, MAGMASPIRIT).setUnlocalizedName("magmaSpiritPickaxe").setTextureName("spiritoresmod:magmaSpiritPickaxe");
		iriditePickaxe = new SpiritPickaxe(iriditePickaxeId, IRIDITE).setUnlocalizedName("iriditePickaxe").setTextureName("spiritoresmod:iriditePickaxe");
		lilithitePickaxe = new SpiritPickaxe(lilithitePickaxeId, LILITHITE).setUnlocalizedName("lilithitePickaxe").setTextureName("spiritoresmod:lilithitePickaxe");
		enderspiritPickaxe = new SpiritPickaxe(enderSpiritPickaxeId, ENDERSPIRIT).setUnlocalizedName("enderspiritPickaxe").setTextureName("spiritoresmod:enderspiritPickaxe");
		teleniumPickaxe = new SpiritPickaxe(teleniumPickaxeId, TELENIUM).setUnlocalizedName("teleniumPickaxe").setTextureName("spiritoresmod:teleniumPickaxe");
		dimensionForgedPickaxe = new SpiritPickaxe(dimensionForgedPickaxeId, DIMENSIONFORGED).setUnlocalizedName("dimensionForgedPickaxe").setTextureName("spiritoresmod:dimensionForgedPickaxe");
		
		aluminumAxe = new SpiritAxe(aluminumAxeId,COPPER).setUnlocalizedName("aluminumAxe").setTextureName("spiritoresmod:aluminumAxe");
		copperAxe = new SpiritAxe(copperAxeId,COPPER).setUnlocalizedName("copperAxe").setTextureName("spiritoresmod:copperAxe");
		steelAxe = new SpiritAxe(steelAxeId,STEEL).setUnlocalizedName("steelAxe").setTextureName("spiritoresmod:steelAxe");
		spiritedAxe = new SpiritAxe(spiritedAxeId, SPIRITED).setUnlocalizedName("spiritedAxe").setTextureName("spiritoresmod:spiritedAxe");
		charredLeadAxe = new SpiritAxe(charredLeadAxeId, CHARREDLEAD).setUnlocalizedName("charredLeadAxe").setTextureName("spiritoresmod:charredLeadAxe");
		amethystAxe = new SpiritAxe(amethystAxeId, AMETHYST).setUnlocalizedName("amethystAxe").setTextureName("spiritoresmod:amethystAxe");
		magnetiteAxe = new SpiritAxe(magnetiteAxeId, MAGNETITE).setUnlocalizedName("magnetiteAxe").setTextureName("spiritoresmod:magnetiteAxe");
		magmaSpiritAxe = new SpiritAxe(magmaSpiritedAxeId, MAGMASPIRIT).setUnlocalizedName("magmaSpiritAxe").setTextureName("spiritoresmod:magmaSpiritAxe");
		iriditeAxe = new SpiritAxe(iriditeAxeId, IRIDITE).setUnlocalizedName("iriditeAxe").setTextureName("spiritoresmod:iriditeAxe");
		lilithiteAxe = new SpiritAxe(lilithiteAxeId, LILITHITE).setUnlocalizedName("lilithiteAxe").setTextureName("spiritoresmod:lilithiteAxe");
		enderspiritAxe = new SpiritAxe(enderSpiritAxeId, ENDERSPIRIT).setUnlocalizedName("enderspiritAxe").setTextureName("spiritoresmod:enderspiritAxe");
		teleniumAxe = new SpiritAxe(teleniumAxeId, TELENIUM).setUnlocalizedName("teleniumAxe").setTextureName("spiritoresmod:teleniumAxe");
		dimensionForgedAxe = new SpiritAxe(dimensionForgedAxeId, DIMENSIONFORGED).setUnlocalizedName("dimensionForgedAxe").setTextureName("spiritoresmod:dimensionForgedAxe");
		
		aluminumShovel = new SpiritSpade(aluminumShovelId,COPPER).setUnlocalizedName("aluminumShovel").setTextureName("spiritoresmod:aluminumShovel");
		copperShovel = new SpiritSpade(copperShovelId,COPPER).setUnlocalizedName("copperShovel").setTextureName("spiritoresmod:copperShovel");
		steelShovel = new SpiritSpade(steelShovelId,STEEL).setUnlocalizedName("steelShovel").setTextureName("spiritoresmod:steelShovel");
		spiritedShovel = new SpiritSpade(spiritedShovelId, SPIRITED).setUnlocalizedName("spiritedShovel").setTextureName("spiritoresmod:spiritedShovel");
		charredLeadShovel = new SpiritSpade(charredLeadShovelId, CHARREDLEAD).setUnlocalizedName("charredLeadShovel").setTextureName("spiritoresmod:charredLeadShovel");
		amethystShovel = new SpiritSpade(amethystShovelId, AMETHYST).setUnlocalizedName("amethystShovel").setTextureName("spiritoresmod:amethystShovel");
		magnetiteShovel = new SpiritSpade(magnetiteShovelId, MAGNETITE).setUnlocalizedName("magnetiteShovel").setTextureName("spiritoresmod:magnetiteShovel");
		magmaSpiritShovel = new SpiritSpade(magmaSpiritedShovelId, MAGMASPIRIT).setUnlocalizedName("magmaSpiritShovel").setTextureName("spiritoresmod:magmaSpiritShovel");
		iriditeShovel = new SpiritSpade(iriditeShovelId, IRIDITE).setUnlocalizedName("iriditeShovel").setTextureName("spiritoresmod:iriditeShovel");
		lilithiteShovel = new SpiritSpade(lilithiteShovelId, LILITHITE).setUnlocalizedName("lilithiteShovel").setTextureName("spiritoresmod:lilithiteShovel");
		enderspiritShovel = new SpiritSpade(enderSpiritShovelId, ENDERSPIRIT).setUnlocalizedName("enderspiritShovel").setTextureName("spiritoresmod:enderspiritShovel");
		teleniumShovel = new SpiritSpade(teleniumShovelId, TELENIUM).setUnlocalizedName("teleniumShovel").setTextureName("spiritoresmod:teleniumShovel");
		dimensionForgedShovel = new SpiritSpade(dimensionForgedShovelId, DIMENSIONFORGED).setUnlocalizedName("dimensionForgedShovel").setTextureName("spiritoresmod:dimensionForgedShovel");
		
		aluminumHoe = new SpiritHoes(aluminumHoeId,COPPER).setUnlocalizedName("aluminumHoe").setTextureName("spiritoresmod:aluminumHoe");
		copperHoe = new SpiritHoes(copperHoeId,COPPER).setUnlocalizedName("copperHoe").setTextureName("spiritoresmod:copperHoe");
		steelHoe = new SpiritHoes(steelHoeId,STEEL).setUnlocalizedName("steelHoe").setTextureName("spiritoresmod:steelHoe");
		spiritedHoe = new SpiritHoes(spiritedHoeId,SPIRITED).setUnlocalizedName("spiritedHoe").setTextureName("spiritoresmod:spiritedHoe");
		charredLeadHoe = new SpiritHoes(charredLeadHoeId,CHARREDLEAD).setUnlocalizedName("charredLeadHoe").setTextureName("spiritoresmod:charredLeadHoe");
		amethystHoe = new SpiritHoes(amethystHoeId, AMETHYST).setUnlocalizedName("amethystHoe").setTextureName("spiritoresmod:amethystHoe");
		magnetiteHoe = new SpiritHoes(magnetiteHoeId, MAGMASPIRIT).setUnlocalizedName("magnetiteHoe").setTextureName("spiritoresmod:magnetiteHoe");
		magmaSpiritHoe = new SpiritHoes(magmaSpiritedHoeId, MAGMASPIRIT).setUnlocalizedName("magmaSpiritHoe").setTextureName("spiritoresmod:magmaSpiritHoe");
		iriditeHoe = new SpiritHoes(iriditeHoeId, IRIDITE).setUnlocalizedName("iriditeHoe").setTextureName("spiritoresmod:iriditeHoe");
		lilithiteHoe = new SpiritHoes(lilithiteHoeId, LILITHITE).setUnlocalizedName("lilithiteHoe").setTextureName("spiritoresmod:lilithiteHoe");
		enderspiritHoe = new SpiritHoes(enderSpiritedHoeId, ENDERSPIRIT).setUnlocalizedName("enderspiritHoe").setTextureName("spiritoresmod:enderspiritHoe");
		teleniumHoe = new SpiritHoes(teleniumHoeId, TELENIUM).setUnlocalizedName("teleniumHoe").setTextureName("spiritoresmod:teleniumHoe");
		dimensionForgedHoe = new SpiritHoes(dimensionForgedHoeId, DIMENSIONFORGED).setUnlocalizedName("dimensionForgedHoe").setTextureName("spiritoresmod:dimensionForgedHoe");
		
		aluminumSword = new SpiritSword(aluminumSwordId,COPPER).setUnlocalizedName("aluminumSword").setTextureName("spiritoresmod:aluminumSword");
		copperSword = new SpiritSword(copperSwordId,COPPER).setUnlocalizedName("copperSword").setTextureName("spiritoresmod:copperSword");
		steelSword = new SpiritSword(steelSwordId,STEEL).setUnlocalizedName("steelSword").setTextureName("spiritoresmod:steelSword");
		spiritedSword = new SpiritSword(spiritedSwordId,SPIRITED).setUnlocalizedName("spiritedSword").setTextureName("spiritoresmod:spiritedSword");
		charredLeadSword = new SpiritSword(charredLeadSwordId, CHARREDLEAD).setUnlocalizedName("charredLeadSword").setTextureName("spiritoresmod:charredLeadSword");
		amethystSword = new SpiritSword(amethystSwordId, AMETHYST).setUnlocalizedName("amethystSword").setTextureName("spiritoresmod:amethystSword");
		magnetiteSword = new SpiritSword(magnetiteSwordId, MAGNETITE).setUnlocalizedName("magnetiteSword").setTextureName("spiritoresmod:magnetiteSword");
		magmaSpiritSword = new SpiritSword(magmaSpiritedSwordId, MAGMASPIRIT).setUnlocalizedName("magmaSpiritSword").setTextureName("spiritoresmod:magmaSpiritSword");
		iriditeSword = new SpiritSword(iriditeSwordId, IRIDITE).setUnlocalizedName("iriditeSword").setTextureName("spiritoresmod:iriditeSword");
		lilithiteSword = new SpiritSword(lilithiteSwordId, LILITHITE).setUnlocalizedName("lilithiteSword").setTextureName("spiritoresmod:lilithiteSword");
		enderspiritSword = new SpiritSword(enderSpiritedSwordId, ENDERSPIRIT).setUnlocalizedName("enderspiritSword").setTextureName("spiritoresmod:enderspiritSword");
		teleniumSword = new SpiritSword(teleniumSwordId, TELENIUM).setUnlocalizedName("teleniumSword").setTextureName("spiritoresmod:teleniumSword");
		dimensionForgedSword = new SpiritSword(dimensionForgedSwordId, DIMENSIONFORGED).setUnlocalizedName("dimensionForgedSword").setTextureName("spiritoresmod:dimensionForgedSword");
		
		basicDartGun = new SpiritDartGun(basicDartGunId, 9000,700,"basicDartGun").setTextureName("spiritoresmod:basicDartGun");
		aluminumDartGun = new SpiritDartGun(aluminumDartGunId,74000,700,"aluminumDartGun").setTextureName("spiritoresmod:aluminumDartGun");
		spiritedDartGun = new SpiritedSpiritDartGun(spiritedDartGunId,90000,1000,"spiritedDartGun").setUnlocalizedName("spiritedDartGun").setTextureName("spiritoresmod:spiritedDartGun");
		amethystDartGun = new SpiritDartGun(amethystDartGunId, 85000,920, "amethystDartGun").setTextureName("spiritoresmod:amethystDartGun");
		magmaSpiritDartGun = new MagmaSpiritDartGun(magmaSpiritedDartGunId, 150000,1500, "magmaSpiritDartGun").setTextureName("spiritoresmod:magmaSpiritDartGun");
		enderspiritDartGun = new SpiritDartGun(enderSpiritedDartGunId, 170000,1600, "enderSpiritDartGun").setTextureName("spiritoresmod:enderSpiritDartGun");
		teleniumDartGun = new SpiritDartGun(teleniumDartGunId, 140000, 350, "teleniumDartGun").setTextureName("spiritoresmod:teleniumDartGun");
		dimensionForgedDartGun = new DimensionForgedDartGun(dimensionForgedDartGunId, 200000, 1800, "dimensionForgedDartGun").setTextureName("spiritoresmod:dimensionForgedDartGun");
		
		aluminumHelmet = new SpiritArmor(aluminumHelmetId,COPPER_A,2,0,"aluminum").setUnlocalizedName("aluminumHelmet").setTextureName("spiritoresmod:aluminumHelmet");
		aluminumChestplate = new SpiritArmor(aluminumChestplateId,COPPER_A,2,1,"aluminum").setUnlocalizedName("aluminumChestplate").setTextureName("spiritoresmod:aluminumChestplate");
		aluminumLeggings = new SpiritArmor(aluminumLeggingsId,COPPER_A,2,2,"aluminum").setUnlocalizedName("aluminumLeggings").setTextureName("spiritoresmod:aluminumLeggings");
		aluminumBoots = new SpiritArmor(aluminumBootsId,COPPER_A,2,3,"aluminum").setUnlocalizedName("aluminumBoots").setTextureName("spiritoresmod:aluminumBoots");
		
		copperHelmet = new SpiritArmor(copperHelmetId,COPPER_A,4,0,"copper").setUnlocalizedName("copperHelmet").setTextureName("spiritoresmod:copperHelmet");
		copperChestplate = new SpiritArmor(copperChestplateId,COPPER_A,4,1,"copper").setUnlocalizedName("copperChestplate").setTextureName("spiritoresmod:copperChestplate");
		copperLeggings = new SpiritArmor(copperLeggingsId,COPPER_A,4,2,"copper").setUnlocalizedName("copperLeggings").setTextureName("spiritoresmod:copperLeggings");
		copperBoots = new SpiritArmor(copperBootsId,COPPER_A,4,3,"copper").setUnlocalizedName("copperBoots").setTextureName("spiritoresmod:copperBoots");
		
		steelHelmet = new SpiritArmor(steelHelmetId,STEEL_A,0,0,"steel").setUnlocalizedName("steelHelmet").setTextureName("spiritoresmod:steelHelmet");
		steelChestplate = new SpiritArmor(steelChestplateId,STEEL_A,0,1,"steel").setUnlocalizedName("steelChestplate").setTextureName("spiritoresmod:steelChestplate");
		steelLeggings = new SpiritArmor(steelLeggingsId,STEEL_A,0,2,"steel").setUnlocalizedName("steelLeggings").setTextureName("spiritoresmod:steelLeggings");
		steelBoots = new SpiritArmor(steelBootsId,STEEL_A,0,3,"steel").setUnlocalizedName("steelBoots").setTextureName("spiritoresmod:steelBoots");
		
		spiritedHelmet = new SpiritArmor(spiritedHelmetId,SPIRITED_A,0,0,"spirited").setUnlocalizedName("spiritedHelmet").setTextureName("spiritoresmod:spiritedHelmet");
		spiritedChestplate = new SpiritArmor(spiritedChestplateId,SPIRITED_A,0,1,"spirited").setUnlocalizedName("spiritedChestplate").setTextureName("spiritoresmod:spiritedChestplate");
		spiritedLeggings = new SpiritArmor(spiritedLeggingsId,SPIRITED_A,0,2,"spirited").setUnlocalizedName("spiritedLeggings").setTextureName("spiritoresmod:spiritedLeggings");
		spiritedBoots = new SpiritArmor(spiritedBootsId,SPIRITED_A,0,3,"spirited").setUnlocalizedName("spiritedBoots").setTextureName("spiritoresmod:spiritedBoots");
		
		charredLeadHelmet = new SpiritArmor(charredLeadHelmetId, CHARREDLEAD_A,0,0,"charredLead").setUnlocalizedName("charredLeadHelmet").setTextureName("spiritoresmod:charredLeadHelmet");
		charredLeadChestplate = new SpiritArmor(charredLeadChestplateId, CHARREDLEAD_A,0,1,"charredLead").setUnlocalizedName("charredLeadChestplate").setTextureName("spiritoresmod:charredLeadChestplate");
		charredLeadLeggings = new SpiritArmor(charredLeadLeggingsId,CHARREDLEAD_A,0,2,"charredLead").setUnlocalizedName("charredLeadLeggings").setTextureName("spiritoresmod:charredLeadLeggings");
		charredLeadBoots = new SpiritArmor(charredLeadBootsId,CHARREDLEAD_A,0,3,"charredLead").setUnlocalizedName("charredLeadBoots").setTextureName("spiritoresmod:charredLeadBoots");
		
		amethystHelmet = new SpiritArmor(amethystHelmetId, AMETHYST_A, 0,0, "amethyst").setUnlocalizedName("amethystHelmet").setTextureName("spiritoresmod:amethystHelmet");
		amethystChestplate = new SpiritArmor(amethystChestplateId, AMETHYST_A,0,1,"amethyst").setUnlocalizedName("amethystChestplate").setTextureName("spiritoresmod:amethystChestplate");
		amethystLeggings = new SpiritArmor(amethystLeggingsId, AMETHYST_A,0,2,"amethyst").setUnlocalizedName("amethystLeggings").setTextureName("spiritoresmod:amethystLeggings");
		amethystBoots = new SpiritArmor(amethystBootsId, AMETHYST_A, 0,3, "amethyst").setUnlocalizedName("amethystBoots").setTextureName("spiritoresmod:amethystBoots");
		
		magnetiteHelmet = new SpiritArmor(magnetiteHelmetId, MAGNETITE_A, 0,0,"magnetite").setUnlocalizedName("magnetiteHelmet").setTextureName("spiritoresmod:magnetiteHelmet");
		magnetiteChestplate = new SpiritArmor(magnetiteChestplateId, MAGNETITE_A,0,1, "magnetite").setUnlocalizedName("magnetiteChestplate").setTextureName("spiritoresmod:magnetiteChestplate");
		magnetiteLeggings = new SpiritArmor(magnetiteBootsId, MAGNETITE_A, 0,2, "magnetite").setUnlocalizedName("magnetiteLeggings").setTextureName("spiritoresmod:magnetiteLeggings");
		magnetiteBoots = new SpiritArmor(magnetiteBootsId, MAGNETITE_A, 0,3, "magnetite").setUnlocalizedName("magnetiteBoots").setTextureName("spiritoresmod:magnetiteBoots");
		
		magmaSpiritHelmet = new SpiritArmor(magmaSpiritedHelmetId, MAGMASPIRIT_A , 0,0,"magmaSpirit").setUnlocalizedName("magmaSpiritHelmet").setTextureName("spiritoresmod:magmaSpiritHelmet");
		magmaSpiritChestplate = new SpiritArmor(magmaSpiritedChestplateId, MAGMASPIRIT_A,0,1,"magmaSpirit").setUnlocalizedName("magmaSpiritChestplate").setTextureName("spiritoresmod:magmaSpiritChestplate");
		magmaSpiritLeggings = new SpiritArmor(magmaSpiritedLeggingsId, MAGMASPIRIT_A,0,2,"magmaSpirit").setUnlocalizedName("magmaSpiritLeggings").setTextureName("spiritoresmod:magmaSpiritLeggings");
		magmaSpiritBoots = new SpiritArmor(magmaSpiritedBootsId, MAGMASPIRIT_A,0,3,"magmaSpirit").setUnlocalizedName("magmaSpiritBoots").setTextureName("spiritoresmod:magmaSpiritBoots");
		
		iriditeHelmet = new SpiritArmor(iriditeHelmetId, IRIDITE_A, 0,0,"iridite").setUnlocalizedName("iriditeHelmet").setTextureName("spiritoresmod:iriditeHelmet");
		iriditeChestplate = new SpiritArmor(iriditeChestplateId, IRIDITE_A, 0,1,"iridite").setUnlocalizedName("iriditeChestplate").setTextureName("spiritoresmod:iriditeChestplate");
		iriditeLeggings = new SpiritArmor(iriditeLeggingsId,IRIDITE_A,0,2,"iridite").setUnlocalizedName("iriditeLeggings").setTextureName("spiritoresmod:iriditeLeggings");
		iriditeBoots = new SpiritArmor(iriditeBootsId, IRIDITE_A,0,3,"iridite").setUnlocalizedName("iriditeBoots").setTextureName("spiritoresmod:iriditeBoots");
		
		lilithiteHelmet = new SpiritArmor(lilithiteHelmetId, LILITHITE_A, 0,0, "lilithite").setUnlocalizedName("lilithiteHelmet").setTextureName("spiritoresmod:lilithiteHelmet");
		lilithiteChestplate = new SpiritArmor(lilithiteChestplateId, LILITHITE_A,0,1,"lilithite").setUnlocalizedName("lilithiteChestplate").setTextureName("spiritoresmod:lilithiteChestplate");
		lilithiteLeggings = new SpiritArmor(lilithiteLeggingsId, LILITHITE_A,0,2,"lilithite").setUnlocalizedName("lilithiteLeggings").setTextureName("spiritoresmod:lilithiteLeggings");
		lilithiteBoots = new SpiritArmor(lilithiteBootsId, LILITHITE_A,0,3,"lilithite").setUnlocalizedName("lilithiteBoots").setTextureName("spiritoresmod:lilithiteBoots");
		
		enderSpiritHelmet = new SpiritArmor(enderSpiritedHelmetId, ENDERSPIRIT_A,0,0,"enderSpirit").setUnlocalizedName("enderSpiritHelmet").setTextureName("spiritoresmod:enderSpiritHelmet");
		enderSpiritChestplate = new SpiritArmor(enderSpiritedChestplateId, ENDERSPIRIT_A,0,1,"enderSpirit").setUnlocalizedName("enderSpiritChestplate").setTextureName("spiritoresmod:enderSpiritChestplate");
		enderSpiritLeggings = new SpiritArmor(enderSpiritedLeggingsId, ENDERSPIRIT_A,0,2,"enderSpirit").setUnlocalizedName("enderSpiritLeggings").setTextureName("spiritoresmod:enderSpiritLeggings");
		enderSpiritBoots = new SpiritArmor(enderSpiritedBootsId, ENDERSPIRIT_A,0,3, "enderSpirit").setUnlocalizedName("enderSpiritBoots").setTextureName("spiritoresmod:enderSpiritBoots");
		
		teleniumHelmet = new SpiritArmor(teleniumHelmetId, TELENIUM_A,0,0,"telenium").setUnlocalizedName("teleniumHelmet").setTextureName("spiritoresmod:teleniumHelmet");
		teleniumChestplate = new SpiritArmor(teleniumChestplateId, TELENIUM_A,0,1,"telenium").setUnlocalizedName("teleniumChestplate").setTextureName("spiritoresmod:teleniumChestplate");
		teleniumLeggings = new SpiritArmor(teleniumLeggingsId, TELENIUM_A,0,2,"telenium").setUnlocalizedName("teleniumLeggings").setTextureName("spiritoresmod:teleniumLeggings");
		teleniumBoots = new SpiritArmor(teleniumBootsId, TELENIUM_A,0,3,"telenium").setUnlocalizedName("teleniumBoots").setTextureName("spiritoresmod:teleniumBoots");
		
		dimensionForgedHelmet = new SpiritArmor(dimensionForgedHelmetId, DIMENSIONFORGED_A,0,0,"dimensionForged").setUnlocalizedName("dimensionForgedHelmet").setTextureName("spiritoresmod:dimensionForgedHelmet");
		dimensionForgedChestplate = new SpiritArmor(dimensionForgedChestplateId, DIMENSIONFORGED_A,0,1,"dimensionForged").setUnlocalizedName("dimensionForgedChestplate").setTextureName("spiritoresmod:dimensionForgedChestplate");
		dimensionForgedLeggings = new SpiritArmor(dimensionForgedLeggingsId, DIMENSIONFORGED_A,0,2,"dimensionForged").setUnlocalizedName("dimensionForgedLeggings").setTextureName("spiritoresmod:dimensionForgedLeggings");
		dimensionForgedBoots = new SpiritArmor(dimensionForgedBootsId, DIMENSIONFORGED_A,0,3, "dimensionForged").setUnlocalizedName("dimensionForgedBoots").setTextureName("spiritoresmod:dimensionForgedBoots");
		
		
		aluminumOre = new SpiritOre(aluminumOreId,Material.iron, 1){
			public String getUnlocalizedName() {
				return "tile.aluminumOre";
			}
		}.setHardness(4.0f).setBlockTextureName("spiritoresmod:aluminumOre");
		copperOre = new SpiritOre(copperOreId,Material.iron,1){
			public String getUnlocalizedName() {
				return "tile.copperOre";
			}
		}.setHardness(4.0F).setBlockTextureName("spiritoresmod:copperOre");
		steelOre = new SpiritOre(steelOreId,Material.anvil,2){
			public String getUnlocalizedName() {
				return "tile.steelOre";
			}
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:steelOre");
		spiritOre = new BlockSpiritOre(spiritOreId,Material.dragonEgg, 3){
			public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
		    {
		        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		        ret.add(new ItemStack(spiritIngot,1));
		        return ret;
		    }
			public String getUnlocalizedName() {
				return "tile.spiritOre";
			}
			
		}.setHardness(30.0F).setBlockTextureName("spiritoresmod:spiritOre");
		
		charredLeadOre = new SpiritOre(charredLeadOreId,Material.iron,1){
			public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
		    {
		        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		        ret.add(new ItemStack(charredLeadChunk,1));
		        return ret;
		    }
			public String getUnlocalizedName() {
				return "tile.charredLeadOre";
			}
		}.setHardness(3.5F).setBlockTextureName("spiritoresmod:charredLeadOre");
		
		amethystOre = new SpiritOre(amethystOreId,Material.anvil,2) {
			public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
		    {
		        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		        ret.add(new ItemStack(amethystGem,1));
		        return ret;
		    }
			public String getUnlocalizedName() {
				return "tile.amethystOre";
			}
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:amethystOre");
		
		magnetiteOre = new SpiritOre(magnetiteOreId, Material.iron,1){
			public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
		    {
		        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		        ret.add(new ItemStack(magnetiteChunk,1));
		        return ret;
		    }
			public String getUnlocalizedName() {
				return "tile.magnetiteOre";
			}
		}.setHardness(4.0f).setBlockTextureName("spiritoresmod:magnetiteOre");
		
		magmaSpiritOre = new BlockSpiritOre(magmaSpiritOreId,Material.dragonEgg,4) {
			public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
		    {
		        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		        ret.add(new ItemStack(magmaSpiritCrystal,1));
		        return ret;
		    }
			public String getUnlocalizedName() {
				return "tile.magmaSpiritOre";
			}
		}.setHardness(35.0f).setBlockTextureName("spiritoresmod:magmaSpiritOre");
		
		iriditeOre = new SpiritOre(iriditeOreId, Material.rock,2) {
			public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
		    {
		        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		        ret.add(new ItemStack(iriditeShard,1));
		        return ret;
		    }
			public String getUnlocalizedName() {
				return "tile.iriditeOre";
			}
		}.setHardness(6.5f).setBlockTextureName("spiritoresmod:iriditeOre");
		
		lilithiteOre = new SpiritOre(lilithiteOreId, Material.rock,3) {
			public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
		    {
		        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		        ret.add(new ItemStack(lilithiteGem,1));
		        return ret;
		    }
			public String getUnlocalizedName() {
				return "tile.lilithiteOre";
			}
		}.setHardness(7.0f).setBlockTextureName("spiritoresmod:lilithiteOre");
		
		enderspiritOre = new BlockSpiritOre(enderSpiritOreId, Material.rock,5) {
			public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
		    {
		        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		        ret.add(new ItemStack(enderSpiritCrystal,1));
		        return ret;
		    }
			public String getUnlocalizedName() {
				return "tile.enderSpiritOre";
			}
		}.setHardness(8.0f).setBlockTextureName("spiritoresmod:enderspiritOre");
		
		teleniumOre = new SpiritOre(teleniumOreId, Material.rock,3){
			public String getUnlocalizedName() {
				return "tile.teleniumOre";
			}
		}.setHardness(4.5f).setBlockTextureName("spiritoresmod:teleniumOre");
		
		aluminumBlock = new SpiritOre(aluminumBlockId,Material.iron,1){
			public String getUnlocalizedName() {
				return "tile.aluminumBlock";
			}
			
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:aluminumBlock");
		copperBlock = new SpiritOre(copperBlockId,Material.iron,1){
			public String getUnlocalizedName() {
				return "tile.copperBlock";
			}
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:copperBlock");
		steelBlock = new SpiritOre(steelBlockId,Material.iron,2){
			public String getUnlocalizedName() {
				return "tile.steelBlock";
			}
		}.setHardness(8.0F).setBlockTextureName("spiritoresmod:steelBlock");
		spiritStone = new SpiritOre(spiritStoneId,Material.glass,-1){
			public String getUnlocalizedName() {
				return "tile.spiritStone";
			}
		}.setLightLevel(0.8f).setHardness(0.4F).setBlockTextureName("spiritoresmod:spiritStone");
		spiritedBlock = new SpiritOre(spiritedBlockId,Material.dragonEgg,3){
			public String getUnlocalizedName() {
				return "tile.spiritedBlock";
			}
		}.setLightLevel(0.6f).setHardness(40.0F).setBlockTextureName("spiritoresmod:spiritedBlock");
		charredLeadBlock = new SpiritOre(charredLeadBlockId, Material.iron,1){
			public String getUnlocalizedName() {
				return "tile.charredLeadBlock";
			}
		}.setHardness(5.5F).setBlockTextureName("spiritoresmod:charredLeadBlock");
		amethystBlock = new SpiritOre(amethystBlockId, Material.anvil,2){
			public String getUnlocalizedName() {
				return "tile.amethystBlock";
			}
		}.setHardness(6.5F).setBlockTextureName("spiritoresmod:amethystBlock");
		magnetiteBlock = new SpiritOre(magnetiteBlockId, Material.iron,1){
			public String getUnlocalizedName() {
				return "tile.magnetiteBlock";
			}
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:magnetiteBlock");
		magmaSpiritBlock = new SpiritOre(magmaSpiritedBlockId, Material.dragonEgg,4) {
			public String getUnlocalizedName() {
				return "tile.magmaSpiritBlock";
			}
		}.setHardness(36.0f).setLightLevel(0.8f).setBlockTextureName("spiritoresmod:magmaSpiritBlock");
		iriditeBlock = new SpiritOre(iriditeBlockId, Material.anvil,2){
			public String getUnlocalizedName() {
				return "tile.iriditeBlock";
			}
		}.setHardness(7.0F).setBlockTextureName("spiritoresmod:iriditeBlock");
		lilithiteBlock = new SpiritOre(lilithiteBlockId, Material.anvil,3){
			public String getUnlocalizedName() {
				return "tile.lilithiteBlock";
			}
		}.setHardness(7.5f).setBlockTextureName("spiritoresmod:lilithiteBlock");
		enderSpiritBlock = new SpiritOre(enderSpiritedBlockId, Material.dragonEgg,5){
			public String getUnlocalizedName() {
				return "tile.enderSpiritBlock";
			}
		}.setHardness(8.5f).setLightLevel(0.8f).setBlockTextureName("spiritoresmod:enderSpiritBlock");
		teleniumBlock = new SpiritOre(teleniumBlockId, Material.anvil,3){
			public String getUnlocalizedName() {
				return "tile.teleniumBlock";
			}
		}.setHardness(5.0f).setBlockTextureName("spiritoresmod:teleniumBlock");
		dimensionForgedBlock = new SpiritOre(dimensionForgedBlockId, Material.dragonEgg,6){
			public String getUnlocalizedName() {
				return "tile.dimensionForgedBlock";
			}
		}.setHardness(10.0f).setLightLevel(1.0f).setBlockTextureName("spiritoresmod:dimensionForgedBlock");
		
		aluminumFence = new SpiritFence(aluminumFenceId,Material.iron,"aluminum",1){
			public String getUnlocalizedName() {
				return "tile.aluminumFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return aluminumBlock.getIcon(par2, par2);
		    }
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:aluminumBlock");
		copperFence = new SpiritFence(copperFenceId,Material.iron,"copper",1){
			public String getUnlocalizedName() {
				return "tile.copperFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return copperBlock.getIcon(par2, par2);
		    }
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:copperBlock");
		steelFence = new SpiritFence(steelFenceId,Material.iron,"steel",2){
			public String getUnlocalizedName() {
				return "tile.steelFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return steelBlock.getIcon(par2, par2);
		    }
		}.setHardness(8.0F).setBlockTextureName("spiritoresmod:steelBlock");
		spiritedFence = new SpiritFence(spiritedFenceId,Material.dragonEgg,"spirited",3){
			public String getUnlocalizedName() {
				return "tile.spiritedFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return spiritedBlock.getIcon(par2, par2);
		    }
		}.setLightLevel(0.6f).setHardness(40.0f).setBlockTextureName("spiritoresmod:spiritedBlock");
		charredLeadFence = new SpiritFence(charredLeadFenceId, Material.iron, "charredLead",1){
			public String getUnlocalizedName() {
				return "tile.charredLeadFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return charredLeadBlock.getIcon(par2, par2);
		    }
		}.setHardness(5.5F).setBlockTextureName("spiritoresmod:charredLeadBlock");
		amethystFence = new SpiritFence(amethystFenceId, Material.anvil, "amethyst",2){
			public String getUnlocalizedName() {
				return "tile.amethystFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return amethystBlock.getIcon(par2, par2);
		    }
		}.setHardness(6.5F).setBlockTextureName("spiritoresmod:amethystBlock");
		magnetiteFence = new SpiritFence(magnetiteFenceId, Material.iron, "magnetite",1){
			public String getUnlocalizedName() {
				return "tile.magnetiteFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return magnetiteBlock.getIcon(par2, par2);
		    }
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:magnetiteBlock");
		magmaSpiritFence = new SpiritFence(magmaSpiritedFenceId, Material.dragonEgg, "magmaSpirit",4){
			public String getUnlocalizedName() {
				return "tile.magmaSpiritFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return magmaSpiritBlock.getIcon(par2, par2);
		    }
		}.setHardness(36.0f).setLightLevel(0.8f).setBlockTextureName("spiritoresmod:magmaSpiritBlock");
		iriditeFence = new SpiritFence(iriditeFenceId, Material.anvil, "iridite",2){
			public String getUnlocalizedName() {
				return "tile.iriditeFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return iriditeBlock.getIcon(par2, par2);
		    }
		}.setHardness(7.0F).setBlockTextureName("spiritoresmod:iriditeBlock");
		lilithiteFence = new SpiritFence(lilithiteFenceId, Material.anvil, "lilithite",3){
			public String getUnlocalizedName() {
				return "tile.lilithiteFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return lilithiteBlock.getIcon(par2, par2);
		    }
		}.setHardness(7.5f).setBlockTextureName("spiritoresmod:lilithiteBlock");
		enderSpiritFence = new SpiritFence(enderSpiritedFenceId, Material.dragonEgg, "enderSpirit",5){
			public String getUnlocalizedName() {
				return "tile.enderSpiritFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return enderSpiritBlock.getIcon(par2, par2);
		    }
		}.setHardness(8.5f).setLightLevel(0.8f).setBlockTextureName("spiritoresmod:enderSpiritBlock");
		teleniumFence = new SpiritFence(teleniumFenceId, Material.anvil, "telenium",3){
			public String getUnlocalizedName() {
				return "tile.teleniumFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return teleniumBlock.getIcon(par2, par2);
		    }
		}.setHardness(5.0f).setBlockTextureName("spiritoresmod:teleniumBlock");
		dimensionForgedFence = new SpiritFence(dimensionForgedFenceId, Material.dragonEgg, "dimensionForged",6){
			public String getUnlocalizedName() {
				return "tile.dimensionForgedFence";
			}
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return dimensionForgedBlock.getIcon(par2, par2);
		    }
		}.setHardness(10.0f).setLightLevel(1.0f).setBlockTextureName("spiritoresmod:dimensionForgedBlock");
		
		aluminumFenceGate = new SpiritFenceGate(1){
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
		    {
				return aluminumBlock.getBlockTextureFromSide(par1);
		    }
			public String getUnlocalizedName() {
				return "tile.aluminumFenceGate";
			}
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:aluminumBlock").setCreativeTab(tabSpiritOres);
		copperFenceGate = new SpiritFenceGate(1){
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
			{
				return copperBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.copperFenceGate";
			}
		}.setHardness(6.0F).setBlockTextureName("spiritoresmod:copperBlock").setCreativeTab(tabSpiritOres);
		steelFenceGate = new SpiritFenceGate(2){
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
			{
				return steelBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.steelFenceGate";
			}
		}.setHardness(8.0F).setBlockTextureName("spiritoresmod:steelBlock").setCreativeTab(tabSpiritOres);
		spiritedFenceGate = new SpiritFenceGate(3){
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
			{
				return spiritedBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.spiritedFenceGate";
			}
		}.setLightLevel(0.6f).setHardness(40.0f).setBlockTextureName("spiritoresmod:spiritedBlock").setCreativeTab(tabSpiritOres);
		charredLeadFenceGate = new SpiritFenceGate(1){
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
			{
				return charredLeadBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.charredLeadFenceGate";
			}
		}.setHardness(5.5f).setBlockTextureName("spiritoresmod:charredLeadBlock").setCreativeTab(tabSpiritOres);
		amethystFenceGate = new SpiritFenceGate(2) {
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
			{
				return amethystBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.amethystFenceGate";
			}
		}.setHardness(6.5f).setCreativeTab(tabSpiritOres);
		magnetiteFenceGate = new SpiritFenceGate(1) {
			@SideOnly(Side.CLIENT)
			public IIcon getIcon(int par1, int par2)
			{
				return magnetiteBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.magnetiteFenceGate";
			}
		}.setHardness(6.0f).setCreativeTab(tabSpiritOres);
		magmaSpiritFenceGate = new SpiritFenceGate(4) {
			public IIcon getIcon(int par1, int par2) {
				return magmaSpiritBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.magmaSpiritFenceGate";
			}
		}.setHardness(36.0f).setCreativeTab(tabSpiritOres).setLightLevel(0.8f);
		iriditeFenceGate = new SpiritFenceGate(2) {
			public IIcon getIcon(int par1, int par2) {
				return iriditeBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.iriditeFenceGate";
			}
		}.setHardness(7.0f).setCreativeTab(tabSpiritOres);
		lilithiteFenceGate = new SpiritFenceGate(3) {
			public IIcon getIcon(int par1, int par2) {
				return lilithiteBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.lilithiteFenceGate";
			}
		}.setHardness(7.5f).setCreativeTab(tabSpiritOres);
		enderSpiritFenceGate = new SpiritFenceGate(5) {
			public IIcon getIcon(int par1, int par2) {
				return enderSpiritBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.enderSpiritFenceGate";
			}
		}.setHardness(8.5f).setCreativeTab(tabSpiritOres).setLightLevel(0.8f);
		teleniumFenceGate = new SpiritFenceGate(3) {
			public IIcon getIcon(int par1, int par2) {
				return teleniumBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.teleniumFenceGate";
			}
		}.setHardness(5.0f).setCreativeTab(tabSpiritOres);
		dimensionForgedFenceGate = new SpiritFenceGate(6) {
			public IIcon getIcon(int par1, int par2) {
				return dimensionForgedBlock.getBlockTextureFromSide(par1);
			}
			public String getUnlocalizedName() {
				return "tile.dimensionForgedFenceGate";
			}
		}.setHardness(10.0f).setLightLevel(1.0f).setCreativeTab(tabSpiritOres);
		
		//other stuffs
		
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabSpiritOres", "en_US", "SpiritOres");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabSpiritOres", "en_CA", "SpiritOres");
		
		LanguageRegistry.addName(aluminumIngot, "Aluminum Ingot");
		LanguageRegistry.addName(copperIngot, "Copper Ingot");
		LanguageRegistry.addName(steelIngot, "Steel Ingot");
		LanguageRegistry.addName(spiritIngot, "Spirit Crystal");
		LanguageRegistry.addName(spiritedIngot, "Spirited Ingot");
		LanguageRegistry.addName(charredLeadChunk, "Charred Lead Chunk");
		LanguageRegistry.addName(amethystGem, "Amethyst Gem");
		LanguageRegistry.addName(magnetiteChunk, "Magnetite Chunk");
		LanguageRegistry.addName(magmaSpiritCrystal, "Magma Spirit Crystal");
		LanguageRegistry.addName(magmaSpiritIngot, "Magma Spirited Ingot");
		LanguageRegistry.addName(iriditeShard, "Iridite Shard");
		LanguageRegistry.addName(lilithiteGem, "Lilithite Gem");
		LanguageRegistry.addName(enderSpiritCrystal, "Ender Spirit Crystal");
		LanguageRegistry.addName(enderSpiritIngot, "Ender Spirited Ingot");
		LanguageRegistry.addName(teleniumIngot, "Telenium Ingot");
		LanguageRegistry.addName(dimensionForgedIngot, "Dimensionforged Ingot");
		
		OreDictionary.registerOre("ingotAluminum", aluminumIngot);
		OreDictionary.registerOre("ingotCopper",copperIngot);
		OreDictionary.registerOre("ingotSteel", steelIngot);
		OreDictionary.registerOre("crystalSpirit",spiritIngot);
		OreDictionary.registerOre("ingotSpirited",spiritedIngot);
		OreDictionary.registerOre("ingotCharredLead", charredLeadChunk);
		OreDictionary.registerOre("gemAmethyst",amethystGem);
		OreDictionary.registerOre("ingotMagnetite",magnetiteChunk);
		OreDictionary.registerOre("crystalMagmaSpirit",magmaSpiritCrystal);
		OreDictionary.registerOre("ingotMagmaSpirited", magmaSpiritIngot);
		OreDictionary.registerOre("shardIridite",iriditeShard);
		OreDictionary.registerOre("gemLilithite",lilithiteGem);
		OreDictionary.registerOre("crystalEnderSpirit", enderSpiritCrystal);
		OreDictionary.registerOre("ingotEnderSpirited",enderSpiritIngot);
		OreDictionary.registerOre("ingotDimensionForged",dimensionForgedIngot);
		
		LanguageRegistry.addName(aluminumPickaxe, "Aluminum Pickaxe");
		LanguageRegistry.addName(copperPickaxe, "Copper Pickaxe");
		LanguageRegistry.addName(steelPickaxe, "Steel Pickaxe");
		LanguageRegistry.addName(spiritedPickaxe, "Spirited Pickaxe");
		LanguageRegistry.addName(charredLeadPickaxe, "Charred Lead Pickaxe");
		LanguageRegistry.addName(amethystPickaxe, "Amethyst Pickaxe");
		LanguageRegistry.addName(magnetitePickaxe, "Magnetite Pickaxe");
		LanguageRegistry.addName(magmaSpiritPickaxe, "Magma Spirited Pickaxe");
		LanguageRegistry.addName(iriditePickaxe, "Iridite Pickaxe");
		LanguageRegistry.addName(lilithitePickaxe, "Lilithite Pickaxe");
		LanguageRegistry.addName(enderspiritPickaxe, "Ender Spirit Pickaxe");
		LanguageRegistry.addName(teleniumPickaxe, "Telenium Pickaxe");
		LanguageRegistry.addName(dimensionForgedPickaxe, "Dimensionforged Pickaxe");
		
		LanguageRegistry.addName(aluminumAxe, "Aluminum Axe");
		LanguageRegistry.addName(copperAxe, "Copper Axe");
		LanguageRegistry.addName(steelAxe, "Steel Axe");
		LanguageRegistry.addName(spiritedAxe, "Spirited Axe");
		LanguageRegistry.addName(charredLeadAxe, "Charred Lead Axe");
		LanguageRegistry.addName(amethystAxe, "Amethyst Axe");
		LanguageRegistry.addName(magnetiteAxe, "Magnetite Axe");
		LanguageRegistry.addName(magmaSpiritAxe, "Magma Spirited Axe");
		LanguageRegistry.addName(iriditeAxe, "Iridite Axe");
		LanguageRegistry.addName(lilithiteAxe, "Lilithite Axe");
		LanguageRegistry.addName(enderspiritAxe, "Ender Spirit Axe");
		LanguageRegistry.addName(teleniumAxe, "Telenium Axe");
		LanguageRegistry.addName(dimensionForgedAxe, "Dimensionforged Axe");
		
		LanguageRegistry.addName(aluminumShovel, "Aluminum Shovel");
		LanguageRegistry.addName(copperShovel, "Copper Shovel");
		LanguageRegistry.addName(steelShovel, "Steel Shovel");
		LanguageRegistry.addName(spiritedShovel, "Spirited Shovel");
		LanguageRegistry.addName(charredLeadShovel, "Charred Lead Shovel");
		LanguageRegistry.addName(amethystShovel, "Amethyst Shovel");
		LanguageRegistry.addName(magnetiteShovel, "Magnetite Shovel");
		LanguageRegistry.addName(magmaSpiritShovel, "Magma Spirited Shovel");
		LanguageRegistry.addName(iriditeShovel, "Iridite Shovel");
		LanguageRegistry.addName(lilithiteShovel, "Lilithite Shovel");
		LanguageRegistry.addName(enderspiritShovel, "Ender Spirit Shovel");
		LanguageRegistry.addName(teleniumShovel, "Telenium Shovel");
		LanguageRegistry.addName(dimensionForgedShovel, "Dimensionforged Shovel");
		
		LanguageRegistry.addName(aluminumHoe, "Aluminum Hoe");
		LanguageRegistry.addName(copperHoe, "Copper Hoe");
		LanguageRegistry.addName(steelHoe, "Steel Hoe");
		LanguageRegistry.addName(spiritedHoe, "Spirited Hoe");
		LanguageRegistry.addName(charredLeadHoe, "Charred Lead Hoe");
		LanguageRegistry.addName(amethystHoe, "Amethyst Hoe");
		LanguageRegistry.addName(magnetiteHoe, "Magnetite Hoe");
		LanguageRegistry.addName(magmaSpiritHoe, "Magma Spirited Hoe");
		LanguageRegistry.addName(iriditeHoe, "Iridite Hoe");
		LanguageRegistry.addName(lilithiteHoe, "Lilithite Hoe");
		LanguageRegistry.addName(enderspiritHoe, "Ender Spirit Hoe");
		LanguageRegistry.addName(teleniumHoe, "Telenium Hoe");
		LanguageRegistry.addName(dimensionForgedHoe, "Dimensionforged Hoe");
		
		LanguageRegistry.addName(aluminumSword, "Aluminum Sword");
		LanguageRegistry.addName(copperSword, "Copper Sword");
		LanguageRegistry.addName(steelSword, "Steel Sword");
		LanguageRegistry.addName(spiritedSword, "Spirited Sword");
		LanguageRegistry.addName(charredLeadSword, "Charred Lead Sword");
		LanguageRegistry.addName(amethystSword, "Amethyst Sword");
		LanguageRegistry.addName(magnetiteSword, "Magnetite Sword");
		LanguageRegistry.addName(magmaSpiritSword, "Magma Spirited Sword");
		LanguageRegistry.addName(iriditeSword, "Iridite Sword");
		LanguageRegistry.addName(lilithiteSword, "Lilithite Sword");
		LanguageRegistry.addName(enderspiritSword, "Ender Spirit Sword");
		LanguageRegistry.addName(teleniumSword, "Telenium Sword");
		LanguageRegistry.addName(dimensionForgedSword, "Dimensionforged Sword");
		
		LanguageRegistry.addName(aluminumDartGun, "Aluminum Dart Gun");
		LanguageRegistry.addName(spiritedDartGun, "Spirited Dart Gun");
		LanguageRegistry.addName(amethystDartGun, "Amethyst Dart Gun");
		LanguageRegistry.addName(magmaSpiritDartGun, "Magma Spirit Dart Gun");
		LanguageRegistry.addName(basicDartGun, "Dart Gun");
		LanguageRegistry.addName(enderspiritDartGun, "Ender Spirit Dart Gun");
		LanguageRegistry.addName(teleniumDartGun, "Telenium Dart Gun");
		LanguageRegistry.addName(dimensionForgedDartGun, "Dimensionforged Dart Gun");
		
		LanguageRegistry.addName(aluminumHelmet, "Aluminum Helmet");
		LanguageRegistry.addName(aluminumChestplate, "Aluminum Chestplate");
		LanguageRegistry.addName(aluminumLeggings, "Aluminum Leggings");
		LanguageRegistry.addName(aluminumBoots, "Aluminum Boots");
		
		LanguageRegistry.addName(copperHelmet, "Copper Helmet");
		LanguageRegistry.addName(copperChestplate, "Copper Chestplate");
		LanguageRegistry.addName(copperLeggings, "Copper Leggings");
		LanguageRegistry.addName(copperBoots, "Copper Boots");
		
		LanguageRegistry.addName(steelHelmet, "Steel Helmet");
		LanguageRegistry.addName(steelChestplate, "Steel Chestplate");
		LanguageRegistry.addName(steelLeggings, "Steel Leggings");
		LanguageRegistry.addName(steelBoots, "Steel Boots");
		
		LanguageRegistry.addName(spiritedHelmet, "Spirited Helmet");
		LanguageRegistry.addName(spiritedChestplate, "Spirited Chestplate");
		LanguageRegistry.addName(spiritedLeggings,"Spirited Leggings");
		LanguageRegistry.addName(spiritedBoots, "Spirited Boots");
		
		LanguageRegistry.addName(charredLeadHelmet, "Charred Lead Helmet");
		LanguageRegistry.addName(charredLeadChestplate, "Charred Lead Chestplate");
		LanguageRegistry.addName(charredLeadLeggings, "Charred Lead Leggings");
		LanguageRegistry.addName(charredLeadBoots, "Charred Lead Boots");
		
		LanguageRegistry.addName(amethystHelmet, "Amethyst Helmet");
		LanguageRegistry.addName(amethystChestplate, "Amethyst Chestplate");
		LanguageRegistry.addName(amethystLeggings, "Amethyst Leggings");
		LanguageRegistry.addName(amethystBoots, "Amethyst Boots");
		
		LanguageRegistry.addName(magnetiteHelmet, "Magnetite Helmet");
		LanguageRegistry.addName(magnetiteChestplate, "Magnetite Chestplate");
		LanguageRegistry.addName(magnetiteLeggings, "Magnetite Leggings");
		LanguageRegistry.addName(magnetiteBoots, "Magnetite Boots");
		
		LanguageRegistry.addName(magmaSpiritHelmet, "Magma Spirited Helmet");
		LanguageRegistry.addName(magmaSpiritChestplate, "Magma Spirited Chestplate");
		LanguageRegistry.addName(magmaSpiritLeggings, "Magma Spirited Leggings");
		LanguageRegistry.addName(magmaSpiritBoots, "Magma Spirited Boots");
		
		LanguageRegistry.addName(iriditeHelmet, "Iridite Helmet");
		LanguageRegistry.addName(iriditeChestplate, "Iridite Chestplate");
		LanguageRegistry.addName(iriditeLeggings, "Iridite Leggings");
		LanguageRegistry.addName(iriditeBoots, "Iridite Boots");
		
		LanguageRegistry.addName(lilithiteHelmet, "Lilithite Helmet");
		LanguageRegistry.addName(lilithiteChestplate, "Lilithite Chestplate");
		LanguageRegistry.addName(lilithiteLeggings, "Lilithite Leggings");
		LanguageRegistry.addName(lilithiteBoots, "Lilithite Boots");
		
		LanguageRegistry.addName(enderSpiritHelmet, "Ender Spirit Helmet");
		LanguageRegistry.addName(enderSpiritChestplate,"Ender Spirit Chestplate");
		LanguageRegistry.addName(enderSpiritLeggings, "Ender Spirit Leggings");
		LanguageRegistry.addName(enderSpiritBoots, "Ender Spirit Boots");
		
		LanguageRegistry.addName(teleniumHelmet, "Telenium Helmet");
		LanguageRegistry.addName(teleniumChestplate, "Telenium Chestplate");
		LanguageRegistry.addName(teleniumLeggings, "Telenium Leggings");
		LanguageRegistry.addName(teleniumBoots, "Telenium Boots");
		
		LanguageRegistry.addName(dimensionForgedHelmet, "Dimensionforged Helmet");
		LanguageRegistry.addName(dimensionForgedChestplate, "Dimensionforged Chestplate");
		LanguageRegistry.addName(dimensionForgedLeggings, "Dimensionforged Leggings");
		LanguageRegistry.addName(dimensionForgedBoots, "Dimensionforged Boots");
		
		//ingots
		GameRegistry.registerItem(aluminumIngot, "aluminumIngot");
		GameRegistry.registerItem(copperIngot,"copperIngot");
		GameRegistry.registerItem(steelIngot,"steelIngot");
		GameRegistry.registerItem(spiritIngot,"spiritIngot");
		GameRegistry.registerItem(spiritedIngot,"spiritedIngot");
		GameRegistry.registerItem(charredLeadChunk,"charredLeadChunk");
		GameRegistry.registerItem(amethystGem,"amethystGem");
		GameRegistry.registerItem(magnetiteChunk,"magnetiteChunk");
		GameRegistry.registerItem(magmaSpiritCrystal,"magmaSpiritCrystal");
		GameRegistry.registerItem(magmaSpiritIngot,"magmaSpiritIngot");
		GameRegistry.registerItem(iriditeShard,"iriditeShard");
		GameRegistry.registerItem(lilithiteGem,"lilithiteGem");
		GameRegistry.registerItem(teleniumIngot,"teleniumIngot");
		GameRegistry.registerItem(enderSpiritCrystal,"enderSpiritCrystal");
		GameRegistry.registerItem(enderSpiritIngot, "enderSpiritIngot");
		GameRegistry.registerItem(dimensionForgedIngot,"dimensionForgedIngot");
		
		//picks
		GameRegistry.registerItem(aluminumPickaxe,"aluminumPickaxe");
		GameRegistry.registerItem(copperPickaxe,"copperPickaxe");
		GameRegistry.registerItem(steelPickaxe,"steelPickaxe");
		GameRegistry.registerItem(spiritedPickaxe,"spiritedPickaxe");
		GameRegistry.registerItem(charredLeadPickaxe,"charredLeadPickaxe");
		GameRegistry.registerItem(amethystPickaxe,"amethystPickaxe");
		GameRegistry.registerItem(magnetitePickaxe,"magnetitePickaxe");
		GameRegistry.registerItem(magmaSpiritPickaxe,"magmaSpiritPickaxe");
		GameRegistry.registerItem(iriditePickaxe,"iriditePickaxe");
		GameRegistry.registerItem(lilithitePickaxe,"lilithitePickaxe");
		GameRegistry.registerItem(teleniumPickaxe,"teleniumPickaxe");
		GameRegistry.registerItem(enderspiritPickaxe, "enderspiritPickaxe");
		GameRegistry.registerItem(dimensionForgedPickaxe,"dimensionForgedPickaxe");
		
		//axes
		GameRegistry.registerItem(aluminumAxe,"aluminumAxe");
		GameRegistry.registerItem(copperAxe,"copperAxe");
		GameRegistry.registerItem(steelAxe,"steelAxe");
		GameRegistry.registerItem(spiritedAxe,"spiritedAxe");
		GameRegistry.registerItem(charredLeadAxe,"charredLeadAxe");
		GameRegistry.registerItem(amethystAxe,"amethystAxe");
		GameRegistry.registerItem(magnetiteAxe,"magnetiteAxe");
		GameRegistry.registerItem(magmaSpiritAxe,"magmaSpiritAxe");
		GameRegistry.registerItem(iriditeAxe,"iriditeAxe");
		GameRegistry.registerItem(lilithiteAxe,"lilithiteAxe");
		GameRegistry.registerItem(teleniumAxe,"teleniumAxe");
		GameRegistry.registerItem(enderspiritAxe, "enderspiritAxe");
		GameRegistry.registerItem(dimensionForgedAxe,"dimensionForgedAxe");
		
		//shovels
		GameRegistry.registerItem(aluminumShovel,"aluminumShovel");
		GameRegistry.registerItem(copperShovel,"copperShovel");
		GameRegistry.registerItem(steelShovel,"steelShovel");
		GameRegistry.registerItem(spiritedShovel,"spiritedShovel");
		GameRegistry.registerItem(charredLeadShovel,"charredLeadShovel");
		GameRegistry.registerItem(amethystShovel,"amethystShovel");
		GameRegistry.registerItem(magnetiteShovel,"magnetiteShovel");
		GameRegistry.registerItem(magmaSpiritShovel,"magmaSpiritShovel");
		GameRegistry.registerItem(iriditeShovel,"iriditeShovel");
		GameRegistry.registerItem(lilithiteShovel,"lilithiteShovel");
		GameRegistry.registerItem(teleniumShovel,"teleniumShovel");
		GameRegistry.registerItem(enderspiritShovel, "enderspiritShovel");
		GameRegistry.registerItem(dimensionForgedShovel,"dimensionForgedShovel");
		
		//hoes
		GameRegistry.registerItem(aluminumHoe,"aluminumHoe");
		GameRegistry.registerItem(copperHoe,"copperHoe");
		GameRegistry.registerItem(steelHoe,"steelHoe");
		GameRegistry.registerItem(spiritedHoe,"spiritedHoe");
		GameRegistry.registerItem(charredLeadHoe,"charredLeadHoe");
		GameRegistry.registerItem(amethystHoe,"amethystHoe");
		GameRegistry.registerItem(magnetiteHoe,"magnetiteHoe");
		GameRegistry.registerItem(magmaSpiritHoe,"magmaSpiritHoe");
		GameRegistry.registerItem(iriditeHoe,"iriditeHoe");
		GameRegistry.registerItem(lilithiteHoe,"lilithiteHoe");
		GameRegistry.registerItem(teleniumHoe,"teleniumHoe");
		GameRegistry.registerItem(enderspiritHoe, "enderspiritHoe");
		GameRegistry.registerItem(dimensionForgedHoe,"dimensionForgedHoe");
		
		//swords
		GameRegistry.registerItem(aluminumSword,"aluminumSword");
		GameRegistry.registerItem(copperSword,"copperSword");
		GameRegistry.registerItem(steelSword,"steelSword");
		GameRegistry.registerItem(spiritedSword,"spiritedSword");
		GameRegistry.registerItem(charredLeadSword,"charredLeadSword");
		GameRegistry.registerItem(amethystSword,"amethystSword");
		GameRegistry.registerItem(magnetiteSword,"magnetiteSword");
		GameRegistry.registerItem(magmaSpiritSword,"magmaSpiritSword");
		GameRegistry.registerItem(iriditeSword,"iriditeSword");
		GameRegistry.registerItem(lilithiteSword,"lilithiteSword");
		GameRegistry.registerItem(teleniumSword,"teleniumSword");
		GameRegistry.registerItem(enderspiritSword, "enderspiritSword");
		GameRegistry.registerItem(dimensionForgedSword,"dimensionForgedSword");
		
		//dart guns
		GameRegistry.registerItem(basicDartGun, "basicDartGun");
		GameRegistry.registerItem(aluminumDartGun,"aluminumDartGun");
		GameRegistry.registerItem(spiritedDartGun,"spiritedDartGun");
		GameRegistry.registerItem(amethystDartGun,"amethystDartGun");
		GameRegistry.registerItem(magmaSpiritDartGun,"magmaSpiritDartGun");
		GameRegistry.registerItem(teleniumDartGun,"teleniumDartGun");
		GameRegistry.registerItem(enderspiritDartGun, "enderspiritDartGun");
		GameRegistry.registerItem(dimensionForgedDartGun,"dimensionForgedDartGun");
		
		//helmets
		GameRegistry.registerItem(aluminumHelmet,"aluminumHelmet");
		GameRegistry.registerItem(copperHelmet,"copperHelmet");
		GameRegistry.registerItem(steelHelmet,"steelHelmet");
		GameRegistry.registerItem(spiritedHelmet,"spiritedHelmet");
		GameRegistry.registerItem(charredLeadHelmet,"charredLeadHelmet");
		GameRegistry.registerItem(amethystHelmet,"amethystHelmet");
		GameRegistry.registerItem(magnetiteHelmet,"magnetiteHelmet");
		GameRegistry.registerItem(magmaSpiritHelmet,"magmaSpiritHelmet");
		GameRegistry.registerItem(iriditeHelmet,"iriditeHelmet");
		GameRegistry.registerItem(lilithiteHelmet,"lilithiteHelmet");
		GameRegistry.registerItem(teleniumHelmet,"teleniumHelmet");
		GameRegistry.registerItem(enderSpiritHelmet, "enderSpiritHelmet");
		GameRegistry.registerItem(dimensionForgedHelmet,"dimensionForgedHelmet");
		
		//chestplates
		GameRegistry.registerItem(aluminumChestplate,"aluminumChestplate");
		GameRegistry.registerItem(copperChestplate,"copperChestplate");
		GameRegistry.registerItem(steelChestplate,"steelChestplate");
		GameRegistry.registerItem(spiritedChestplate,"spiritedChestplate");
		GameRegistry.registerItem(charredLeadChestplate,"charredLeadChestplate");
		GameRegistry.registerItem(amethystChestplate,"amethystChestplate");
		GameRegistry.registerItem(magnetiteChestplate,"magnetiteChestplate");
		GameRegistry.registerItem(magmaSpiritChestplate,"magmaSpiritChestplate");
		GameRegistry.registerItem(iriditeChestplate,"iriditeChestplate");
		GameRegistry.registerItem(lilithiteChestplate,"lilithiteChestplate");
		GameRegistry.registerItem(teleniumChestplate,"teleniumChestplate");
		GameRegistry.registerItem(enderSpiritChestplate, "enderSpiritChestplate");
		GameRegistry.registerItem(dimensionForgedChestplate,"dimensionForgedChestplate");
		
		//leggings
		GameRegistry.registerItem(aluminumLeggings,"aluminumLeggings");
		GameRegistry.registerItem(copperLeggings,"copperLeggings");
		GameRegistry.registerItem(steelLeggings,"steelLeggings");
		GameRegistry.registerItem(spiritedLeggings,"spiritedLeggings");
		GameRegistry.registerItem(charredLeadLeggings,"charredLeadLeggings");
		GameRegistry.registerItem(amethystLeggings,"amethystLeggings");
		GameRegistry.registerItem(magnetiteLeggings,"magnetiteLeggings");
		GameRegistry.registerItem(magmaSpiritLeggings,"magmaSpiritLeggings");
		GameRegistry.registerItem(iriditeLeggings,"iriditeLeggings");
		GameRegistry.registerItem(lilithiteLeggings,"lilithiteLeggings");
		GameRegistry.registerItem(teleniumLeggings,"teleniumLeggings");
		GameRegistry.registerItem(enderSpiritLeggings, "enderSpiritLeggings");
		GameRegistry.registerItem(dimensionForgedLeggings,"dimensionForgedLeggings");
		
		//boots
		GameRegistry.registerItem(aluminumBoots,"aluminumBoots");
		GameRegistry.registerItem(copperBoots,"copperBoots");
		GameRegistry.registerItem(steelBoots,"steelBoots");
		GameRegistry.registerItem(spiritedBoots,"spiritedBoots");
		GameRegistry.registerItem(charredLeadBoots,"charredLeadBoots");
		GameRegistry.registerItem(amethystBoots,"amethystBoots");
		GameRegistry.registerItem(magnetiteBoots,"magnetiteBoots");
		GameRegistry.registerItem(magmaSpiritBoots,"magmaSpiritBoots");
		GameRegistry.registerItem(iriditeBoots,"iriditeBoots");
		GameRegistry.registerItem(lilithiteBoots,"lilithiteBoots");
		GameRegistry.registerItem(teleniumBoots,"teleniumBoots");
		GameRegistry.registerItem(enderSpiritBoots, "enderSpiritBoots");
		GameRegistry.registerItem(dimensionForgedBoots,"dimensionForgedBoots");
		
		//ores
		GameRegistry.registerBlock(aluminumOre, "aluminumOre");
		LanguageRegistry.addName(aluminumOre, "Aluminum Ore");
		OreDictionary.registerOre("oreAluminum", aluminumOre);
		
		GameRegistry.registerBlock(copperOre, "copperOre");
		LanguageRegistry.addName(copperOre, "Copper Ore");
		OreDictionary.registerOre("oreCopper",copperOre);
		
		GameRegistry.registerBlock(steelOre, "steelOre");
		LanguageRegistry.addName(steelOre, "Steel Ore");
		OreDictionary.registerOre("oreSteel",steelOre);
		
		GameRegistry.registerBlock(spiritOre, "spiritOre");
		LanguageRegistry.addName(spiritOre, "Spirit Ore");
		OreDictionary.registerOre("oreSpirit",spiritOre);
		
		GameRegistry.registerBlock(charredLeadOre, "charredLeadOre");
		LanguageRegistry.addName(charredLeadOre, "Charred Lead Ore");
		OreDictionary.registerOre("oreCharredLead",charredLeadOre);
		
		GameRegistry.registerBlock(amethystOre, "amethystOre");
		LanguageRegistry.addName(amethystOre, "Amethyst Ore");
		OreDictionary.registerOre("oreAmethyst",amethystOre);
		
		GameRegistry.registerBlock(magnetiteOre, "magnetiteOre");
		LanguageRegistry.addName(magnetiteOre, "Magnetite Ore");
		OreDictionary.registerOre("oreMagnetite",magnetiteOre);
		
		GameRegistry.registerBlock(magmaSpiritOre, "magmaSpiritOre");
		LanguageRegistry.addName(magmaSpiritOre, "Magma Spirit Ore");
		OreDictionary.registerOre("oreMagmaSpirit",magmaSpiritOre);
		
		GameRegistry.registerBlock(enderspiritOre, "enderspiritOre");
		LanguageRegistry.addName(enderspiritOre, "Ender Spirit Ore");
		OreDictionary.registerOre("oreEnderSpirit", enderspiritOre);
		
		GameRegistry.registerBlock(iriditeOre, "iriditeOre");
		LanguageRegistry.addName(iriditeOre, "Iridite Ore");
		OreDictionary.registerOre("oreIridite",iriditeOre);
		
		GameRegistry.registerBlock(lilithiteOre, "lilithiteOre");
		LanguageRegistry.addName(lilithiteOre, "Lilithite Ore");
		OreDictionary.registerOre("oreLilithite",lilithiteOre);
		
		GameRegistry.registerBlock(teleniumOre, "teleniumOre");
		LanguageRegistry.addName(teleniumOre, "Telenium Ore");
		OreDictionary.registerOre("oreTelenium",teleniumOre);
		
		//material blocks
		GameRegistry.registerBlock(aluminumBlock, "aluminumBlock");
		LanguageRegistry.addName(aluminumBlock, "Aluminum Block");
		OreDictionary.registerOre("blockAluminum",aluminumBlock);
		
		GameRegistry.registerBlock(copperBlock, "copperBlock");
		LanguageRegistry.addName(copperBlock, "Copper Block");
		OreDictionary.registerOre("blockCopper",copperBlock);
		
		GameRegistry.registerBlock(steelBlock, "steelBlock");
		LanguageRegistry.addName(steelBlock, "Steel Block");
		OreDictionary.registerOre("blockSteel",steelBlock);
		
		GameRegistry.registerBlock(spiritStone, "spiritStone");
		LanguageRegistry.addName(spiritStone, "Spirit Stone");
		OreDictionary.registerOre("blockSpiritStone",spiritStone);
		
		GameRegistry.registerBlock(spiritedBlock, "spiritedBlock");
		LanguageRegistry.addName(spiritedBlock, "Spirited Block");
		OreDictionary.registerOre("blockSpirited",spiritedBlock);
		
		GameRegistry.registerBlock(charredLeadBlock, "charredLeadBlock");
		LanguageRegistry.addName(charredLeadBlock, "Charred Lead Block");
		OreDictionary.registerOre("blockCharredLead",charredLeadBlock);
		
		GameRegistry.registerBlock(amethystBlock, "amethystBlock");
		LanguageRegistry.addName(amethystBlock, "Amethyst Block");
		OreDictionary.registerOre("blockAmethyst",amethystBlock);
		
		GameRegistry.registerBlock(magnetiteBlock, "magnetiteBlock");
		LanguageRegistry.addName(magnetiteBlock, "Magnetite Block");
		OreDictionary.registerOre("blockMagnetite",magnetiteBlock);
		
		GameRegistry.registerBlock(magmaSpiritBlock, "magmaSpiritBlock");
		LanguageRegistry.addName(magmaSpiritBlock, "Magma Spirited Block");
		OreDictionary.registerOre("blockMagmaSpirited",magmaSpiritBlock);
		
		GameRegistry.registerBlock(iriditeBlock, "iriditeBlock");
		LanguageRegistry.addName(iriditeBlock, "Iridite Block");
		OreDictionary.registerOre("blockIridite",iriditeBlock);
		
		GameRegistry.registerBlock(lilithiteBlock, "lilithiteBlock");
		LanguageRegistry.addName(lilithiteBlock, "Lilithite Block");
		OreDictionary.registerOre("blockLilithite",lilithiteBlock);
		
		GameRegistry.registerBlock(enderSpiritBlock, "enderSpiritBlock");
		LanguageRegistry.addName(enderSpiritBlock, "Ender Spirited Block");
		OreDictionary.registerOre("blockEnderSpirit",enderSpiritBlock);
		
		GameRegistry.registerBlock(teleniumBlock, "teleniumBlock");
		LanguageRegistry.addName(teleniumBlock, "Telenium Block");
		OreDictionary.registerOre("blockTelenium",teleniumBlock);
		
		GameRegistry.registerBlock(dimensionForgedBlock, "dimensionForgedBlock");
		LanguageRegistry.addName(dimensionForgedBlock, "Dimensionforged Block");
		OreDictionary.registerOre("blockDimensionForged",dimensionForgedBlock);
		
		//fences
		
		if (enableFences)
		{
		GameRegistry.registerBlock(aluminumFence, "aluminumFence");
		LanguageRegistry.addName(aluminumFence, "Aluminum Fence");
		
		GameRegistry.registerBlock(copperFence, "copperFence");
		LanguageRegistry.addName(copperFence, "Copper Fence");
		
		GameRegistry.registerBlock(steelFence, "steelFence");
		LanguageRegistry.addName(steelFence, "Steel Fence");
		
		GameRegistry.registerBlock(spiritedFence, "spiritedFence");
		LanguageRegistry.addName(spiritedFence, "Spirited Fence");
		
		GameRegistry.registerBlock(charredLeadFence, "charredLeadFence");
		LanguageRegistry.addName(charredLeadFence, "Charred Lead Fence");
		
		GameRegistry.registerBlock(amethystFence, "amethystFence");
		LanguageRegistry.addName(amethystFence, "Amethyst Fence");
		
		GameRegistry.registerBlock(magnetiteFence, "magnetiteFence");
		LanguageRegistry.addName(magnetiteFence, "Magnetite Fence");
		
		GameRegistry.registerBlock(magmaSpiritFence, "magmaSpiritFence");
		LanguageRegistry.addName(magmaSpiritFence, "Magma Spirit Fence");
		
		GameRegistry.registerBlock(iriditeFence, "iriditeFence");
		LanguageRegistry.addName(iriditeFence, "Iridite Fence");
		
		GameRegistry.registerBlock(lilithiteFence, "lilithiteFence");
		LanguageRegistry.addName(lilithiteFence, "Lilithite Fence");
		
		GameRegistry.registerBlock(enderSpiritFence, "enderSpiritFence");
		LanguageRegistry.addName(enderSpiritFence, "Ender Spirit Fence");
		
		GameRegistry.registerBlock(teleniumFence, "teleniumFence");
		LanguageRegistry.addName(teleniumFence, "Telenium Fence");
		
		GameRegistry.registerBlock(dimensionForgedFence, "dimensionForgedFence");
		LanguageRegistry.addName(dimensionForgedFence, "Dimensionforged Fence");
		}
		
		if (enableFenceGates)
		{
		//fence gates
		GameRegistry.registerBlock(aluminumFenceGate, "aluminumFenceGate");
		LanguageRegistry.addName(aluminumFenceGate, "Aluminum Fence Gate");
		
		GameRegistry.registerBlock(copperFenceGate, "copperFenceGate");
		LanguageRegistry.addName(copperFenceGate, "Copper Fence Gate");
		
		GameRegistry.registerBlock(steelFenceGate, "steelFenceGate");
		LanguageRegistry.addName(steelFenceGate, "Steel Fence Gate");
		
		GameRegistry.registerBlock(spiritedFenceGate, "spiritedFenceGate");
		LanguageRegistry.addName(spiritedFenceGate, "Spirited Fence Gate");
		
		GameRegistry.registerBlock(charredLeadFenceGate, "charredLeadFenceGate");
		LanguageRegistry.addName(charredLeadFenceGate, "Charred Lead Fence Gate");
		
		GameRegistry.registerBlock(amethystFenceGate, "amethystFenceGate");
		LanguageRegistry.addName(amethystFenceGate, "Amethyst Fence Gate");
		
		GameRegistry.registerBlock(magnetiteFenceGate, "magnetiteFenceGate");
		LanguageRegistry.addName(magnetiteFenceGate, "Magnetite Fence Gate");
		
		GameRegistry.registerBlock(magmaSpiritFenceGate, "magmaSpiritFenceGate");
		LanguageRegistry.addName(magmaSpiritFenceGate, "Magma Spirit Fence Gate");
		
		GameRegistry.registerBlock(iriditeFenceGate, "iriditeFenceGate");
		LanguageRegistry.addName(iriditeFenceGate, "Iridite Fence Gate");
		
		GameRegistry.registerBlock(lilithiteFenceGate, "lilithiteFenceGate");
		LanguageRegistry.addName(lilithiteFenceGate, "Lilithite Fence Gate");
		
		GameRegistry.registerBlock(enderSpiritFenceGate, "enderSpiritFenceGate");
		LanguageRegistry.addName(enderSpiritFenceGate, "Ender Spirit Fence Gate");
		
		GameRegistry.registerBlock(teleniumFenceGate, "teleniumFenceGate");
		LanguageRegistry.addName(teleniumFenceGate, "Telenium Fence Gate");
		
		GameRegistry.registerBlock(dimensionForgedFenceGate, "dimensionForgedFenceGate");
		LanguageRegistry.addName(dimensionForgedFenceGate, "Dimensionforged Fence Gate");
		}
		
		//Entities
		/*
		EntityRegistry.registerGlobalEntityID(EntityAluminumSpider.class, "Aluminum Spider", EntityRegistry.findGlobalUniqueEntityId());  
        registerEntityEgg(EntityAluminumSpider.class, (new Color(38, 22, 5)).getRGB(), (new Color(193, 193, 193)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(EntityAluminumSpider.class, new RenderAluminumSpider());
        ModLoader.addLocalization("entity.Aluminum Spider.name", "Aluminum Spider");
        
        EntityRegistry.registerGlobalEntityID(EntityCopperSpider.class, "Copper Spider", EntityRegistry.findGlobalUniqueEntityId());
        registerEntityEgg(EntityCopperSpider.class, (new Color(43,26,7)).getRGB(),(new Color(182,87,41)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(EntityCopperSpider.class, new RenderCopperSpider());
        ModLoader.addLocalization("entity.Copper Spider.name","Copper Spider");
        
        //Dungeons
        DungeonHooks.addDungeonMob("Aluminum Spider", 75);
        DungeonHooks.addDungeonMob("Copper Spider",70); */
		
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(aluminumBlock), "xxx", "xxx", "xxx",
                'x', new ItemStack(aluminumIngot));
		GameRegistry.addRecipe(new ItemStack(copperBlock), "xxx", "xxx", "xxx",
                'x', new ItemStack(copperIngot));
		GameRegistry.addRecipe(new ItemStack(steelBlock), "xxx", "xxx", "xxx",
                'x', new ItemStack(steelIngot));
		GameRegistry.addRecipe(new ItemStack(spiritStone), "xx", "xx",
                'x', new ItemStack(spiritIngot));
		GameRegistry.addRecipe(new ItemStack(spiritedBlock), "xxx","xxx", "xxx",
				'x', new ItemStack(spiritedIngot));
		GameRegistry.addRecipe(new ItemStack(charredLeadBlock), "xxx","xxx", "xxx",
				'x', new ItemStack(charredLeadChunk));
		GameRegistry.addRecipe(new ItemStack(amethystBlock), "xxx","xxx", "xxx",
				'x', new ItemStack(amethystGem));
		GameRegistry.addRecipe(new ItemStack(magnetiteBlock), "xxx","xxx", "xxx",
				'x', new ItemStack(magnetiteChunk));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritBlock), "xxx","xxx", "xxx",
				'x', new ItemStack(magmaSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(iriditeBlock), "xxx","xxx","xxx",
				'x', new ItemStack(iriditeShard));
		GameRegistry.addRecipe(new ItemStack(lilithiteBlock),"xxx","xxx","xxx",
				'x', new ItemStack(lilithiteGem));
		GameRegistry.addRecipe(new ItemStack(enderSpiritBlock),"xxx","xxx","xxx",
				'x', new ItemStack(enderSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(teleniumBlock), "xxx","xxx","xxx",
				'x', new ItemStack(teleniumIngot));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedBlock), "xxx","xxx","xxx",
				'x', new ItemStack(dimensionForgedIngot));
		
		GameRegistry.addShapelessRecipe(new ItemStack(aluminumIngot,9), new ItemStack(aluminumBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(copperIngot,9), new ItemStack(copperBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(steelIngot,9), new ItemStack(steelBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(spiritedIngot,9), new ItemStack(spiritedBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(charredLeadChunk,9), new ItemStack(charredLeadBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(amethystGem,9), new ItemStack(amethystBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(magnetiteChunk,9), new ItemStack(magnetiteBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(magmaSpiritIngot,9),new ItemStack(magmaSpiritBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(iriditeShard,9), new ItemStack(iriditeBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(lilithiteGem,9), new ItemStack(lilithiteBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(enderSpiritIngot,9), new ItemStack(enderSpiritBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(teleniumIngot, 9), new ItemStack(teleniumBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(dimensionForgedIngot,9), new ItemStack(dimensionForgedBlock));
		
		GameRegistry.addShapelessRecipe(new ItemStack(spiritedIngot, 2), new ItemStack(aluminumIngot), new ItemStack(copperIngot), new ItemStack(steelIngot),new ItemStack(spiritIngot));
		GameRegistry.addShapelessRecipe(new ItemStack(magmaSpiritIngot, 2), new ItemStack(charredLeadChunk), new ItemStack(amethystGem), new ItemStack(magnetiteChunk), new ItemStack(magmaSpiritCrystal));
		GameRegistry.addShapelessRecipe(new ItemStack(enderSpiritIngot, 2), new ItemStack(teleniumIngot), new ItemStack(iriditeShard), new ItemStack(lilithiteGem), new ItemStack(enderSpiritCrystal));
		GameRegistry.addShapelessRecipe(new ItemStack(dimensionForgedIngot), new ItemStack(spiritedIngot), new ItemStack(magmaSpiritIngot), new ItemStack(enderSpiritIngot));
		
		GameRegistry.addRecipe(new ItemStack(aluminumPickaxe), "xxx", " y ", " y ",
                'x', new ItemStack(aluminumIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(copperPickaxe), "xxx", " y ", " y ",
                'x', new ItemStack(copperIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(steelPickaxe), "xxx", " y ", " y ",
                'x', new ItemStack(steelIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(spiritedPickaxe), "xxx", " y ", " y ",
                'x', new ItemStack(spiritedIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(charredLeadPickaxe), "xxx", " y ", " y ",
                'x', new ItemStack(charredLeadChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(amethystPickaxe), "xxx", " y ", " y ",
                'x', new ItemStack(amethystGem),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magnetitePickaxe), "xxx", " y ", " y ",
                'x', new ItemStack(magnetiteChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritPickaxe), "xxx", " y ", " y ",
				'x', new ItemStack(magmaSpiritIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(iriditePickaxe), "xxx", " y ", " y ",
				'x', new ItemStack(iriditeShard), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(lilithitePickaxe), "xxx"," y ", " y ",
				'x', new ItemStack(lilithiteGem), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(enderspiritPickaxe), "xxx"," y "," y ",
				'x', new ItemStack(enderSpiritIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(teleniumPickaxe),"xxx"," y "," y ",
				'x', new ItemStack(teleniumIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedPickaxe),"xxx"," y ", " y ",
				'x', new ItemStack(dimensionForgedIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		
		GameRegistry.addRecipe(new ItemStack(aluminumAxe), "xx ", "xy ", " y ",
                'x', new ItemStack(aluminumIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(copperAxe), "xx ", "xy ", " y ",
                'x', new ItemStack(copperIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(steelAxe), "xx ", "xy ", " y ",
                'x', new ItemStack(steelIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(spiritedAxe), "xx ", "xy ", " y ",
                'x', new ItemStack(spiritedIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(charredLeadAxe), "xx ", "xy ", " y ",
                'x', new ItemStack(charredLeadChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(amethystAxe), "xx ", "xy ", " y ",
                'x', new ItemStack(amethystGem),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magnetiteAxe), "xx ", "xy ", " y ",
                'x', new ItemStack(magnetiteChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritAxe), "xx ", "xy ", " y ",
				'x', new ItemStack(magmaSpiritIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(iriditeAxe), "xx ", "xy ", " y ",
				'x', new ItemStack(iriditeShard), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(lilithiteAxe), "xx ", "xy ", " y ",
				'x', new ItemStack(lilithiteGem), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(enderspiritAxe), "xx ", "xy "," y ",
				'x', new ItemStack(enderSpiritIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(teleniumAxe), "xx ", "xy ", " y ",
				'x', new ItemStack(teleniumIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedAxe), "xx ", "xy ", " y ",
				'x', new ItemStack(dimensionForgedIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		
		
		GameRegistry.addRecipe(new ItemStack(aluminumShovel), " x ", " y ", " y ",
                'x', new ItemStack(aluminumIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(copperShovel), " x ", " y ", " y ",
                'x', new ItemStack(copperIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(steelShovel), " x ", " y ", " y ",
                'x', new ItemStack(steelIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(spiritedShovel), " x ", " y ", " y ",
                'x', new ItemStack(spiritedIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(charredLeadShovel), " x ", " y ", " y ",
                'x', new ItemStack(charredLeadChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(amethystShovel), " x ", " y ", " y ",
                'x', new ItemStack(amethystGem),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magnetiteShovel), " x ", " y ", " y ",
                'x', new ItemStack(magnetiteChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritShovel), " x ", " y ", " y ",
				'x', new ItemStack(magmaSpiritIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(iriditeShovel), " x ", " y ", " y ",
				'x', new ItemStack(iriditeShard), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(lilithiteShovel), " x ", " y ", " y ",
				'x', new ItemStack(lilithiteGem), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(enderspiritShovel), " x ", " y ", " y ",
				'x', new ItemStack(enderSpiritIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(teleniumShovel), " x ", " y ", " y ",
				'x', new ItemStack(teleniumIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedShovel), "x","y","y",
				'x', new ItemStack(dimensionForgedIngot),'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		
		GameRegistry.addRecipe(new ItemStack(aluminumHoe), "xx ", " y ", " y ",
                'x', new ItemStack(aluminumIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(copperHoe), "xx ", " y ", " y ",
                'x', new ItemStack(copperIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(steelHoe), "xx ", " y ", " y ",
                'x', new ItemStack(steelIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(spiritedHoe), "xx ", " y ", " y ",
                'x', new ItemStack(spiritedIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(charredLeadHoe), "xx ", " y ", " y ",
                'x', new ItemStack(charredLeadChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(amethystHoe), "xx ", " y ", " y ",
                'x', new ItemStack(amethystGem),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magnetiteHoe), "xx ", " y ", " y ",
                'x', new ItemStack(magnetiteChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritHoe), "xx ", " y ", " y ",
				'x', new ItemStack(magmaSpiritIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(iriditeHoe), "xx ", " y ", " y ",
				'x', new ItemStack(iriditeShard),'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(lilithiteHoe), "xx ", " y ", " y ",
				'x', new ItemStack(lilithiteGem), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(enderspiritHoe),"xx "," y ", " y ",
				'x', new ItemStack(enderSpiritIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(teleniumHoe), "xx ", " y ", " y ",
				'x', new ItemStack(teleniumIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedHoe), "xx", " y", " y",
				'x', new ItemStack(dimensionForgedIngot),'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		
		GameRegistry.addRecipe(new ItemStack(aluminumSword), " x ", " x ", " y ",
                'x', new ItemStack(aluminumIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(copperSword), " x ", " x ", " y ",
                'x', new ItemStack(copperIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(steelSword), " x ", " x ", " y ",
                'x', new ItemStack(steelIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(spiritedSword), " x ", " x ", " y ",
                'x', new ItemStack(spiritedIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(charredLeadSword), " x ", " x ", " y ",
                'x', new ItemStack(charredLeadChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(amethystSword), " x ", " x ", " y ",
                'x', new ItemStack(amethystGem),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magnetiteSword), " x ", " x ", " y ",
                'x', new ItemStack(magnetiteChunk),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritSword), " x ", " x ", " y ",
				'x', new ItemStack(magmaSpiritIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(iriditeSword), " x "," x ", " y ",
				'x', new ItemStack(iriditeShard), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(lilithiteSword), " x ", " x ", " y ",
				'x', new ItemStack(lilithiteGem), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(enderspiritSword), " x ", " x ", " y ",
				'x', new ItemStack(enderSpiritIngot),'y',new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(teleniumSword), " x ", " x ", " y ",
				'x', new ItemStack(teleniumIngot),'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedSword),"x","x","y",
				'x', new ItemStack(dimensionForgedIngot), 'y', new ItemStack((Item)Item.itemRegistry.getObject("stick")));
	
		GameRegistry.addRecipe(new ItemStack(aluminumDartGun), "x", "y", "x",
                'x', new ItemStack(aluminumIngot),'y',new ItemStack(basicDartGun));
		GameRegistry.addRecipe(new ItemStack(spiritedDartGun), " x ", "xyx", " x ",
                'x', new ItemStack(spiritedIngot),'y',new ItemStack(aluminumDartGun));
		GameRegistry.addRecipe(new ItemStack(amethystDartGun), "x", "y", "x",
                'x', new ItemStack(amethystGem),'y',new ItemStack(spiritedDartGun));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritDartGun), " x ", "xyx"," x ",
				'x', new ItemStack(magmaSpiritIngot), 'y', new ItemStack(amethystDartGun));
		GameRegistry.addRecipe(new ItemStack(basicDartGun), "r", "r",
				'r', new ItemStack((Item)Item.itemRegistry.getObject("reeds")));
		GameRegistry.addRecipe(new ItemStack(teleniumDartGun), "x","y","x",
				'x', new ItemStack(teleniumIngot), 'y', new ItemStack(magmaSpiritDartGun));
		GameRegistry.addRecipe(new ItemStack(enderspiritDartGun)," x ", "xyx"," x ",
				'x', new ItemStack(enderSpiritIngot),'y', new ItemStack(teleniumDartGun));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedDartGun), "x","y","x",
				'x', new ItemStack(dimensionForgedIngot), 'y', new ItemStack(enderspiritDartGun));
		
		GameRegistry.addRecipe(new ItemStack(aluminumHelmet), "xxx", "x x", "   ",
                'x', new ItemStack(aluminumIngot));
		GameRegistry.addRecipe(new ItemStack(aluminumChestplate), "x x", "xxx", "xxx",
                'x', new ItemStack(aluminumIngot));
		GameRegistry.addRecipe(new ItemStack(aluminumLeggings), "xxx", "x x", "x x",
                'x', new ItemStack(aluminumIngot));
		GameRegistry.addRecipe(new ItemStack(aluminumBoots), "   ", "x x", "x x",
                'x', new ItemStack(aluminumIngot));
		
		GameRegistry.addRecipe(new ItemStack(copperHelmet), "xxx", "x x", "   ",
                'x', new ItemStack(copperIngot));
		GameRegistry.addRecipe(new ItemStack(copperChestplate), "x x", "xxx", "xxx",
                'x', new ItemStack(copperIngot));
		GameRegistry.addRecipe(new ItemStack(copperLeggings), "xxx", "x x", "x x",
                'x', new ItemStack(copperIngot));
		GameRegistry.addRecipe(new ItemStack(copperBoots), "   ", "x x", "x x",
                'x', new ItemStack(copperIngot));
		
		GameRegistry.addRecipe(new ItemStack(steelHelmet), "xxx", "x x", "   ",
                'x', new ItemStack(steelIngot));
		GameRegistry.addRecipe(new ItemStack(steelChestplate), "x x", "xxx", "xxx",
                'x', new ItemStack(steelIngot));
		GameRegistry.addRecipe(new ItemStack(steelLeggings), "xxx", "x x", "x x",
                'x', new ItemStack(steelIngot));
		GameRegistry.addRecipe(new ItemStack(steelBoots), "   ", "x x", "x x",
                'x', new ItemStack(steelIngot));
		
		GameRegistry.addRecipe(new ItemStack(spiritedHelmet), "xxx", "x x", "   ",
                'x', new ItemStack(spiritedIngot));
		GameRegistry.addRecipe(new ItemStack(spiritedChestplate), "x x", "xxx", "xxx",
                'x', new ItemStack(spiritedIngot));
		GameRegistry.addRecipe(new ItemStack(spiritedLeggings), "xxx", "x x", "x x",
                'x', new ItemStack(spiritedIngot));
		GameRegistry.addRecipe(new ItemStack(spiritedBoots), "   ", "x x", "x x",
                'x', new ItemStack(spiritedIngot));
		
		GameRegistry.addRecipe(new ItemStack(charredLeadHelmet), "xxx", "x x", "   ",
                'x', new ItemStack(charredLeadChunk));
		GameRegistry.addRecipe(new ItemStack(charredLeadChestplate), "x x", "xxx", "xxx",
                'x', new ItemStack(charredLeadChunk));
		GameRegistry.addRecipe(new ItemStack(charredLeadLeggings), "xxx", "x x", "x x",
                'x', new ItemStack(charredLeadChunk));
		GameRegistry.addRecipe(new ItemStack(charredLeadBoots), "   ", "x x", "x x",
                'x', new ItemStack(charredLeadChunk));
		
		GameRegistry.addRecipe(new ItemStack(amethystHelmet), "xxx", "x x", "   ",
                'x', new ItemStack(amethystGem));
		GameRegistry.addRecipe(new ItemStack(amethystChestplate), "x x", "xxx", "xxx",
                'x', new ItemStack(amethystGem));
		GameRegistry.addRecipe(new ItemStack(amethystLeggings), "xxx", "x x", "x x",
                'x', new ItemStack(amethystGem));
		GameRegistry.addRecipe(new ItemStack(amethystBoots), "   ", "x x", "x x",
                'x', new ItemStack(amethystGem));
		
		GameRegistry.addRecipe(new ItemStack(magnetiteHelmet), "xxx", "x x", "   ",
                'x', new ItemStack(magnetiteChunk));
		GameRegistry.addRecipe(new ItemStack(magnetiteChestplate), "x x", "xxx", "xxx",
                'x', new ItemStack(magnetiteChunk));
		GameRegistry.addRecipe(new ItemStack(magnetiteLeggings), "xxx", "x x", "x x",
                'x', new ItemStack(magnetiteChunk));
		GameRegistry.addRecipe(new ItemStack(magnetiteBoots), "   ", "x x", "x x",
                'x', new ItemStack(magnetiteChunk));
		
		GameRegistry.addRecipe(new ItemStack(magmaSpiritHelmet), "xxx","x x", "   ",
				'x', new ItemStack(magmaSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritChestplate), "x x", "xxx", "xxx",
				'x', new ItemStack(magmaSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritLeggings), "xxx", "x x", "x x",
				'x', new ItemStack(magmaSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritBoots), "x x", "x x",
				'x', new ItemStack(magmaSpiritIngot));
		
		GameRegistry.addRecipe(new ItemStack(iriditeHelmet),"xxx","x x","   ",
				'x',new ItemStack(iriditeShard));
		GameRegistry.addRecipe(new ItemStack(iriditeChestplate),"x x", "xxx","xxx",
				'x',new ItemStack(iriditeShard));
		GameRegistry.addRecipe(new ItemStack(iriditeLeggings),"xxx","x x","x x",
				'x',new ItemStack(iriditeShard));
		GameRegistry.addRecipe(new ItemStack(iriditeBoots),"x x","x x",
				'x',new ItemStack(iriditeShard));
		
		GameRegistry.addRecipe(new ItemStack(lilithiteHelmet), "xxx", "x x", "   ",
				'x', new ItemStack(lilithiteGem));
		GameRegistry.addRecipe(new ItemStack(lilithiteChestplate), "x x", "xxx","xxx",
				'x', new ItemStack(lilithiteGem));
		GameRegistry.addRecipe(new ItemStack(lilithiteLeggings), "xxx","x x","x x",
				'x', new ItemStack(lilithiteGem));
		GameRegistry.addRecipe(new ItemStack(lilithiteBoots), "x x", "x x",
				'x', new ItemStack(lilithiteGem));
		
		GameRegistry.addRecipe(new ItemStack(enderSpiritHelmet), "xxx", "x x","   ",
				'x', new ItemStack(enderSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(enderSpiritChestplate), "x x","xxx","xxx",
				'x', new ItemStack(enderSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(enderSpiritLeggings), "xxx","x x","x x",
				'x', new ItemStack(enderSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(enderSpiritBoots), "x x", "x x",
				'x', new ItemStack(enderSpiritIngot));
		
		GameRegistry.addRecipe(new ItemStack(teleniumHelmet), "xxx","x x", "   ",
				'x', new ItemStack(teleniumIngot));
		GameRegistry.addRecipe(new ItemStack(teleniumChestplate), "x x", "xxx","xxx",
				'x', new ItemStack(teleniumIngot));
		GameRegistry.addRecipe(new ItemStack(teleniumLeggings), "xxx", "x x", "x x",
				'x', new ItemStack(teleniumIngot));
		GameRegistry.addRecipe(new ItemStack(teleniumBoots), "x x", "x x",
				'x', new ItemStack(teleniumIngot));
		
		GameRegistry.addRecipe(new ItemStack(dimensionForgedHelmet),"xxx","x x","   ",
				'x', new ItemStack(dimensionForgedIngot));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedChestplate),"x x","xxx","xxx",
				'x', new ItemStack(dimensionForgedIngot));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedLeggings),"xxx","x x","x x",
				'x', new ItemStack(dimensionForgedIngot));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedBoots),"x x","x x",
				'x', new ItemStack(dimensionForgedIngot));
		
		GameRegistry.addRecipe(new ItemStack(aluminumFence), " x ","xxx", " x ", 
                'x', new ItemStack(aluminumIngot));
		GameRegistry.addRecipe(new ItemStack(copperFence), " x ","xxx", " x ", 
                'x', new ItemStack(copperIngot));
		GameRegistry.addRecipe(new ItemStack(steelFence), " x ", "xxx", " x ",
                'x', new ItemStack(steelIngot));
		GameRegistry.addRecipe(new ItemStack(spiritedFence), " x ","xxx"," x ", 
                'x', new ItemStack(spiritedIngot));
		GameRegistry.addRecipe(new ItemStack(charredLeadFence)," x " ,"xxx", " x ", 
                'x', new ItemStack(charredLeadChunk));
		GameRegistry.addRecipe(new ItemStack(amethystFence)," x ", "xxx", " x ",
                'x', new ItemStack(amethystGem));
		GameRegistry.addRecipe(new ItemStack(magnetiteFence), " x ", "xxx", " x ",
                'x', new ItemStack(magnetiteChunk));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritFence), " x ", "xxx", " x ",
				'x', new ItemStack(magmaSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(iriditeFence)," x ","xxx"," x ",
				'x', new ItemStack(iriditeShard));
		GameRegistry.addRecipe(new ItemStack(lilithiteFence)," x ","xxx", " x ",
				'x', new ItemStack(lilithiteGem));
		GameRegistry.addRecipe(new ItemStack(enderSpiritFence)," x ","xxx"," x ",
				'x', new ItemStack(enderSpiritIngot));
		GameRegistry.addRecipe(new ItemStack(teleniumFence)," x ", "xxx", " x ",
				'x', new ItemStack(teleniumIngot));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedFence)," x ","xxx", " x ",
				'x', new ItemStack(dimensionForgedIngot));
		
		GameRegistry.addRecipe(new ItemStack(aluminumFenceGate), "x x","xrx", "x x",
                'x', new ItemStack(aluminumIngot), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(copperFenceGate),"x x", "xrx", "x x",
                'x', new ItemStack(copperIngot), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(steelFenceGate),"x x", "xrx", "x x",
                'x', new ItemStack(steelIngot), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(spiritedFenceGate),"x x", "xrx", "x x",
                'x', new ItemStack(spiritedIngot), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(charredLeadFenceGate),"x x", "xrx", "x x",
                'x', new ItemStack(charredLeadChunk), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(amethystFenceGate), "x x", "xrx", "x x",
                'x', new ItemStack(amethystGem), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(magnetiteFenceGate), "x x", "xrx", "x x",
                'x', new ItemStack(magnetiteChunk), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(magmaSpiritFenceGate), "x x", "xrx","x x",
				'x', new ItemStack(magmaSpiritIngot), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(iriditeFenceGate),"x x","xrx","x x",
				'x', new ItemStack(iriditeShard), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(lilithiteFenceGate),"x x","xrx","x x",
				'x', new ItemStack(lilithiteGem), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(enderSpiritFenceGate),"x x","xrx","x x",
				'x', new ItemStack(enderSpiritIngot), 'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(teleniumFenceGate),"x x", "xrx","x x",
				'x', new ItemStack(teleniumIngot),'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		GameRegistry.addRecipe(new ItemStack(dimensionForgedFenceGate),"x x","xrx","x x",
				'x', new ItemStack(dimensionForgedIngot),'r', new ItemStack((Item)Item.itemRegistry.getObject("redstone")));
		
		//Smelting
		GameRegistry.addSmelting(aluminumOre, new ItemStack(aluminumIngot), 0.2f);
		GameRegistry.addSmelting(copperOre, new ItemStack(copperIngot), 0.2f);
		GameRegistry.addSmelting(steelOre, new ItemStack(steelIngot), 0.3f);
		GameRegistry.addSmelting(spiritOre, new ItemStack(spiritIngot), 0.4f);
		GameRegistry.addSmelting(charredLeadOre, new ItemStack(charredLeadChunk),0.2f);
		GameRegistry.addSmelting(amethystOre, new ItemStack(amethystGem),0.4f);
		GameRegistry.addSmelting(magnetiteOre, new ItemStack(magnetiteChunk),0.2f);
		GameRegistry.addSmelting(magmaSpiritOre, new ItemStack(magmaSpiritCrystal), 0.5f);
		GameRegistry.addSmelting(iriditeOre, new ItemStack(iriditeShard),0.4f);
		GameRegistry.addSmelting(lilithiteOre, new ItemStack(lilithiteGem),0.3f);
		GameRegistry.addSmelting(enderspiritOre, new ItemStack(enderSpiritCrystal), 0.6f);
		GameRegistry.addSmelting(teleniumOre, new ItemStack(teleniumIngot),0.3f);
		
		//Worldgen
		GameRegistry.registerWorldGenerator(new SpiritOresGenerator(), aluminumAxeId);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) { //stub method - not used right now
		
	}
}
