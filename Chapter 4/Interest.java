public class Interest{
public static void main(String[] args){
double principal=1000;
for(int rate=5;rate<=10;rate++){
double amount=principal*Math.pow(1+rate/100.0,10);
System.out.println(rate+"% : "+amount);
}
}
}
