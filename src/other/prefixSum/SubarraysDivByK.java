package other.prefixSum;

import java.util.HashMap;

public class SubarraysDivByK {
    public SubarraysDivByK() {
        super();
    }
   /* public int subarraysDivByK(int[] A, int K) {
        int sum=0;
        int n=A.length;
        HashMap<Integer,Integer> hashmap=new HashMap<>();//key=abs(PrefixSum[x]%K);value=次数
        *//*
        1.sum(A[i]...A[j])=PrefixSum[j]-Prefix[i-1]
        2.sum(A[i]...A[j])%K==0, (PrefixSum[j]-Prefix[i-1])%K==0
        3.根据同余定理:
        PrefixSum[j]%K==Prefix[i-1]%K
        4.所以只需要统计每一个PrefixSum[x]%K，统计余数相同的情况下的前缀和元素PrefixSum[x]的个数
        * *//*
        int [] PrefixSum=new int[n];
        PrefixSum[0]=A[0];
        for(int i=1;i<n;i++) PrefixSum[i]=PrefixSum[i-1]+A[i];

        hashmap.put(0,1);
        for(int i=0;i<n;i++){//对每一个前缀和数组元素
            *//*java:
            * 当x和y的正负相同，取余和取模结果相同，当x和y正负不同，取余结果的符号和x相同，取模结果的符号和y的符号相同
            * *//*
            if(hashmap.containsKey(Math.abs(PrefixSum[i])%K)){
                sum+=hashmap.get(Math.abs(PrefixSum[i])%K);
            }
            hashmap.put(Math.abs(PrefixSum[i]),hashmap.getOrDefault(Math.abs(PrefixSum[i]),0)+1);
        }
        return sum;

    }*/
}
