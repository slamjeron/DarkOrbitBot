package seeingComputer;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import cargoSight.boxes;
import imglogic.GetImage;


public class MainObjects {
	public boolean mapf=false;
	public boolean shipstf=false;
	public boolean toolBarF=false;
	public boolean petstf=false;
	private Point toolbarPnt=new Point(0,0);
	private Point shipStatspnt=new Point(0,0);
	private Point mappnt=new Point(0,0);
	private Point petstat=new Point(0,0);
public GetImage imgcon = new GetImage();
public ToolBarinfo toolbar = new ToolBarinfo(imgcon);
public PetStats petSt = new PetStats(imgcon);
public ShipPetTrack shipPet = new ShipPetTrack(imgcon);
public ShipStatus shipstat = new ShipStatus(imgcon);
public FlytoLocation flylocate = new FlytoLocation(imgcon);
private int spaceingint;
public boxes colect=new boxes(imgcon);
public void search(){
	mapf=false;
	shipstf=false;
	toolBarF=false;
	petstf=false;
	BufferedImage screenimg = imgcon.screanImage();
	for (int y = 100; y < screenimg.getHeight()-100 ; y++) {
		for (int x = 3; x < screenimg.getWidth()-100; x++) {	
				 //comcon.moveCursor(x,y);
			if(!mapf){
			MapPoint(screenimg,x,y);
			
			}
			if(!shipstf){
			shipStats(screenimg,x,y);
			}
			if(!petstf){
			petStats(screenimg,x,y);
			}
			if(!toolBarF){
			toolbar(screenimg,x,y);
			}
		}
	}
	if(mapf&&shipstf&&petstf&&toolBarF){
		Rectangle[] skipZone={new Rectangle
				(toolbarPnt.x,toolbarPnt.y,370,30)
				,new Rectangle(shipStatspnt.x-20,shipStatspnt.y,200,102)
				,new Rectangle(mappnt.x,mappnt.y,360,230)
				,new Rectangle(petstat.x,petstat.y,236,183)};
		colect.skipZone=skipZone;
	}
	flylocate.setPoints(mappnt);
}
public boolean active(){
	return (imgcon.pointEcolor(petstat.x,petstat.y,49,47,44)||
			imgcon.pointEcolor(petstat.x,petstat.y,49,47,44)||
			imgcon.pointEcolor(petstat.x,petstat.y,49,47,44));
}
private void petStats(BufferedImage img, int x, int y) {
	// TODO Auto-generated method stub
	if (imgcon.pointEcolor(img,x,y,232,225,191)&&
			imgcon.pointEcolor(img,x+21,y,36,43,46)&&
			imgcon.pointEcolor(img,x+11,y,51,49,46)
			) {
		petstf=true;
		petstat=new Point(x,y);
		petSt.setPetstatp(petstat);
	}
}
	
private void toolbar(BufferedImage img, int x, int y) {
	// TODO Auto-generated method stub
	if(imgcon.pointEcolor(img,x,y,54 ,63 , 77)){
		toolBarF=true;
		toolbarPnt=new Point(x,y);
		toolbar.setToolbarPnt(toolbarPnt);
	}
}
private void shipStats(BufferedImage img, int x, int y) {
	// TODO Auto-generated method stub
	if(imgcon.pointEcolor(img,x, y,232,225,191)
			&&imgcon.pointEcolor(img,x+2, y,232,225,191)
			&&imgcon.pointEcolor(img,x+1, y,232,225,191)
			&&imgcon.pointEcolor(img,x+7, y,67,58,47)
			&&imgcon.pointEcolor(img,x+11, y,33,42,45)){
		shipStatspnt=new Point(x,y);
		shipstat.setShipStatpnt(shipStatspnt,imgcon);
		shipstf=true;
	}
		
}
private void MapPoint(BufferedImage img, int x, int y) {
	if( imgcon.pointEcolor(img, x, y,153 ,204 , 255)){
		mapf=true;
		mappnt=new Point(x,y);
		shipPet.setMappnt(mappnt);
		imgcon.mapPoint=mappnt;
	}
	// TODO Auto-generated method stub
	
}

}
