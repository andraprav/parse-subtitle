import java.util.Map;
import java.util.Set;

public final class Parser {
    static String parse(String content, Map<String, String> replacements) {

        Set<Map.Entry<String, String>> entries = replacements.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            content = content.replace(entry.getKey(), entry.getValue());
        }

        return content;
    }
}