
public class Main {
    static double min;
	static int t;
	static int index;
	static double running;
	static double cycling;
	static double[]runningContes;
	static double[]cyclingContes;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		min = 1e-9;
		t = 100;
		runningContes = new double[2];
		cyclingContes = new double[2];
		runningContes[0]= 10.0;
		runningContes[1]= 20.0;
		cyclingContes[0]=40.0;
		cyclingContes[1]=30.0;
		running = 15.0;
		cycling = 35.0;
		double r = win();
		System.out.println(r);
		
		

	}
	static double win(){
		double low = 0;
		double high = t;
		while(Math.abs(high - low) > min ){
			double p1 = low +((high -low)/3.0);
			double p2 = low + (2*(high-low)/3.0);
			double v1 = check(p1);
			double v2 = check(p2);
			if(v1 < v2){
				low = p1;
			}else{
				high = p2;
			}	
		}
		
		return low;
	}
	static double check(double r){
		double c = t - r;
		double seconds = r/running  + c/cycling;
		double less = Math.pow(10, 9);
		for (int i = 0; i < cyclingContes.length; i++) {
			double temp = r/runningContes[i] + c/cyclingContes[i];
			if(temp < less){
				index = i;
				less = temp;
			}	
		}
		return less-seconds;
	  
		
	}

}
