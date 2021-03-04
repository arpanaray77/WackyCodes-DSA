//String to Integer (atoi) conversion
class Solution {
    public int myAtoi(String s) {
        String w = "";
        int l = s.length();
        if (checkIntegerPresent(s) != -1) 
        {
            int ix = checkIntegerPresent(s);
            //System.out.print(ix);
            for (int i = ix; i < l; i++) 
            {
             if(w.length()==0 && (s.charAt(i) == '+'|| s.charAt(i) == '-'))
                    w = w + s.charAt(i);
             else if (w.length()!=0 && (s.charAt(i) == '+'|| s.charAt(i) == '-'))
                  break;
             else if(s.charAt(i) >= 48 && s.charAt(i)<=57)
                 w=w+s.charAt(i);
            else
                break;
            }
            
            if(w.length()==0 ||w.length()==1 && !(w.charAt(0) >= 48 && w.charAt(0)<=57))
                return 0;
              try 
            {
                return (Integer.parseInt(w));
            } 
            catch (NumberFormatException ex) {
                if(w.charAt(0)=='-')
                  return (Integer.MIN_VALUE);
                else
                return  (Integer.MAX_VALUE);
            }
           }
            return 0;    
        }
    
        public static int checkIntegerPresent(String s)
        {
            int l=s.length();
            for(int i=0;i<l;i++) {
                if (s.charAt(i) != ' ') {
                    if (s.charAt(i) == '+' || s.charAt(i) == '-' || (s.charAt(i) >= 48 && s.charAt(i) <= 57))
                        return i;
                    else
                        return  -1;
                }
            }
            return -1;
        }
}
