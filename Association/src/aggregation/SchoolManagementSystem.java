
package aggregation;

import composition.Payment;
import java.time.LocalDate;
import java.util.ArrayList;

public class SchoolManagementSystem {
   public static void main(String[] args){
       
       
       //Student objects Created
       Student s1 = new Student(
               101,
               "Henry",
               "John",
               'M'
       );
       
       Student s2 = new Student(
               102,
               "Joy",
               "Jack",
               'F'
       );
       Student s3 = new Student(
               103,
               "Frankiln",
               "Willams",
               'M'
       );       
       Student s4 = new Student(
                104,
               "Toby",
               "Emmanuel",
               'F'
       );
       Student s5 = new Student(
                105,
                "Lucy",
                "Jason",
                'M'
        );
       
       s1.makePayment(
               300000, 
               LocalDate.of(2025,8,10),
               "Transfer", 
               "Paid for Data Analytics"
       );
       
       s3.makePayment(
               300000, 
               LocalDate.of(2025,9,15),
               "Transfer", 
               "Paid for MMS"
       );
       
       s5.makePayment(
               500000, 
               LocalDate.of(2026,3,9),
               "POS", 
               "Paid for Java"
       );
      
       
       
       ArrayList<Student> students = new ArrayList<>();
       students.add(s1);
       students.add(s2);
       students.add(s3);
       students.add(s4);
       students.add(s5);
       
       //School Object Created
       School school = new School("Besona International School", students);
       
      school.displayStudentDetails();
   }
}
