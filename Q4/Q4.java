package Q4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:/Programming/MetaHackerCup2023/Q4/data.txt"));
        int testCase = Integer.parseInt(scanner.nextLine());
        int tCount = 1;
        while (scanner.hasNextInt()) {
            int days = Integer.parseInt(scanner.nextLine());
            String input = scanner.nextLine();
            String[] parts = input.split(" "); // Split the string by spaces
            int[] apples = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                apples[i] = Integer.parseInt(parts[i]); // Convert each part to an integer
            }
            System.out.println("Case #" + tCount + ": " + appleFinder(apples));
            tCount++;
        }

    }

    private static int appleFinder(int[] apples) {
        Arrays.sort(apples);
        if (apples.length == 1) {
            return apples[0];
        }
        int start = 0;
        int end = apples.length - 1;
        int sum = apples[start] + apples[end];
        int predict = -1;
        int pCount = 0;
        // finding predicting to find answer
        while (start < end) {
            if (pCount > 1) {
                return -1;
            }
            start++;
            end--;
            if (start >= end) {
                break;
            }
            if (sum != apples[start] + apples[end]) {
                predict = apples[start - 1];
                end++;
                pCount++;
                sum = apples[start] + apples[end];
            }
        }

        return sum - (predict == -1 ? apples[start] : predict);
    }
}
