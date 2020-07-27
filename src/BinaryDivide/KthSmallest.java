package BinaryDivide;

public class KthSmallest {
    /*378. 有序矩阵中第K小的元素*/
    public KthSmallest() {
        super();
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;//方阵
        if(n==1) return matrix[0][0];//因为k的值总是有效的，此时k一定等于1
        int left=matrix[0][0],right=matrix[n-1][n-1];
        int mid=-1;
        while(left<right){
            mid=(left+right)/2;
            int cnt=get_cnt(matrix,mid);
            if(cnt>=k) right=mid;
            else left=mid+1;
        }
        return right;

    }
    public int get_cnt(int [][] matrix,int mid){//在矩阵里找小于等于mid的元素的个数
        int n=matrix.length;
        int sum=0;
        //逐行查找
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]<=mid) {
                    sum+=(j+1);//第j列及其之前列的元素肯定也都<=mid,都加上
                    break;//直接开始下一行
                }
            }
        }
        return sum;
    }
}
