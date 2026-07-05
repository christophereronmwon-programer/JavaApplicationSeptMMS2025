import java.util.Set; 
import java.util.HashSet; 

public class UsingHashSet{
	public static void main(String[] args){
		
		Set<String> emails = new HashSet<>(); 
		
		emails.add("chris@yahoo.com");
		emails.add("jack@yahoo.com");
		emails.add("john@yahoo.com");
		emails.add("cj@yahoo.com");
		emails.add("andrew@yahoo.com");
		emails.add("stephen@yahoo.com");
		emails.add("steve@yahoo.com");
		emails.add("francis@yahoo.com");
		emails.add("michael@yahoo.com");
		
		System.out.println(emails);
		
		for(String email : emails){
			System.out.println(email);
		}
		
	}
}