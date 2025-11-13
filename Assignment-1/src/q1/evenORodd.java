package q1;
import java.io.*;

public class evenORodd {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
        Integer num = Integer.parseInt(br.readLine());
            if (num % 2 == 0) {
                System.out.println(num + " is an Even number.");
            } else {
                System.out.println(num + " is an Odd number.");
            }
        }
        br.close();
    }
}
