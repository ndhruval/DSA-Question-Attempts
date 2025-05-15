class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int neg =0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<asteroids.length;i++)
        {
            int curr = asteroids[i];
            boolean destroyed = false;

            while(!st.isEmpty() && curr<0 && st.peek()>0)
            {
                if(st.peek()< -curr)
                {
                    st.pop();
                }
                else if(st.peek() == -curr)
                {
                    st.pop();
                    destroyed = true;
                    break;
                }
                else
                {
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed)
            st.push(curr);
        }
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        
        int[] res = new int[ans.size()];
        for(int i =0;i<ans.size();i++)
        {
            res[i]= ans.get(i);
        }
        return res;

        
    }
}