package keyMouse;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import objectFinder.Colorlogic;
import objectFinder.ImgRobot;

public class ToolBar {

	public Point pnt;
	public Colorlogic imgRead;
	public Keyboard keyB;
	public ToolPnts toolpnt =new ToolPnts();
	private int sleepTm;
	public class ToolPnts{

		public intPoint cloak=new intPoint();
		public intPoint infectLsr=new intPoint();
		public intPoint recon=new intPoint();
		public intPoint ulCloak=new intPoint();
		public intPoint jumpCPU=new intPoint();
		public intPoint hartDC =new intPoint();
		public intPoint wheelDC=new intPoint();
		public intPoint instShield=new intPoint();
		public intPoint speedBst=new intPoint();
		public intPoint rapidRctF=new intPoint();
		public intPoint agsSDRep=new intPoint();
		public intPoint hPRep=new intPoint();
		public intPoint hPRepPod=new intPoint();
		
		
		
	}
	public class intPoint{
		public int i=0;
		public Point p=new Point();
	}
public void findItems(BufferedImage screenImg){
	toolpnt =new ToolPnts();
	int i=0;
	for(int x=pnt.x+19;x<pnt.x+390;x+=39){
		i++;
		if(i==10)i=0;
		if(toolClr(screenImg, x, 20, 125,115,119)){
			System.out.println("hartDC found on tool "+i);
		toolpnt.hartDC.p=new Point(x,pnt.y);
		toolpnt.hartDC.i=i;
		}
		if(toolClr(screenImg, x, 7, 23,94,105)){
			System.out.println("ags shild rep found on tool "+i);
		toolpnt.agsSDRep.p=new Point(x,pnt.y);
		toolpnt.agsSDRep.i=i;
		}
		if(toolClr(screenImg, x, 11, 184,252,172)){
			System.out.println("ags hp rep found on tool "+i);
		toolpnt.hPRep.p=new Point(x,pnt.y);
		toolpnt.hPRep.i=i;
		}
		if(toolClr(screenImg, x, 10, 114,231,114)){
			System.out.println("ags hp rep pod found on tool "+i);
		toolpnt.hPRepPod.p=new Point(x,pnt.y);
		toolpnt.hPRepPod.i=i;
		}
		if(toolClr(screenImg, x, 16, 136,236,255)){
			System.out.println("wheelDC found on tool "+i);
		toolpnt.wheelDC.p=new Point(x,pnt.y);
		toolpnt.wheelDC.i=i;
		}
		if(toolClr(screenImg, x, 10, 137,135,136)){
			System.out.println("Cloak found on tool "+i);
		toolpnt.cloak.p=new Point(x,pnt.y);
		toolpnt.cloak.i=i;
		}
		if(toolClr(screenImg, x, 15, 129,128,129)){
			System.out.println("Cloak found on tool "+i);
		toolpnt.cloak.p=new Point(x,pnt.y);
		toolpnt.cloak.i=i;
		}
		if(toolClr(screenImg, x, 14, 107,85,208)){
			toolpnt.jumpCPU.p=new Point(x,pnt.y);
			toolpnt.jumpCPU.i=i;
			System.out.println("jumpCPU found on tool "+i);
		}
		if(toolClr(screenImg, x, 18, 171,225,255)){
			toolpnt.ulCloak.p=new Point(x,pnt.y);
			toolpnt.ulCloak.i=i;
			System.out.println("ultimate clock found on tool "+i);
		}
		if(toolClr(screenImg, x, 10,123,132,140)){
			toolpnt.instShield.p=new Point(x,pnt.y);
			toolpnt.instShield.i=i;
			System.out.println("insta Sheild found on tool "+i);
		}
		if(toolClr(screenImg, x, 16, 151,16,52)){
			toolpnt.recon.p=new Point(x,pnt.y);
			toolpnt.recon.i=i;
			System.out.println("recon on tool "+i);
		}
		if(toolClr(screenImg, x, 12, 190,240,255)){
			toolpnt.infectLsr.p=new Point(x,pnt.y);
			toolpnt.infectLsr.i=i;
			System.out.println("poison laser found on tool "+i);
		}
		if(toolClr(screenImg, x, 15,56,91,114)){
			toolpnt.speedBst.p=new Point(x,pnt.y);
			toolpnt.speedBst.i=i;
			System.out.println("speed boost found on tool "+i);
		}
		if(toolClr(screenImg, x, 8,255,206,85)){
			toolpnt.rapidRctF.p=new Point(x,pnt.y);
			toolpnt.rapidRctF.i=i;
			System.out.println("rapid rocet fire found on tool "+i);
		}
	}
}
public void activate(intPoint p){
	if(sleepTm==2)
	if(p.p.x>0)
	if(inActive(p.p)){
		keyB.type(p.i);
		System.out.println("typed"+p.i);
	}
	if(sleepTm>20)
		sleepTm=0;
	sleepTm++;
}
private boolean inActive(Point p) {
	// TODO Auto-generated method stub
	return imgRead.pointEcolor(p, new Color(44,114,140));
}
private boolean toolClr(BufferedImage screenImg, int x, int y, int r, int g, int b) {
	// TODO Auto-generated method stub
	return imgRead.pointEcolor(screenImg, x, pnt.y+y, r,g,b);
}
public void actUlCloak(){
	activate(toolpnt.ulCloak);
}
public void acthomejump(){
	activate(toolpnt.jumpCPU);
}
public void actCloak(){
	activate(toolpnt.cloak);
}
public void actHartDC(){
	activate(toolpnt.hartDC);
}
public void actSpeedDC(){
	activate(toolpnt.wheelDC);
}
public void actSpeedBst(){
	activate(toolpnt.speedBst);
}
public void actRecon(){
	activate(toolpnt.recon);
}
public void fireInfect(){
	activate(toolpnt.infectLsr);
}
public void actAgsRep(){
	activate(toolpnt.hPRep);
}
public void actAgsRepPod(){
	activate(toolpnt.hPRepPod);
}
public void actAgsRepSD(){
	activate(toolpnt.agsSDRep);
}
}
