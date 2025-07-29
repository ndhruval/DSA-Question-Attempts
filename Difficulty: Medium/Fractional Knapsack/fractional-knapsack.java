class Data{
    int v, w;
    double ratio;
    Data(int v, int w, double ratio){
        this.v = v;
        this.w = w;
        this.ratio = ratio;
    }
}
class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int W) {
        Data[] arr = new Data[values.length];
        int n= values.length;
        for(int i =0;i<n;i++){
            double ratio = (double) values[i] / weights[i];
            arr[i] = new Data(values[i], weights[i], ratio);
        }
        Arrays.sort(arr, (a, b) -> Double.compare(b.ratio, a.ratio));
        
        Double profit =0.0;
        int curr_weight =0;
        for(int i=0;i<n;i++){
            if (curr_weight + arr[i].w <= W) {
                curr_weight += arr[i].w;
                profit += arr[i].v;
            }
            else {
                int remain = W - curr_weight;
                profit += arr[i].ratio * remain;
                break;
            }
        }
        return Math.round(profit * 1e6) / 1e6;

        // code here
        
    }
}