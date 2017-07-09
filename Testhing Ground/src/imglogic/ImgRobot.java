package imglogic;

import java.awt.AWTException;
import java.awt.Robot;

public class ImgRobot {
private Robot rob;
public GetImage image;
public searchMath smath;
public Colorlogic clogic;
public ImgRobot(){
	try {
		rob=new Robot();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	image=new GetImage(rob);
	clogic=new Colorlogic();
	smath= new searchMath();
}
}
