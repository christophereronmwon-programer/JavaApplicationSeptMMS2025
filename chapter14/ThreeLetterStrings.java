package chapter14;
import javax.swing.*;import java.awt.*;
public class ThreeLetterStrings extends JFrame {
    JTextField in=new JTextField(8);JTextArea out=new JTextArea(15,50);
    public ThreeLetterStrings(){super("14.17 Three-Letter Strings");JButton b=new JButton("Generate");b.addActionListener(e->generate());
        JPanel p=new JPanel();p.add(new JLabel("Five-letter word:"));p.add(in);p.add(b);add(p,BorderLayout.NORTH);add(new JScrollPane(out));setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(550,400);setLocationRelativeTo(null);}
    void generate(){out.setText("");String s=in.getText();if(s.length()!=5){out.setText("Enter exactly five letters.");return;}for(int i=0;i<5;i++)for(int j=0;j<5;j++)if(j!=i)for(int k=0;k<5;k++)if(k!=i&&k!=j)out.append(""+s.charAt(i)+s.charAt(j)+s.charAt(k)+"\n");}
    public static void main(String[]z){new ThreeLetterStrings().setVisible(true);}
}
