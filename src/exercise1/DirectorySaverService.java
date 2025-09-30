package exercise1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectorySaverService {

    public void saveDirectoryToFile(File dir, String outputFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            listDirectoryRecursive(dir, 0, writer);
        }
    }

    private static void listDirectoryRecursive(File dir, int level, PrintWriter writer) {
        File[] files = dir.listFiles();
        if (files == null) return;

        Arrays.sort(files, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));

        for (File file : files) {
            saveFileInfo(file, level, writer);
            if (file.isDirectory()) {
                listDirectoryRecursive(file, level + 1, writer);
            }
        }
    }


    private static void saveFileInfo(File file, int level, PrintWriter writer) {
        String indent = " ".repeat(level * 2);
        String type = file.isDirectory() ? "(D)" : "(F)";
        String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()));
        String info = indent + file.getName() + " " + type + " " + lastModified;

        writer.println(info);
    }
}
