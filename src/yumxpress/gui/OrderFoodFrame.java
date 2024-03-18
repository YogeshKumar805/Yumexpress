/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.gui;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import yumxpress.dao.CompanyDAO;
import yumxpress.dao.OrderDAO;
import yumxpress.dao.ProductDAO;
import yumxpress.pojo.AddCartPojo;
import yumxpress.pojo.ProductPojo;
import yumxpress.utill.UserProfile;

/**
 *
 * @author AFROZ
 */
public class OrderFoodFrame extends javax.swing.JFrame {

    private Map<String, String> companyMap;
    private List<ProductPojo> productList;
    private int listIndex;
    private JFrame showFrame;
    private ProductPojo p;

    public OrderFoodFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.lblUserProfile.setText("Hello " + UserProfile.getUserName().trim());
        loadCompanyNames();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnCancelOrder = new javax.swing.JButton();
        btnOrderHistory = new javax.swing.JButton();
        btnMyAccount = new javax.swing.JButton();
        btnMyCart = new javax.swing.JButton();
        lblUserProfile = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jcCompanyNames = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        lblProductImage2 = new javax.swing.JLabel();
        lblProductImage3 = new javax.swing.JLabel();
        lblProductImage1 = new javax.swing.JLabel();
        lblProductName2 = new javax.swing.JLabel();
        lblProductName3 = new javax.swing.JLabel();
        lblProductName1 = new javax.swing.JLabel();
        lblProductName4 = new javax.swing.JLabel();
        lblProductImage5 = new javax.swing.JLabel();
        lblProductName5 = new javax.swing.JLabel();
        lblProductImage6 = new javax.swing.JLabel();
        lblProductName6 = new javax.swing.JLabel();
        lblProductImage4 = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order Food Frame");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelOrder.setBackground(new java.awt.Color(255, 176, 9));
        btnCancelOrder.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancelOrder.setText("Cancel Order");
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 220, 40));

        btnOrderHistory.setBackground(new java.awt.Color(255, 176, 9));
        btnOrderHistory.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOrderHistory.setText("Order History");
        btnOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderHistoryActionPerformed(evt);
            }
        });
        jPanel4.add(btnOrderHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 220, 40));

        btnMyAccount.setBackground(new java.awt.Color(255, 176, 9));
        btnMyAccount.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnMyAccount.setText("My Account");
        btnMyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyAccountActionPerformed(evt);
            }
        });
        jPanel4.add(btnMyAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 220, 40));

        btnMyCart.setBackground(new java.awt.Color(255, 176, 9));
        btnMyCart.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnMyCart.setText("My Cart");
        btnMyCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyCartActionPerformed(evt);
            }
        });
        jPanel4.add(btnMyCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 220, 40));

        lblUserProfile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUserProfile.setForeground(new java.awt.Color(51, 51, 51));
        jPanel4.add(lblUserProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, 34));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/user.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 7));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel4.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 140, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 280, 570));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcCompanyNames.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcCompanyNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcCompanyNamesActionPerformed(evt);
            }
        });
        jPanel1.add(jcCompanyNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 132, -1));

        jPanel2.setBackground(new java.awt.Color(254, 255, 254));

        lblProductImage2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductImage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductImage3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductImage3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductImage1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductImage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductName2.setBackground(new java.awt.Color(254, 255, 254));
        lblProductName2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductName2.setForeground(new java.awt.Color(255, 176, 9));
        lblProductName2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductName2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductName3.setBackground(new java.awt.Color(254, 255, 254));
        lblProductName3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductName3.setForeground(new java.awt.Color(255, 176, 9));
        lblProductName3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductName3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductName1.setBackground(new java.awt.Color(254, 255, 254));
        lblProductName1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductName1.setForeground(new java.awt.Color(255, 176, 9));
        lblProductName1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductName1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductName4.setBackground(new java.awt.Color(254, 255, 254));
        lblProductName4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductName4.setForeground(new java.awt.Color(255, 176, 9));
        lblProductName4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductName4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductImage5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductImage5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductImage5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductName5.setBackground(new java.awt.Color(254, 255, 254));
        lblProductName5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductName5.setForeground(new java.awt.Color(255, 176, 9));
        lblProductName5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductName5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductImage6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductImage6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductImage6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductName6.setBackground(new java.awt.Color(254, 255, 254));
        lblProductName6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductName6.setForeground(new java.awt.Color(255, 176, 9));
        lblProductName6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductName6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        lblProductImage4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProductImage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblProductImage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderProductMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProductName4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductName1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProductName2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductImage5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductName5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProductName6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductImage6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductName3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProductImage2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(lblProductImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductName3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProductImage5, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(lblProductImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductImage6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblProductName4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblProductName5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductName6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 94, 710, -1));

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/icons8-left-arrow-64 (1).png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        jPanel1.add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        lblNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/icons8-right-arrow-64.png"))); // NOI18N
        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNextMouseClicked(evt);
            }
        });
        jPanel1.add(lblNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 280, -1, -1));

        jLabel1.setBackground(new java.awt.Color(254, 255, 254));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 176, 9));
        jLabel1.setText("FILTER ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, 22));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Order Food");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 900, 560));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked

    }//GEN-LAST:event_lblBackMouseClicked

    private void lblNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseClicked

    }//GEN-LAST:event_lblNextMouseClicked

    private void lblOrderProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderProductMouseClicked
        JLabel lbl = (JLabel) evt.getSource();//downcasting
        int index = Integer.parseInt(lbl.getName());
        System.out.println("You clicked on:" + index);
        if (index >= productList.size()) {
            JOptionPane.showMessageDialog(null, "Invalid item clicked");
            return;
        }
        String[] str = {"Add To Cart", "Buy Now"};
        int choice = JOptionPane.showOptionDialog(null, "What do you want to do ?", "Select", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, str, str[1]);
        p = productList.get(index);
        if (choice == 0) {
            // Code for add to cart

            AddCartPojo addCart = new AddCartPojo();
            addCart.setCompanyId(p.getCompanyId());
            addCart.setProductId(p.getProductId());
            addCart.setCustomerId(UserProfile.getUserId());
            try {

                String orderId = OrderDAO.addCart(addCart);
                 if ("PRODUCT_ALREADY_IN_CART".equals(orderId)) {
                    JOptionPane.showMessageDialog(null, "Product already exists in your cart");
                    return;
                }
                if (orderId == null) {
                    JOptionPane.showMessageDialog(null, "Sorry ! product cannot be added to Cart");
                    return;
                }

                JOptionPane.showMessageDialog(null, "Product added Successfully to Cart");
                this.dispose();
                new OrderFoodFrame().setVisible(true);
            } catch (SQLException sq) {
                JOptionPane.showMessageDialog(null, "DB ERROR IN OrderFoodFrame");
                sq.printStackTrace();
            }

        } else {

            showFrame = new OrderProductFrame(p);
            showFrame.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_lblOrderProductMouseClicked

    private void jcCompanyNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcCompanyNamesActionPerformed
        String compName = jcCompanyNames.getSelectedItem().toString();
        String compId = companyMap.get(compName);
        if (compId == null) {
            compId = "ALL";
        }
        try {
            productList = ProductDAO.getAllProductsByCompanyId(compId);
            showDetails();
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "DB ERROR IN OrderFoodFrame");
            sq.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Image ERROR IN OrderFoodFrame");
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jcCompanyNamesActionPerformed

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed
        new CancelOrderFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelOrderActionPerformed

    private void btnOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderHistoryActionPerformed
        new OrderHistoryFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOrderHistoryActionPerformed

    private void btnMyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyAccountActionPerformed
        new CustomerAccountFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyAccountActionPerformed

    private void btnMyCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyCartActionPerformed
        try {
            new CustomerCartFrame().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(OrderFoodFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnMyCartActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new CustomerOptionFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderFoodFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnMyAccount;
    private javax.swing.JButton btnMyCart;
    private javax.swing.JButton btnOrderHistory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcCompanyNames;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblProductImage1;
    private javax.swing.JLabel lblProductImage2;
    private javax.swing.JLabel lblProductImage3;
    private javax.swing.JLabel lblProductImage4;
    private javax.swing.JLabel lblProductImage5;
    private javax.swing.JLabel lblProductImage6;
    private javax.swing.JLabel lblProductName1;
    private javax.swing.JLabel lblProductName2;
    private javax.swing.JLabel lblProductName3;
    private javax.swing.JLabel lblProductName4;
    private javax.swing.JLabel lblProductName5;
    private javax.swing.JLabel lblProductName6;
    private javax.swing.JLabel lblUserProfile;
    // End of variables declaration//GEN-END:variables

    private void loadCompanyNames() {
        try {
            companyMap = CompanyDAO.getAllCompanyIdAndName();
            Set<String> companyNames = companyMap.keySet();
            jcCompanyNames.addItem("ALL");
            for (String cname : companyNames) {
                jcCompanyNames.addItem(cname);
            }
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "DB ERROR IN OrderFoodFrame");
            sq.printStackTrace();
        }
    }

    private void showDetails() {
        if (listIndex < productList.size()) {
            ProductPojo p = productList.get(listIndex);
            Image img = p.getProductImage();
            img = img.getScaledInstance(lblProductImage1.getWidth(), lblProductImage1.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblProductImage1.setIcon(icon);
            lblProductName1.setText(p.getProductName());
            lblProductImage1.setName(listIndex + "");
            lblProductName1.setName(listIndex + "");
            listIndex++;
        } else {
            lblProductImage1.setIcon(null);
            lblProductImage1.setText("N/A");
            lblProductName1.setText("N/A");
            lblProductImage1.setName(listIndex + "");
            lblProductName1.setName(listIndex + "");
            listIndex++;
        }
        if (listIndex < productList.size()) {
            ProductPojo p = productList.get(listIndex);
            Image img = p.getProductImage();
            img = img.getScaledInstance(lblProductImage2.getWidth(), lblProductImage2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblProductName2.setText(p.getProductName());
            lblProductImage2.setIcon(icon);
            lblProductImage2.setName(listIndex + "");
            lblProductName2.setName(listIndex + "");
            listIndex++;
        } else {
            lblProductImage2.setIcon(null);
            lblProductImage2.setText("N/A");
            lblProductName2.setText("N/A");
            lblProductImage2.setName(listIndex + "");
            lblProductName2.setName(listIndex + "");
            listIndex++;
        }
        if (listIndex < productList.size()) {
            ProductPojo p = productList.get(listIndex);
            Image img = p.getProductImage();
            img = img.getScaledInstance(lblProductImage3.getWidth(), lblProductImage3.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblProductImage3.setIcon(icon);
            lblProductName3.setText(p.getProductName());
            lblProductImage3.setName(listIndex + "");
            lblProductName3.setName(listIndex + "");
            listIndex++;
        } else {
            lblProductImage3.setIcon(null);
            lblProductImage3.setText("N/A");
            lblProductName3.setText("N/A");
            lblProductImage3.setName(listIndex + "");
            lblProductName3.setName(listIndex + "");
            listIndex++;
        }
        if (listIndex < productList.size()) {
            ProductPojo p = productList.get(listIndex);
            Image img = p.getProductImage();
            img = img.getScaledInstance(lblProductImage4.getWidth(), lblProductImage4.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblProductImage4.setIcon(icon);
            lblProductName4.setText(p.getProductName());
            lblProductImage4.setName(listIndex + "");
            lblProductName4.setName(listIndex + "");
            listIndex++;
        } else {
            lblProductImage4.setIcon(null);
            lblProductImage4.setText("N/A");
            lblProductName4.setText("N/A");
            lblProductImage4.setName(listIndex + "");
            lblProductName4.setName(listIndex + "");
            listIndex++;
        }
        if (listIndex < productList.size()) {
            ProductPojo p = productList.get(listIndex);
            Image img = p.getProductImage();
            img = img.getScaledInstance(lblProductImage5.getWidth(), lblProductImage5.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblProductImage5.setIcon(icon);
            lblProductName5.setText(p.getProductName());
            lblProductImage5.setName(listIndex + "");
            lblProductName5.setName(listIndex + "");
            listIndex++;
        } else {
            lblProductImage5.setIcon(null);
            lblProductImage5.setText("N/A");
            lblProductName5.setText("N/A");
            lblProductImage5.setName(listIndex + "");
            lblProductName5.setName(listIndex + "");
            listIndex++;
        }
        if (listIndex < productList.size()) {
            ProductPojo p = productList.get(listIndex);
            Image img = p.getProductImage();
            img = img.getScaledInstance(lblProductImage6.getWidth(), lblProductImage6.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblProductImage6.setIcon(icon);
            lblProductName6.setText(p.getProductName());
            lblProductImage6.setName(listIndex + "");
            lblProductName6.setName(listIndex + "");
            listIndex++;
        } else {
            lblProductImage6.setIcon(null);
            lblProductImage6.setText("N/A");
            lblProductName6.setText("N/A");
            lblProductImage6.setName(listIndex + "");
            lblProductName6.setName(listIndex + "");
            listIndex++;
        }
    }

}
