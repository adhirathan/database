import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class test extends HttpServlet {

 public void doGet(HttpServletRequest request, 
  HttpServletResponse response) 
  throws ServletException, IOException {
  
   String a = request.getParameter("userName");

    ArrayList<String> userName = new ArrayList<String>();
    ArrayList<String> password = new ArrayList<String>();
    

  PrintWriter out = response.getWriter();
  
  out.println("{'format':'json'}" + a);

 }
}