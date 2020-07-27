package Hot100;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
    @Test
    public void insert() throws Exception {
        Trie trie=new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true

    }

    @Test
    public void search() throws Exception {
    }

    @Test
    public void startsWith() throws Exception {
    }

}