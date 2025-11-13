import java.io.IOException;
import java.io.*;

public class InversionCount_q1 {

    public static void printA(int [] array){
        for( int i=0; i<array.length; i++){
            System.out.print(array[i] +" ");
        }
    }

    public  static long mergeSort(int[] a, int l, int h){
        long count = 0;
        int mid = (l+h)/2;

        if(  l >= h){ // In merge sort, the recursion should stop when the subarray has 1 or 0 elements
            return 0;
        }
        count += mergeSort(a,l,mid);
        count += mergeSort(a,mid+1,h);
        count += merge(a,l,mid,h);
        return count;

    }

    public static long merge( int[] ar, int low, int mid, int high){
        int [] temp = new int[high-low+1];
        int i = low;   // for left sorted array
        int j = mid+1;  // for right sorted array
        int k = 0;     //for temp
        long count = 0; //for inversion count;
        while( i<= mid && j<=high ){
            if( ar[i] < ar[j] ){
                temp[k] = ar[i];
                i++;
            }else{
                temp[k] = ar[j];
                j++;
                count  += (mid-i+1);
            }
            k++;
        }

        while( i <= mid ){
            temp[k++] = ar[i++];
        }
        while( j<= high ){
            temp[k++] = ar[j++];
        }
        for( k=0, i=low; k<temp.length; k++, i++){
            ar[i] = temp[k];
        }
        return count;

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        String [] nums = br.readLine().split(" ");
        for( int i=0; i<n; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }


        //static int c =0;

        //Now the inversion counting part

        long inver = mergeSort(arr, 0, n-1);
        System.out.println(inver);
        //System.out.println();
        printA(arr);
    }
}
