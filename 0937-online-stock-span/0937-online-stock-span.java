class StockSpanner {
    Deque<int[]> dq;

    public StockSpanner() {
        dq = new ArrayDeque<>();
        
    }
    
    public int next(int price) 
    {
        int span =1;
        while(dq.size()>0 && dq.peek()[0]<= price)
        {
            span += dq.pop()[1];
        }
        dq.push(new int[] {price, span});
        return span;

        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */