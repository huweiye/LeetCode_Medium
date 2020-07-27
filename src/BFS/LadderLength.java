package BFS;

import java.util.*;

public class LadderLength {
    Queue<String> queue=new LinkedList<>();
    Set<String> visited=new HashSet<>();
    Set<String> wordset=new HashSet<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word:wordList) wordset.add(word);
        if(!wordset.contains(endWord)) return 0;
        visited.add(beginWord);
        queue.add(beginWord);
        return bfs(endWord);
    }
    private int bfs(String endWord){
        int steps=1;
        while (!queue.isEmpty()){
            int len_queue=queue.size();
            for(int qqqq=0;qqqq<len_queue;qqqq++) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    StringBuffer next_word = new StringBuffer(word);//寻找和word只有一个字符不同且在字典里的单词
                    for (char temp = 'a'; temp <= 'z'; temp++) {
                        next_word.replace(i, i + 1, String.valueOf(temp));
                        if (!visited.contains(next_word.toString()) && wordset.contains(next_word.toString())) {
                            if (next_word.toString().equals(endWord)) {
                                steps++;
                                return steps;
                            }
                            visited.add(next_word.toString());
                            queue.offer(next_word.toString());
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}
