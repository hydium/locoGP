import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class RadixSort2 {
	 
	static int get_max_val(int my_arr[], int arr_len) {
	      int max_val = my_arr[0];
	      for (int i = 1; i < arr_len; i++)
	         if (my_arr[i] > max_val)
	         max_val = my_arr[i];
	      return max_val;
	   }
	   static void countSort(int my_arr[], int arr_len, int exp) {
	      int result[] = new int[arr_len];
	      int i;
	      int count[] = new int[10];
	      Arrays.fill(count,0);
	      for (i = 0; i < arr_len; i++)
	         count[ (my_arr[i]/exp)%10 ]++;
	      for (i = 1; i < 10; i++)
	         count[i] += count[i - 1];
	      for (i = arr_len - 1; i >= 0; i--) {
	         result[count[ (my_arr[i]/exp)%10 ] - 1] = my_arr[i];
	         count[ (my_arr[i]/exp)%10 ]--;
	      }
	      for (i = 0; i < arr_len; i++)
	         my_arr[i] = result[i];
	   }
	   static int[] radix_sort(int my_arr[], int arr_len) {
	      int m = get_max_val(my_arr, arr_len);
	      for (int exp = 1; m/exp > 0; exp *= 10)
	      countSort(my_arr, arr_len, exp);
	      return my_arr;
	   }
  
	   
	  
	   public static int[] bucket_sort(int[] arr) 
	    {   int max_value=maxValue(arr);
	       // System.out.print(max_value);
	        int[] bucket = new int[max_value + 1];
	        int[] sorted_arr = new int[arr.length];
	 
	        for (int i= 0; i <arr.length; i++)
	            bucket[arr[i]]++;
	 
	        int pos = 0;
	        for (int i = 0; i < bucket.length; i++)
	            for (int j = 0; j < bucket[i]; j++)
	                sorted_arr[pos++] = i;
	 
	        return sorted_arr;
	    }
	 
	 
	    static int maxValue(int[] arr) 
	    {
	        int max_value = 0;
	        for (int i = 0; i < arr.length; i++)
	            if (arr[i] > max_value)
	                max_value = arr[i];
	        return max_value;
	    }
	   
	   
	   
	 static void print(int arr[], int n) 
	    { 
	        for (int i = 0; i < n; i++) 
	            System.out.print(arr[i] + " "); 
	    } 
	  public static void main(String[] args) 
	    { 
	        int arr[] = { 170, 45, 75,3, 90, 802, 24, 2, 66 }; 
	        int n = arr.length; 
	    
	       bucket_sort(arr);
	        print(arr, n); 
}
	    
}