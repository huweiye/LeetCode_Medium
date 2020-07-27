package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class CanReach {
    /*1306. 跳跃游戏 III*/
    int [] arr;
    boolean[] visited;
    Queue<Integer> queue=new LinkedList<>();
    public boolean canReach(int[] arr, int start) {
        this.arr=arr;
        visited=new boolean[arr.length];
        queue.offer(start);
        visited[start]=true;
        return bfs();
    }
    private boolean bfs(){
        while (!queue.isEmpty()){
            int index=queue.poll();
            if(arr[index]==0) return true;
            visited[index]=true;
            if((index-arr[index])>=0&&!visited[index-arr[index]]){
                queue.offer(index-arr[index]);
                visited[index-arr[index]]=true;
            }
            if((index+arr[index])<arr.length&&!visited[index+arr[index]]){
                queue.offer(index+arr[index]);
                visited[index+arr[index]]=true;
            }
        }
        return false;

    }
}
