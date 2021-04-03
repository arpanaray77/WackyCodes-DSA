//question link: https://leetcode.com/problems/longest-valid-parentheses/
class Solution {
    public int longestValidParentheses(String s) {
        
        if(s.length()==0)
            return 0;
        
        int cnt=0,maxCnt=0;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
               st.push(i);
            else
            {
                if(!st.isEmpty())
                {
                   st.pop();
                  if(!st.isEmpty()) //this may be the longest valid string
                    maxCnt=Math.max(i-st.peek(),maxCnt);   
                 else
                    {
                       st.push(i); //the previous valid string has ended so moving to next one
                    }
                }
        }
        }
        return maxCnt;
    }
}