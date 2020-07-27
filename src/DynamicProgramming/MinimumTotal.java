package DynamicProgramming;

import java.util.List;

public class MinimumTotal {
    public MinimumTotal() {
        super();
    }
    public int minimumTotal(List<List<Integer>> triangle) {
       //行数必>=1,且列数必>=1,不然空树该返回什么作为最小值呢？
        int row=triangle.size();//行数
        int max_col=triangle.get(row-1).size();//最后一行的元素个数，即dp表最大的可能的容量
        int []dp_min=new int[max_col];//在第i行中，dp_min[j-1]表示以triangle[i-1][j-1]节点结尾的（注：此时，从根到第i行的路径必包含triangle[i-1][j-1]作为结尾）路径的最小长度
        //当i<=row时，设col=第i行的元素个数，则dp_min只用到了前col个位置，其中1<=i<=row,1<=j<=max_col
        //当循环完第row行，此时的dp_min就是以最后一行各个元素为终点的最小路径和，取min(dp_min)即可
        dp_min[0]=triangle.get(0).get(0);//第一行

        int [] temp_last_row=new int[max_col];//临时数组，用于保存上一次循环的dp表结果，即上一行的dp值

        for(int i=1;i<row;i++){//从第二行开始循环，i与上面注释的i不同，这里是下标

            for(int x=0;x<triangle.get(i-1).size();x++) temp_last_row[x]=dp_min[x];//每次只需要做上一行元素个数的次数的赋值

            int this_col=triangle.get(i).size();//本行列数

            for(int j=0;j<this_col;j++){//i，j直接用作下标
                if(j==0) dp_min[j]=temp_last_row[j]+triangle.get(i).get(j);//上一行的相邻元素只一个，本行[0] 的上一行相邻元素是 上一行[0]
                else if(j==this_col-1) dp_min[j]=temp_last_row[j-1]+triangle.get(i).get(j);//上一行的相邻元素只一个
                else{
                    dp_min[j]=Math.min(temp_last_row[j],temp_last_row[j-1])+triangle.get(i).get(j);//上一行的相邻元素有两个
                    //即上一行的 [j]和[j-1]
                }

            }

        }
        int min_res=dp_min[0];

        for (int min_in_dp:dp_min
             ) {
            if(min_in_dp<min_res) min_res=min_in_dp;

        }//取最大的dp_min元素

       return min_res;

    }
}
