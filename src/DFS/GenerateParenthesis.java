package DFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public GenerateParenthesis() {
        super();
    }

    ArrayList<String> dfs_str=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,0,0,"");
        return dfs_str;
    }
    public void dfs(int n,int left,int right,String str){
        if(left==n&&left==right)  dfs_str.add(str);//一个匹配结果
        if(left<n)  dfs(n,left+1,right,str+"(");//还有左括号没用完
        if(right<left)  dfs(n,left,right+1,str+")");//可以放个右括号去匹配
    }


}
