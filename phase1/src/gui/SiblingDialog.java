package gui;

import dao.DAOException;
import dao.MemberDAO;
import domain.Member;
import gui.helpers.SimpleListModel;
import gui.helpers.ValidationHelper;
import java.awt.Window;
import javax.swing.JOptionPane;
import gui.MemberDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 * Web-based system for Otago Southland Chinese Association (OSCA)
 * 
 * @author Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid and Hans To'o
 */
public class SiblingDialog extends javax.swing.JDialog {

    MemberDAO dao;
    ValidationHelper validHelp = new ValidationHelper();

    Member members = new Member();
    Member chilren = new Member();

    public SiblingDialog(Window parent, boolean modal, MemberDAO aDao) {
        super(parent);
        setModal(modal);
        dao = aDao;
        initComponents();
        validHelp.addTypeFormatter(txtId, "#0", Integer.class);
        if (!dao.getSibling().isEmpty()) {
            Object[] sibling = dao.getSibling().toArray();
            ArrayList<String> siblings = new ArrayList<>();
            for (Object sb : sibling) {
                Member sib = (Member) sb;

                siblings.add(sib.getFirstName());
            }
        }
        int length = 7;
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        txtId.setText((new String(digits)));
        txtId.setEditable(false);
   //jLabel1.setVisible(false);

    }

    public SiblingDialog(Window parent, boolean modal, Member productToEdit, MemberDAO aDao) {
        this(parent, modal, aDao);
        this.members = productToEdit;
        txtId.setValue(productToEdit.getId());
        txtFirstName.setText(productToEdit.getFirstName());
        txtLastName.setText(productToEdit.getLastName());
        txtAddress.setText(productToEdit.getAddress());
        txtPhone.setText(productToEdit.getPhoneNumber());
        txtStatus.setText(productToEdit.getStatus());

        txtId.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        basketballCheckBox = new javax.swing.JCheckBox();
        chineseCheckBox = new javax.swing.JCheckBox();
        newsletterCheckBox = new javax.swing.JCheckBox();
        socialCheckBox = new javax.swing.JCheckBox();
        fundRaisingCheckBox = new javax.swing.JCheckBox();
        culturalCheckBox = new javax.swing.JCheckBox();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        txtId = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        lblEmail1 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        eligibilityCmbBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        titleLabel.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N

        lblId.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("ID:");

        lblFirstName.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstName.setText("First Name:");

        lblLastName.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(255, 255, 255));
        lblLastName.setText("Last Name:");

        lblAddress.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Address:");

        lblPhone.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setText("Phone:");

        basketballCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        basketballCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        basketballCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        basketballCheckBox.setText("Basketball");
        basketballCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basketballCheckBoxActionPerformed(evt);
            }
        });

        chineseCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        chineseCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        chineseCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        chineseCheckBox.setText("School");

        newsletterCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        newsletterCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        newsletterCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        newsletterCheckBox.setText("Newsletter");

        socialCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        socialCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        socialCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        socialCheckBox.setText("Social");

        fundRaisingCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        fundRaisingCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        fundRaisingCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        fundRaisingCheckBox.setText("Fundraising");

        culturalCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        culturalCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        culturalCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        culturalCheckBox.setText("Cultural");

        lblEmail.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");

        saveButton.setBackground(new java.awt.Color(153, 153, 153));
        saveButton.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save Sibling");
        saveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveButton.setContentAreaFilled(false);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(153, 153, 153));
        cancelButton.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelButton.setContentAreaFilled(false);
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 0, 0));
        jLabel2.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Activity");

        lblEmail1.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblEmail1.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail1.setText("Status: ");

        txtStatus.setText("C");
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setLabelFor(eligibilityCmbBox);
        jLabel1.setText("Are you Chinese:");

        eligibilityCmbBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        eligibilityCmbBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eligibilityCmbBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Champagne & Limousines", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sibling Membership Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(titleLabel))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblFirstName)
                                        .addComponent(lblId)
                                        .addComponent(lblAddress)
                                        .addComponent(lblPhone))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtId)
                                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblLastName)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblEmail)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtEmail)))
                                    .addGap(31, 31, 31))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(64, 64, 64))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGap(30, 30, 30)
                                            .addComponent(lblEmail1)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(eligibilityCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(basketballCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chineseCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newsletterCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(socialCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fundRaisingCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(culturalCheckBox)
                        .addGap(11, 11, 11))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastName))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail1)
                    .addComponent(jLabel1)
                    .addComponent(eligibilityCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basketballCheckBox)
                    .addComponent(chineseCheckBox)
                    .addComponent(newsletterCheckBox)
                    .addComponent(socialCheckBox)
                    .addComponent(fundRaisingCheckBox)
                    .addComponent(culturalCheckBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose(); // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        members.setId((Integer) txtId.getValue());
        members.setFirstName(txtFirstName.getText());
        members.setLastName(txtLastName.getText());
        members.setAddress(txtAddress.getText());
        members.setPhoneNumber(txtPhone.getText());
        members.setStatus(txtStatus.getText());
        members.setEmail(txtEmail.getText());
        //members.setChild(txtFirstName.getText() + " " + txtLastName.getText());
        //System.out.println(members.getChild().toString());

        if (basketballCheckBox.isSelected()) {
            members.setCatagories("Basketball");
        }

        if (chineseCheckBox.isSelected()) {
            members.setCatagories("Chinese School");
        }

        if (culturalCheckBox.isSelected()) {
            members.setCatagories("Cultural");
        }

        if (fundRaisingCheckBox.isSelected()) {
            members.setCatagories("Fundraising");
        }

        if (socialCheckBox.isSelected()) {
            members.setCatagories("Social");
        }

        if (newsletterCheckBox.isSelected()) {
            members.setCatagories("Newsletter");
        }

        if (validHelp.isObjectValid(members)) {

            dao.save(members);
            dao.saveSibling(members);

            this.dispose();

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void basketballCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basketballCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_basketballCheckBoxActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void eligibilityCmbBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eligibilityCmbBoxActionPerformed
        members.setEligibility((String) eligibilityCmbBox.getSelectedItem());
    }//GEN-LAST:event_eligibilityCmbBoxActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox basketballCheckBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox chineseCheckBox;
    private javax.swing.JCheckBox culturalCheckBox;
    private javax.swing.JComboBox eligibilityCmbBox;
    private javax.swing.JCheckBox fundRaisingCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JCheckBox newsletterCheckBox;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox socialCheckBox;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
