/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.main;

/**
 *
 * @author sonuy
 */
public class Customer {
    private int id;
    private String name;
    private String accountno;
    private String bal;

 
    private String Address;
    private String email;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAccountno() {
        return accountno;
    }

    public String getBal() {
        return bal;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public void setBal(String bal) {
        this.bal = bal;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
