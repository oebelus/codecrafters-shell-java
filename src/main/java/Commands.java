import java.util.ArrayList;
import java.util.List;

public class Commands {
    private static List<String> commands = new ArrayList<>();

    static {
        commands.add("echo");
        commands.add("cd");
        commands.add("exit");
    }

    public static boolean commandExists(String command) {
        return commands.contains(command);
    }
}
