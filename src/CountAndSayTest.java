public class CountAndSayTest {
    public static String countAndSay(int n) {
        // check for base case, 1 or 0 (anything under)
        if (n <= 1) {
            return n + "";
        }
        
        // previous-generate first row. 1 - 1, first row.
        String str = "11";
        
        // first row already generated, start at 2.
        int row = 2;
        
        // iterate until we get to the desired row.
        while (row < n) {
            // initialize the string buffer to append to.
            StringBuilder sb = new StringBuilder();

            // convert previous string to array to index value comparison.
            char[] arr = str.toCharArray();

            // character appearance counter.
            int count = 1;

            // the index value
            int type = Character.getNumericValue(arr[0]);

            // iterate through the previous string array and count value appearances.
            // start at index 1, we're comparing against index 0.
            for (int i = 1; i < arr.length; i++) {
                // if the next value is the same as the previous in the iteration, increment count.
                if (arr[i] == arr[i - 1]) {

                    count++;
                } else {
                    // if the index value did not match, append the count (amount encountered) and the value (type)
                    sb.append(count + "" + type);

                    // update the value we're comparing to.
                    type = Character.getNumericValue(arr[i]);
                    // reset character count to 1, this occurrence.
                    count = 1;
                }
            }

            // go to next row
            row++;

            // append to the running string.
            sb.append(count + "" + type);

            // reset "str" to current row result.
            str = sb.toString();
        }
        return str;
    }

    public static void main(String args[]) {
        for(int i = 0; i < 10; i++) {
            System.out.println(countAndSay(i));
        }
    }
}
