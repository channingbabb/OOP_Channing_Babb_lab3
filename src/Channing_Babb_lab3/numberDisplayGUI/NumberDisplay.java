package Channing_Babb_lab3.numberDisplayGUI;

public class NumberDisplay {
    String number = "0";

    public NumberDisplay() {

    }

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

    public String clear() {
        this.number = "0";
        return this.number;
    }

    // append number to itself
    public String append(String number) {
        if (this.number.trim().equals("0") && number.trim().equals("0")) {
            return this.number;
        } else if (this.number.trim().equals("0") && !number.trim().equals("0") && !number.equals(".")) {
            this.number = number;
            return this.number;
        } else if (this.number.equals("0") && number.equals(".")) {
            this.number = "0.";
            return this.number;
        } else if (number.equals(".")) {
            if (this.number.contains(".")) {
                return this.number;
            } else {
                String numberString = this.number;
                numberString += number;
                this.number = numberString;
                return numberString;
            }
        }

        // append number to itself
        this.number += number;
        // return this.number
        return this.number;
    }
}
