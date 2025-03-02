class Solution {
    public boolean doesAliceWin(String s) {
        int n= s.length();
       
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c =='a'||c=='e'|| c== 'i'|| c== 'o' ||c=='u')
            return true;

        }
        return false;
        
        
    }
}