package chapter14;
import javax.swing.*;import java.awt.*;
public class RegionMatches extends JFrame {
    JTextField s1=new JTextField(12),s2=new JTextField(12),start=new JTextField("0",4),count=new JTextField("1",4);
    JLabel out=new JLabel("Result:");
    public RegionMatches(){super("14.4 Comparing Portions of Strings");setLayout(new FlowLayout());
        add(new JLabel("String 1:"));add(s1);add(new JLabel("String 2:"));add(s2);
        add(new JLabel("Start index:"));add(start);add(new JLabel("Characters:"));add(count);
        JButton b=new JButton("Compare");add(b);add(out);
        b.addActionListener(e->{try{int st=Integer.parseInt(start.getText()),n=Integer.parseInt(count.getText());
            boolean ok=s1.getText().regionMatches(true,st,s2.getText(),st,n);out.setText(ok?"Equal":"Not equal");
        }catch(Exception ex){out.setText("Invalid input.");}});
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(650,150);setLocationRelativeTo(null);}
    public static void main(String[]z){new RegionMatches().setVisible(true);}
}
