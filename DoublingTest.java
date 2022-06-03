import java.util.*;
public class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = (int)(Math.random() * MAX);
        Stopwatch s = new Stopwatch();
        for (int i = 0; i < N; i++) {
            // your code.
            HeapSort.minSort(a);
            // MergeSort.sort(a);
        }
        return s.elapsedTime();
    }

    public static void doubleingRatio() {
        double prev = timeTrial(125);
        for (int N = 250; true; N += N)
        {
            double time = timeTrial(N);
            System.out.printf("%6d %7.1f ", N, time);
            System.out.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
