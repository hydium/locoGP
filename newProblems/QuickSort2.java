
public class QuickSort2 {
	 public static int[] quickSort(int[] arr, int start, int end){
		 
	        int partition = partition(arr, start, end);
	 
	        if(partition-1>start) {
	            quickSort(arr, start, partition - 1);
	        }
	        if(partition+1<end) {
	            quickSort(arr, partition + 1, end);
	        }
	        return arr;
	    }
	 
	    public static int partition(int[] arr, int start, int end){
	        int pivot = arr[end];
	 
	        for(int i=start; i<end; i++){
	            if(arr[i]<pivot){
	                int temp= arr[start];
	                arr[start]=arr[i];
	                arr[i]=temp;
	                start++;
	            }
	        }
	 
	        int temp = arr[start];
	        arr[start] = pivot;
	        arr[end] = temp;
	 
	        return start;
	    }
}
