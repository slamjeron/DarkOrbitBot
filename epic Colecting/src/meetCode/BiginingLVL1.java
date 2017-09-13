package meetCode;

import java.util.Timer;
import java.util.TimerTask;

import meetCodeLVL2.Colect;
import meetCodeLVL2.EnimySearch;

public class BiginingLVL1 {
	public boolean timerStop=true;
	private boolean runing;
	public void test(boolean run, boolean iscolect, boolean runNow, boolean fndPP, boolean ptclct) {
		if(runNow)
			runing=true;
		Timer timer=new Timer();
		Timer timer2=new Timer();
		timer.scheduleAtFixedRate (
				new TimerTask() {
				private Colect colect;

				public void run() {
					if(timerStop){
						timer.cancel();
				         timer.purge();
					}else{
						if(run||runing){
							
						}
						if(iscolect&&!runing){
							colect.sequence();
						}
					}
				}
			  }, 0, 1);
		timer2.scheduleAtFixedRate (
				new TimerTask() {
				private EnimySearch enimySch;

				public void run() {
					if(timerStop){
						timer2.cancel();
				         timer2.purge();
					}else{
						if(fndPP&&!runing){
							if(enimySch.findPlayer())
								runing=true;
							if(ptclct)
								pet.colect;
						}
					}
				}
			  }, 0, 3);
	}

}
