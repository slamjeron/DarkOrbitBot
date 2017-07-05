package cargoSight;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import seeingComputer.GetImage;
import takeAction.NormalColect;

public class bonesBoxsearch {

public GetImage imgcon;
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
	private boolean pfound;
	private BufferedImage pallieimg;
	private boolean moving;
	private int movetime;
	private int clickcount;
	private boolean wcg=true;
	private int numpnt;
	private Point petst;
	private Point mst;
	public void setpts(Point petstat,Point mystats){
		petst=petstat;
		mst=mystats;
	}
	public bonesBoxsearch(GetImage imgcon2) {
		// TODO Auto-generated constructor stub
		
		imgcon=imgcon2;
	}
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
			
			if(moving){
				if(movetime>12){
					setCt(0);
					cargoFound=false;
				}
				movetime++;
			}else{
				if(getCargoNotClose()>3){
					cargoFound=false;
				}
				setCargoNotClose(getCargoNotClose() + 1);
			}
			if(!moving||movetime>2){
				if(ct!=0){
				ct++;
				
				}
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
						if(getCt()>2){
							setCt(0);
						}
						if(getCt()==0){
				if(!click){
					if(clickcount>2){
						
						cargoFound=false;
						
					}
					clickcount++;
					clickpoint=dp;
					click=true;
					cargoNotClose=0;
					ct++;
				}
						}
						
						
				
				return true;
					}
			}
		
		}
		
		}
			
		}
		return false;
		
	}
 	public boolean cargo(boolean moving, NormalColect colect){
 		this.moving=moving;
		boolean mf=false;
		if(cargoFound){
			
			Point dell = new Point(imgcon.centerpt.x,
					(imgcon.centerpt.y+70));
			Point dell2 = new Point(imgcon.centerpt.x,
					(imgcon.centerpt.y+73));
			Point dell3 = new Point(imgcon.centerpt.x,
					(imgcon.centerpt.y+80));
			Color cl = imgcon.pointColor(dell);
			Color cl2 = imgcon.pointColor(dell2);
			Color cl3 = imgcon.pointColor(dell3);
			if(cargo(cl)||cargo(cl2)||cargo(cl3)){
				
				if(oncargo==1){
				click=true;
				clickpoint=new Point(imgcon.centerpt.x,imgcon.centerpt.y+80);
				}
				if(oncargo>1){
					if(numpnt<1){
					colect.stmove();
					}
				cargoFound=false;
				setCt(0);
				setCargoNotClose(0);
				oncargo=0;
				
				wcg=true;
				
				}
				oncargo++;
			}else{
				if(oncargo>0){
					cargoFound=false;
					oncargo=0;
				}
			}
		}else{
			clickcount=0;
			cargoNotClose=0;
			movetime=0;
			clickcount=0;
			ct=0;
		Point[] bbPNts=new Point[20];
		//stpt=new Point(100,100);
		if(wcg){
			if(oncargo>1){
				oncargo=0;
				wcg=false;
			}
			oncargo++;
		}else{
		pallieimg = this.imgcon.screanImage();
				//aleanLoked=img.compScPxtoCol(new Point(aleanLock.x+stpt.x,aleanLock.y+stpt.y), new Color(204,0, 0));						
				int pntcnt=0;
				int pcount=0;
				//System.out.println(rect.height/2-100);
				
					for(int y1 =150;y1<pallieimg.getHeight()-150;y1+=3){
						if(!pfound){
							y1+=10;
							
						}
						pfound=false;
					for(int x1=150; x1<pallieimg.getWidth()-150;x1++){
						int ptsx = petst.x;
						int ptsy = petst.y;
						int shptx = mst.x;
						int shpty = mst.y;
						int mpx = imgcon.mapPoint.x;
						int mpy = imgcon.mapPoint.y;
						x1=imgcon.twoPntSkip(x1,y1, mpx-22,mpy-50, mpx+320,mpy+261);
						x1=imgcon.twoPntSkip(x1,y1, ptsx,ptsy, ptsx+230,ptsy+180);
						x1=imgcon.twoPntSkip(x1,y1, shptx,ptsy, shptx+186,shptx+90);
						pcount++;
						if(!cargo(new Color(pallieimg.getRGB(x1, y1)))&&
						!cargo(new Color(pallieimg.getRGB(x1+10, y1)))){
							x1+=10;
						}else{
							pfound=true;
						}
						
						
						if(!cargo(new Color(pallieimg.getRGB(x1+10, y1+17)))&&
						!cargo(new Color(pallieimg.getRGB(x1, y1+10)))){
							
						}else{
							pfound=true;
						}
						if(seeifPntisCargo(pallieimg,x1,y1)){
							bbPNts[pntcnt]=new Point(x1,y1);
							 mf = true;
							 pntcnt++;
						}
						
					}
					}
					//System.out.println(pcount);
					clickpoint=null;
					if(mf){
					int[] e =new int[20];
					int i=0;
					numpnt=0;
					for(Point p:bbPNts){
						if(p!=null){
							e[i]=findHipotinus(imgcon.centerpt,p);
							numpnt++;
							i++;
						
						}else{
							break;
						}
					}
					
					int small = 6000;
					
					 for(int l=0;l<20;l++){
						//System.out.println(e[l]);
						 if(bbPNts[l]==null){
							 break;
						 }
						 if(e[l]>0){
						if(small>e[l]){
							
							small=e[l];
							clickpoint=new Point(bbPNts[l].x+5,bbPNts[l].y+5);
							click=true;
							cargoFound=true;
							movetime=0;
						}
						 }
						
					}
					}
		}
		}
					return mf=true;
	}
 	
	private int findHipotinus(Point p, Point p1){
		int x = p.x- p1.x;
		int y=p.y- p1.y;
		if(x<0){
			x=x*(-1);
		}
		if(y<0){
			y=y*(-1);
		}
		
		return pyththeore(x,y);
	}
	private int pyththeore(int hp,int nownleg){
		return (int) Math.sqrt((Math.pow(hp, 2)+Math.pow(nownleg, 2)));
	}
	
	public boolean findBonesBox(int increment,int str){
		if(cargoFound){
		Point dell = new Point(imgcon.centerpt.x,
				(imgcon.centerpt.y+70));
		Point dell2 = new Point(imgcon.centerpt.x,
				(imgcon.centerpt.y+73));
		Point dell3 = new Point(imgcon.centerpt.x,
				(imgcon.centerpt.y+80));
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
			setCargoNotClose(0);
			setCt(27);
		BufferedImage palieimg = imgcon.screanImage();
		Point dp=new Point();
		Point dp2=new Point();
		
		int max=imgcon.centerpt.x+200;
		for(int r=str;r<max;r+=increment){
		for(int y= (int)(-r/1.41);y<(int)(r/1.41)+1;y+=4){
			
			int x=pyththeorem(r, y);
			if(!imgcon.scipMap(x, y)){
				break;
			}
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
			if(!imgcon.scipMap(x, y)){
				break;
			}
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
				for(int y1=y-20;y1<y+40;y1++){
					for(int x1=x-10;x1<x+50;x1++){
					pallieimg.setRGB(x1, y1,new Color(0,0,0).getRGB());
					}
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
	public int getCt() {
		return ct;
	}
	public void setCt(int ct) {
		this.ct = ct;
	}
	public int getCargoNotClose() {
		return cargoNotClose;
	}
	public void setCargoNotClose(int cargoNotClose) {
		this.cargoNotClose = cargoNotClose;
	}
}
