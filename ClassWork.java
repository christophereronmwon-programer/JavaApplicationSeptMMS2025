import java.util.Scanner; 
public class ClassWork{
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in); 
		
		int num1;
		int num2;
		int num3;
		int sum;
		
		System.out.print("Enter the number [1]: ");
		num1 = scan.nextInt();
		
		System.out.print("Enter the number [2]: ");
		num2 = scan.nextInt();
		
		System.out.print("Enter the number [3]: ");
		num3 = scan.nextInt();
		
		sum = num1 + num2 + num3;
		
		if (sum % 2 == 0 && sum % 10 == 0){
		
			
			System.out.print("Enter the number [1]: ");
			 num1 = scan.nextInt();
			
			System.out.print("Enter the number [2]: ");
			 num2 = scan.nextInt();
			
		    System.out.print("Enter the number [3]: ");
		     num3 = scan.nextInt();
			
			
			int product = num1 * num2 * num3; 
		
			if( product > 200){
				System.out.println("Hurray");
			}
			else{
				System.out.println("On going"); 
			}
		}
		else{
			System.out.println("I must solve this problem");
		}
		
	}
}