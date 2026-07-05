import java.util.Arrays;

public class UsingArrayClass{
	public static void main(String[] args){
		int[] numbers = {5,8,2,3,9,4,1,6,7,10}; 
		
		int[] a = {7,9,6};
		int[] b = {7,9,6};
		
		int[] c = {7,9,9};
		int[] d = {7,9,6};
		
		int[][] e = {
				{7,8,9,5},
				{4,5,6,7}
			};
			
		System.out.println("The multidimensional array is "+Arrays.deepToString(e));
		
		int[] myFillArr = new int[10]; 
		Arrays.fill(myFillArr,5);
		
		
		Arrays.sort(numbers);
		
		System.out.println("The element of the array are "); 
		
		for(int number : numbers){
			System.out.printf("%d%n",number);
		}
		
		System.out.println("Binary search");
		int index = Arrays.binarySearch(numbers,9);
		System.out.printf("The index number of element 9 is %d%n", index);
		
		boolean isEqual = Arrays.equals(a,b);
		System.out.printf("The result is %b%n",isEqual);
		
		int number = Arrays.compare(c,d);
		System.out.printf("The result is %d%n", number);
		

	
		System.out.println("My fill array are :");  
		for(int fill : myFillArr){
		System.out.printf("%d%n",fill);
		}
		
		int[] evenNumbers = {2,46,8,10,12,14,16,18,20};
		int[] copyArr = Arrays.copyOf(evenNumbers,10);
		System.out.println("The element of the array are");
		for(int arr: copyArr){
			System.out.printf("%d%n",arr);
		}
		
		System.out.println(Arrays.toString(evenNumbers));
	}
}