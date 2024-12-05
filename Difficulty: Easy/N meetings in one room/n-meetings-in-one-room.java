//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Data {
    int start, end, pos;

    Data(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        int N = start.length;

        // Create an array of Data objects
        Data[] arr = new Data[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Data(start[i], end[i], i + 1);
        }

        // Sort meetings based on their end time
        Arrays.sort(arr, (a, b) -> a.end - b.end);

        int count = 1;          // At least one meeting can always be scheduled
        int freeTime = arr[0].end; // Time when the first meeting ends

        // Iterate through the meetings
        for (int i = 1; i < N; i++) {
            if (arr[i].start > freeTime) { // If the meeting starts after the last one ends
                count++;
                freeTime = arr[i].end; // Update freeTime to the current meeting's end time
            }
        }

        return count;
    }
}

