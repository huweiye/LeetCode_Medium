package BinaryDivide;

public class FindDuplicate {
    public FindDuplicate() {
        super();
    }
    public int findDuplicate(int[] nums) {
        return rec_div(nums,1,nums.length-1);
    }
    public int rec_div(int[] nums,int left,int right){
        if(left==right) return right;
        if(howmany_mid(nums,(left+right)/2)) return rec_div(nums,left,(left+right)/2);
        else return rec_div(nums,(left+right)/2+1,right);

    }
    public boolean howmany_mid(int [] nums,int mid){
        int sum=0;
        for (int n:
             nums) {
            if(n<=mid) sum+=1;
        }
        return sum>mid;

    }
}
