import java.util.Random;
import java.util.Arrays;

public class MergeSort {
    private static int iterations = 0;

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            iterations++;
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            result[k++] = left[i++];
        }
        
        while (j < right.length) {
            result[k++] = right[j++];
        }
        
        return result;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        
        return merge(mergeSort(left), mergeSort(right));
    }

    public static void runTest(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000000);
        }
        
        iterations = 0;
        long startTime = System.nanoTime();
        int[] sortedArr = mergeSort(arr);
        long endTime = System.nanoTime();
        
        System.out.println("Tamanho: " + size);
        System.out.println("Iterações: " + iterations);
        System.out.println("Tempo: " + (endTime - startTime) / 1e9 + " segundos\n");
    }

    public static void main(String[] args) {
        int[] sizes = {32, 2048, 1048576};
        for (int size : sizes) {
            runTest(size);
        }
    }
}
