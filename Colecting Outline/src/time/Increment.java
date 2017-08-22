package time;

public class Increment {

	private int inc=0;
	public int inc1=0;

	public boolean increment(int i) {
		boolean r=false;
		//System.out.println("ink="+inc);
		if(i<inc){
			inc=0;
			r=true;
		}
		inc++;
		return r;
	}
	
	public boolean increment1(int i,int reactInt) {
		boolean r=false;
		if(inc1==reactInt){
			
			r=true;
		}
		if(i<inc1){
			inc1=0;
		}
		//System.out.println("this is the inc");
		inc1++;
		return r;
	}
}
