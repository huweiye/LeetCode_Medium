package BackTrack;

import java.util.HashMap;
import java.util.HashSet;

public class NumTilePossibilities {
    /*
    含有重复元素的所有非空的排列的数目和
    * */
    public NumTilePossibilities() {
        super();
    }
    int n;
    String tiles;
    String one_str="";//遍历一条路径时生成的当前排列
    boolean[] visited;//记录当前字模有没有被使用过，因为字模有重复的，所以不能从one_str查找来判断
    HashSet<String> res=new HashSet<>();
    public int numTilePossibilities(String tiles) {
         n=tiles.length();
         this.tiles=tiles;
         visited=new boolean[n];
         backtrack();
         return res.size();
    }
    private void backtrack(){//解空间树的层数
        if(one_str.length()==n) return;
        //先验证字符串长度，不超过n才能再添加字符
        for(int j=0;j<n;j++){//回溯的一个特点是循环里写递归
            if(!visited[j]){//当前字模没被使用过，可以使用
                visited[j]=!visited[j];//标记上已经被使用了，在更深层次的dfs中（注意不是本层中），不能再使用了
                one_str+=tiles.charAt(j);
                res.add(one_str);
                backtrack();
                one_str=one_str.substring(0,one_str.length()-1);//撤销当前选择
                visited[j]=!visited[j];//撤销选择
            }

        }
    }


}
