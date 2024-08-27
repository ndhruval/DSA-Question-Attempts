class Solution 
{
    public String frequencySort(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        List<Character> characters = new ArrayList<>(map.keySet());
        characters.sort((a, b) -> map.get(b) - map.get(a));

        // Step 3: Build the resulting string
        String ans = "";
        for (char ch : characters) {
            int freq = map.get(ch);
            while (freq > 0) {
                ans += ch; // Concatenate the character to the string
                freq--;
            }
        }

        return ans;
    }
}