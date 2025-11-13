package CF2;
import java.io.*;
import java.util.*;

public class longestSubArray_q5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        long k = Long.parseLong(s[1]);

        String[] nums = br.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(nums[i]);
        }

        long sum = 0;
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
