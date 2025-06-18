class Pair{
    String word;
    int steps;

    Pair(String w, int p)
    {
        this.word = w;
        this.steps = p;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<>();

        int n= wordList.size();

        for(int i=0;i<n;i++)
        {
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        while(!q.isEmpty())
        {
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.remove();
            if(word.equals(endWord)== true)
            return steps;

            for(int i=0;i<word.length();i++)
            {
                for(char ch ='a';ch<='z';ch++)
                {
                    char[] arr = word.toCharArray();
                    arr[i]=ch;
                    String s = new String(arr);

                    if(st.contains(s)== true)
                    {
                        st.remove(s);
                        q.add(new Pair(s, steps+1));
                    }
                }
            }
        }
            return 0;



        
    }
}