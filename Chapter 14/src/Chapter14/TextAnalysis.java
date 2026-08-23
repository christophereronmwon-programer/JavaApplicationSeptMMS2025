package chapter14;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class TextAnalysis extends JFrame {
    JTextArea in = new JTextArea(6, 55), out = new JTextArea(20, 55);
    public TextAnalysis() {
        super("14.18 Text Analysis");
        out.setEditable(false);
        JButton b = new JButton("Analyze");
        add(new JScrollPane(in), BorderLayout.NORTH);
        add(new JScrollPane(out), BorderLayout.CENTER);
        add(b, BorderLayout.SOUTH);
        b.addActionListener(e -> analyze());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 600);
        setLocationRelativeTo(null);
    }
    void analyze() {
        String s = in.getText();
        int[] letters = new int[26];
        for (char c: s.toLowerCase().toCharArray()) if (c >= 'a' && c <= 'z') letters[c - 'a'] ++ ;
        String[] words = s.split("\\s+");
        Map < Integer, Integer > lengths = new TreeMap < > ();
        LinkedHashMap < String, Integer > freq = new LinkedHashMap < > ();
        for (String w: words) if ( ! w.isEmpty()) {
            lengths.put(w.length(), lengths.getOrDefault(w.length(), 0) + 1);
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        StringBuilder x = new StringBuilder("Letters\n");
        for (int i = 0; i < 26; i ++ ) x.append((char)('a' + i)).append(": ").append(letters[i]).append("\n");
        x.append("\nWord lengths\n");
        for (var e: lengths.entrySet()) x.append(e.getKey()).append(": ").append(e.getValue()).append("\n");
        x.append("\nWords in order\n");
        for (var e: freq.entrySet()) x.append(e.getKey()).append(": ").append(e.getValue()).append("\n");
        out.setText(x.toString());
    }
    public static void main(String[] z) {
        new TextAnalysis().setVisible(true);
    }
}
