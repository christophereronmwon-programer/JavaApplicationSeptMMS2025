
package Date;


public class Date {

    private int month;
    private int day;
    private int year;

    private static final int[] daysPerMonth =
        {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public Date(int month, int day, int year) {

        if(month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month");

        if(year < 1)
            throw new IllegalArgumentException("Invalid year");

        if(month == 2 && isLeapYear(year))
        {
            if(day < 1 || day > 29)
                throw new IllegalArgumentException("Invalid day");
        }
        else
        {
            if(day < 1 || day > daysPerMonth[month])
                throw new IllegalArgumentException("Invalid day");
        }

        this.month = month;
        this.day = day;
        this.year = year;
    }

    private boolean isLeapYear(int year){
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }

    public void nextDay(){

        if(month == 2 && isLeapYear(year)){

            if(day < 29){
                day++;
                return;
            }
        }
        else if(day < daysPerMonth[month]){
            day++;
            return;
        }

        day = 1;

        if(month == 12){
            month = 1;
            year++;
        }
        else{
            month++;
        }
    }

    @Override
    public String toString(){
        return month + "/" + day + "/" + year;
    }
}