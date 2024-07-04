import java.util.Scanner;

public class Main {
    private static boolean inShell = true;

    public static void main(String[] args) throws Exception {

        while (inShell) {
            System.out.print("$ ");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            String[] tokens = Utils.tokenize(input);
            String cmd = tokens[0];

            if (!Utils.isExecutable(cmd) && !Commands.commandExists(cmd))
                System.out.println(input + ": command not found");

            else {
                if (cmd.equals("exit")) {
                    inShell = false;
                    scanner.close();
                } else if (cmd.equals("echo")) {
                    System.out.println(Utils.getEchoText(tokens));
                } else if (cmd.equals("type")) {
                    System.out.println(Commands.typeCommand(tokens[1]));
                } else {
                    System.out.println(Commands.runProgram(cmd, tokens[1]));
                }
            }
        }
    }
}
