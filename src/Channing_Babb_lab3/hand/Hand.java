package Channing_Babb_lab3.hand;

import java.util.ArrayList;

/**
 * Hand class
 * This class holds the functions for the hand function
 */
public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();

    /**
     * Display hand
     * @return
     */
    public String displayHand() {
        System.out.println("Hand size is " + hand.size());
        // string builder instead of += for performance
        StringBuilder handString = new StringBuilder();
        for (Card card : hand) {
            handString.append(card.toString()).append("\n");
        }
        return handString.toString();
    }

    /**
     * Get hand
     * @return
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Add card to hand
     * @param card
     */
    public void addCard(Card card) {
        this.hand.add(card);
    }

    /**
     * Add cards to hand
     * Function works but is not used.
     * @param cards
     */
    public void addCards(ArrayList<Card> cards) {
        this.hand.addAll(cards);
    }
}
