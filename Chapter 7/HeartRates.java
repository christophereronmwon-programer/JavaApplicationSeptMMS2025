
class HeartRates {
    private String firstName,lastName;
    private int birthMonth,birthDay,birthYear;

    public HeartRates(String fn,String ln,int m,int d,int y) {
        firstName=fn; lastName=ln; birthMonth=m; birthDay=d; birthYear=y;
    }

    public int getAge() {
        Calendar today=Calendar.getInstance();
        int age=today.get(Calendar.YEAR)-birthYear;
        if(today.get(Calendar.MONTH)+1<birthMonth ||
           (today.get(Calendar.MONTH)+1==birthMonth && today.get(Calendar.DAY_OF_MONTH)<birthDay)) {
            age--;
        }
        return age;
    }

    public int getMaxHeartRate() { return 220-getAge(); }
    public String getTargetHeartRate() {
        int max=getMaxHeartRate();
        int lower=(int)(max*0.50);
        int upper=(int)(max*0.85);
        return lower+" - "+upper;
    }

    public String toString() {
        return firstName+" "+lastName+" DOB: "+birthDay+"/"+birthMonth+"/"+birthYear;
    }

    public static void main(String[] args) {
        HeartRates hr=new HeartRates("John","Doe",5,15,1990);
        System.out.println(hr);
        System.out.println("Age: "+hr.getAge());
        System.out.println("Max HR: "+hr.getMaxHeartRate());
        System.out.println("Target HR: "+hr.getTargetHeartRate());
    }
}