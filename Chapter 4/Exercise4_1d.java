public class Exercise4_1d{
	public static void main(String[] args){
		int n = 1; // Variable was not decleared 
		while (n <= 10){//There was no braces and it was < insted of <= 
			System.out.println(n++);
		}
	}
}