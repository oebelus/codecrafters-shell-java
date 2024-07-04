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
}
