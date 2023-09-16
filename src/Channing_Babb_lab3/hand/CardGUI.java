package Channing_Babb_lab3.hand;

import Channing_Babb_lab3.hand.Card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
// bit of polymorphism here

/**
 * CardGUI
 */
public class CardGUI extends JLabel {
    private Card card;

    //  the width and height of the card
    private int width = 100;
    private int height = 100;

    /**
     * CardGUI constructor
     * @param card
     */
    public CardGUI(Card card) {
        this.card = card;
        // create a new image icon
        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(card.getImage()).getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        // set the label to the image icon
        this.setIcon(imageIcon);
    }

    /**
     * getCard
     * Getter for the card
     * @return
     */
    public Card getCard() {
        return this.card;
    }

    /**
     * setWidth
     * Setter for the width
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * getWidth
     * Getter for the width
     * @return
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * setHeight
     * Setter for the height
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * getHeight
     * Getter for the height
     * @return
     */
    public int getHeight() {
        return this.height;
    }

}
