package exercise1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class DirectoryListerConfigurable {

    public static void main(String[] args) {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Error reading configuration file.");
            return;
        }

        String directory = props.getProperty("directory");
        String outputFile = props.getProperty("outputFile");

        File dir = new File(directory);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("The provided path is not a valid directory.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(outputFile)) {
            listDirectoryRecursive(dir, 0, writer);
            System.out.println("Directory contents saved to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
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
