package DynamicProgramming;

public class MaxProfit2 {
    public MaxProfit2() {
        super();
    }
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int [] p=new int[prices.length+1];
        for(int i=1;i<p.length;i++){
            p[i]=prices[i-1];
        }
        int [] m=new int[p.length];
        m[1]=0;
        int min_p=p[1];//前i-1天的最小价格
        int out_day=1;//上一笔交易的抛出日,默认第1天
        for(int i=2;i<p.length;i++){//从第2天开始填表
            if(p[i-1]<min_p)  min_p=p[i-1];

            int new_tx=0;
            for(int j=out_day;j<i;j++){
                if(p[i]-p[j]>new_tx) new_tx=p[i]-p[j];
            }
            if(new_tx==0){//无新交易可进行
                if(p[i]-min_p>m[i-1]){
                    out_day=i;
                    m[i]=p[i]-min_p;
                }else{
                    m[i]=m[i-1];
                }
            }
            else {//new_tx>0，有新交易可进行
                if(new_tx+m[i-1]>p[i]-min_p){
                    out_day=i;
                    m[i]=new_tx+m[i-1];
                }else{
                    out_day=i;
                    m[i]=p[i]-min_p;
                }

            }

        }
        return m[prices.length];

    }
}
