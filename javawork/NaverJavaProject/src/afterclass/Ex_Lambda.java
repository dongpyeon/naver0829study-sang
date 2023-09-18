package afterclass;

@FunctionalInterface
interface Calculable{
	public void calculate(int x, int y);
}

public class Ex_Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		action((x,y)->{
			int result = x+y;
			System.out.println("result: "+result);
		});
		
		action((x,y)->{
			int result = x-y;
			System.out.println("result: "+result);
		});
	}
		private static void action(Calculable calculable) {
			// TODO Auto-generated method stub
			int x =10;
			int y =4;
			calculable.calculate(x, y);
		}
	}
