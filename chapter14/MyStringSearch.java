package chapter14;
import javax.swing.*;import java.awt.*;
public class MyStringSearch extends JFrame {
    JTextField text=new JTextField(25),target=new JTextField(10);JLabel out=new JLabel(" ");
    public MyStringSearch(){super("14.16 Own indexOf and lastIndexOf");setLayout(new FlowLayout());add(text);add(target);JButton b=new JButton("Search");add(b);add(out);
        b.addActionListener(e->{String s=text.getText(),t=target.getText();out.setText("indexOf = "+indexOf(s,t)+"   lastIndexOf = "+lastIndexOf(s,t));});
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(600,130);setLocationRelativeTo(null);}
    static int indexOf(String s,String t){if(t.isEmpty())return 0;for(int i=0;i<=s.length()-t.length();i++){int j=0;while(j<t.length()&&s.charAt(i+j)==t.charAt(j))j++;if(j==t.length())return i;}return -1;}
    static int lastIndexOf(String s,String t){if(t.isEmpty())return s.length();for(int i=s.length()-t.length();i>=0;i--){int j=0;while(j<t.length()&&s.charAt(i+j)==t.charAt(j))j++;if(j==t.length())return i;}return -1;}
    public static void main(String[]z){new MyStringSearch().setVisible(true);}
}
