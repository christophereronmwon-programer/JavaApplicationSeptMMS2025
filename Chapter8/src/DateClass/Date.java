
package DateClass;


public class Date {

    private int month;
    private int day;
    private int year;

    private static final String[] months={
        "",
        "January","February","March","April",
        "May","June","July","August",
        "September","October","November","December"
    };

    public Date(int month,int day,int year){

        this.month=month;
        this.day=day;
        this.year=year;
    }

    public Date(String month,int day,int year){

        for(int i=1;i<months.length;i++)
            if(months[i].equalsIgnoreCase(month))
                this.month=i;

        this.day=day;
        this.year=year;
    }

    public Date(int dayNumber,int year){

        this.year=year;

        int[] days={
            31,28,31,30,31,30,
            31,31,30,31,30,31
        };

        month=1;

        while(dayNumber>days[month-1]){

            dayNumber-=days[month-1];
            month++;
        }

        day=dayNumber;
    }

    @Override
    public String toString(){

        return String.format(
                "%02d/%02d/%04d",
                month,day,year);
    }

    public String longDate(){

        return months[month]+" "+day+", "+year;
    }

    public String dayOfYear(){

        return day+" "+year;
    }

}
