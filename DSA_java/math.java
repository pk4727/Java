import java.util.ArrayList;

class math {
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }

    static void isPrimeInRange(int n, boolean[] barr) {
        for (int i = 2; i * i <= n; i++) {
            if (!barr[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    barr[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!barr[i]) {
                System.out.print(i + " ");
            }
        }
    }

    // square root of a number
    static double SQRTbinarySearch(int n, int p) {
        int start = 0;
        int end = n;
        double root = 0.0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        double incre = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += incre;
            }
            root -= incre;
            incre /= 10;
        }
        return root;
    }

    static double SQRTnewtonRapson(double n) {
        double x = n;
        double root;
        while (true) {
            root = 0.5 * (x + (n / x));
            if (Math.abs(root - x) < 0.5) {
                break;
            }
            x = root;
        }
        return root;
    }

    // factors of a number
    static void factor1(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    static void factor2(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " " + n / i + " ");
                }
            }
        }
    }

    static void factor3(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    list.add(0, n / i);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i) + " ");
        }
    }

    static void modulo(int n) {
        // (A + B) % M = ((A % M) + (B % M)) % M
        // (A - B) % M = ((A % M) - (B % M) + M) % M
        // (A * B) % M = ((A % M) * (B % M)) % M
        // (A / B) % M = ((A % M) * (B ^ -1 % M)) % M
        // B^-1 % M => Multiplicative modulo inverse(MMI) also B and M are co-prime.
        // (A % M) % M = A % M
        // M^x % M = 0 (for all x belong to +ve integer)
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(isPrime(n));
        // boolean[] barr = new boolean[n + 1];
        // isPrimeInRange(n, barr);
        // System.out.println();
        // System.out.printf("%.3f" , SQRTbinarySearch(n, 3));
        // System.out.println(SQRTnewtonRapson(n));
        // factor1(n);
        // System.out.println();
        // factor2(n);
        // System.out.println();
        // factor3(n);
        // modulo(n);
    }
}