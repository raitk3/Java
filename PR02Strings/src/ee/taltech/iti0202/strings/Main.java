package ee.taltech.iti0202.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /**
     * Classic count the words exercise.
     * <p>
     * From input count all the words and collect results to map.
     *
     * @param sentence array of strings, can't be null.
     * @return map containing all word to count mappings.
     */
    public static Map<String, Integer> wordCount(String[] sentence) {
        Map<String, Integer> words = new HashMap<>();
        for (String word : sentence) {
            if (words.getOrDefault(word, 0) != 0) words.put(word, words.get(word) + 1);
            words.putIfAbsent(word, 1);
        }
        return words;
    }


    /**
     * Find the most frequent word in given array of strings.
     *
     * If there are multiple most frequent words to choose from pick any of them.
     *
     * @param sentence array of strings, can't be null.
     * @return most frequent word in the sentence
     */
    public static String mostFrequentWord(String[] sentence) {
        Map<String, Integer> words = wordCount(sentence);
        int biggestNumber = 0;
        String mostFrequentWord1 = "";
        for (Map.Entry<String, Integer> element: words.entrySet()) {
            int value = element.getValue();
            String key = element.getKey();
            if (value > biggestNumber) {
                biggestNumber = value;
                mostFrequentWord1 = key;
            }
        }
        if (mostFrequentWord1.length() == 0) return null;
        return mostFrequentWord1;
    }

    /**
     * Loop over the given list of strings to build a resulting list of string like this:
     * when a string appears the 2nd, 4th, 6th, etc. time in the list, append the string to the result.
     * <p>
     * Return the empty list if no string appears a 2nd time.
     * <p>
     * Use map to count times that string has appeared.
     *
     * @param words input list to filter
     * @return list of strings matching criteria
     */
    public static List<String> onlyEvenWords(List<String> words) {
        Map<String, Integer> counts = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            if (counts.getOrDefault(word, 0) != 0) counts.put(word, counts.get(word) + 1);
            counts.putIfAbsent(word, 1);
            if (counts.get(word) % 2 == 0) answer.add(word);
        }
        return answer;
    }
    /**
     * Loop over the given string to build a result string like this:
     * when a character appears the 2nd, 4th, 6th, etc. time in the string, append the character to the result.
     * <p>
     * Return the empty string if no character appears a 2nd time.
     * <p>
     * Use map to count times that character has appeared.
     * Easy way to get char array (char[]) from string: input.toCharArray();
     *
     * @param input string
     * @return string
     */
    public static String onlyEvenCharacters(String input) {
        List<String> letters = new ArrayList<>();
        for (char c: input.toCharArray()) {
            String character = "" + c;
            letters.add(character);
        }
        List<String> answer = onlyEvenWords(letters);
        return String.join("", answer);
    }


    public static void main(String[] args) {
        System.out.println(wordCount(new String[]{})); // empty
        System.out.println(wordCount(new String[]
                {"eggs", "SPAM", "eggs", "bacon", "SPAM", "bacon", "SPAM"})); // {bacon=2, eggs=2, SPAM=3}

        System.out.println();
        System.out.println(mostFrequentWord(new String[]{})); // null
        System.out.println(mostFrequentWord(new String[]{"SPAM", "SPAM", "eggs", "bacon", "and", "SPAM"})); // SPAM

        System.out.println();
        System.out.println(onlyEvenWords(Arrays.asList("tere", "tere", "vanakere"))); // [tere]
        System.out.println(onlyEvenWords(Arrays.asList("foo", "bar", "baz", "baz", "bar", "foo"))); // [baz, bar, foo]
        System.out.println(onlyEvenWords(Arrays.asList("a", "b", "b", "a"))); // [b, a]
        System.out.println(onlyEvenWords(Arrays.asList("a", "b", "a", "b"))); // [a, b]
        System.out.println(onlyEvenWords(Arrays.asList("eggs", "bacon", "SPAM", "ham", "SPAM", "SPAM"))); // [SPAM]

        System.out.println();
        System.out.println(onlyEvenCharacters("aaa")); // a
        System.out.println(onlyEvenCharacters("aabbcaca")); // abca
        System.out.println(onlyEvenCharacters("bob")); // b
        System.out.println("\"" + onlyEvenCharacters("abc") + "\""); // ""
    }
}
