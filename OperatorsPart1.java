public class OperatorsPart1{
		public static void main(String[] args){
			//Assignment Operator (=)
			
			int num = 200; 
			System.out.printf("The value of num is %d%n",num); 
			
			System.out.println("");
			System.out.println("=========================================================================");
			
			// Arithemetic Operators(+,-,/,*,%)
			int num1 = 80; 
			int num2 = 100;
			
			int addition = num1 + num2; 
			int subtraction = num1 - num2; 
			double division = (double)num1/num2;
			int multiplication = num1 * num2; 
			int remainder = num1 % num2; 
			
			System.out.println("");
			System.out.println("=========================================================================");
			System.out.printf("The sum of %d + %d = %d%n",num1,num2,addition);
			System.out.printf("The sum of %d - %d = %d%n",num1,num2,subtraction);
			System.out.printf("The sum of %d / %d = %.1f%n",num1,num2,division);
			System.out.printf("The sum of %d x %d = %d%n",num1,num2,multiplication);
			System.out.printf("The sum of %d %% %d = %d%n",num1,num2,remainder);
			System.out.println("");
			System.out.println("=========================================================================");
			
			
			//Compound assignment operator(+=,-=,*=,/=,%=)
			
			num1 += num2; 
		
			System.out.printf("The value of num1 has been updated to %d%n",num1);
			
			num1 -= num2; 
			System.out.printf("The value of num1 has been updated to %d%n",num1);
			
			num1 *= num2;
			System.out.printf("The value of num1 has been updated to %d%n",num1);
			
			num1 /= num2;
			System.out.printf("The value of num1 has been updated to %d%n",num1);
			
			num1 %= num2;
			System.out.printf("The value of num1 has been updated to %d%n",num1);
			
			System.out.println("");
			System.out.println("=========================================================================");
			
			int number1 = 15; 
			int number2 = 30;
			
			
			boolean isGreater = number1 > number2; 
			boolean isLessThan = number1< number2;
			boolean isGreaterOrEqualTO = number1 >= number2;
			boolean isLessThanOrEqualTO = number1 <= number2;
			boolean isEqualTO = number1 == number2;
			boolean isNotEqualTo = number1 != number2;
			
			System.out.printf("Is %d > %d = %b%n",number1 ,number2, isGreater);
			System.out.printf("Is %d < %d = %b%n",number1 ,number2, isLessThan);
			System.out.printf("Is %d >= %d = %b%n",number1 ,number2, isGreaterOrEqualTO);
			System.out.printf("Is %d <= %d = %b%n",number1 ,number2, isLessThanOrEqualTO);
			System.out.printf("Is %d == %d = %b%n",number1 ,number2, isEqualTO);
			System.out.printf("Is %d != %d = %b%n",number1 ,number2, isNotEqualTo);
			
			
		}
}