
package SchoolManagementSystem;


public abstract class Person {
    String firstName;
    String lastName;
    int age;
    
    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public abstract void performDuty();
    
    public void displayDetails(){
        System.out.println(firstName + " " + lastName + " " + age);
    } 
}
