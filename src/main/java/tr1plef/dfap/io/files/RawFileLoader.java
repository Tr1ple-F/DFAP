package tr1plef.dfap.io.files;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tr1plef.dfap.io.console.Console.message;
import static tr1plef.dfap.io.errors.Messages.*;

public class RawFileLoader {

    public static Map<String, String> loadFile(String path) {
        List<String> lines = loadRawFileLines(path);
        // Error was thrown
        if (lines == null) {
            return null;
        }
        // Process into hash map
        Map<String, String> variableMap = new HashMap<>();
        boolean multiline = false;
        String key = null;
        String value = null;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            // Skip comments
            if (line.startsWith("//")) {
                continue;
            }
            // Continue line
            if (multiline) {
                value = value.concat(line);
                if (line.endsWith("}")) {
                    // End multiline
                    variableMap.put(key, value);
                    multiline = false;
                }
                continue;
            }
            // Break into assigning parts
            String[] assignment = line.split("=");
            if (assignment.length < 2) {
                message(noValueAssigned, i + "", line);
                continue;
            }
            if (assignment.length > 2) {
                message(multipleAssignments, i + "", line);
            }
            // Always assign last value
            String lineKey = assignment[0];
            String assignedValue = assignment[assignment.length - 1];
            if (assignedValue.startsWith("{") && !assignedValue.endsWith("}")) {
                // Multiline
                multiline = true;
                key = lineKey;
                value = assignedValue;
            } else {
                variableMap.put(lineKey, assignedValue);
            }
        }
        return variableMap;
    }

    private static List<String> loadRawFileLines(String path) {
        // File objects
        File file = new File(path);
        BufferedReader br;
        List<String> lines = new ArrayList<>();
        String line;
        // Find file
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            // Catch file not found exception
            message(fileNotFound, path);
            return null;
        }
        // Try to read file
        try {
            while ((line = br.readLine()) != null) {
                // Remove whitespaces
                lines.add(line.replaceAll("\\s", ""));
            }
        } catch (IOException e) {
            // Catch IO exception
            message(unableToRead, path);
            return null;
        }
        return lines;
    }
}
