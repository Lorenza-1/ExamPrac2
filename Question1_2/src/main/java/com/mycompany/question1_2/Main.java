/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.question1_2;

/**
 * Q.1.1 - Console application that prints the movie ticket sales report 
 * @author emeris
 */
public class Main {
     public static void main(String[] args) {
        // Single-dimensional arrays: movie names and month headings
        String[] movies = {"Napoleon", "Oppenheimer"};
        String[] months = {"JAN", "FEB", "MAR"};

        // Two-dimensional array: rows = movies, columns = months
        int[][] ticketSales = {
            {3000, 1500, 1700},   // Napoleon
            {3500, 1200, 1600}    // Oppenheimer
        };

        IMovieTickets movieTickets = new MovieTickets();

        // Single-dimensional array of totals, one per movie
        int[] totalSales = new int[movies.length];

        // ----- Heading and month columns -----
        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println();
        System.out.printf("%-15s", "");
        for (String month : months) {
            System.out.printf("%10s", month);
        }
        System.out.println();
        System.out.println("-".repeat(45));

        // ----- One row per movie; the total is calculated as we go -----
        for (int row = 0; row < movies.length; row++) {
            System.out.printf("%-15s", movies[row]);
            for (int col = 0; col < ticketSales[row].length; col++) {
                System.out.printf("%10d", ticketSales[row][col]);
            }
            System.out.println();
            totalSales[row] = movieTickets.TotalMovieSales(ticketSales[row]);
        }
        System.out.println();

        // ----- Totals for each movie -----
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Total movie ticket sales for " + movies[i] + " " + totalSales[i]);
        }
        System.out.println();

        // ----- Top performing movie -----
        System.out.println("Top performing movie: " + movieTickets.TopMovie(movies, totalSales));
    }
}
