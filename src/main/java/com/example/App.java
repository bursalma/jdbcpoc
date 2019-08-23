package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
    public static void main( String[] args )
    {

        String sql =
                "SELECT customerName, city, state " +
                "FROM customers";

        try (Connection conn = MySQLJDBCUtil.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            System.out.println(String.format("Connected to database %s "
                    + "successfully.", conn.getCatalog()));

            while (rs.next()) {
                System.out.println(rs.getString("customerName") + "\t" +
                        rs.getString("city")  + "\t" +
                        rs.getString("state"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
