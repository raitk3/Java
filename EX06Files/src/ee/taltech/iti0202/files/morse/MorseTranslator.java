package ee.taltech.iti0202.files.morse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseTranslator {
    public Map<String, String> values;
    public Map<String, String> values2;

    public Map<String, String> addMorseCodes(List<String> lines) {
        Map<String, String> values = new HashMap<>();
        for (String line : lines) {
            String[] splits = line.split(" ");
            String asciiValue = splits[0].toLowerCase();
            String morseValue = splits[1];
            values.put(asciiValue, morseValue);
            values2.put(morseValue, asciiValue);
        }
        return values;
    }

    public List<String> translateLinesToMorse(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        if (lines.size() > 0) {
            for (String line : lines) {
                newLines.add(translateLineToMorse(line));
            }
        }
        return newLines;
    }

    public List<String> translateLinesFromMorse(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        if (lines.size() > 0) {
            for (String line : lines) {
                newLines.add(translateLineFromMorse(line));
            }
        }
        return newLines;
    }

    private String translateLineToMorse(String line) {
        List<String> newLine = new ArrayList<>();
        String[] wordsToTranslate = line.split(" ");
        if (line.length() > 0) {
            for (String word: wordsToTranslate) {
                List<String> newWord = new ArrayList<>();
                String[] charsToTranslate = word.split("");
                for (String letter : charsToTranslate) {
                    newWord.add(values.get(letter));
                }
                newLine.add(String.join(" ", newWord));
            }
            return String.join("\t", newLine);
        }
        return "";
    }

    private String translateLineFromMorse(String line) {
        List<String> newLine = new ArrayList<>();
        if (line.length() > 0) {
            String[] wordsToTranslate = line.split("\t");
            for (String word: wordsToTranslate) {
                List<String> newWord = new ArrayList<>();
                String[] charsToTranslate = word.split(" ");
                for (String letter : charsToTranslate) {
                    newWord.add(values.get(letter));
                }
                newLine.add(String.join("", newWord));
            }
            return String.join(" ", newLine);
        }
        return "";
    }
}
