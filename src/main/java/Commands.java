import java.util.ArrayList;
import java.util.List;

public class Commands {
    private static List<String> commands = new ArrayList<>();

    static {
        commands.add("echo");
        commands.add("cd");
        commands.add("exit");
        commands.add("type");
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
}
