//Jake Mulrenin, Kaleigh Jaeger, Max Couch, Odinaka Amadi
public class GroupWork{

 	public static void main(String[] args){
		System.out.println(factorial(0));
		System.out.println(factorial(1));
		System.out.println(factorial(5));
	}
	public static int sum;
	public static int factorial(int factorialNum){
		if(factorialNum == 0 || factorialNum == 1){
			sum = 1;
			return sum;
		}else{
			for(int i = factorialNum; i > 1; i--){
				sum = sum * i;
			}
			return sum;
		}
	}
}
