import java.util.ArrayList;
import java.util.List;

public class Commands {
    private static List<String> commands = new ArrayList<>();

    static {
        commands.add("echo");
        commands.add("cd");
    }

    public static boolean commandExists(String command) {
        return commands.contains(command);
    }
}
