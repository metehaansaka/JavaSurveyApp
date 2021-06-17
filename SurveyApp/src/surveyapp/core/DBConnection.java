/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surveyapp.core;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final String url = "jdbc:postgresql://localhost:5432/Survey";
    private final String user = "postgres";
    private final String password = "root";

    public Connection connect() {

        Connection conn = null;
        try {

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Hata => " + e.getMessage());
        }

        return conn;
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
