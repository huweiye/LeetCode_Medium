package BackTrack;

public class GetPermutation {
    public GetPermutation() {
        super();
    }
    int sum=0;//当前产生的排列总数
    String one_solution=new String();
    String res;
    boolean [] visited;
    int n;
    int k;
    public String getPermutation(int n, int k) {
        this.n=n;
        this.k=k;
        visited=new boolean[n+1];
        backtrack();
        return res;
    }
    private void backtrack(){
        if(one_solution.length()==n){
            sum++;
            if(sum==k) res=one_solution;
            return;
            }
            for(int i=1;i<=n;i++){
            if(!visited[i]){
                one_solution+=i;
                visited[i]=true;
                backtrack();
                one_solution=one_solution.substring(0,one_solution.length()-1);
                visited[i]=false;
            }

        }
    }
}
