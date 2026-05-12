public class TypeCasting{
	public static void main(String[] args){
		
		int num1 = 50;
		int num2 = 200; 
		
		
		
		// IMPLICIT TYPE CASTING (WIDENING TYPE CASTING) 
		double price = 7484;
		System.out.printf("The price of laptop is %f%n",price); 
		
		// EXPLICIT TYPE CASTING(NARROWING TYPE CASTING)
		double balance = 5693.2875; 
		int convertedBalance = (int)balance; 
		System.out.printf("The converted balance is %d%n",convertedBalance);
		
		char symbol = '?'; 
		int convertedSymbol = (int)symbol; 
		System.out.printf("The converted symbol is %d%n",convertedSymbol);
		
		double division = (double)num1/num2;
		System.out.printf("The division is %f%n",division);
		
	}
}	