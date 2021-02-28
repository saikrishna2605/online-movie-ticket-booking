
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/userinput")
public class Input extends HttpServlet {
 
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String id = request.getParameter("id");
        String movieName = request.getParameter("movieName");
        String genere = request.getParameter("genere");
        String duration = request.getParameter("duration");
        String director = request.getParameter("director");
         
        System.out.println("movie: " + movieName);
        System.out.println("genere: " + genere);
 
  
        try
        {
          
          String myDriver = "com.mysql.jdbc.Driver";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/UserDB", "root", "root");
          // the mysql insert statement
          String query = "insert into MOVIEDATABASE (id,title, genere, duration, director)"
            + " values (?,?, ?, ?, ?)";

         
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1,Integer.parseInt(id));
          preparedStmt.setString (2, movieName);
          preparedStmt.setString (3, genere);
          preparedStmt.setInt(4, Integer.parseInt(duration));
          preparedStmt.setString(5, director);

          // execute the preparedstatement
          preparedStmt.executeUpdate();
          //preparedStmt.close();
          //conn.close();
          response.sendRedirect("options.jsp");
        }
        catch (Exception e)
        {
           // System.out.println("1");
          //System.err.println("Got an exception!");
          
          System.err.println(e.getMessage());
        }
			
//  stmt.executeUpdate("INSERT INTO MOVIEDATABASE " + "values('"+ movieName +"','"+ genere + "',"+ duration +",'"+ director + "')");

			
        // get response writer
//        PrintWriter writer = response.getWriter();
//         
//        // build HTML code
//        String htmlRespone = "<html>";
//        htmlRespone += "<h2>Your username is: " + movieName + "<br/>";      
//        htmlRespone += "Your password is: " + genere + "</h2>";    
//        htmlRespone += "</html>";
//         
//        // return response
//        writer.println(htmlRespone);
         
    }
 
}