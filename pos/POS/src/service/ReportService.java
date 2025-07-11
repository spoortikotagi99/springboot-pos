package service;

import dal.DALManager;
import model.dto.Response;
import model.dto.SalesReportDTO;
import model.dto.SalaryReportDTO;
import java.sql.Connection;
import java.util.List;

public class ReportService {
    private ReportDAO reportDAO;

    public ReportService() {
        this.reportDAO = new ReportDAO();  // Initialize DAO for DB queries
    }

    public SalesReportDTO getMonthlySales(int month, int year) {
        return reportDAO.fetchMonthlySales(month, year);
    }

    public List<SalaryReportDTO> getMonthlySalaries(int month, int year) {
        return reportDAO.fetchMonthlySalaries(month, year);
    }
}
