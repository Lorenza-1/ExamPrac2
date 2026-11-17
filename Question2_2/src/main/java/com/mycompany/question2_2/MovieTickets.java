/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question2_2;

/**
 * Calculates the total ticket price (incl. VAT) and validates the captured data.
 * @author emeris
 */
public class MovieTickets implements IMovieTickets {
    
    /** VAT rate of 14%, kept as a constant so it is easy to change. */
    public static final double VAT_RATE = 0.14;

    /** Total = (tickets x price) + 14% VAT, rounded to 2 decimal places. */
    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double subtotal = numberOfTickets * ticketPrice;
        double total = subtotal + (subtotal * VAT_RATE);
        // Rounding removes floating-point noise such as 341.99999999999994
        return Math.round(total * 100.0) / 100.0;
    }

    /**
     * Validation rules (Q.2.7):
     *  - movie name cannot be empty
     *  - ticket price must be greater than zero
     *  - number of tickets must be greater than zero
     */
    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {
        if (movieTicketData == null) {
            return false;
        }
        String name = movieTicketData.getMovieName();
        boolean nameValid = name != null && !name.trim().isEmpty();
        boolean priceValid = movieTicketData.getTicketPrice() > 0;
        boolean ticketsValid = movieTicketData.getNumberOfTickets() > 0;
        return nameValid && priceValid && ticketsValid;
    }
}

