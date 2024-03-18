package yumxpress.gui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yumxpress.dao.OrderDAO;
import yumxpress.pojo.AddCartPojo;
import yumxpress.pojo.OrderPojo;
import yumxpress.pojo.ProductPojo;
import yumxpress.utill.UserProfile;

/**
 *
 * @author AFROZ
 */
public class CustomerCartFrame extends javax.swing.JFrame {
     private DefaultTableModel model;
      private JFrame showFrame;
     private List<ProductPojo> productList;

    /**
     * Creates new form CustomerCartFrame
     */
    public CustomerCartFrame() throws IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.lblUserProfile.setText("Hello "+UserProfile.getUserName());
         model = (DefaultTableModel) jtCartTable.getModel();//downCasting
        loadCartProducts();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCartTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnOrderFood = new javax.swing.JButton();
        btnCancelOrder = new javax.swing.JButton();
        btnOrderHistory = new javax.swing.JButton();
        btnMyAccount = new javax.swing.JButton();
        lblUserProfile = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Cart Frame");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtCartTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtCartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT NAME", "PRODUCT PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCartTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCartTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 620, 370));

        btnBack.setBackground(new java.awt.Color(51, 153, 255));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBack.setForeground(new java.awt.Color(254, 255, 254));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 219, 48));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 630, 460));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOrderFood.setBackground(new java.awt.Color(255, 176, 9));
        btnOrderFood.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOrderFood.setText("Order Food");
        btnOrderFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderFoodActionPerformed(evt);
            }
        });
        jPanel3.add(btnOrderFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 220, 40));

        btnCancelOrder.setBackground(new java.awt.Color(255, 176, 9));
        btnCancelOrder.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCancelOrder.setText("Cancel Order");
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 220, 40));

        btnOrderHistory.setBackground(new java.awt.Color(255, 176, 9));
        btnOrderHistory.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOrderHistory.setText("Order History");
        btnOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderHistoryActionPerformed(evt);
            }
        });
        jPanel3.add(btnOrderHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 220, 40));

        btnMyAccount.setBackground(new java.awt.Color(255, 176, 9));
        btnMyAccount.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnMyAccount.setText("My Account");
        btnMyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyAccountActionPerformed(evt);
            }
        });
        jPanel3.add(btnMyAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 220, 40));

        lblUserProfile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUserProfile.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(lblUserProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, 34));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/user.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 7));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 280, 560));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("My Cart");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtCartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCartTableMouseClicked
           int index =  jtCartTable.getSelectedRow();//give the index of the selected row
        ProductPojo product = productList.get(index);
        
        String[] str = {"remove from cart", "order food"};
        int choice = JOptionPane.showOptionDialog(null, "What do you want to do ?", "Select", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, str, str[1]);
        
        
        if (choice == 0) {
          
            try {

                String ProductId = OrderDAO.removeFromCart(product.getProductId());
                if (ProductId == null) {
                    JOptionPane.showMessageDialog(null, "Sorry ! product cannot be removed removed from Cart");
                    return;
                }

                JOptionPane.showMessageDialog(null, "Product removed Successfully");
                this.dispose();
                new CustomerCartFrame().setVisible(true);
            } catch (SQLException sq) {
                JOptionPane.showMessageDialog(null, "DB ERROR IN CustomerCartFrame ");
                sq.printStackTrace();
            }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Image ERROR IN OrderFoodFrame");
            ex.printStackTrace();
        }

        } else {

            
            showFrame = new OrderProductFrame(product);
            showFrame.setVisible(true);
            this.dispose();
        }
        


    }//GEN-LAST:event_jtCartTableMouseClicked

    private void btnOrderFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderFoodActionPerformed
        new OrderFoodFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOrderFoodActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerCartFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerCartFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerCartFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerCartFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CustomerCartFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(CustomerCartFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnMyAccount;
    private javax.swing.JButton btnOrderFood;
    private javax.swing.JButton btnOrderHistory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jtCartTable;
    private javax.swing.JLabel lblUserProfile;
    // End of variables declaration//GEN-END:variables

    private void loadCartProducts() throws IOException {
        try {
            productList = OrderDAO.getCart();
            if (productList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Your Cart is Empty");
                jtCartTable.setEnabled(false);
                return;

            }
            int i = 0;
            Object[] rows = new Object[2];//becz all datatypes in table are of object 
            while (i < productList.size()) {
                ProductPojo prd = productList.get(i);

                rows[0] = prd.getProductName();
                rows[1] = prd.getProductPrice();
               
                model.addRow(rows);
                i++;

            }
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "DB ERROR IN CustomerCartFrame");
            sq.printStackTrace();
        }
    }

}
