import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();

            }
        }
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        for (int k = 0; k < n; k++) {
            int temp = matrix[k][c1];
            matrix[k][c1] = matrix[k][c2];
            matrix[k][c2] = temp;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}