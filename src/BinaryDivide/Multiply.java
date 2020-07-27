package BinaryDivide;

public class Multiply {
    public Multiply() {
        super();
    }
    public int multiply(int A, int B) {
       return getsum(0,A,B);

    }
    int getsum(int sum,int a,int b){
        if(b==0) return sum;//加够了，所有a都加完了
        return getsum(sum+a,a,--b);
    }
}
