package BinaryDivide;

public class MyPow {
    public MyPow() {
        super();
    }
    public double myPow(double x, int n) {
        int temp_n=n;
        double ans=1;
        while(n!=0){
            if((n&1)!=0){//和1与取末尾
                ans*=x;
            }
            x*=x;
            n/=2;
        }
        return temp_n>=0?ans:1/ans;

    }
    public double rec(double x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 1)//奇数
            return rec(x, n - 1) * x;
        else//偶数
        {
            double temp = rec(x, n / 2);
            return temp * temp;
        }
    }




}
