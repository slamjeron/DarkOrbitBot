package triangle;

public class RightTriangle {
	public double findhipotinose(double legA,double legB){
		this.legA=legA;
		this.legB=legB;
		return hipotinose=Math.sqrt((Math.pow(legA, 2)+Math.pow(legB, 2)));
	}
	public double findLeg(double legA,double hipotinose){
		this.legA=legA;
		if(hipotinose<legA){
			this.hipotinose=legA+1;
		}else{
			this.hipotinose=hipotinose;
		}
		return hipotinose=Math.sqrt((Math.pow(hipotinose, 2)-Math.pow(legA, 2)));
	}
	private double legA;
	private double legB;
	private double hipotinose;
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
