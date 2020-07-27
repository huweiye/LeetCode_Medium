package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxProfit1 {
    public MaxProfit1() {
        super();
    }
    public int maxProfit(int[] prices) {//m(i)=max{m(i-1),第i天抛出价-第i-1天买入价}
        if(prices.length==0){
            return 0;
        }
        /**递归方程：
         * m(i)：前i天所能获得的最大利润
         m(i)=max{m(i-1),第i天的价格-前i-1天的最小价格}.....一维的，备忘录m是一维数组
         * */
        int min_price_day=prices[0];
        int [] m=new int[prices.length];
        m[0]=0;//第1天买入后就抛出的情况
        for(int i=1;i<prices.length;i++){//m[i]前i+1天的最大利润,从前2天开始算
            if(prices[i]<min_price_day){
                min_price_day=prices[i];
            }
            if(prices[i]-min_price_day>m[i-1]){
                m[i]=prices[i]-min_price_day;
            }else{
                m[i]=m[i-1];
            }

        }

        return m[m.length-1];

    }
}
