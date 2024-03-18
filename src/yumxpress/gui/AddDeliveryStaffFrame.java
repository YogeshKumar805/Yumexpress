package yumxpress.gui;

import java.sql.SQLException;
import java.util.Map;
import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import yumxpress.dao.CompanyDAO;
import yumxpress.dao.StaffDAO;
import yumxpress.pojo.StaffPojo;
import yumxpress.utill.Mailer;
import yumxpress.utill.OwnerProfile;
import yumxpress.utill.PasswordEncryption;
import yumxpress.utill.Validator;


/**
 *
 * @author AFROZ
 */
public class AddDeliveryStaffFrame extends javax.swing.JFrame {

    private JFrame showFrame;
    
    public AddDeliveryStaffFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.lblOwnerProfile.setText("Hello "+OwnerProfile.getOwnerName());
        this.txtCompanyName.setText(OwnerProfile.getCompanyName());
    }
    public boolean validateInputs(){
        char []pwd=this.txtPassword.getPassword();
        if(pwd.length==0||this.txtStaffName.getText().trim().isEmpty()||this.txtEmailId.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please fill all the details");
            return false;
        }
        if(Validator.isValidEmail(this.txtEmailId.getText().trim())==false){
            JOptionPane.showMessageDialog(null,"Please input a valid email id");
            return false;
        }
        return true;
    }
  private void clearAll() {
        txtStaffName.setText("");
        txtEmailId.setText("");
        txtPassword.setText("");
        txtEmailId.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAddStaff = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCompanyName = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStaffName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblOwnerProfile = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnAddFood = new javax.swing.JButton();
        btnViewFood = new javax.swing.JButton();
        btnViewStaff = new javax.swing.JButton();
        btnOrderList = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Delivery Staff Frame");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 255, 254));
        jPanel2.setForeground(new java.awt.Color(255, 176, 9));

        btnAddStaff.setBackground(new java.awt.Color(193, 224, 127));
        btnAddStaff.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAddStaff.setText("Add Staff");
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(254, 255, 254));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(129, 120, 177));
        jLabel3.setText("Enter Email");

        txtCompanyName.setEditable(false);
        txtCompanyName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        txtEmailId.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(254, 255, 254));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(129, 120, 177));
        jLabel4.setText("Enter Name");

        jLabel6.setBackground(new java.awt.Color(254, 255, 254));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(129, 120, 177));
        jLabel6.setText("Password");

        txtStaffName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(254, 255, 254));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(129, 120, 177));
        jLabel1.setText("Company Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtEmailId, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                        .addComponent(txtCompanyName)
                        .addComponent(txtStaffName)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmailId)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(118, 118, 118)
                .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 570, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(129, 120, 177));
        jLabel8.setText("Add Staff");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(129, 120, 177));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOwnerProfile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblOwnerProfile.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.add(lblOwnerProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, 34));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/user.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 197, 280, 10));

        btnAddFood.setBackground(new java.awt.Color(193, 224, 127));
        btnAddFood.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAddFood.setText("Add Food");
        btnAddFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFoodActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 165, 40));

        btnViewFood.setBackground(new java.awt.Color(193, 224, 127));
        btnViewFood.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnViewFood.setText("View Food");
        btnViewFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFoodActionPerformed(evt);
            }
        });
        jPanel3.add(btnViewFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 165, 40));

        btnViewStaff.setBackground(new java.awt.Color(193, 224, 127));
        btnViewStaff.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnViewStaff.setText("View Staff");
        btnViewStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStaffActionPerformed(evt);
            }
        });
        jPanel3.add(btnViewStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 165, 40));

        btnOrderList.setBackground(new java.awt.Color(193, 224, 127));
        btnOrderList.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOrderList.setText("Order List");
        btnOrderList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderListActionPerformed(evt);
            }
        });
        jPanel3.add(btnOrderList, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 165, 40));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel3.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 100, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 280, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
      if(!validateInputs()){
          return;
      }
      try{
          StaffPojo staff=new StaffPojo();
          staff.setCompanyId(OwnerProfile.getCompanyId());
          staff.setEmailId(txtEmailId.getText().trim());
          staff.setStaffName(txtStaffName.getText().trim());
          char []pwd=txtPassword.getPassword();
          String pwdStr=String.valueOf(pwd);
          pwdStr=PasswordEncryption.getEncryptedPassword(pwdStr);
          staff.setPassword(pwdStr);
          String staffId=StaffDAO.addStaff(staff);
          if(staffId==null){
              JOptionPane.showMessageDialog(null,"Registration UnSuccessfull");
              return;
          }
          JOptionPane.showMessageDialog(null,"Registration successful");
          
          
          
          //Write code to send mail
          
           Map<String, String> emailCredentials = CompanyDAO.getEmailCredentailsByCompanyId(OwnerProfile.getCompanyId());
           Mailer.sendMail(emailCredentials, staff);
            
          JOptionPane.showMessageDialog(null,"Mail sent to "+staff.getEmailId());
          clearAll();
      }
      catch(SQLException sq){
            JOptionPane.showMessageDialog(null,"DB ERROR IN AddDeliveryStaffFrame");
            sq.printStackTrace();
        }
      catch(MessagingException ex){
            JOptionPane.showMessageDialog(null,"MAIL ERROR IN AddDeliveryStaffFrame");
            ex.printStackTrace();
        }
     
    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void btnAddFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFoodActionPerformed
     AddFoodFrame foodFrame=new AddFoodFrame();
     foodFrame.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_btnAddFoodActionPerformed

    private void btnViewFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFoodActionPerformed
     ViewFoodFrame foodFrame=new ViewFoodFrame();
     foodFrame.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_btnViewFoodActionPerformed

    private void btnViewStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStaffActionPerformed
     ViewDeliveryStaffFrame staffFrame=new ViewDeliveryStaffFrame();
     staffFrame.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_btnViewStaffActionPerformed

    private void btnOrderListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderListActionPerformed
     OrderListFrame listFrame=new OrderListFrame();
      listFrame.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnOrderListActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
      SellerOptionFrame optionFrame=new SellerOptionFrame();
      optionFrame.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDeliveryStaffFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFood;
    private javax.swing.JButton btnAddStaff;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnOrderList;
    private javax.swing.JButton btnViewFood;
    private javax.swing.JButton btnViewStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblOwnerProfile;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtStaffName;
    // End of variables declaration//GEN-END:variables

   
}
