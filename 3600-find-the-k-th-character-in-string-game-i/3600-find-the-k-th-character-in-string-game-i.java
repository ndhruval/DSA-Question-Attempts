class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while(true){
            if(sb.length()>k){
                return sb.charAt(k-1);
            }
            int n = sb.length();
            for(int i =0;i<n;i++){
                char ch = sb.charAt(i);
                if(ch == 'z')
                sb.append("a");
                else
                sb.append(Character.toString(ch+1));
            }
        }
        
        
    }
}