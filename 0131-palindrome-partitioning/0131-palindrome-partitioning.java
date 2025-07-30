class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        function(0,s,list,temp);
        return list;
        
    }
    public static void function(int ind, String s, List<List<String>> list, List<String> temp){
        if(ind == s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s.substring(ind, i+1)))
            {
                temp.add(s.substring(ind,i+1));
                function(i+1,s,list,temp);
                temp.remove(temp.size()-1);
            }
        }

    }
    public static boolean isPalindrome(String s){
        int l=0, r= s.length()-1;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r))
            return false;
            l++;
            r--;
        }
        return true;
    }
}