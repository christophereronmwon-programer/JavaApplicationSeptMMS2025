public class PassingArrayToMethod{
	public static void main(String[] args){
		int[] arr = {7,8,4,3,2,9,0,1,6,8};
		int totalNumber = sum(arr);
		System.out.print("The total number is " +totalNumber);
	}
	public static int sum(int[] numbers){
		int sum = 0; 
		for(int i = 0; i < numbers.length; i++){
			sum += numbers[i];
		}
		
		return sum;
	}
}