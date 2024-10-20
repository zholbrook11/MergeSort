import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter the size of random array to generate:");
        int arrSize = scnr.nextInt();
        int[] randArray = createRandomArray(arrSize);
        System.out.println();
        System.out.println("Your array has been generated.");
        System.out.println();
        System.out.println("Would you like to use BubbleSort (type 'b') or MergeSort (type 'm') ?");
        String userChoice = scnr.next();
        if (userChoice.equalsIgnoreCase("b")){
            System.out.println("Array before sorting:");
            System.out.println(isSorted(randArray));
            long start = System.currentTimeMillis();

            bubbleSort(randArray);

            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) + " ms");
            System.out.println("Array after sorting:");
            System.out.println(isSorted(randArray));

        } else if (userChoice.equalsIgnoreCase("m")){
            System.out.println("Array before sorting:");
            System.out.println(isSorted(randArray));
            long start = System.currentTimeMillis();

            mergeSort(randArray, 0, randArray.length - 1);

            long end = System.currentTimeMillis();
            System.out.println("Time taken: " + (end - start) + " ms");
            System.out.println("Array after sorting:");
            System.out.println(isSorted(randArray));
        } else{
            System.out.println("Invalid option.");
        }
        scnr.close();
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArr[j] = arr[mid + 1 + j];


        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static boolean isSorted(int[] array) {
        for (int i=0; i < array.length - 1; i++){
            if (array[i] > array[i+1]){
                return false;
            }     
        }
        return true;
    }

    public static int[] createRandomArray(int arrayLength) {
        Random rand = new Random();
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = rand.nextInt(101);
        }
        return randomArray;
    }  
}
