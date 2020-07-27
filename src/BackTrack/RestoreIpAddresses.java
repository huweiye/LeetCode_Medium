package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public RestoreIpAddresses() {
        super();
    }
    ArrayList<String> res=new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12) return res;
        backtrack("",0,s);
        return res;
   }
    private void backtrack(String one_answer,int flag,String str){//第flag层,3层截止
        if(str.equals("")) return;//1.2.3.这种情况
        if(flag==3){//只要到了第三层就进去，绝对不能dfs到超过三层
            if(str.length()<=3) {//1.2.3.211 111 111这种情况，不用判断，直接不合法
                int x = Integer.parseInt(str);
                if (str.length() == 1 || (str.length() == 2 && x >= 10) || (str.length() == 3 && (x >= 100 && x <= 255))) {//010，01这种情况不合法，排除这种情况
                    res.add(one_answer + str);
                    return;
                }else{//010，01这种情况不合法，排除这种情况
                    return;
                }
            }else{///1.2.3.211 111 111这种情况，前面划分得到的数字太少了，后面的超位数了
                return;
            }
        }

        for(int i=0;i<3&&i<str.length();i++){
            String left=str.substring(0,i+1);
            int x1=Integer.parseInt(left);
            if(left.length()==1||(left.length()==2&&x1>=10)||(left.length()==3&&(x1>=100&&x1<=255))){
                backtrack(one_answer+left+".",flag+1,str.substring(i+1));
            }
        }
    }
}
