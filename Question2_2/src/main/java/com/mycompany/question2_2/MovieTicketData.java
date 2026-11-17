/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.question2_2;

/**
 *
 * @author emeris
 */
public class MovieTicketData {
    private final String movieName;
    private final int numberOfTickets;
    private final double ticketPrice;

    public MovieTicketData(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieName()     { return movieName; }
    public int getNumberOfTickets()  { return numberOfTickets; }
    public double getTicketPrice()   { return ticketPrice; }
}
