public class Exercise4_1c{
	public static void main(String[] args){
		
		int n = 1;
		
		switch (n) {
			case 1:
				System.out.println("The number is 1");
				break; // there was no break statement after case1
			case 2:
				System.out.println("The number is 2");
				break;
			default:
				System.out.println("The number is not 1 or 2");
				break;
		}
	}
}