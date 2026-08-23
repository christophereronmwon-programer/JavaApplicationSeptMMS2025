package chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConversion extends JFrame {
    private final JTextField fahrenheitField = new JTextField(10);
    private final JLabel resultLabel = new JLabel("Celsius: ");

    public TemperatureConversion() {
        super("12.12 Temperature Conversion");
        setLayout(new FlowLayout());

        add(new JLabel("Fahrenheit:"));
        add(fahrenheitField);

        JButton convertButton = new JButton("Convert");
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(e -> convert());
        fahrenheitField.addActionListener(e -> convert());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 120);
        setLocationRelativeTo(null);
    }

    private void convert() {
        try {
            double fahrenheit = Double.parseDouble(fahrenheitField.getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            resultLabel.setText(String.format("Celsius: %.2f", celsius));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConversion().setVisible(true));
    }
}
