import java.io.*;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner scanner = new Scanner(new
        // File("D://Programming//MetaHackerCup2023//Q3//dim_sum_delivery_input.txt"));
        Scanner scanner = new Scanner(new File("D://Programming//MetaHackerCup2023//Round 1//Q1//input.txt"));
        // Scanner scanner = new Scanner(new File("Q1//input.txt"));
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(scanner.nextLine()); // Number of buttons
            String S = scanner.nextLine(); // Initial state as a binary string
            int Q = Integer.parseInt(scanner.nextLine()); // Number of button presses
            int pressCount = 0; // Counter for button presses

            for (int q = 1; q <= Q; q++) {
                int Bi = Integer.parseInt(scanner.nextLine()); // Button index pressed by brother
                // Toggle the state of button Bi and every Bi-th button
                for (int i = Bi; i <= N; i += Bi) {
                    S = toggleButton(S, i);
                }
                pressCount++; // Increment the button press count
            }
            try {
                // Create a FileWriter object to write to a file (change the file path as
                // needed).
                FileWriter fileWriter = new FileWriter("output.txt");

                // Create a BufferedWriter for efficient writing.
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Write each integer to the file, separated by spaces and followed by a
                // newline.
                bufferedWriter.write("Case #" + t + ": " + pressCount);
                bufferedWriter.newLine(); // Add newline after the last number

                // Close the BufferedWriter to save changes to the file.
                bufferedWriter.close();

                System.out.println("Data has been written to the file...");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Function to toggle the state of a button (0 to 1, 1 to 0)
    private static String toggleButton(String s, int index) {
        char[] chars = s.toCharArray();
        chars[index - 1] = (chars[index - 1] == '0') ? '1' : '0';
        return new String(chars);
    }
}
