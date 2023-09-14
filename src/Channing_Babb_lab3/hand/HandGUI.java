package Channing_Babb_lab3.hand;
// https://code.google.com/archive/p/vector-playing-cards/
// these are being used for the deck

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class HandGUI {
    Hand hand = new Hand();
    Deck deck = new Deck();

    // create a JFrame
    static JFrame frame = new JFrame("Hand GUI");
    // create a JPanel
    static JPanel panel = new JPanel();
    static JPanel cardPanel = new JPanel();

    public void createButtons() {
        // create new button to shuffle the deck
        JButton shuffleButton = new JButton("Shuffle");
        // add the button to the panel
        panel.add(shuffleButton);
        // add an action listener to the button
        shuffleButton.addActionListener(e -> {
            // shuffle the deck
            this.deck.shuffle();
        });


        // create new button to deal cards to the hand
        JButton dealButton = new JButton("Deal");
        // add the button to the panel
        panel.add(dealButton);
        // add an action listener to the button
        dealButton.addActionListener(e -> {
            // deal 5 cards to the hand
            Card[] cards = this.deck.deal(13);
            // create new arraylist and add all the cards to the arraylist
            // just proving that it can be done
            ArrayList<Card> cardsList = new ArrayList<Card>();
            Collections.addAll(cardsList, cards);
            this.hand.addCards(cardsList);
            // loop through hand and display image for each card
            for (Card card : hand.getHand()) {
                System.out.println(card.getImage());
                // create a new image icon
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(card.getImage()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                // create a new label
                JLabel label = new JLabel();
                // set the label to the image icon
                label.setIcon(imageIcon);
                // add the label to the panel
                cardPanel.add(label);
            }
        });

    }

    // display the GUI
    public HandGUI() {
        // add the panel to the frame
        frame.add(panel);
        createButtons();
        // set the layout of the panel
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.X_AXIS));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // set the size of the frame
        frame.setSize(600, 600);
        // set the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the frame to be visible
        frame.setVisible(true);


    }
}