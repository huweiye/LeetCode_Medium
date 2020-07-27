package WeekContest.past;

import java.util.Arrays;

public class MaxProduct {
    public MaxProduct() {
        super();
    }
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);

    }
}
