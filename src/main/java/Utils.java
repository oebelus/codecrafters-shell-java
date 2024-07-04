import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static String buildProcess(String[] command) throws IOException {
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

    public static int occurences(String substring, String string) {
        int index = 0;
        int count = 0;

        while (index != -1) {
            index = string.indexOf(substring, index);
            if (index != -1) {
                count++;
                index += substring.length();
            }
        }

        return count;
    }
}
