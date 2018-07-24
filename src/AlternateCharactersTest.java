import java.util.Arrays;

public class AlternateCharactersTest {
    public static String alternateStrings(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();

        int shortest = aCharArray.length < bCharArray.length ? aCharArray.length : bCharArray.length;

        char[] combined = new char[aCharArray.length + bCharArray.length];

        int i = 0;
        int k = i;

        while (i < shortest) {
            combined[k] = aCharArray[i];

            k++;

            combined[k] = bCharArray[i];

            k++;
            i++;
        }


        while (k < combined.length - 1) {
            System.out.println(i);

            combined[k] = bCharArray[i];

            i++;
            k++;
        }

        return Arrays.toString(combined);
    }

    public static void main(String[] args) {

        String a = "ace";
        String b = "bdfghij";

        System.out.println(alternateStrings(a, b));
    }
}
