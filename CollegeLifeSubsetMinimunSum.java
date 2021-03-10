//CodeChef March Long: https://www.codechef.com/MARCH21C/problems/COLGLF4

import java.util.*;

class CollegeLife {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long e = sc.nextLong();
            long h = sc.nextLong();
            long p1 = sc.nextLong();
            long p2 = sc.nextLong();
            long p3 = sc.nextLong();

            if(getMinPrice(n, e, h, p1, p2, p3)==(long)1e15)
                System.out.println(-1);
            else
                System.out.println(getMinPrice(n, e, h, p1, p2, p3));
        }
    }

    public static long getMinPrice(long n, long e, long h, long p1, long p2, long p3) {
        if (n <= 0)
            return 0;

        long total = (long) 1e15;

        if (2 * n <= e) { 
         //all orders are omlettes
            total = Math.min(total, n * p1);
        }

       if (3 * n <= h) {
	//all orders are milkshakes
            total = Math.min(total, n * p2);
        }

       if (n <= e && n <= h) {
	//all orders are cakes
            total = Math.min(total, n * p3);
        }

        if (((h - n) / 2 >= 1) && ((h - n) / 2 >= n - e)) {
		//all orders include only milkshake and cake

		//considering  x milkshakes and n-x cakes are ordered and vice versa
            if (p2 - p3 < 0) { 
                long tmp = Math.min(n - 1, (h - n) / 2);
                total = Math.min(total, (p2 - p3) * tmp + n * p3);
            } else {
                long tmp = Math.max(1, n - e);
                total = Math.min(total, (p2 - p3) * tmp + n * p3);
            }
        }

        if ((e - n) >= 1 && (e - n) >= n - h) {
	//all orders include only omlettes and cakes

	//considering x omlettes and n-x cakes are ordered and vice versa
            if (p1 - p3 < 0) {
                long tmp = Math.min(n - 1, e - n);
                total = Math.min(total, (p1 - p3) * tmp + n * p3);
            } else {
                long tmp = Math.max(1, n - h);
                total = Math.min(total, (p1 - p3) * tmp + n * p3);
            }
        }

        if ((e / 2) >= 1 && (e / 2 >= (3 * n - h + 2) / 3)) {
	//all orders include only omlettes and milkshakes

            if (p1 - p2 < 0) {
                long tmp = Math.min(n - 1, e / 2);
                total = Math.min(total, (p1 - p2) * tmp + n * p2);
            } else {
                long tmp = Math.max(1, (3 * n - h + 2) / 3);
                total = Math.min(total, (p1 - p2) * tmp + n * p2);
            }
        }
       if ((e >= 3) && (h >= 4) && (n >= 3)) {
	//all orders include atleast one of three items

            total = Math.min(total, (p1 + p2 + p3) + getMinPrice(n - 3, e - 3, h - 4, p1, p2, p3));
        }
        return total;
    }
}
