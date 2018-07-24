public class PalindromeTest {

    public static boolean isPalindrome(String s) {

        // first normalize the string; remove (ignore) any characters that
        // do not apply. in this example, anything that's not an alphanumeric
        // character
        String clean = s.replaceAll("[^A-Za-z0-9]", "");

        // to lower case any characters for equivalence check later.
        clean = clean.toLowerCase();

        // to char array
        char[] sArray = clean.toCharArray();

        int start = 0;
        int last = sArray.length - 1;

        while(start < last) {
            System.out.println(sArray[start]);
            System.out.println(sArray[last]);

            if(sArray[start] != sArray[last]) {
                return false;
            } else {
                start++;
                last--;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = " R acE bE ca R ";

        System.out.println(isPalindrome(s1));
    }
}
