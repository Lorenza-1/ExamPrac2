/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question1_2;

import com.mycompany.question1.IMovieTickets;
import com.mycompany.question1.MovieTickets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Q.1.3 - Unit tests for the MovieTickets class 
 * @author emeris
 */
class MovieTicketsTest {
    
    private final IMovieTickets movieTickets = new MovieTickets();

    @Test
    void CalculateTotalSales_ReturnsExpectedTotalSales() {
        int[] napoleonSales = {3000, 1500, 1700};
        // 3000 + 1500 + 1700 = 6200
        assertEquals(6200, movieTickets.TotalMovieSales(napoleonSales));
    }

    @Test
    void TopMovieSales_ReturnsTopMovie() {
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totalSales = {6200, 6300};
        // Oppenheimer (6300) beats Napoleon (6200)
        assertEquals("Oppenheimer", movieTickets.TopMovie(movies, totalSales));
    }
}
