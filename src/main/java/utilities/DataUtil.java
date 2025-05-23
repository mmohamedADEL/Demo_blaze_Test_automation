package utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class DataUtil {

    private static String TEST_DATA_PATH = "src/test/resources/";

    public static String getJsonData(String filename, String... keys) {
        InputStream inputStream = DataUtil.class.getClassLoader().getResourceAsStream(filename + ".json");

        if (inputStream == null) {
            throw new RuntimeException("❌file not found : " + filename + ".json");
        }

        JsonElement jsonElement = JsonParser.parseReader(new InputStreamReader(inputStream));
        JsonObject currentObject = jsonElement.getAsJsonObject();

        for (int i = 0; i < keys.length - 1; i++) {
            if (currentObject.has(keys[i])) {
                currentObject = currentObject.getAsJsonObject(keys[i]);
            } else {
                throw new RuntimeException("❌ key not found " + keys[i]);
            }
        }

        String lastKey = keys[keys.length - 1];
        if (currentObject.has(lastKey)) {
            return currentObject.get(lastKey).getAsString();
        } else {
            throw new RuntimeException("❌ post key not found : " + lastKey);
        }
    }
    public static String getPropertyValue(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(TEST_DATA_PATH + fileName + ".properties")) {
            properties.load(input);
        }
        return properties.getProperty(key);
    }
}