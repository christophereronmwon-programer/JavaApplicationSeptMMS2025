package chapter14;
import javax.swing.*;import java.awt.*;
public class SearchCharacter extends JFrame {
    JTextField text=new JTextField(35),ch=new JTextField(2);JLabel out=new JLabel(" ");
    public SearchCharacter(){super("14.11 Searching Strings");setLayout(new FlowLayout());add(text);add(new JLabel("Character:"));add(ch);JButton b=new JButton("Search");add(b);add(out);
        b.addActionListener(e->{if(ch.getText().isEmpty()){out.setText("Enter a character.");return;}char c=ch.getText().charAt(0);int n=0,p=-1;while((p=text.getText().indexOf(c,p+1))!=-1)n++;out.setText("Occurrences: "+n);});
        setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(650,130);setLocationRelativeTo(null);}
    public static void main(String[]z){new SearchCharacter().setVisible(true);}
}
