package chapter14;
import javax.swing.*;import java.awt.*;import java.text.*;import java.util.*;
public class DateFormatter extends JFrame {
    JTextField in=new JTextField("04/25/1955",15);JLabel out=new JLabel(" ");
    public DateFormatter(){super("14.19 Date Formats");setLayout(new FlowLayout());add(in);JButton b=new JButton("Convert");add(b);add(out);
        b.addActionListener(e->{try{Date d=new SimpleDateFormat("MM/dd/yyyy").parse(in.getText());out.setText(new SimpleDateFormat("MMMM d, yyyy").format(d));}catch(Exception x){out.setText("Use MM/dd/yyyy.");}});
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(500,130);setLocationRelativeTo(null);}
    public static void main(String[]z){new DateFormatter().setVisible(true);}
}
