package CF2;
import java.io.*;
import java.util.*;

public class twoSum_q1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        Integer N = Integer.parseInt(s[0]);
        Integer tar = Integer.parseInt(s[1]);

        String[] nums = br.readLine().split(" ");
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        boolean found = false;

        //label for breaking outer loops at once
         int left =0;
         int right = N-1;


         while( left<right ){
            long sum = arr[left]+arr[right];
            if( sum==tar){
                System.out.println((left + 1) + " " + (right + 1));
                found = true;
                break;
            }else if( sum< tar){
                left++;
            }else if( sum>tar){
                right--;
            }
         }

         if(!found){
             System.out.println("-1");
         }
        }
    }

