import java.util.Random;

public class IntegerMultiplication {
    private static int iterations = 0;

    public static long multiply(long x, long y, int n) {
        iterations++;
        if (n == 1) {
            return x * y;
        } else {
            int m = (int) Math.ceil(n / 2.0);
            long a = x >> m, b = x & ((1L << m) - 1);
            long c = y >> m, d = y & ((1L << m) - 1);
            
            long e = multiply(a, c, m);
            long f = multiply(b, d, m);
            long g = multiply(b, c, m);
            long h = multiply(a, d, m);
            
            return (e << (2 * m)) + ((g + h) << m) + f;
        }
    }

    public static void runTest(int bits) {
        Random random = new Random();
        long x = random.nextLong() & ((1L << bits) - 1);
        long y = random.nextLong() & ((1L << bits) - 1);
        
        iterations = 0;
        long startTime = System.nanoTime();
        long result = multiply(x, y, bits);
        long endTime = System.nanoTime();
        
        System.out.println("Bits: " + bits);
        System.out.println("Iterações: " + iterations);
        System.out.println("Resultado: " + result);
        System.out.println("Tempo: " + (endTime - startTime) / 1e9 + " segundos\n");
    }

    public static void main(String[] args) {
        int[] bitSizes = {4, 16, 64};
        for (int bits : bitSizes) {
            runTest(bits);
        }
    }
}
