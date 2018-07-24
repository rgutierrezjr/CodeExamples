public class OneEditTest {
    public static boolean oneEdit(String s1, String s2) {
        // if w1 and w2 are more than 1 character away from
        // one another, we can automatically return false.

        // if the strings are identical, then they cannot be 1 anything away from eachother
        if(s1 == s2) {
            return false;
        }

        if(Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        // find the shortest and the longest string
        String shortest = s1.length() < s2.length() ? s1 : s2;
        String longest = s1.length() < s2.length() ? s2 : s1;

        System.out.println("shortest: " + shortest + ", longest: " + longest);

        // declare 2 pointers. one for shortest and one for longest.
        // also a boolean for when we detect a difference.
        int index1 = 0, index2 = 0;
        boolean diffFound = false;

        while(index1 < shortest.length() && index2 < longest.length()) {
            System.out.println("short: " + index1 + ", long: " + index2);
            System.out.println("shortest at " + shortest.charAt(index1));
            System.out.println("longest at " + longest.charAt(index2));

            // only 1 difference is allowed. if difference already found, return false.
            if(shortest.charAt(index1) != longest.charAt(index2)) {
                if(diffFound) {
                    return false;
                } else {
                    diffFound = true;
                }

                if(shortest.length() == longest.length()) {
                    // if same length move shortest
                    index1++;
                }
            } else {
                // move shortest index
                index1++;
            }

            // longest index always moves forward
            index2++;
        }

        // if we get to the end of the shortest string and
        // longest.charAt(index2) == last char of string 1 and
        // only 1 difference was detected.
        return true;
    }

    public static void main(String args[]) {
        String s1 = "abcdfg";
        String s2 = "abcdfg";

        System.out.println(oneEdit(s1, s2));

    }
}
