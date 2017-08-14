package checkStats;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import keyMouse.Keyboard;
import keyMouse.Mouse;
import objectFinder.ImgRobot;

public class PetActions {

	private Point panelPnt;
	private Rectangle petFuelRect;
	private Rectangle petHPRect;
	private Rectangle petSHRect;
	private Rectangle petEXPRect;
	public ImgRobot imgR;
	private BufferedImage image;
	public Mouse mouse;
	private int wClick;
	private int petFuel;
	private int petHP;
	private int petSD;
	private int petEXP;
	public Keyboard keyB;
	private int stime;
	private boolean numLocated=false;
	private int oldHP;
	private int oldSD;
	private Point comboBXpnt;
	private Rectangle comboBXrect;
	private Rectangle cmBXSelectRct;

	public void stopPet() {
		if(stime==1)
		if(petEXP!=0)
			keyB.type("e");
		if(stime>25)
			stime=0;
		stime++;
		
	}
	public void startPet() {
		if(stime==1)
		if(petEXP==0)
			keyB.type("e");
		if(stime>25)
			stime=0;
		stime++;
		
	}
	public void gardMode() {
		
		mouse.rightclick(comboBXpnt);
		
	}
	public void findCBItems(){
		mouse.rightclick(comboBXpnt);
		this.imgR.image.subimg(image, comboBXrect);
	}
	public Point getPanelPnt() {
		return panelPnt;
	}
	public boolean isPetAtaked(){
		boolean hit = (hitCheck(oldHP,getPetHP(),oldSD,getPetSD()));
		oldHP=getPetHP();
		oldSD=getPetSD();
		return hit;
		
	}
	private boolean hitCheck(int oldHP,int newHP,int oldSD,int newSD){
		return(oldHP!=0&&newHP!=0&&oldSD!=0&&newSD!=0&&
				oldHP>newHP&&oldSD>newSD);
	}
	public void readInfo(){
		 setPetFuel(imgR.number.readnum1(image, petFuelRect));
		int fuelDig = imgR.number.getDigits();
	if(wClick==1){
		if(fuelDig==0){
			mouse.rightclick(petFuelRect.x+30, petFuelRect.y+7);
		}
	}
		setPetHP(imgR.number.readnum1(image, petHPRect));
		int hpDig = imgR.number.getDigits();
		if(wClick==4){
			if(hpDig==0){
				mouse.rightclick(petHPRect.x+20, petHPRect.y+6);
			}
		}
		setPetSD(imgR.number.readnum1(image, petSHRect));
		int sdDig = imgR.number.getDigits();
		
			if(wClick==8){
				if(sdDig==0){
					mouse.rightclick(petSHRect.x+20, petSHRect.y+6);
				}
			}
			 setPetEXP(imgR.number.readnum1(image, petEXPRect));
			 int expDig = imgR.number.getDigits();
			if(wClick==9){
				if(expDig==0){
					mouse.rightclick(petEXPRect.x+20, petEXPRect.y+6);
				}
			}
		if(wClick>15){
			//numLocated=true;
			System.out.println(wClick);
			wClick=0;
		}
		wClick++;
		
	}
	public void setPanelPnt(Point pnt) {
		numLocated=false;
		this.panelPnt = pnt;
		comboBXpnt=addXYtoPnt(pnt,178,113);
		cmBXSelectRct=new Rectangle(pnt.x+119,pnt.y+100,21,23);
		comboBXrect=new Rectangle(pnt.x+130,pnt.y+186,30,100);
		petFuelRect=new Rectangle(pnt.x+180,pnt.y+49,75,8);
		petHPRect=new Rectangle(pnt.x+82,pnt.y+49,60,8);
		petSHRect=new Rectangle(pnt.x+82,pnt.y+69,60,8);
		petEXPRect=new Rectangle(pnt.x+188,pnt.y+69,60,8);
	}
	public Point addXYtoPnt(Point pnt,int x, int y){
		return new Point(pnt.x+x,pnt.y+y);
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getPetEXP() {
		return petEXP;
	}

	public void setPetEXP(int petEXP) {
		this.petEXP = petEXP;
	}

	public int getPetSD() {
		return petSD;
	}

	public void setPetSD(int petSD) {
		this.petSD = petSD;
	}

	public int getPetHP() {
		return petHP;
	}

	public void setPetHP(int petHP) {
		this.petHP = petHP;
	}

	public int getPetFuel() {
		return petFuel;
	}

	public void setPetFuel(int petFuel) {
		this.petFuel = petFuel;
	}

}
