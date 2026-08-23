package chapter12;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CrapsGUI extends JFrame {
    private final Random random = new Random();
    private final JTextField die1 = new JTextField(5);
    private final JTextField die2 = new JTextField(5);
    private final JTextField sum = new JTextField(5);
    private final JTextField pointField = new JTextField(5);
    private final JLabel status = new JLabel("Click Roll Dice to begin.");
    private final JButton rollButton = new JButton("Roll Dice");

    private int point;
    private boolean firstRoll = true;
    private boolean gameOver = false;

    public CrapsGUI() {
        super("12.16 GUI-Based Craps Game");

        setLayout(new FlowLayout());

        add(new JLabel("Die 1:"));
        add(die1);
        add(new JLabel("Die 2:"));
        add(die2);
        add(new JLabel("Sum:"));
        add(sum);
        add(new JLabel("Point:"));
        add(pointField);
        add(rollButton);
        add(status);

        die1.setEditable(false);
        die2.setEditable(false);
        sum.setEditable(false);
        pointField.setEditable(false);

        rollButton.addActionListener(e -> rollDice());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 160);
        setLocationRelativeTo(null);
    }

    private void rollDice() {
        if (gameOver) return;

        int d1 = random.nextInt(6) + 1;
        int d2 = random.nextInt(6) + 1;
        int total = d1 + d2;

        die1.setText(String.valueOf(d1));
        die2.setText(String.valueOf(d2));
        sum.setText(String.valueOf(total));

        if (firstRoll) {
            firstRoll = false;

            if (total == 7 || total == 11) {
                status.setText("You win!");
                gameOver = true;
            } else if (total == 2 || total == 3 || total == 12) {
                status.setText("You lose!");
                gameOver = true;
            } else {
                point = total;
                pointField.setText(String.valueOf(point));
                status.setText("Point is " + point + ". Roll again.");
            }
        } else {
            if (total == 7) {
                status.setText("You lose!");
                gameOver = true;
            } else if (total == point) {
                status.setText("You win!");
                gameOver = true;
            }
        }

        if (gameOver) rollButton.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CrapsGUI().setVisible(true));
    }
}
