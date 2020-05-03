/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.exception;

/**
 *
 * @author sonuy
 */
public class InvalidAccountNumberExceptions   extends Exception{

    public String getText() {
return "Account Number Not Found";
    }
    
}
