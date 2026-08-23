
package DateClass;


public class DateTest {

    public static void main(String[] args) {

        Date d1=new Date(6,14,1992);

        Date d2=new Date("June",14,1992);

        Date d3=new Date(165,1992);

        System.out.println(d1);

        System.out.println(d2.longDate());

        System.out.println(d3);

    }

}
