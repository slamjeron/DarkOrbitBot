package workingFinder;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

import mapControls.ShipPetTrack;
import mapControls.Travel;
import mapControls.Travel.Direction;
import pet.PetControler;
import pet.PetStats;
import userControls.ImgRobot;
public class FindCargo  {
	private int traveltime;
	
	private Rectangle[] skipZone;
	private boolean bonesboxfound=false;
	private boolean wmove;
	private int sampt;
	public bonesBox cbox=new bonesBox();
	private ShipPetTrack shipPet;
	private int looktime;

	public Travel travel;

	public int stagnintTimer;

	public Direction nDir;

	public JLabel lblDirection=new JLabel("direction =");

	public JLabel lblNotMovingTime=new JLabel("moving timer =");;
	public JLabel lblTravelTime = new JLabel("travel time=");
	public JLabel lblShipXLocation = new JLabel("ship x location =");

	public PetControler pet;

	
	//private MainObjects mObjects=new MainObjects();
	public FindCargo(ImgRobot imgcon, ShipPetTrack shipPet, PetStats petSt) {
		pet=new PetControler(petSt,cbox);
		cbox.imgrob=imgcon;
		this.shipPet=shipPet;
		//travel.mouse=cbox.mouse;
		// TODO Auto-generated constructor stub
	}
	public void findCargo1(){
		travel.mouse=cbox.mouse;
	}
	public void findCargo(){
		
		pet.start();
		pet.colect();
		boolean moving = shipPet.moving();
		Point shipPoint = shipPet.findShip();
		int shx = shipPoint.x;
		lblDirection.setText("direction ="+nDir);
		lblNotMovingTime.setText("not moving time ="+stagnintTimer);
		lblTravelTime.setText("travel time ="+traveltime);
		lblShipXLocation.setText("ship x location ="+shx);
		travel.inBounds(shipPoint);
		
			if(!moving){
				stagnintTimer++;
			}else{
				stagnintTimer=0;
			}
			
		if(stagnintTimer>40){
			if(travel.dir==Direction.RIGHT){
			travel.dir=Direction.LEFT;
			}else{
				travel.dir=Direction.RIGHT;
			}
			travel.sethight();
			travel.move=true;
			stagnintTimer=0;
		}
		
		if(!bonesboxfound){
			wmove=true;
			setLooktime(getLooktime() + 1);
			
			if(!moving){
				
				if(traveltime>6)
				traveltime=0;
				
				if(traveltime==2)
					travel.moveside();
					
				traveltime++;
			}else{
				traveltime=0;
			}
			}else{
				if(moving){
					if(traveltime>20){
						sampt=0;
						traveltime=0;
						bonesboxfound=false;
						wmove=false;
						setLooktime(0);
					}
					traveltime++;
					}else{
						if(sampt>5){
						if(wmove){
						sampt=0;
						traveltime=0;
						bonesboxfound=false;
						wmove=false;
						setLooktime(0);
						}
						}
						sampt++;
					}
			}
	}
	public void findBonesBoxes(){
		if(!bonesboxfound){
		nDir=travel.dir;
		bonesboxfound =cbox.findBonesBox3();
		}
	}
	public void reset(){
		sampt=0;
		traveltime=0;
		bonesboxfound=false;
		wmove=false;
		setLooktime(0);
	}
	public Rectangle[] getSkipZone() {
		return skipZone;
	}
	public void setSkipZone(Rectangle[] skipZone,Point p) {
		this.skipZone = skipZone;
		cbox.setSkipZone(skipZone);
		travel=new Travel();
		travel.setMapPoint(p);
	}
	public int getLooktime() {
		return looktime;
	}
	public void setLooktime(int looktime) {
		this.looktime = looktime;
	}
	

}
