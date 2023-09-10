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
        // “round” the number to the closet even integer
        number = number / 2;
        this.number = String.valueOf(number);


        return String.valueOf(number);
    }

    public String clear() {
        this.number = "0";
        return this.number;
    }

    // append number to itself
    public String append(String number) {
        if (this.number == "0" && number != "." && number != "0") {
            this.number = number;
            return number;
        } else if (this.number == "0" && number == "0") {
            this.number = "0";
            return this.number;
        }

        if (number == ".") {
            if (this.number.contains(".") == true) {
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
