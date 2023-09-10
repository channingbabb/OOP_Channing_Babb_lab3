package Channing_Babb_lab3.dicebag;
// Adapt your DiceBag from Lab two into a GUI.
// In the window, the user ought to see graphically a representation of the DiceBag,
// including the number of each type of die currently in the bag, as well as
// buttons to add dice of the various number of faces to the bag.
// In the main panel, there should be buttons to roll the dice and a display for
// the result of the roll.  If multiple dice are rolled, then you should display
// a sum.
//Additionally, have an ‘Armageddon” button that rolls all the dice and
// provides a sum.

import javax.swing.*;
import java.awt.*;

public class DiceBagGUI {
    DiceBag diceBag = new DiceBag();


    static JFrame frame = new JFrame("DiceBag");
    static JPanel panel = new JPanel();
    static JLabel label = new JLabel();
    // create JFrame
    // create JPanel
    // create JLabel
    // create JButton
    // create JTextField
    // create JList
    // create JSpinner
    // create JSlider
    // create JCheckBox



    // create constructor
    public DiceBagGUI() {
        // set the size of the frame
        frame.setSize(600, 600);
        // set the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the frame to be visible
        frame.setVisible(true);
        // set the layout of the panel
        panel.setLayout(new GridLayout(3, 4));
        // add the panel to the frame
        frame.add(panel);
        // add the label to the panel
        panel.add(label);

        // create buttons 4, 6, 8, 10, 12, 20
        for (int i = 4; i <= 20; i += 2) {
            final JButton button = new JButton(Integer.toString(i));
            panel.add(button);
            button.addActionListener(e -> {
                Die die = new Die(Integer.parseInt(button.getText()));
                diceBag.addDie(die);
                label.setText(diceBag.toString());
            });
        }

    }


}
