package prova.speriamo;



 import prova.speriamo.provola;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.gui.GuiIngame;
 
 
public class provola extends GuiIngame  {
static Minecraft getmc = Minecraft.getMinecraft();

public provola(Minecraft mcIn) {
super(mcIn);

}

public static void render() {
	
	

	 int x = (int) getmc.thePlayer.chasingPosX;
	 int z = (int) getmc.thePlayer.chasingPosZ;
	 int y = (int) getmc.thePlayer.chasingPosY;
	 
	 
	getmc.fontRendererObj.drawString("Ciao " + getmc.getSession().getUsername(), 1, 1, 0xffffff);
	getmc.fontRendererObj.drawString("Buon Divertimento", 2, 10, 0xffffff);
	getmc.fontRendererObj.drawString("x: " + x + " y: "+y+" z: "+ z , 3, 20, 0xffffff);
	
	

}



}
