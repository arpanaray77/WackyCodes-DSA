//LongestPalindromicString int O(n2)
import java.util.*;

class LongestPalindromicString {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getLongestPalin(str));
    }
    public static String getLongestPalin(String s)
    {
        int n=s.length();

        //dp[i][j] will be 1 if Substring(i,i+j) is palindrome else dp[i][[j]=0
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            dp[i][i]=1; //marking single letters as palindrome
        }

        int maxlen=1,start=0;

        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1)) //marking double letters as palindrome
            {
                dp[i][i+1]=1;
                start=i; //marking it as longest Palindrome for now
                maxlen=2;
            }
        }

        for(int len=3;len<=n;++len) //marking palindromes of len > 2
        {
            for(int i=0;i<n-len+1;++i) //for getting possible substrings of k length
            {
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1) //if palindrome
                {
                    dp[i][j]=1;
                    if(len>maxlen)
                    {
                        start=i;
                        maxlen=len; //storing length of longest Palindrome substring
                    }
                }
            }
        }

        return (s.substring(start,start+maxlen));
    }
}
