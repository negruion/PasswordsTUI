
public class Main {
    public static void main(String[] args) {

    Main main = new Main();
    main.run();

    }

    /** Runs the PasswordsTUI. */
    public void run(){



    }


    public void showCommands(){
        String commands =
                """
                generate            - generates a password
                check <password>    - checks the given password
                quit                - quits the PasswordsTUI
                """;
        System.out.println(commands);
    }

    public void showStartTUI(){
        System.out.println("Welcome to PasswordsTUI!");
        showCommands();
    }

}