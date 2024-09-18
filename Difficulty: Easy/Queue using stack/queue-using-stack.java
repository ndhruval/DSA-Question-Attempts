//{ Driver Code Starts
import java.util.*;


class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queue g = new Queue();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.enqueue(a);
				}
				else if(QueryType == 2)
				System.out.print(g.dequeue()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		}
	}
}


// } Driver Code Ends


class Queue
{
    Stack<Integer> input = new Stack<Integer>(); 
    Stack<Integer> output = new Stack<Integer>(); 
    
    /*The method pop whiclement poped out of the stack*/
    int dequeue()
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
	
    /* The method push to push element into the stack */
    void enqueue(int x)
    {
	    input.push(x);
    }
}

