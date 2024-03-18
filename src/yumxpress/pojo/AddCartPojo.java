/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.pojo;

/**
 *
 * @author JASRAJ
 */
public class AddCartPojo {
    private String productId;
    private String customerId;
    private String orderId;
    private String companyId;

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public AddCartPojo() {
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
    

    public AddCartPojo(String productId, String customerId) {
        this.productId = productId;
        this.customerId = customerId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
