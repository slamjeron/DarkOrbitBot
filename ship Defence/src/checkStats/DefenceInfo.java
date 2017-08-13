package checkStats;

import java.awt.image.BufferedImage;

import userControls2.GetImage;
import userControls2.ImageReader;
import userControls2.ImgRobot;

public class DefenceInfo {

	private BufferedImage image;
	private ImgRobot img;
	private int shipHPInt;
	private int shipSDInt;
	private int petHPInt;
	private int petSDInt;
	private ImageReader imgReader;
	
	public void startReadImg(ImgRobot img) {
		this.img=img;
		imgReader=img.imgReader;
		imgReader.panelsearch.imsearch(image);
	}
	
	public boolean petHit() {
		boolean hit=false;
		if(imgReader.panelsearch.petFound){
			BufferedImage petHP = img.image.subimg(image,img.imgReader.textR.petHPRect);
			BufferedImage petSD =  img.image.subimg(image,img.imgReader.textR.petSDRect);
			int newHP = imgReader.numbers.readnum(petHP);
			int newSD =imgReader.numbers.readnum(petSD);
			if(hitCheck(petHPInt,newHP,petSDInt,newSD)){
				hit =true;
			}
			petHPInt=newHP;
			petSDInt=newSD;
		}
		return hit;
	}
	public boolean shipHit(){
		boolean hit=false;
		if(imgReader.panelsearch.shipFound){
			BufferedImage health = img.image.subimg(image,imgReader.textR.shiphpRect);
			BufferedImage shield = img.image.subimg(image,imgReader.textR.shipSDRect);
			int newHP = imgReader.numbers.readnum(health);
			int newSD =imgReader.numbers.readnum(shield);
			
			if(hitCheck(shipHPInt,newHP,shipSDInt,newSD)){
				hit= true;
			}
			shipHPInt=newHP;
			shipSDInt=newSD;
		}
		return hit;
		
		
	}
	private boolean hitCheck(int oldHP,int newHP,int oldSD,int newSD){
		return(oldHP!=0&&newHP!=0&&oldSD!=0&&newSD!=0&&
				oldHP>newHP&&oldSD>newSD);
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	
}
