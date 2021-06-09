package com;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class registration extends HttpServlet {

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
        
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String location=request.getParameter("location");
        String production=request.getParameter("production");
        String crop=request.getParameter("crop");
        String hum=request.getParameter("hum");
        String most=request.getParameter("most");
        String ph=request.getParameter("ph");
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
          String temprange=mint+","+(mint+10);
          String humrange=minh+","+(minh+10);
          String mosrange=minm+","+(minm+10);
        System.out.println(phrange);
        try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
String sql="insert into reg(firstname,lastname,location,production,crop,hum,most,ph,temp) values(?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, location);
            stmt.setString(4, production);
            stmt.setString(5, crop);
            stmt.setString(6, humrange);
            stmt.setString(7, mosrange);
            stmt.setString(8, phrange);
            stmt.setString(9, temprange);
            
            int i=stmt.executeUpdate();
            if(i>0)
            {
                out.println("successfully insert");
            }
            else
            {
                out.println("fail");
            }

}
 
  catch(Exception e){System.out.println(e);}  
   
                
    }

    

}
