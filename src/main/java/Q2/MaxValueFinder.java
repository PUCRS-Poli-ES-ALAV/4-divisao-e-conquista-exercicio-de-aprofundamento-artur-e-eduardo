import java.util.Random;

public class MaxValueFinder {
    private static int iterations = 0;

    public static long maxVal1(long[] A, int n) {
        long max = A[0];
        for (int i = 1; i < n; i++) {
            iterations++;
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

    public static void runTest(int size) {
        Random random = new Random();
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextLong();
        }
        
        iterations = 0;
        long startTime = System.nanoTime();
        long max = maxVal1(arr, size);
        long endTime = System.nanoTime();
        
        System.out.println("Tamanho: " + size);
        System.out.println("Iterações: " + iterations);
        System.out.println("Maior valor: " + max);
        System.out.println("Tempo: " + (endTime - startTime) / 1e9 + " segundos\n");
    }

    public static void main(String[] args) {
        int[] sizes = {32, 2048, 1048576};
        for (int size : sizes) {
            runTest(size);
        }
    }
}
