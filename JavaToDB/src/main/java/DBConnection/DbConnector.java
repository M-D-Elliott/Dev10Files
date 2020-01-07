package DBConnection;

import java.sql.*;

public class DbConnector{  
    public void run(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            //here sonoo is database name, root is username and password
            try (Connection con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/trackit","root","")) {
                //here sonoo is database name, root is username and password
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from task");
                while(rs.next()){
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                }
                stmt.executeUpdate("INSERT INTO "
                                    + "TASK VALUES"
                                        + "(544, 'Eat Breakfast', '', '2007-02-19', 22.00, 'payroll', 60, 1, 2, null);");
            }
        }
        catch(ClassNotFoundException | SQLException e){ System.out.println(e);}  
    }
}  