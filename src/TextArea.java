import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextArea {

    public static void main(String[] args) {

        // vytvorenie hlavneho okna aplikacie
        JFrame frame = new JFrame("TextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // vytvorenie TextArea komponentov
        JTextArea editableArea = new JTextArea(10, 20);
        JTextArea nonEditableArea = new JTextArea(10, 20);
        nonEditableArea.setEditable(false);

        // vytvorenie tlacidla pre kopirovanie textu odzadu
        JButton copyButton = new JButton("Kopírovať odzadu");
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = editableArea.getText();
                String reversedText = reverseString(text);
                nonEditableArea.setText(reversedText);
            }
        });

        // vytvorenie CheckBoxu pre voľbu operácie
        JCheckBox operationCheckbox = new JCheckBox("Zachovať poradie slov");

        // vytvorenie panelu s tlacidlom a CheckBoxom
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(copyButton);
        buttonPanel.add(operationCheckbox);

        // pridanie TextArea a panelu do hlavneho okna
        frame.add(editableArea, BorderLayout.WEST);
        frame.add(nonEditableArea, BorderLayout.EAST);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // zobrazenie hlavneho okna
        frame.pack();
        frame.setVisible(true);
    }

    // metoda na reverzovanie retazca
    private static String reverseString(String input) {
        String[] words = input.split("\\s");
        StringBuilder reversedText = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedText.append(words[i]).append(" ");
        }
        return reversedText.toString().trim();
    }

}

