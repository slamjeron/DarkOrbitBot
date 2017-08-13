package userControls;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import userControls.panelFinder.textRect;

public class ReadText {

	private textRect text;
	private readnum read=new readnum();
	private boolean shipFound=false;
	private boolean petFound=false;
	private int petHPInt;
	private int petSDInt;
	private int shipHPInt=0;
	private int shipSDInt;
	private boolean shipAtaked;
	private boolean petAtaked;
	

	

	public void statCheck(BufferedImage im) {
		getStats(im);
	}
	

public void getStats(BufferedImage im){
	if(shipFound){
		
		BufferedImage health = subimg(im,getText().shiphpRect);
		BufferedImage shield = subimg(im,getText().shipSDRect);
		int newHP = read.readnum1(health);
		int newSD =read.readnum1(shield);
		if(newHP!=0&&newSD!=0)
			if(shipHPInt!=0&&shipSDInt!=0)
		if(shipHPInt>newHP&&shipSDInt>newSD){
			System.out.println("shipHit");
			shipAtaked=true;
		}
		//System.out.println(newHP);
		shipHPInt=newHP;
		shipSDInt=newSD;
	}
	
	if(petFound){
		BufferedImage petHP = subimg(im,getText().petHPRect);
		BufferedImage petSD = subimg(im,getText().petHPRect);
		int newHP = read.readnum1(petHP);
		int newSD =read.readnum1(petSD);
		if(petHPInt<newHP&&petSDInt<newSD){
			petAtaked=true;
		}
		petHPInt=newHP;
		petSDInt=newSD;
	}

}

public boolean PointWhithinImage(BufferedImage im, int x, int y){
	return (x < im.getWidth() && y < im.getHeight() && x > 0 && y > 0);
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
	
	public boolean isShipFound() {
		return shipFound;
	}

	public void setShipFound(boolean shipFound) {
		this.shipFound = shipFound;
	}

	public boolean isPetFound() {
		return petFound;
	}

	public void setPetFound(boolean petFound) {
		this.petFound = petFound;
	}

	public textRect getText() {
		return text;
	}


	public void setText(textRect text) {
		this.text = text;
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

	}

}
