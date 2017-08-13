package shairing;

import java.awt.Point;

import mapControls.GateJumper;
import mapControls.ShipTrack;
import pet.PetStats;
import seeingComputer.MainObjects;
import seeingComputer.ToolBarinfo;
import userControls.ImgRobot;
import userControls.Mouse;
import workingFinder.FindCargo;

public class ShairInfo {

public ImgRobot imgcon = new ImgRobot();
public Mouse mouse = new Mouse();
public ToolBarinfo toolbar = new ToolBarinfo(imgcon);
public PetStats petSt = new PetStats(imgcon);
public ShipTrack shipPet = new ShipTrack(imgcon);
public FindCargo cargo=new FindCargo(imgcon,shipPet,petSt,mouse);
public MainObjects findObjects =new MainObjects();
public GateJumper gateJumper;
public ShairInfo(){
	findObjects.imgcon=imgcon;
}
public void setObjectLocations(){
	findObjects.search();
	Point mapPnt = findObjects.getMappnt();
	Point pet= findObjects.getPetstat();
	gateJumper=new GateJumper(mapPnt,mouse,imgcon.clogic);
	toolbar.setToolbarPnt(findObjects.getToolbarPnt());
	cargo.setSkipZone(findObjects.getSkipZone());
	cargo.travel.setMapPoint(mapPnt);
	shipPet.setMappnt(mapPnt);
	petSt.setPetstatp(pet);
}
}
