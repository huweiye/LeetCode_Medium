package DynamicProgramming;

public class NumberOfArithmeticSlices {
    public NumberOfArithmeticSlices() {
        super();
    }
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3) return 0;
        if(A.length==3) return A[2]-A[1]==A[1]-A[0]?1:0;
        int n=A.length;
        int [] dp_num=new int[n];//dp_num[i]:以A[i]结尾的等差数列的个数
        int sum=0;
        //因为等差数列最短长度为3，所以从第三个元素为结尾的子数组开始初始化
        dp_num[2]=A[2]+A[0]==A[1]+A[1]?1:0;
        sum=dp_num[2];
        for(int i=3;i<n;i++){//以A[i]结尾的等差数列
            if(A[i]+A[i-2]==A[i-1]+A[i-1]){
                dp_num[i]=dp_num[i-1]+1;
                sum+=dp_num[i];
            }
            else dp_num[i]=0;
        }



        return sum;




    }

}
