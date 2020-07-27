package DFS.GridDFS;

import java.util.ArrayList;
import java.util.Arrays;

public class PondSizes {
    public PondSizes() {
        super();
    }
    int [][] land;
    int m;
    int n;
    int a_size;
    public int[] pondSizes(int[][] land) {
        this.land=land;
         m=land.length;
         n=land[0].length;
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==0){
                    dfs(i,j);
                    res.add(a_size);
                }
                a_size=0;
            }
        }
        int [] a=res.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(a);
        return a;


    }
    private void dfs(int i,int j){
        if(i<0||i>=m||j<0||j>=n) return ;//越界
        if(land[i][j]!=0) return ;//不是水域或者访问过了
        //没越界且是水域的情况：
        a_size++;
        land[i][j]=-1;
        dfs(i-1,j);
        dfs(i+1,j);
        dfs(i,j-1);
        dfs(i,j+1);
        dfs(i-1,j-1);
        dfs(i-1,j+1);
        dfs(i+1,j-1);
        dfs(i+1,j+1);
    }
}
