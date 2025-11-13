import java.io.IOException;
import java.io.*;
import java.math.BigInteger;

public class FstPowerDrift_q3 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] nums = br.readLine().split(" ");


        BigInteger A = new BigInteger(nums[0]);
        BigInteger B = new BigInteger(nums[1]);
        BigInteger C = new BigInteger("107");
        BigInteger result = A.modPow(B, C);

        System.out.println(result);
    }
}
