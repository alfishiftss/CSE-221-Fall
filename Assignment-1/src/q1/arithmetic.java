package q1;
import java.io.*;

public class arithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        Double sum;

        for( int i=0; i<T; i++){
            String s = br.readLine();

            s = s.replace("calculate", "").trim();
            String [] parts = s.split(" ");
            double a = Double.parseDouble(parts[0]);
            String operator = parts[1];
            double b = Double.parseDouble(parts[2]);

            if(operator.equals("+")){
                sum = a+b;
                System.out.printf("%.6f\n", sum);
            }else if(operator.equals("-")){
                sum = a-b;
                System.out.printf("%.6f\n", sum);
            }else if(operator.equals("*")){
                sum = a*b;
                System.out.printf("%.6f\n", sum);
            }else if( operator.equals("/")){
                sum = a/b;
                System.out.printf("%.6f\n", sum);
            }
        }
    }
}