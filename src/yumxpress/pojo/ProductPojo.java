/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.pojo;

import java.awt.Image;

/**
 *
 * @author JASRAJ
 */
public class ProductPojo {

    @Override
    public String toString() {
        return "ProductPojo{" + "productId=" + productId + ", companyid=" + companyid + ", productName=" + productName + ", productPrice=" + productPrice + ", productImage=" + productImage + ", productImageType=" + productImageType + '}';
    }
    public ProductPojo(){
        
    }

    public ProductPojo(String productId, String companyid, String productName, double productPrice, Image productImage, String productImageType) {
        this.productId = productId;
        this.companyid = companyid;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productImageType = productImageType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCompanyId() {
        return companyid;
    }

    public void setCompanyId(String companyid) {
        this.companyid = companyid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Image getProductImage() {
        return productImage;
    }

    public void setProductImage(Image productImage) {
        this.productImage = productImage;
    }

    public String getProductImageType() {
        return productImageType;
    }

    public void setProductImageType(String productImageType) {
        this.productImageType = productImageType;
    }
    private String productId;
    private String companyid;
    private String productName;
    private double productPrice;
    private Image productImage;
    private String productImageType;
}
