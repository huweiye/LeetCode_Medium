package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxDistance {
    /*1162. 地图分析*/
    int [][] grid;
    Queue<int []> queue=new LinkedList<>();
    boolean [][] visited;
    int m;
    int n;
    int []res;

    public int maxDistance(int[][] grid) {
        this.grid=grid;
         m=grid.length;
         n=grid[0].length;
        Set<int[]> set=new HashSet<>();
        visited=new boolean[m][n];
        res=new int[2];
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                 if(grid[i][j]==1) {queue.offer(new int[]{i,j});set.add(new int[]{i,j});visited[i][j]=true;}
             }
         }

        if(queue.isEmpty()||queue.size()==m*n) return -1;
         bfs();

         return grid[res[0]][res[1]]-1;



    }
    private void bfs(){
        while (!queue.isEmpty()){
            int queue_size=queue.size();
            for(int i=0;i<queue_size;i++){
                int [] temp=queue.poll();
                res[0]=temp[0];
                res[1]=temp[1];
                if(temp[0]-1>=0&&!visited[temp[0]-1][temp[1]]&&grid[temp[0]-1][temp[1]]==0) {
                    visited[temp[0]-1][temp[1]]=true;
                    grid[temp[0]-1][temp[1]]=grid[temp[0]][temp[1]]+1;
                    queue.offer(new int[]{temp[0]-1,temp[1]});
                }
                if(temp[0]+1<m&&!visited[temp[0]+1][temp[1]]&&grid[temp[0]+1][temp[1]]==0) {
                    visited[temp[0]+1][temp[1]]=true;
                    grid[temp[0]+1][temp[1]]=grid[temp[0]][temp[1]]+1;
                    queue.offer(new int[]{temp[0]+1,temp[1]});
                }
                if(temp[1]-1>=0&&!visited[temp[0]][temp[1]-1]&&grid[temp[0]][temp[1]-1]==0) {
                    visited[temp[0]][temp[1]-1]=true;
                    grid[temp[0]][temp[1]-1]=grid[temp[0]][temp[1]]+1;
                    queue.offer(new int[]{temp[0],temp[1]-1});
                }
                if(temp[1]+1<n&&!visited[temp[0]][temp[1]+1]&&grid[temp[0]][temp[1]+1]==0) {
                    visited[temp[0]][temp[1]+1]=true;
                    grid[temp[0]][temp[1]+1]=grid[temp[0]][temp[1]]+1;
                    queue.offer(new int[]{temp[0],temp[1]+1});
                }
            }
        }
    }
}
