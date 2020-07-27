package BinaryDivide;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
    public FindRightInterval() {
        super();
    }
    public int[] findRightInterval(int[][] intervals) {
       int n=intervals.length;//区间个数
       int [][] temp_inter=new int[n][2];//待排序数组，用来二分查找的，分别存起始点值及该起始所在区间的下标，因为起始点互不相同，所以不会撞下标
       for(int i=0;i<n;i++){
           temp_inter[i][0]=intervals[i][0];
           temp_inter[i][1]=i;
       }
        //先排序，再二分
        Arrays.sort(temp_inter,new Comparator<int[] >() {
            @Override
            public int compare(int[] A, int[] B) {//按区间里前面的那个数排序,因为二分的时候找的是起始点
                if (A[0] > B[0]) return 1;
                else if (A[0] < B[0]) return -1;
                else return 0;
            }
        });
        int [] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=binary_divide(temp_inter,0,n-1,intervals[i][1]);
        }
        return res;
    }
    public int binary_divide(int [][] nums,int left,int right,int target){//二分找满足条件（nums[i][0]大于等于target）的最小值（左边界）
        int mid=-1,res=-1;
        while (left<=right){
            mid=(left+right)/2;
            if(nums[mid][0]>=target){res=mid;right=mid-1;}//往左半区域去寻找满足条件的更小的值
            else left=mid+1;//不够大
        }
        return res==-1?-1:nums[res][1];

    }
    public int binary_search(int[][] nums, int left, int right, int target){//递归版，更复杂，不用看
        if(left==right) {
            if(nums[left][0]>=target) return nums[left][1];
            else if(left+1<nums.length&&nums[left+1][0]>=target) return nums[left+1][1];
            else return -1;
        }
        int mid=(left+right)/2;
        if(target==nums[mid][0]) return nums[mid][1];
        else if(target<nums[mid][0]) return binary_search(nums,left,mid-1,target);
        else return binary_search(nums,mid+1,right,target);
    }



}
