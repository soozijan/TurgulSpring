package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class Repository {
    private String m_conn;

    public Repository(String m_conn) {
        this.m_conn = m_conn;
    }

    public void insertReport(Report r) {
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            if (conn != null) {

                String sql = String.format("INSERT INTO Reports (License_Plate, Driver_Id, Speed) " +
                        "VALUES ( '%s', %d, %d )", r.getLicense_Plate(), r.getDriver_Id(), r.getSpeed());
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(sql);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateReports(Report r, int id) {
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            if (conn != null) {
                String sql = String.format(
                        "UPDATE Reports set License_Plate = '%s', Driver_Id = %d, Speed = %d " +
                                " WHERE id = %d"
                        , r.getLicense_Plate(), r.getDriver_Id(), r.getSpeed(), id);
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(sql);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteReports(int id) {
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            if (conn != null) {
                String sql = String.format("DELETE from Reports where id = " + id);
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(sql);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public ArrayList<Report> getAllReports(){

        ArrayList<Report> reports = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                String sql = "SELECT * FROM Reports";

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Report r = new Report(
                            rs.getInt("id"),
                            rs.getString("license_Plate"),
                            rs.getInt("driver_Id"),
                            rs.getInt("speed") );
                    reports.add(r);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reports;
    }

    public Report getReportsById(int id){
        // try to connect to db
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query string
                String sql = String.format("Select * from Reports where id = %d", id );

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                ResultSet rs = stmt.executeQuery(sql);

                // read results
                while (rs.next()) {
                    Report r = new Report(
                            rs.getInt("id"),
                            rs.getString("license_Plate"),
                            rs.getInt("driver_Id"),
                            rs.getInt("speed") );
                    return r;
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

}

