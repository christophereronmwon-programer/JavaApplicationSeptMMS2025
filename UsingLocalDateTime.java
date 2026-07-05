import java.time.LocalDateTime; 

public class UsingLocalDateTime{
	public static void main(String[] args){
		
		LocalDateTime todaysDateTime = LocalDateTime.now(); 
		LocalDateTime meetinigDateTime = LocalDateTime.of(2021,05,15,06,30,45); 
		LocalDateTime myBirthDay = LocalDateTime.parse("2000-11-23T05:30:32");
		
		boolean isBefore = myBirthDay.isBefore(meetinigDateTime);
		boolean isAfter = myBirthDay.isAfter(meetinigDateTime);
		
		
		
		System.out.printf("The current date and time is %s%n", todaysDateTime);         
		System.out.printf("The current date and time is %s%n", meetinigDateTime); 
		System.out.printf("The current date and time is %s%n", myBirthDay);
		
		
		System.out.printf("The current date and time is %s%n", myBirthDay.getYear());
		System.out.printf("The current date and time is %s%n", myBirthDay.getMonth());
		System.out.printf("The current date and time is %s%n", myBirthDay.getDaysofMonth());
		System.out.printf("The current date and time is %s%n", myBirthDay.getHour());
		System.out.printf("The current date and time is %s%n", myBirthDay.plusDays(2));
		System.out.printf("The current date and time is %s%n", myBirthDay.plusHours(3));
		System.out.printf("The current date and time is %s%n", myBirthDay.minusMinutes(4));
		System.out.printf("The current date and time is %s%n", myBirthDay.minusMinutes(4));

		
		
		
		
	}
}