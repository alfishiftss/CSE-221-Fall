package CF2;

import java.io.*;
import java.util.*;

public class divisible_q8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            long k = Long.parseLong(input[0]);
            long x = Long.parseLong(input[1]);

            long result = k + (k - 1) / (x - 1);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
