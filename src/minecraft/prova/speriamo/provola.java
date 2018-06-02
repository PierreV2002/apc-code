package prova.speriamo;



 import prova.speriamo.provola;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
 import net.minecraft.client.gui.GuiIngame;
 import java.util.Random;
 import java.lang.Thread;
 
import java.util.concurrent.TimeUnit;

 
 
public class provola extends GuiIngame  {
static Minecraft getmc = Minecraft.getMinecraft();


public provola(Minecraft mcIn) {
super(mcIn);

}

public static void render()   {
 
	 String coso = "RadioAttiva";
	 int random = 1;
	 
	 random = rand.nextInt(16);
	 
	 
	// if (random < 1) {
		 
		// TimeUnit.SECONDS.sleep(10);	 
	//getmc.fontRendererObj.drawString("Modalità " + coso + " Attivata", 14, 30, 0xffffff); 
//	TimeUnit.SECONDS.sleep(18);
	

	
	// }
	
	 int x = (int) getmc.thePlayer.chasingPosX;
	 int z = (int) getmc.thePlayer.chasingPosZ;
	 int y = (int) getmc.thePlayer.chasingPosY;
	 
	 
	getmc.fontRendererObj.drawString("Ciao " + getmc.getSession().getUsername(), 1, 1, 0xffffff);
	getmc.fontRendererObj.drawString("Buon Divertimento", 2, 10, 0xffffff);
	getmc.fontRendererObj.drawString("x: " + x + " y: "+y+" z: "+ z , 3, 20, 0xffffff);

	//getmc.fontRendererObj.drawString("Ciao " + coso , 14, 30, 0xffffff);
	
	

}
}




