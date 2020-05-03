/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.pro;

import com.bank.db.DbConnection;
import com.bank.exception.InsufficientFundsExceptions;
import com.bank.exception.InvalidAccountNumberExceptions;
import com.bank.main.Customer;
import java.sql.SQLException;

public class User2 {
DbConnection db;
public User2()
{
    db=new DbConnection();
}
    public void checkacc(String accno) throws SQLException, ClassNotFoundException, InvalidAccountNumberExceptions {

        db.checkacc(accno);
     
           
    }

    public Customer getdetails(String accno) throws ClassNotFoundException, SQLException {
 Customer c=db.getdetails(accno);
 return c;
    
    }

    public void transc(Customer c, String bal) throws ClassNotFoundException, SQLException {
        db.trans(c,bal);
    
    }

    public void upcust(String accountno, double tot) throws ClassNotFoundException, SQLException {
db.upcust(accountno,tot);
    }

    public void withdraw(Customer c, String bal) throws SQLException, InsufficientFundsExceptions, ClassNotFoundException {

        db.withdraw(c,bal);
    
    }
    
}
