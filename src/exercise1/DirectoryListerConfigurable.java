package exercise1;

import java.io.File;

public class DirectoryListerConfigurable {

    public static void main(String[] args) {
        try {
            ConfigLoader config = new ConfigLoader("config.properties");
            String directory = config.getDirectory();
            String outputFile = config.getOutputFile();

            File dir = new File(directory);

            if (!DirectoryValidator.isValidDirectory(dir)) {
                return;
            }

            DirectorySaverService service = new DirectorySaverService();
            service.saveDirectoryToFile(dir, outputFile);

            System.out.println("Directory contents saved to " + outputFile);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
