package chapter14;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class MorseCode extends JFrame {
    JTextArea in = new JTextArea(5, 45), out = new JTextArea(8, 45);
    Map < Character, String > m = new HashMap < > ();
    Map < String, Character > rev = new HashMap < > ();
    public MorseCode() {
        super("14.22 Morse Code");
        build();
        JButton enc = new JButton("English -> Morse"), dec = new JButton("Morse -> English");
        JPanel p = new JPanel();
        p.add(enc);
        p.add(dec);
        enc.addActionListener(e -> encode());
        dec.addActionListener(e -> decode());
        add(new JScrollPane(in), BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        add(new JScrollPane(out), BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 500);
        setLocationRelativeTo(null);
    }
    void build() {
        String[] c = {
            "A .-", "B -...", "C -.-.", "D -..", "E .", "F ..-.", "G --.", "H ....", "I ..", "J .---", "K -.-", "L .-..", "M --", "N -.", "O ---", "P .--.", "Q --.-", "R .-.", "S ...", "T -", "U ..-", "V ...-", "W .--", "X -..-", "Y -.--", "Z --..", "0 -----", "1 .----", "2 ..---", "3 ...--", "4 ....-", "5 .....", "6 -....", "7 --...", "8 ---..", "9 ----."
        };
        for (String s: c) {
            String[] p = s.split(" ");
            m.put(p[0].charAt(0), p[1]);
            rev.put(p[1], p[0].charAt(0));
        }
    }
    void encode() {
        StringBuilder s = new StringBuilder();
        for (String w: in.getText().toUpperCase().split(" ")) {
            for (char c: w.toCharArray()) if (m.containsKey(c)) s.append(m.get(c)).append(" ");
            s.append("  ");
        }
        out.setText(s.toString().trim());
    }
    void decode() {
        StringBuilder s = new StringBuilder();
        for (String w: in.getText().trim().split("   ")) {
            for (String c: w.trim().split(" ")) if (rev.containsKey(c)) s.append(rev.get(c));
            s.append(" ");
        }
        out.setText(s.toString().trim());
    }
    public static void main(String[] z) {
        new MorseCode().setVisible(true);
    }
}
