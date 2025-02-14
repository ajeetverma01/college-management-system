import java.sql.*;

class ConnectionProvider
{
    static Connection con = null;
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            CollegeManagementSystem is the name of my database
            String url = "jdbc:mysql://localhost:3306/CollegeManagementSystem";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e)
        {
            System.out.println("Cannot reach database server.");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver not found.");
        }
        return con;
    }
}