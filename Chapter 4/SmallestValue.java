import java.util.Scanner; 

public class SmallestValue{
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		
		int numberOfInputs; 
		int numbers; 
		int minimum;
		
		
		 
		System.out.print("Enter number of inputs: "); 
		numberOfInputs = scan.nextInt();
		
		
		System.out.print("Enter the number : ");
		minimum = scan.nextInt();
		
		 
		
		
		for(int count = 2 ; count <= numberOfInputs; count++){
			System.out.printf("Enter a number : ",count);
			numbers = scan.nextInt(); 
			
			if (numbers < minimum){
				minimum = numbers; 
			}
		} 
		System.out.println("");
		System.out.println("=================================================");
		System.out.println("The smallest integer is "+minimum);
		System.out.println("Thanks for playing");
		
	}
}