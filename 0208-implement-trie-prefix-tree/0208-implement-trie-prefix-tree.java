class Trie 
{
    class Node
    {
        Node[] children;
        boolean flag;

        public Node()
        {
            children = new Node[26];
            for(int i=0;i<26;i++)
            {
                children[i] = null;
            }
            flag = false;
        }
    }
    Node curr = new Node();
    
    
    

    public Trie() {
        
    }
    
    public void insert(String word) 
    {
        Node root = curr;
        for(int i=0;i<word.length(); i++)
        {
            int idx = word.charAt(i) - 'a';

            if(root.children[idx] == null)
            root.children[idx] = new Node();

            if(i == word.length()-1)
            root.children[idx].flag = true;

            root = root.children[idx];
        }
        
    }
    
    public boolean search(String word) 
    {
        Node root = curr;
        for(int i =0;i<word.length();i++)
        {
            int idx = word.charAt(i)- 'a';
            if(root.children[idx] == null)
            return false;

            if(i == word.length()-1 && root.children[idx].flag == false)
            return false;

            root = root.children[idx];

        }
        return true;
        
    }
    
    public boolean startsWith(String prefix) 
    {
        Node root = curr;
        for(int i =0;i<prefix.length();i++)
        {
            int idx = prefix.charAt(i) - 'a';
            if(root.children[idx]== null)
            return false;

            root = root.children[idx];
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */