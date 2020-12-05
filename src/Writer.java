import java.io.FileOutputStream;
import java.io.IOException;

public final class Writer {
    static void write(byte[] content, String fileName, boolean createCopy) {
        FileOutputStream writer = null;
        fileName = getFileName(fileName, createCopy);
        try {
            writer = new FileOutputStream(fileName);
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getFileName(String fileName, boolean createCopy) {
        if (createCopy) {
            if (fileName.indexOf(".") > 0) {
                String extension = fileName.substring(fileName.lastIndexOf("."));
                String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf("."));
                fileName = fileNameWithoutExtension + " Copy" + extension;
            } else {
                fileName += " Copy";
            }
        }
        return fileName;
    }
}
