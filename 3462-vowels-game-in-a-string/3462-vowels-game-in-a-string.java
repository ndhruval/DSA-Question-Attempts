class Solution {
    public boolean doesAliceWin(String s) {
        int n= s.length();
        int vow =0;
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c =='a'||c=='e'|| c== 'i'|| c== 'o' ||c=='u')
            vow++;

        }
        if(vow ==0)
        return false;
        if(vow%2 !=0)
        return true;
        else
        return true;
        
    }
}