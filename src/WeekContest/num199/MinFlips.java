package WeekContest.num199;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinFlips {
    int n;
    public int minFlips(String target) {
        int res=0;
        this.n=target.length();
        String start=new String();
        boolean flag=true;
        for(int x=0;x<n;x++) start+="0";

        for(int i=0;i<n;i++){
            if(flag) {//不同时记录
                if ((start.charAt(i) != target.charAt(i))) {
                    flag=!flag;
                    res++;
                }
            }else{//相同时记录
                if((start.charAt(i) == target.charAt(i))){
                    res++;
                    flag=!flag;
                }

            }
        }
        return res;

    }

}
/*
public class MinFlips {
    Set<String> q1=new HashSet<>();
    Set<String> q2=new HashSet<>();
    Set<String> visited=new HashSet<>();
    int n;
    String target;
    public int minFlips(String target) {
        this.n=target.length();
        this.target=target;
        String start=new String();
        for(int x=0;x<n;x++) start+="0";
        q1.add(start);
        q2.add(target);
        return bfs();
    }
    private int bfs(){
        int steps=0;
        while (!q1.isEmpty()&&!q2.isEmpty()){
            Set<String> temp = new HashSet<>();
            for(String temp_str : q1){
                if(q2.contains(temp_str)) return steps;
                visited.add(temp_str);
                for(int j=0;j<n;j++){
                    String x=reverse(temp_str,j);
                    if(!visited.contains(x)) {temp.add(x);}
                }
            }
            steps++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
    private String reverse(String bulb,int start){//翻转操作
        */
/*选择当前配置下的任意一个灯泡（下标为 i ）
          翻转下标从 i 到 n-1 的每个灯泡*//*

        char [] now_bulb=bulb.toCharArray();
        for(int i=start;i<n;i++){
            if(now_bulb[i]=='0') now_bulb[i]='1';
            else now_bulb[i]='0';
        }
        return String.valueOf(now_bulb);
    }
}
*/
