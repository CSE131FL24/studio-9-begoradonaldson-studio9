package studio9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordCount {
    /**
     * Constructs and returns a map of the distinct words in the specified list with
     * each word associated with its accumulated count (that is: the number of
     * occurrences of the word in the list).
     * 
     * For example, if passed a List<String> containing:
     * 
     * [to, be, or, not, to, be]
     * 
     * the resulting Map<String, Integer> would contain
     * 
     * key="to", value=2;
     * key="be", value=2;
     * key="or", value=1;
     * key="not", value=1;
     * 
     * @param words List of words to count
     * @return a map which contains all of the distinct words as keys, each
     *         associated with the number of occurrences of the word
     */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            // Increment the count if the word is already in the map, otherwise set it to 1
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    public static void main(String[] args) {
        List<String> wordList = new LinkedList<>();
        wordList.add("to");
        wordList.add("be");
        wordList.add("or");
        wordList.add("not");
        wordList.add("to");
        wordList.add("be");

        // Count words
        Map<String, Integer> words = countWords(wordList);

        // Verify the contents of the map
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println("Key: \"" + entry.getKey() + "\", Value: " + entry.getValue());
        }
    }
}
