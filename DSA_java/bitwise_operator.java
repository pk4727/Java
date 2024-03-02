public class bitwise_operator {

    // bitwise AND operator
    // AND with any number return same number
    static boolean isOdd(int n) {
        // if 2^0 == 1 then odd else even
        return (n & 1) == 1;
    }

    // bitwise XOR operator
    // a^1 = a'
    // a^0 = a
    // a^a = 0
    static int findUnique(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }

    // 10101 --> 4th bit = 0 ans.
    static int findIthBit(int n) {
        return n & (1 << (n - 1));
    }

    // 10101 --> 11101 (set 0 to 1 at 4th place)
    static int setIthBit1(int n) {

        return n;
    }

    // bit * 5^1,5^2,5^3,...
    static int magicNumber(int n) {
        int ans = 0;
        int powervalue = 5;
        while (n > 0) {
            int lastbit = n & 1;
            ans += lastbit * powervalue;
            powervalue = powervalue * 5;
            n = n >> 1;
        }
        return ans;
    }

    // 1010 = 4 bit
    static int countBit(int n) {
        int ans = 0;
        while (n > 0) {
            ans++;
            n = n >> 1;
        }
        return ans;
    }

    // for digits use formula " log n base b = digits " --> n = b ^ digits -->
    // digits in ceiling value is ANS.
    static int countBitInAnyNumberSystem(int number, int base) {
        int ans = (int) ((Math.log(number) / Math.log(base)) + 1);
        return ans;
    }

    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1 4 6 4 1
    // 1 5 10 10 5 1
    static int pascalTriangle(int n) {
        int nthrowsum = 1 << (n - 1);
        int eachrowsum = (int) Math.pow(2, n);
        System.out.println(nthrowsum);
        return eachrowsum;
    }

    // 2^0=1,2^1=2,2^2=4,....
    static boolean checkpowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    // base = 2 and power = 3 --> 2^3 = 8
    static int findPowerof(int base, int power) {
        int ans = 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= base;
            }
            base *= base;
            power = power >> 1;
        }
        return ans;
    }

    // count number of bit in binary number which is 1 ( 1010 = 2 )
    static int countSetBit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        // or
        while (n > 0) {
            count++;
            n -= n & (-n);
        }
        // or
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    // xor from 0 to 8 = 8
    static int findXORfrom0toA(int a) {
        if (a % 4 == 0) {
            return a;
        }
        if (a % 4 == 1) {
            return 1;
        }
        if (a % 4 == 2) {
            return a + 1;
        }
        return 0;
    }

    // xor from 4,8 = 8
    static int findXORfromrangeAtoB(int a, int b) {
        int ans = findXORfrom0toA(b) ^ findXORfrom0toA(a - 1);
        return ans;
    }
    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) { // shift first letter until value are equal to 1
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift; // add 0 no of shift to right side of 1
    }

    public static void main(String[] args) {
//         int n = 4;
////       int n = 197;
//         int[] arr = { 2, 3, 4, 5, 4, 3, 2 };
//         System.out.println(isOdd(n));
//         System.out.println(findUnique(arr));
//         System.out.println(findIthBit(n));
//         System.out.println(setIthBit1(n));
//         System.out.println(magicNumber(n));
//         System.out.println(countBit(n));
//         System.out.println("Bit in Decimal : " + countBitInAnyNumberSystem(n, 10));
//         System.out.println("Bit in Binary : " + countBitInAnyNumberSystem(n, 2));
//         System.out.println("Bit in Octal : " + countBitInAnyNumberSystem(n, 8));
//         System.out.println("Bit in Hexa : " + countBitInAnyNumberSystem(n, 16));
//         System.out.println(pascalTriangle(n));
//         System.out.println(checkpowerOf2(n));
//         System.out.println(findPowerof(4, n));
//         System.out.println(countSetBit(n));
//         System.out.println(findXORfrom0toA(n));
//         System.out.println(findXORfromrangeAtoB(n, 8));
           System.out.println(rangeBitwiseAnd(20,24));
    }
}