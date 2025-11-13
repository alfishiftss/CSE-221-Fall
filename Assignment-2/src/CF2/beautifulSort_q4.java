package CF2;
import java.io.*;
import java.util.*;

public class beautifulSort_q4 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] narr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            narr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] marr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            marr[i] = Integer.parseInt(st.nextToken());
        }

        Integer [] fums = new Integer[n+m];

        int no = 0;
        int mo = 0;
        int fo= 0 ;
        while ( no<n && mo<m ){

            if(narr[no] <= marr[mo] ){
                fums[fo] = narr[no];
                fo++;

                no++;

            }else  {
                fums[fo] = marr[mo];
                fo++;
                mo++;
            }

        }
        while( no< n ){
            fums[fo] = narr[no];
            fo++;
            no++;
        }

        while( mo< m){
            fums[fo] = marr[mo];
            fo++;
            mo++;
        }
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < fums.length; x++) {
            sb.append(fums[x]).append(" ");
        }
        System.out.println(sb.toString());

    }
}
