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
import javax.swing.JOptionPane;
import gui.helpers.SimpleListModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import javax.swing.JDialog;

/**
 * 
 * Web-based system for Otago Southland Chinese Association (OSCA)
 * 
 * @author Jill Mirandilla, Kendall Chin, Gary Lee, Sean Braid and Hans To'o
 */
public class MemberDialog extends javax.swing.JDialog {

    MemberDAO dao;
    ValidationHelper validHelp = new ValidationHelper();
    private SimpleListModel MembertModel;

    Member members = new Member();

    public MemberDialog(Window parent, boolean modal, MemberDAO aDao) {
        super(parent);
        setModal(modal);
        dao = aDao;

        initComponents();
        this.MembertModel = new SimpleListModel(members.getChild());

        validHelp.addTypeFormatter(txtId, "#0", Integer.class);
        childList.setModel(MembertModel);
        partnerList.setModel(MembertModel);
        siblingList.setModel(MembertModel);

        int length = 7;
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        txtId.setText((new String(digits)));
        txtId.setEditable(false);

      //     childList.setModel( new SimpleListModel(dao.getChildren()));
        //  MembertModel.updateItems(modal);
        //  revalidate();
        //  repaint();
        jLabel1.setVisible(false);
    }

    public MemberDialog(Window parent, boolean modal, Member productToEdit, MemberDAO aDao) {
        this(parent, modal, aDao);
        this.members = productToEdit;
        txtId.setValue(productToEdit.getId());
        txtFirstName.setText(productToEdit.getFirstName());
        txtLastName.setText(productToEdit.getLastName());
        txtEmail.setText(productToEdit.getEmail());
        txtAddress.setText(productToEdit.getAddress());
        txtPhone.setText(productToEdit.getPhoneNumber());

        if (!productToEdit.getCatagories().isEmpty()) {
            if (productToEdit.getCatagories().get(0).equals("Newsletter")) {
                NewsCheckBox.setSelected(true);
            }

            for (String pt : productToEdit.getCatagories()) {
                if (pt.equals("Newsletter")) {
                    NewsCheckBox.setSelected(true);
                } else if (pt.equals("Basketball")) {
                    BasketballCheckBox.setSelected(true);
                } else if (pt.equals("Social")) {
                    SocialCheckBox.setSelected(true);
                } else if (pt.equals("Fundraising")) {
                    FundraisingCheckBox.setSelected(true);
                } else if (pt.equals("Cultural")) {
                    CulturalCheckBox.setSelected(true);
                } else if (pt.equals("Chinese School")) {
                    ChineseCheckBox.setSelected(true);
                }
            }
        }
        //System.out.println
        if (productToEdit.getSubscription().equals("family")
                || productToEdit.getSubscription().equals("Family (Parents and children under 21) - $20")) {
            subCombo.setSelectedIndex(0);
        } else if (productToEdit.getSubscription().equals("student")
                || productToEdit.getSubscription().equals("Student - $5")) {
            subCombo.setSelectedIndex(2);
        } else if (productToEdit.getSubscription().equals("single")
                || productToEdit.getSubscription().equals("Single Adult - $10")) {
            subCombo.setSelectedIndex(1);
        } else if (productToEdit.getSubscription().equals("adult")
                || productToEdit.getSubscription().equals("Adult 70+ - Free")) {
            subCombo.setSelectedIndex(3);
        }
        txtStatus.setText(productToEdit.getStatus());
        if(productToEdit.getEligibility().equals("Yes")){
            eligibilityCmbBox.setSelectedIndex(0);
        } else if(productToEdit.getEligibility().equals("No")){
            eligibilityCmbBox.setSelectedIndex(1);
        }
        txtId.setEditable(false);
        /*
         childList.updateUI();
         revalidate();
         repaint();
         */

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        popupMenu3 = new java.awt.PopupMenu();
        jFrame1 = new javax.swing.JFrame();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel2 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        addChildren = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtId = new javax.swing.JFormattedTextField();
        txtLastName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblPartner = new javax.swing.JLabel();
        lblChildren = new javax.swing.JLabel();
        lblSibling = new javax.swing.JLabel();
        lblSubscription = new javax.swing.JLabel();
        subCombo = new javax.swing.JComboBox();
        BasketballCheckBox = new javax.swing.JCheckBox();
        ChineseCheckBox = new javax.swing.JCheckBox();
        NewsCheckBox = new javax.swing.JCheckBox();
        SocialCheckBox = new javax.swing.JCheckBox();
        FundraisingCheckBox = new javax.swing.JCheckBox();
        CulturalCheckBox = new javax.swing.JCheckBox();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        childList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        addSibling = new javax.swing.JButton();
        addPartner = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        partnerList = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        siblingList = new javax.swing.JList();
        lblPhone1 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        eligibilityCmbBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        popupMenu3.setLabel("popupMenu3");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("productDialog"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        addChildren.setBackground(new java.awt.Color(153, 153, 153));
        addChildren.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        addChildren.setForeground(new java.awt.Color(255, 255, 255));
        addChildren.setText("Add Children");
        addChildren.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addChildren.setContentAreaFilled(false);
        addChildren.setName("addChildren"); // NOI18N
        addChildren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addChildrenActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(153, 0, 0));
        btnCancel.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancel.setContentAreaFilled(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblId.setBackground(new java.awt.Color(0, 0, 0));
        lblId.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblId.setText("ID:");
        lblId.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblFirstName.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFirstName.setText("First Name:");
        lblFirstName.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtFirstName.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(67, 38, 127));
        txtFirstName.setName("txtFirstName"); // NOI18N
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        lblLastName.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(255, 255, 255));
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLastName.setText("Last Name:");
        lblLastName.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtId.setForeground(new java.awt.Color(67, 38, 127));
        txtId.setText("1");
        txtId.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtId.setName("txtId"); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        lblAddress.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Address:");

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        lblPhone.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setText("Phone:");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        lblPartner.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblPartner.setForeground(new java.awt.Color(255, 255, 255));
        lblPartner.setText("Partner:");

