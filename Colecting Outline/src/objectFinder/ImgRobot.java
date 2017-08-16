package objectFinder;

import java.awt.AWTException;
import java.awt.Robot;

public class ImgRobot {
private Robot rob;
public GetImage image;
public searchMath smath;
public Colorlogic clogic;
public GamePanels gamePanels;
public NumberReader number;
public ImgRobot(){
	try {
		rob=new Robot();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	smath= new searchMath();
	image=new GetImage(rob);
	number=new NumberReader(image);
	smath=new searchMath();
	image.smath=smath;
	clogic=new Colorlogic(smath);
	gamePanels=new GamePanels(clogic,image);
}
}
