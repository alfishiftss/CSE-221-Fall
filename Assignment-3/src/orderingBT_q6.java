import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class orderingBT_q6 {

    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String [] num = br.readLine().split(" ");
        int [] arr = new int[n];

        for(int i=0; i<n; i++){
           arr[i] = Integer.parseInt(num[i]);
        }

        buildOrder(arr, 0, n-1);

        System.out.println(sb.toString().trim());

    }
    static void buildOrder(int arr[] , int l, int h){

        if( l > h){
            return;
        }
        int mid = (l+h) /2;
        sb.append(arr[mid]).append(" ");
        buildOrder(arr,l,mid-1);
        buildOrder(arr,mid+1,h);

    }
}
