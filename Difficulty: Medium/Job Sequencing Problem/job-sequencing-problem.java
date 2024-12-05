//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            // size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            // adding id, deadline, profit
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Job(Integer.parseInt(inputLine[k++]),
                                 Integer.parseInt(inputLine[k++]),
                                 Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            // function call
            ArrayList<Integer> res = ob.JobScheduling(arr, n);
            System.out.println(res.get(0) + " " + res.get(1));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
*/

class Solution 
{
    // Function to find the maximum profit and the number of jobs done.
    ArrayList<Integer> JobScheduling(Job jobs[], int n) 
    {
        // Sort jobs based on their profit in descending order
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int total = 0, count = 0, maxDeadLine = -1;

        // Find the maximum deadline
        for (int i = 0; i < n; i++) {
            maxDeadLine = Math.max(maxDeadLine, jobs[i].deadline);
        }

        // Create an array to track occupied slots (1-based indexing)
        int[] a = new int[maxDeadLine + 1];
        Arrays.fill(a, -1); // -1 indicates a free slot

        // Iterate through all jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for the current job, starting from its deadline
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (a[j] == -1) { // Slot is free
                    count += 1;      // Increment the job count
                    a[j] = jobs[i].id; // Assign this job to the slot
                    total += jobs[i].profit; // Add profit
                    break;
                }
            }
        }

        // Create the result list
        ArrayList<Integer> result = new ArrayList<>();
        result.add(count); // Number of jobs done
        result.add(total); // Total profit

        return result;
    }
}
