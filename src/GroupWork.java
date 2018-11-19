//Jake Mulrenin, Kaleigh Jaeger, Max Couch, Odinaka Amadi
public class GroupWork{

 	public static void main(String[] args){
		System.out.println(factorial(0));
		System.out.println(factorial(1));
		System.out.println(factorial(5));
	}
	public static int output;
	public static int factorial(int factorialNum){
		output = 1;
		if(factorialNum == 0 || factorialNum == 1){
			return output;
		}else{
			for(int i = factorialNum; i > 1; i--){
				output = output * i;
			}
			return output;
		}
	}
}
