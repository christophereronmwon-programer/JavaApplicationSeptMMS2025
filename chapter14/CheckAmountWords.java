package chapter14;
import javax.swing.*;import java.awt.*;
public class CheckAmountWords extends JFrame {
    JTextField in=new JTextField("112.43",12);JLabel out=new JLabel(" ");
    String[] ones={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    String[] tens={"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    public CheckAmountWords(){super("14.21 Check Amount in Words");setLayout(new FlowLayout());add(in);JButton b=new JButton("Convert");add(b);add(out);
        b.addActionListener(e->{try{double d=Double.parseDouble(in.getText());int n=(int)d;int cents=(int)Math.round((d-n)*100);out.setText(toWords(n).toUpperCase()+" and "+String.format("%02d/100",cents));}catch(Exception x){out.setText("Enter an amount below $1000.");}});
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(700,130);setLocationRelativeTo(null);}
    String toWords(int n){if(n<20)return ones[n];if(n<100)return tens[n/10]+(n%10>0?" "+ones[n%10]:"");return ones[n/100]+" hundred"+(n%100>0?" "+toWords(n%100):"");}
    public static void main(String[]z){new CheckAmountWords().setVisible(true);}
}
