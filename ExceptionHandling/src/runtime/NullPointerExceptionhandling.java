
package runtime;

import java.util.Scanner;
public class NullPointerExceptionhandling {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        try{
            String name = null;
            
           
        
            System.out.println("The lenght of name is:"+ name.length());
        }
        catch(NullPointerException e){
            System.out.println("Name has not be initialized");
        }
        
    }
}
