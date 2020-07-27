package Hot100;

public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
         root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char [] word_chars=word.toCharArray();
        TrieNode node=root;
        for(int i=0;i<word_chars.length;i++){
            if(node.next_node[word_chars[i]-'a']==null){
                node.next_node[word_chars[i]-'a']=new TrieNode();
                node=node.next_node[word_chars[i]-'a'];
            }else{
                node=node.next_node[word_chars[i]-'a'];
            }
        }
        node.is_leaf=true;//node是当前结束节点的子节点

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char [] word_chars=word.toCharArray();
        TrieNode node=root;
        for(int i=0;i<word_chars.length;i++){
            if(node.next_node[word_chars[i]-'a']==null) return false;
            node=node.next_node[word_chars[i]-'a'];
        }
        if(node.is_leaf==false) return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char [] word_chars=prefix.toCharArray();
        TrieNode node=root;
        for(int i=0;i<word_chars.length;i++){
            if(node.next_node[word_chars[i]-'a']==null) return false;
            node=node.next_node[word_chars[i]-'a'];
        }
        return true;
    }


    public class TrieNode{
        TrieNode[] next_node=new TrieNode[26];//26个小写英文字母
        boolean is_leaf=false;
        public TrieNode() {
            for(int i=0;i<26;i++) next_node[i]=null;
        }
    }
}
