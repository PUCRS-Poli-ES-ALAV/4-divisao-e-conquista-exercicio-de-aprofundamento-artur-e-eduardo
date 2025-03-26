import java.util.Random;

public class MaxValueDivideConquer {
    private static int iterations = 0;

    public static long max(long a, long b) {
        return (a > b) ? a : b;
    }

    public static long maxVal2(long[] A, int init, int end) {
        iterations++;
        if (end - init <= 1) {
            return max(A[init], A[end]);
        } else {
            int m = (init + end) / 2;
            long v1 = maxVal2(A, init, m);
            long v2 = maxVal2(A, m + 1, end);
            return max(v1, v2);
        }
    }

    public static void runTest(int size) {
        Random random = new Random();
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextLong();
        }
        
        iterations = 0;
        long startTime = System.nanoTime();
        long max = maxVal2(arr, 0, size - 1);
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
