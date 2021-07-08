class Solution {
    public int minSetSize(int[] arr) {
       
        //finding max n min to get the range
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
                               
        //counting the frequencies
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        
        count=countSort(count);
        System.out.print(Arrays.toString(count));
        
        //storing cumulative freq.
        for (int i = count.length-2; i>=0;i--) {
            count[i] += count[i+1];
        }
         System.out.print(Arrays.toString(count)); 
        int res=0;
        for(int i = count.length-1; i>=0; i--)
        {
            res++;
            if(count[i]>=arr.length/2)
                return res;
        }
        return 0;
    }
    
    static int[] countSort(int[] arr)
    {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
 
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
 
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
        return arr;
    }
}