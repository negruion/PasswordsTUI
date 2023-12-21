package passwords;

import java.util.Random;
import java.util.Scanner;

/**
 * The Generator Class generates a password according to specific requirements.
 *
 * @author Ion Negru
 */
public class Generator {

    Alphabet alphabet;
    int size;
    final int DEFAULT_SIZE = 15;
    boolean upperLetters = false, lowerLetters = false, digits = false, symbols = false, customPass=false;

    public Generator(int size, boolean customPass){
        this.size = size;
        this.customPass = customPass;
    }
    public Generator(int size){
        this.size = size;
    }
    public Generator(){
        this.size = DEFAULT_SIZE;
    }
    /**
     *
     * Creates a new string with specific allowed characters, and creates a password with
     * the specific characters.
     * It calls the method buildPassword(), which return the generated password.
     *
     * @return the final generated password
     */
    public String getPassword(Scanner keyboard){

        getPasswordInfo(keyboard);

        alphabet = new Alphabet(upperLetters, lowerLetters, digits, symbols);
        String allowedChars = alphabet.getAllowedChars();

        return buildPassword(allowedChars);
    }

    /**
     *
     * Method to gather information from the user about the wanted password:
     * it asks questions about the size, whether it should contain digits, symbols, letters.
     *
     */
    private void getPasswordInfo(Scanner keyboard){
        if(!customPass){
            upperLetters = lowerLetters = digits = symbols = true;
        } else{
            upperLetters = askYesNoQuestion("Upper letters?", keyboard);
            lowerLetters = askYesNoQuestion("Lower letters?", keyboard);
            digits = askYesNoQuestion("Digits?", keyboard);
            symbols = askYesNoQuestion("Symbols?", keyboard);
            if(!upperLetters && !lowerLetters && !digits && !symbols){
                System.out.println("Password must contain something!");
                getPassword(keyboard);
            }
        }
    }

    /**
     * Gets the answer of the user at the given question.
     * @param question the given question
     * @param keyboard the scanner to get the input
     * @return true if the user types Y/y; false otherwise
     */
    private boolean askYesNoQuestion(String question, Scanner keyboard){
        System.out.print(question + " (Y/n) ");
        return keyboard.nextLine().equalsIgnoreCase("y");
    }

    /**
     *
     * Generates a password based on a given string with all the allowed characters.
     * The method adds a specific number of characters, each determined at random.
     *
     * @param allowedChars a string with all the allowed character by the user
     * @return the newly generated password
     */
    private String buildPassword(String allowedChars){
        StringBuilder password = new StringBuilder();

        // build the password with random characters in the allowed string
        for(int i = 0; i<size; i++){
            int index = (new Random()).nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        Checker checker = new Checker(password.toString());
        Category passCategory = checker.checkPassword();

        // it's not possible to generate something very strong when the user wants a password
        // with a small size and without letters/digits/symbols
        if(!customPass && size >= 12){
            // check if the generated password is good, if not generate it again
            if(passCategory == Category.STRONG || passCategory == Category.VERY_STRONG){
                return password.toString();
            }
            return buildPassword(allowedChars);
        }
        return password.toString();
    }

}
