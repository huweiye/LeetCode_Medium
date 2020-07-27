package Design;

import java.util.HashMap;

public class Cashier {
    int n;
    int dis;
    int [] products;
    int [] prices;
    int this_num=0;
    HashMap<Integer,Integer> hashMap=new HashMap<>();
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n=n;
        this.dis=discount;
        this.products=products;
        this.prices=prices;
        for(int i=0;i<products.length;i++){
            hashMap.put(products[i],i);
        }
    }

    public double getBill(int[] product, int[] amount) {
        this_num++;
        double res=0;
        for(int i=0;i<product.length;i++){
            res+=prices[hashMap.get(product[i])]*amount[i];
        }
        if(this_num%n==0) return res - (((double)dis * res) / 100.0);
        else return res;
    }
}
