package chapter14;
import javax.swing.*;
import java.awt.*;
public class CompareStrings extends JFrame {
    JTextField a=new JTextField(15), b=new JTextField(15); JLabel result=new JLabel("Result:");
    public CompareStrings(){super("14.3 Comparing Strings"); setLayout(new FlowLayout());
        add(new JLabel("First:"));add(a);add(new JLabel("Second:"));add(b); JButton x=new JButton("Compare");add(x);add(result);
        x.addActionListener(e->{int c=a.getText().compareTo(b.getText()); result.setText(c<0?"First is less than second.":c>0?"First is greater than second.":"Strings are equal.");});
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(500,130);setLocationRelativeTo(null);}
    public static void main(String[]z){new CompareStrings().setVisible(true);}
}
