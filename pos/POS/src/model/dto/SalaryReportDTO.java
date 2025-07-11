package model.dto;

public class SalaryReportDTO {
    private String employeeName;
    private double salaryAmount;
    private String paymentDate;

    // Constructor
    public SalaryReportDTO(String employeeName, double salaryAmount, String paymentDate) {
        this.employeeName = employeeName;
        this.salaryAmount = salaryAmount;
        this.paymentDate = paymentDate;
    }

    // Getters and Setters
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
