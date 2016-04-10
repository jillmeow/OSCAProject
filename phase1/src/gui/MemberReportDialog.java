/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.MemberDAO;
import domain.Member;
import gui.helpers.SimpleListModel;
import gui.helpers.ValidationHelper;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * 
 * Web-based system for Otago Southland Chinese Association (OSCA)
 * 
 * @author Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid and Hans To'o
 */
public class MemberReportDialog extends javax.swing.JDialog {

    MemberDAO dao;
    int theID;
    ValidationHelper validHelp = new ValidationHelper();
    private SimpleListModel MemberModel;

    public MemberReportDialog(java.awt.Frame parent, boolean modal, MemberDAO aDao) {
        super(parent, modal);
        dao = aDao;
        this.MemberModel = new SimpleListModel(dao.getAll());
        initComponents();
        lstProducts.setModel(MemberModel);
        
        System.out.println(dao.getCategories());
        ArrayList<String> allCategories = new ArrayList<>();
        allCategories.add("Basketball");
        allCategories.add("Newsletter");
        allCategories.add("Cultural");
        allCategories.add("Social");
        allCategories.add("Chinese School");
        allCategories.add("Fundraising");
        cmbCategories.setModel(new SimpleListModel(allCategories));
        cmbStatus.setModel(new SimpleListModel(dao.getStatus()));
        validHelp.addTypeFormatter(txtSearchById, "#0", Integer.class);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        lblSearchById = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        cmbCategories = new javax.swing.JComboBox();
        lblCategoryFilter = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtSearchById = new javax.swing.JFormattedTextField();
        lblCategoryFilter1 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        lblSearchById.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblSearchById.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchById.setText("Search by ID:");

        btnSearch.setBackground(new java.awt.Color(153, 0, 0));
        btnSearch.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearch.setContentAreaFilled(false);
        btnSearch.setName("btnSearch"); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cmbCategories.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbCategories.setForeground(new java.awt.Color(67, 38, 127));
        cmbCategories.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategories.setName("cmbCategories"); // NOI18N
        cmbCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriesActionPerformed(evt);
            }
        });

        lblCategoryFilter.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblCategoryFilter.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoryFilter.setText("Category:");

        lstProducts.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lstProducts.setForeground(new java.awt.Color(67, 38, 127));
        lstProducts.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstProducts);

        btnEdit.setBackground(new java.awt.Color(153, 0, 0));
        btnEdit.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEdit.setContentAreaFilled(false);
        btnEdit.setName("btnEdit"); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 0, 0));
        btnDelete.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.setContentAreaFilled(false);
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(153, 0, 0));
        btnClose.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClose.setContentAreaFilled(false);
        btnClose.setName("btnClose"); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtSearchById.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtSearchById.setName("txtSearchById"); // NOI18N

        lblCategoryFilter1.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblCategoryFilter1.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoryFilter1.setText("Status: ");

        cmbStatus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmbStatus.setForeground(new java.awt.Color(67, 38, 127));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbStatus.setName("cmbCategories"); // NOI18N
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Payment");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentMethod(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Champagne & Limousines", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Membership Report");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(lblCategoryFilter1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(lblCategoryFilter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtSearchById)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cmbCategories, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblSearchById, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchById, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchById)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoryFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoryFilter1)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(jButton1)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClose, btnDelete, btnEdit});

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

    private void paymentMethod(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentMethod
        // TODO add your handling code here:
        Member x = (Member) lstProducts.getSelectedValue();
        PaymentDialog pdialog = new PaymentDialog(this, true, dao, x.getId());
        pdialog.setLocationRelativeTo(this);
        pdialog.setVisible(true);
        System.out.println(x.getId());
    }//GEN-LAST:event_paymentMethod

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        if( cmbStatus != null){
            MemberModel.updateItems(dao.getByStatus((String) cmbStatus.getSelectedItem()));
        }// TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (lstProducts.isSelectionEmpty() == false) {
            int result = JOptionPane.showConfirmDialog(
                this, "Are you sure you want to delete this product?");
            // did the user click the yes button?
            if (result == JOptionPane.YES_OPTION) {
                dao.delete((Member) lstProducts.getSelectedValue());
                MemberModel.updateItems(dao.getAll());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (lstProducts.isSelectionEmpty() == true) {
            int result = JOptionPane.showConfirmDialog(
                this, "No product selected.");
            // did the user click the yes button?
            if (result == JOptionPane.CANCEL_OPTION) {
            }

        }
        Member editProduct = (Member) lstProducts.getSelectedValue();
        MemberDialog dialog = new MemberDialog(this, true, editProduct, dao);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        MemberModel.updateItems(dao.getAll());
    }//GEN-LAST:event_btnEditActionPerformed

    private void cmbCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriesActionPerformed
        if( cmbCategories != null){
            MemberModel.updateItems(dao.getByCategories((String) cmbCategories.getSelectedItem()));
        }
    }//GEN-LAST:event_cmbCategoriesActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        MemberModel.updateItems(dao.getById((Integer) (txtSearchById.getValue())));
    }//GEN-LAST:event_btnSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbCategories;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoryFilter;
    private javax.swing.JLabel lblCategoryFilter1;
    private javax.swing.JLabel lblSearchById;
    private javax.swing.JList lstProducts;
    private javax.swing.JFormattedTextField txtSearchById;
    // End of variables declaration//GEN-END:variables
}
