package objectFinder;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class NumberReader {
	
		private int num;
		private String nstr=new String();
		private int digits;
		private GetImage imgC;
	
	public NumberReader(GetImage image) {
			imgC=image;
		}
	public int readnum1(BufferedImage im,Rectangle rect){
		BufferedImage img = imgC.subimg(im, rect);
		nstr="";
         for(int l=2;l<img.getWidth();l++){
        	 if(!this.textcl(img, l-1, 0)){
 				if(this.textcl(img, l, 0)){
         		testnum(img,l);
         		setDigits(getDigits() + 1);
         		nstr+=num;
 				}}
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
	public int getDigits() {
		return digits;
	}
	public void setDigits(int digits) {
		this.digits = digits;
	}
	
	
}
