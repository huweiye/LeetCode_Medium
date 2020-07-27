package DynamicProgramming;

public class MaxProduct {
    public MaxProduct() {
       super();
    }
    public int maxProduct(int[] nums) {
        int [][] m=new int[nums.length][2];
        m[0][0]=nums[0];
        m[0][1]=nums[0];
        int max_prod=m[0][0];
        for(int i=1;i<nums.length;i++){
            m[i][0]= Math.max(Math.max(nums[i],nums[i]*m[i-1][0]),nums[i]*m[i-1][1]);
            m[i][1]=Math.min(Math.min(nums[i],nums[i]*m[i-1][0]),nums[i]*m[i-1][1]);
        }
        for(int i=1;i<nums.length;i++){
            max_prod=Math.max(Math.max(m[i][0],m[i][1]),max_prod);
        }
        return max_prod;
    }
}
