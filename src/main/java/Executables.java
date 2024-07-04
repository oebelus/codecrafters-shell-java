import java.io.File;

public class Executables {
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
