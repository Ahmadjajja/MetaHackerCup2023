package Q3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(
                new File("D://Programming//MetaHackerCup2023//Q3//dim_sum_delivery_input.txt"));
        int testCase = Integer.parseInt(scanner.nextLine());
        int tCount = 1;
        while (scanner.hasNextInt()) {
            String input = scanner.nextLine();
            String[] parts = input.split(" "); // Split the string by spaces
            int[] inputParameters = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                inputParameters[i] = Integer.parseInt(parts[i]); // Convert each part to an integer
            }
            long rows = inputParameters[0];
            long cols = inputParameters[1];
            long aliceMoves = inputParameters[2];
            long bobMoves = inputParameters[3];
            try {
                // Create a FileWriter object to write to a file (change the file path as
                // needed).
                FileWriter fileWriter = new FileWriter("output.txt");

                // Create a BufferedWriter for efficient writing.
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Write each integer to the file, separated by spaces and followed by a
                // newline.
                bufferedWriter.write("Case #" + tCount + ": " + winner(rows, cols, aliceMoves,
                        bobMoves));
                bufferedWriter.newLine(); // Add newline after the last number

                // Close the BufferedWriter to save changes to the file.
                bufferedWriter.close();

                System.out.println("Data has been written to the file " + tCount + " time");

            } catch (IOException e) {
                e.printStackTrace();
            }
            tCount++;
        }

    }

    private static String winner(long rows, long cols, long aliceMoves, long bobMoves) {
        boolean isAliceMove = true;
        long sr = 1;
        long sc = 1;
        while (sr <= rows && sc <= cols) {
            if (isAliceMove) {
                sr = sr == rows ? sr : sr + aliceMoves > rows ? rows : sr + aliceMoves;
            } else {
                sc = sc == cols ? sc : sc + bobMoves > cols ? cols : sc + bobMoves;
            }

            if (sr == rows && sc == cols) {
                if (isAliceMove) {
                    return "YES";
                } else {
                    return "NO";
                }
            }
            isAliceMove = !isAliceMove;
        }
        if (isAliceMove) {
            return "YES";
        } else {
            return "NO";
        }

    }
}
