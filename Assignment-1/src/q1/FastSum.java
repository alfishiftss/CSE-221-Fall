package q1;
import java.io.*;

public class FastSum {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());

        for( int i=0; i<T; i++){
             Long N = Long.parseLong(br.readLine());
             Long sum = (N * (N + 1)) / 2;
            System.out.println(sum);
        }
        br.close();
    }
}
