import java.io.File;
import java.util.Arrays;

public class Utils {
    public static String[] tokenize(String str) {
        return str.split("\\s+");
    }

    public static String getEchoText(String[] tokens) {
        String text = "";
        int length = tokens.length;

        String[] textArray = Arrays.copyOfRange(tokens, 1, length);
        text = String.join(" ", textArray);
        return text;
    }

    public static String findExecutableOnPath(String cmd) {
        for (String dirname : System.getenv("PATH").split(File.pathSeparator)) {
            File file = new File(dirname, cmd);
            if (file.isFile() && file.canExecute()) {
                return file.getAbsolutePath();
            }
        }
        return cmd + ": not found";
    }

    public static boolean isExecutable(String cmd) {
        for (String dirname : System.getenv("PATH").split(File.pathSeparator)) {
            File file = new File(dirname, cmd);
            if (file.isFile() && file.canExecute()) {
                return true;
            }
        }
        return false;
    }
}
