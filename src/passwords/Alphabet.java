package passwords;

/**
 * The Alphabet Class creates a string with all the allowed characters to be used in the password
 * generation process.
 *
 * @author Ion Negru
 */
public class Alphabet {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    StringBuilder allowedChars;

    public Alphabet(boolean upperLetters, boolean lowerLetters, boolean digits, boolean symbols){

        allowedChars = new StringBuilder();

        if(upperLetters) {
            allowedChars.append(UPPERCASE_LETTERS);
        }

        if(lowerLetters) {
            allowedChars.append(LOWERCASE_LETTERS);
        }

        if(digits) {
            allowedChars.append(DIGITS);
        }

        if(symbols) {
            allowedChars.append(SYMBOLS);
        }

    }

    /**
     *
     * Gets the allowedChars StringBuilder and returns it as a string.
     *
     * @return a string with all allowed characters
     */
    public String getAllowedChars(){
        // it cannot return the string if it's not initialized
        assert this.allowedChars != null;

        return this.allowedChars.toString();
    }

}
