import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class ColorCheckbox {

    public class ColorMix extends JFrame {
        private JCheckBox redBox, greenBox, blueBox;

        public ColorMix() {
            setTitle("Miešanie farieb");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 400);

            // vytvorenie checkboxov pre jednotlive farby
            redBox = new JCheckBox("červená");
            greenBox = new JCheckBox("zelená");
            blueBox = new JCheckBox("modrá");

            // pridanie akcie na zmenu stavu checkboxov
            ItemListener listener = new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    repaint();
                }
            };
            redBox.addItemListener(listener);
            greenBox.addItemListener(listener);
            blueBox.addItemListener(listener);

            // pridanie checkboxov do grafickeho rozhrania
            JPanel panel = new JPanel();
            panel.add(redBox);
            panel.add(greenBox);
            panel.add(blueBox);
            getContentPane().add(panel, "North");

            setVisible(true);
        }

        public void paint(Graphics g) {
            super.paint(g);
            // ziskanie stavu checkboxov
            boolean redSelected = redBox.isSelected();
            boolean greenSelected = greenBox.isSelected();
            boolean blueSelected = blueBox.isSelected();

            // ziskanie farby podla stavu checkboxov
            Color color;
            if (!redSelected && !greenSelected && !blueSelected) {
                color = Color.BLACK;
            } else if (redSelected && greenSelected && blueSelected) {
                color = Color.WHITE;
            } else {
                int red = redSelected ? 255 : 0;
                int green = greenSelected ? 255 : 0;
                int blue = blueSelected ? 255 : 0;
                color = new Color(red, green, blue);
            }

            // vykreslenie utvarov s danou farbou
            g.setColor(color);
            g.fillRect(50, 100, 100, 100);
            g.fillRect(200, 100, 100, 100);
            g.fillRect(50, 250, 100, 100);
            g.fillRect(200, 250, 100, 100);
        }
    }

    public static void main(String[] args) {
        ColorCheckbox colorCheckbox = new ColorCheckbox();
        ColorMix colorMix = colorCheckbox.new ColorMix();
    }
}


