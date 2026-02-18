// Merge Sort technique

import java.util.Scanner;
public class MergeSortDemo{
    public static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }
    public static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        for(int i = 0; i < n1; i++){
            lArr[i] = arr[l + i];
        }
        for(int i = 0; i < n2; i++){
            rArr[i] = arr[mid + 1 + i];
        }

        int i = 0;  // for tracking left array
        int j = 0;  // for right array
        int k = l;  // for main array
        while(i < n1 && j < n2){
            if(lArr[i] < rArr[j]){
                arr[k] = lArr[i];
                i++;
            }
            else{
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = lArr[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array:");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("enter array elements:");
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        
        mergeSort(a, 0, a.length - 1);  // calling mergeSort method

        System.out.println("After Merge Sort:");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}
