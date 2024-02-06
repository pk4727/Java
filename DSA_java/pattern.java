public class pattern {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("\nPattern_1 :-\n");
        Pattern1(n);
        System.out.println("\nPattern_2 :-\n");
        Pattern2(n);
        System.out.println("\nPattern_3 :-\n");
        Pattern3(n);
        System.out.println("\nPattern_4 :-\n");
        Pattern4(n);
        System.out.println("\nPattern_5 :-\n");
        Pattern5(n);
        System.out.println("\nPattern_6 :-\n");
        Pattern6(n);
        System.out.println("\nPattern_7 :-\n");
        Pattern7(n);
        System.out.println("\nPattern_8 :-\n");
        Pattern8(n);
        System.out.println("\nPattern_9 :-\n");
        Pattern9(n);
        System.out.println("\nPattern_10 :-\n");
        Pattern10(n);
        System.out.println("\nPattern_11 :-\n");
        Pattern11(n);
    }

    // * * * *
    // * * * *
    // * * * *
    // * * * *
    static void Pattern1(int n) {
        for (int row = 1; row <= n; row++) // for every rows
        {
            for (int col = 1; col <= n; col++) // for every column
            {
                System.out.print("* ");
            }
            System.out.println(); // when one row is printed, we need to add a newline
        }
    }

    // *
    // * *
    // * * *
    // * * * *
    static void Pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // * * * *
    // * * *
    // * *
    // *
    static void Pattern3(int n) {
        for (int row = n; row > 0; row--) {
            for (int col = row; col > 0; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // *
    // * *
    // * * *
    // * * * *
    // * * *
    // * *
    // *

    static void Pattern4(int n) {
        for (int row = 1; row <= 2 * n; row++) {
            if (row <= n) {
                for (int col = 1; col <= row; col++) {
                    System.out.print("* ");
                }
                System.out.println();
            } else {
                for (int col = 1; col <= (2 * n - row) + 1; col++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }

    // 1
    // 1 2
    // 1 2 3
    // 1 2 3 4
    static void Pattern5(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    // 1
    // 1 2
    // 1 2 3
    // 1 2 3 4
    // 1 2 3
    // 1 2
    // 1
    static void Pattern6(int n) {
        for (int row = 1; row <= 2 * n; row++) {
            if (row <= n) {
                for (int col = 1; col <= row; col++) {
                    System.out.print(col + " ");
                }
                System.out.println();
            } else {
                for (int col = 1; col <= 2 * n - row; col++) {
                    System.out.print(col + " ");
                }
                System.out.println();
            }
        }
    }

    // - -*
    // - * *
    // -* * *
    // * * * *
    // -* * *
    // - * *
    // - -*
    static void Pattern7(int n) {
        for (int row = 1; row < 2 * n; row++) {
            if (row <= n) {
                for (int col = 1; col <= n - row; col++) {
                    System.out.print(" ");
                }
                for (int col = 1; col <= row; col++) {
                    System.out.print("* ");
                }
                System.out.println();
            } else {
                for (int col = 1; col <= row % n; col++) {
                    System.out.print(" ");
                }
                for (int col = 1; col <= 2 * n - row; col++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }

    // - - - 1
    // - - 2 1
    // - 3 2 1
    // 4 3 2 1
    static void Pattern8(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= row; col++) {
                int x = row - col + 1;
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    // - - - 1
    // - - 2 1 2
    // - 3 2 1 2 3
    // 4 3 2 1 2 3 4
    static void Pattern9(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= row; col++) {
                int x = row - col + 1;
                System.out.print(x + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    // - - - 1
    // - - 2 1 2
    // - 3 2 1 2 3
    // 4 3 2 1 2 3 4
    // - 3 2 1 2 3
    // - - 2 1 2
    // - - - 1
    static void Pattern10(int n) {
        for (int row = 1; row < 2 * n; row++) {
            if (row <= n) {
                for (int col = 1; col <= n - row; col++) {
                    System.out.print("  ");
                }
                for (int col = 1; col <= row; col++) {
                    int x = row - col + 1;
                    System.out.print(x + " ");
                }
                for (int col = 2; col <= row; col++) {
                    System.out.print(col + " ");
                }
                System.out.println();
            } else {
                for (int col = 1; col <= row % n; col++) {
                    System.out.print("  ");
                }
                for (int col = 2 * n - row; col > 0; col--) {
                    System.out.print(col + " ");
                }
                for (int col = 2; col <= (n - row % n); col++) {
                    System.out.print(col + " ");
                }
                System.out.println();
            }
        }
    }

    // 4 4 4 4 4 4 4 4 4
    // 4 3 3 3 3 3 3 3 4
    // 4 3 2 2 2 2 2 3 4
    // 4 3 2 1 1 1 2 3 4
    // 4 3 2 1 0 1 2 3 4
    // 4 3 2 1 1 1 2 3 4
    // 4 3 2 2 2 2 2 3 4
    // 4 3 3 3 3 3 3 3 4
    // 4 4 4 4 4 4 4 4 4
    static void Pattern11(int n) {
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}