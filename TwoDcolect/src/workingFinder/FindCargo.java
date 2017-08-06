package workingFinder;

import java.awt.Point;
import java.awt.Rectangle;
import seeingComputer.ShipPetTrack;
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

	private Travel travel;

	
	//private MainObjects mObjects=new MainObjects();
	public FindCargo(ImgRobot imgcon, ShipPetTrack shipPet) {
		cbox.imgrob=imgcon;
		this.shipPet=shipPet;
		//travel.mouse=cbox.mouse;
		// TODO Auto-generated constructor stub
	}
	public void findCargo1(){
		travel.mouse=cbox.mouse;
	}
	public void findCargo(){
		boolean moving = shipPet.moving();
		Point shipPoint = shipPet.keapshipLock();
		
			travel.inBounds(shipPoint);
		
		
		if(!bonesboxfound){
			bonesboxfound =cbox.findBonesBox3();
			wmove=true;
			setLooktime(getLooktime() + 1);
			
			if(!moving){
				if(traveltime>8){
				traveltime=0;
				}
				if(traveltime==2){
					travel.moveside();
					}
				traveltime++;
			}
			}else{
				if(moving){
					if(traveltime>140){
						sampt=0;
						traveltime=0;
						bonesboxfound=false;
						wmove=false;
						setLooktime(0);
					}
					traveltime++;
					}else{
						if(sampt>10){
						if(wmove){
						System.out.println("travle="+traveltime);
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
	public Rectangle[] getSkipZone() {
		return skipZone;
	}
	public void setSkipZone(Rectangle[] skipZone) {
		this.skipZone = skipZone;
		cbox.setSkipZone(skipZone);
		travel=new Travel();
		travel.mapPoint=new Point(skipZone[2].x,skipZone[2].y);
	}
	public int getLooktime() {
		return looktime;
	}
	public void setLooktime(int looktime) {
		this.looktime = looktime;
	}
	

}
