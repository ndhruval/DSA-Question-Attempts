class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort by units per box (descending order)
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        for (int[] box : boxTypes) {
            int boxesToTake = Math.min(truckSize, box[0]);
            totalUnits += boxesToTake * box[1];
            truckSize -= boxesToTake;
            if (truckSize == 0) break;
        }

        return totalUnits;
    }
}
