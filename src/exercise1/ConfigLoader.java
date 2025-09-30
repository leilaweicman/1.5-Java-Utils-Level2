package exercise1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private final Properties props = new Properties();

    public ConfigLoader(String configPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(configPath)) {
            props.load(fis);
        }
    }

    public String getDirectory() {
        return props.getProperty("directory");
    }

    public String getOutputFile() {
        return props.getProperty("outputFile");
    }
}
