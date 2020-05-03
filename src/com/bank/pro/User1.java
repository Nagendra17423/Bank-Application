
package com.bank.pro;

import com.bank.db.DbConnection;
import com.bank.exception.InvalidCredentialsExceptions;
import com.bank.main.Customer;
import java.sql.SQLException;

/**
 *
 * @author sonuy
 */
public class User1 {
DbConnection db=new DbConnection();
    public boolean validate(String name, String password) throws InvalidCredentialsExceptions {
if(name.equals("admin"))
{
   if(password.equals("1234"))
    return true;
}
   throw new InvalidCredentialsExceptions();
    }

    public void conndb(Customer c) throws ClassNotFoundException, SQLException {
 db.createAcc(c);
    
    }
    
    
}
