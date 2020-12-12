
public class BubbleSort2 {
	public static int[] BubbleSort(int a[],int n)
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
			
			}
		
			if(swap==false)
				break;
		}
		return a;
	}

}
