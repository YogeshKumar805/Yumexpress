/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dbutill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JASRAJ
 */
public class DBConnection {
     private static Connection conn;//private for oops concept,static because we want to open only one connection at a time
    //we are using static block here bcz we want to open the connection when first use of the class DBConnection happens and we are not using constructer here bcz constructer init the obj and obj contain the instance vars and our class not contain only one var which is static
    //static block runs only once during first use of the class
    static{
        
        try{
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-FJDN2PGR:1521/xe","yumexpress","foodie");
            JOptionPane.showMessageDialog(null,"Connection opened");
               
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Can not open the Connection");
            ex.printStackTrace();
            //System.exit(0);//if connection not open for any reason
            
        }   
    }
    public static Connection getConnection(){//static becz we dont want create any obj 
            return conn;//return connection to the dao
        }
    public static void closeConnection(){
        try{
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"cannot close the connection");
            ex.printStackTrace();
        }
    }
    
}
