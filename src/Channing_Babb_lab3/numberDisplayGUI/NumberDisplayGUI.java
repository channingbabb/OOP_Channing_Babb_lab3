package Channing_Babb_lab3.numberDisplayGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Create an application with a GUI that displays a numeric entry pad.  You should have buttons for each digit, a button for a decimal, and a button to Clear and an “Evener”.  There should also be a “display” which shows the digits (or decimal) as they are pushed.  The Clear button should clear the display of any digits.  The “Evener” button should “round” the number to the closet even integer.  If the number displayed is an odd integer (i.e. 50% of the way between the two nearest even integers), then round up. (33 points)

public class NumberDisplayGUI {
    NumberDisplay numberDisplay = new NumberDisplay();
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
    static JButton decimal = new JButton(".");
    // create a JButton for the clear button
    static JButton clear = new JButton("Clear");
    // create a JButton for the evener button
    static JButton evener = new JButton("Evener");


    // display the GUI
    public NumberDisplayGUI() {


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
        panel.add(spacer1);
        // add the label to the panel
        panel.add(label);
        panel.add(spacer2);
        panel.add(spacer3);
        label.setText(numberDisplay.number);


        // create buttons 0-9
        for (int i = 0; i < 10; i++) {
            final JButton button = new JButton(Integer.toString(i));
            panel.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String number = numberDisplay.append(String.valueOf(button.getText()));
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


    }





}
