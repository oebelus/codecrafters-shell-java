import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Commands {
    private static List<String> commands = new ArrayList<>();

    static {
        commands.add("echo");
        commands.add("cd");
        commands.add("exit");
        commands.add("type");
        commands.add("pwd");
        commands.add("cd");
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

        return Utils.buildProcess(command);
    }

    public static String getDirectory() {
        return System.getProperty("user.dir");
    }

    public static void changeDirectory(String directory) {
        Path path = Paths.get(directory);
        String pwd = getDirectory();
        String[] pwdArray = pwd.split("\\\\");
        String[] relative = { "./", "../" };

        int index = 0;
        int twoCount = 0;

        while (index != -1) {
            index = directory.indexOf(relative[1], index);
            if (index != -1) {
                twoCount++;
                index += relative[1].length();
            }
        }

        if (twoCount > 0) {
            String newPath = String.join("/", Arrays.copyOfRange(pwdArray, 0, pwdArray.length - twoCount));
            System.setProperty("user.dir", newPath);
        } else if (directory.startsWith("./")) {
            pwd += "\\" + directory.substring(2);
            if (Files.exists(Paths.get(pwd)))
                System.setProperty("user.dir", pwd);
            else {
                System.out.println("cd: " + pwd + ": No such file or directory");
            }
        } else {
            if (Files.exists(path)) {
                System.setProperty("user.dir", directory);
            } else {
                System.out.println("cd: " + directory + ": No such file or directory");
            }
        }
        // System.out.println(oneCount);
        // System.out.println(twoCount);

        // if (pwd.contains(directory)) {
        // System.setProperty("user.dir", directory);
        // } else if (Files.exists(path))
        // System.setProperty("user.dir", directory);
        // else
        // System.out.println("cd: " + directory + ": No such file or directory");
    }
}
