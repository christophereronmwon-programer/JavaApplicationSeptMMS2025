
package Abstraction;


public class Student extends Person{
    
    int studentID;
    
    public Student(){
    }
    
    
    
    public Student(String firstName, String lastName,
            String phone, String address, int studentID){
        super(firstName,lastName,phone,address);
        this.studentID = studentID;
    }
    
    
    
    @Override
    void study() {
        System.out.println(firstName + " " + lastName 
                + " is Studying");
    }
    
    @Override
    void read(){
        System.out.println(firstName + " " + lastName 
                + " is reading");
    }
}
