
package DateAndTime;


public class DateAndTimeTest {

    public static void main(String[] args) {

        DateAndTime dt =
                new DateAndTime(12,31,2025,23,59,58);

        for(int i=0;i<5;i++){

            System.out.println(dt);

            dt.tick();
        }

    }

}
