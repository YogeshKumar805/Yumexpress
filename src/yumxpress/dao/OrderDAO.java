/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import yumxpress.dbutill.DBConnection;
import yumxpress.pojo.AddCartPojo;
import yumxpress.pojo.OrderPojo;
import yumxpress.pojo.PlaceOrderPojo;
import yumxpress.pojo.ProductPojo;

/**
 *
 * @author SCALive
 */
public class OrderDAO {

    public static String getNewId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select max(order_id) from orders");
        rs.next();
        String id = rs.getString(1);
        String ordId = "";
        if (id != null) {
            id = id.substring(4);
            ordId = "ORD-" + (Integer.parseInt(id) + 1);
        } else {
            ordId = "ORD-101";
        }
        return ordId;

    }

    public static String placeOrder(PlaceOrderPojo placeOrder) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?)");
        placeOrder.setOrderId(getNewId());
        ps.setString(1, placeOrder.getOrderId());
        ps.setString(2, placeOrder.getProductId());
        ps.setString(3, placeOrder.getCustomerId());
        ps.setString(4, placeOrder.getDeliveryStaffId());
        ps.setString(5, "");
        ps.setString(6, "ORDERED");
        ps.setString(7, placeOrder.getCompanyId());
        Random rand = new Random();
        int otp = rand.nextInt(1000);
        ps.setInt(8, otp);
        if (ps.executeUpdate() == 1) {
            return placeOrder.getOrderId();
        }
        return null;
    }

    public static OrderPojo getOrderDetailsByOrderId(String orderId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "SELECT c.customer_name, c.address, s.staff_name, c.mobile_no, co.company_name,co.email_id, p.product_name, p.product_price, o.otp "
                + "FROM orders o "
                + "JOIN products p ON o.product_id = p.product_id "
                + "JOIN companies co ON o.company_id = co.company_id "
                + "JOIN customers c ON o.customer_id = c.customer_id "
                + "JOIN staff s ON o.staff_id = s.staff_id "
                + "WHERE o.order_id = ?";
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, orderId);
        ResultSet rs = ps.executeQuery();
        OrderPojo order = null;
        if (rs.next()) {
            order = new OrderPojo();
            order.setOrderId(orderId);
            order.setCustomerName(rs.getString("customer_name"));
            order.setCustomerAddress(rs.getString("address"));
            order.setDeliveryStaffName(rs.getString("staff_name"));
            order.setCustomerPhoneNo(rs.getString("mobile_no"));
            order.setCompanyName(rs.getString("company_name"));
            order.setCompanyEmailId(rs.getString("email_id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductPrice(rs.getDouble("product_price"));
            order.setOtp(rs.getInt("otp"));

        }
        return order;
    }

    public static List<OrderPojo> getNewOrdersForStaff(String staffId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "SELECT o.order_id, o.otp, p.product_name, p.product_price, c.customer_name, c.address, c.mobile_no "
                + "FROM orders o "
                + "JOIN products p ON o.product_id = p.product_id "
                + "JOIN customers c ON o.customer_id = c.customer_id "
                + "WHERE o.staff_id = ? "
                + "  AND o.status = 'ORDERED' "
                + "ORDER BY o.order_id DESC";

        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, staffId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> orderList = new ArrayList<>();
        OrderPojo order = null;
        while (rs.next()) {
            order = new OrderPojo();
            order.setOrderId(rs.getString("order_id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductPrice(rs.getDouble("product_price"));
            order.setCustomerName(rs.getString("customer_name"));
            order.setCustomerAddress(rs.getString("address"));
            order.setCustomerPhoneNo(rs.getString("mobile_no"));
            order.setOtp(rs.getInt("otp"));
            orderList.add(order);

        }
        return orderList;
    }

    public static boolean confirmOrder(String orderId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update orders set status='DELIVERED' where order_id=?");
        ps.setString(1, orderId);
        return ps.executeUpdate() == 1;
    }

    public static String addCart(AddCartPojo cartItem) throws SQLException {//***
        Connection conn = DBConnection.getConnection();
        
     // Check if the product already exists in the cart for the same customer
        String checkIfExistsQuery = "SELECT order_id FROM orders WHERE product_id = ? AND customer_id = ? AND status = 'CART'";
        PreparedStatement p=conn.prepareStatement(checkIfExistsQuery);
        p.setString(1, cartItem.getProductId());
        p.setString(2, cartItem.getCustomerId());
        ResultSet existingCartItems = p.executeQuery();
        
        if (existingCartItems.next()) {
             // Product already exists in the cart
            return "PRODUCT_ALREADY_IN_CART";
        }
        
     // If the product doesn't exist in the cart, add it as a new item
        PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?)");
        cartItem.setOrderId(getNewId());
        ps.setString(1, cartItem.getOrderId());
        ps.setString(2, cartItem.getProductId());
        ps.setString(3, cartItem.getCustomerId());
        ps.setString(4, "");
        ps.setString(5, "");
        ps.setString(6, "CART");
        ps.setString(7, cartItem.getCompanyId());
        ps.setInt(8, 0);
        if (ps.executeUpdate() == 1) {
            return cartItem.getOrderId();
        }
        return null;
    }

    public static List<ProductPojo> getCart() throws SQLException, IOException {
        Connection conn = DBConnection.getConnection();
        String qry = "SELECT p.product_name,p.product_price,p.product_image,p.product_id,o.company_id "
                + "FROM orders o "
                + "JOIN products p ON o.product_id = p.product_id "
                + "WHERE o.status = 'CART' ";

        PreparedStatement ps = conn.prepareStatement(qry);

        ResultSet rs = ps.executeQuery();
        List<ProductPojo> productList = new ArrayList<>();
        ProductPojo product = null;
        while (rs.next()) {
            product = new ProductPojo();
            product.setProductId(rs.getString("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductPrice(rs.getDouble("product_price"));

            product.setCompanyId(rs.getString("company_id"));

            InputStream inputStream = rs.getBinaryStream("product_image");

            // Convert InputStream to BufferedImage
            BufferedImage bufferedImage = ImageIO.read(inputStream);

            // Convert BufferedImage to Image
            Image image = bufferedImage;
            product.setProductImage(image);
            productList.add(product);

        }
        return productList;
    }

    public static String removeFromCart(String productId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = null;
        String qry = "DELETE FROM orders WHERE product_id = ? AND status = 'CART'";
        ps = conn.prepareStatement(qry);
        ps.setString(1, productId);

        if (ps.executeUpdate() == 1) {
            return productId;
        }
        return null;

    }

    public static List<OrderPojo> getNewOrdersForCustomer(String customerId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "SELECT o.order_id, p.product_name, p.product_price, c.address, s.staff_name "
                + "FROM orders o "
                + "JOIN products p ON o.product_id = p.product_id "
                + "JOIN customers c ON o.customer_id = c.customer_id "
                + "JOIN staff s ON o.staff_id = s.staff_id "
                + "WHERE o.customer_id = ? "
                + "  AND o.status = 'ORDERED' "
                + "ORDER BY o.order_id DESC";

        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, customerId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> orderList = new ArrayList<>();
        OrderPojo order = null;
        while (rs.next()) {
            order = new OrderPojo();
            order.setOrderId(rs.getString("order_id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductPrice(rs.getDouble("product_price"));

            order.setCustomerAddress(rs.getString("address"));


            order.setDeliveryStaffName(rs.getString("staff_name"));
            orderList.add(order);

        }
        return orderList;
    }

    public static String cancelOrder(String orderId) throws SQLException {//for canceling the order by the customer
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = null;
        String qry = "UPDATE orders "
                + "SET STATUS='CANCELLED' "
                + "WHERE ORDER_ID = ? AND STATUS='ORDERED'";
        ps = conn.prepareStatement(qry);
        ps.setString(1, orderId);

        if(ps.executeUpdate() == 1) {
            return orderId;
        }
        return null;

    }
    
    public static List<OrderPojo> getDeliverdOrders(String customerId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "SELECT o.order_id, p.product_name, p.product_price, c.address, s.staff_name,comp.company_name,o.review "
                + "FROM orders o "
                + "JOIN products p ON o.product_id = p.product_id "
                + "JOIN customers c ON o.customer_id = c.customer_id "
                + "JOIN staff s ON o.staff_id = s.staff_id "
                +"JOIN companies comp ON s.company_id=comp.company_id "
                + "WHERE o.customer_id = ? "
                + "  AND o.status = 'DELIVERED' "
                + "ORDER BY o.order_id DESC";

        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, customerId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> orderList = new ArrayList<>();
        OrderPojo order = null;
        while (rs.next()) {
            order = new OrderPojo();
            order.setOrderId(rs.getString("order_id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductPrice(rs.getDouble("product_price"));

            order.setCustomerAddress(rs.getString("address"));


            order.setDeliveryStaffName(rs.getString("staff_name"));
            order.setCompanyName(rs.getString("company_name"));
            order.setReview(rs.getString("review"));
            orderList.add(order);

        }
        return orderList;
    }
    
    
     public static String updateDatabaseWithReview(String review,String orderId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = null;
        String qry = "UPDATE orders SET REVIEW = ? WHERE ORDER_ID = ? AND STATUS = 'DELIVERED'";
        ps = conn.prepareStatement(qry);
        ps.setString(1, review);
        ps.setString(2, orderId);

        if(ps.executeUpdate() == 1) {
            return orderId;
        }
        return null;
        
       

    }
     
     
     
       public static List<OrderPojo> getDeliverdOrdersForStaff(String staffId) throws SQLException {
        Connection conn = DBConnection.getConnection();
       String qry = "SELECT o.order_id, p.product_name, p.product_price, c.address, s.staff_name, comp.company_name, o.review "
            + "FROM orders o "
            + "JOIN products p ON o.product_id = p.product_id "
            + "JOIN customers c ON o.customer_id = c.customer_id "
            + "JOIN staff s ON o.staff_id = s.staff_id "
            + "JOIN companies comp ON s.company_id = comp.company_id "
            + "WHERE s.staff_id = ? "
            + "AND o.status = 'DELIVERED' "
            + "ORDER BY o.order_id DESC";
       

        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, staffId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> orderList = new ArrayList<>();
        OrderPojo order = null;
        while (rs.next()) {
            order = new OrderPojo();
            order.setOrderId(rs.getString("order_id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductPrice(rs.getDouble("product_price"));

            order.setCustomerAddress(rs.getString("address"));


            order.setDeliveryStaffName(rs.getString("staff_name"));
            order.setCompanyName(rs.getString("company_name"));
            order.setReview(rs.getString("review"));
            orderList.add(order);

        }
        return orderList;
    }
       
       
       
        public static List<OrderPojo> getDeliverdOrdersForSeller(String  CompanyId) throws SQLException {
        Connection conn = DBConnection.getConnection();
       String qry = "SELECT o.order_id, p.product_name, p.product_price, c.address, s.staff_name, comp.company_name, c.customer_name, o.review "
            + "FROM orders o "
            + "JOIN products p ON o.product_id = p.product_id "
            + "JOIN customers c ON o.customer_id = c.customer_id "
            + "JOIN staff s ON o.staff_id = s.staff_id "
            + "JOIN companies comp ON s.company_id = comp.company_id "
            + "WHERE comp.company_id = ? "
            + "AND o.status = 'DELIVERED' "
            + "ORDER BY o.order_id DESC";
       
 


        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,CompanyId);
        ResultSet rs = ps.executeQuery();
        List<OrderPojo> orderList = new ArrayList<>();
        OrderPojo order = null;
        while (rs.next()) {
            order = new OrderPojo();
            order.setOrderId(rs.getString("order_id"));
            order.setProductName(rs.getString("product_name"));
            order.setProductPrice(rs.getDouble("product_price"));
            

            order.setCustomerAddress(rs.getString("address"));


            order.setDeliveryStaffName(rs.getString("staff_name"));
            order.setCompanyName(rs.getString("company_name"));
            order.setCustomerName(rs.getString("customer_name"));
            order.setReview(rs.getString("review"));
            orderList.add(order);

        }
        return orderList;
    }
    

}
