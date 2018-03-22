
package site.kevinhuang.javatraining;
public class Sort
{
	public static void main(String[] args)
	{
		int[] numSerl = new int[]{28,16,32,12,60,2,5,72};
		//排序之前
		System.out.print("原始数据：");
		for(int num : numSerl)
		{
			System.out.print(num+" ");
		}
		System.out.println();		
		
		//此处更换排序算法
		quickSort(numSerl);
		
		//排序之后
		System.out.print("排序之后：");
		for(int num : numSerl)
		{
			System.out.print(num+" ");
		}
		
	}
	/* 1: sortSeclet*/
	public static void sortSeclet(int[] arr)
	{
		for (int i = 0; i < arr.length-1; i++) 
		{
            for (int j = i+1; j < arr.length; j++) 
            {
                if(arr[j]<arr[i])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            //打印第i次的结果
    		System.out.print("第"+(i+1)+"次排序：");
    		for(int num : arr)
    		{
    			System.out.print(num+" ");
    		}
    		System.out.println();
        }
		
	}
	
	
	/* 2: sortInsert*/
	public static void sortInsert(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if (arr[j]<arr[j-1])
				{
					int temp =  arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
					
			}
			//打印第i次的结果
    		System.out.print("第"+(i+1)+"次排序：");
    		for(int num : arr)
    		{
    			System.out.print(num+" ");
    		}
    		System.out.println();
		}
	}
	
	/* 3: sortShell*/
	public static void sortShell(int[] source) 
	{   
		int j; 
		for (int gap = source.length / 2; gap > 0; gap /= 2) 
		{ 
			for (int i = gap; i < source.length; i++) 
			{ 
				int temp = source[i]; 
				for (j = i; j >= gap; j -= gap) 
					if(temp < source[j - gap]) 
						source[j] = source[j - gap];
					else break;
					source[j] = temp; 
			} 
	
		//打印第i次的结果
		System.out.print("增量"+(gap)+"次排序：");
		for(int num : source)
		{
			System.out.print(num+" ");
		}
		System.out.println();
		} 
	}
	
	/* 4: sortBubble*/
	public static void sortBubble(int[] arr) 
	{   
		for(int i=0;i<arr.length-1;i++){//冒泡趟数
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        	
		//打印第i次的结果
		System.out.print("第"+(i)+"次排序：");
		for(int num : arr)
		{
			System.out.print(num+" ");
		}
		System.out.println();
		} 
	}
	
	
	
	/* 5: sortMerge*/
	public static void sortMerge(int []arr)
	{
		int[] aux = new int[arr.length];    //辅助数组
		sortMerge(arr, 0, arr.length - 1, aux);
    }
	
	
	//重载的方法,多态的表现
	public static void sortMerge(int[] a, int lo, int hi, int[] aux) 
	{
		    if (hi <= lo)
		        return;
		    int mid = lo + (hi - lo) / 2;
		    sortMerge(a, lo, mid, aux);
		    sortMerge(a, mid + 1, hi, aux);
		    merge(a, lo, mid, hi, aux);
		    


			 
	}
	
	public static void merge(int[] a, int lo, int mid, int hi, int[] aux) 
	{
	    int i = lo, j = mid + 1;
	    for (int k = lo; k <= hi; k++) {
	        aux[k] = a[k];
	    }
	    for (int k = lo; k <= hi; k++) {
	        if (i > mid)
	            a[k] = aux[j++];
	        else if (j > hi)
	            a[k] = aux[i++];
	        else if (aux[i] <= aux[j])
	            a[k] = aux[i++];
	        else
	            a[k] = aux[j++];

	    }
	    
	    System.out.print("归并"+i+"次: ");
		for(int num : a)
		{
			System.out.print(num+" ");
		}
		System.out.println();
	}
	
	//quicksort	
	
	//quickSort
	public static void quickSort(int[] array){
		quickSort(array, 0,array.length-1);
		
	}
	
	//quickSortTemp
	
	public static int partition(int[] array, int low, int high){
		int i=low+1,j=high;
		int value = array[low];
		while(true){
			while(array[i]<=value){
				if(i==high) break;
				i++;
			}
			while(array[j]>=value){
				if(j==low) break;
				j--;
			}
			if(i>=j) break;
			swap(array,i,j);
		}
		
		swap(array,low,j);
		for(int num : array)
		{
			System.out.print(num+" ");
		}
		System.out.println();
		return j;
		
	}
	
	public static void  quickSort(int[] array,int low, int high){
		if(high <= low) return;
		int j=partition(array, low, high);
		quickSort(array,low,j-1);
		quickSort(array,j+1,high);
	}
	
	//swap
	public static void swap(int array[],int a, int b){
		if(a != b){
			int temp = array [b];
			array[b] = array[a];
			array[a] = temp;
		}
	} 
	
	
	
	
	/*
	
	public static int[] quickSort(int[] array) {
		return quickSortTmp(array, 0, array.length - 1);
	}
	
	public static int[] quickSortTmp(int[] array, int low, int high) {
		  if (low < high) {
		   int division = partition(array, low, high);
		   quickSortTmp(array, low, division - 1);
		   quickSortTmp(array, division + 1, high);
		  }
		  return array;
		 }
	 public static void swap(int[] array, int a, int b) {
		  if (a != b) {
		   int temp = array[a];
		   array[a] = array[b];
		   array[b] = temp;
		  }
		 }
		 
	
	private static int mark = 0;
	 
	public static int partition(int array[], int low, int high) {
		
		int i=low,j=high+1;
		int base = array[low];
		  mark++;		  
		  while (true) {

		   while (array[++i] <= base) {
			   if(i==high) break;
			   System.out.println("从左往右找比" + base + "小的，指针变动：" + low + "-" + high);
		   }
		   while (array[--j] >= base) {
			   if(j==low) break;
			   System.out.println("从右往左找比" + base + "大的，指针变动：" + low + "-" + high);
		   }
		   if(i>=j) break;
		   
		   swap(array, i, j);
		   
		  }
		  swap(array, low, j);
		  
		  System.out.println("正在进行第" + mark + "轮分隔：");
		   for (int n : array) {
			    System.out.print(n + " ");
			   }
		   System.out.println();
		 
		   return j;
		  

		 }*/
	
	
	
	
	
	
//这是尾线	
}

