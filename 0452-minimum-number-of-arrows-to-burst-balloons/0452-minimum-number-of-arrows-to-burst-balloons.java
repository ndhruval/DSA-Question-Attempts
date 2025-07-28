class Data {
    int start, end, pos;
    Data(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        Data[] burst = new Data[n];
        for(int i =0;i<n;i++){
            burst[i] = new Data(points[i][0], points[i][1], i+1);
        }
        Arrays.sort(burst, (a,b)-> Integer.compare(a.end, b.end));

        int count =1;
        int Shot = burst[0].end;

        for(int i =1;i<n;i++){
            if(burst[i].start > Shot){
                count ++;
                Shot = burst[i].end;
            }
        }
        return count;

        
    }
}