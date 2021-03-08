//https://www.codechef.com/MARCH21C/problems/IRSTXOR

//find the pair (with max product) producing the given number on XOR

import java.util.*;

class XOR {
    static int ar[]=new int [31];
    static
    {
        for(int i=0;i<31;i++)
            ar[i]=(int)Math.pow(2,i);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while (t-- > 0) {
            int c=sc.nextInt();
            int n=0;
            for(int i=0;i<31;i++)
            {
                if(ar[i]>=c) {
                    n = ar[i];
                    break;
                }
            }

            long max=Integer.MIN_VALUE;

            for(int i=0;i<n;i++)
            {
               for(int j=0;j<n;j++) {

                   if(c==(i^j))
                   {
                       max= Math.max(i*j,max);
                   }
               }
            }
            System.out.println(max);
        }
    }
} 