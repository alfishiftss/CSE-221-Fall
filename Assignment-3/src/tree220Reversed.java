import java.io.*;
import java.util.*;

public class tree220Reversed {
    static int postIdx;

    // returns preorder list for subtree covering inorder[inL..inR]
    static List<Integer> buildPre(int[] inorder, int[] postorder, int inL, int inR, Map<Integer,Integer> inPos) {
        List<Integer> res = new ArrayList<>();
        if (inL > inR) return res;

        // root from postorder (consume from right)
        int root = postorder[postIdx--];
        int mid = inPos.get(root);

        // consume right subtree first (so postIdx moves correctly)
        List<Integer> rightPre = buildPre(inorder, postorder, mid + 1, inR, inPos);
        // then consume left subtree
        List<Integer> leftPre  = buildPre(inorder, postorder, inL, mid - 1, inPos);

        // preorder = root, then left, then right
        res.add(root);
        res.addAll(leftPre);
        res.addAll(rightPre);
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] inorder = new int[n];
        int[] postorder = new int[n];

        String[] inTok = br.readLine().trim().split("\\s+");
        String[] postTok = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(inTok[i]);
            postorder[i] = Integer.parseInt(postTok[i]);
        }

        Map<Integer,Integer> inPos = new HashMap<>();
        for (int i = 0; i < n; i++) inPos.put(inorder[i], i);

        postIdx = n - 1;
        List<Integer> preorder = buildPre(inorder, postorder, 0, n - 1, inPos);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < preorder.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(preorder.get(i));
        }
        System.out.println(sb.toString());
    }
}
