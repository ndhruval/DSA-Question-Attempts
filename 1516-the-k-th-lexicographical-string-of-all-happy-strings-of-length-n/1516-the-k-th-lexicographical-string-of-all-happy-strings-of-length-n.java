import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyList = new ArrayList<>();
        generate(n, "", happyList, k);
        
        return happyList.size() >= k ? happyList.get(k - 1) : "";
    }

    private void generate(int n, String current, List<String> happyList, int k) {
        if (current.length() == n) {
            happyList.add(current);
            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (current.length() > 0 && current.charAt(current.length() - 1) == c) {
                continue;
            }
            if (happyList.size() < k) {
                generate(n, current + c, happyList, k);
            }
        }
    }
}
