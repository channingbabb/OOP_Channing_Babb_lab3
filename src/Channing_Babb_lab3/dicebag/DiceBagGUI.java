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
    static final String DICEBAG_IMAGE_PATH = "src/Channing_Babb_lab3/dicebag.jpg";
    int dice[];
    DiceBag diceBag = new DiceBag();
    static JFrame frame = new JFrame("DiceBag");
    static JPanel panel = new JPanel();
    static JLabel label = new JLabel();
    static JPanel dicePanel = new JPanel();
    static JPanel masterPanel = new JPanel();


    static JLabel fours = new JLabel();
    static JLabel sixes = new JLabel();
    static JLabel eights = new JLabel();
    static JLabel tens = new JLabel();
    static JLabel twelves = new JLabel();
    static JLabel twenties = new JLabel();

    public void createButtons() {
        // create buttons 4, 6, 8, 10, 12, 20
        for (int i = 4; i <= 20; i += 2) {
            if (i == 14 || i == 16 || i == 18) {
                continue;
            }
            final JButton button = new JButton(Integer.toString(i));
            panel.add(button);
            int finalI = i;
            button.addActionListener(e -> {
                switch (finalI) {
                    case 4:
                        int result = diceBag.rollFours(1);
                        label.setText("You rolled a " + result + " with a " + finalI + " sided die.");
                        // create new dice in the dice panel
                        dice[0] = result;
                        break;
                    case 6:
                        result = diceBag.rollSixes(1);
                        label.setText("You rolled a " + result + " with a " + finalI + " sided die.");
                        break;
                    case 8:
                        result = diceBag.rollEights(1);
                        label.setText("You rolled a " + result + " with a " + finalI + " sided die.");
                        break;
                    case 10:
                        result = diceBag.rollTens(1);
                        label.setText("You rolled a " + result + " with a " + finalI + " sided die.");
                        break;
                    case 12:
                        result = diceBag.rollTwelves(1);
                        label.setText("You rolled a " + result + " with a " + finalI + " sided die.");
                        break;
                    case 20:
                        result = diceBag.rollTwenties(1);
                        label.setText("You rolled a " + result + " with a " + finalI + " sided die.");
                        break;
                }

                getNumDice();
            });
        }

        // Armageddon button
        final JButton button = new JButton("Armageddon");
        panel.add(button);
        button.addActionListener(e -> {
//            Die die = new Die(Integer.parseInt(button.getText()));
//            diceBag.addDie(die);
            int result = diceBag.armageddon();
            label.setText("Sum of armageddon: " + result + "\n");
        });
    }

    // dicebag image function
    public void createDiceBagImage() {
        // set size of image
        // https://stackoverflow.com/a/32886146
        // create new label that is an image icon for dicebag.jpg
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(DICEBAG_IMAGE_PATH).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel diceBag = new JLabel(imageIcon);
        panel.add(diceBag);
    }

    // get # of dice
    public void getNumDice() {
        int foursCounter = 0;
        int sixesCounter = 0;
        int eightsCounter = 0;
        int tensCounter = 0;
        int twelvesCounter = 0;
        int twentiesCounter = 0;

        // foreach in dicebag
        for (int i=0; i<diceBag.getDiceBag().size(); i++) {
            // if die is 4 sided
            Die die = (Die) diceBag.getDiceBag().get(i);
            if (die.getNumberOfSides() == 4) {
                // increment counter
                foursCounter++;
            }
            // if die is 6 sided
            if (die.getNumberOfSides() == 6) {
                // increment counter
                sixesCounter++;
            }
            // if die is 8 sided
            if (die.getNumberOfSides() == 8) {
                // increment counter
                eightsCounter++;
            }
            // if die is 10 sided
            if (die.getNumberOfSides() == 10) {
                // increment counter
                tensCounter++;
            }
            // if die is 12 sided
            if (die.getNumberOfSides() == 12) {
                // increment counter
                twelvesCounter++;
            }
            // if die is 20 sided
            if (die.getNumberOfSides() == 20) {
                // increment counter
                twentiesCounter++;
            }
        }
        // append to string builder

        fours.setText("Number of 4 sided dice: " + foursCounter + "\n");
        sixes.setText("Number of 6 sided dice: " + sixesCounter + "\n");
        eights.setText("Number of 8 sided dice: " + eightsCounter + "\n");
        tens.setText("Number of 10 sided dice: " + tensCounter + "\n");
        twelves.setText("Number of 12 sided dice: " + twelvesCounter + "\n");
        twenties.setText("Number of 20 sided dice: " + twentiesCounter + "\n");
    }

    // create constructor
    public DiceBagGUI() {
        createButtons();
        getNumDice();
        // set to different layout
        masterPanel.add(panel);
        masterPanel.add(dicePanel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // create dicebag image
        createDiceBagImage();
        // set the size of the frame
        frame.setSize(600, 600);
        // set the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add the panel to the frame
        // add the label to the panel
        panel.add(label);
        panel.add(fours);
        panel.add(sixes);
        panel.add(eights);
        panel.add(tens);
        panel.add(twelves);
        panel.add(twenties);
        frame.add(masterPanel);
        // set the frame to be visible
        frame.setVisible(true);
    }
}
