
package runtime;

public class StringIndexOutOfBoundExceptionHandling {
    public static void main(String[] args){
        String myName = "Mercy Ben";
        try{
            System.out.println(myName.charAt(5));
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("Invalid string index");
        }
        
        
    }
}
