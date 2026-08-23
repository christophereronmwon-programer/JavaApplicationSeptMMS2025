package chapter14;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class SpellChecker extends JFrame {
    JTextField word = new JTextField(20);
    JTextArea list = new JTextArea(5, 35), out = new JTextArea(8, 35);
    public SpellChecker() {
        super("14.24 Spell Checker");
        list.setText("default\ncomputer\njava\nprogram\nhello\nworld\nstudent\nkeyboard\nstring\nmethod");
        out.setEditable(false);
        JButton b = new JButton("Check");
        b.addActionListener(e -> check());
        add(new JLabel("Word:"), BorderLayout.NORTH);
        add(word, BorderLayout.WEST);
        add(b, BorderLayout.EAST);
        add(new JScrollPane(list), BorderLayout.CENTER);
        add(new JScrollPane(out), BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 500);
        setLocationRelativeTo(null);
    }
    void check() {
        String w = word.getText().trim().toLowerCase(), best = "";
        Set < String > words = new HashSet < > (Arrays.asList(list.getText().toLowerCase().split("\\s+")));
        if (words.contains(w)) {
            out.setText("Word is spelled correctly.");
            return;
        }
        for (String x: words) if (x.length() == w.length()) {
            int d = 0;
            for (int i = 0; i < w.length(); i ++ ) if (w.charAt(i) != x.charAt(i)) d ++ ;
            if (d == 1) {
                best = x;
                break;
            }
        }
        out.setText(best.isEmpty() ? "Word is not spelled correctly.": "Word is not spelled correctly.\nDid you mean \"" + best + "\"?");
    }
    public static void main(String[] z) {
        new SpellChecker().setVisible(true);
    }
}
