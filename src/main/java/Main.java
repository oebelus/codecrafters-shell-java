import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("$ ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (!Commands.commandExists(input))
            System.out.println(input + ": command not found");

        scanner.close();
    }
}
