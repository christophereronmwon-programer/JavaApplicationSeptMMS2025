public class ClassWorkEven{
	public static void evenNumbers(int[] numbers){
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i]%2 == 0){
				System.out.println(numbers[i]); 
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {7,8,4,3,2,9,0,1,6,8};
		evenNumbers(arr);
	}
}