package BackTrack;

import java.util.List;

public class NQueens {
    public NQueens() {
        super();
    }
    int []x;//记录一个解的各个皇后的位置，其中x[i]表示第i行的皇后放在第x[i]列
    int sum=0;//解总数
    int n;//皇后个数
    public int totalNQueens(int n) {
        x=new int[n+1];//从下标1开始使用，棋盘格是[1..n]行* [1...n]列
        this.n=n;
        backtrack(1);
        return sum;
    }
    private void backtrack(int t){//在已经产生了x[1]....x[t-1]的可行值的情况下，去产生x[t]的可行值
        if(t>n){//检查过叶节点了
            sum++;
            return;
        }
        for(int j=1;j<=n;j++){//对第t个皇后，它的可能的位置从从第1列到第n列逐个验证
            x[t]=j;
            if(canPlace(t)) backtrack(t+1);//因为x数组t位置的元素在下一次循环就被新值覆盖掉了，所以不用撤销
        }
    }
    private boolean canPlace(int t){//这是：已经生成了前t-1个皇后的位置了，判断当前情况下第t个皇后能不能放，在回溯函数中用于限界
        for(int i=1;i<t;i++){
            if((x[i]==x[t])||(Math.abs(i-t)==Math.abs(x[i]-x[t]))) return false;//同列或者同斜线
        }
        return true;
    }

}
