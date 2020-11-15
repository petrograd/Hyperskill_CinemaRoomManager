import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        var squareSize = n * n;

        int[][] matrix = new int[squareSize][squareSize];
        var columns = new int[squareSize][squareSize];

        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                int number = scanner.nextInt();
                matrix[i][j] = number;
                columns[j][i] = number;

            }
        }
        System.out.println(solvedSudoku(matrix) && solvedSudoku(columns) ? "YES" : "NO");
    }

    private static boolean solvedSudoku(int[][] matrix) {

        for (int[] ints : matrix) {
            Arrays.sort(ints);
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] != i + 1) {
                    return false;
                }
            }
        }
        return true;
    }
}