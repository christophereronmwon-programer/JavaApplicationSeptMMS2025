
package classWork3;


public class TestingStudent {
    public static void main(String[] args){
        Student[] studentObject = {
            new UnderGraduateStudent(),
            new GradiuateStudent(),
        };
    
        for(Student student : studentObject){
            student.study();
        }
    }
}
