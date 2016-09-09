
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3086
 */
public class Main {
	int leak = 0;
	double currentLiters0 = 0;
	double savedLiters = 0;
	double FuelConsumption = 0;
	double first = 0;
	LinkedList  list = new LinkedList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main solve = new Main();
		double temp;
		int temp0;
		boolean flag = true;
		Scanner x = new Scanner(System.in);
		String input ;
		String[]action;
		while(flag){
			input = x.nextLine();
			action = input.split(" ");
			temp =  Double.parseDouble(action[0]);
			if(action[1].contains("Fuel")){
				temp0 = Integer.parseInt(action[3]);
				if(temp0 == 0){
					flag = false;
					solve.print();
				}else{
					solve.calculate(temp);
					solve.FuelConsumption = temp0/100.0;
					solve.first = temp;
				}
				
			}else if(action[1].contains("Leak")){
				solve.calculate(temp);
				solve.first = temp ;
				solve.leak++;
			}else if(action[1].contains("Gas")){
				solve.calculate(temp);
				if(solve.currentLiters0 > solve.savedLiters){
					solve.savedLiters = solve.currentLiters0;
				}
				solve.currentLiters0 = 0;
				solve.first = temp;
			}else if(action[1].contains("Mechanic")){
				solve.calculate(temp);
				solve.first = temp;
				solve.leak = 0;
			}else{
				solve.calculate(temp);
				if(solve.currentLiters0 > solve.savedLiters){
					solve.savedLiters = solve.currentLiters0;
				}
				solve.list.add(solve.savedLiters);
				solve.currentLiters0 = 0;
				solve.savedLiters = 0;
				solve.first = 0;
				solve.leak = 0;
				
			}
		
		}
		

	}
	void calculate(double last){
		double distance = last - first;
		currentLiters0 = currentLiters0 + distance * FuelConsumption  + leak* distance;
	}
	void print(){
		ListIterator y = list.listIterator();
		while(y.hasNext()){
			System.out.printf("%.3f\n", y.next());
		}
	}


}
