package seeingComputer;

import java.awt.Color;
import java.awt.Point;


public class FlytoLocation {
	
private Point mapcPoint;
private GetImage imgcon;
public FlytoLocation( GetImage i) {
	imgcon=i;
	
}
public void setPoints(Point mapPoint){
	mapcPoint=mapPoint;
}
public boolean base11color(int x,int y){
	return mPEColor(x, y,204,0,0);
}
public boolean on1_1(){
	return (mPEColor(21,36,204,198,125))&&mPEColor(56,36,204,198,125);
}
public boolean on2_1(){
	
	return (mPEColor(324,49,204,198,125))&&mPEColor(343,36,204,198,125);
}
public boolean mPEColor(int mx,int my,int r,int g,int b){
	return imgcon.pointEcolor(new Point(mapcPoint.x+mx, mapcPoint.y+my),new Color(r,g,b));
}

public boolean plocate(Point p){
	return this.imgcon.pointEcolor(new Point(p.x+10, p.y)
			, new Color(70,70,70))&&
			imgcon.pointEcolor(new Point(p.x, p.y-10)
					, new Color(70,70,70))&&
			imgcon.pointEcolor(new Point(p.x-10, p.y)
					, new Color(70,70,70));
}
}
