package Channing_Babb_lab3.hand;

/**
 * Card class
 * This class holds the functions for the card function
 */
public class Card {
    private int suit;
    private int value;

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getValue() {
        switch (this.value) {
            case 1:
                return "The Ace";
            case 11:
                return "The Jack";
            case 12:
                return "The Queen";
            case 13:
                return "The King";
            default:
                return String.valueOf(this.value);
        }
    }

    public String getSuit() {
        // breaks will not be needed since I will just be returning the string directly.
        switch (this.suit) {
            case 0:
                return "Spades";
            case 1:
                return "Hearts";
            case 2:
                return "Clubs";
            case 3:
                return "Diamonds";
            default:
                return "Invalid suit";
        }

    }

    public String getImage() {
        String suit = this.getSuit().toLowerCase();
        String value = this.getValue().toLowerCase();
        if (value.contains(" ")) {
            value = value.split(" ")[1]; // get everything after space

        }
        return "src/Channing_Babb_lab3/hand/cards/"+value+"_of_"+suit+".png";
    }


    public String toString() {
//        System.out.println(this.value + " of " + this.getSuit());
        return (this.getValue() + " of " + this.getSuit());
    }
}
