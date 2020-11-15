package cinema;

import java.util.Scanner;

public class Cinema {
    static int[][] matrix;
    static Scanner scanner = new Scanner(System.in);
    static int rows;
    static int columns;

    public static void main(String[] args) {
        
        initCinema();

        int userInput;
        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.print("> ");
            userInput = scanner.nextInt();
            System.out.println();
            switch (userInput) {
                case 0: 
                    return;
                case 1:
                    showSeats();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    getStatistics();
                    break;
                    
            }
            System.out.println();
        }
    }

    private static void getStatistics() {
        int purchasedTickets = getNumberPurchasedTickets();
        double percentage = purchasedTickets / (double) (rows * columns);
        int currentIncome = getCurrentIncome();
        int totalIncome = getTotalIncome();
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.println("Percentage: " + String.format("%.2f", percentage * 100) + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $"+ totalIncome);

    }

    private static int getTotalIncome() {
        int totalIncome = 0;
        for (int i = 0; i < rows; i++) {
            int priceInTheRow = getPrice(i+1);
            totalIncome += priceInTheRow * columns;
        }
        return totalIncome;
    }

    private static int getCurrentIncome() {
        int income = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                income += anInt;
            }
        }
        return income;
    }

    private static int getNumberPurchasedTickets() {
        int cnt = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt > 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void initCinema() {
        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        columns = scanner.nextInt();

        if (rows > 9 || columns > 9) {
            return;
        }

        matrix = new int[rows][columns];

    }

    private static void buyTicket() {
        while (true) {
            System.out.println("Enter a row number:");
            System.out.print("> ");
            int rowN = scanner.nextInt();

            System.out.println("Enter a seat number in that row:");
            System.out.print("> ");
            int columnN = scanner.nextInt();

            if (rowN < 1 || rowN > rows || columnN < 1 || columnN > columns) {
                System.out.println("Wrong input!");
                continue;
            }
            if (matrix[rowN - 1][columnN - 1] > 0) {
                System.out.println("That ticket has already been purchased ");
                continue;
            }

            int price = getPrice(rowN);
            System.out.printf("Ticket price: $%d \n", price);
            matrix[rowN - 1][columnN - 1] = price;
            break;
        }
    }

    private static int getPrice(int rowN) {
        int price = 0;
        if (rows * columns <= 60) {
            price = 10;
        } else {
            int firstHalf = rows / 2;
            int secondHalf = rows - firstHalf;
            if (rowN <= firstHalf) {
                price = 10;
            } else {
                price = 8;
            }
        }
        return price;
    }

    private static void showSeats() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < columns; i++) {
            System.out.printf(" %d", i+1);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.printf("%d", i+1);
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] > 0) {
                    System.out.print(" B");
                } else {
                    System.out.print(" S");
                }
            }
            System.out.println();
        }
    }
}