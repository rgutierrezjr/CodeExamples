public class AnagramTest {
    public static int numberNeeded(String first, String second) {
        // set up an array denoting each possible character. ASCII w/extend 256
        int[] charSet = new int[256];

        // traverse through the first array, increment character encounters.
        for(int i = 0; i < first.length(); i++) {
            charSet[first.charAt(i)]++;
        }

        // traverse through second array, decrement character encounters.
        for(int i=0; i < second.length(); i++) {
            charSet[second.charAt(i)]--;
        }

        int numberNeeded = 0;

        // traverse through char set count and return the number of character needed.
        // character found in both arrays will wash out to 0.
        for (int i = 0; i < 256; i++) {
            numberNeeded += Math.abs(charSet[i]);
        }

        return numberNeeded;
    }

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "adx";

        System.out.println(numberNeeded(s1, s2));

    }
}
