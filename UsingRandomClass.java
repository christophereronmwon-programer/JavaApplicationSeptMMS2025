import java.util.Random;

public class UsingRandomClass{
	public static void main(String[] args){
		
		Random random = new Random();
		
			int genetatedInteger = random.nextInt();
			System.out.printf("The generated number is %d%n",Math.abs(genetatedInteger));
		
			int rangeNumber = random.nextInt(100)+1;
			System.out.printf("The generated number is %d%n",rangeNumber); 
			
			double decimalNumber = random.nextDouble(); 
			System.out.printf("The float point value is %f%n",decimalNumber); 
			
			boolean isJava = random.nextBoolean();
			System.out.printf("So you love Java %b%n",isJava); 
		
	}       
}