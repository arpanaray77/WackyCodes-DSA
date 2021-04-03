//https://leetcode.com/problems/ones-and-zeroes/
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        int dp[][]=new int[m+1][n+1];
        for(String s:strs)
        {
            int zeros=0,ones=0;
            for(int j=0;j<s.length();j++)
            {
                if(s.charAt(j)=='0')
                    zeros++;
                else
                    ones++;
            }
            
            for(int i=m;i>=zeros;i--)
            {
                for(int j=n;j>=ones;j--)
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
            }
        }
        return dp[m][n];
    }
}