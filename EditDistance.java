class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
 
        int mat[][] = new int[m + 1][n + 1];
 
        //base conditions
        for (int i = 0; i <= m; i++) mat[i][0] = i;
        for (int j = 0; j <= n; j++) mat[0][j] = j;
 
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
   //as last character is same we have to manipulate only (m-1) accpding to (n-1)characters
                       mat[i][j]=mat[i-1][j-1];
                else
    //find minimum operations required after performing deletion,insertion and substituion for last charcter of word1 to make it equal to word2
                   mat[i][j] =1+ min(mat[i - 1][j], mat[i][j - 1], mat[i - 1][j - 1]);
            }
        }
        return mat[m][n];
    }
 
    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}