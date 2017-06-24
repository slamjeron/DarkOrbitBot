package simplifyingFunctions;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class comonTools {
	protected imageCon img = new imageCon();
	protected compControls com=new compControls();
	protected Rectangle rect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	protected int hScreanW =rect.width/2;
	protected int hScreanH =rect.height/2;
	
	public boolean backGround(Color c){
		//colmore one first color>second color  return true
		return(img.colmore(new Color(100,100,100), c));
	}
	public boolean colorSimPalie(Color c){
		return(img.colmore(new Color(120,160,200), c)
				&&img.colmore(c,new Color(40,60,100))
				&&c.getBlue() > c.getRed());
		}
	public boolean cargo(Color c){
		return(img.colmore(c, new Color(240,180,90)));
				
		}
}
