package userControls;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class textReader{
	
	private Rectangle screen=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	public final Point centerpt = new Point(screen.width/2,screen.height/2);
	public int scwidth=screen.width;
	public int scheight=screen.height;
	private int shipHP;
	private int shipSH;
	private readtxt rt;
	private int curintUritum;
	private int curintPetfuel;
	private int startingUridum;
	private int startingPetFuel;
	private int shipSpeed;
	private readnum numbers = new readnum();
	public displayANCalkinfo dispInfo= new displayANCalkinfo();
	private boolean petStarted=false;
	private boolean ufound=false;
	private int numpetHP;
	private int numpetSD;
	public boolean userFound=false;
	public boolean petFound=false;
	public boolean shipFound=false;
	public boolean mapFound=false;
	
	 
	public textReader(BufferedImage image) {
		if(image!=null){
			saveimg(image,"screen");
		}
	}
	public void start(BufferedImage image){
		
		rt = new readtxt();
		rt.imsearch(image);
		//readStats(image);
		BufferedImage speed = subimg(rt.nim1,rt.speedRect);
		shipSpeed=numbers.readnum1(speed);
		System.out.println("ship speed="+shipSpeed);
	}
	public void saveimg(BufferedImage im, String name){
		if(im!=null){
		File outputfile = new File(name+".png");
		try {
			ImageIO.write(im, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void readResorces(BufferedImage im, int min){
		
		if(rt.userPnt.x>2){
			BufferedImage uridum = subimg(im,rt.uridumRect);
			 int uri=numbers.readnum1(uridum);
				if(uri!=0){
					curintUritum=uri;
					if(!ufound){
						startingUridum=uri;
						System.out.println("uridum ="+curintUritum);
						ufound=true;
					}
					
				}
		}
		if(rt.petPnt.x>2){
			BufferedImage petfuel = subimg(im,rt.petfuelRect);
			int pt = numbers.readnum1(petfuel);
			if(pt!=0){
				if(curintPetfuel!=0)
				if(curintPetfuel<pt-500){
					try {
						Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				curintPetfuel=pt;
				if(!petStarted){
					startingPetFuel=pt;
					petStarted=true;
				}
			}
		}
		
		dispInfo.calk(min);
	}
	public void getStats(BufferedImage im){
		if(rt.shipPnt.x>2){
			BufferedImage health = subimg(im,rt.hpRect);
			BufferedImage shield = subimg(im,rt.shieldRect);
			 shipHP=numbers.readnum1(health);
		shipSH=numbers.readnum1(shield);
			}
	if(!cltest(im,rt.petHPPt,Color.green)&&
			!cltest(im,rt.petHPPt,Color.black)){
		if(rt.petPnt.x>2&&curintPetfuel!=0){
		BufferedImage petHP = subimg(im,rt.petHPRect);
		numpetHP = numbers.readnum1(petHP);
		BufferedImage petSD = subimg(im,rt.petHPRect);
		numpetSD = numbers.readnum1(petSD);
		}
	}else{
		
	}
}
	private BufferedImage subimg(BufferedImage nim, Rectangle r){
		int k=r.x+r.width;
		if(nim.getWidth()>k){
		return nim.getSubimage(r.x, r.y, r.width, r.height);
		}else{
			System.out.println("too big");
		return nim;
		}
	}
	private boolean cltest(BufferedImage im, Point p, Color color) {
		// TODO Auto-generated method stub
		return cltest(im,p.x,p.y,color);
	}
	
	private class readnum{
		private int num;
		private String nstr=new String();
	
	public int readnum1(BufferedImage im){
		nstr="";
         for(int l=2;l<im.getWidth();l++){
        	 if(!this.textcl(im, l-1, 0)){
 				if(this.textcl(im, l, 0)){
         		testnum(im,l);
         		nstr+=num;
 				}
 			}
         }
        
         if(nstr!=null&&nstr!=""){
        	 nstr.replaceAll("\\D+","");
        return Integer.parseInt(nstr);
         }else{
        	 return 0;
         }
       
         
	}
	public int testnum(BufferedImage im,int x){
		if( textcl(im,x+-1,3)&& textcl(im,x+2,3)){
			num=6;
			//System.out.println(6);
			return num;
		}
		if(textcl(im,x+1, 5)){
			if(textcl(im,x+-2, 4)){
				num=4;
				//System.out.println(num);
				return num;
			}else{
				num=1;
				//System.out.println(num);
				return num;
			}
		}
		if(textcl(im,x+0, 4)){
			num=2;
			//System.out.println(num);
			return num;
		}
		if(textcl(im,x-1,5)&&!textcl(im,x+3,6)
				&&!textcl(im,x+3,3)){
			num=3;
			//System.out.println(num);
			return num;
		}
		if(textcl(im,x+0, 2)){
			num=5;
			//System.out.println(num);
			return num;
		}
		if(textcl(im,x+2, 4)){
			num=7;
			//System.out.println(7);
			return num;
		}
		if(textcl(im,x+0,3)&& textcl(im,x+2,3)){
			num=8;
			//System.out.println(8);
			return num;
		}
		if(textcl(im,x+-1,3)&&textcl(im,x+0,3)){
			num=9;
			//System.out.println(num);
			return num;
		}
		if(textcl(im,x+-1,3)&& textcl(im,x+-1,4)){
			num=0;
			//System.out.println(num);
			return num;
		}
		return 12;
	}
	private boolean textcl(BufferedImage im,int x,int y){
		if(im.getWidth()>x&&x>0){
			Color cl = new Color(im.getRGB(x, y));
		return (cl.equals(new Color(222,222,222))||
				cl.equals(new Color(254,254,254)));
		}else{
			return false;
		}
	}
	private boolean maptextcl(BufferedImage im,int x,int y){
		if(im.getWidth()>x&&x>0){
			Color cl = new Color(im.getRGB(x, y));
		return cl.equals(new Color(255,255,255));
		}else{
			return false;
		}
	}
	}
	
	private class readtxt{
		public Rectangle petfuelRect;
		public Rectangle btkeyRect;
		public Rectangle creditsRect;
		public Rectangle uridumRect;
		public Point mapPnt=new Point(0,0);
		public Point shipPnt=new Point(0,0);
		public Point petPnt=new Point(0,0);
		public Point userPnt=new Point(0,0);
		public BufferedImage nim1;
		public BufferedImage nim;
		public Rectangle hpRect;
		public Rectangle shieldRect;
		public Rectangle cargoRect;
		public Rectangle speedRect;
		public Rectangle petHPRect;
		public Rectangle petSHRect;
		public Point petHPPt;
		public Point petSDPt;
		
		private void imsearch(BufferedImage im) {
			nim1=im;
			for(int y =0; y<im.getHeight();y+=100){
				for(int x=2;x<im.getWidth();x++){
					if((mapPnt.x-1<x&&mapPnt.x+3>x&&mapPnt.y+279>y))
						x+=400;
					if((shipPnt.x-1<x&&shipPnt.x+3>x&&shipPnt.y+110>y))
						x+=220;
					if((userPnt.x-1<x&&userPnt.x+3>x&&userPnt.y+100>y))
						x+=220;
					if((petPnt.x-1<x&&petPnt.x+3>x&&petPnt.y+190>y))
						x+=250;
					if(!borderCLR(im, x-1, y+1)
							&&!borderCLR(im, x-1, y)&&borderCLR(im, x, y)){
						
						if(!cltest(im,x+3, y,new Color(0,0,0))){
							
						findCorner(im,x,y);
						
						}
					}
				}
				}
			
			hpRect=new Rectangle(shipPnt.x+34,shipPnt.y+38,50,8);
			shieldRect=new Rectangle(shipPnt.x+34,shipPnt.y+55,50,8);
			cargoRect=new Rectangle(shipPnt.x+131,shipPnt.y+38,50,8);
			speedRect=new Rectangle(shipPnt.x+125,shipPnt.y+55,25,8);
			
			btkeyRect=new Rectangle(userPnt.x+138,userPnt.y+84,30,8);
			creditsRect=new Rectangle(userPnt.x+138,userPnt.y+33,75,8);
			uridumRect=new Rectangle(userPnt.x+138,userPnt.y+50,75,8);
			
			petfuelRect=new Rectangle(petPnt.x+180,petPnt.y+49,75,8);
			petHPRect=new Rectangle(petPnt.x+82,petPnt.y+49,60,8);
			petHPPt=new Point(petPnt.x+151,petPnt.y+58);
			petSHRect=new Rectangle(petPnt.x+82,petPnt.y+69,60,8);
			petSDPt=new Point(petPnt.x+151,petPnt.y+78);
		}
		
		private void findCorner(BufferedImage im, int x, int y) {
			//setnimcl(x, y, Color.yellow);
			int nint=-47;
			for(int in=50;in>1;in/=2){
				//System.out.println(nint);
				//System.out.println(in);
				if(borderCLR(im, x, y+nint)){
					//setnimcl(x, y+nint, Color.GREEN);
					nint-=in;
				}else{
					nint+=in;
					//setnimcl(x, y+nint, Color.RED);
				}
				if(in<4){
				fcorner(im,x,y+nint);
				}
			}
		}
		private void fcorner(BufferedImage im, int x, int y){
			boolean up = borderCLR(im,x,y);
				for(int i =0;i<5;i++){
					//System.out.println("up"+i);
					int n=0;
					if(up){
						n=-1*i;
					}else{
						n=i;
					}
						
					if(corner(im ,x, y+n)){
						if(textclr(im,x+34,y+n+4)&&textclr(im,x+83,y+n+16)){
							System.out.println("map");
						//printPoint(new Point(x,y+n));
							mapFound=true;
						mapPnt=new Point(x, y+n);
					}
						if(textclr(im,x+50,y+n+4)&&textclr(im,x+57,y+n+13)){
							System.out.println("Ship");
							shipFound=true;
							shipPnt=new Point(x, y+n);
					}
						if(textclr(im,x+65,y+n+12)&&textclr(im,x+43,y+n+13)){
							System.out.println("pet");
							petFound=true;
						petPnt=new Point(x, y+n);
					}
						if(cltest(im, x+16, y+n+32,new Color(233,226,191))){
							System.out.println("user");
							userFound=true;
						userPnt=new Point(x, y+n);
						
					}
						//System.out.println("foundCorner");
						//setnimcl(x, y+n, Color.BLUE);
						//checktype(im ,x, y+n);
						break;
					}else{
						//setnimcl(x, y+n, Color.WHITE);
					}
					}
			
		}
		
		private boolean corner(BufferedImage im, int x, int y){
			return borderCLR(im, x, y)&&borderCLR(im, x+1, y-1);
		}
		
		private boolean borderCLR(BufferedImage im, int x, int y) {
			return cltest(im,x,y,new Color(40,116,144));
			
		}
		private boolean textclr(BufferedImage im,int x,int y){
			
			return cltest(im,x,y,new Color(232,225,191));
			
		}
		
	}
	public class displayANCalkinfo{
		
		private String showStr="";
		public JLabel lblStats=new JLabel("Uster Stats");
		private String saveStr = "";
		private boolean da1=true;
		private boolean p1=true;
		
		public void calk(int min) {
			//System.out.println(ufound);
			
			int uGain = curintUritum-startingUridum;
			int fuleloss = startingPetFuel-curintPetfuel;
			double fuleCost=(double)(fuleloss)*.25;
			int netgain=(int) (uGain-fuleCost);
			int upmin=0;
			if(min!=0&&netgain!=0){
				upmin = netgain/min;
			}
			showStr="<html>User Stats"+"<br>"
			+"total uridum ="+ curintUritum
					+"<br>"+ "uridum gain ="+uGain
					+"<br>"+ "fuel loss ="+fuleloss
					+"<br>"+ "fuel cost ="+fuleCost
					+"<br>"+ "time colecting ="+min+"min"
					+"<br>"+ "uridum per min ="+upmin+"</html>";
			lblStats.setText(showStr);
			//openUser();
			
			boolean st = min==0;
			boolean cnt400=(min%400!=0);
			if(st^cnt400){
				if(da1){
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date today = new Date();
				String todayst = dateFormat.format(today);
				saveStr+=todayst+"\r \r";
				da1=false;
				}
			}else{
				da1=true;
			}
			boolean cnt10=(min%10!=0);
			if(cnt10){
				if(p1){
				if(showStr!=""){
					showStr=showStr.replaceAll("<br>","\r\n");
					showStr=showStr.replaceAll("<html>","\r\n");
					showStr=showStr.replaceAll("</html>","\r\n");
					saveStr+=showStr;
				}
				}
			}else{
				p1=true;
			}
		
		}
	
	}
	private boolean cltest(BufferedImage im, int x, int y, Color clr){
		if (x < im.getWidth() && y < im.getHeight() && x > 0 && y > 0) {
			
			Color cl = new Color(im.getRGB(x, y));
		return cl.equals(clr);
		}else{
			return false;
		}
	}
	
	
}
