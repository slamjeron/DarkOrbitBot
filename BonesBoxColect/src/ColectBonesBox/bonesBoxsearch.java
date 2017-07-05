package ColectBonesBox;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import seeingComputer.GetImage;
import takeAction.NormalColect;

public class bonesBoxsearch {
//this class will systematically search the entire screen
public GetImage imgcon=new GetImage();
private BufferedImage pallieimg;
private Point[] bsmPNTs;
private boolean pfound;
public void vectorSearch(int vector){
	
	pallieimg.getHeight();
loop:for(int y1 =150;y1<pallieimg.getHeight()-60;y1+=3){
for(int x1=10; x1<pallieimg.getWidth()-100;x1++){
	
	
}
}

}
public int twoPntSkip(Point cP,Point p,Point p2){
	bsmPNTs=sortpnt(p,p2);
	if(bsmPNTs[0].x>cP.x&&bsmPNTs[1].x<cP.x
			&&bsmPNTs[0].y>cP.y&&bsmPNTs[1].y<cP.y){
		return bsmPNTs[0].x;
	}else{
		return cP.x;
	}
}	
private Point[] sortpnt(Point p,Point p2){
	int bigy;
	int smally;
	if(p.y>p2.y){
		bigy=p.y;
		smally=p2.y;
	}else{
		bigy=p2.y;
		smally=p.y;
	}
	int bigX;
	int smallX;
	if(p.x>p2.x){
		bigX=p.x;
		smallX=p2.x;
	}else{
		bigX=p2.x;
		smallX=p.x;
	}
	 Point[]arint={new Point(bigX,bigy),new Point(smallX,smally)};
	return arint;
}
}
