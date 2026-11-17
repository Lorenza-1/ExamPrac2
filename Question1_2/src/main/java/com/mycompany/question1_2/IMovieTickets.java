/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question1_2;

/**
 *
 * @author emeris
 */
public interface IMovieTickets {
    int TotalMovieSales(int[] movieTicketSales);          // total tickets for ONE movie
    String TopMovie(String[] movies, int[] totalSales);   // name of the best-selling movie
}
