package chapter14;
import javax.swing.*;
import java.awt.*;
public class CrosswordGenerator extends JFrame {
    JTextArea words = new JTextArea(10, 20), grid = new JTextArea(15, 30);
    public CrosswordGenerator() {
        super("14.25 Crossword Puzzle Generator");
        JButton b = new JButton("Generate");
        b.addActionListener(e -> generate());
        add(new JScrollPane(words), BorderLayout.WEST);
        add(new JScrollPane(grid), BorderLayout.CENTER);
        add(b, BorderLayout.SOUTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
    void generate() {
        String[] w = words.getText().toUpperCase().split("\\s+");
        char[][] g = new char[15][15];
        for (int r = 0; r < 15; r ++ ) java.util.Arrays.fill(g[r], '#');
        int row = 7, col = 0;
        for (String s: w) {
            if (col + s.length() > 15) {
                row ++ ;
                col = 0;
            }
            if (row >= 15) break;
            for (char c: s.toCharArray()) g[row][col ++ ] = c;
            col ++ ;
        }
        StringBuilder x = new StringBuilder();
        for (char[] r: g) x.append(new String(r)).append("\n");
        grid.setText(x.toString());
    }
    public static void main(String[] z) {
        new CrosswordGenerator().setVisible(true);
    }
}
