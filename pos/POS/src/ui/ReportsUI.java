package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import model.dto.SalaryReportDTO;
import model.dto.SalesReportDTO;
import model.POSController;

public class ReportsUI extends javax.swing.JPanel {
    private JTable salesTable, salaryTable;
    private DefaultTableModel salesModel, salaryModel;
    private JComboBox<String> monthDropdown, yearDropdown;
    private JButton fetchButton;
    private POSController controller;

    public ReportsUI() {
        controller = new POSController(); // Initialize controller
        initCustomComponents();  // Call custom UI initialization
    }

    private void initCustomComponents() {
        setLayout(new BorderLayout());

        // Dropdowns for selecting month and year
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthDropdown = new JComboBox<>(months);
        yearDropdown = new JComboBox<>(new String[]{"2023", "2024", "2025"});
        fetchButton = new JButton("Get Report");

        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Month:"));
        filterPanel.add(monthDropdown);
        filterPanel.add(new JLabel("Year:"));
        filterPanel.add(yearDropdown);
        filterPanel.add(fetchButton);
        add(filterPanel, BorderLayout.NORTH);

        // Tables for Sales and Salary Reports
        salesModel = new DefaultTableModel(new Object[]{"Date", "Total Sales", "Total Transactions"}, 0);
        salesTable = new JTable(salesModel);

        salaryModel = new DefaultTableModel(new Object[]{"Employee Name", "Salary Amount", "Payment Date"}, 0);
        salaryTable = new JTable(salaryModel);

        // Use GridLayout to properly display tables
        JPanel tablePanel = new JPanel(new GridLayout(1, 2));
        tablePanel.add(new JScrollPane(salesTable));
        tablePanel.add(new JScrollPane(salaryTable));
        add(tablePanel, BorderLayout.CENTER);

        // Fetch button action listener
        fetchButton.addActionListener((ActionEvent e) -> {
            int month = monthDropdown.getSelectedIndex() + 1;
            int year = Integer.parseInt(yearDropdown.getSelectedItem().toString());
            loadSalesReport(month, year);
            loadSalaryReport(month, year);
        });
    }

    private void loadSalesReport(int month, int year) {
        try {
            List<SalesReportDTO> salesData = controller.fetchMonthlySales(month, year);
            salesModel.setRowCount(0);
            for (SalesReportDTO sales : salesData) {
                salesModel.addRow(new Object[]{sales.getDate(), sales.getTotalSales(), sales.getTotalTransactions()});
            }
            salesTable.revalidate();
            salesTable.repaint();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching sales report: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadSalaryReport(int month, int year) {
        try {
            List<SalaryReportDTO> salaryData = controller.fetchMonthlySalaries(month, year);
            salaryModel.setRowCount(0);
            for (SalaryReportDTO salary : salaryData) {
                salaryModel.addRow(new Object[]{salary.getEmployeeName(), salary.getSalaryAmount(), salary.getPaymentDate()});
            }
            salaryTable.revalidate();
            salaryTable.repaint();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching salary report: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
