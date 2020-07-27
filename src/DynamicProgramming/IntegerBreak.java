package DynamicProgramming;

public class IntegerBreak {
    public IntegerBreak() {
        super();
    }
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        if(n==4) return 4;
        //从4开始以后的每一个数，其通过拆分得到的积都大于其本身，不要问我为什么，猜的
        int []dp_max=new int[n+1];//n>=5，从下标1开始使用dp表
        dp_max[1]=1;
        dp_max[2]=2;
        dp_max[3]=3;
        dp_max[4]=4;
        //当下面用到的加数小于5时，使用它们本身而不是它们的拆分值，因为小于5时它们本身更大
        //只有当加数大于等于5时，才用它们的拆分值
        for(int each_num=5;each_num<=n;each_num++){
            dp_max[each_num]=dp_max[1]*dp_max[each_num-1];//初始化，比如5=1+4，此时给dp_max[5]赋值1*4
            for(int i=2;i<=each_num/2;i++){//i<=each_num/2即可,因为拆分各部分之积与顺序无关
                if(dp_max[i]*dp_max[each_num-i]>dp_max[each_num]) dp_max[each_num]=dp_max[i]*dp_max[each_num-i];
            }

        }
        return dp_max[n];



    }
}
