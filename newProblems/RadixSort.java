
import java.io.*; 
import java.util.*; 
  
public class RadixSort { 
  
    static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  
   
    static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count, 0); 
  
        for (i = 0; i < n; i++) 
            count[(arr[i] / exp) % 10]++; 
  
       
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        for (i = n - 1; i >= 0; i--) { 
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
            count[(arr[i] / exp) % 10]--; 
        } 
  
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
   
   static int[] radixsort(int arr[], int n) 
    { 
        int m = getMax(arr, n);  
        for (int exp = 1; m / exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
        return arr;
    } 
  
    // A utility function to print an array 
    static void print(int arr[], int n) 
    { 
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
    } 
  
    
    public static int[] bubblesort(int[] numbers) {
	    boolean swapped = true;
	    for(int i = numbers.length - 1; i > 0 && swapped; i--) {
	        swapped = false;
	        for (int j = 0; j < i; j++) {
	            if (numbers[j] > numbers[j+1]) {
	                int temp = numbers[j];
	                numbers[j] = numbers[j+1];
	                numbers[j+1] = temp;
	                swapped = true;
	            }
	        }
	    }
	    return numbers;
	    } 
    
    
    static int[] sort(int arr[]) {
		for (int i = 1, j; i < arr.length; i++) {
			int temp = arr[i];
			for (j = i; j > 0 && temp < arr[j - 1]; j--)
				arr[j] = arr[j - 1];
			arr[j] = temp;
		}
		return arr;
	}
    
    
    static int[] sort1(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
        return arr;
    } 
    
  /*  public static int[] BubbleSort(int a[],int n)
	{
		int temp;
		boolean swap;
		for(int i=0;i<n-1;i++)
		{
			swap=false;
			for(int j=0;j<n-1;j++)
			{
				if(a[j]>a[(j+1)])
				{
					temp=a[j];
					a[j]=a[(j+1)];
					a[(j+1)]=temp;
					swap=true;
				}
			//System.out.print(a[j]);
			}
			//System.out.println();
			if(swap==false)
				break;
		}
		return a;
	} */
    
    
    
    
    
    
    
    /*Driver Code*/
    public static void main(String[] args) 
    { 
        int arr[] = { 170, 45, 75,3, 90, 802, 24, 2, 66 }; 
        int n = arr.length; 
            
          // Function Call 
        radixsort(arr, n); 
      // BubbleSort(arr,arr.length);
        print(arr, n); 
    } 
} 