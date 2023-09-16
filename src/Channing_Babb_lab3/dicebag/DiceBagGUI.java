package Channing_Babb_lab3.dicebag;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * DiceBagGUI Class
 * This class holds the functions for the dicebag GUI
 */
public class DiceBagGUI {
    // The path to the image of the dice bag
    static final String DICEBAG_IMAGE_PATH = "src/Channing_Babb_lab3/dicebag.jpg";
    // An array to store the results of rolling the dice
    int dice[];
    // The DiceBag object
    DiceBag diceBag = new DiceBag();
    // The main window frame
    static JFrame frame = new JFrame("DiceBag");
    // The main panel
    static JPanel panel = new JPanel();
    // The label to display the results of rolling the dice
    static JLabel label = new JLabel();
    // The panel to display the dice
    static JPanel dicePanel = new JPanel();
    // The master panel to hold the main panel and the dice panel
    static JPanel masterPanel = new JPanel();

    // A map to store the labels for the number of each type of die in the bag
    static Map<Integer, JLabel> diceCountLabels = new HashMap<>();
    // A list to store the buttons for adding dice to the bag
    static List<JButton> diceButtons = new ArrayList<>();

    /**
     * Creates the buttons for adding dice to the bag.
     */
    public void createButtons() {
        // create buttons 4, 6, 8, 10, 12, 20
        for (int i = 4; i <= 20; i += 2) {
            if (i == 14 || i == 16 || i == 18) {
                continue;
            }
            final JButton button = new JButton(Integer.toString(i));
            diceButtons.add(button);
            panel.add(button);
            int finalI = i;
            button.addActionListener(e -> {
                Die die = new Die(finalI);
                int result = diceBag.rollDice(1, die);
                label.setText("You rolled a " + result + " with a " + finalI + " sided die.");
                getNumDice();
                // create new dice in the dice panel
                dice[0] = result;
            });
        }

        // Armageddon button
        final JButton button = new JButton("Armageddon");
        diceButtons.add(button);
        panel.add(button);
        button.addActionListener(e -> {
            int result = diceBag.armageddon();
            label.setText("Sum of armageddon: " + result + "\n");
            getNumDice();
        });
    }

    /**
     * Creates the image of the dice bag.
     */
    public void createDiceBagImage() {
        // set size of image
        // https://stackoverflow.com/a/32886146
        // create new label that is an image icon for dicebag.jpg
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(DICEBAG_IMAGE_PATH).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel diceBag = new JLabel(imageIcon);
        panel.add(diceBag);
    }

    /**
     * Updates the labels for the number of each type of die in the bag.
     */
    public void getNumDice() {
        Map<Integer, Integer> diceCounts = new HashMap<>();
        for (int i = 4; i <= 20; i += 2) {
            if (i == 14 || i == 16 || i == 18) {
                continue;
            }
            diceCounts.put(i, 0);
        }

        for (int i = 0; i < diceBag.getDiceBag().size(); i++) {
            Die die = (Die) diceBag.getDiceBag().get(i);
            int numberOfSides = die.getNumberOfSides();
            if (diceCounts.containsKey(numberOfSides)) {
                diceCounts.put(numberOfSides, diceCounts.get(numberOfSides) + 1);
            }
        }

        for (int i = 4; i <= 20; i += 2) {
            if (i == 14 || i == 16 || i == 18) {
                continue;
            }
            JLabel label = diceCountLabels.get(i);
            if (label == null) {
                label = new JLabel();
                diceCountLabels.put(i, label);
                panel.add(label);
            }
            int count = diceCounts.get(i);
            label.setText("Number of " + i + " sided dice: " + count + "\n");
        }
    }

    /**
     * Creates a new DiceBagGUI object.
     */
    public DiceBagGUI() {
        createButtons();
        getNumDice();
        // set to different layout
        masterPanel.add(panel);
        masterPanel.add(dicePanel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        // create dicebag image
        // this is the lunch bag image i talked with you about in class...
        // enable it if you would like to see it haha
//        createDiceBagImage();


        // set the size of the frame
        frame.setSize(600, 600);
        // set the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add the panel to the frame
        // add the label to the panel
        panel.add(label);
        for (int i = 4; i <= 20; i += 2) {
            if (i == 14 || i == 16 || i == 18) {
                continue;
            }
            JLabel label = diceCountLabels.get(i);
            if (label == null) {
                label = new JLabel();
                diceCountLabels.put(i, label);
                panel.add(label);
            }
        }
        frame.add(masterPanel);
        // set the frame to be visible
        frame.setVisible(true);
    }
}
