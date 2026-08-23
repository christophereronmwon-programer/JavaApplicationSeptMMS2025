package chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class TypingTutor extends JFrame {
    private final JTextArea typedText = new JTextArea(5, 45);
    private final Map<Character, JButton> keyButtons = new LinkedHashMap<>();
    private final Map<Character, Color> originalColors = new LinkedHashMap<>();

    public TypingTutor() {
        super("12.20 Typing Tutor");

        typedText.setEditable(false);
        typedText.setLineWrap(true);
        typedText.setWrapStyleWord(true);

        JPanel keyboard = new JPanel(new GridLayout(4, 1, 3, 3));

        String[] rows = {
            "QWERTYUIOP",
            "ASDFGHJKL",
            "ZXCVBNM",
            "0123456789"
        };

        for (String row : rows) {
            JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 2));

            for (char c : row.toCharArray()) {
                JButton key = new JButton(String.valueOf(c));
                key.setFocusable(false);
                key.setPreferredSize(new Dimension(50, 40));
                keyButtons.put(c, key);
                originalColors.put(c, key.getBackground());
                rowPanel.add(key);
            }

            keyboard.add(rowPanel);
        }

        JPanel main = new JPanel(new BorderLayout(5, 5));
        main.add(new JScrollPane(typedText), BorderLayout.NORTH);
        main.add(keyboard, BorderLayout.CENTER);

        add(main);

        // A key listener needs focus on the frame/component receiving keyboard events.
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(e -> {
                    if (e.getID() == KeyEvent.KEY_PRESSED) {
                        handleKeyPressed(e);
                    } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                        handleKeyReleased(e);
                    }
                    return false;
                });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 400);
        setLocationRelativeTo(null);
    }

    private void handleKeyPressed(KeyEvent e) {
        char c = Character.toUpperCase(e.getKeyChar());

        if (c == '\b') {
            String text = typedText.getText();
            if (!text.isEmpty()) {
                typedText.setText(text.substring(0, text.length() - 1));
            }
            return;
        }

        if (Character.isLetterOrDigit(c) || Character.isSpaceChar(e.getKeyChar())) {
            typedText.append(String.valueOf(e.getKeyChar()));
        }

        JButton button = keyButtons.get(c);
        if (button != null) {
            button.setBackground(Color.YELLOW);
        }
    }

    private void handleKeyReleased(KeyEvent e) {
        char c = Character.toUpperCase(e.getKeyChar());
        JButton button = keyButtons.get(c);

        if (button != null) {
            button.setBackground(originalColors.get(c));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TypingTutor().setVisible(true));
    }
}
