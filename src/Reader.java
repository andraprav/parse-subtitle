import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Reader {
    static String read(String fileName) {
        String currentDirectory = new File("").getAbsolutePath();
        File file = new File(currentDirectory + "/" + fileName);

        StringBuilder content = new StringBuilder();
        FileInputStream reader = null;

        try {
            reader = new FileInputStream(file);

            int i;
            while ((i = reader.read()) != -1) {
                content.append((char) i);
            }

            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    static List<String> getSubtitlesInCurrentDirectory() {
        File currentDirectory = new File(".");

        List<String> files = new ArrayList<>();
        for (final File fileEntry : currentDirectory.listFiles()) {
            if (!fileEntry.isDirectory() && isSubtitle(fileEntry.getName())) {
                files.add(fileEntry.getName());
            }
        }
        return files;
    }

    private static boolean isSubtitle(String name) {
        return name.endsWith(".srt") || name.endsWith(".sub");
    }
}
