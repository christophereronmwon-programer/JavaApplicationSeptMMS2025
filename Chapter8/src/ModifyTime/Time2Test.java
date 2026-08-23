
package ModifyTime;


public class Time2Test {

    public static void main(String[] args) {

        Time2 time = new Time2(23,59,59);

        System.out.println("Current Time: " + time);

        time.tick();
        System.out.println("After Tick: " + time);

        time.incrementMinute();
        System.out.println("After Minute: " + time);

        time.incrementHour();
        System.out.println("After Hour: " + time);
    }
}