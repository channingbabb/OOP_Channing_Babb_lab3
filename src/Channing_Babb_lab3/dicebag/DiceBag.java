package Channing_Babb_lab3.dicebag;

import java.util.ArrayList;

/**
 * DiceBag Class
 * This class holds the functions for the dicebag
 */
public class DiceBag {

    // diceBag arrayList
    ArrayList<Die> diceBag = new ArrayList<>();

    /**
     * Default constructor
     */
    public DiceBag() {
    }

    /**
     * Add a die to the bag
     *
     * @param die the die to add
     */
    public void addDie(Die die) {
        this.diceBag.add(die);
    }

    /**
     * Get the dice bag
     *
     * @return the dice bag
     */
    public ArrayList<Die> getDiceBag() {
        return this.diceBag;
    }

    /**
     * Roll the specified number of dice
     *
     * @param numberOfDice the number of dice to roll
     * @param die          the type of die to roll
     * @return the sum of the dice rolls
     * moved away from having multiple functions
     */
    public int rollDice(int numberOfDice, Die die) {
        int sumOfDice = 0;


        for (int dieIterator = 0; dieIterator < numberOfDice; dieIterator++) {
            die.roll();
            sumOfDice += die.getFace();

            // add the die to the dice bag
            this.diceBag.add(die);

        }

        return sumOfDice;
    }

    /**
     * Roll all the dice in the bag
     *
     * @return the sum of the dice rolls
     */
    public int armageddon() {
        int sumOfDice = 0;


        for (int dieIterator = 0; dieIterator < this.diceBag.size(); dieIterator++) {
            Die die = this.diceBag.get(dieIterator);
            die.roll();
            sumOfDice += die.getFace();
            int shownIteration = (dieIterator + 1);
        }

        return sumOfDice;
    }

}
