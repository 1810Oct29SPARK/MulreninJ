public class EstebansQuestion{
	public static void main(String[] args){
		int shiftArray[] = new int[]{1,2,3,4,5,6,7,8,9,10};
		shiftLeft(shiftArray,3);
	}

	public static int numFromEnd;
	public static void shiftLeft(int array[], int n){
        	int placeholder[] = new int[array.length];
		for(int i = 0; i < array.length; i++){
			if((i-n) < 0){
				placeholder[array.length - (n-i)] = array[i];
			}else{
				placeholder[i - n] = array[i];
			}
		}
		for(int j = 0; j < placeholder.length; j++){
			System.out.println(placeholder[j]);
		}
	}
}
