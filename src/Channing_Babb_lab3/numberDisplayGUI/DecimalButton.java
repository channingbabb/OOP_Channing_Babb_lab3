package Channing_Babb_lab3.numberDisplayGUI;

import javax.swing.JButton;
import javax.swing.JLabel;

// polymorphism
public class DecimalButton extends JButton {

    public DecimalButton(NumberDisplay numberDisplay, JLabel label) {
        super(".");
        addActionListener(e -> {
            String number = numberDisplay.append(this.getText());
            label.setText(number);
        });
    }
}
