package Channing_Babb_lab3.register;

/**
 * Currency Enum
 * This enum holds the different types of currency, their values, and their labels (singular and plural).
 */
public enum Currency {

    // set up the different types of currency
    ONE_HUNDRED(100, "one hundred dollar bill", "one hundred dollar bills"),
    TWENTY(20, "twenty dollar bill", "twenty dollar bills"),
    TEN(10, "ten dollar bill", "ten dollar bills"),
    FIVE(5, "five dollar bill", "five dollar bills"),
    ONE(1, "one dollar bill", "one dollar bills"),
    FIFTY_CENT(0.5, "fifty cent piece", "fifty cent pieces"),
    DIME(0.1, "dime", "dimes"),
    NICKEL(0.05, "nickel", "nickels"),
    PENNY(0.01, "penny", "pennies");

    private final double value;
    private final String singularLabel;
    private final String pluralLabel;

    /**
     * Currency Constructor
     * This constructor sets up the currency enum with the value, singular label, and plural label.
     * @param value
     * @param singularLabel
     * @param pluralLabel
     */
    Currency(double value, String singularLabel, String pluralLabel) {
        this.value = value;
        this.singularLabel = singularLabel;
        this.pluralLabel = pluralLabel;
    }

    /**
     * Getter for value of currency
     * @return value
     */
    public double getValue() {
        return value;
    }

    /**
     * Getter for singular label of currency
     * @return singularLabel
     */
    public String getSingularLabel() {
        return singularLabel;
    }

    /**
     * Getter for plural label of currency
     * @return pluralLabel
     */
    public String getPluralLabel() {
        return pluralLabel;
    }

    /**
     * toString override
     * This override returns the singular label and value of the currency.
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s (%s)", singularLabel, value);
    }

}
