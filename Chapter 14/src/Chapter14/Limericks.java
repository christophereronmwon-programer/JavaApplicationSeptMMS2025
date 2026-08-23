package chapter14;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Limericks extends JFrame {
    JTextArea out = new JTextArea(15, 55);
    Random r = new Random();
    String[] a = {
        "There once was a coder from Rome", "Who wrote Java code at home", "He coded all day", "In a curious way", "And finished the program alone"
    };
    String[][] lines = {
        {
            "There once was a coder from Rome", "There once was a student named Joe", "There once was a programmer from town"
        }, {
            "Who wrote Java code at home", "Who practiced his coding alone", "Who debugged his program all day"
        }, {
            "He coded all day", "He solved bugs with care", "He learned something new"
        }, {
            "In a curious way", "With coffee right there", "And made it work too"
        }, {
            "And finished the program alone", "And proudly completed his code", "And smiled at the result"
        }
    };
    public Limericks() {
        super("14.6 Project: Limericks");
        out.setEditable(false);
        JButton b = new JButton("Generate Limerick");
        b.addActionListener(e -> generate());
        add(b, BorderLayout.NORTH);
        add(new JScrollPane(out));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
    void generate() {
        out.setText("");
        for (int i = 0; i < 5; i ++ ) out.append(lines[i][r.nextInt(lines[i].length)] + "\n");
    }
    public static void main(String[] z) {
        new Limericks().setVisible(true);
    }
}
