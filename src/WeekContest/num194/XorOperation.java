package WeekContest.num194;

public class XorOperation {
    public XorOperation() {
        super();
    }
    public int xorOperation(int n, int start) {
        int res=start;
        for(int i=1;i<n;i++){
            int num=start+ 2*i;
            res=res^num;
        }
        return res;

    }
}
