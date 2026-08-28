package Assignments;

import java.util.*;

/**
 * ASSIGNMENT 3:
 * Implement 0/1 Knapsack and Longest Common Subsequence (LCS)
 * using Dynamic Programming (DP).
 * Interactive user input with DP Table printing and solution reconstruction.
 */
public class Assignment3_KnapsackAndLCS {

    // =========================================================
    // PART 1: 0/1 KNAPSACK USING DYNAMIC PROGRAMMING
    // =========================================================
    public static void solve01Knapsack(Scanner scanner) {
        System.out.println("\n=================================================");
        System.out.println("            0/1 KNAPSACK PROBLEM (DP)            ");
        System.out.println("=================================================");

        System.out.print("Enter number of items (N): ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter the weight and value for each item:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Item %d [weight value]: ", i + 1);
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter maximum knapsack capacity (W): ");
        int W = scanner.nextInt();

        // DP Table: dp[i][w] represents max value using first i items and capacity w
        int[][] dp = new int[n + 1][W + 1];

        // Fill DP Table
        for (int i = 1; i <= n; i++) {
            int currentWeight = weights[i - 1];
            int currentValue = values[i - 1];

            for (int w = 0; w <= W; w++) {
                if (currentWeight <= w) {
                    // Max of (Exclude item, Include item)
                    dp[i][w] = Math.max(dp[i - 1][w], currentValue + dp[i - 1][w - currentWeight]);
                } else {
                    // Cannot include item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Print DP Table
        System.out.println("\n-------------------------------------------------");
        System.out.println("                KNAPSACK DP TABLE                ");
        System.out.println("-------------------------------------------------");
        System.out.print("Item\\Cap |");
        for (int w = 0; w <= W; w++) {
            System.out.printf("%5d", w);
        }
        System.out.println("\n---------+" + "-----".repeat(W + 1));

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print("Init (0) |");
            } else {
                System.out.printf("Item %-3d |", i);
            }
            for (int w = 0; w <= W; w++) {
                System.out.printf("%5d", dp[i][w]);
            }
            System.out.println();
        }

        // Traceback to find selected items
        List<Integer> selectedItems = new ArrayList<>();
        int resWeight = W;
        for (int i = n; i > 0 && dp[i][resWeight] > 0; i--) {
            // If value came from including item i
            if (dp[i][resWeight] != dp[i - 1][resWeight]) {
                selectedItems.add(i);
                resWeight -= weights[i - 1];
            }
        }
        Collections.reverse(selectedItems);

        System.out.println("\n-------------------------------------------------");
        System.out.println("                 RESULTS SUMMARY                 ");
        System.out.println("-------------------------------------------------");
        System.out.println("Maximum Profit / Value: " + dp[n][W]);
        System.out.println("Items Included in Knapsack:");
        int totalWeight = 0;
        int totalValue = 0;
        for (int idx : selectedItems) {
            int wt = weights[idx - 1];
            int val = values[idx - 1];
            totalWeight += wt;
            totalValue += val;
            System.out.printf("  -> Item %d (Weight: %d, Value: %d)\n", idx, wt, val);
        }
        System.out.println("Total Weight Used : " + totalWeight + " / " + W);
        System.out.println("Total Value Gained: " + totalValue);
        System.out.println("=================================================\n");
    }

    // =========================================================
    // PART 2: LONGEST COMMON SUBSEQUENCE (LCS) USING DP
    // =========================================================
    public static void solveLCS(Scanner scanner) {
        System.out.println("\n=================================================");
        System.out.println("       LONGEST COMMON SUBSEQUENCE (LCS) (DP)     ");
        System.out.println("=================================================");

        System.out.print("Enter first string (S1): ");
        String s1 = scanner.next();
        System.out.print("Enter second string (S2): ");
        String s2 = scanner.next();

        int m = s1.length();
        int n = s2.length();

        // DP Table: dp[i][j] represents LCS length of s1[0..i-1] and s2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Fill DP Table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Print DP Table
        System.out.println("\n-------------------------------------------------");
        System.out.println("                  LCS DP TABLE                   ");
        System.out.println("-------------------------------------------------");
        System.out.print("S1\\S2  |   - ");
        for (int j = 0; j < n; j++) {
            System.out.printf("%4c", s2.charAt(j));
        }
        System.out.println("\n-------+-----" + "----".repeat(n));

        for (int i = 0; i <= m; i++) {
            if (i == 0) {
                System.out.print("  -    |");
            } else {
                System.out.printf("  %c    |", s1.charAt(i - 1));
            }
            for (int j = 0; j <= n; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }

        // Reconstruct LCS string via backtracking
        StringBuilder lcsBuilder = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcsBuilder.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        String lcsString = lcsBuilder.reverse().toString();

        System.out.println("\n-------------------------------------------------");
        System.out.println("                 RESULTS SUMMARY                 ");
        System.out.println("-------------------------------------------------");
        System.out.println("String 1 (S1) : \"" + s1 + "\" (Length: " + m + ")");
        System.out.println("String 2 (S2) : \"" + s2 + "\" (Length: " + n + ")");
        System.out.println("LCS Length    : " + dp[m][n]);
        System.out.println("Actual LCS    : \"" + lcsString + "\"");
        System.out.println("=================================================\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=================================================");
            System.out.println(" ASSIGNMENT 3: DYNAMIC PROGRAMMING MENU          ");
            System.out.println("=================================================");
            System.out.println("1. Solve 0/1 Knapsack Problem");
            System.out.println("2. Solve Longest Common Subsequence (LCS)");
            System.out.println("3. Run Both");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Exiting.");
                break;
            }

            int choice = scanner.nextInt();
            if (choice == 1) {
                solve01Knapsack(scanner);
            } else if (choice == 2) {
                solveLCS(scanner);
            } else if (choice == 3) {
                solve01Knapsack(scanner);
                solveLCS(scanner);
            } else if (choice == 4) {
                System.out.println("Exiting. Thank you!");
                break;
            } else {
                System.out.println("Invalid option! Please enter 1, 2, 3, or 4.");
            }
        }
        scanner.close();
    }
}
