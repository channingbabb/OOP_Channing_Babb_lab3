package Channing_Babb_lab3.numberDisplayGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * NumberDisplayGUI
 */
public class NumberDisplayGUI {
    static NumberDisplay numberDisplay = new NumberDisplay();
    // create a JFrame
    static JFrame frame = new JFrame("Number Display GUI");
    // create a JPanel
    static JPanel panel = new JPanel();
    // create a JLabel
    static JLabel label = new JLabel();
    // create spacer JLabels
    static JLabel spacer1 = new JLabel();
    static JLabel spacer2 = new JLabel();
    static JLabel spacer3 = new JLabel();
    // create a JButton for the decimal
    static DecimalButton decimal = new DecimalButton(numberDisplay, label);
    // create a JButton for the clear button
    static ClearButton clear = new ClearButton(numberDisplay, label);
    // create a JButton for the evener button
    static EvenerButton evener = new EvenerButton(numberDisplay, label);


    /**
     * NumberDisplayGUI
     * This is the constructor for the NumberDisplayGUI class
     */
    public NumberDisplayGUI() {


        // add the panel to the frame
        frame.add(panel);
        panel.add(spacer1);
        // add the label to the panel
        panel.add(label);
        panel.add(spacer2);
        panel.add(spacer3);
        label.setText(numberDisplay.number);


        // set the size of the frame
        frame.setSize(600, 600);
        // set the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the layout of the panel
        panel.setLayout(new GridLayout(3, 4));
        // create buttons 0-9
        for (int i = 0; i < 10; i++) {
            final JButton button = new JButton(Integer.toString(i));
            panel.add(button);
            button.addActionListener(new ActionListener() { // action listener for the button
                @Override
                public void actionPerformed(ActionEvent e) {
                    String number = numberDisplay.append(String.valueOf(button.getText())); // append the text of the button to the numberDisplay
                    label.setText(number);
                }
            });
        }

        // add the buttons to the panel
        panel.add(decimal);
        panel.add(clear);
        panel.add(evener);

        // add an action listener to the button
        decimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = numberDisplay.append(decimal.getText());
                label.setText(number);
            }
        });

        // add an action listener to the button
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set the text of the label to the text of the button
                numberDisplay.clear();
                label.setText(numberDisplay.number);
            }
        });

        // add an action listener to the button
        evener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = numberDisplay.evener();
                label.setText(number);
            }
        });


        // set the frame to be visible
        frame.setVisible(true);


    }





}
