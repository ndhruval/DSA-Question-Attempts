
class MyQueue 
{
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    

    public MyQueue() 
    {
        
    }
    
    public void push(int x) 
    {
        input.push(x);
        
    }
    
    public int pop() 
    {
        int x;
        if(!output.isEmpty())
        x=output.pop();
        else
        {
            while(!input.isEmpty())
            {
                output.push(input.pop());

            }
            x =output.pop();
        }
        return x;
        
    }
    
    public int peek() 
    {
        int x;
        if(!output.isEmpty())
         x=output.peek();
        else
        {
            while(!input.isEmpty())
            {
                output.push(input.pop());

            }
             x =output.peek();
        }
        return x;
        
    }
    
    public boolean empty() 
    {
        if(input.isEmpty() && output.isEmpty())
        return true;
        return false;
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */