package q1;

import java.io.*;
import java.util.*;

public class tain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Train[] trains = new Train[N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            // Example line: ABCD will departure for Mymensingh at 00:30
            String[] parts = line.split(" ");
            String name = parts[0];
            String time = parts[parts.length - 1]; // the last part is the time (HH:MM)
            trains[i] = new Train(name, time, i, line);
        }

        Arrays.sort(trains, new Comparator<Train>() {
            public int compare(Train a, Train b) {
                // 1️⃣ Compare train names
                int nameCompare = a.name.compareTo(b.name);
                if (nameCompare != 0)
                    return nameCompare;

                // 2️⃣ If same name, compare times (latest first)
                int timeCompare = compareTime(b.time, a.time); // reverse for latest first
                if (timeCompare != 0)
                    return timeCompare;

                // 3️⃣ If both same, keep original input order
                return a.index - b.index;
            }
        });

        // Print output
        for (int i = 0; i < N; i++) {
            System.out.println(trains[i].fullLine);
        }
    }

    // Helper to compare two times in HH:MM format
    static int compareTime(String t1, String t2) {
        String[] p1 = t1.split(":");
        String[] p2 = t2.split(":");
        int h1 = Integer.parseInt(p1[0]);
        int m1 = Integer.parseInt(p1[1]);
        int h2 = Integer.parseInt(p2[0]);
        int m2 = Integer.parseInt(p2[1]);

        if (h1 != h2) return h1 - h2;
        return m1 - m2;
    }

    static class Train {
        String name;
        String time;
        int index;      // input order
        String fullLine;

        Train(String name, String time, int index, String fullLine) {
            this.name = name;
            this.time = time;
            this.index = index;
            this.fullLine = fullLine;
        }
    }
}
