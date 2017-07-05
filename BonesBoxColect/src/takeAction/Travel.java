package takeAction;

import seeingComputer.FlytoLocation;

public class Travel {
private FlytoLocation flylocate;
private RunFromeEnimy runf;
	public Travel(FlytoLocation flylocate, RunFromeEnimy runf) {
		// TODO Auto-generated constructor stub
		this.flylocate=flylocate;
		this.runf=runf;
	}
	private boolean left1_1;
	public boolean onHomescreen;
	public boolean traveling;
	private boolean on1_1;
	private boolean on2_1;
	public int timeserch=0;
	public void seeAthome(){
		
		if(timeserch>20){
		on1_1=flylocate.on1_1();
		 on2_1=flylocate.on2_1();
		 if(!on1_1&&!on2_1){
					onHomescreen=false;
				}else{
					onHomescreen=true;
					//System.out.println("on the home screen");
					
				}
		 timeserch=0;
		}
		timeserch++;
	}
	public void flytoPvp(){
		
		
		if(on1_1){
			if(left1_1){
				runf.resetRuning();
				left1_1=false;
			}
			runf.travel4_1=true;
		}
		traveling=runf.moving;
		
		if(on2_1){
			if(left1_1){
				runf.resetRuning();
				left1_1=false;
			}
			runf.travel4_2=true;
		}
			if(!on1_1&&!on2_1){
			left1_1=true;
			}
		int conrers=0;
		int sides=1;
		int[][] f1_1to4_1={{conrers,2},{conrers,0},{conrers,2},
				{conrers,0},{sides,1},{sides,3}};
		int[][] f2_1to4_2={{conrers,3},{conrers,1},{conrers,2},
				{conrers,0},{sides,2},{sides,0}};
		if(runf.travel4_2){
		runf.travel(f2_1to4_2);
		}
		if(runf.travel4_1){
		runf.travel(f1_1to4_1);
		}
		
	}
		
}
