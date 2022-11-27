package Tarea_Ordenamiento;

import java.util.*;

public class Main {
	
	// -------- METODO BURBUJA --------
	
	// Algoritmo Ordenamiento Burbuja
	public void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
        	for (int j = 0; j < n - i - 1; j++){
        		 if (arr[j] > arr[j + 1]) {
                     
                     int temp = arr[j];
                     arr[j] = arr[j + 1];
                     arr[j + 1] = temp;
        		 }
        	} 
        }
        //imprimirArray(arr);
    }
	
	// -------- METODO QUICKSORT --------
	
	// A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high)
    {
  
        // pivot
        int pivot = arr[high];
  
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
  
        for (int j = low; j <= high - 1; j++) {
  
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
  
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
  
    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
  
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
  
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    // -------- ShellSort --------
    
    int sort(int arr[])
    {
        int n = arr.length;
 
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];
 
                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
 
                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }
    
    // -------- RadixSort --------
    
 // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of
    // size n using Radix Sort
    void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    
    // -------- MergeSort --------
    
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    // -------- MergeSort --------
    
    static void swapDualPivot(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     
    void dualPivotQuickSort(int[] arr,
                                   int low, int high)
    {
        if (low < high)
        {
             
            // piv[] stores left pivot and right pivot.
            // piv[0] means left pivot and
            // piv[1] means right pivot
            int[] piv;
            piv = partitionDualPivot(arr, low, high);
             
            dualPivotQuickSort(arr, low, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, high);
        }
    }
     
    static int[] partitionDualPivot(int[] arr, int low, int high)
    {
        if (arr[low] > arr[high])
            swap(arr, low, high);
             
        // p is the left pivot, and q
        // is the right pivot.
        int j = low + 1;
        int g = high - 1, k = low + 1,
            p = arr[low], q = arr[high];
             
        while (k <= g)
        {
             
            // If elements are less than the left pivot
            if (arr[k] < p)
            {
                swap(arr, k, j);
                j++;
            }
             
            // If elements are greater than or equal
            // to the right pivot
            else if (arr[k] >= q)
            {
                while (arr[g] > q && k < g)
                    g--;
                     
                swap(arr, k, g);
                g--;
                 
                if (arr[k] < p)
                {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;
         
        // Bring pivots to their appropriate positions.
        swap(arr, low, j);
        swap(arr, high, g);
     
        // Returning the indices of the pivots
        // because we cannot return two elements
        // from a function, we do that using an array.
        return new int[] { j, g };
    }
    
   // -------- FINALIZACION --------
    
   // Metodo imprimir Array
   public void imprimirArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
   // Metodo generador de Array
   public int[] generadorArray(int []array)
   {
	   for(int x = 0; x <array.length; x++)
	   {
		   int numero = (int)(Math.random()*array.length+1);		
		   array[x] = numero;
	   }
	   return array;
   }
   
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		Main m = new Main();
		int op1= 0,op2 = 0;
		
		long inicio = 0, fin = 0, tiempo = 0;
		
		System.out.println("-- METODOS DE ORDENAMIENTO --");
		System.out.println("");
		System.out.print("Longitud de arreglo: ");
		op1 = sc.nextInt();
		int array[] = new int[op1];
		m.generadorArray(array);
		m.imprimirArray(array);
		
		System.out.println("");
		System.out.println("1- Bubble Sort");
		System.out.println("2- Quick Sort");
		System.out.println("3- Shell Sort");
		System.out.println("4- Radix Sort");
		System.out.println("5- Merge Sort");
		System.out.println("6- Dual-Pivot Quick Sort");
		System.out.println("");
		System.out.print("Algoritmo: ");
		op2 = sc.nextInt();
		
		System.out.println("Arreglo sin ordenar: ");
		m.imprimirArray(array);
		System.out.println("");
		System.out.println("Arreglo ordenado: ");
		switch(op2)
		{
			case 1:
				inicio = System.currentTimeMillis();
				
				m.bubbleSort(array);
				m.imprimirArray(array);
				fin = System.currentTimeMillis();
			        
			    tiempo = (fin-inicio);
			        
			    System.out.println("Tiempo: "+tiempo);
				break;
			case 2:
				inicio = System.currentTimeMillis();
				
				m.quickSort(array, 0, array.length - 1);
				//m.imprimirArray(array);
				
				fin = System.currentTimeMillis();
		        
			    tiempo = ((fin-inicio));
			        
			    System.out.println("Tiempo: "+tiempo);
				break;
			case 3:
				inicio = System.currentTimeMillis();
				
				m.sort(array);
				//m.imprimirArray(array);
				
				fin = System.currentTimeMillis();
				
				tiempo = ((fin-inicio));
			        
				System.out.println("Tiempo: "+tiempo);
				break;
			case 4:
				inicio = System.currentTimeMillis();
				
				m.radixsort(array, array.length);
				//m.imprimirArray(array);
				
				fin = System.currentTimeMillis();
				
				tiempo = ((fin-inicio));
			        
				System.out.println("Tiempo: "+tiempo);
				break;
			case 5:
				inicio = System.currentTimeMillis();
				
				m.sort(array, 0, array.length - 1);
				//m.imprimirArray(array);
				
				fin = System.currentTimeMillis();
				
				tiempo = ((fin-inicio));
			        
				System.out.println("Tiempo: "+tiempo);
				break;
			case 6:
				inicio = System.currentTimeMillis();
				
				m.dualPivotQuickSort(array, 0, array.length - 1);
				//m.imprimirArray(array);
				
				fin = System.currentTimeMillis();
				
				tiempo = ((fin-inicio));
			        
				System.out.println("Tiempo: "+tiempo);
				break;
			default: System.out.println("Opcion incorrecta");
		}	
	}
}