import java.time.LocalDate;

public class UsingLocalDate{
	public static void main(String[] args){
		LocalDate todaysDate = LocalDate.now();
		LocalDate myBirthDate = LocalDate.of(2000,05,25);
		LocalDate resumptionDate = LocalDate.parse("2028-10-15");
		
		boolean isLeapYear = resumptionDate.isLeapYear();
		
		System.out.printf("Today's date is %s%n",todaysDate);
		System.out.printf("My birth date is %s%n",myBirthDate);
		System.out.printf("The resumption Date is %s%n",resumptionDate);
		System.out.printf("Resumption Year is %s%n",resumptionDate.getYear());
		System.out.printf("Resumption Month is %s%n",resumptionDate.getMonth());
		System.out.printf("The meeting Date is %s%n",resumptionDate.plusDays(10));
		System.out.printf("The party date will be %s%n",resumptionDate.plusMonths(5));
		System.out.printf("The Resumption date is a leapyear %b%n",isLeapYear);
		
		
	}
}