public class EvenNumberArray{
	public static void main(String[] args){
		
		int[] numbers = {6,9,5,12,4,8,5,2,16,14};
		int count = 0;
		
		for(int i : numbers){
			if(i % 2 == 0){
				count++;
			}
		}
		System.out.println("count of even numbers:" + count);
	}
}