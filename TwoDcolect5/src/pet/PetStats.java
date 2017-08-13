package pet;

import java.awt.Color;
import java.awt.Point;

import userControls.ImgRobot;

public class PetStats {

	
	public Point[] petControlPoints=new Point[6];
	private Point[] petStatsP=new Point[9];
	public boolean petdown=false;
	public boolean petup;
	public boolean petLesHP;
	public boolean petLesSH;
	private ImgRobot imgcon;
	private int tl;
	public Point BTN3,selectBTN,startBTN
	,BTN4,BTN5,BTN6;
	private boolean petstart=false;

	public PetStats(ImgRobot imgcon2) {
		// TODO Auto-generated constructor stub
		imgcon=imgcon2;
	}
	
	public void setPetstatp(Point p) {
		petstart=true;
		petControlPoints[0] = new Point(p.x, p.y + 110);
		petControlPoints[1] = new Point(p.x + 150, p.y + 110);
		for(int i = 2;i<4;i++){
			int k =(i-2)*25;
			petControlPoints[i] = new Point(p.x + 150, p.y + 195+k);
		}
		startBTN=petControlPoints[0];
		selectBTN=petControlPoints[1];
		BTN3=petControlPoints[2];
		BTN4=petControlPoints[3];
		BTN5=petControlPoints[4];
		BTN6=petControlPoints[5];
		// pet hp start
		petStatsP[0] = new Point(p.x + 52, p.y + 55);
		// pet is down
		petStatsP[4] = new Point(p.x + 211, p.y + 108);
		// pet hp end
		petStatsP[1] = new Point(p.x + 116, p.y + 55);
		// pet sh end
		petStatsP[2] = new Point(p.x + 115, p.y + 55 + 20);
		petStatsP[5] = new Point(p.x + 158, p.y + 55 + 20);
		petStatsP[6] = new Point(p.x + 93, p.y +102);
	}
	public boolean petmoniter(){
		if(petstart){
		petdown = imgcon.clogic.pointEcolor(petStatsP[5], Color.BLACK);
		petup = imgcon.clogic.pointEcolor(petStatsP[5], Color.RED);
		if(petdown){
			tl=0;
		}
		if(tl>6){
			petLesHP = imgcon.clogic.pointEcolor(petStatsP[1], Color.BLACK);
			petLesSH = imgcon.clogic.pointEcolor(petStatsP[2], Color.BLACK);
		}else{
			petLesHP=false;
			petLesSH=false;
		}
		tl++;
		}
		return false;
	}
	public boolean dropdownShown() {
		return imgcon.clogic.pointEcolor(petControlPoints[2],34,34,34);
	}
	public boolean petColecting(){
		return imgcon.clogic.pointEcolor(petStatsP[6],255,179,0);
	}

}