        lblChildren.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblChildren.setForeground(new java.awt.Color(255, 255, 255));
        lblChildren.setText("Children:");

        lblSibling.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblSibling.setForeground(new java.awt.Color(255, 255, 255));
        lblSibling.setText("Sibling:");

        lblSubscription.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblSubscription.setForeground(new java.awt.Color(255, 255, 255));
        lblSubscription.setText("Subscription:");

        subCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Family (Parents and children under 21) - $20", "Single Adult - $10", "Student - $5", "Adult 70+ - Free" }));
        subCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subComboActionPerformed(evt);
            }
        });

        BasketballCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        BasketballCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        BasketballCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        BasketballCheckBox.setText("Basketball");
        BasketballCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BasketballCheckBoxActionPerformed(evt);
            }
        });

        ChineseCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        ChineseCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        ChineseCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        ChineseCheckBox.setText("School");

        NewsCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        NewsCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        NewsCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        NewsCheckBox.setText("Newsletter");
        NewsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewsCheckBoxActionPerformed(evt);
            }
        });

        SocialCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        SocialCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        SocialCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        SocialCheckBox.setText("Social");
        SocialCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SocialCheckBoxActionPerformed(evt);
            }
        });

        FundraisingCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        FundraisingCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        FundraisingCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        FundraisingCheckBox.setText("Fundraising");
        FundraisingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FundraisingCheckBoxActionPerformed(evt);
            }
        });

        CulturalCheckBox.setBackground(new java.awt.Color(153, 0, 0));
        CulturalCheckBox.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        CulturalCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        CulturalCheckBox.setText("Cultural");
        CulturalCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CulturalCheckBoxActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");

        jLabel1.setBackground(new java.awt.Color(153, 0, 0));
        jLabel1.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Activity:");

        btnSave.setBackground(new java.awt.Color(153, 0, 0));
        btnSave.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.setContentAreaFilled(false);
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(153, 0, 0));

        childList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(childList);

        jButton1.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Refresh");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addSibling.setBackground(new java.awt.Color(153, 153, 153));
        addSibling.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        addSibling.setForeground(new java.awt.Color(255, 255, 255));
        addSibling.setText(" Add Sibling");
        addSibling.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addSibling.setContentAreaFilled(false);
        addSibling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSiblingActionPerformed(evt);
            }
        });

        addPartner.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        addPartner.setForeground(new java.awt.Color(255, 255, 255));
        addPartner.setText("Add Partner");
        addPartner.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addPartner.setContentAreaFilled(false);
        addPartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPartnerActionPerformed(evt);
            }
        });

        partnerList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(partnerList);

        siblingList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(siblingList);

        lblPhone1.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        lblPhone1.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone1.setText("Status: ");

        txtStatus.setText("C");
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setLabelFor(eligibilityCmbBox);
        jLabel3.setText("Are you Chinese?");

        eligibilityCmbBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        eligibilityCmbBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eligibilityCmbBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Siblings");

        jLabel6.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Partner");

        jLabel7.setFont(new java.awt.Font("Champagne & Limousines", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Children");

        jLabel8.setFont(new java.awt.Font("Champagne & Limousines", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Membership Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eligibilityCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(95, 95, 95)
                                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(SocialCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(FundraisingCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BasketballCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ChineseCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(NewsCheckBox)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CulturalCheckBox)))
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblFirstName)
                                    .addComponent(lblEmail)
                                    .addComponent(lblAddress)
                                    .addComponent(lblId)
                                    .addComponent(lblPhone1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSubscription)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(subCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtAddress)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblLastName)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLastName))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(lblPhone)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPhone))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblPartner)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblSibling)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addSibling, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblChildren)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addChildren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFirstName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone1)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubscription))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPartner)
                    .addComponent(addPartner)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblChildren)
                            .addComponent(addChildren)
                            .addComponent(addSibling)
                            .addComponent(lblSibling))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SocialCheckBox)
                    .addComponent(FundraisingCheckBox)
                    .addComponent(BasketballCheckBox)
                    .addComponent(ChineseCheckBox)
                    .addComponent(NewsCheckBox)
                    .addComponent(CulturalCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(eligibilityCmbBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addGap(8, 8, 8))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addChildren, addPartner, addSibling});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eligibilityCmbBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eligibilityCmbBoxActionPerformed
        members.setEligibility((String) eligibilityCmbBox.getSelectedItem());
    }//GEN-LAST:event_eligibilityCmbBoxActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void addPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPartnerActionPerformed
        String myName = txtFirstName.getText() + " " + txtLastName.getText();
        PartnerDialog dialog = new PartnerDialog(this, true, dao, myName);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);  // TODO add your handling code here:
    }//GEN-LAST:event_addPartnerActionPerformed

    private void addSiblingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSiblingActionPerformed
        SiblingDialog dialog = new SiblingDialog(this, true, dao);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_addSiblingActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!dao.getPartner().isEmpty()) {
            Object[] partner = dao.getPartner().toArray();
            Member prt = (Member) partner[0];

            members.setPartnersName(prt.getFirstName() + " " + prt.getLastName());
        }

        childList.setModel(new SimpleListModel(dao.getChildren()));
        partnerList.setModel(new SimpleListModel(dao.getPartner()));
        siblingList.setModel(new SimpleListModel(dao.getSibling()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        members.setId((Integer) txtId.getValue());
        members.setFirstName(txtFirstName.getText());
        members.setLastName(txtLastName.getText());
        members.setAddress(txtAddress.getText());
        members.setPhoneNumber(txtPhone.getText());
        members.setSubscription((String) subCombo.getSelectedItem());
        members.setEmail(txtEmail.getText());
        members.setStatus("C");

        ArrayList<String> children = new ArrayList<>();
        if(!dao.getSibling().isEmpty()){
            Object[] objectSibling = dao.getSibling().toArray();
            ArrayList<String> siblings = new ArrayList<>();

            for(Object o: objectSibling){
                Member sb = (Member) o;
                siblings.add(sb.getFirstName());
            }
            members.setSiblingsName(siblings.toString());

            for(Object o: objectSibling){
                Member sb = (Member) o;
                ArrayList<String> sSiblings = new ArrayList<>();
                sSiblings.add(txtFirstName.getText());

                for(String sN : siblings){
                    if(!sN.equals(sb.getFirstName())){
                        sSiblings.add(sN);
                    }

                }
                sb.setSiblingsName(sSiblings.toString());
                System.out.println(sSiblings);
                dao.save(sb);
            }
        }

        if(!dao.getChildren().isEmpty()){
            Object[] objectChildren = dao.getChildren().toArray();

            for(Object o: objectChildren){
                Member ch = (Member) o;
                children.add(ch.getFirstName());
            }
            members.setChildrenName(children.toString());

            //siblings of child
            for(Object o : objectChildren){
                Member ch = (Member) o;
                ArrayList<String> chSiblings = new ArrayList<>();
                for(String c : children){
                    if(!c.equals(ch.getFirstName())){
                        chSiblings.add(c);
                    }
                }
                ch.setSiblingsName(chSiblings.toString());
                dao.save(ch);
            }

            if(!dao.getPartner().isEmpty()){
                Object[] objectPartner = dao.getPartner().toArray();
                Member pt = (Member) objectPartner[0];
                pt.setChildrenName(children.toString());
                dao.save(pt);
            }

        }

        if(!dao.getPartner().isEmpty()){
            Object[] objectPartner = dao.getPartner().toArray();
            Member pt = (Member) objectPartner[0];
            pt.setPartnersName(txtFirstName.getText() + " " + txtLastName.getText());
            pt.setChildrenName(children.toString());
            members.setPartnersName(pt.getFirstName() + " " + pt.getLastName());
            dao.save(pt);
        }

        if (validHelp.isObjectValid(members)) {
            dao.save(members);
            if (!dao.getChildren().isEmpty()) {

                dao.deleteChild();

            }
            if (!dao.getSibling().isEmpty()) {

                dao.deleteSibling();

            }
            if (!dao.getPartner().isEmpty()) {

                dao.deletePartner();

            }
            System.out.println(members);
            this.dispose();

        }
        //  catch (DAOException ex) {
            //     JOptionPane.showMessageDialog(this, ex.getMessage(), "Storage problem.", JOptionPane.ERROR_MESSAGE);

            // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void CulturalCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CulturalCheckBoxActionPerformed

        members.setCatagories("Cultural");
    }//GEN-LAST:event_CulturalCheckBoxActionPerformed

    private void FundraisingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FundraisingCheckBoxActionPerformed
        members.setCatagories("Fundraising");

        // TODO add your handling code here:
    }//GEN-LAST:event_FundraisingCheckBoxActionPerformed

    private void SocialCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SocialCheckBoxActionPerformed
        members.setCatagories("Social");
        // TODO add your handling code here:
    }//GEN-LAST:event_SocialCheckBoxActionPerformed

    private void NewsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewsCheckBoxActionPerformed
        members.setCatagories("Newsletter");

        // TODO add your handling code here:
    }//GEN-LAST:event_NewsCheckBoxActionPerformed

    private void BasketballCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BasketballCheckBoxActionPerformed
        members.setCatagories("Basketball");
        // TODO add your handling code here:
    }//GEN-LAST:event_BasketballCheckBoxActionPerformed

    private void subComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subComboActionPerformed

        members.setSubscription((String) subCombo.getSelectedItem());
        //System.out.println(members.getSubscription());
    }//GEN-LAST:event_subComboActionPerformed

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void addChildrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addChildrenActionPerformed
        ChildDialog dialog = new ChildDialog(this, true, dao);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_addChildrenActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BasketballCheckBox;
    private javax.swing.JCheckBox ChineseCheckBox;
    private javax.swing.JCheckBox CulturalCheckBox;
    private javax.swing.JCheckBox FundraisingCheckBox;
    private javax.swing.JCheckBox NewsCheckBox;
    private javax.swing.JCheckBox SocialCheckBox;
    private javax.swing.JButton addChildren;
    private javax.swing.JButton addPartner;
    private javax.swing.JButton addSibling;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JList childList;
    private javax.swing.JComboBox eligibilityCmbBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblChildren;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPartner;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JLabel lblSibling;
    private javax.swing.JLabel lblSubscription;
    private javax.swing.JList partnerList;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private java.awt.PopupMenu popupMenu3;
    private javax.swing.JList siblingList;
    private javax.swing.JComboBox subCombo;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
