/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnector;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kanchanaR
 */
public class userHandler {
    dbHandler hand=dbHandler.gethandler();
    
public void info(){
        try {
            
            String sql = "SELECT * FROM usertb";
            ResultSet rs = hand.getResultSet(hand.getConnetction(),sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("max_sec_lvl");
                int age = rs.getInt("cur_sec_lvl");
                String first = rs.getString("username");
                String last = rs.getString("fingerprint");
                
                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
