package userControls2;

import java.awt.Point;

public class Rtriangle {
	public Point changePointPositive(int x, int y) {
		if(x<0){
			x=x*(-1);
		}
		if(y<0){
			y=y*(-1);
		}
		return new Point(x,y);
	}
	public Point changePointPositive( Point p) {
		return changePointPositive(p.x,p.y);
	}
	public double findhipotinose(double legA,double legB){
		this.legA=legA;
		this.legB=legB;
		slope=legA/legB;
		return hipotinose=Math.sqrt((Math.pow(legA, 2)+Math.pow(legB, 2)));
	}
	
	public double findLeg(double legA,double hipotinose){
		this.legA=legA;
		if(hipotinose<legA){
			this.hipotinose=legA+1;
		}else{
			this.hipotinose=hipotinose;
		}
		return legB=Math.sqrt((Math.pow(hipotinose, 2)-Math.pow(legA, 2)));
	}
	private double legA;
	private double legB;
	private double hipotinose=0;
	private double slope=0;
	public void findSlope(int x,int y){
		slope=y/x;
	}
	public double findhipotinose(Point p1,Point p2) {
		int x=p1.x-p2.x;
		int y=p1.y-p2.y;
		if(x!=0&&y!=0){
		findSlope(x,y);
		hipotinose=findhipotinose(x,y);
		}else{
			if(x==0){
				hipotinose=y;
			}else{
				hipotinose=x;
			}
		}
		
		return hipotinose;
	}
	public double getSlope() {
		return slope;
	}
	public void setSlope(double slope) {
		this.slope = slope;
	}
	public double getHight() {
		return legB;
	}
	public void setHight(double hight) {
		this.legB = hight;
	}
	public double getWidth() {
		return legA;
	}
	public void setWidth(double width) {
		this.legA = width;
	}
	public double getHipotinose() {
		return hipotinose;
	}
	public void setHipotinose(double hipotinose) {
		this.hipotinose = hipotinose;
	}
	
}
