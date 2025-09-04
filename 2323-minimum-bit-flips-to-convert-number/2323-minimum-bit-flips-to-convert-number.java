class Solution {
    public int minBitFlips(int start, int goal) {
        String s1 = Integer.toBinaryString(start);
        String s2 = Integer.toBinaryString(goal);
        int l = Math.abs(s1.length() - s2.length());
        if(l>0){
            StringBuilder sb = new StringBuilder();
            while (sb.length() < l) {
            sb.append('0');
            }
            if(s1.length()< s2.length()){
                sb.append(s1);
                s1 = sb.toString();
            }
            else {
                sb.append(s2);
                s2= sb.toString();
            }
        }
        int count =0;

        for(int i = s1.length() -1;i>=0;i--){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
         return count;

    }
}