package seeingComputer;

import java.awt.Color;
import java.awt.Point;

import imglogic.GetImage;

public class PetStats {

	
	public Point[] petControlPoints=new Point[6];
	private Point[] petStatsP=new Point[7];
	private Point cargoColect;
	public boolean petdown;
	public boolean petup;
	public boolean petLesHP;
	public boolean petLesSH;
	private GetImage imgcon;
	private int tl;

	public PetStats(GetImage i) {
		// TODO Auto-generated constructor stub
		imgcon=i;
	}
	
	public void setPetstatp(Point p) {
		petControlPoints[0] = new Point(p.x, p.y + 110);

		petControlPoints[1] = new Point(p.x + 150, p.y + 110);
		
		for(int i = 2;i<4;i++){
			int k =(i-2)*25;
			petControlPoints[i] = new Point(p.x + 150, p.y + 195+k);
			
			
		}
		//comcon.moveCursor(petControlPoints[3]);
		cargoColect=petControlPoints[2];
		// pet hp start
		petStatsP[0] = new Point(p.x + 52, p.y + 55);
		// pet is down
		petStatsP[4] = new Point(p.x + 211, p.y + 108);
		// System.out.println(con.screenColor(new Point(p.x,p.y+185)));

		
		//com.moveCursor(petControlPoints[4]);
		// pet hp end
		petStatsP[1] = new Point(p.x + 116, p.y + 55);
		// pet sh end
		petStatsP[2] = new Point(p.x + 115, p.y + 55 + 20);
		petStatsP[5] = new Point(p.x + 158, p.y + 55 + 20);
		petStatsP[6] = new Point(p.x + 93, p.y +102);
	}
	public boolean petmoniter(){
		petdown = imgcon.pointEcolor(petStatsP[5], Color.BLACK);
		petup = imgcon.pointEcolor(petStatsP[5], Color.RED);
		if(petdown){
			tl=0;
		}
		if(tl>6){
			petLesHP = imgcon.pointEcolor(petStatsP[1], Color.BLACK);
			petLesSH = imgcon.pointEcolor(petStatsP[2], Color.BLACK);
		}else{
			petLesHP=false;
			petLesSH=false;
		}
		tl++;
		return false;
	}
	public boolean dropdownShown() {
		return imgcon.pointEcolor(petControlPoints[2],34,34,34);
	}
	public boolean petColecting(){
		
		return imgcon.pointEcolor(petStatsP[6],255,179,0);
	}
}
