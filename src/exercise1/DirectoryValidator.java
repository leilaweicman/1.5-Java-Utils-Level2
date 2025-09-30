package exercise1;

import java.io.File;

public class DirectoryValidator {

    public static boolean isValidDirectory(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("The provided path is not a valid directory.");
            return false;
        }
        return true;
    }
}
