import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Choice {

    public class ChangeColor extends JFrame {
        private JComboBox<String> colorList;

        public ChangeColor() {
            super("Zmena farby");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 400);

            // nastavenie možností farieb v rokovacom zozname
            String[] colorChoices = {"červená", "modrá", "zelená", "vlastná"};
            colorList = new JComboBox<>(colorChoices);

            // pridanie akcie na výber farby z rokovacieho zoznamu
            colorList.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedColor = (String) colorList.getSelectedItem();
                    Color color;

                    // zistenie zvolenej farby a nastavenie premennej color na zodpovedajúcu farbu
                    switch(selectedColor) {
                        case "červená":
                            color = Color.RED;
                            break;
                        case "modrá":
                            color = Color.BLUE;
                            break;
                        case "zelená":
                            color = Color.GREEN;
                            break;
                        case "vlastná":
                            color = JColorChooser.showDialog(null, "Vyberte farbu", Color.BLACK);
                            break;
                        default:
                            color = Color.BLACK;
                            break;
                    }

                    // nastavenie novej farby pre všetky geometrické tvary
                    setForeground(color);
                    repaint();
                }
            });

            // pridanie rokovacieho zoznamu do grafického rozhrania
            JPanel panel = new JPanel();
            panel.add(new JLabel("Vyberte farbu: "));
            panel.add(colorList);
            getContentPane().add(panel, "North");

            setVisible(true);
        }

        public void paint(Graphics g) {
            super.paint(g);
            // vykreslenie niekoľkých geometrických tvarov
            g.drawRect(50, 100, 100, 100);
            g.fillRect(200, 100, 100, 100);
            g.drawOval(50, 250, 100, 100);
            g.fillOval(200, 250, 100, 100);
        }
    }

    public static void main(String[] args) {
        Choice choice = new Choice();
        ChangeColor changeColor = choice.new ChangeColor();
    }
}

