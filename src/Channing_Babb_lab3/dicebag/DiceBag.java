package Channing_Babb_lab3.dicebag;

import java.util.ArrayList;

/**
 * DiceBag Class
 * This class holds the functionss for the dicebag
 */
public class DiceBag {

    // diceBag arrayList
    ArrayList<Object> diceBag = new ArrayList<Object>();


    /**
     * Default constructor
     */
    public DiceBag() {
    }

    /**
     * Add a die to the bag
     *
     * @param die
     */
    public void addDie(Channing_Babb_lab3.dicebag.Die die) {
        this.diceBag.add(die);
    }

    /**
     * Roll fours
     *
     * @param numberOfDice
     * @return
     */
    public String rollFours(int numberOfDice) {
        int sumOfDice = 0;
        int shownIteration;
        Channing_Babb_lab3.dicebag.Die die;

        System.out.println("Rolling fours...");

        for (int dieIterator = 0; dieIterator < numberOfDice; dieIterator++) {
            die = new Channing_Babb_lab3.dicebag.Die(4);
            addDie(die);
            die.roll();
            sumOfDice += die.getFace();
            shownIteration = (dieIterator + 1);
            System.out.println("Die " + shownIteration + ": " + die.getFace());
        }

        return "Sum of dice: " + sumOfDice + "\n";
    }

    /**
     * Roll sixes
     *
     * @param numberOfDice
     * @return
     */
    public String rollSixes(int numberOfDice) {
        int sumOfDice = 0;
        int shownIteration;
        Channing_Babb_lab3.dicebag.Die die;

        System.out.println("Rolling sixes...");

        for (int dieIterator = 0; dieIterator < numberOfDice; dieIterator++) {
            die = new Channing_Babb_lab3.dicebag.Die(6);
            addDie(die);
            die.roll();
            sumOfDice += die.getFace();
            shownIteration = (dieIterator + 1);
            System.out.println("Die " + shownIteration + ": " + die.getFace());
        }

        return "Sum of dice: " + sumOfDice + "\n";

    }

    /**
     * Roll eights
     *
     * @param numberOfDice
     * @return
     */
    public String rollEights(int numberOfDice) {
        int sumOfDice = 0;
        int shownIteration;
        Channing_Babb_lab3.dicebag.Die die;

        System.out.println("Rolling eights...");

        for (int dieIterator = 0; dieIterator < numberOfDice; dieIterator++) {
            die = new Channing_Babb_lab3.dicebag.Die(8);
            addDie(die);
            die.roll();
            sumOfDice += die.getFace();
            shownIteration = (dieIterator + 1);
            System.out.println("Die " + shownIteration + ": " + die.getFace());
        }

        return "Sum of dice: " + sumOfDice + "\n";
    }

    /**
     * Roll tens
     *
     * @param numberOfDice
     * @return
     */
    public String rollTens(int numberOfDice) {
        int sumOfDice = 0;
        int shownIteration;
        Channing_Babb_lab3.dicebag.Die die;

        System.out.println("Rolling tens...");

        for (int dieIterator = 0; dieIterator < numberOfDice; dieIterator++) {
            die = new Channing_Babb_lab3.dicebag.Die(10);
            addDie(die);
            die.roll();
            sumOfDice += die.getFace();
            shownIteration = (dieIterator + 1);
            System.out.println("Die " + shownIteration + ": " + die.getFace());
        }

        return "Sum of dice: " + sumOfDice + "\n";

    }

    /**
     * Roll tens
     *
     * @param numberOfDice
     * @return
     */
    public String rollTwelves(int numberOfDice) {
        int sumOfDice = 0;
        int shownIteration;
        Channing_Babb_lab3.dicebag.Die die;

        System.out.println("Rolling twelves...");

        for (int dieIterator = 0; dieIterator < numberOfDice; dieIterator++) {
            die = new Channing_Babb_lab3.dicebag.Die(12);
            addDie(die);
            die.roll();
            sumOfDice += die.getFace();
            shownIteration = (dieIterator + 1);
            System.out.println("Die " + shownIteration + ": " + die.getFace());
        }

        return "Sum of dice: " + sumOfDice + "\n";

    }

    /**
     * Roll twenties
     *
     * @param numberOfDice
     * @return
     */
    public String rollTwenties(int numberOfDice) {
        int sumOfDice = 0;
        int shownIteration;
        Channing_Babb_lab3.dicebag.Die die;

        System.out.println("Rolling twenties...");

        for (int dieIterator = 0; dieIterator < numberOfDice; dieIterator++) {
            die = new Channing_Babb_lab3.dicebag.Die(20);
            addDie(die);
            die.roll();
            sumOfDice += die.getFace();
            shownIteration = (dieIterator + 1);
            System.out.println("Die " + shownIteration + ": " + die.getFace());
        }

        return "Sum of dice: " + sumOfDice + "\n";

    }

    /**
     * Armageddon function
     * This function rolls all of the dice in the bag
     */
    public int armageddon() {
        int sumOfDice = 0;
        int shownIteration;
        Channing_Babb_lab3.dicebag.Die die;

        System.out.println("Rolling armageddon...");

        for (int dieIterator = 0; dieIterator < this.diceBag.size(); dieIterator++) {
            die = (Channing_Babb_lab3.dicebag.Die) this.diceBag.get(dieIterator);
            die.roll();
            sumOfDice += die.getFace();
            shownIteration = (dieIterator + 1);
            System.out.println("Die " + shownIteration + ": " + ((Channing_Babb_lab3.dicebag.Die) this.diceBag.get(dieIterator)).getFace());
        }
        return sumOfDice;
    }

}
