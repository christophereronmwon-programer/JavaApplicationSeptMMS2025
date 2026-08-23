import java.util.Scanner;

public class FairTax{
public static void main(String[] args){
Scanner input=new Scanner(System.in);
double housing=input.nextDouble();
double food=input.nextDouble();
double clothing=input.nextDouble();
double total=housing+food+clothing;
System.out.println("FairTax="+(0.23*total));
}
}
