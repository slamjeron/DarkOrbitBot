package checkStats;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import keyMouse.Keyboard;
import keyMouse.Mouse;
import objectFinder.ImgRobot;
import time.Increment;

public class PetActions {

	private Point panelPnt;
	private Rectangle petFuelRect;
	private Rectangle petHPRect;
	private Rectangle petSHRect;
	private Rectangle petEXPRect;
	public ImgRobot imgR;
	private BufferedImage image;
	public Mouse mouse;
	private int petFuel;
	private int petHP;
	private int petSD;
	private int petEXP;
	public Keyboard keyB;
	private int oldHP;
	private int oldSD;
	private Point comboBXpnt=new Point();
	private Rectangle comboBXrect;
	private boolean rct=false;
	private boolean cbtF=true;
	private boolean cBXDown;
	private boolean tradeF;
	private boolean autolootF;
	private boolean repairF;
	private boolean kamiF;
	private boolean gardF;
	//private Point kamiPnt;
	private Point repairPnt;
	private Point lootPnt;
	//private Point tradePnt;
	private int inkSD;
	private int inkHP;
	private int inkFD;
	private int inkEXP;
	private int maxHp=50000;
	private boolean islowHP=false;
	private int incRep;
	public boolean screenChanged;

	public void stopPet() {
		screenChanged=petBXMissing();
		if(!screenChanged){
			
		if(petEXP!=0)
			if(inc.increment1(25, 2))
			keyB.type("e");
		}
		
	}
	private Increment inc=new Increment();
	private Increment inc2=new Increment();
	private Point stBtnPnt=new Point();
	public void startPet() {
		if(petEXP<1){
		if(inc.increment1(25, 5)){
			if(stBtnPnt.x>1){
			mouse.rightclick(this.stBtnPnt);
			
			}else{
				int x1=panelPnt.x;
				int y1=panelPnt.y;
				stBtnPnt=new Point(x1+34,y1+115);
			}
			System.out.println(stBtnPnt);
		}
		}
		
		
	}
	public boolean gardMode(BufferedImage cbx, int x, int y) {
		return pointEcolor(cbx, x+3, y+3,162,117,13);
		
	}
	public void stAutoCargo(){
		boolean autoCG = isAutoCargo();
		if(!autoCG)
		if(petEXP!=0){
		keepCBDown();
		if(!islowHP)
			if(cBXDown)
				if(autolootF){
			mouse.rightclick(lootPnt);
		cBXDown=false;
				}
		}
	}
	public void stGardMode(){
		if(!isGardMode()){
			keyB.type("g");
		}
	}
	private boolean isGardMode() {
		// TODO Auto-generated method stub
		return goldCLR(image, panelPnt.x+121, panelPnt.y+109);
	}
	private boolean isAutoCargo() {
		// TODO Auto-generated method stub
		return pointEcolor(image, panelPnt.x+122, panelPnt.y+107,101,73,6);
	}
	public void findCBItems(){
	if(cbtF)
		if(petEXP!=0){
			int x1=comboBXrect.x;
			int y1=comboBXrect.y;
			stBtnPnt=new Point(x1+34,y1+115);
		keepCBDown();
		
		if(rct)
		if(cBXDown){
		BufferedImage cbx = this.imgR.image.subimg(image, comboBXrect);
		
		
		int x=8;
		for(int y=5;y<cbx.getHeight();y++){
			
			if(goldCLR2(cbx, x, y)){
				if(!tradeF)
				if(trade(cbx, x, y)){
					 y+=10;
					 tradeF=true;
				}
				
			}
			 if(goldCLR(cbx, x, y)){
				 if(!autolootF)
				if(autoLoot(cbx, x, y)){
					System.out.println("auto loot Found");
					lootPnt=new Point(x1+x+16,y1+y+3);
					 y+=20;
					 autolootF=true;
				}
				 if(!repairF)
				if(repair(cbx, x, y)){
					repairPnt=new Point(x1+x+16,y1+y+3);
					System.out.println("rep Found");
					repairF=true;
					 y+=10;
				}
				 if(!kamiF)
				if(kamikaze(cbx, x, y)){
					System.out.println("kamikazy Found");
					kamiF=true;
					 y+=10;
				}
				 if(!gardF)
				if(gardMode(cbx, x, y)){
					System.out.println("gard Found");
					gardF=true;
					 y+=10;
				}
				
				 this.stAutoCargo();
			 }
			
		}
		 mouse.rightclick(lootPnt);
		 cBXDown=false;
		cbtF=false;
			}
			
		}
		}
	private boolean trade(BufferedImage cbx, int x, int y) {
		// TODO Auto-generated method stub
		return pointEcolor(cbx, x-2, y+1,156,113,14);
	}
	private boolean kamikaze(BufferedImage cbx, int x, int y) {
		// TODO Auto-generated method stub
		return pointEcolor(cbx, x+3, y+6,251,176,0);
	}
	private boolean repair(BufferedImage cbx, int x, int y) {
		// TODO Auto-generated method stub
		return pointEcolor(cbx, x+4, y+4,183,131,10);
	}
	private boolean autoLoot(BufferedImage cbx, int x, int y) {
		// TODO Auto-generated method stub
		return pointEcolor(cbx, x+16, y+10,255,255,255);
	}
	private boolean goldCLR(BufferedImage cbx, int x, int y){
		return pointEcolor(cbx, x, y,255,179,0);
	}
	private boolean goldCLR2(BufferedImage cbx, int x, int y){
		return pointEcolor(cbx, x, y,251,176,0);
	}
	private boolean pointEcolor(BufferedImage cbx, int x, int y, int r, int g, int b){
		return imgR.clogic.pointEcolor(cbx, x, y,r,g,b);
	}
private void keepCBDown(){
	cBXDown=cBXDown();
	
	if(cBXDown){
		inc2.inc1=0;
	}else{
	if(inc2.increment1(25, 1))
		mouse.rightclick(comboBXpnt);
	}
}
	private boolean cBXDown() {
		// TODO Auto-generated method stub
		return imgR.clogic.pointEcolor(image,panelPnt.x+126,panelPnt.y+187,102,102,102);
	}
	public Point getPanelPnt() {
		return panelPnt;
	}
	public boolean isAtaked(){
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
		showFuelAmnt(fuelDig);
	
		setPetHP(imgR.number.readnum1(image, petHPRect));
		int hpDig = imgR.number.getDigits();
		showHPAmnt(hpDig);
		
		setPetSD(imgR.number.readnum1(image, petSHRect));
		int sdDig = imgR.number.getDigits();
		showSDAmnt(sdDig);
		
		setPetEXP(imgR.number.readnum1(image, petEXPRect));
		int expDig = imgR.number.getDigits();
		showEXPAmnt(expDig);
			
		
		
	}
	private void showFuelAmnt(int fuelDig) {
		if(fuelDig==0){
		if(inkFD==1){
				mouse.rightclick(petFuelRect.x+30, petFuelRect.y+7);
		}
		if(inkFD>30)
			inkFD=0;
		inkFD++;
		System.out.println(inkFD);
		}else{
			inkFD=2;
		}
	}
	private void showSDAmnt(int fuelDig) {
		if(fuelDig==0){
		if(inkSD==1){
				mouse.rightclick(petSHRect.x+30, petSHRect.y+7);
		}
		if(inkSD>30)
			inkSD=0;
		inkSD++;
		}else{
			inkSD=2;
		}
	}
	private void showHPAmnt(int fuelDig) {
		if(fuelDig==0){
		if(inkHP==1){
				mouse.rightclick(petHPRect.x+30, petHPRect.y+7);
		}
		if(inkHP>30)
			inkHP=0;
		inkHP++;
		}else{
			inkHP=2;
		}
	}
	private void showEXPAmnt(int fuelDig) {
		if(fuelDig==0){
		if(inkEXP==1){
				mouse.rightclick(petEXPRect.x+30, petEXPRect.y+7);
		}
		if(inkEXP>30)
			inkEXP=0;
		inkEXP++;
		}else{
			inkEXP=2;
		}
	}
	public void setPanelPnt(Point pnt) {
		this.panelPnt = pnt;
		comboBXpnt=addXYtoPnt(pnt,178,113);
		this.panelPnt = pnt;
		comboBXpnt=addXYtoPnt(pnt,178,113);
		comboBXrect=new Rectangle(pnt.x+130,pnt.y+180,30,150);
		petFuelRect=new Rectangle(pnt.x+180,pnt.y+49,75,8);
		petHPRect=new Rectangle(pnt.x+82,pnt.y+49,60,8);
		petSHRect=new Rectangle(pnt.x+82,pnt.y+69,60,8);
		petEXPRect=new Rectangle(pnt.x+188,pnt.y+69,60,8);
		rct=true;
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
	public void rep() {
		
		if(this.repairF){
			//System.out.println(maxHp);
		
		if(islowHP){
			if(incRep<9){
				keepCBDown();
				System.out.println("incRep ="+incRep);
			}
			if(cBXDown)
			if(incRep==10){
				System.out.println(islowHP+"="+petHP+"<="+maxHp);
				System.out.println(repairPnt);
			mouse.rightclick(repairPnt);
			}
			if(incRep>100){
				incRep=0;
				islowHP=false;
			}
			incRep++;
		}else{
			islowHP=(maxHp>petHP&&0!=petHP&&petEXP!=0);
			if(!islowHP)
			maxHp=petHP;
		}
		}
		
		
	}
	public void colect() {
		if(!petBXMissing()){
		findCBItems();
		startPet();
		stAutoCargo();
		rep();
		}
	}
public boolean petBXMissing(){
	return !pointEcolor(image, panelPnt.x+79, panelPnt.y+10,22,38,47);
	
}
}
