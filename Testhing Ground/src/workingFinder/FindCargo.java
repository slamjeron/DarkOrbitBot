package workingFinder;

import java.awt.Rectangle;

import cargoSight.boxes3;
import imglogic.ImgRobot;
import seeingComputer.ShipPetTrack;
public class FindCargo  {
	private int traveltime;
	private Rectangle[] skipZone;
	private boolean bonesboxfound;
	private boolean wmove;
	private int sampt;
	public boxes3 cbox=new boxes3();
	private ShipPetTrack shipPet;
	private int looktime;
	//private MainObjects mObjects=new MainObjects();
	public FindCargo(ImgRobot imgcon, ShipPetTrack shipPet) {
		cbox.imgrob=imgcon;
		this.shipPet=shipPet;
		// TODO Auto-generated constructor stub
	}
	public void findCargo1(){
		cbox.findBonesBox3();
	}
	public void findCargo(){
		if(!bonesboxfound){
			bonesboxfound =cbox.findBonesBox3();
			
			wmove=true;
			setLooktime(getLooktime() + 1);
			}else{
				if(shipPet.moving()){
					if(traveltime>140){
						sampt=0;
						traveltime=0;
						bonesboxfound=false;
						wmove=false;
						setLooktime(0);
					}
					traveltime++;
					}else{
						if(sampt>30){
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
		
	}
	public int getLooktime() {
		return looktime;
	}
	public void setLooktime(int looktime) {
		this.looktime = looktime;
	}
	

}
