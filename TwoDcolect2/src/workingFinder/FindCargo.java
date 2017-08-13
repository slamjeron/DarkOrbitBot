package workingFinder;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JLabel;

import seeingComputer.ShipPetTrack;
import userControls.ImgRobot;
import workingFinder.Travel.Direction;
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

	public JLabel lblDirection=new JLabel();

	public JLabel lblNotMovingTime=new JLabel();;
	public JLabel lblTravelTime = new JLabel("travel time=");
	public JLabel lblShipXLocation = new JLabel("ship x location =");
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
		Point shipPoint = shipPet.findShip();
		int shx = shipPoint.x;
		lblDirection.setText("direction ="+nDir);
		lblNotMovingTime.setText("not moving time ="+stagnintTimer);
		lblTravelTime.setText("travel time ="+traveltime);
		
		lblShipXLocation.setText("ship x location ="+shx);
			if(!moving){
				stagnintTimer++;
			}else{
				stagnintTimer=0;
			}
			System.out.println(nDir);
		if(stagnintTimer>40){
			if(travel.dir==Direction.RIGHT){
			travel.dir=Direction.LEFT;
			}else{
				travel.dir=Direction.RIGHT;
				
			}
			travel.move=true;
			travel.moveRight();
			stagnintTimer=0;
		}
		
		if(!bonesboxfound){
			travel.inBounds(shipPoint);
			
			nDir=travel.dir;
			bonesboxfound =cbox.findBonesBox3(moving,nDir);
			wmove=true;
			setLooktime(getLooktime() + 1);
			
			if(!moving){
				if(traveltime>10){
				traveltime=0;
				}
				if(traveltime==4){
					travel.moveside();
					}
				traveltime++;
			}else{
				traveltime=0;
			}
			}else{
				if(moving){
					if(traveltime>60){
						sampt=0;
						traveltime=0;
						bonesboxfound=false;
						wmove=false;
						setLooktime(0);
					}
					traveltime++;
					}else{
						if(sampt>8){
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
