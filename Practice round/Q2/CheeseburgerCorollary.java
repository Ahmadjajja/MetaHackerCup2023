package Q2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class CheeseburgerCorollary {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                "D://Programming//MetaHackerCup2023//Q2//cheeseburger_corollary_2_validation_input.txt"));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            String[] line = reader.readLine().split(" ");
            BigInteger A = new BigInteger(line[0]);
            BigInteger B = new BigInteger(line[1]);
            BigInteger cost = new BigInteger(line[2]);

            String result = calculate(A, B, cost);

            System.out.println("Case #" + i + ": " + result);
        }

        reader.close();
    }

    public static String calculate(BigInteger A, BigInteger B, BigInteger cost) {
        BigInteger k = BigInteger.ZERO;

        while (cost.compareTo(BigInteger.ZERO) > 0) {
            if (A.compareTo(B) <= 0) {
                k = k.add(cost.divide(A));
                cost = cost.mod(A);
            } else {
                if (B.multiply(BigInteger.valueOf(2)).compareTo(A) <= 0) {
                    k = k.add(cost.divide(B).multiply(BigInteger.valueOf(2)).subtract(BigInteger.ONE));
                    cost = cost.mod(B);
                } else {
                    k = k.add(cost.divide(B).multiply(BigInteger.valueOf(2)).subtract(BigInteger.ONE));
                    cost = cost.mod(B);
                    k = k.add(cost.divide(A));
                    cost = cost.mod(A);
                }
            }
        }

        return k.toString();
    }
}
