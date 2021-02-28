/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sai krishna
 */

@WebServlet("/login")
public class admin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
//        String duration = request.getParameter("duration");
//        String director = request.getParameter("director");
         
        System.out.println("Username admin: " + Username);
        System.out.println("Password admin: " + Password);
        PrintWriter writer = response.getWriter();
         
        if(Username.equals("admin") && Password.equals("admin")){
            response.sendRedirect("options.jsp");
        }
        else{
               String htmlResponse = "<html>";
               htmlResponse += "<h2>Invalid Credentials</h2>";        
               htmlResponse += "</html>";
               writer.println(htmlResponse);
        }
         
        // return response
        
        }
    }
}
    

 

