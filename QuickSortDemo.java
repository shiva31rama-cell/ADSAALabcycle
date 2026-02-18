import java.util.Scanner;
class QuickSortDemo{
    static int[] arr;
    static void quickSort(int low, int high){
        if(low < high){
            int j = partition(low, high);
            quickSort(low, j - 1);
            quickSort(j + 1, high);
        }
    }
    static int partition(int low, int high){
        int pivot = arr[low]; // first element as pivot
        int i = low + 1;
        int j = high;

        while(i <= j){
            while(i <= high && arr[i] <= pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i < j){  // --> Swapping of arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // if i and j crosses --> swap(arr[j] and pivot ie., arr[low])
        arr[low] = arr[j];
        arr[j] = pivot;

        return j;
    }
    // Main Method
    public static void main(String[] args){
        arr = new int[] {5, 3, 1, 4, 2, 6};

        System.out.println("Before sorting :");
        for(int ele : arr){
            System.out.print(ele + " ");
        }
        System.out.println();
        // calling quickSort method
        quickSort(0, arr.length - 1);

        System.out.println("after Sorting :");
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
}
