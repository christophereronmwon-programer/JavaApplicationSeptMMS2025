package chapter14;
import javax.swing.*;
import java.awt.*;
public class WordsEndingED extends JFrame {
    JTextField in = new JTextField(45);
    JLabel out = new JLabel(" ");
    public WordsEndingED() {
        super("14.14 Words Ending in ED");
        setLayout(new FlowLayout());
        add(in);
        JButton b = new JButton("Find");
        add(b);
        add(out);
        b.addActionListener(e -> {
            StringBuilder s = new StringBuilder(); for (String w: in.getText().split("\\s+")) if (w.toUpperCase().endsWith("ED")) s.append(w).append(" "); out.setText(s.toString());
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 130);
        setLocationRelativeTo(null);
    }
    public static void main(String[] z) {
        new WordsEndingED().setVisible(true);
    }
}
