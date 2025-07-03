class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc"); map.put(3, "def");
        map.put(4, "ghi"); map.put(5, "jkl");
        map.put(6, "mno"); map.put(7, "pqrs");
        map.put(8, "tuv"); map.put(9, "wxyz");

        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;

        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String prefix = q.poll();
            if (prefix.length() == digits.length()) {
                ans.add(prefix);
            } else {
                int digit = digits.charAt(prefix.length()) - '0';
                if (digit < 2 || digit > 9) continue;

                for (char letter : map.get(digit).toCharArray()) {
                    q.add(prefix + letter);
                }
            }
        }

        return ans;
    }
}
