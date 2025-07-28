


class Data {
    int dead, profit;
    Data(int dead, int profit) {
        this.dead = dead;
        this.profit = profit;
    }
}

class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Data[] jobs = new Data[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Data(deadline[i], profit[i]);
        }

        // Step 1: Sort jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Step 2: Find maximum deadline to create time slots
        int maxDeadline = 0;
        for (Data job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.dead);
        }

        boolean[] slots = new boolean[maxDeadline + 1]; // 1-indexed
        int count = 0, totalProfit = 0;

        // Step 3: Assign jobs greedily
        for (Data job : jobs) {
            for (int j = job.dead; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    count++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(totalProfit);
        return result;
    }
}
