package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataAccessObject {
    
    public static boolean login(String user, String password) {
        
        Connection conn = null;
            PreparedStatement ps = null;

               try
               {
                   String url = "jdbc:mysql://aghgrid.dyn.pl:3306/aghgrid";
                   Class.forName ("com.mysql.jdbc.Driver");
                   conn = DriverManager.getConnection (url,"root","spearhead10");
                   System.out.println ("Database connection established");
               }
               catch (Exception e)
               {
                   e.printStackTrace();
                   return false;
               }
               finally
               {
                   if (conn != null)
                   {
                       try
                       {
                           ps = conn.prepareStatement(
                                   "select login, password from users where login= ? and password= ? ");
                           ps.setString(1, user);
                           ps.setString(2, password);
                           System.out.println (ps.toString());
                           ResultSet rs = ps.executeQuery();
                           if (rs.next()) // found
                           {
                               System.out.println(rs.getString("User logged succesfully"));
                               conn.close ();
                               System.out.println ("Database connection terminated");
                               return true;
                           }
                           else {
                               System.out.println ("Invalid Login!");
                               conn.close ();
                               System.out.println ("Database connection terminated");
                               return false;
                           }
                       }
                       catch (Exception e) { /* ignore close errors */
                            return false;}
                   }
               }
        
        /*    
            Connection con = null;
            PreparedStatement ps = null;
            try {
                con = Database.getConnection();
                ps = con.prepareStatement(
                        "select user, pass from userinfo where user= ? and pass= ? ");
                ps.setString(1, user);
                ps.setString(2, password);
     
                ResultSet rs = ps.executeQuery();
                if (rs.next()) // found
                {
                    System.out.println(rs.getString("user"));
                    return true;
                }
                else {
                    return false;
                }
            } catch (Exception ex) {
                System.out.println("Error in login() -->" + ex.getMessage());
                return false;
            } finally {
                Database.close(con);
            }
        */
        return false;
    }
}
