/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.pojo;

/**
 *
 * @author SCALive
 */
public class CustomerPojo {

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerPojo(String customerId, String customerName, String emailId, String password, String mobileNo, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailId = emailId;
        this.password = password;
        this.mobileNo = mobileNo;
        this.address = address;
    }
    public CustomerPojo(){
        
    }
    private String customerId;
    private String customerName;
    private String emailId;
    private String password;
    private String mobileNo;
    private String address;
    
}
