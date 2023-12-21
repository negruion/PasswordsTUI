package passwords;

public class Alphabet {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    StringBuilder allowedChars;

    public Alphabet(boolean upperLetters, boolean lowerLetters, boolean digits, boolean symbols){

        allowedChars = new StringBuilder();

        if(upperLetters) allowedChars.append(UPPERCASE_LETTERS);

        if(lowerLetters) allowedChars.append(LOWERCASE_LETTERS);

        if(digits) allowedChars.append(DIGITS);

        if(symbols) allowedChars.append(SYMBOLS);

    }

    public String getAllowedChars(){
        return this.allowedChars.toString();
    }

}
