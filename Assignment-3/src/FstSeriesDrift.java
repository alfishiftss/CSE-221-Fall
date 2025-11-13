import java.io.IOException;
//import java.io.*;
import java.math.BigInteger;

//public class FstSeriesDrift {
//
//    static long modPO(long base, long exponential, long mod) {
//
//        if (exponential == 0) {
//            return 1;
//        }
//        long half = modPO(base, exponential / 2, mod);
//        long full = ((half * half) % mod);
//
//        if (exponential % 2 == 1) {
//            full = (full * base) % mod;
//        }
//        return full;
//    }
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int t = Integer.parseInt(br.readLine());
//        for (int i = 0; i < t; i++) {
//            String[] nums = br.readLine().split(" ");
//
//            long a = Long.parseLong(nums[0]);
//            long n = Long.parseLong(nums[1]);
//            long m = Long.parseLong(nums[2]);
//
//            long res = modPO(a, n, m);
//
//            System.out.println(res);
//        }
//    }
//}

import java.io.*;

public class FstSeriesDrift {

    static long modPow(long a, long n, long m) {
        long res = 1;
        a %= m;
        while (n > 0) {
            if ((n & 1) == 1)
                res = (res * a) % m;
            a = (a * a) % m;
            n >>= 1;
        }
        return res;
    }

    static long seriesSum(long a, long n, long m) {
        if (n == 1) return a % m;
        if (n % 2 == 0) {
            long half = seriesSum(a, n / 2, m);
            long aHalf = modPow(a, n / 2, m);
            return (half * (1 + aHalf) % m) % m;
        } else {
            long prev = seriesSum(a, n - 1, m);
            long term = modPow(a, n, m);
            return (prev + term) % m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] nums = br.readLine().split(" ");
            long a = Long.parseLong(nums[0]);
            long n = Long.parseLong(nums[1]);
            long m = Long.parseLong(nums[2]);

            if (a == 1) sb.append(n % m).append("\n");
            else sb.append(seriesSum(a, n, m)).append("\n");
        }

        System.out.print(sb);
    }
}

