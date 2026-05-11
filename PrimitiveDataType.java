public class PrimitiveDataType{
	public static void main(String[] args){
		byte myAge = 30; 
		System.out.printf("Miss mercy is %d years old%n",myAge);
		
		short quantity = 20000;
		System.out.printf("The quantity of iphone ordered is %c%,d%n",'$',quantity);
		
		int  nigeriaPopulation = 2938749230;
		System.out.printf("The population of Nigeria is %d%n",nigeriaPopulation)
		
		long worldPopulation = 470834098590843L; 
		System.out.printf("The World's population is %,d%n",worldPopulation);
		
		float price = 5778859.78458F; 
		System.out.printf("The price of each iphone per unit is %,.2f%n",price);
		
		double myBalance = 785454887458784.34987; 
		System.out.printf("My account balance is %c%,.2f$n", '$',myBalance); 
		
		char symbol = '%' 
		System.out.printf("There is an increment in the world's Population by 20.5%c%n", symbol)
		
		boolean isJavaFun = true; 
		System.out.printf("Do you love Java? %b", isJavaFun);
	}
}