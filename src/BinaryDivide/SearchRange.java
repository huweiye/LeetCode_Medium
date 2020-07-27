package BinaryDivide;

public class SearchRange {
    public SearchRange() {
        super();
    }
    public int[] searchRange_BetterAnswer(int[] nums, int target) {
        int n=nums.length;
        if(n==0) return new int[]{-1,-1};
        int left=0,right=n-1;
        int mid=(left+right)/2;

        while(left<=right){
            if(nums[mid]>=target) right=mid-1;
            else left=mid+1;
            mid=(left+right)/2;
        }
        if(left==n||nums[left]!=target) return new int[]{-1,-1};
        int res1=left;
        left=0;
        right=n-1;
        while(left<=right){
            if(nums[mid]<=target) left=mid+1;
            else right=mid-1;
            mid=(left+right)/2;
        }
        int res2=right;
        return new int[]{res1,res2};


    }

    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        if(n==0) return new int[]{-1,-1};
        int flag=binary_search(nums,0,n-1,target);
        if(flag==-1) return  new int[]{-1,-1};
        int min_index=flag,max_index=flag;
        boolean find_both=false;
        for(int x=1;flag-x>=0;x++){
            if(nums[flag-x]==target) {min_index=flag-x;}
            else find_both=true;//找到左边界了
            if(find_both) break;
        }
        find_both=false;
        for(int x=1;flag+x<n;x++){
            if(nums[flag+x]==target) {max_index=flag+x;}
            else find_both=true;//找到右边界了
            if(find_both) break;
        }


        return new int[]{min_index,max_index};
    }

    public int binary_search(int[] nums, int left, int right, int target){
        if(left>right) return -1;
        int mid=(left+right)/2;
        if(target==nums[mid]) return mid;
        else if(target<nums[mid]) return binary_search(nums,left,mid-1,target);
        else return binary_search(nums,mid+1,right,target);
    }



}
