package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DatabaseConnector;
import model.dto.SalaryReportDTO;
import model.dto.SalesReportDTO;
import java.util.List;
import java.util.ArrayList;

public class ReportDAO {

    private DatabaseConnector dbConnection = new DatabaseConnector();  // Manage DB connection

    public SalesReportDTO fetchMonthlySales(int month, int year) {
        String query = "SELECT DATE_FORMAT(sale_date, '%Y-%m') AS report_date, " +
                "SUM(total_price) AS total_sales, COUNT(id) AS total_transactions " +
                "FROM sales WHERE MONTH(sale_date) = ? AND YEAR(sale_date) = ? " +
                "GROUP BY report_date";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, month);
            stmt.setInt(2, year);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new SalesReportDTO(
                        rs.getString("report_date"),       // ✅ Pass the formatted date
                        rs.getDouble("total_sales"),
                        rs.getInt("total_transactions")
                );
            }
            return new SalesReportDTO("N/A", 0.0, 0);  // If no data found, return default

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<SalaryReportDTO> fetchMonthlySalaries(int month, int year) {
        String query = "SELECT employee_name, salary, DATE_FORMAT(payment_date, '%Y-%m-%d') AS formatted_date " +
                "FROM employees WHERE MONTH(payment_date) = ? AND YEAR(payment_date) = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, month);
            stmt.setInt(2, year);
            ResultSet rs = stmt.executeQuery();

            List<SalaryReportDTO> salaryReports = new ArrayList<>();
            while (rs.next()) {
                salaryReports.add(new SalaryReportDTO(
                        rs.getString("employee_name"),  // ✅ Correctly passing name
                        rs.getDouble("salary"),        // ✅ Correctly passing salary
                        rs.getString("formatted_date") // ✅ Correctly passing date
                ));
            }

            return salaryReports;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();  // Return empty list to avoid null issues
        }
    }

}
