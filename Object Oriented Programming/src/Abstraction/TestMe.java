
package Abstraction;


public class TestMe {
    public static void main(String[] args){
        Student student1 = new Student("John", "Yung",
        "09039527807", "No 1 Kaduna Street, Ogbunabali PortHarcout",
                101);
        
        student1.read();
        System.out.println("=================================\n");
        student1.study();
    }
}
