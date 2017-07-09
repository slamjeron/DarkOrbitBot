package seeingComputer;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import imglogic.GetImage;


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
public Point[] mapnum={
new Point(11,5),
new Point(12,5),
new Point(13,5),
new Point(22,5),
new Point(23,5),
new Point(24,5),
new Point(10,6),
new Point(11,6),
new Point(12,6),
new Point(13,6),
new Point(21,6),
new Point(22,6),
new Point(23,6),
new Point(24,6),
new Point(9,7),
new Point(10,7),
new Point(12,7),
new Point(13,7),
new Point(20,7),
new Point(21,7),
new Point(23,7),
new Point(24,7),
new Point(12,8),
new Point(13,8),
new Point(23,8),
new Point(24,8),
new Point(12,9),
new Point(13,9),
new Point(16,9),
new Point(17,9),
new Point(18,9),
new Point(23,9),
new Point(24,9),
new Point(12,10),
new Point(13,10),
new Point(23,10),
new Point(24,10),
new Point(12,11),
new Point(13,11),
new Point(23,11),
new Point(24,11),
new Point(12,12),
new Point(13,12),
new Point(23,12),
new Point(24,12),
new Point(0,0)};
private BufferedImage ims;
public boolean moving;
public boolean on1_1(){
	//System.out.println(moving);
	Point pnt=new Point(mapcPoint.x,mapcPoint.y-18);
	ims=imgcon.screanImage(pnt, 27, 18);
	if(imgcon.colMoreLess(imgcon.pointColor(ims,11,7),
			new Color(204,204,204))){
		
		return false;
	}
	int k=0;
for(int y=0;y<ims.getHeight();y++){
	for(int x=0;x<ims.getWidth();x++){
		if(mapnum.length>k){
		if(mapnum[k].equals(new Point(x,y))){
			
			if(imgcon.colMoreLess(imgcon.pointColor(ims, mapnum[k]),
					new Color(204,204,204))){
			k+=2;
			}else{
				k=0;
				return false;
			}
			}
		}
	}
}
	return true;
}

public boolean on2_1(){
	
	return false; 
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
	
	return !moving&&
			imgcon.pointEcolor(new Point(p.x, p.y-10)
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
