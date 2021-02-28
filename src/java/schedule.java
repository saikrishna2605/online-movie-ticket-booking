import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/schedule")
public class schedule extends HttpServlet {
 
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String id = request.getParameter("id");
        String movieId = request.getParameter("movieId");
        String screen = request.getParameter("screen");
        String slot = request.getParameter("slot");
        //String booked = request.getParameter("slot");
         
        System.out.println("movie: " + movieId);
        System.out.println("genere: " + screen+" "+slot);
 
        // do some processing here...
        try
        {
          // create a mysql database connection
          String myDriver = "com.mysql.jdbc.Driver";
          //String myUrl = "jdbc:mysql://localhost:3306/UserDB";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "root", "root");
          // the mysql insert statement
          String query = " INSERT INTO SHOWS (ID,MID,SCREEN, SLOT)"
            + " values (?, ?, ?,?)";

          // create the mysql insert preparedvstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1,Integer.parseInt(id));
          preparedStmt.setInt(2, Integer.parseInt(movieId));
          preparedStmt.setInt(3, Integer.parseInt(screen));
          preparedStmt.setInt(4, Integer.parseInt(slot));
          //preparedStmt.setInt(5, Integer.parseInt(booked));

          // execute the preparedstatement
          preparedStmt.executeUpdate();
          preparedStmt.close();
          conn.close();
          response.sendRedirect("options.jsp");
        }
        catch (Exception e)
        {
          System.err.println("Got an exception in schedule java file!");
          System.err.println(e.getMessage());
        }
      
    }
 
}