package other.prefixSum;

import java.util.HashMap;

public class SubarraySum {
    public SubarraySum() {
        super();
    }
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int n=nums.length;
        int [] preixSum=new int[n];
        preixSum[0]=nums[0];
        for(int i=1;i<n;i++){
            preixSum[i]=preixSum[i-1]+nums[i];
        }
        for(int left=0;left<n;left++){
            for(int right=left;right<n;right++){
                if((preixSum[right]-(left-1<0?0:preixSum[left-1]))==k) sum+=1;
            }
        }
        return sum;
    }
    public int subarraySum2(int[] nums, int k) {
        int sum=0;
        int n=nums.length;
        int [] preixSum=new int[n];
        preixSum[0]=nums[0];
        for(int i=1;i<n;i++){
            preixSum[i]=preixSum[i-1]+nums[i];
        }
        //1.sum(nums[i]...nums[j])=preixSum[j]-preixSum[i-1].....j>=i
        //2.sum(nums[i]...nums[j])==K
        //3.preixSum[j]-preixSum[i-1]==K
        //4.preixSum[j]-K=preixSum[i-1](preixSum[i-1]从哈希表里去取)
        //对每个前缀和元素preixSum[j]，判断它的值减去K的值是否存在
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,1);//当i-1<0时，前缀和数组越界，(0,1)表示此时减去的是0
        for(int preixsum:preixSum){
            if(hashMap.containsKey(preixsum-k)){
                sum+=hashMap.get(preixsum-k);
            }
            hashMap.put(preixsum,hashMap.getOrDefault(preixsum, 0) + 1);
        }
        return sum;
    }
}
