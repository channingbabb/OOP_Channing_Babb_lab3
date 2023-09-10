package Channing_Babb_lab3.hand;

/**
 * Deck Class
 * This class holds the function for the deck function
 */
public class Deck {
    private final int AMOUNT_OF_SUITS = 3;
    private final int AMOUNT_OF_FACES = 13;

    private Card[] deck;
    private Card[] originalDeck;

    /**
     * Deck Constructor
     */
    public Deck() {
        deck = new Card[52];
        originalDeck = new Card[52];
        int cardCount = 0;
        // suit will be stringified in the Card class
        for (int suit = 0; suit <= AMOUNT_OF_SUITS; suit++) {
            for (int value = 1; value <= AMOUNT_OF_FACES; value++) { // starting at one because we don't want a 0 of Clubs, etc.
                deck[cardCount] = new Card(suit, value);
                originalDeck[cardCount] = new Card(suit, value);
                cardCount++;
            }
        }
    }

    /**
     * Shuffle Function
     * This function shuffles the deck.
     */
    public void shuffle() {
        for (int shuffleIteration = deck.length - 1; shuffleIteration > 0; shuffleIteration--) {
            int rand = (int) (Math.random() * (shuffleIteration + 1));
            Card temp = deck[shuffleIteration];
            deck[shuffleIteration] = deck[rand];
            deck[rand] = temp;
        }
    }

    /**
     * deckContains
     * Check if the deck still contains a certain card.
     * @param hand
     * @param card
     */
    public boolean handContains(Card[] hand, Card card) {
        if (hand.length == 0) { // if 0, move on
            return false;
        }

        // check if the card is in the hand
        for (Card handCard : hand) {
            if (handCard == null) { // if null, move on
                continue; // only adding continue so that it's more readable; aware that it's unnecessary.
            } else if ((handCard.getSuit().equals(card.getSuit())) && (handCard.getValue().equals(card.getValue()))) { // if the card is found, return true
                return true;
            }
        }
        return false; // if the card is not found, return false
    }

    /**
     * dealCard
     * This function draws a single (random) card from the deck.
     * @return
     */
    public Card draw() {
        int rand;
        rand = (int) (Math.random() * this.deck.length); // random number between 0 and 51
        return this.deck[rand];
    }


    /**
     * deal
     * This function deals a certain number of (random) cards from the deck.
     * @param numberOfCards
     * @return
     */
    public Card[] deal(int numberOfCards) {
        Card[] hand = new Card[numberOfCards];
        Card tempCard;
        for (int dealIteration = 0; dealIteration < numberOfCards; dealIteration++) {
            do {
                tempCard = draw();
                // hand contains tempCard
            } while (handContains(hand, tempCard));
            hand[dealIteration] = draw();
        }
        return hand;
    }

    /**
     * renewDeck
     * Brings the deck back to its initial state (before any cards have been dealt).
     */
    public void renewDeck() {
        deck = originalDeck;
    }

    /**
     * toString override
     * @return
     */
    public String toString() {
        StringBuilder deckString = new StringBuilder();
        // enhanced for loop
        for (Card card : deck) {
            deckString.append(card.toString()).append("\n");
        }
        return deckString.toString();
    }
}
