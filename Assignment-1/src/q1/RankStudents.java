package q1;

import java.io.*;
import java.util.*;

public class RankStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] id = new int[N];
            int[] mark = new int[N];

            String[] idInput = br.readLine().split(" ");
            String[] markInput = br.readLine().split(" ");

            for (int i = 0; i < N; i++) {
                id[i] = Integer.parseInt(idInput[i]);
                mark[i] = Integer.parseInt(markInput[i]);
            }

            // Create a list of pairs (ID, mark, originalIndex)
            Student[] arr = new Student[N];
            for (int i = 0; i < N; i++) {
                arr[i] = new Student(id[i], mark[i], i);
            }

            // Sort by mark DESC, then ID ASC
            Arrays.sort(arr, new Comparator<Student>() {
                public int compare(Student a, Student b) {
                    if (a.mark != b.mark)
                        return b.mark - a.mark; // higher marks first
                    return a.id - b.id; // smaller ID first
                }
            });

            // Count minimum swaps using cycle detection
            int swaps = 0;
            boolean[] visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                if (visited[i] || arr[i].originalIndex == i)
                    continue;

                int cycleSize = 0;
                int j = i;

                while (!visited[j]) {
                    visited[j] = true;
                    j = arr[j].originalIndex;
                    cycleSize++;
                }

                if (cycleSize > 1)
                    swaps += (cycleSize - 1);
            }

            // Print the result
            System.out.println("Minimum swaps: " + swaps);
            for (int i = 0; i < N; i++) {
                System.out.println("ID: " + arr[i].id + " Mark: " + arr[i].mark);
            }
        }
    }

    static class Student {
        int id;
        int mark;
        int originalIndex;

        Student(int id, int mark, int originalIndex) {
            this.id = id;
            this.mark = mark;
            this.originalIndex = originalIndex;
        }
    }
}

