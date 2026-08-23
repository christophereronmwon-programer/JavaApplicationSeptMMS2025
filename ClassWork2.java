import java.util.Set;
import java.util.HashSet;

public class Classwork2 {
	public static void main(String[] args){
		Set<String> Emails = new HashSet<>();
			
			Emails.add("Tammy@gmail.com");
			Emails.add("Cj@gmail.com");
			Emails.add("Stanley@gmail.com");
			Emails.add("Chidera@gmail.com");
			Emails.add("Victor@gmail.com");
			Emails.add("Lucy@gmail.com");
			Emails.add("Benard@gmail.com");
			Emails.add("Ifeoma@gmail.com");
			Emails.add("Joseph@gmail.com");
			Emails.add("Steven@gmail.com");
			
			System.out.println(Emails);
			
			for(String Email : Emails){
				System.out.println(Email);
			}
			
			
	}
}