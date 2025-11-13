package q1;
import java.io.*;
public class isSorted {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Integer N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            Integer[] arr = new Integer[N];

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }

            boolean sorted = true;

            for (int K = 0;  K< N - 1; K++) {
                if (arr[K] > arr[K + 1]) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
