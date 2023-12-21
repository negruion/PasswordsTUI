import java.util.Scanner;
import passwords.Checker;
import passwords.Generator;

public class Main {

    boolean running = true;
    Generator generator = new Generator();
    Checker checker = new Checker();

    public static void main(String[] args) {

        Main passwordsTUI = new Main();
        passwordsTUI.run();

    }

    /** Runs the PasswordsTUI. */
    public void run(){
        showStartTUI();

        Scanner keyboard = new Scanner(System.in);

        while(running){
            System.out.print("Choice: ");
            String command = keyboard.nextLine(), value="";

            String[] commands = command.split("\\s+");
            command = commands[0];

            switch (command.toLowerCase()){
                case "generate" -> {
                    String password = generator.getPassword();
                    System.out.println("Generated Password: " + password);
                }
                case "check" -> {
                    if(commands.length == 1){
                        System.out.println("Nonexistent parameter!");
                    }else{
                        value = commands[1];
                        checker.checkPassword(value);
                    }
                }
                case "help" -> showCommands();
                case "exit" -> {
                    System.out.println("Quitting the TUI...");
                    running = false;
                }
                default -> {
                    System.out.println("You've entered an unknown command!");
                    showCommands();
                }

            }
        }

    }

    /** Shows the available commands for the TUI. */
    public void showCommands(){
        String commands =
                """
                
                generate            - generates a password
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

}