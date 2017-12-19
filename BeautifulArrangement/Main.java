package BeautifulArrangement;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int a = sl.countArrangement(2);
        System.out.println(a);
    }
}

class Solution {
    public int sum = 0;
    public int countArrangement(int N) {
        int[] a= new int[N+1];
        for(int i=0;i<N+1;i++)
        {
            a[i]=1;
        }
        dfs(1,N,a);
        return this.sum;
    }
    void dfs(int n,int N,int[] a)
    {
        if(n > N+1)
        {
            return ;
        }
        if(n == N+1)
        {
            this.sum++;

        }
        else{
            for(int i=1;i<=N;i++)
            {
                if(a[i] > 0 )
                {
                    if(i % n == 0 || n % i == 0)
                    {
                        a[i]--;
                        dfs(n+1,N,a);
                        a[i]++;
                    }

                }

            }
        }

    }

}