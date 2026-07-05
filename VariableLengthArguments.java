public class VariableLengthArguments {

    public static int sum(int... numbers) {
        int total = 0;

        for (int num : numbers) {
            total += num;
        }

        return total;
    }

    public static void main(String[] args) {
		System.out.println("The sum is "+sum(5,6,8,9,3,2,1)); 
		System.out.println("The sum is "+sum(8,6,4,7,5,6)); 
		System.out.println("The sum is "+sum(5,6,8,9,4)); 
		System.out.println("The sum is "+sum(5,6,8,6)); 
		System.out.println("The sum is "+sum(5,6,8,)); 
		System.out.println("The sum is "+sum(5,6,)); 
        System.out.println("The sum is "+sum(5);      
        System.out.println("The sum is "+sum());        
                    
    }
}