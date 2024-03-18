/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.utill;

import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author JASRAJ
 */
public class Validator {//validate the email using apache commons library
    public static boolean isValidEmail(String emailId){
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(emailId);
    }
    
     public static boolean isValidMobile(String mobileNo){
        if(mobileNo.length()!=10)
            return false;
        char[] mobArr=mobileNo.toCharArray();//enhanced for not applicable on strings
        for(char ch:mobArr){//convert it to string
            if(Character.isDigit(ch)==false)
                return false;
            
        }
        return true;
        
    }
    
}
