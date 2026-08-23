package chapter14;
import javax.swing.*;
import java.awt.*;
public class PigLatin extends JFrame {
    JTextField input = new JTextField(40);
    JTextArea out = new JTextArea(15, 50);
    public PigLatin() {
        super("14.7 Pig Latin");
        out.setEditable(false);
        JButton b = new JButton("Translate");
        b.addActionListener(e -> translate());
        JPanel p = new JPanel();
        p.add(input);
        p.add(b);
        add(p, BorderLayout.NORTH);
        add(new JScrollPane(out));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 400);
        setLocationRelativeTo(null);
    }
    void translate() {
        StringBuilder s = new StringBuilder();
        for (String w: input.getText().split(" ")) {
            if (w.length() > 1) s.append(w.substring(1)).append(w.charAt(0)).append("ay ");
        }
        out.append(s.toString().trim() + "\n");
        input.setText("");
    }
    public static void main(String[] z) {
        new PigLatin().setVisible(true);
    }
}
