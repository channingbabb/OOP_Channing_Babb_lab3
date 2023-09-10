package Channing_Babb_lab3.register;

/**
 * Register Class
 */
public class Register {


    // default quantities
    private final int PENNY_QUANTITY = 20;
    private final int NICKEL_QUANTITY = 20;
    private final int DIME_QUANTITY = 20;
    private final int FIFTY_CENT_QUANTITY = 10;
    private final int ONES_QUANTITY = 20;
    private final int FIVES_QUANTITY = 20;
    private final int TENS_QUANTITY = 20;
    private final int TWENTIES_QUANTITY = 10;
    private final int HUNDREDS_QUANTITY = 0;

    private int[] currency = new int[9]; // 0 means 100s, 1 means 20s
    private double[] currencyValues = new double[9]; // 0 means 100s, 1 means 20s

    /**
     * Constructor
     */
    public Register() {
        currencyValues[0] = Currency.ONE_HUNDRED.getValue();
        currencyValues[1] = Currency.TWENTY.getValue();
        currencyValues[2] = Currency.TEN.getValue();
        currencyValues[3] = Currency.FIVE.getValue();
        currencyValues[4] = Currency.ONE.getValue();
        currencyValues[5] = Currency.FIFTY_CENT.getValue();
        currencyValues[6] = Currency.DIME.getValue();
        currencyValues[7] = Currency.NICKEL.getValue();
        currencyValues[8] = Currency.PENNY.getValue();
    }


    /**
     * Get the amount needed by dividing the monetary value by the amount, casting (int)
     *
     * @param monetaryValue The amount of money remaining
     * @param amount        The quantity of the money type
     * @return int
     */
    public static int getAmountNeeded(double monetaryValue, double amount) {
        // cannot surpass max quantity
        return (int) (monetaryValue / amount);
    }

    /**
     * Get the remainder of the monetary value by using the modulus divisor
     *
     * @param monetaryValue The amount of money remaining
     * @param amount        The quantity of the money type
     * @return double
     */
    public static double getRemainder(double monetaryValue, double amount) {
        return monetaryValue % amount;
    }


    /**
     * Restock function
     * This function restocks the register with the default values
     */
    public double restock() {
        double total = 0;
        // (quantity - quantity_in_hand) * value which will return the $$$ cash money cash
        total += (PENNY_QUANTITY - currency[8]) * Currency.PENNY.getValue();
        total += (NICKEL_QUANTITY - currency[7]) * Currency.NICKEL.getValue();
        total += (DIME_QUANTITY - currency[6]) * Currency.DIME.getValue();
        total += (FIFTY_CENT_QUANTITY - currency[5]) * Currency.FIFTY_CENT.getValue();
        total += (ONES_QUANTITY - currency[4]) * Currency.ONE.getValue();
        total += (FIVES_QUANTITY - currency[3]) * Currency.FIVE.getValue();
        total += (TENS_QUANTITY - currency[2]) * Currency.TEN.getValue();
        total += (TWENTIES_QUANTITY - currency[1]) * Currency.TWENTY.getValue();
        total += (HUNDREDS_QUANTITY - currency[0]) * Currency.ONE_HUNDRED.getValue();

        // revert to original state
        currency[8] = PENNY_QUANTITY;
        currency[7] = NICKEL_QUANTITY;
        currency[6] = DIME_QUANTITY;
        currency[5] = FIFTY_CENT_QUANTITY;
        currency[4] = ONES_QUANTITY;
        currency[3] = FIVES_QUANTITY;
        currency[2] = TENS_QUANTITY;
        currency[1] = TWENTIES_QUANTITY;
        currency[0] = HUNDREDS_QUANTITY;

        return total;

    }

    /**
     * Purse makeChange
     * This function takes a Purse and a double representing the price of an item and returns the Purse with change for the purchase.
     */
    public Purse makeChange(Purse cashIn, double price) {
        Purse change = new Purse();

        // if the cashIn.cashTotal() is less than price, return the original Purse and make no changes
        if (cashIn.cashTotal() < price) {
            return cashIn;
        }

        // put the money from the purse into the register
        currency[0] += cashIn.getHundreds();
        currency[1] += cashIn.getTwenties();
        currency[2] += cashIn.getTens();
        currency[3] += cashIn.getFives();
        currency[4] += cashIn.getOnes();
        currency[5] += cashIn.getFiftyCents();
        currency[6] += cashIn.getDimes();
        currency[7] += cashIn.getNickels();
        currency[8] += cashIn.getPennies();

        // find the change needed
        double changeTotalValue = cashIn.cashTotal() - price;

        System.out.println("Change needed: " + changeTotalValue);

        int[] changeValues = new int[9];

        // subtract that from the register
        for (int amountNeededIteration = 0; amountNeededIteration < currencyValues.length; amountNeededIteration++) {
            int amountNeeded = getAmountNeeded(changeTotalValue, currencyValues[amountNeededIteration]);
            double remainder = getRemainder(changeTotalValue, currencyValues[amountNeededIteration]);
            changeValues[amountNeededIteration] = amountNeeded;
            changeTotalValue = remainder;

            System.out.println("Amount needed for "+amountNeededIteration+": " + amountNeeded);
        }

        // give the change to the client
        change.setHundreds(changeValues[0]);
        change.setTwenties(changeValues[1]);
        change.setTens(changeValues[2]);
        change.setFives(changeValues[3]);
        change.setOnes(changeValues[4]);
        change.setFiftyCents(changeValues[5]);
        change.setDimes(changeValues[6]);
        change.setNickels(changeValues[7]);
        change.setPennies(changeValues[8]);

        for (int changeValueIndex = 0; changeValueIndex < changeValues.length; changeValueIndex++) {
            currency[changeValueIndex] -= changeValues[changeValueIndex];
        }

        // return the change
        return change;

    }

    /**
     * Empty function
     * double empty () which sets all the currency in the register to zero and returns the amount that was in the register.
     */
    public double empty() {
        double total = 0;
        // set all the currency in the register to zero
        total += (PENNY_QUANTITY - currency[8]) * Currency.PENNY.getValue();
        total += (NICKEL_QUANTITY - currency[7]) * Currency.NICKEL.getValue();
        total += (DIME_QUANTITY - currency[6]) * Currency.DIME.getValue();
        total += (FIFTY_CENT_QUANTITY - currency[5]) * Currency.FIFTY_CENT.getValue();
        total += (ONES_QUANTITY - currency[4]) * Currency.ONE.getValue();
        total += (FIVES_QUANTITY - currency[3]) * Currency.FIVE.getValue();
        total += (TENS_QUANTITY - currency[2]) * Currency.TEN.getValue();
        total += (TWENTIES_QUANTITY - currency[1]) * Currency.TWENTY.getValue();
        total += (HUNDREDS_QUANTITY - currency[0]) * Currency.ONE_HUNDRED.getValue();

        // revert to original state
        currency[8] = 0;
        currency[7] = 0;
        currency[6] = 0;
        currency[5] = 0;
        currency[4] = 0;
        currency[3] = 0;
        currency[2] = 0;
        currency[1] = 0;
        currency[0] = 0;

        // return the amount that was in the register
        return total;

    }

}