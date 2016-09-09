
public class shios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 2;
		double y = 1;
		int i = 1;
		while(i < 20){
			double fx = calc(x);
			double temp = x;
		    x = x - (fx * (y-x))/(calc(y)-fx);
		    y = temp;
			x = (double) Math.round(x * 100000) / 100000 ;
			System.out.println("iteration "+i+" value x= "+x);
			i++;
		}

	}
	static double calc(double x){
		return (Math.pow(x, 4) - 18 *x*x + 45 );
	}

}
