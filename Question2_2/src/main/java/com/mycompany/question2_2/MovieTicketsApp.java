/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.question2_2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Q.2.1 - 2.6: Swing GUI for the movie ticket application
 * @author emeris
 */
public class MovieTicketsApp extends JFrame {
    
    private static final String FILE_NAME = "report.txt";
    private static final String DIVIDER = "**********************************";
    private static final String[] MOVIES = {"Napoleon", "Oppenheimer", "Damsel"};

    private final IMovieTickets movieTickets = new MovieTickets();

    // GUI components
    private final JComboBox<String> cboMovie = new JComboBox<>(MOVIES);
    private final JTextField txtTickets = new JTextField(15);
    private final JTextField txtPrice = new JTextField(15);
    private final JTextArea txtReport = new JTextArea(6, 25);

    public MovieTicketsApp() {
        super("MOVIE TICKETS");
        buildMenu();
        buildLayout();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /** Q.2.2 - File > Exit, Tools > Process / Clear. */
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));        // Q.2.3
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(e -> processTickets());   // Q.2.4
        clearItem.addActionListener(e -> clearForm());          // Q.2.6
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    /** Q.2.1 - combo box, two text fields and a read-only text area. */
    private void buildLayout() {
        txtReport.setEditable(false);   // read-only

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addRow(panel, gbc, 0, "MOVIE:", cboMovie);
        addRow(panel, gbc, 1, "NUMBER OF TICKETS:", txtTickets);
        addRow(panel, gbc, 2, "TICKET PRICE:", txtPrice);

        // "TICKET REPORT:" label spanning both columns
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(new JLabel("TICKET REPORT:"), gbc);

        // Scrollable report area spanning both columns
        gbc.gridy = 4;
        panel.add(new JScrollPane(txtReport), gbc);

        add(panel);
    }

    /** Adds a "label + component" row to the form (avoids repeating layout code). */
    private void addRow(JPanel panel, GridBagConstraints gbc, int row, String text, JComponent field) {
        gbc.gridwidth = 1;
        gbc.gridy = row;
        gbc.gridx = 0;
        panel.add(new JLabel(text), gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    /** Q.2.4 - read the input, validate it, show the report and save it. */
    private void processTickets() {
        MovieTicketData data;
        try {
            data = new MovieTicketData(
                    (String) cboMovie.getSelectedItem(),
                    Integer.parseInt(txtTickets.getText().trim()),
                    Double.parseDouble(txtPrice.getText().trim()));
        } catch (NumberFormatException ex) {
            // Letters, blanks or a decimal comma will end up here
            showError("Number of tickets must be a whole number and the ticket price must be a number (use a full stop, e.g. 99.50).");
            return;
        }

        // Only valid data is allowed through (Q.2.7)
        if (!movieTickets.ValidateData(data)) {
            showError("Invalid data:\n- A movie must be selected\n- Number of tickets must be greater than 0\n- Ticket price must be greater than 0");
            return;
        }

        double total = movieTickets.CalculateTotalTicketPrice(
                data.getNumberOfTickets(), data.getTicketPrice());

        String report = "MOVIE NAME: " + data.getMovieName() + "\n"
                + "MOVIE TICKET PRICE: R " + data.getTicketPrice() + "\n"
                + "NUMBER OF TICKETS: " + data.getNumberOfTickets() + "\n"
                + "TOTAL TICKET PRICE: R " + total;

        txtReport.setText(report);
        saveReport(report);             // Q.2.5
    }

    private void saveReport(String report) {
        // try-with-resources closes the file automatically
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("MOVIE TICKET REPORT");
            writer.newLine();
            writer.write(DIVIDER);
            writer.newLine();
            writer.write(report);
            writer.newLine();
            writer.write(DIVIDER);
            writer.newLine();
        } catch (IOException ex) {
            showError("Could not save " + FILE_NAME + ": " + ex.getMessage());
        }
    }

    /** Q.2.6 - return the form to its default state. */
    private void clearForm() {
        cboMovie.setSelectedIndex(0);
        txtTickets.setText("");
        txtPrice.setText("");
        txtReport.setText("");
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovieTicketsApp().setVisible(true));
    }
}
