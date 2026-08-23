package chapter12;

import javax.swing.*;
import java.awt.*;

public class TemperatureConversionKelvin extends JFrame {
    private final JComboBox<String> fromScale =
            new JComboBox<>(new String[]{"Fahrenheit", "Celsius", "Kelvin"});
    private final JComboBox<String> toScale =
            new JComboBox<>(new String[]{"Fahrenheit", "Celsius", "Kelvin"});
    private final JTextField inputField = new JTextField(10);
    private final JLabel resultLabel = new JLabel("Result: ");

    public TemperatureConversionKelvin() {
        super("12.13 Temperature Conversion Modification");
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Convert from:"));
        add(fromScale);

        add(new JLabel("Convert to:"));
        add(toScale);

        add(new JLabel("Temperature:"));
        add(inputField);

        JButton convertButton = new JButton("Convert");
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(e -> convert());
        inputField.addActionListener(e -> convert());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 180);
        setLocationRelativeTo(null);
    }

    private void convert() {
        try {
            double value = Double.parseDouble(inputField.getText());
            String from = (String) fromScale.getSelectedItem();
            String to = (String) toScale.getSelectedItem();

            double celsius;

            switch (from) {
                case "Fahrenheit":
                    celsius = (value - 32) * 5 / 9;
                    break;
                case "Kelvin":
                    celsius = value - 273.15;
                    break;
                default:
                    celsius = value;
            }

            double result;
            switch (to) {
                case "Fahrenheit":
                    result = celsius * 9 / 5 + 32;
                    break;
                case "Kelvin":
                    result = celsius + 273.15;
                    break;
                default:
                    result = celsius;
            }

            resultLabel.setText(String.format("Result: %.2f %s", result, to));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConversionKelvin().setVisible(true));
    }
}
