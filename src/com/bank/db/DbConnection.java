/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.db;

import com.bank.exception.InsufficientFundsExceptions;
import com.bank.exception.InvalidAccountNumberExceptions;
import com.bank.main.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.xml.datatype.DatatypeConstants;

public class DbConnection {
    private String username="postgres";
    private String password="NAGENDRA1@1999";
    private String url="jdbc:postgresql://localhost:5432/Bankdb";
    private String driver="org.postgresql.Driver";
    Connection conn;
    private void dbconn() throws ClassNotFoundException, SQLException
    {
        Class.forName(driver);
        conn=DriverManager.getConnection(url,username,password);
        if(conn==null)
            System.out.print("not connected");
        else
            System.out.print("connected"); 
    }
    private void close() throws SQLException
    {
        conn.close();
    }
    public  void createAcc(Customer c) throws ClassNotFoundException, SQLException
    {
        dbconn();
        String q="insert into customer1(address,email,balance,name,password,accno)"
                + " values (?,?,?,?,?,?);";
        PreparedStatement pstmt=conn.prepareStatement(q);
        pstmt.setString(1,c.getAddress());
        pstmt.setString(2,c.getEmail());
        pstmt.setString(3, c.getBal());
        pstmt.setString(4,c.getName());
        pstmt.setString(5,c.getPassword());
        pstmt.setString(6,c.getAccountno());
        pstmt.executeUpdate();
        close();
        
    }

    public boolean checkacc(String no) 
            throws ClassNotFoundException, SQLException, InvalidAccountNumberExceptions {

        dbconn();
        String q="select * from customer1 where accno=?";
        PreparedStatement pstmt=conn.prepareStatement(q);
        pstmt.setString(1,no);
        ResultSet rs=pstmt.executeQuery();
        int count=0;
        while(rs.next())
        {
            count++;
        }
        
    
    close();
    if(count==1)
        return true;
    throw new InvalidAccountNumberExceptions();
    
    }

    public Customer getdetails(String accno)
            throws ClassNotFoundException, SQLException {

        dbconn();
         Customer c=new Customer();
        String q="select * from customer1 where accno=?";
        PreparedStatement pstmt=conn.prepareStatement(q);
        pstmt.setString(1,accno);
        ResultSet rs=pstmt.executeQuery();
        int count=0;
        while(rs.next())
        {
            c.setAccountno(rs.getString(7));
            c.setAddress(rs.getString(3));
            c.setName(rs.getString(5));
            c.setEmail(rs.getString(4));
            c.setBal(rs.getString(2));

        }
    close();
    return c;
    
    
    }

    public void trans(Customer c, String bal) throws ClassNotFoundException, SQLException {

    dbconn();
        String q="insert into transc(accno ,finalbal,initialbal,amt,date )"
                + " values (?,?,?,?,?);";
        double a1=Double.parseDouble(bal);
        double a2=Double.parseDouble(c.getBal());
        double tot=a1+a2;
        PreparedStatement pstmt=conn.prepareStatement(q);
        pstmt.setString(1,c.getAccountno());
        pstmt.setString(2,Double.toString(tot));
        pstmt.setString(3, c.getBal());
        pstmt.setString(4,bal);
        pstmt.setString(5,LocalDate.now().toString());
//        pstmt.setString(6,c.getAccountno());
        pstmt.executeUpdate();
        close();
    }

    public void upcust(String accountno, double tot) throws ClassNotFoundException, SQLException {

     dbconn();
        String q="update customer1 set balance=? where accno=?;";
        
        PreparedStatement pstmt=conn.prepareStatement(q);
        pstmt.setString(1,Double.toString(tot));
        pstmt.setString(2,accountno);
//        pstmt.setString(6,c.getAccountno());
        pstmt.executeUpdate();
        close();
    
    }

    public void withdraw(Customer c, String bal) throws SQLException, InsufficientFundsExceptions, ClassNotFoundException {
        dbconn();
       double a=Double.parseDouble(bal);
       double a1=Double.parseDouble(c.getBal());
       double sub=a1-a;
       if(a<=a1)
       {
        String q="update  transc set finalbal=? where accno=?";
        PreparedStatement pstmt=conn.prepareStatement(q);
        pstmt.setString(1,Double.toString(sub));
        pstmt.setString(2,c.getAccountno());
        
//        pstmt.setString(6,c.getAccountno());
        pstmt.executeUpdate();
       }
       else
       throw new InsufficientFundsExceptions();
       
        close();    
    }

   
    
}
