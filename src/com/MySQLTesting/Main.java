package com.MySQLTesting;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
//
        Main m = new Main();
        m.createConnection();
    }
    void createConnection(){
        try{
            //Get a connection to the my sql database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/javadb?characterEncoding=latin1&useConfigs=maxPerformance",
                                                                                System.getenv("username"),//username for the database
                                                                                System.getenv("password"));//password for the database

            Statement stmt = con.createStatement();
            //sends the SQL command to the database to create a new table with the specified columns
            stmt.execute("CREATE TABLE Persons (PersonID int, LastName varchar(255))");

            System.out.println("Database connection successful");
        }catch (ClassNotFoundException | SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}