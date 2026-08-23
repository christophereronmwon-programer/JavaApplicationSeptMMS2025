package chapter14;
import javax.swing.*;import java.awt.*;
public class TokenizePhone extends JFrame {
    JTextField input=new JTextField("(555) 555-5555",20);JLabel out=new JLabel(" ");
    public TokenizePhone(){super("14.8 Tokenizing Telephone Numbers");setLayout(new FlowLayout());add(input);JButton b=new JButton("Tokenize");add(b);add(out);
        b.addActionListener(e->{String s=input.getText().replace("(","").replace(")","").replace("-"," ");String[] p=s.trim().split("\\s+");if(p.length==3)out.setText("Area code: "+p[0]+"   Phone: "+p[1]+p[2]);else out.setText("Use (555) 555-5555");});
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(550,130);setLocationRelativeTo(null);}
    public static void main(String[]z){new TokenizePhone().setVisible(true);}
}
