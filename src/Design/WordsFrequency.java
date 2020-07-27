package Design;

import java.util.HashMap;

public class WordsFrequency {
    HashMap<String,Integer> hashMap=new HashMap<>();
    public WordsFrequency(String[] book) {
        for (String b:book) hashMap.put(b,hashMap.getOrDefault(b,0)+1);
    }
    public int get(String word) {
        return hashMap.getOrDefault(word,0);

    }
}
