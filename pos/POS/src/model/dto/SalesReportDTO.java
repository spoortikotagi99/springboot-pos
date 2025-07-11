package model.dto;

public class SalesReportDTO {
    private String date;
    private double totalSales;
    private int totalTransactions;

    // Constructor
    public SalesReportDTO(String date, double totalSales, int totalTransactions) {
        this.date = date;
        this.totalSales = totalSales;
        this.totalTransactions = totalTransactions;
    }

    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }
}
