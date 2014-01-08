package pl.agh.aghgrid.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDao {
    
    public static boolean createRequest(String username, String request) {
        Integer id;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String url = "jdbc:mysql://aghgrid.dyn.pl:3306/aghgrid";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "spearhead10");
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();            
        } finally {
            if (conn != null) {
                try {
                    ps = conn.prepareStatement("insert into tasks (user_id, request) values ((select id from users where username = ?), ?)");
                    ps.setString(1, username);
                    ps.setString(2, request);
                    System.out.println(ps.toString());
                    ps.execute();
                    return true;
                    //ResultSet rs = ps.executeQuery();
                    /* if (rs.next()) // found
                    {
                        //System.out.println(rs.getString("username"));
                        //System.out.println("User logged succesfully");
                        conn.close();
                        System.out.println("Database connection terminated");
                        return true;
                    } else {
                        System.out.println("Invalid Login!");
                        conn.close();
                        System.out.println("Database connection terminated");
                        return false;
                    } */
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }
}
