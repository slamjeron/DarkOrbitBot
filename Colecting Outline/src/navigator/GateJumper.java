package navigator;

import java.awt.Color;
import java.awt.Point;
import keyMouse.Keyboard;
import keyMouse.Mouse;
import objectFinder.Colorlogic;


public class GateJumper {
public Gate gate=new Gate();
private int runStep=0;
private int actionDelay=0;
private Point mapPnt=new Point();
private Colorlogic clogic;
private Mouse mouse=new Mouse();
private boolean moving=false;
private Keyboard kB=new Keyboard();
private int mapNumber=9;

public int getMapNumber(){
	return mapNumber;
}

public GateJumper(Point mappnt2,Mouse mouse2,Keyboard kb, Colorlogic clgc) {
	mapPnt=mappnt2;
	this.clogic=clgc;
	mouse=mouse2;
	kB=kb;
}
public void setMoving(boolean b){
	moving=b;
}

public Point[][] from1_1To4_1={{gate.BOTOM_RIGHT,gate.TOP_LEFT},
		{gate.BOTOM_RIGHT,gate.TOP_LEFT},
		{gate.CENTER_RIGHT,gate.CENTER_LEFT}};
public boolean travleing=false;

public void travel(Point[][] gate){
	int size = gate.length;
	if(mapNumber<size){
		travleing=true;
		jumpgate(gate[mapNumber][0],
				gate[mapNumber][1]);
	}else{
		travleing=false;
	}
	
}
public Point pntanMPnt(Point p){
	return new Point(mapPnt.x+p.x,mapPnt.y+p.y);
}
private void jumpgate(Point p,Point p2){
	Point jpnt=pntanMPnt(p);
	Point dpnt = pntanMPnt(p2);
	if(!moving){
	if(runStep==1){
	if(plocate(jpnt)){
		runStep++;
		actionDelay=0;
	}else{
		if(actionDelay==5){
			mouse.rightclick(jpnt);
		}
		if(actionDelay>40){
			actionDelay=0;
		}
		}
			actionDelay++;
	}
	
	if(runStep==2){
		if(plocate(dpnt)){
			runStep=1;
			mapNumber++;
			actionDelay=0;
		}else{
			if(plocate(jpnt)){
			if(actionDelay==10){
				kB.type("j");
			}
			if(actionDelay>170){
				actionDelay=0;
			}
				actionDelay++;
			}
		}
	}
	}
}
	public boolean plocate(Point p){
		return clogic.pointEcolor(new Point(p.x, p.y-10)
					, new Color(70,70,70))&&
			clogic.pointEcolor(new Point(p.x-10, p.y)
					, new Color(70,70,70));
	}
public void reset(){
	actionDelay=0;
	runStep=1;
	mapNumber=0;
}
}
