/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.DAOException;
import dao.MemberDAO;
import domain.Member;
import gui.helpers.ValidationHelper;
import java.awt.Window;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author brase127
 */
public class PartnerDialogOLD extends javax.swing.JDialog {
   MemberDAO dao;
    ValidationHelper validHelp = new ValidationHelper();

    Member members = new Member();
    Member chilren = new Member();
        

    public PartnerDialogOLD(Window parent, boolean modal, MemberDAO aDao) {
        super(parent);
        setModal(modal);
        dao = aDao;
        initComponents();
        validHelp.addTypeFormatter(txtId, "#0", Integer.class);
  
                  int length = 7;
    Random random = new Random();
    char[] digits = new char[length];
    digits[0] = (char) (random.nextInt(9) + '1');
    for (int i = 1; i < length; i++) {
        digits[i] = (char) (random.nextInt(10) + '0');
    }
   txtId.setText((new String(digits)));
   txtId.setEditable(false);
   
  

    }

    public PartnerDialogOLD(Window parent, boolean modal, Member productToEdit, MemberDAO aDao) {
          this(parent, modal, aDao);
        this.members = productToEdit;
        txtId.setValue(productToEdit.getId());
        txtFirstName.setText(productToEdit.getFirstName());
        txtLastName.setText(productToEdit.getLastName());
        txtAddress.setText(productToEdit.getAddress());
        txtPhone.setText(productToEdit.getPhoneNumber());
        

        txtId.setEditable(false);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEmail = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        txtLastName = new javax.swing.JTextField();
        btnCacel = new javax.swing.JButton();
        lblFirstName = new javax.swing.JLabel();
        txtId = new javax.swing.JFormattedTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        basketballCheckbox = new javax.swing.JCheckBox();
        lblId = new javax.swing.JLabel();
        chineseCheckBox = new javax.swing.JCheckBox();
        lblAddress = new javax.swing.JLabel();
        newsCheckBox = new javax.swing.JCheckBox();
        lblPhone = new javax.swing.JLabel();
        socialCheckBox = new javax.swing.JCheckBox();
        lblEmail = new javax.swing.JLabel();
        fundraisingCheckBox = new javax.swing.JCheckBox();
        txtPhone = new javax.swing.JTextField();
        culturalCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 0));
        setForeground(new java.awt.Color(153, 0, 0));

        btnSave.setBackground(new java.awt.Color(153, 0, 0));
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.setContentAreaFilled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCacel.setText("Cancel");

        lblFirstName.setText("First Name:");

        jLabel2.setText("Please Choose:");

        lblLastName.setText("Last Name:");

        basketballCheckbox.setText("Basketball");
        basketballCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basketballCheckboxActionPerformed(evt);
            }
        });

        lblId.setText("ID:");

        chineseCheckBox.setText("School");

        lblAddress.setText("Address:");

        newsCheckBox.setText("Newsletter");

        lblPhone.setText("Phone:");

        socialCheckBox.setText("Social");

        lblEmail.setText("Email:");

        fundraisingCheckBox.setText("Fundraising");

        culturalCheckBox.setText("Cultural");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(basketballCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chineseCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newsCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(socialCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fundraisingCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(culturalCheckBox)
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEmail)
                                    .addComponent(lblPhone)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLastName)
                                        .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFirstName, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                            .addComponent(txtPhone)
                            .addComponent(txtId))
                        .addGap(43, 43, 43))))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(btnCacel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(basketballCheckbox)
                    .addComponent(chineseCheckBox)
                    .addComponent(newsCheckBox)
                    .addComponent(socialCheckBox)
                    .addComponent(fundraisingCheckBox)
                    .addComponent(culturalCheckBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCacel))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        
                members.setId((Integer) txtId.getValue());
                members.setFirstName(txtFirstName.getText());
                members.setLastName(txtLastName.getText());
                members.setAddress(txtAddress.getText());
                members.setPhoneNumber(txtPhone.getText());

                members.setEmail(txtEmail.getText());
                members.setChild(txtFirstName.getText() + " " + txtLastName.getText());
                System.out.println(members.getChild().toString());

            
            if (validHelp.isObjectValid(members)) {

                dao.save(members);
                dao.savePartner(members);

                this.dispose();
            }
        

        // TODO add your handling code here:

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void basketballCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basketballCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_basketballCheckboxActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox basketballCheckbox;
    private javax.swing.JButton btnCacel;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chineseCheckBox;
    private javax.swing.JCheckBox culturalCheckBox;
    private javax.swing.JCheckBox fundraisingCheckBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JCheckBox newsCheckBox;
    private javax.swing.JCheckBox socialCheckBox;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
