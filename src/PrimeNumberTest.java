public class PrimeNumberTest {
    public static boolean isPrimeGood(int n){
        int count = 0;

        // 1 is not prime
        if( n == 1 ){
            return false;
        } else if( n == 2 ){
            return true;
        }

        // return false n is divisible by any i from 2 to n
        int i = 1;
        while( i++ <= Math.sqrt(n) ) {
            if( n % i == 0 ){
                return false;
            }
        }

        // n is prime
        return true;
    }


    public static boolean isPrime(int n){
        // check lower boundaries on primality
        if( n == 2 ){
            return true;
        } // 1 is not prime, even numbers > 2 are not prime
        else if( n == 1 || (n & 1) == 0){
            return false;
        }

        // Check for primality using odd numbers from 3 to sqrt(n)
        for(int i = 3; i <= Math.sqrt(n); i += 2){
            // n is not prime if it is evenly divisible by some 'i' in this range
            if( n % i == 0 ){
                return false;
            }
        }
        // n is prime
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPrime(7));

    }
}
