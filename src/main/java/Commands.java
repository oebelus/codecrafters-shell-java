import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Commands {
    private static List<String> commands = new ArrayList<>();

    static {
        commands.add("echo");
        commands.add("cd");
        commands.add("exit");
        commands.add("type");
        commands.add("program_1234");
    }

    public static boolean commandExists(String command) {
        return commands.contains(command);
    }

    public static String typeCommand(String cmd) {
        if (commandExists(cmd))
            return cmd + " is a shell builtin";
        else
            return Utils.findExecutableOnPath(cmd);
    }

    public static String programCommand() {
        return "";
    }

    public static String runProgram(String cmd, String name) throws IOException {
        String exePath = Utils.findExecutableOnPath(cmd);

        String[] command = { exePath, name };

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        return output.toString().trim();
    }
}
