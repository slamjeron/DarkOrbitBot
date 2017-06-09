package cargoSight;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import seeingComputer.GetImage;

public class bonesBoxsearch {

public GetImage imgcon = new GetImage();
	//public Petinfo pet = new Petinfo();
	protected Point palliePoint;
	public boolean cargoFound=false;
	
	public boolean click;
	public Point clickpoint;
	private int ct=0;
	private int cargoNotClose;
	private int onc;
	public Point mapPnt;
	private int somelse;
	private int oncargo;
	private boolean searchBoundries(int x,int y){
		return (y<imgcon.centerpt.y-60&&y>-(imgcon.centerpt.y-60)&&
				x<imgcon.centerpt.x-60&&x>-(imgcon.centerpt.x-60));
				
	}
	private boolean cargo(Color c){
		return(imgcon.colMoreLess(c, new Color(240,180,90)));
				
		}
	private boolean cargo2(Color c){
		return(imgcon.colMoreLess(c, new Color(160,120,60)));
				
		}
	public boolean Cargoonship(int xs,int ys){
		if(cargoFound){
			if(cargoNotClose>10){
				cargoNotClose=0;
				ct=26;
				cargoFound=false;
			}
			//System.out.println(cargoNotClose);
			
			ct++;
			cargoNotClose++;
			Point tp = new Point(imgcon.centerpt.x-130,imgcon.centerpt.y-54);
		BufferedImage img = imgcon.screanImage(tp,260,137);
		Point dp=new Point();
		int max=img.getWidth();
		for(int y= ys;y<img.getHeight()-5;y+=5){
			for(int x=xs;x<max-3;x+=5){
					if(cargo2(new Color(img.getRGB(x, y+5)))
							&&cargo2(new Color(img.getRGB(x, y)))&&
							cargo2(new Color(img.getRGB(x+1, y)))
							&&cargo2(new Color(img.getRGB(x+2, y)))){
						dp=new Point(tp.x+x,tp.y+y);
						if(ct>30){
				if(!click){
					clickpoint=dp;
					click=true;
					ct=26;
					
					
				}
						}
						
						
				
				return true;
					}
			}
		
		}
		
		}
		
		return false;
		
	}
	public boolean findBonesBox(int increment,int str){
		if(cargoFound){
		Point dell = new Point(imgcon.centerpt.x,(imgcon.centerpt.y+70));
		Point dell2 = new Point(imgcon.centerpt.x,(imgcon.centerpt.y+73));
		Point dell3 = new Point(imgcon.centerpt.x,(imgcon.centerpt.y+80));
		Color cl = imgcon.pointColor(dell);
		Color cl2 = imgcon.pointColor(dell2);
		Color cl3 = imgcon.pointColor(dell3);
		if(cargo(cl)||cargo(cl2)||cargo(cl3)){
			if(oncargo==1){
			click=true;
			clickpoint=new Point(imgcon.centerpt.x,imgcon.centerpt.y+80);
			}
			if(oncargo>4){
			cargoFound=false;
			oncargo=0;
			}
			oncargo++;
		}else{
			if(oncargo>0){
				cargoFound=false;
				oncargo=0;
			}
		}
		}else{
			cargoNotClose=0;
			ct=27;
		BufferedImage palieimg = imgcon.screanImage();
		Point dp=new Point();
		Point dp2=new Point();
		
		int max=imgcon.centerpt.x+200;
		for(int r=str;r<max;r+=increment){
		for(int y= (int)(-r/1.41);y<(int)(r/1.41)+1;y+=4){
			
			int x=pyththeorem(r, y);
			if(searchBoundries(x,y)){
				if(cargoFound){
					return true;
				}
				
			dp=new Point(imgcon.centerpt.x+x,imgcon.centerpt.y+y);
			dp2=new Point(imgcon.centerpt.x+-x,imgcon.centerpt.y+y);
			//System.out.println(centerpt);
		
			if(cargo(imgcon.pointColor(palieimg, dp2))
					||cargo(imgcon.pointColor(palieimg, dp))){
				if(seeifPntisCargo(palieimg,dp2.x,dp2.y)||
				seeifPntisCargo(palieimg,dp.x,dp.y)){
					
					
					return true;
					
				}
					}
			}
		}
		for(int x=(int)(-r/1.41);x<(int)(r/1.41);x+=3){
			if(cargoFound){
				return true;
			}
			int y=pyththeorem(r, x);
			if(searchBoundries(x,y)){
				
			dp=new Point(imgcon.centerpt.x+x,imgcon.centerpt.y+y);
			dp2=new Point(imgcon.centerpt.x+x,imgcon.centerpt.y+-y);
			
			
			if(cargo(imgcon.pointColor(palieimg, dp2))
					||cargo(imgcon.pointColor(palieimg, dp))){
				if(seeifPntisCargo(palieimg,dp2.x,dp2.y)||
						seeifPntisCargo(palieimg,dp.x,dp.y)){
					
					
					return true;
						}
			}
			}
		}
		}
		}
		return false;
		
	}
private int pyththeorem(int hp,int nownleg){
		return (int) Math.sqrt(Math.pow(hp, 2)-Math.pow(nownleg, 2));
	}
	
	private boolean seeifPntisCargo(BufferedImage img,int x,int y){
		
		if (cargo(new Color(img.getRGB(x, y)))
				&&cargo(new Color(img.getRGB(x, y+10)))
				&&cargo(new Color(img.getRGB(x+5, y+10)))
				&&cargo(new Color(img.getRGB(x+3, y+7)))) {
					//dFind(palliePoint);
			if(thisPaliePic(img.getSubimage(x-10, y-20, 60, 60))){
					// System.out.println(new Point(x,y));
				if(!click){
					clickpoint=new Point(x+5,y+5);
					click=true;
					cargoFound=true;
				}
					//img.colorPrint(new Color(pallieimg.getRGB(x, y)));
				
				return true;
			}
		}
		return false;
	}

	
	private boolean thisPaliePic(BufferedImage imPalie) {
		
		for (int y = 0; y < imPalie.getHeight(); y++) {
			for (int x = 0; x < imPalie.getWidth(); x++) {
				if (y == 1 || y == 2 || y == 59 || y == 60 ) {
					
					if (backGround(new Color(imPalie.getRGB(x, y)))) {
						//System.out.println(new Color(imPalie.getRGB(x, y)));
					} else {
						return false;
					}
				}
				if (x == 1 ||x == 50||x == 51) {
					//System.out.println(new Color(imPalie.getRGB(x, y)));
					if (backGround(new Color(imPalie.getRGB(x, y)))) {
						
					} else {
						return false;
						
					}
				}
				
				
			}
		}
		return true;
		 //System.out.println("work");
	}
	private boolean backGround(Color c){
		//colmore one first color>second color  return true
		return(imgcon.colMoreLess(new Color(130,130,130), c));
	}
}
