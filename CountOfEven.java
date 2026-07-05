// Write a java program to transverse thorugh this array called numbers 
// numbers = {6,9,5,12,4,8,5,2,16,14} 
// and display the count of all the even numbers; 

public class CountOfEven{
	public static void main(String[] args){
		
		int[] numbers = {6,9,5,12,4,8,5,2,16,14}; 
		int count = 0;
		
		for(int i = 0; i < 10; i++){
			if(numbers[i] % 2 == 0) {
				count++;
			}
		}
		
		System.out.println("The count of the even numbers is: "+count);
			
	}
}