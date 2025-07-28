
class X {
    int time;
    char c;

    X(int time, char c) {
        this.time = time;
        this.c = c;
    }
}

class Solution {
    // Function to find the minimum number of platforms required at the railway station
    static int findPlatform(int arr[], int dep[]) {
        X[] events = new X[arr.length * 2];
        int k = 0;

        // Create events for arrivals and departures
        for (int i = 0; i < arr.length; i++) {
            events[k++] = new X(arr[i], 'A');
            events[k++] = new X(dep[i], 'D');
        }

        // Sort events by time; if times are the same, prioritize arrivals ('A' < 'D')
        Arrays.sort(events, (a, b) -> {
            if (a.time == b.time) {
                return a.c - b.c; // 'A' comes before 'D' if times are equal
            }
            return a.time - b.time;
        });

        int count = 0; // Current platforms needed
        int max = 0;   // Maximum platforms needed

        // Process events
        for (int i = 0; i < events.length; i++) {
            if (events[i].c == 'A') {
                count++; // Arrival needs a platform
            } else {
                count--; // Departure frees a platform
            }
            max = Math.max(max, count); // Update the maximum
        }

        return max;
    }
}
