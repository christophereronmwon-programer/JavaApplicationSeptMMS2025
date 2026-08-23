package chapter12;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayingEvents extends JFrame
        implements ActionListener, ItemListener, ListSelectionListener,
                   MouseListener, MouseMotionListener, KeyListener {

    private final JTextArea output = new JTextArea(20, 55);
    private final JButton button = new JButton("Click Me");
    private final JCheckBox checkBox = new JCheckBox("Check Me");
    private final JList<String> list = new JList<>(new String[]{"One", "Two", "Three"});
    private final JTextField textField = new JTextField(20);
    private final JPanel mousePanel = new JPanel();

    public DisplayingEvents() {
        super("12.15 Displaying Events");

        output.setEditable(false);
        mousePanel.setPreferredSize(new Dimension(250, 120));
        mousePanel.setBorder(BorderFactory.createTitledBorder("Mouse Area"));

        JPanel controls = new JPanel();
        controls.add(button);
        controls.add(checkBox);
        controls.add(textField);

        add(controls, BorderLayout.NORTH);
        add(new JScrollPane(output), BorderLayout.CENTER);
        add(new JScrollPane(list), BorderLayout.EAST);
        add(mousePanel, BorderLayout.SOUTH);

        button.addActionListener(this);
        checkBox.addItemListener(this);
        list.addListSelectionListener(this);
        textField.addKeyListener(this);

        mousePanel.addMouseListener(this);
        mousePanel.addMouseMotionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 550);
        setLocationRelativeTo(null);
    }

    private void showEvent(String name, Object event) {
        output.append(name + ": " + event + "\n");
    }

    @Override public void actionPerformed(ActionEvent e) { showEvent("ActionEvent", e.toString()); }
    @Override public void itemStateChanged(ItemEvent e) { showEvent("ItemEvent", e.toString()); }
    @Override public void valueChanged(ListSelectionEvent e) { showEvent("ListSelectionEvent", e.toString()); }
    @Override public void mouseClicked(MouseEvent e) { showEvent("mouseClicked", e.toString()); }
    @Override public void mousePressed(MouseEvent e) { showEvent("mousePressed", e.toString()); }
    @Override public void mouseReleased(MouseEvent e) { showEvent("mouseReleased", e.toString()); }
    @Override public void mouseEntered(MouseEvent e) { showEvent("mouseEntered", e.toString()); }
    @Override public void mouseExited(MouseEvent e) { showEvent("mouseExited", e.toString()); }
    @Override public void mouseDragged(MouseEvent e) { showEvent("mouseDragged", e.toString()); }
    @Override public void mouseMoved(MouseEvent e) { showEvent("mouseMoved", e.toString()); }

    @Override public void keyTyped(KeyEvent e) { showEvent("keyTyped", e.toString()); }
    @Override public void keyPressed(KeyEvent e) { showEvent("keyPressed", e.toString()); }
    @Override public void keyReleased(KeyEvent e) { showEvent("keyReleased", e.toString()); }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DisplayingEvents().setVisible(true));
    }
}
