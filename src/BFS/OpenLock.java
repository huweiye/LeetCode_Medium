package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*BFS的visited一定要在把当前合法节点加入队列的同时就更新
* */
public class OpenLock {

    public int openLock(String[] deadends, String target) {
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        Set<String> dead=new HashSet<>();
        queue.offer("0000");
        for (String d:deadends) dead.add(d);
        if(dead.contains("0000")) return -1;//只有不在dead里的节点才能出现在图里面
        visited.add("0000");
        return bfs(queue,visited,dead,target);
    }
    private int bfs(Queue<String> queue,Set<String> visited,Set<String> dead,String target){
        int steps=0;
        while (!queue.isEmpty()){
            int queue_size=queue.size();
            for(int s=0;s<queue_size;s++) {
                String curr = queue.poll();

                if (curr.equals(target)) return steps;
                for (int x = 0; x < 4; x++) {//4个位置
                    String temp1 = add_one(curr, x);
                    if ((!visited.contains(temp1)) && (!dead.contains(temp1))) {queue.offer(temp1);visited.add(temp1);}

                    String temp2 = less_one(curr, x);
                    if ((!visited.contains(temp2)) && (!dead.contains(temp2))) {queue.offer(temp2);visited.add(temp2);}
                }
            }
            steps++;
        }
        return -1;
    }
    private String add_one(String c,int x){//对curr的第x位加1操作
        StringBuffer curr=new StringBuffer(c);
        if(curr.charAt(x)=='9') curr.replace(x,x+1,"0");
        else curr.replace(x,x+1,String.valueOf(Integer.valueOf(curr.substring(x,x+1))+1));
        return new String(curr);
    }
    private String less_one(String c,int x){//对curr的第x位加1操作
        StringBuffer curr=new StringBuffer(c);
        if(curr.charAt(x)=='0') curr.replace(x,x+1,"9");
        else curr.replace(x,x+1,String.valueOf(Integer.valueOf(curr.substring(x,x+1))-1));
        return new String(curr);
    }
}
