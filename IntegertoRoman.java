class Solution {
    public String intToRoman(int num) 
    {
        int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] romans = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder sb = new StringBuilder();
        
        for(int i = values.length - 1;i>=0 && num>0 ;i--)
        {
           if(num==values[i]) //if num == any standard value
           {
               sb.append(romans[i]);
               break;
           }   
          else if(num%values[i] == num) //if values is greater than num
              continue;
          else
          {
            int q=num/values[i]; // if divisible by any value then append that values' roman form quotient times
           while(q-- > 0)
               sb.append(romans[i]);
              
              num=num%values[i];
          }
        }
        return sb.toString();
            
    }
}