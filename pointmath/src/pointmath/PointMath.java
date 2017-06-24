package pointmath;

import java.awt.Point;
import java.awt.image.BufferedImage;

import simplifyingFunctions.comonTools;

public class PointMath extends comonTools{
private Point recttcPt=new Point();
private Point rectBpoint;
private Point rectSize;
public void pMath(Point p1,Point p2){
	pMath(p1.x,p1.y,p2.x,p2.y);
}
public BufferedImage pMath(int x1 ,int y1,int x2 ,int y2){
	int tempx;
	int tempy;
	int tempxb;
	int tempyb;
	if(x1>x2){
		tempx=x2;
		tempxb=x1;
	}else{
		tempxb=x2;
		tempx=x1;
	}
	if(y1>y2){
		tempy=y2;
		tempyb=y1;
	}else{
		tempyb=y2;
		tempy=y1;
	}
	recttcPt=new Point(tempx,tempy);
	rectBpoint=new Point(tempxb,tempyb);
	rectSize =pointsub(rectBpoint,recttcPt);
	//System.out.println(recttcPt);
	//System.out.println(rectBpoint);
	img.printPointColor(rectBpoint.x, rectBpoint.y);
	System.out.println(rectSize);
	return img.screanImage(recttcPt, rectSize.x, rectSize.y);

}
public Point pointsub(Point bigpt,Point smallpt){
		System.out.println(bigpt.x-smallpt.x);
		return new Point(bigpt.x-smallpt.x,bigpt.y-smallpt.y);
}
}
