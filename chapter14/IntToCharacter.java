package chapter14;
import javax.swing.*;import java.awt.*;
public class IntToCharacter extends JFrame {
    JTextField in=new JTextField("65",8);JTextArea out=new JTextArea(12,40);
    public IntToCharacter(){super("14.15 int to Character");JButton b=new JButton("Convert");b.addActionListener(e->{try{out.setText("Character: "+(char)Integer.parseInt(in.getText()));}catch(Exception x){out.setText("Invalid code.");}});
        JPanel p=new JPanel();p.add(new JLabel("Code:"));p.add(in);p.add(b);add(p,BorderLayout.NORTH);add(new JScrollPane(out));setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(500,300);setLocationRelativeTo(null);}
    public static void main(String[]z){new IntToCharacter().setVisible(true);}
}
