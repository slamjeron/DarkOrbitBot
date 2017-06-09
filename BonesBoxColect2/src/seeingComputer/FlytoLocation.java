package seeingComputer;

import java.awt.Color;
import java.awt.Point;


public class FlytoLocation {

public Point mRightGate;
public Point mLeftGate;
public boolean on1_4=false;
public boolean redyToClock=false;
public boolean alienLocated;
public int runnum=5;
private Point bRightGate;
public Point tLeftGate;
public int gateNumber=0;
private Point mapcPoint;
public int gateJumpCount=1;
private int mTimer=45;
private GetImage imgcon;
private Point clickpnt;
private boolean click;
private boolean typj;
public FlytoLocation( GetImage i) {
	imgcon=i;
	
}
public void setPoints(Point mapPoint){
	mRightGate=new Point(mapPoint.x+322,mapPoint.y+100);
	mLeftGate=new Point(mapPoint.x+31,mapPoint.y+100);
	bRightGate=new Point(mapPoint.x+314,mapPoint.y+191);
	tLeftGate=new Point(mapPoint.x+39,mapPoint.y+33);
	mapcPoint=mapPoint;
}
public boolean base11color(int x,int y){
	return imgcon.pointEcolor(
			new Point(mapcPoint.x+x, mapcPoint.y+y), new Color(204,0,0));
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
public void run4_1(){
	
	 switch (gateNumber) {
     case 1:
     if(gateJump(bRightGate,tLeftGate)){
    		 gateNumber=2;
 		}
        break;
     case 3: if(gateJump(bRightGate,tLeftGate)){
    		 gateNumber=4;
 		}
        break;
     case 4: if(gateJump(mRightGate,mLeftGate)){
    		 gateNumber=0;
 			
 		}
        break;
     
	 }
	
}
public boolean gateJump(Point p,Point othersideP){
switch (gateJumpCount){

case 1:
	

if(plocate(p)){
	
	mTimer=70;
	 gateJumpCount=2;
	}else{
		if(mTimer>50){
			setClick(true);
			setClickpnt(p);
		
		mTimer=0;
		}
		mTimer++;
	}
	
	break;
case 2:
	if(plocate(p)){
		if(mTimer>90){
			setTypj(true);
	mTimer=0;
		}
		mTimer++;
	}else{
		mTimer=45;
		gateJumpCount=3;
	}
	break;
case 3:
	
if(plocate(othersideP)){
	gateJumpCount=1;
	
	return true;
}
}
return false;
}
public boolean plocate(Point p){
	
	return this.imgcon.pointEcolor(new Point(p.x+10, p.y)
			, new Color(70,70,70))&&
			imgcon.pointEcolor(new Point(p.x, p.y-10)
					, new Color(70,70,70))&&
			imgcon.pointEcolor(new Point(p.x-10, p.y)
					, new Color(70,70,70));
}
public boolean isTypj() {
	return typj;
}
public void setTypj(boolean typj) {
	this.typj = typj;
}
public boolean isClick() {
	return click;
}
public void setClick(boolean click) {
	this.click = click;
}
public Point getClickpnt() {
	return clickpnt;
}
public void setClickpnt(Point clickpnt) {
	this.clickpnt = clickpnt;
}

}
