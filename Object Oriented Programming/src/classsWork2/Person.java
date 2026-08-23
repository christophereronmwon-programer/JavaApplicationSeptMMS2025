package classsWork2;


public class Person {
    void display(){
        System.out.println("No parameter was given");
    }
    
    void display(String name){
        System.out.println("Your Name is " + name);
    }
    
    void display(String name,int age){
        System.out.println("Your Name is " + name);
        System.out.println("You are "+ age + "years old");
    }
}
