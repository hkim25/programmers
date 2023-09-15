package snippet.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort instance = new BubbleSort();
        int[] arr = {1,4,6,2,8,12,15,18,6,39,25,66,89};
        instance.bubbleSortAsc4(arr);
        System.out.println(Arrays.toString(arr));
    }
    private void swap(int[] arr, int n, int m){
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }
    private void bubbleSortAsc1(int[] arr){
        int compareCount = 0;
        for(int i=arr.length; i>=0; i--){
            for(int j=0; j<i-1; j++){
                compareCount++;
                if(arr[j]>arr[j+1])swap(arr,j,j+1);
            }
        }
        System.out.println(compareCount);
    }
    private void bubbleSortAsc2(int[] arr){
        int compareCount = 0;
        for(int i=arr.length; i>=0; i--){
            int swapCount = 0;
            for(int j=0; j<i-1; j++){
                compareCount++;
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swapCount++;
                }
            }
            if(swapCount==0)break;
        }
        System.out.println(compareCount);
    }
    private void bubbleSortAsc3(int[] arr){
        int compareCount = 0;
        int k = 0;
        for(int i=arr.length; i>=0; i--){
            int swapCount = 0;
            for(int j=k; j<i-1; j++){
                compareCount++;
                if(arr[j]>arr[j+1]){
                    if(swapCount==0&&j!=0)k=j-1;
                    swap(arr,j,j+1);
                    swapCount++;
                }
            }
            if(swapCount==0)break;
        }
        System.out.println(compareCount);
    }

    public void bubbleSortAsc4(int[] arr){
        int compareCount = 0;
        int leftEnd = 0;
        int rightEnd = arr.length-1;
        for(int i=1; leftEnd<rightEnd; i++){
            int swapCount = 0;
            if(i%2!=0){
                for(int j=0; j<rightEnd; j++){
                    compareCount++;
                    if(arr[j]>arr[j+1]){
                        swapCount++;
                        swap(arr,j,j+1);
                    }
                }
                rightEnd--;
            }else{
                for(int j=arr.length-1; j>leftEnd; j--){
                    compareCount++;
                    if(arr[j]<arr[j-1]){
                        swapCount++;
                        swap(arr,j,j-1);
                    }
                }
                leftEnd++;
            }
            if(swapCount==0)break;
        }
        System.out.println(compareCount);
    }
}
