package chapter14;
import javax.swing.*;import java.awt.*;
public class ReverseSentence extends JFrame {
    JTextField in=new JTextField(40);JLabel out=new JLabel(" ");
    public ReverseSentence(){super("14.9 Reverse Words");setLayout(new FlowLayout());add(in);JButton b=new JButton("Reverse");add(b);add(out);
        b.addActionListener(e->{String[] a=in.getText().trim().split("\\s+");StringBuilder s=new StringBuilder();for(int i=a.length-1;i>=0;i--)s.append(a[i]).append(i==0?"":" ");out.setText(s.toString());});
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(650,130);setLocationRelativeTo(null);}
    public static void main(String[]z){new ReverseSentence().setVisible(true);}
}
