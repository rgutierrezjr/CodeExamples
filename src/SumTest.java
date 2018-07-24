import java.util.*;

public class SumTest {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println("index: " + i + ", value: " + nums[i] + ", target: " + target);
            int complement = target - nums[i];

            System.out.println("compliment: " + complement);
            System.out.println(map.toString());

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
            System.out.println(map.toString());

            System.out.println("\n\n");


        }

        return new int[] {};
    }

    public static List<List<Integer>> threeSum(int[] num) {
        // sort array to make this easier to check for dupes.
        Arrays.sort(num);

        System.out.println("sorted array: " + Arrays.toString(num));

        // declare the result set.
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < num.length-2; i++) {
            System.out.println("\nindex pointer: " + i);

            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lowPointer = i+1, highPointer = num.length-1, sum = 0 - num[i];

                System.out.println("low pointer: " + lowPointer);
                System.out.println("high pointer: " + highPointer);
                System.out.println("sum: " + sum);

                // starting at i (low), move low towards high and high towards low until they meet.
                while (lowPointer < highPointer) {

                    System.out.println("\nlow val: " + num[lowPointer]);
                    System.out.println("high val: " + num[highPointer]);

                    if (num[lowPointer] + num[highPointer] == sum) {
                        res.add(Arrays.asList(num[i], num[lowPointer], num[highPointer]));
                        while (lowPointer < highPointer && num[lowPointer] == num[lowPointer+1]) lowPointer++;
                        while (lowPointer < highPointer && num[highPointer] == num[highPointer-1]) highPointer--;
                        lowPointer++; highPointer--;
                    } else if (num[lowPointer] + num[highPointer] < sum) {
                        lowPointer++;
                    } else {
                        highPointer--;
                    }
                }
            }
        }
        return res;
    }

    public static int sumDigits(int number) {
        int sum = 0;

        while (number != 0) {
            System.out.println("number % 10: " + (number % 10));
            System.out.println("number: " + number );

            sum = sum + (number % 10);
            number = number / 10;
        }

        return sum;
    }

    public static void main(String args[]) {
        //      index: 0,1,2,3,4,5,6
        int[] array = {1,2,3,4,5,6,7};

//        System.out.println(Arrays.toString(twoSum(array, 50)) + "\n\n");


        System.out.println(sumDigits(12345));

        //               index: 0, 1, 2, 3,  4, 5, 6
        int[] threeSumArray = {-1, 3, 2, 0, -4, 5, 2};

//        System.out.print(threeSum(threeSumArray));
    }
}
