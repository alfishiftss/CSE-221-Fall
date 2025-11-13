import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class tree220 {
    static int preidx = 0;
    static StringBuilder sb = new StringBuilder();

    static void buildpo(int[] ino, int[] pre, int st, int end, Map<Integer,Integer> inoidx ){

        if( st > end){
            return;
        }
        int rootval = pre[preidx++];
        int mid = inoidx.get(rootval);
        buildpo(ino,pre,st,mid-1,inoidx);
        buildpo(ino,pre,mid+1,end,inoidx);
        sb.append(rootval).append(" ");
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] inor = br.readLine().split(" ");
        String [] prior = br.readLine().split(" ");
        int [] ine = new int[n];
        int [] pre = new int[n];

        for(int i=0; i<n; i++){
            ine[i] = Integer.parseInt(inor[i]);
            pre[i] = Integer.parseInt(prior[i]);
        }

        Map<Integer, Integer> inoidx = new HashMap<>();
        for( int i=0; i<n; i++){
            inoidx.put(ine[i],i);

        }
        buildpo(ine,pre,0,n-1,inoidx);
        System.out.println(sb.toString().trim());


    }
}
