
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Menu {

    private JFrame frame;
    private JPanel cards;
    private CardLayout cardLayout;
    private JTextArea textArea1, textArea2;

    public Menu() {
        frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenu();

        createCards();

        frame.add(cards, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Programs");
        JMenuItem program1Item = new JMenuItem("Program 1");
        JMenuItem program2Item = new JMenuItem("Program 2");

        program1Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "program1");
            }
        });

        program2Item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "program2");
            }
        });

        menu.add(program1Item);
        menu.add(program2Item);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }

    private void createCards() {
        cards = new JPanel(new CardLayout());
        cardLayout = (CardLayout) cards.getLayout();

        // Program 1
        JPanel program1Panel = new JPanel();
        textArea1 = new JTextArea("Text Area 1");
        textArea2 = new JTextArea("Text Area 2");
        textArea2.setEditable(false);
        program1Panel.add(textArea1);
        program1Panel.add(textArea2);

        // Program 2
        JPanel program2Panel = new JPanel();
        program2Panel.add(new ColorCheckbox().new ColorMix());

        cards.add(program1Panel, "program1");
        cards.add(program2Panel, "program2");
    }

    public static void main(String[] args) {
        new Menu();
    }
}

