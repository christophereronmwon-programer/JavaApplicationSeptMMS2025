package chapter14;
import javax.swing.*;import java.awt.*;
public class AlphabetCounts extends JFrame {
    JTextArea in=new JTextArea(5,50),out=new JTextArea(15,50);
    public AlphabetCounts(){super("14.12 Alphabet Occurrences");out.setEditable(false);JButton b=new JButton("Count");
        add(new JScrollPane(in),BorderLayout.NORTH);add(new JScrollPane(out),BorderLayout.CENTER);add(b,BorderLayout.SOUTH);
        b.addActionListener(e->{int[] c=new int[26];for(char x:in.getText().toLowerCase().toCharArray())if(x>='a'&&x<='z')c[x-'a']++;out.setText("Letter\tCount\n");for(int i=0;i<26;i++)out.append((char)('a'+i)+"\t"+c[i]+"\n");});
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(550,450);setLocationRelativeTo(null);}
    public static void main(String[]z){new AlphabetCounts().setVisible(true);}
}
