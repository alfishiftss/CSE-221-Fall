package CF2;
import java.io.*;
import java.util.*;

public class CountTheNums_q7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int q = Integer.parseInt(first[1]);

        long[] arr = new long[n];
        String[] a = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(a[i]);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String[] range = br.readLine().split(" ");
            long x = Long.parseLong(range[0]);
            long y = Long.parseLong(range[1]);

            int left = lowerBound(arr, x);
            int right = upperBound(arr, y);

            sb.append(right - left).append("\n");
        }

        System.out.print(sb);
    }

    static int lowerBound(long[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    static int upperBound(long[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
