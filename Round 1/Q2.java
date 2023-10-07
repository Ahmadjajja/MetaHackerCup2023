import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            int q = scanner.nextInt();
            int[] prefixSum = new int[n];

            // Calculate the prefix sum array
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    sum++;
                }
                prefixSum[i] = sum;
            }

            long totalPresses = 0;

            for (int i = 0; i < q; i++) {
                int b = scanner.nextInt() - 1; // Convert to 0-based index
                int buttonPresses = 0;

                if (s.charAt(b) == '1') {
                    buttonPresses = n - prefixSum[b];
                    for (int j = b; j < n; j += (b + 1)) {
                        if (s.charAt(j) == '1') {
                            buttonPresses--;
                        } else {
                            buttonPresses++;
                        }
                    }
                    s = s.substring(0, b) + "0" + s.substring(b + 1);
                } else {
                    buttonPresses = prefixSum[b];
                    for (int j = b; j < n; j += (b + 1)) {
                        if (s.charAt(j) == '1') {
                            buttonPresses++;
                        } else {
                            buttonPresses--;
                        }
                    }
                    s = s.substring(0, b) + "1" + s.substring(b + 1);
                }

                totalPresses += buttonPresses;
            }

            System.out.println("Case #" + testCase + ": " + totalPresses);
        }

        scanner.close();
    }
}
