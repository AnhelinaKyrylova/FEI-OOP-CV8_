import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RGBColorPicker extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField redField;
    private JTextField greenField;
    private JTextField blueField;
    private JLabel colorLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RGBColorPicker frame = new RGBColorPicker();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RGBColorPicker() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel redLabel = new JLabel("Red:");
        redLabel.setBounds(10, 10, 80, 25);
        contentPane.add(redLabel);

        redField = new JTextField();
        redField.setBounds(100, 10, 80, 25);
        contentPane.add(redField);

        JLabel greenLabel = new JLabel("Green:");
        greenLabel.setBounds(10, 40, 80, 25);
        contentPane.add(greenLabel);

        greenField = new JTextField();
        greenField.setBounds(100, 40, 80, 25);
        contentPane.add(greenField);

        JLabel blueLabel = new JLabel("Blue:");
        blueLabel.setBounds(10, 70, 80, 25);
        contentPane.add(blueLabel);

        blueField = new JTextField();
        blueField.setBounds(100, 70, 80, 25);
        contentPane.add(blueField);

        colorLabel = new JLabel("");
        colorLabel.setBounds(100, 100, 80, 25);
        contentPane.add(colorLabel);

        redField.addActionListener(e -> updateColor());
        greenField.addActionListener(e -> updateColor());
        blueField.addActionListener(e -> updateColor());
    }

    private void updateColor() {
        String redText = redField.getText();
        String greenText = greenField.getText();
        String blueText = blueField.getText();

        try {
            int red = Integer.parseInt(redText, 10);
            int green = Integer.parseInt(greenText, 10);
            int blue = Integer.parseInt(blueText, 10);

            Color color = new Color(red, green, blue);
            colorLabel.setText(String.format("#%02x%02x%02x", red, green, blue));
            colorLabel.setBackground(color);
        } catch (NumberFormatException e) {
            String tooltip = "Please  enter valid values for all RGB fields (0-255)";
            colorLabel.setToolTipText(tooltip);
        }}}
