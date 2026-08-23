public class SingleDimentionalArray{
	public static void main(String[] args){
		
		int[] numbers = {2,4,6,8,12,15,20,25,26,30};
		
		System.out.printf("The element at index number 5 %d%n ",numbers[5]);
		System.out.printf("The element at index number 5 %d%n ",numbers[8]);
		
		System.out.println("Transversing through the elements of the Array");
		System.out.println("=============================================");
		
		for(int i = 0; i <10; i++){
			System.out.printf("%d%n",numbers[i]);
		}
	}
}