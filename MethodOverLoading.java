import java.util.Scanner; 

public class MethodOverLoading{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("=========Program To Calculate the Perimeter Of A Shape ======================");
		System.out.println("Enter The following to select a shape ");
		System.out.println("1. Square");
		System.out.println("2. Rectangle");
		System.out.println("3. Triangle");
		
		System.out.print("Enter your option: ");
		int choice = scan.nextInt();

		switch(choice){
			case 1: 
				System.out.println("");
				System.out.println("=========Calculating the Perimeter of a Square =====================");
				System.out.print("Enter the length of the square: ");
				int squarelength = scan.nextInt(); 
				perimeter(squarelength);
				
				
		
			break;
			
			case 2: 
				System.out.println("");
				System.out.println("=========Calculating the Perimeter of a Rectangle ======================");
				System.out.print("Enter the length of the rectangle: ");
				int recLength = scan.nextInt(); 
				
				System.out.print("Enter the length of the rectangle: ");
				int recWidth = scan.nextInt(); 
				
				perimeter(recLength,recWidth);
				
			break;
			
			case 3: 
				System.out.println("");
				System.out.println("=========Calculating the Perimeter of a Triangle ======================");
				System.out.print("Enter sideA: ");
				int sideA = scan.nextInt();
				
				System.out.print("Enter sideB: ");
				int sideB = scan.nextInt();
				
				System.out.print("Enter sideC: "); 
				int sideC = scan.nextInt(); 
				
				perimeter(sideA,sideB,sideC );
				
			break;
			
			default: 
				System.out.println("Program Exited, Good Bye..............");
	}
	}
	public static void perimeter(int lenOfSquare){
		int perimeterOfSquare = 4 * lenOfSquare;
		
		System.out.printf("The perimeter of the square is %d%n",perimeterOfSquare);
	}
	
	public static void perimeter(int lenOfRect, int widthOfRect){
		int perimeterOfRect = 2 * (lenOfRect + widthOfRect);
		
		System.out.printf("The perimeter of the rectangle is %d%n",perimeterOfRect);
	}
	
		public static void perimeter(int sideA, int sideB, int sideC){
		int perimeterOfTriangle = sideA + sideB + sideC;
		
		System.out.printf("The perimeter of the triangle is %d%n",perimeterOfTriangle );
	}
}