
package Date;


public class DateTest {

    public static void main(String[] args) {

        Date date = new Date(12,29,2025);

        for(int i=0;i<5;i++){

            System.out.println(date);

            date.nextDay();
        }

    }

}