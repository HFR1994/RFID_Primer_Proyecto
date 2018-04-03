/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm;

import java.sql.*;

/**
 *
 * @author frhec
 */
public class Connector {

    Connection con;
    Statement stmt;

    public Connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo", "root", "hcfr1994");
            //here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
