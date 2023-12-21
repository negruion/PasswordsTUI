package passwords;

/**
 * The Checker Class checks a given password, and decides what type it is:
 * weak, moderate, strong, very_strong.
 *
 * @author Ion Negru
 */
public class Checker {
    double score = 0;
    String password;
    int usedUpperLetters=0, usedLowerLetters=0, usedDigits=0, usedSymbols=0;

    public Checker(String password){
        this.password = password;
    }

    /**
     *
     * Computes the category of a certain password.
     * It first calculates how many letters, digits, symbols the password has. Then calculates the
     * score based on a formula, and depending on the interval of the score, it gets the category.
     *
     * @return the category for the password.
     */
    public Category checkPassword(){
        char[] passwordCharArray = password.toCharArray();

        for(char chr : passwordCharArray){
            // char is uppercase letter
            if ((int) chr >= 65 && (int) chr <= 90) {
                usedUpperLetters += 1;
            }

            // char is lowercase letter
            else if ((int) chr >= 97 && (int) chr <= 122) {
                usedLowerLetters += 1;
            }

            // char is digit
            else if ((int) chr >= 48 && (int) chr <= 57) {
                usedDigits += 1;
            }

            // char is symbol
            else {
                usedSymbols += 1;
            }
        }
        return getCategory();
    }

    /**
     * Calculates the score of a password by a specific formula. <br>
     * Each character has a specific weight: <br>
     * UpperLetters: 0.01 <br>
     * LowerLetters: 0.01 <br>
     * Digits: 0.02 <br>
     * Symbols: 0.03 <br>
     * Length: 0.05 <br>
     */
    public void calculateScore(){
        double passSize = password.length();
        score = 0.01 * (usedUpperLetters / passSize) +
                0.01 * (usedLowerLetters / passSize) +
                0.02 * (usedDigits / passSize) +
                0.03 * (usedSymbols / passSize) +
                0.05 * password.length();
    }


    /**
     *
     * Checks in what interval is the final score.
     *
     * @return the category of the password
     */
    private Category getCategory(){
        calculateScore();
        System.out.println(score);
        if(score >= .9){
            return Category.VERY_STRONG;
        }
        else if(score >= .6){
            return Category.STRONG;
        }
        else if(score >= .4){
            return Category.MODERATE;
        }

        return Category.WEAK;
    }



}
