class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
 
        int mat[][] = new int[m + 1][n + 1];
 
        for (int i = 0; i <= m; i++) mat[i][0] = i;
        for (int i = 0; i <= n; i++) mat[0][i] = i;
 
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) cost = 0;
 
                mat[i][j] = min(mat[i - 1][j] + 1, mat[i][j - 1] + 1, mat[i - 1][j - 1] + cost);
            }
        }
        return mat[m][n];
    }
 
    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}