package chapter14;
import javax.swing.*;import java.awt.*;import java.util.*;
public class RandomSentences extends JFrame {
    JTextArea out=new JTextArea(20,50); Random r=new Random();
    String[] article={"the","a","one","some","any"},noun={"boy","girl","dog","town","car"},
    verb={"drove","jumped","ran","walked","skipped"},prep={"to","from","over","under","on"};
    public RandomSentences(){super("14.5 Random Sentences");out.setEditable(false);JButton b=new JButton("Generate 20");
        b.addActionListener(e->generate());add(b,BorderLayout.NORTH);add(new JScrollPane(out));
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(550,450);setLocationRelativeTo(null);}
    void generate(){out.setText("");for(int i=0;i<20;i++){String s=article[r.nextInt(5)]+" "+noun[r.nextInt(5)]+" "+verb[r.nextInt(5)]+" "+prep[r.nextInt(5)]+" "+article[r.nextInt(5)]+" "+noun[r.nextInt(5)];out.append(Character.toUpperCase(s.charAt(0))+s.substring(1)+".\n");}}
    public static void main(String[]z){new RandomSentences().setVisible(true);}
}
