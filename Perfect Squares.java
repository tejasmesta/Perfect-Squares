class Solution {
    public int numSquares(int n) {
        int i = 1;
        
        int m  = 1;
        
        List<Integer> list = new ArrayList<>();
        
        while(true)
        {
            m = i*i;
            if(m<=n)
            {
                list.add(m);                
                i++;
            }
            else
            {
                break;
            }
        }
        
        int dp[] = new int[n+1];
        
        Arrays.fill(dp,n+1);
        
        dp[0] = 0;
        
        for(i=0;i<=n;i++)
        {
            for(int j=0;j<list.size();j++)
            {
                if(list.get(j)<=i)
                {
                    dp[i] = Math.min(dp[i],1+dp[i-list.get(j)]);
                }
            }
        }
        
        return dp[n]==n+1?-1:dp[n];
    }
}
