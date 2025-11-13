package q1;
import java.io.*;
import java.util.ArrayList;

public class reverseSot {

    public static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {

                return false;
            }
        }
        return true;

    }

    public static void reverese3(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i + 2];
        arr[i + 2] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().trim().split(" ");
        int[] array = new int[N];
        ArrayList<int[]> moves = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }
        if (isSorted(array)) {
            System.out.println("YES");
            System.out.println(0);
            return;
        }
        for (int i = 0; i < N - 2; i++) {
            boolean changed = false;
            for (int j = 0; j + 2 < N; j++) {
                if (array[j] > array[j + 1] || array[j] > array[j + 2]) {
                    reverese3(array, j);
                    moves.add(new int[] { j + 1, j + 3 });
                    if (isSorted(array)) {
                        break;
                    }

                    changed = true;
                }
            }
            if (!changed) {
                break;
            }

        }

        if (isSorted(array)) {
            System.out.println("YES");
            System.out.println(moves.size());
            for (int[] op : moves)
                System.out.println(op[0] + " " + op[1]);
        }

        else {
            System.out.println("NO");
        }
    }
}

