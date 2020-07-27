package BinaryDivide;

public class SearchMatrix {
    public SearchMatrix() {
        super();
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        if(matrix[0].length==0) return false;
        //肯定不含空数组了
        //只比较右上角即可
        return divide(matrix,0,matrix[0].length-1,target);


    }
    public boolean divide(int [][] matrix,int row,int col,int target){
        if(row>matrix.length-1||col<0) return false;//越界
        if(matrix[row][col]==target) return true;
        if(target<matrix[row][col]) return divide(matrix,row,col-1,target);
        else return divide(matrix,row+1,col,target);
    }
}
