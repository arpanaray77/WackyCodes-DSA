//Implement strStr() : https://leetcode.com/problems/implement-strstr/

class Solution {
        
   public int strStr(String s, String t) { 
           
       return KMPsearch(s,t);
   }
    
    public static int KMPsearch(String txt,String pat)
    {
       //base case    
        if(pat.length() == 0 ) return 0;
        if(txt.length() < pat.length() || !txt.contains(pat)) return -1;
        
        int m=pat.length();
        int n=txt.length();
        
        int lps[]=new int[m]; 
        //having the length of longest proper prefix as well as suffix at index i
        computeLps(pat,lps);
        int i=0,j=0;
        
        while(i<n)
        {
            if(pat.charAt(j)==txt.charAt(i))
            {
                i++;j++;
            }
            
            if(j==m)//if whole pattern matched
            {
                return (i-j);
            }
            else if(i<n && pat.charAt(j)!=txt.charAt(i))
            {
                if(j!=0) 
                    j=lps[j-1];
                else //j==0
                    i=i+1;
            }            
        }
        return -1;
    }    
    
    public static void computeLps(String pat,int lps[])
    {
        int j=0;
        int i=1;
         lps[0]=0; 
        while(i<pat.length())
        {
            if(pat.charAt(i)==pat.charAt(j))
            {
                lps[i]=j+1; 
                i++;
                j++;
            }
            else
            {
                if(j!=0)
                {
                    j=lps[j-1]; //move j to a location = length of longest prefix and suffix
                }
                else //if j==0
                {
                    lps[i]=0;
                    i++;
                }
            }
        }
    }
}
    