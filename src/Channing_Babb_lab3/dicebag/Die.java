package Channing_Babb_lab3.dicebag;

/**
 * Die Class
 * This class holds the functions for the die
 */
public class Die {
    private final int DEFAULT_SIDES = 6;
    private int numberOfSides;
    private int face;


    /**
     * Default constructor
     */
    public Die() {
        this.numberOfSides = DEFAULT_SIDES;
    }

    /**
     * Overloaded constructor
     * @param numberOfSides
     */
    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    /**
     * Roll function
     * @return
     */
    public int roll() {
        int rolledDie = (int) (Math.random() * numberOfSides) + 1;
        this.face = rolledDie;
        return rolledDie;
    }

    /**
     * Getter for face
     * @return
     */
    public int getFace() {
        return this.face;
    }

    /**
     * toString override
     * @return
     */
    public String toString() {
        return "Number of sides: " + numberOfSides + "\n";
    }

}
