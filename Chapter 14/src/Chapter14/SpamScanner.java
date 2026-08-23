package chapter14;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class SpamScanner extends JFrame {
    JTextArea msg = new JTextArea(12, 55), out = new JTextArea(8, 55);
    String[] spam = {
        "free", "winner", "win money", "cash", "prize", "urgent", "click", "offer", "buy now", "limited time", "congratulations", "million", "guaranteed", "cheap", "discount", "viagra", "loan", "credit", "investment", "earn money", "risk free", "act now", "selected", "claim", "bonus", "unsubscribe", "casino", "password", "account", "dear friend"
    };
    public SpamScanner() {
        super("14.27 Spam Scanner");
        out.setEditable(false);
        JButton b = new JButton("Scan");
        b.addActionListener(e -> scan());
        add(new JScrollPane(msg), BorderLayout.NORTH);
        add(new JScrollPane(out), BorderLayout.CENTER);
        add(b, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
    }
    void scan() {
        String s = msg.getText().toLowerCase();
        int score = 0;
        StringBuilder x = new StringBuilder();
        for (String k: spam) {
            int p = 0, c = 0;
            while ((p = s.indexOf(k, p)) >= 0) {
                c ++ ;
                score ++ ;
                p += k.length();
            }
            if (c > 0) x.append(k).append(": ").append(c).append("\n");
        }
        x.append("\nSpam score: ").append(score).append("\nLikelihood: ").append(score >= 8 ? "HIGH": score >= 4 ? "MEDIUM": "LOW");
        out.setText(x.toString());
    }
    public static void main(String[] z) {
        new SpamScanner().setVisible(true);
    }
}
