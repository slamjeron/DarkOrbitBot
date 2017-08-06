package seeingComputer;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapControls.ShipPetTrack;
import pet.PetStats;
import userControls.ImgRobot;
import workingFinder.FindCargo;


public class MainObjects {
	public boolean mapf=false;
	public boolean shipstf=false;
	public boolean toolBarF=false;
	public boolean petstf=false;
	private Point toolbarPnt=new Point(0,0);
	private Point shipStatspnt=new Point(0,0);
	public Point mappnt=new Point(0,0);
	private Point petstat=new Point(0,0);
public ImgRobot imgcon = new ImgRobot();

public ToolBarinfo toolbar = new ToolBarinfo(imgcon);
public PetStats petSt = new PetStats(imgcon);
public ShipPetTrack shipPet = new ShipPetTrack(imgcon);
public FindCargo cargo=new FindCargo(imgcon,shipPet,petSt);
public void search(){
	mapf=false;
	shipstf=false;
	toolBarF=false;
	petstf=false;
	BufferedImage screenimg = imgcon.image.screanImage();
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
				(toolbarPnt.x-2,toolbarPnt.y-4,405,38)
				,new Rectangle(shipStatspnt.x-30,shipStatspnt.y-6,220,110)
				,new Rectangle(mappnt.x-42,mappnt.y-70,407,298)
				,new Rectangle(petstat.x-34,petstat.y-7,266,193)};
		shipPet.setMappnt(mappnt);
		cargo.setSkipZone(skipZone,mappnt);
		screenimg=colorRect(screenimg,skipZone);
		petSt.setPetstatp(petstat);
	}

		
	
	try {
		ImageIO.write(screenimg, "BMP", new File("stsearch"+".bmp"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//flylocate.setPoints(mappnt);
}
private BufferedImage colorRect(BufferedImage screenimg, Rectangle[] skipZone){
	for(Rectangle r:skipZone){
		//screenimg.setRGB(r.x, r.y, Color.red.getRGB());
		int ex = (int) (r.x+r.getWidth());
		int ey=(int) (r.y+r.getHeight());
		for(int x=r.x;x<ex;x++){
			screenimg.setRGB(x,r.y , Color.red.getRGB());
			screenimg.setRGB(x,ey, Color.red.getRGB());
		}
	}
	return screenimg;
}


private void petStats(BufferedImage img, int x, int y) {
	// TODO Auto-generated method stub
	if (imgcon.clogic.pointEcolor(img,x,y,232,225,191)&&
			imgcon.clogic.pointEcolor(img,x+21,y,36,43,46)&&
			imgcon.clogic.pointEcolor(img,x+11,y,51,49,46)
			) {
		petstf=true;
		petstat=new Point(x,y);
		//petSt.setPetstatp(petstat);
	}
}
	
private void toolbar(BufferedImage img, int x, int y) {
	// TODO Auto-generated method stub
	if(imgcon.clogic.pointEcolor(img,x,y,54 ,63 , 77)){
		toolBarF=true;
		toolbarPnt=new Point(x,y);
		//toolbar.setToolbarPnt(toolbarPnt);
	}
}
private void shipStats(BufferedImage img, int x, int y) {
	// TODO Auto-generated method stub
	if(imgcon.clogic.pointEcolor(img,x, y,232,225,191)
			&&imgcon.clogic.pointEcolor(img,x+2, y,232,225,191)
			&&imgcon.clogic.pointEcolor(img,x+1, y,232,225,191)
			&&imgcon.clogic.pointEcolor(img,x+7, y,67,58,47)
			&&imgcon.clogic.pointEcolor(img,x+11, y,33,42,45)){
		shipStatspnt=new Point(x,y);
		shipstf=true;
	}
		
}
private void MapPoint(BufferedImage img, int x, int y) {
	if( imgcon.clogic.pointEcolor(img, x, y,153 ,204 , 255)){
		mapf=true;
		mappnt=new Point(x,y);
		//shipPet.setMappnt(mappnt);
	}
	// TODO Auto-generated method stub
	
}

}
