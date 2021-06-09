package com;
import java.sql.*;
/**
 */

public class myconnection {
   public static void main(String args[])
   {
    try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crop","root","");
if(con!=null)
{
    System.out.println(" connection sucessful");
}

}
 
  catch(Exception e){System.out.println(e);}  
   
   }
}
