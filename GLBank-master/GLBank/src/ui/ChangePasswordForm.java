/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import glbank.database.ConnectionProvider;

/**
 *
 * @author client
 */
public class ChangePasswordForm extends javax.swing.JDialog {

    private int idemp;


    /**
     * Creates new form ChangePasswordForm
     */
    public ChangePasswordForm(java.awt.Frame parent, boolean modal, int idemp) {
        super(parent, modal);
        initComponents();
        this.idemp=idemp;
        lblPasswordsMatch.setVisible(false);
        lblOldPasswordsIncorect.setVisible(false);
        lblInvalidPassword.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        txtNewPassword1 = new javax.swing.JPasswordField();
        txtNewPassword2 = new javax.swing.JPasswordField();
        btnChangePassword = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblPasswordsMatch = new javax.swing.JLabel();
        lblOldPasswordsIncorect = new javax.swing.JLabel();
        lblInvalidPassword = new javax.swing.JLabel();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel1.setText("Old password: ");

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel2.setText("New password: ");

        jLabel3.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        jLabel3.setText("Confirm new password: ");

        txtOldPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNewPassword1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNewPassword2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnChangePassword.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        btnChangePassword.setText("Change password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblPasswordsMatch.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        lblPasswordsMatch.setForeground(new java.awt.Color(255, 51, 51));
        lblPasswordsMatch.setText("Passwords do not match !");

        lblOldPasswordsIncorect.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        lblOldPasswordsIncorect.setForeground(new java.awt.Color(255, 51, 51));
        lblOldPasswordsIncorect.setText("Incorect old password !");

        lblInvalidPassword.setFont(new java.awt.Font("Algerian", 0, 13)); // NOI18N
        lblInvalidPassword.setForeground(new java.awt.Color(255, 51, 51));
        lblInvalidPassword.setText("Invalid new password !");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNewPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblInvalidPassword)
                                    .addComponent(lblPasswordsMatch)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOldPasswordsIncorect)
                                    .addComponent(txtNewPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOldPasswordsIncorect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNewPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInvalidPassword)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPasswordsMatch)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangePassword)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        String oldPassword=new String(txtOldPassword.getPassword());
        String newPassword1=new String(txtNewPassword1.getPassword());
        String newPassword2=new String(txtNewPassword2.getPassword());
        
        boolean validPassword=false;
        lblInvalidPassword.setVisible(false);
        boolean samePasswords=newPassword1.equals(newPassword2);
        if(samePasswords){
            lblPasswordsMatch.setVisible(false);
            validPassword=isPasswordValid(newPassword1);
            if(!validPassword){
                lblInvalidPassword.setVisible(true);
            }
        }
        else{
            lblPasswordsMatch.setVisible(true);
        }
        
        boolean correctOldPassword = new ConnectionProvider().isEmployeePasswordValid(idemp, oldPassword);
        if(correctOldPassword){
            lblOldPasswordsIncorect.setVisible(false);
        }
        else{
            lblOldPasswordsIncorect.setVisible(true);
        }
        
        if(correctOldPassword && samePasswords && validPassword){
            ConnectionProvider conn=new ConnectionProvider();
            conn.changePassword(idemp, newPassword1);
            this.dispose();
        }
    }//GEN-LAST:event_btnChangePasswordActionPerformed

      
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblInvalidPassword;
    private javax.swing.JLabel lblOldPasswordsIncorect;
    private javax.swing.JLabel lblPasswordsMatch;
    private javax.swing.JPasswordField txtNewPassword1;
    private javax.swing.JPasswordField txtNewPassword2;
    private javax.swing.JPasswordField txtOldPassword;
    // End of variables declaration//GEN-END:variables

                     private boolean isPasswordValid(String newPassword) {
                    newPassword = newPassword.trim();
                   if(newPassword.length()<6)
                  return false;
                       boolean lowLetter=false;
                        boolean upperLetter=false;
                          boolean digit=false;
                           boolean nonAlphaNum=false;
                                 for(int i=0;i<newPassword.length(); i++){
                                if(Character.isLowerCase(newPassword.charAt(i)))
                               lowLetter=true;
                             if(Character.isUpperCase(newPassword.charAt(i)))
                            upperLetter=true;
                          if(Character.isDigit(newPassword.charAt(i)))
                         digit=true;
                             if(!Character.isLetter(newPassword.charAt(i)) && !Character.isDigit(newPassword.charAt(i)))
                              nonAlphaNum=true;
        }
                               return lowLetter && upperLetter && digit && nonAlphaNum;
    }
}
