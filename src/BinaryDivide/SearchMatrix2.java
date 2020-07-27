package BinaryDivide;

public class SearchMatrix2 {
    public SearchMatrix2() {
        super();
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        //从左下，右上逼近都可
        /*左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。
        比较左下角元素和target：
        若左下角元素等于目标，则找到
        若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
        若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标
        若最后矩阵减小为空，则说明不存在
        */
        if(matrix.length==0) return false;//外侧数组为空
        if(matrix[0].length==0) return false;//外侧数组包含一个空数组
        return divide(matrix,matrix.length-1,0,target);


    }
    public boolean divide(int [][] matrix,int row,int col,int target){//递归地分治
        if(row<0||col>matrix[0].length-1) return false;
        if(target==matrix[row][col]) return true;
        else if(target<matrix[row][col]) return divide(matrix,row-1,col,target);
        else return divide(matrix,row,col+1,target);//target>matrix[row][col]
    }

}
