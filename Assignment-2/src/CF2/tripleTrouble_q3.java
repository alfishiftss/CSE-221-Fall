package CF2;
    import java.io.*;
    import java.util.*;

    public class tripleTrouble_q3 {

        static class pair{
            long val;
            long idx;
            pair(long val, long idx){
                this.val = val;
                this.idx = idx;
            }
        }
        public static void main(String[] args)throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String [] s = br.readLine().split(" ");
         int n = Integer.parseInt(s[0]);
         long tar = Long.parseLong(s[1]);
         String [] nums = br.readLine().split(" ");
         pair [] arr = new pair[n];
         for( Integer i=0; i<n; i++){
             arr[i] = new pair(Long.parseLong(nums[i]),i+1);
         }
         Arrays.sort(arr, Comparator.comparingLong(p -> p.val));


          for( Integer i=0; i<n ; i++){
              Integer left = i+1;
              Integer right = n-1;
              while ( left < right ) {
                  long sum = arr[i].val + arr[left].val + arr[right].val;

                  if (sum == tar) {
                      System.out.println(arr[i].idx + " " + arr[left].idx + " " + arr[right].idx);
                      return;
                  } else if (sum < tar) {
                      left++;
                  } else   {
                      right--;
                  }
              }
          }
            System.out.println(-1);

        }
    }
