public class VaragsClassWork{
	public static void main(String[] args){
		
		int oddCount = count(5,6,7,3,2,3,4,7,5,3);
		
		System.out.printf("The count of all the odd numbers are: %d%n ", oddCount);
	}
	public static int count(int... numbers){
		int count = 0; 
		for(int number : numbers){
			if(number % 2 != 0){
				count ++ ;
			}
		}
		return count;
	}
}