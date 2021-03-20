//link: https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character,Integer> mp=new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int res=0;

        if(s.length()==1 && mp.containsKey(s.charAt(0)))
            res+=mp.get(s.charAt(0));
        else
        {
            int temp=0;
            int i=0;
           while(i<s.length())
            {
               temp=0;
               if(i<s.length()-1)
               {
                 //  System.out.println(mp.get(s.charAt(i))+"  "+mp.get(s.charAt(i+1)));
                if(mp.get(s.charAt(i)) < mp.get(s.charAt(i+1)))
                {
                    temp=(mp.get(s.charAt(i+1))-mp.get(s.charAt(i)));
                   i+=2;
                }
               }
               
               if(temp>0)
                    res+=temp;
               else
               {
                   res+=mp.get(s.charAt(i));
                   i++;
               }
                    
            }
        }
        return res;
        
    }
}