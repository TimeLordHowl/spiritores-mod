package howl01.spiritores.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import howl01.spiritores.CommonProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		addModderCapes();
		addCapes();
	}
	@Override
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	public static void addModderCapes() {
		String capeURL = "http://i.imgur.com/gx2CTtm.png";
		String[] devs = {"howl01","elrock13","TXX59"};
		ThreadDownloadImageData image = new ThreadDownloadImageData(null, capeURL, null, null);
		for (String username:devs) {
			Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/" + username),(ITextureObject) image);
		}
	}
	public static void addCapes() {
		String capeURL = "http://i.imgur.com/JIIN6T2mm.png";
		String[] capes = {"ninjabee2000"};
		ThreadDownloadImageData image = new ThreadDownloadImageData(null, capeURL, null, null);
		for (String username: capes) {
			Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/"+username), (ITextureObject) image);
		}
	}
}
