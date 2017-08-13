package checkStats;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import keyMouse.Keyboard;
import keyMouse.Mouse;
import objectFinder.ImgRobot;

public class PetActions {

	private Point panelPnt;
	private Rectangle petfuelRect;
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
		// TODO Auto-generated method stub
		
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
	public void readPetInfo(){
		 setPetFuel(imgR.number.readnum1(image, petfuelRect));
		 
		 setPetHP(imgR.number.readnum1(image, petHPRect));
		 
		 setPetSD(imgR.number.readnum1(image, petSHRect));
		 
		 setPetEXP(imgR.number.readnum1(image, petEXPRect));
		//System.out.println(petFuel);
		if(wClick==1)
		if(imgR.number.getDigits()==0)
			mouse.rightclick(petfuelRect.x+30, petfuelRect.y+7);
		
		 
		if(wClick==4){
			if(imgR.number.getDigits()==0)
				mouse.rightclick(petHPRect.x+20, petHPRect.y+6);
		}
		
			if(wClick==8){
				if(imgR.number.getDigits()==0)
					mouse.rightclick(petSHRect.x+20, petSHRect.y+6);
			}
			
			if(wClick==9){
				if(imgR.number.getDigits()==0)
					mouse.rightclick(petEXPRect.x+20, petEXPRect.y+6);
			}
		if(wClick>20){
			numLocated=true;
			wClick=0;
		}
		wClick++;
	}
	public void setPanelPnt(Point pnt) {
		numLocated=false;
		this.panelPnt = pnt;
		petfuelRect=new Rectangle(pnt.x+180,pnt.y+49,75,8);
		petHPRect=new Rectangle(pnt.x+82,pnt.y+49,60,8);
		petSHRect=new Rectangle(pnt.x+82,pnt.y+69,60,8);
		petEXPRect=new Rectangle(pnt.x+188,pnt.y+69,60,8);
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
