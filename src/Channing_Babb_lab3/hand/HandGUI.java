package Channing_Babb_lab3.hand;
// https://opengameart.org/sites/default/files/Playing%20Cards.zip
// these are being used for the deck
// shared them with the class so expect to see them reused, it was difficult finding it.

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

/**
 * HandGUI
 */
public class HandGUI {
    Hand hand = new Hand();
    Deck deck = new Deck();

    // create a JFrame
    static JFrame frame = new JFrame("Hand GUI");
    // create a JPanel
    static JPanel panel = new JPanel();
    static JPanel cardPanel = new JPanel();
    static JPanel masterPanel = new JPanel();
    static CardGUI[] images = new CardGUI[14];


    /**
     * createButtons
     * This function creates the buttons for the GUI
     */
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
            // deal cards to the hand
            this.hand.resetHand();
            for (int i = 0; i < images.length; i++) {
                cardPanel.remove(images[i]);
            }
            Card[] cards = this.deck.deal(14);
            ArrayList<Card> cardsList = new ArrayList<Card>();
            Collections.addAll(cardsList, cards);
            this.hand.addCards(cardsList);
            // loop through hand and display image for each card
            int i = 0;
            for (Card card : hand.getHand()) {
                images[i] = new CardGUI(card);
                cardPanel.add(images[i]);
                i++;
            }
            cardPanel.repaint(); // repaint the panel
            frame.pack(); // resize the frame to fit all the components
        });

        // reset deck button
        JButton resetButton = new JButton("Reset Deck");
        // add the button to the panel
        panel.add(resetButton);
        // add an action listener to the button
        resetButton.addActionListener(e -> {
            // reset the deck
            this.deck.renewDeck();
            this.hand.resetHand();
            for (int i = 0; i < images.length; i++) {
                // fix to visually remove
                images[i].setIcon(new ImageIcon());
                cardPanel.remove(images[i]);
            }
        });


    }

    /**
     * HandGUI
     * This is the constructor for the HandGUI class
     */
    public HandGUI() {
        // instantiate the images array
        for (int i = 0; i < images.length; i++) {
            images[i] = new CardGUI(new Card(0, 0));
//            cardPanel.add(images[i]);
        }

        // set the layout of the panel
        cardPanel.setLayout(new GridLayout(2, 7));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // add the panel to the frame
        masterPanel.add(panel);
        masterPanel.add(cardPanel);
        frame.add(masterPanel);
        createButtons();

        // set the size of the frame
        frame.setSize(600, 600);
        // set the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the frame to be visible
        frame.setVisible(true);


    }
}