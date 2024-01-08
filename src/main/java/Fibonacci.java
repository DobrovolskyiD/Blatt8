import java.util.Scanner;

public class Fibonacci {
    // Iterative Berechnung der Fibonacci-Folge
    public static int fibonacciIter(int n) {
        if (n <= 1) return n;

        int prev1 = 0;
        int prev2 = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }

    // Rekursive Berechnung der Fibonacci-Folge
    public static int fibonacciRec(int n) {
        if (n <= 1) return n;
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geben Sie einen Wert für n ein: ");
        int n = scanner.nextInt();

        // Iterative Berechnung mit Zeitmessung
        long startTimeIter = System.nanoTime();
        int resultIter = fibonacciIter(n);
        long endTimeIter = System.nanoTime();
        double durationIter = (endTimeIter - startTimeIter) / 1_000_000.0;

        System.out.println("Iterative Fibonacci: " + resultIter);
        System.out.printf("Laufzeit (iterativ): %.3f ms%n", durationIter);

        // Rekursive Berechnung mit Zeitmessung
        long startTimeRec = System.nanoTime();
        int resultRec = fibonacciRec(n);
        long endTimeRec = System.nanoTime();
        double durationRec = (endTimeRec - startTimeRec) / 1_000_000.0;

        System.out.println("Rekursive Fibonacci: " + resultRec);
        System.out.printf("Laufzeit (rekursiv): %.3f ms%n", durationRec);
    }
}

