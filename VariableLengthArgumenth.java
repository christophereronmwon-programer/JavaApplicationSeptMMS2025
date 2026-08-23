public class VariableLengthArgumenth{
	public static void main(String[] args){
		System.out.printf("The sum is %d%n",addition(5,6,8,9,3,2,1));
		System.out.printf("The sum is %d%n",addition(5,6,8,9,3,2));
		System.out.printf("The sum is %d%n",addition(5,6,8,9,3));
		System.out.printf("The sum is %d%n",addition(5,6,8,9));
		System.out.printf("The sum is %d%n",addition(5,6,8));
		System.out.printf("The sum is %d%n",addition(5,6));
		System.out.printf("The sum is %d%n",addition(5));
		System.out.printf("The sum is %d%n",addition());
	}
	
	public static int addition(int... numbers){
		int addition = 0;
		for(int number : numbers){
			addition += number;
			
		}
		return addition;
	}
	
}