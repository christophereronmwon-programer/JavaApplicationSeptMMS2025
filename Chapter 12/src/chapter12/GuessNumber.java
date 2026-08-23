package chapter12;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GuessNumber extends JFrame {
    private final Random random = new Random();
    private int number;
    private final JLabel messageLabel = new JLabel(
            "I have a number between 1 and 1000. Can you guess my number?");
    private final JLabel hintLabel = new JLabel("Please enter your first guess.");
    private final JTextField guessField = new JTextField(10);
    private final JButton newGameButton = new JButton("New Game");

    public GuessNumber() {
        super("12.14 Guess-the-Number Game");

        setLayout(new FlowLayout());
        messageLabel.setPreferredSize(new Dimension(430, 25));
        hintLabel.setPreferredSize(new Dimension(430, 25));

        add(messageLabel);
        add(hintLabel);
        add(new JLabel("Guess:"));
        add(guessField);
        add(newGameButton);

        guessField.addActionListener(e -> checkGuess());
        newGameButton.addActionListener(e -> newGame());

        newGame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 180);
        setLocationRelativeTo(null);
    }

    private void newGame() {
        number = random.nextInt(1000) + 1;
        guessField.setEditable(true);
        guessField.setText("");
        guessField.setBackground(Color.WHITE);
        hintLabel.setText("Please enter your first guess.");
        guessField.requestFocusInWindow();
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());

            if (guess < 1 || guess > 1000) {
                hintLabel.setText("Enter a number from 1 to 1000.");
                return;
            }

            if (guess == number) {
                hintLabel.setText("Correct!");
                guessField.setEditable(false);
            } else if (guess > number) {
                hintLabel.setText("Too High");
                guessField.setBackground(Color.RED);
            } else {
                hintLabel.setText("Too Low");
                guessField.setBackground(Color.BLUE);
            }
        } catch (NumberFormatException ex) {
            hintLabel.setText("Enter a whole number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessNumber().setVisible(true));
    }
}
