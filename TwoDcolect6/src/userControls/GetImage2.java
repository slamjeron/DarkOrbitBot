package userControls;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import gui.ColectRobot;

public class GetImage2 {
	
	private Rectangle screen=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	public final Point centerpt = new Point(screen.width/2,screen.height/2);
	public int scwidth=screen.width;
	public int scheight=screen.height;
	private Robot rob;
	public searchMath smath;
	public GetImage2(Robot rob) {
		this.rob=rob;
		
	}
	public Color[][] numcolors = new Color[][]
			{{new Color(157,159,160),
		new Color(222,222,222),
		new Color(222,222,222),
		new Color(222,222,222),
		new Color(216,217,217)
		},{
			new Color(70,73,79),
			new Color(222,222,222),
			new Color(222,222,222),
			new Color(179,180,181),
		},{
			new Color(169,170,172),
			new Color(222,222,222),
			new Color(222,222,222),
			new Color(222,222,222),
			new Color(196,196,197)
			},{
				new Color(188,189,190),
				new Color(222,222,222),
				new Color(222,222,222),
				new Color(222,222,222),
				new Color(198,198,199)
			},{
				new Color(107,110,114),
				new Color(222,222,222),
				new Color(222,222,222),
				new Color(179,180,181)},{
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(222,222,222)
				},{
					new Color(157,159,161),
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(222,222,222),
					
				},{
					//7
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(222,222,222)
				},{
					new Color(186,186,188),
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(198,199,200)
				},{
					new Color(184,185,186),
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(222,222,222),
					new Color(192,192,193)
				}};
	private int car;
	private int cn;
	private boolean tl;
	private String str;
	private int num;
	private ArrayList<ArrayList<Color>> colAray=new ArrayList<ArrayList<Color>>() ;
	private String nstr="";
	
