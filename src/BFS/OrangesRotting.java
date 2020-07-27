package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    Queue<int []> queue=new LinkedList<>();
    int nn=0;//最终有多少腐烂的橘子
    public int orangesRotting(int[][] grid) {
        int nums=0;//橘子数目
        int m=grid.length;
        int n=grid[0].length;
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    nums++;//坏橘子
                    queue.offer(new int[]{i,j});//初始的一批腐烂的橘子
                }else if(grid[i][j]==1){
                    nums++;//好橘子
                }
            }
        }
        int minute=bfs(grid);
        if(n==nums) return minute==-1?0:minute;//最终腐烂的橘子数目等于一开始所有的橘子数目
        else return -1;



    }
    private int bfs(int[][] grid){
        int minute=0;
        while (!queue.isEmpty()){
            int width=queue.size();
            nn+=width;
            for(int i=0;i<width;i++){
                int [] temp=queue.poll();

                if(temp[0]-1>=0&&grid[temp[0]-1][temp[1]]==1){//上
                    grid[temp[0]-1][temp[1]]=2;
                    queue.offer(new int[]{temp[0]-1,temp[1]});
                }
                if(temp[0]+1<grid.length&&grid[temp[0]+1][temp[1]]==1){//下
                    grid[temp[0]+1][temp[1]]=2;
                    queue.offer(new int[]{temp[0]+1,temp[1]});
                }
                if(temp[1]-1>=0&&grid[temp[0]][temp[1]-1]==1){//左
                    grid[temp[0]][temp[1]-1]=2;
                    queue.offer(new int[]{temp[0],temp[1]-1});
                }
                if(temp[1]+1<grid[0].length&&grid[temp[0]][temp[1]+1]==1){//右
                    grid[temp[0]][temp[1]+1]=2;
                    queue.offer(new int[]{temp[0],temp[1]+1});
                }

            }
            minute++;
        }
        return minute-1;
    }
}
