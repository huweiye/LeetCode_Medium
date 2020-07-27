package WeekContest.num198;

import java.util.ArrayList;

public class CountSubTrees {
    ArrayList<Integer> [] table;//邻接表
    boolean[] visited;
    String labels;
    int [] res;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        res=new int[n];
        this.labels=labels;
        visited=new boolean[n];
        table=new ArrayList[n];//从0到n-1
        for(int i=0;i<n;i++) table[i]=new ArrayList<>();//初始化邻接表
        /*因为edges的父节点、子节点的顺序不一定，所以当作有向图来处理，用visited防止重复遍历*/
        for(int i=0;i<edges.length;i++){
            table[edges[i][0]].add(edges[i][1]);
            table[edges[i][1]].add(edges[i][0]);
        }
        dfs(0);

        return res;
    }
    private int [] dfs(int i) {//后序遍历
        if (visited[i]) return null;
        visited[i] = true;
        int [] letters_count=new int[26];
        ArrayList<Integer> temp = table[i];
        for (int j:temp) {
            int [] child=dfs(j);
            if(child!=null){
               for(int c=0;c<26;c++) letters_count[c]+=child[c];
            }


        }
        letters_count[labels.charAt(i)-'a']+=1;//当前子树的根节点
        res[i]=letters_count[labels.charAt(i)-'a'];
        return letters_count;
    }

}
