package checkStats;

import java.awt.image.BufferedImage;

import userControls.panelFinder.textRect;

public class PetanShip {

	private BufferedImage image;
	
	public void getStats(BufferedImage im){
		if(shipFound){
			BufferedImage health = subimg(im,getText().shiphpRect);
			BufferedImage shield = subimg(im,getText().shipSDRect);
			int newHP = read.readnum1(health);
			int newSD =read.readnum1(shield);
			if(shipHPInt<newHP&&shipSDInt<newSD){
				System.out.println("shipHit");
				shipAtaked=true;
			}
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
	public PetanShip(textRect text) {
		// TODO Auto-generated constructor stub
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
