package q1;
import java.io.*;

public class ancientF {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());
        Integer[] a = new Integer[N];
        String[] input = br.readLine().split(" ");


        //Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(input[i]);
        }



//        for( int i=0; i<N-1; i++){
//            if( a[i]%2==0 && a[i+1]%2==0 && a[i]>a[i+1]){
//                Integer store = a[i];
//                a[i] = a[i+1];
//                a[i+1] = store;
//            }else if(a[i]%2!=0 && a[i+1]%2!=0 && a[i]>a[i+1]){
//                Integer store = a[i];
//                a[i] = a[i+1];
//                a[i+1] = store;
//            }else{
//
//            }
//        }
//
//        for( int i=N-1; i>0; i--){
//            if( a[i]%2==0 && a[i-1]%2==0 && a[i]<a[i-1]){
//                Integer store = a[i];
//                a[i] = a[i-1];
//                a[i-1] = store;
//            }else if(a[i]%2!=0 && a[i-1]%2!=0 && a[i]<a[i-1]){
//                Integer store = a[i];
//                a[i] = a[i-1];
//                a[i-1] = store;
//            }else{
//
//            }
//        }

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < N - 1; i++) {
                if (a[i] % 2 == a[i + 1] % 2 && a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
        }


        for( int i=0; i<N; i++ ){
            System.out.print(a[i] + " ");
        }
        br.close();
    }
}
