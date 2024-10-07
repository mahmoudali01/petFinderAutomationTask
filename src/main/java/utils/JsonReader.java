package utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Utility class to read JSON data from files.
 * Provides static methods to retrieve values based on keys from a JSON structure.
 */
public class JsonReader {
    private static final String DATA_PATH = System.getProperty("user.dir") + "/src/main/java/data/";

    /**
     * Retrieves a value from the JSON structure based on a key.
     *
     * @param key      the key of the value to retrieve
     * @param fileName the name of the JSON file to read from
     * @return the value associated with the specified key, or null if not found or an error occurs
     */
    public static String jsonRead(String key, String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(DATA_PATH + fileName);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)) {
            JSONTokener tokener = new JSONTokener(inputStreamReader);
            JSONObject jsonObject = new JSONObject(tokener);
            return getValueFromJson(jsonObject, key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Recursive method to retrieve a value from a JSONObject based on a key.
     *
     * @param jsonObject the JSONObject to search
     * @param key        the key to search for
     * @return the value associated with the specified key, or null if not found
     */
    private static String getValueFromJson(JSONObject jsonObject, String key) {
        for (String k : jsonObject.keySet()) {
            if (k.equals(key)) {
                return jsonObject.optString(k, null);
            } else if (jsonObject.get(k) instanceof JSONObject) {
                String result = getValueFromJson(jsonObject.getJSONObject(k), key);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}