
package ModifyTime;


public class Time2 {

    private int totalSeconds;

    public Time2() {
        this(0, 0, 0);
    }

    public Time2(int hour) {
        this(hour, 0, 0);
    }

    public Time2(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Time2(int hour, int minute, int second) {

        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("Invalid hour");

        if (minute < 0 || minute > 59)
            throw new IllegalArgumentException("Invalid minute");

        if (second < 0 || second > 59)
            throw new IllegalArgumentException("Invalid second");

        totalSeconds = hour * 3600 + minute * 60 + second;
    }

    public int getHour() {
        return totalSeconds / 3600;
    }

    public int getMinute() {
        return (totalSeconds % 3600) / 60;
    }

    public int getSecond() {
        return totalSeconds % 60;
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d",
                getHour(), getMinute(), getSecond());
    }

    @Override
    public String toString() {

        int hour = getHour();

        return String.format("%d:%02d:%02d %s",
                (hour == 0 || hour == 12) ? 12 : hour % 12,
                getMinute(),
                getSecond(),
                hour < 12 ? "AM" : "PM");
    }
    public void tick() {

    totalSeconds++;

    if (totalSeconds >= 86400)
        totalSeconds = 0;
    }

    public void incrementMinute() {

    totalSeconds += 60;

    if (totalSeconds >= 86400)
        totalSeconds %= 86400;
    }

    public void incrementHour() {

    totalSeconds += 3600;

    if (totalSeconds >= 86400)
        totalSeconds %= 86400;
    }
}