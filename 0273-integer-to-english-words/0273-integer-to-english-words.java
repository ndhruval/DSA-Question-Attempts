class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String arr[] = {
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen", "Twenty",
            "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        String[] units = {"", "Thousand", "Million", "Billion"};

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (num > 0) {
            int d = num % 1000;
            num = num / 1000;

            if (d != 0) {
                StringBuilder temp = new StringBuilder();

                int hundreds = d / 100;
                int lastTwo = d % 100;

                if (hundreds > 0) {
                    temp.append(arr[hundreds - 1]).append(" Hundred ");
                }

                if (lastTwo > 0) {
                    if (lastTwo <= 20) {
                        temp.append(arr[lastTwo - 1]).append(" ");
                    } else {
                        int tens = lastTwo / 10;
                        int ones = lastTwo % 10;

                        temp.append(arr[18 + tens - 1]).append(" "); // 18 + (2-based tens - 2)
                        if (ones > 0) {
                            temp.append(arr[ones - 1]).append(" ");
                        }
                    }
                }

                if (!units[index].isEmpty()) {
                    temp.append(units[index]).append(" ");
                }

                sb.insert(0, temp);
            }

            index++;
        }

        return sb.toString().trim();
    }
}
