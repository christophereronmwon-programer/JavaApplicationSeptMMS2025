package chapter14;
import javax.swing.*;import java.awt.*;
public class UpperLower extends JFrame {
    JTextArea in=new JTextArea(5,45),out=new JTextArea(5,45);
    public UpperLower(){super("14.10 Uppercase and Lowercase");out.setEditable(false);JButton b=new JButton("Convert");
        add(new JScrollPane(in),BorderLayout.NORTH);add(new JScrollPane(out),BorderLayout.CENTER);add(b,BorderLayout.SOUTH);
        b.addActionListener(e->out.setText(in.getText().toUpperCase()+"\n\n"+in.getText().toLowerCase()));
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(550,350);setLocationRelativeTo(null);}
    public static void main(String[]z){new UpperLower().setVisible(true);}
}
