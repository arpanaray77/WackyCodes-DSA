import java.util.*;
import java.io.*;
class BinaryStringEvaluation
{
    public static  int findVal( char n1,char n2, char op)
    {
        int res=0;
        if(op=='C')
            res=n1^n2;
        else if(op=='B')
            res= n1|n2;
        else
            res=n1&n2;
        return  res;
     }
    public static void main (String[] args) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        if(str.length() <3) {
            System.out.println(-1);
            return;
        }
             int res= findVal(str.charAt(0),str.charAt(2),str.charAt(1));

             for(int i=3;i<str.length();i++)
             {
                 char c=str.charAt(i);
                 if(c!='0' && c!='1') {
                     res = findVal((char)res, str.charAt(i + 1), c);
                 }
             }
        System.out.println(res-'0');
    }
}