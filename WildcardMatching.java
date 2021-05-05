public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) 
            return s.isEmpty();

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // Init True values for the first continuing '*'
        dp[0][0] = true;
        for (int p_i = 0; p_i < p.length() && p.charAt(p_i) == '*'; ++p_i)
            dp[0][p_i + 1] = true;

       for (int s_i = 1; s_i <= s.length(); ++s_i) {
            for (int p_i = 1; p_i <= p.length(); ++p_i) {
                
                 //if the char matches or is '?'
                if (p.charAt(p_i-1) == s.charAt(s_i-1) || p.charAt(p_i-1) == '?')
                    dp[s_i][p_i] = dp[s_i-1][p_i-1];
                
                //if char of pattern is '*'
                else if (p.charAt(p_i-1) == '*')
                        dp[s_i][p_i] = dp[s_i - 1][p_i] || dp[s_i][p_i - 1];
                 else
                    //no match found
                    dp[s_i][p_i] =false;
                }
            }
        return dp[s.length()][p.length()];
    }
}