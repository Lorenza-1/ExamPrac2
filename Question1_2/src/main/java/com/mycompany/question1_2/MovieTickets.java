/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question1_2;

/**
 *
 * @author emeris
 */
public class MovieTickets implements IMovieTickets {
    
    /** Adds up the monthly ticket sales of one movie. */
    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        int total = 0;
        for (int monthlySales : movieTicketSales) {
            total += monthlySales;
        }
        return total;
    }

    /**
     * Returns the name of the movie with the highest total sales.
     * movies[i] and totalSales[i] belong to the same movie (parallel arrays).
     */
    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        int topIndex = 0;                          // assume the first movie is the best
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topIndex]) {
                topIndex = i;                      // found a better seller
            }
        }
        return movies[topIndex];
    }
}
