public class Exercise4_1b{
	public static void main(String[] args){
		double k; 
		
		for(k=0.1; k <= 1.0; k+=0.1){ // k!=1.0 results to an infinite loop since k may never get to 1.0
			System.out.println(k);
		} // Integers are also best use for forloops so as not to cause rounding errors.
}	// There where also no braces which can result to an error {}
}