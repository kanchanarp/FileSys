/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnector;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kanchanaR
 */
public class dbHandler {
    private final String username="root";
    private final String password="";
    private final String conString="jdbc:mysql://localhost:3306/fileman";
    private Connection con=null;
    private static dbHandler handler=null;
    
    private dbHandler(){
    
    }
    public static dbHandler gethandler(){
        if(handler==null){
            handler=new dbHandler();
        }
        return handler;
    }
    
    public Connection getConnetction(){
        try{
            con=(Connection) DriverManager.getConnection(conString, username, password);
            return con;
        }catch(Exception ex){
        
        }
        return con;
    }
    
    
    public ResultSet getResultSet(Connection conn,String qry) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Statement stm=conn.createStatement(java.sql.ResultSet.CONCUR_READ_ONLY, java.sql.ResultSet.TYPE_FORWARD_ONLY);
        return stm.executeQuery(qry);
    }
    
}
