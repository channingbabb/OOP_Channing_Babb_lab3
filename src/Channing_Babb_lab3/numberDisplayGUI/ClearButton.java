package Channing_Babb_lab3.numberDisplayGUI;

import javax.swing.JButton;
import javax.swing.JLabel;

// polymorphism
public class ClearButton extends JButton {

    public ClearButton(NumberDisplay numberDisplay, JLabel label) {
        super("Clear");
        addActionListener(e -> {
            numberDisplay.clear();
            label.setText(numberDisplay.number);
        });
    }
}
