package seeingComputer;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class StaticInfo {
	private boolean mapf=false;
	private boolean shipstf=false;
	private boolean toolBarF=false;
	private boolean petstf=false;
	private Point toolbarPnt;
	private Point shipStatspnt;
	private Point mappnt=new Point(0,0);
	private Point petstat;
public GetImage imgcon = new GetImage();
public ToolBarinfo toolbar = new ToolBarinfo(imgcon);
public PetStats petSt = new PetStats(imgcon);
public mapinfo map = new mapinfo(imgcon);
public ShipStatus shipstat = new ShipStatus(imgcon);
public FlytoLocation flylocate = new FlytoLocation(imgcon);
private int spaceingint;
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
	flylocate.setPoints(mappnt);
}
public boolean active(){
	if(spaceingint>100){
	imgcon.printPColer(petstat.x-1,petstat.y);
	imgcon.printPColer(mappnt.x,mappnt.y-2);
	imgcon.printPColer(mappnt.x-1,mappnt.y-2);
	return (imgcon.pointEcolor(petstat.x,petstat.y,49,47,44)||
			imgcon.pointEcolor(petstat.x,petstat.y,49,47,44)||
			imgcon.pointEcolor(petstat.x,petstat.y,49,47,44));
	}
	return mapf;
		
	
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
		map.setMappnt(mappnt);
		imgcon.mapPoint=mappnt;
	}
	// TODO Auto-generated method stub
	
}

}
