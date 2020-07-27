package SlidingWindowANDDoublePointer;

import java.util.ArrayList;

public class IntervalIntersection {
    public IntervalIntersection() {
        super();
    }
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int n=A.length;
        int m=B.length;
        ArrayList<int []> res=new ArrayList<>();
        for(int i=0,j=0;i<n&&j<m;){
            if(Math.max(A[i][0],B[j][0])<=Math.min(A[i][1],B[j][1])) {
                res.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
            }
            if(A[i][1]<B[j][1]) i++;
            else j++;
        }
        int [][] answer=new int[res.size()][2];
        for (int i=0;i<res.size();i++) {
            answer[i][0]=res.get(i)[0];
            answer[i][1]=res.get(i)[1];
        }
        return answer;

    }
}
