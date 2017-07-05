package testPages;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import seeingComputer.MainObjects;

public class Timers {
	protected Timer timer= new Timer();
	public JLabel lblMap = new JLabel();
	public JLabel label = new JLabel("");
	private MainObjects mo=new MainObjects();
	private Point mappnt;
	private boolean start=true;
	private Point nmpnt = null;
	private Point shipPnt= new Point();
	private Point nmpnt1= new Point();
	private BufferedImage mapimg;
public void showShipPNT(){
	if(start){
		mo.search();
		mappnt= mo.imgcon.mapPoint;
		shipPnt=mo.shipPet.keapshipLock();
		start=false;
	 mapimg=mo.imgcon.screanImage(mappnt, 360, 220);
	 for(int y = 0;y<mapimg.getHeight();y++){
	 for(int x = 0;x<mapimg.getWidth();x++){
		 	 mapimg.setRGB(x, y,Color.black.getRGB());
		
	 }
	 }
	//lblMap.setIcon(new ImageIcon(mapimg));
	timer.scheduleAtFixedRate (
		    new TimerTask() {
		    	Point petpnt=new Point(0,0);
				public void run() {
					shipPnt=mo.shipPet.keapshipLock();
					if(shipPnt.x>mappnt.x&&shipPnt.y>mappnt.y){
					nmpnt = new Point(shipPnt.x-mappnt.x,shipPnt.y-mappnt.y);
					boolean[] pet = mo.shipPet.petnearShip(10,30);
					petpnt=mo.shipPet.petpnt;
					if(mo.imgcon.searchBoundries(mapimg,petpnt)){
					if(pet[0]){
						mapimg.setRGB(petpnt.x, petpnt.y,
								Color.red.getRGB());
					}
					if(pet[1]){
						System.out.println("trying to show where pet is ");
						mapimg.setRGB(petpnt.x, petpnt.y,
								Color.blue.getRGB());
						mapimg.setRGB(petpnt.x+1, petpnt.y,
								Color.blue.getRGB());
					}
					 }
					if(!nmpnt.equals(nmpnt1)){
					label.setText("("+nmpnt.x+","+nmpnt.y+")");
					mapimg.setRGB(nmpnt.x, nmpnt.y,
							Color.green.getRGB());
					}
					
					nmpnt1 = nmpnt;
					}
				}
		    }, 0, 1);
	}
	
	if(nmpnt!=null){
	lblMap.setIcon(new ImageIcon(mapimg));
	}
}
}
