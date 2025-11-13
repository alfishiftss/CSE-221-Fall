import java.io.IOException;
import java.io.*;

public class FastMatrixDrift {

    static final long MOD = 1000000007;

    static long[] multiply(long a11, long a12, long a21, long a22,
                           long b11, long b12, long b21, long b22){

        long c11 = (a11 * b11 + a12 * b21) % MOD;
        long c12 = (a11 * b12 + a12 * b22) % MOD;
        long c21 = (a21 * b11 + a22 * b21) % MOD;
        long c22 = (a21 * b12 + a22 * b22) % MOD;
        return new long[]{c11, c12, c21, c22};

    }

    static long[] power( long a11, long a12, long a21, long a22, long p){
        if( p == 1){
            return new long[]{a11,a12,a21,a22};
        }
        long[] half = power(a11,a12,a21,a22,p/2);
        long[] full = multiply(half[0], half[1], half[2], half[3],
                half[0], half[1], half[2], half[3]);

        if( p %2 == 1){
            full = multiply(full[0], full[1], full[2], full[3], a11, a12, a21, a22);

        }
        return full;
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine());
        for( int i=0; i<t; i++){

            String [] nums = br.readLine().split(" ");
            long a11 =Long.parseLong(nums[0]);
            long a12 = Long.parseLong(nums[1]);
            long b21 = Long.parseLong(nums[2]);
            long b22 = Long.parseLong(nums[3]);

            long mul = Long.parseLong(br.readLine());

            long[] result = power(a11, a12, b21, b22,mul);

            System.out.println(result[0] + " " + result[1]);
            System.out.println(result[2] + " " + result[3]);

        }

    }
}
