
package SchoolManagementSystem;


public class Staff extends Person{
    String department;
    
    public Staff(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.department = department;
    }
    
    @Override
    public void performDuty(){
        System.out.println(firstName + " " + lastName + " " + department);
    }
}
