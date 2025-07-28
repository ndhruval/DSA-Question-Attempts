
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
        PriorityQueue<Data> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.end,b.end));
        
        for(int i =0;i<start.length;i++){
            pq.add(new Data(start[i],end[i], i+1));
        }
        
        int count = 1;
        int freeTime = pq.poll().end;
        
        while(!pq.isEmpty()){
            Data node = pq.poll();
            if(node.start > freeTime){
                count++;
                freeTime = node.end;
            }
        }
        return count;
        // add your code here
    }

        
}

