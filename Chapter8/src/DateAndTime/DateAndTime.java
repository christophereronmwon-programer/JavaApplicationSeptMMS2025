
package DateAndTime;


public class DateAndTime {

    private Date date;
    private Time2 time;

    public DateAndTime(int month, int day, int year,
                       int hour, int minute, int second) {

        date = new Date(month, day, year);
        time = new Time2(hour, minute, second);
    }

    public void tick() {

        int oldHour = time.getHour();

        time.tick();

        if (oldHour == 23 && time.getHour() == 0) {
            date.nextDay();
        }
    }

    @Override
    public String toString() {
        return date.toString() + " " + time.toString();
    }

    public String toUniversalString() {
        return date.toString() + " " + time.toUniversalString();
    }
}
