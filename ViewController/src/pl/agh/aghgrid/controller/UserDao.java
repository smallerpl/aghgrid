package pl.agh.aghgrid.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pl.agh.aghgrid.model.Users;

public class UserDao {
    private Connection connection;

    private static final String PERSISTENCE_UNIT_NAME = "Model";
    private static EntityManagerFactory factory;

    public static boolean validate(String username, String password) {
        boolean flag = false;
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("SELECT u FROM Users u WHERE u.username = :login AND u.password = :pass");
        q.setParameter("username", username);
        q.setParameter("password", password);
        try {
            Users user = (Users) q.getSingleResult();
            if (username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())) {
                flag = true;
            }
        } catch (Exception e) {
            return false;
        }

        return flag;
    }
    /* public UserDao() {
        connection = Database.getConnection();
    }

    public void verifyUser(String username, String password) {
            try {
                PreparedStatement ps = connection.prepareStatement("select username, password from users where username= ? and password= ?");
                    ps.setString(1, username);
                    ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) // found
                {
                    //updateUser(user);
                } else {
                    //addUser(user);
                }
            } catch (Exception ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
            }
    } */

    public static boolean login(String username, String password) {


        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String url = "jdbc:mysql://aghgrid.dyn.pl:3306/aghgrid";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "spearhead10");
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    ps =
                        conn.prepareStatement("select username, password from users where username= ? and password= ? ");
                    ps.setString(1, username);
                    ps.setString(2, password);
                    System.out.println(ps.toString());
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) // found
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
                    }
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
