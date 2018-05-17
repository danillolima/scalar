/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;
import java.sql.*;
/**
 *
 * @author Danillo Lima
 */
public class ConMySQL {
    public static boolean conexa(){
        boolean t;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql:/ /localhost:3306/scalar","root","root");
            t = true; 
        }catch(Exception e){
            e.printStackTrace();
            t = false; 
        }
        return t;
    }
    
}
