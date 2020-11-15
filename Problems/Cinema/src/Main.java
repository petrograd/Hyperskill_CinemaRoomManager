import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        var matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        System.out.println(findKSeats(matrix, k));
    }

    private static int findKSeats(int[][] matrix, int k) {

        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            int foundSeatsInARaw = 0;
            for (int anInt : ints) {
                if (anInt == 0) {
                    foundSeatsInARaw ++;
                    if (foundSeatsInARaw == k) {
                        return i + 1;
                    }
                } else {
                    if (foundSeatsInARaw > 0) {
                        foundSeatsInARaw = 0;
                    }
                }

            }
        }
        return 0;

    }
}