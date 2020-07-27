package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
    public SolveNQueens() {
        super();
    }
    int n;//皇后个数
    int [] x;//从根到叶节点的一个可能的解，x[i]表示第i行的皇后放在第x[i]列
    ArrayList<int []> all_x=new ArrayList<>();//存储所有的可能的解，其中一个解以一个字符串形式被存储
    int sum=0;//解的个数

    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        x=new int[n+1];//从下标1开始使用,[1...n]
        backtrack(1);

        //按照规格输出解
        ArrayList<List<String>> res=new ArrayList<>();
        String one_row=new String();
        for(int i=0;i<n;i++){
            one_row+=".";
        }
        for(int i=0;i<all_x.size();i++){
            ArrayList<String> one_solution=new ArrayList<>();
            for(int ii=1;ii<=n;ii++){
                one_solution.add(one_row.substring(0,all_x.get(i)[ii]-1)+"Q"+one_row.substring(all_x.get(i)[ii]));
            }
            res.add(one_solution);
        }
        return res;
    }
    private void backtrack(int t){//解空间树的第t层，从第1层开始到第n层结束
        if(t>n){//找到一个可行解，此时的x就是当前找到的姐，记录下来
            int [] temp_x=new int[n+1];//临时存x用的，每次使用都要new一下temp_x，再把x深拷贝给temp_x
            for (int i=1;i<=n;i++) {
                temp_x[i]=x[i];
            }
            all_x.add(temp_x);
            sum++;
            return;
        }
        for(int j=1;j<=n;j++){//第t个皇后（即t行的皇后），有放第1列，放第2列...第n列这n中可能
            x[t]=j;//放在第j列试试
            if(canPlace(t)) backtrack(t+1);//可以则进一步dfs
            //无需撤销x[t]的值，直接试下一个j即可
        }
    }

    private boolean canPlace(int t){//对第t个皇后，判断它与前面[1...t-1]个皇后放置的位置是否冲突
        for(int i=1;i<=t-1;i++){
            if((x[t]==x[i])||(Math.abs(i-t)==Math.abs(x[i]-x[t]))){//同列||同斜线
                //同斜线：abs(行号-行号)==abs(列号-列号)
                return false;
            }
        }
        return true;
    }
}
