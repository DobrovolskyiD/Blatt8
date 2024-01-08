import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciBigInteger {
    // Iterative Berechnung der Fibonacci-Folge mit BigInteger
    public static BigInteger fibonacciIter(int n) {
        if (n <= 1) return BigInteger.valueOf(n);

        BigInteger prev1 = BigInteger.ZERO;
        BigInteger prev2 = BigInteger.ONE;
        BigInteger result = BigInteger.ZERO;

        for (int i = 2; i <= n; i++) {
            result = prev1.add(prev2);
            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }

    // Rekursive Berechnung der Fibonacci-Folge mit BigInteger
    public static BigInteger fibonacciRec(int n) {
        if (n <= 1) return BigInteger.valueOf(n);
        return fibonacciRec(n - 1).add(fibonacciRec(n - 2));
    }

    // Rekursive Berechnung der Fibonacci-Folge mit BigInteger und Cache
    public static BigInteger fibonacciRecCache(int n, BigInteger[] cache) {
        if (n <= 1) return BigInteger.valueOf(n);
        if (cache[n] != null) return cache[n];

        BigInteger result = fibonacciRecCache(n - 1, cache).add(fibonacciRecCache(n - 2, cache));
        cache[n] = result;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geben Sie einen Wert für n ein: ");
        int n = scanner.nextInt();

        // Iterative Berechnung
        long startTimeIter = System.nanoTime();
        BigInteger resultIter = fibonacciIter(n);
        long endTimeIter = System.nanoTime();
        double durationIter = (endTimeIter - startTimeIter) / 1_000_000.0;

        System.out.println("Iterative Fibonacci: " + resultIter);
        System.out.printf("Laufzeit (iterativ): %.3f ms%n", durationIter);

        // Rekursive Berechnung
        long startTimeRec = System.nanoTime();
        BigInteger resultRec = fibonacciRec(n);
        long endTimeRec = System.nanoTime();
        double durationRec = (endTimeRec - startTimeRec) / 1_000_000.0;

        System.out.println("Rekursive Fibonacci: " + resultRec);
        System.out.printf("Laufzeit (rekursiv): %.3f ms%n", durationRec);

        // Rekursive Berechnung mit Cache
        long startTimeRecCache = System.nanoTime();
        BigInteger[] cache = new BigInteger[n + 1];
        BigInteger resultRecCache = fibonacciRecCache(n, cache);
        long endTimeRecCache = System.nanoTime();
        double durationRecCache = (endTimeRecCache - startTimeRecCache) / 1_000_000.0;

        System.out.println("Rekursive Fibonacci mit Cache: " + resultRecCache);
        System.out.printf("Laufzeit (rekursiv mit Cache): %.3f ms%n", durationRecCache);
    }
}
