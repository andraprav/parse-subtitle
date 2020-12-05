import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> replacements = new HashMap<String, String>() {{
            put("º", "s");
            put("þ", "t");
            put("ª", "S");
        }};
        List<String> files = Reader.getSubtitlesInCurrentDirectory();
        files.forEach(fileName -> {
            String content = Reader.read(fileName);

            String newContent = Parser.parse(content, replacements);

            Writer.write(newContent.getBytes(), fileName, true);
        });
    }

}
