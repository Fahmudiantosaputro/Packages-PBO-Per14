/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeduabelas;

/**
 *
 * @author mursi
 */
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportConnection {

    private static Connection conn = null;

    // === Method static agar bisa dipanggil langsung ===
    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Sesuaikan dengan konfigurasi database kamu
                String url = "jdbc:postgresql://localhost:5432/PBOPer12";
                String user = "postgres";
                String pass = "fahmud";

                // Load driver PostgreSQL
                Class.forName("org.postgresql.Driver");

                // Buat koneksi
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi PostgreSQL berhasil dibuat!");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
        return conn;
    }

    public void tampilkanReport(String reportPath, Map<String, Object> param) {
        try {
            Connection connection = getConnection();

            // File report diambil dari dalam classpath (bukan dari src)
            InputStream stream = getClass().getResourceAsStream(reportPath);

            if (stream == null) {
                System.out.println("Report tidak ditemukan: " + reportPath);
                return;
            }

            JasperPrint jp = JasperFillManager.fillReport(stream, param, connection);

            // Menampilkan JasperViewer
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Gagal menampilkan report: " + e.getMessage());
        }
    }

    // Opsional bila ingin menutup koneksi
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
                System.out.println("Koneksi ditutup");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
