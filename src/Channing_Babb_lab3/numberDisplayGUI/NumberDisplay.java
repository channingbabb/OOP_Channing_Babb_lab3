package Channing_Babb_lab3.numberDisplayGUI;

/**
 * NumberDisplay.java
 * logic for the NumberDisplayGUI.java
 */
public class NumberDisplay {
    String number = "0";

    /**
     * NumberDisplay
     * constructor for the NumberDisplay class
     */
    public NumberDisplay() {

    }

    /**
     * evener
     * if the number is odd, add 1
     * @return
     */
    public String evener() {
        double number = Double.parseDouble(this.number);
        if (number % 2 != 0) {
            number = number + 1;
        }
        // find the closest even integer
        number = Math.round(number);

        // if only 0 after the decimal, convert to int
        if (number % 1 == 0) {
            int numberInt = (int) number;
            this.number = String.valueOf(numberInt);
            return String.valueOf(numberInt);
        }

        // convert the number to a string
        this.number = String.valueOf(number);
        // return the number
        return String.valueOf(number);
    }

    /**
     * clear
     * sets the number to 0
     * @return
     */
    public String clear() {
        this.number = "0";
        return this.number;
    }

    /**
     * append
     * @param number
     * @return
     */
    public String append(String number) {
        // if the number is 0, replace it with the new number
        if (this.number.equals("0")) {
            if (number.equals(".")) { // if the number is a decimal
                this.number = "0."; // set to 0. (we don't want 0.00.00, etc.)
            } else {
                this.number = number; // else set to the new number
            }
        } else if (number.equals(".")) { // if the number is a decimal
            if (this.number.contains(".")) { // if the number already contains a decimal
                return this.number; // return the number
            } else {
                this.number += "."; // else, add the decimal
            }
        } else {
            this.number += number; // if all else, add the number
        }
        return this.number; // return
    }
}
