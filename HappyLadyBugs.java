//hackerrank question : https://www.hackerrank.com/challenges/happy-ladybugs/problem
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for(int a0 = 0; a0 < testcases; a0++){
            int n = in.nextInt();
            String str = in.next();
            System.out.println(isHappy(str) ? "YES" : "NO");
        }
    }
    
    public static boolean isHappy(String s) {
        if (hasSingleFrequency(s)) { 
            //if any character has single frequency, it cant be happy
            return false;
        }
        
        if (alreadyHappy(s)) {
            return true;
        }
        
        if (hasSpace(s)) {
            //we can adjust the character and make it Happy if space is there
            return true;
        }
        
        return false;
    }
    
    public static boolean hasSingleFrequency(String s) {
        int[] ascii = new int[26];
        
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) != '_') {
                ascii[(int)s.charAt(i)-'A']++;
            }
        }
        
        for (int i=0;i<26;i++) {
            if (ascii[i] == 1) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean alreadyHappy(String s) {
        for (int i=0;i<s.length()-1;i++) {
            if (i == 0 && s.charAt(i) != s.charAt(i+1)) {
                return false;
            }
            else if (s.charAt(i) != s.charAt(i+1) && s.charAt(i) != s.charAt(i-1)){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean hasSpace(String s) {
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '_') {
                return true;
            }
        }
        
        return false;
    }
}
