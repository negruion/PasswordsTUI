import java.util.Scanner;
import passwords.Category;
import passwords.Checker;
import passwords.Generator;

/**
 * The Main Class creates the TUI.
 *
 * @author Ion Negru
 */
public class App {

    private String command, parameter;
    private String[] line;
    private int lineSize;
    private boolean quit = false;
    private Scanner keyboard;

    public static void main(String[] args) {
        App passwordsTUI = new App();
        passwordsTUI.run();
    }

    /** Runs the PasswordsTUI. */
    public void run(){
        showStartTUI();

        keyboard = new Scanner(System.in);

        while(!quit){
            getChoice();

            switch (command){
                case "generate" -> generate();
                case "check" -> check();
                case "help" -> showCommands();
                case "quit" -> quit();
                default -> defaultCase();
            }
        }
    }

    /** Shows the available commands for the TUI. */
    public void showCommands(){
        String commands =
                """
                
                generate            - generates a password with 15 chars
                generate <n>        - generates a password with n chars
                generate <n> -c     - generates a custom password with personal criteria
                check <password>    - checks the given password
                help                - display all the commands
                exit                - quits the PasswordsTUI
                
                """;
        System.out.print(commands);
    }

    /** Shows the welcome message and the available commands for the TUI. */
    public void showStartTUI(){
        System.out.println("Welcome to PasswordsTUI!");
        showCommands();
    }

    private void getChoice(){
        System.out.print("Choice: ");

        line = keyboard.nextLine().split("\\s+");
        command = line[0].toLowerCase();
        lineSize = line.length;
    }

    /** Displays the newly generated password. */
    private void generate(){
        Generator generator;
        if(lineSize==2 || lineSize == 3){
            parameter = line[1];
            generator =  new Generator(Integer.parseInt(parameter), lineSize==3);
        } else{
            generator = new Generator();
        }

        System.out.println("Generated Password: " + generator.getPassword());
    }

    /** Checks the given password and displays a message with the category of the password. */
    private void check(){
        Checker checker;
        if(line.length != 2){
            System.out.println("Invalid input! Expected a parameter after \"check\".");
            return;
        }
        parameter = line[1];
        checker = new Checker(parameter);
        displayPasswordCategory(checker.checkPassword());

    }

    /**
     * Displays to the user a message specific to the category of the password.
     *
     * @param category the computed category of the given password by the user
     */
    private void displayPasswordCategory(Category category){
        switch (category){
            case WEAK -> System.out.println("Password is weak!");
            case MODERATE -> System.out.println("Password is moderate!");
            case STRONG -> System.out.println("Password is strong!");
            case VERY_STRONG -> System.out.println("Password is very strong!");
        }
    }

    /** Quits the TUI. It first displays a message to the user, then breaks out of the loop. */
    private void quit(){
        System.out.println("Quitting the TUI...");
        quit = true;
    }

    /** Displays a message to the terminal to warn the user about the encountered error. */
    private void defaultCase(){
        System.out.println("You've entered an unknown command!");
        showCommands();
    }




}