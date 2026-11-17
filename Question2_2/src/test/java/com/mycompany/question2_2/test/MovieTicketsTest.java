/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question2_2.test;

import com.mycompany.question2_2.IMovieTickets;
import com.mycompany.question2_2.MovieTicketData;
import com.mycompany.question2_2.MovieTickets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Q.2.9 - Unit tests for the MovieTickets class.
 * @author emeris
 */
class MovieTicketsTest {
    private final IMovieTickets movieTickets = new MovieTickets();

    @Test
    void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        // 3 tickets x R100 = R300, plus 14% VAT (R42) = R342
        assertEquals(342.0, movieTickets.CalculateTotalTicketPrice(3, 100.0), 0.001);
    }

    @Test
    void ValidateData_ValidData_ReturnsTrue() {
        MovieTicketData data = new MovieTicketData("Napoleon", 3, 100.0);
        assertTrue(movieTickets.ValidateData(data));
    }

    @Test
    void ValidateData_EmptyMovieName_ReturnsFalse() {
        MovieTicketData data = new MovieTicketData("", 3, 100.0);
        assertFalse(movieTickets.ValidateData(data));
    }

    @Test
    void ValidateData_ZeroTickets_ReturnsFalse() {
        MovieTicketData data = new MovieTicketData("Napoleon", 0, 100.0);
        assertFalse(movieTickets.ValidateData(data));
    }
}
