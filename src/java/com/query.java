package com;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author hp
 */
public class query extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String ph=request.getParameter("ph");
        String most=request.getParameter("most");
        String hum=request.getParameter("hum");
        String temp=request.getParameter("temp");
         
        int p=Integer.parseInt(ph);
        int m=Integer.parseInt(most);
         int h=Integer.parseInt(hum);
          int t=Integer.parseInt(temp);
          
          int minp=(p/2);
          minp=minp*2;
          
          
          int mint=(t/10);
          mint=mint*10;
          
          int minh=(h/10);
          minh=minh*10;
          
          int minm=(m/10);
          minm=minm*10;
          
          String phrange=minp+","+(minp+2);
          String mosrange=minm+","+(minm+10);
           String humrange=minh+","+(minh+10);
          String temprange=mint+","+(mint+10);
         
          
           try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
String sql="select ph, most, hum, temp from reg where production=max(production) group by ph, most, hum, temp";
//String sql="select crop, max(production) from reg where temp=? and ph=? and hum=? and most=?";

            PreparedStatement stmt=con.prepareStatement(sql);
            
            stmt.setString(1, phrange);
            stmt.setString(2, mosrange);
            stmt.setString(3, humrange);
            stmt.setString(4, temprange);
            
            
           
           
               ResultSet rs=stmt.executeQuery();
               
               if(rs.next())
                       {
                          out.println(rs.getString(1)+" "+rs.getString(2));
                       }
}
 
  catch(Exception e){System.out.println(e);}  
   
                
    }

          
          
          
    }

   
    
    

