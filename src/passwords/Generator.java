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
    String response;
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
        size = DEFAULT_SIZE;
    }
    /**
     *
     * Creates a new string with specific allowed characters, and creates a password with
     * the specific characters.
     * It calls the method buildPassword(), which return the generated password.
     *
     * @return the final generated password
     */
    public String getPassword(){

        getPasswordInfo();

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
    private void getPasswordInfo(){
        Scanner keyboard = new Scanner(System.in);
        if(!customPass){
            upperLetters = lowerLetters = digits = symbols = true;
        } else{
            System.out.print("All types of characters? (Y/n) ");
            response = keyboard.nextLine();

            if(response.equals("y") || response.equals("Y")){
                upperLetters = lowerLetters = digits = symbols = true;
            }else{
                System.out.print("Upper letters? (Y/n) ");
                response = keyboard.nextLine();
                if(response.equals("y") || response.equals("Y")){
                    upperLetters = true;
                }

                System.out.print("Lower letters? (Y/n) ");
                response = keyboard.nextLine();
                if(response.equals("y") || response.equals("Y")){
                    lowerLetters = true;
                }

                System.out.print("Digits? (Y/n) ");
                response = keyboard.nextLine();
                if(response.equals("y") || response.equals("Y")){
                    digits = true;
                }

                System.out.print("Symbols? (Y/n) ");
                response = keyboard.nextLine();
                if(response.equals("y") || response.equals("Y")){
                    symbols = true;
                }
            }
        }



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

        for(int i = 0; i<size; i++){
            int index = (new Random()).nextInt(allowedChars.length() + 1);

            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }

}
