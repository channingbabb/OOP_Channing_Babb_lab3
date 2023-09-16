package Channing_Babb_lab3.numberDisplayGUI;

import javax.swing.JButton;
import javax.swing.JLabel;

// bit of polymorphism here
public class EvenerButton extends JButton {


    public EvenerButton(NumberDisplay numberDisplay, JLabel label) {
        // set parent button text
        super("Evener");
        addActionListener(e -> {
            label.setText(numberDisplay.evener());
        });
    }
}
