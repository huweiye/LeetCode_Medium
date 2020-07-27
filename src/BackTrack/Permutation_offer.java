package BackTrack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Permutation_offer {
    public Permutation_offer() {
        super();
    }
    Set<String> set=new HashSet<>();
    String one_per=new String();
    String s;
    int n;
    boolean [] visited;
    public String[] permutation(String s) {
        this.s=s;
        this.n=s.length();
        visited=new boolean[n];//表示s的字符s[i]是否被使用过
        backtrack();
        String[]res=new String[set.size()];
        Iterator<String> iterator = set.iterator();
        int i=0;
        while(iterator.hasNext()){
            res[i] = iterator.next();
            i++;
        }
        return res;

    }
    private void backtrack(){
        if(one_per.length()==n){
            set.add(one_per);
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                one_per+=s.charAt(i);
                visited[i]=true;
                backtrack();
                one_per=one_per.substring(0,one_per.length()-1);
                visited[i]=false;
            }
        }

    }
}
