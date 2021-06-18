import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class loginServlet extends HttpServlet {

 public void doGet(HttpServletRequest request, 
  HttpServletResponse response) 
  throws ServletException, IOException {
  
   //String a = request.getParameter("userName");
   //int n = Integer.parseInt(a);


    String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    String USER = "root";
    String PASS = "adhirathan";
    String QUERY = "SELECT * FROM credentials";
    String usrName = request.getParameter("userName");
    String pass = request.getParameter("password");
    ArrayList<String> userName = new ArrayList<String>();
    ArrayList<String> password = new ArrayList<String>();
    
   try
      {
      //Class.forName("com.mysql.jdbc.Driver"); 
      Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.println(rs);
            System.out.print(" First: " + rs.getString("username"));
            System.out.println(" Last: " + rs.getString("password"));
            userName.add(rs.getString("username"));
            password.add(rs.getString("password"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

  PrintWriter out = response.getWriter();
  
  out.println("<HTML>");
  out.println("<HEAD>");
  out.println("</HEAD>");
  out.println("<BODY>");
  out.println("<h1>"+usrName+"</h1>");
  out.println("<h1>"+pass+"</h1>");
  Iterator itr=userName.iterator();
  Iterator itror=password.iterator();
  while(itr.hasNext())
  {
    String u = (String)itr.next();
    String p = (String)itror.next();
    out.println("<h1>"+u+"</h1>");
    out.println("<h1>"+p+"</h1>");
    if(usrName.equals(u) && pass.equals(p))
      out.println("<h1 style= 'color:green'>acess granted</h1>");
    else
      out.println("<h1 style= 'color:red'>acess not granted</h1>");
  }
  out.println("Welcome to the Servlet Testing Center, this is Adhirathan");
  out.println("</BODY>");
  out.println("</HTML>");
 }
}