	public GetImage2() {
		numtest();
	}
	public void numtest(){
		try{
		/*	for(int tn=1;tn<7;tn++){
				nstr="";
				System.out.println("page"+tn);
			BufferedImage im = (BufferedImage)(ImageIO.read(new File("num"+tn+".png")));
			readnum(im);
			}*/
				System.out.println("page"+6);
			BufferedImage im = (BufferedImage)(ImageIO.read(new File("num"+3+".png")));
			readnum(im);
			
			
	 } catch (IOException e) {
         e.printStackTrace();
     }
	}
	public void readnum(BufferedImage im){
		
         
         for(int l=1;l<im.getWidth();l++){
         		l=l+numcl(im,l);
         		
         }
        System.out.println(nstr);
         
	}
	public int numcl(BufferedImage im,int x){
		
		 
			Color clr=new Color(im.getRGB(x-1, 0));
		if((clr.getRed()<59)){
			if(!(new Color(im.getRGB(x, 0)).getRed()<59)){
				printNumberPoints(im,x);
				numbertest(im,x);
				nstr+=""+num;
			}
		}
		
		return 0;
	}
	public void printNumberPoints(BufferedImage im, int x){
		 ArrayList<Color> cl=new ArrayList<Color>();
			for(int i =0;i<5;i++){
				Color clor = new Color(im.getRGB(x+i, 0));
				
				cl.add(clor);
				if(clor.getRed()<59)
					break;
				
			}
			cn=0;
			
			colAray.add(cl);
			String ns="if(";
			for(Color dl:cl){
				ns=ns+printColor(dl);
				cn++;
			}
			ns=ns.substring(0, ns.length() - 3);
			ns=ns+"){\n\n}";
			System.out.println(ns);
			
	}
public String printColor(Color cl){
		
		return("new Color("+cl.getRed()+","+cl.getGreen()
		+","+cl.getBlue()+").equals(new Color(im.getRGB(x+"+cn+",0)))&&\n");
	}
	public void numbertest(BufferedImage im,int x){
		if(new Color(156,158,160).equals
				(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals
				(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals
				(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222).equals
				(new Color(im.getRGB(x+3,0)))&&
				new Color(206,206,207).equals
				(new Color(im.getRGB(x+4,0)))){
			num=0;
				}
		if(new Color(168,170,171).equals
				(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+3,0)))&&
				new Color(195,196,197,255).equals
				(new Color(im.getRGB(x+4,0)))){
			//System.out.println("2");
			num=2;
				}
		
				if(new Color(156,158,160,255).equals
				(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+3,0)))&&
				new Color(206,206,207,255).equals
				(new Color(im.getRGB(x+4,0)))){
					//System.out.println("6");
					num=6;
				}
				if(new Color(105,108,111,255).equals
				(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+2,0)))&&
				new Color(178,179,180,255).equals
				(new Color(im.getRGB(x+3,0)))&&
				new Color(27,33,38,255).equals
				(new Color(im.getRGB(x+4,0)))){
					//System.out.println("4");
					num=4;
				}
				if(new Color(185,186,187,255).equals
				(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222,255).equals
				(new Color(im.getRGB(x+3,0)))&&
				new Color(198,199,199,255).equals
				(new Color(im.getRGB(x+4,0)))){
					//System.out.println("8");
					num=8;
				}

		if(new Color(157,159,160).equals(new Color(im.getRGB(x+0,0)))&&
		new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
		new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
		new Color(222,222,222).equals(new Color(im.getRGB(x+3,0)))&&
		new Color(216,217,217).equals(new Color(im.getRGB(x+4,0)))
		){
		//System.out.println(0);
		num=0;
		}
		
		if(
				new Color(67,72,76).equals(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
				new Color(178,179,180).equals(new Color(im.getRGB(x+3,0)))
				){
				//System.out.println(1);
				num=1;
				}
				
				if(
				new Color(169,170,172).equals(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+3,0)))&&
				new Color(196,196,197).equals(new Color(im.getRGB(x+4,0)))
				){
				//System.out.println(2);
				num=2;
				}
				if(
				new Color(188,189,190).equals(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+3,0)))&&
				new Color(198,198,199).equals(new Color(im.getRGB(x+4,0)))
				){
				//System.out.println(3);
				num=3;
				}
				if(
				new Color(107,110,114).equals(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
				new Color(179,180,181).equals(new Color(im.getRGB(x+3,0)))
				){
				//System.out.println(4);
				num=4;
				}
				if(
				new Color(79,82,87).equals(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+3,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+4,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+5,0)))
				){
				//System.out.println(5);
				num=5;
				}
				if(
				new Color(157,159,161).equals(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+3,0)))&&
				new Color(206,207,207).equals(new Color(im.getRGB(x+4,0)))
				){
				//System.out.println(6);
				num=6;
				}
				if(
				new Color(222,222,222).equals(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+3,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+4,0)))
				){
				//System.out.println(7);
				num=7;
				}
				if(
				new Color(186,186,188).equals(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+3,0)))&&
				new Color(198,199,200).equals(new Color(im.getRGB(x+4,0)))
				){
				//System.out.println(8);
				num=8;
				}
				if(
				new Color(184,185,186).equals(new Color(im.getRGB(x+0,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+1,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+2,0)))&&
				new Color(222,222,222).equals(new Color(im.getRGB(x+3,0)))&&
				new Color(192,192,193).equals(new Color(im.getRGB(x+4,0)))
				){
				//System.out.println(9);
				num=9;
				}
	}
	
	  public static void main(String[] args) {
		  
			  GetImage2 img =new GetImage2();
		
		 
	    }

	public BufferedImage changeIngColor(BufferedImage img,int x,int y,Color color){
		if(smath.inBounds(img, x, y)){
		img.setRGB(x, y, color.getRGB());
		}
		return img; 
	}
	public BufferedImage screanImage(){
		return rob.createScreenCapture(screen);
	}
	public BufferedImage screanImage(int x,int y,int width,int hight){
		return rob.createScreenCapture(new Rectangle(x,y,width,hight));
	}
	public BufferedImage screanImage(Point p,int width,int hight){
		return rob.createScreenCapture(new Rectangle(p.x,p.y,width,hight));
	}

	public boolean pointEcolor(BufferedImage img, int x, int y, int i, int j, int k) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
