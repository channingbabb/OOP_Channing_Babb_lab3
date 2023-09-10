package Channing_Babb_lab3.register;

/**
 * Purse Class
 * This class holds the function for the purse function
 */
public class Purse {
    private int pennies, nickels, dimes, fiftyCents, ones, fives, tens, twenties, hundreds;

    /**
     * Default constructor
     */
    public Purse() {
        this.pennies = 0;
        this.nickels = 0;
        this.dimes = 0;
        this.fiftyCents = 0;
        this.ones = 0;
        this.fives = 0;
        this.tens = 0;
        this.twenties = 0;
        this.hundreds = 0;
    }

    /**
     * Constructor w/ params
     * @param pennies
     * @param nickels
     * @param dimes
     * @param fiftyCents
     * @param ones
     * @param fives
     * @param tens
     * @param twenties
     * @param hundreds
     */
    public Purse(int pennies, int nickels, int dimes, int fiftyCents, int ones, int fives, int tens, int twenties, int hundreds) {
        this.pennies = pennies;
        this.nickels = nickels;
        this.dimes = dimes;
        this.fiftyCents = fiftyCents;
        this.ones = ones;
        this.fives = fives;
        this.tens = tens;
        this.twenties = twenties;
        this.hundreds = hundreds;
    }

    /**
     * Getter for pennies
     * @return pennies
     */
    public int getPennies() {
        return pennies;
    }

    /**
     * Setter for pennies
     * @param pennies
     */
    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    /**
     * Getter for nickels
     * @return nickels
     */
    public int getNickels() {
        return nickels;
    }

    /**
     * Setter for nickels
     * @param nickels
     */
    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    /**
     * Getter for dimes
     * @return dimes
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * Setter for dimes
     * @param dimes
     */
    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    /**
     * Getter for fifty cent pieces
     * @return fiftyCents
     */
    public int getFiftyCents() {
        return fiftyCents;
    }

    /**
     * Setter for fifty cent pieces
     * @param fiftyCents
     */
    public void setFiftyCents(int fiftyCents) {
        this.fiftyCents = fiftyCents;
    }

    /**
     * Getter for one dollar bills
     * @return dollars
     */
    public int getOnes() {
        return ones;
    }

    /**
     * Getter for one dollar bills
     * @param ones
     */
    public void setOnes(int ones) {
        this.ones = ones;
    }

    /**
     * Getter for five dollar bills
     * @return fives
     */
    public int getFives() {
        return fives;
    }

    /**
     * Setter for five dollar bills
     * @param fives
     */
    public void setFives(int fives) {
        this.fives = fives;
    }

    /**
     * Getter for ten dollar bills
     * @return tens
     */
    public int getTens() {
        return tens;
    }

    /**
     * Setter for ten dollar bills
     * @param tens
     */
    public void setTens(int tens) {
        this.tens = tens;
    }

    /**
     * Getter for twenty dollar bills
     * @return twenties
     */
    public int getTwenties() {
        return twenties;
    }

    /**
     * Setter for twenty dollar bills
     * @param twenties
     */
    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    /**
     * Getter for hundred dollar bills
     * @return hundreds
     */
    public int getHundreds() {
        return hundreds;
    }

    /**
     * Setter for hundred dollar bills
     * @param hundreds
     */
    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    /**
     * cashTotal function
     * @return int
     * This function returns the total amount of money the purse is holding (int)
     */
    public double cashTotal() {
        return  (this.getPennies() *    Currency.PENNY.getValue()) +
                (this.getNickels() *    Currency.NICKEL.getValue()) +
                (this.getDimes() *      Currency.DIME.getValue()) +
                (this.getFiftyCents() * Currency.FIFTY_CENT.getValue()) +
                (this.getOnes() *       Currency.ONE.getValue()) +
                (this.getFives() *      Currency.FIVE.getValue()) +
                (this.getTens() *       Currency.TEN.getValue()) +
                (this.getTwenties() *   Currency.TWENTY.getValue()) +
                (this.getHundreds() *   Currency.ONE_HUNDRED.getValue());

    }
}
