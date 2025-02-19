class Solution {
    public String getHappyString(int n, int k) {
        String current="";
        ArrayList<String> happy = new ArrayList<>();
        generate(n,current,happy);
        if(happy.size()<k)
        return "";
        Collections.sort(happy);
        return happy.get(k-1);
        
    }
    public static void generate(int n,String current, ArrayList<String> happy)
    {
        if(current.length()==n)
        {
            happy.add(current);
            return;
        }
        for(char c= 'a';c<='c';c++)
        {
            if(current.length()>0 && current.charAt(current.length()-1)==c )
            continue;
            generate(n,current+c,happy);
        }

    }
}