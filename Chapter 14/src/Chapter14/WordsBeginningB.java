package chapter14;
import javax.swing.*;
import java.awt.*;
public class WordsBeginningB extends JFrame {
    JTextField in = new JTextField(45);
    JLabel out = new JLabel(" ");
    public WordsBeginningB() {
        super("14.13 Words Beginning with b");
        setLayout(new FlowLayout());
        add(in);
        JButton b = new JButton("Find");
        add(b);
        add(out);
        b.addActionListener(e -> {
            StringBuilder s = new StringBuilder(); for (String w: in.getText().split("\\s+")) if (w.toLowerCase().startsWith("b")) s.append(w).append(" "); out.setText(s.toString());
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 130);
        setLocationRelativeTo(null);
    }
    public static void main(String[] z) {
        new WordsBeginningB().setVisible(true);
    }
}
