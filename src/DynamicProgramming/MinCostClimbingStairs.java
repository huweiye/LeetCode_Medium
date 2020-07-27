package DynamicProgramming;

public class MinCostClimbingStairs {
    public MinCostClimbingStairs() {
        super();
    }
    public int minCostClimbingStairs(int[] cost) {
        int [] shit=new int[cost.length];
        shit[0]=cost[0];
        shit[1]=cost[1];
        for(int i=2;i<cost.length+1;i++){//目的地是最后一阶楼梯的再下一步
            if(i==cost.length) return Math.min(shit[i-1],shit[i-2]);//目的地没屎
            shit[i]=Math.min(shit[i-1],shit[i-2])+cost[i];
        }
        return -1;

    }
}
