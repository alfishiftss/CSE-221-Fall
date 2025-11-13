package CF2;
import java.io.*;
import java.util.*;

public class revisitedSum_q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        long k = Long.parseLong(first[2]);

        long[] A = new long[n];
        long[] B = new long[m];

        String[] aStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) A[i] = Long.parseLong(aStr[i]);

        String[] bStr = br.readLine().split(" ");
        for (int j = 0; j < m; j++) B[j] = Long.parseLong(bStr[j]);

        int i = 0;
        int j = m - 1;
        long bestDiff = Long.MAX_VALUE;
        int bestI = 1, bestJ = 1; // store 1-based indices

        while (i < n && j >= 0) {
            long sum = A[i] + B[j];
            long diff = Math.abs(sum - k);

            if (diff < bestDiff) {
                bestDiff = diff;
                bestI = i + 1;
                bestJ = j + 1;
            }

            // Move pointers smartly
            if (sum > k) j--;
            else i++;
        }

        System.out.println(bestI + " " + bestJ);
    }
}