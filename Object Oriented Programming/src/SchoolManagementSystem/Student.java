
package SchoolManagementSystem;


public class Student extends Person{
    private String grade;
    
    public Student(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.grade = grade;
    }
    
    @Override
    public void performDuty(){
        System.out.println(firstName + " " + lastName + " " + grade);
    }

}
