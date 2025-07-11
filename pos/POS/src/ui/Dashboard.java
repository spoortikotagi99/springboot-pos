package ui;

import model.POSController;
import java.awt.BorderLayout;
import javax.swing.JFrame;

import raven.glasspanepopup.GlassPanePopup;


public class Dashboard extends javax.swing.JFrame {

    private POSController controller;

    public Dashboard(POSController controller) {
        this.controller = controller;
        initComponents();
         
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the JFrame to full size
        setResizable(false); // Make the JFrame non-resizable
        mainPanel.removeAll();
        mainPanel.add(new CustomersUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
        username.setText(POSController.objApplicationSession.getUser().getUsername());
        GlassPanePopup.install(this);
       this.setMinimumSize(this.getSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button1 = new ui.components.Button();
        username = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        menuPanel = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        supplierBtn = new javax.swing.JButton();
        employeeBtn = new javax.swing.JButton();
        productBtn = new javax.swing.JButton();
        customerBtn = new javax.swing.JButton();
        reportsBtn = new javax.swing.JButton();
        invoiceBtn = new javax.swing.JButton();
        saleBtn = new javax.swing.JButton();
        categoryBtn = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POS Dashboard v0.1 2024 CodeCrood");
        setUndecorated(true);
        setResizable(false);

        headerPanel.setBackground(new java.awt.Color(0,26,26));
        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_menu_48px_1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Point of Sale");

        button1.setBackground(new java.awt.Color(0,26,26));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Logout");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("jLabel4");

        close.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("x");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 796, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addComponent(username)
                        .addGap(27, 27, 27)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addComponent(close, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(username)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2))
                            .addGroup(headerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))))
                    .addGroup(headerPanelLayout.createSequentialGroup()
                        .addComponent(close)
                        .addGap(11, 11, 11)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        menuPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(0,128,128));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        supplierBtn.setBackground(new java.awt.Color( 0,26, 26));
        supplierBtn.setForeground(new java.awt.Color(255, 255, 255));
        supplierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_property_24px.png"))); // NOI18N
        supplierBtn.setText("Supplier");
        supplierBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierBtnActionPerformed(evt);
            }
        });

        employeeBtn.setBackground(new java.awt.Color(0,26,26));
        employeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        employeeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/google_forms_24px.png"))); // NOI18N
        employeeBtn.setText("Employees");
        employeeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeBtnActionPerformed(evt);
            }
        });

        productBtn.setBackground(new java.awt.Color(0,26,26));
        productBtn.setForeground(new java.awt.Color(255, 255, 255));
        productBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_property_24px.png"))); // NOI18N
        productBtn.setText("Products");
        productBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productBtnActionPerformed(evt);
            }
        });

        customerBtn.setBackground(new java.awt.Color(0,26,26));
        customerBtn.setForeground(new java.awt.Color(255, 255, 255));
        customerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_user_group_woman_man_24px.png"))); // NOI18N
        customerBtn.setText("Customers");
        customerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                customerBtnFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                customerBtnFocusLost(evt);
            }
        });
        customerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerBtnActionPerformed(evt);
            }
        });

        reportsBtn.setBackground(new java.awt.Color(0,26,26));
        reportsBtn.setForeground(new java.awt.Color(255, 255, 255));
        reportsBtn.setText("Reports");
        reportsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsBtnActionPerformed(evt);
            }
        });

        invoiceBtn.setBackground(new java.awt.Color(0,26,26));
        invoiceBtn.setForeground(new java.awt.Color(255, 255, 255));
        invoiceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/categorize_24px.png"))); // NOI18N
        invoiceBtn.setText("Invoice");
        invoiceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceBtnActionPerformed(evt);
            }
        });

        saleBtn.setBackground(new java.awt.Color(0,26,26));
        saleBtn.setForeground(new java.awt.Color(255, 255, 255));
        saleBtn.setText("Sales");
        saleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleBtnActionPerformed(evt);
            }
        });

        categoryBtn.setBackground(new java.awt.Color(0,26,26));
        categoryBtn.setForeground(new java.awt.Color(255, 255, 255));
        categoryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit_property_24px.png"))); // NOI18N
        categoryBtn.setText("Category");
        categoryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(categoryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportsBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invoiceBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saleBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(supplierBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(customerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(employeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(categoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(invoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        menuPanel.setViewportView(jPanel2);

        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new CustomersUI(controller), BorderLayout.CENTER);
        mainPanel.validate();

    }//GEN-LAST:event_customerBtnActionPerformed
    
    private void supplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new SupplierUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_supplierBtnActionPerformed

    private void employeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new EmployeeUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_employeeBtnActionPerformed

    private void productBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new ProductUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_productBtnActionPerformed

    private void saleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new CartUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
        
    }//GEN-LAST:event_saleBtnActionPerformed

    private void invoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new InvoiceUI(), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_invoiceBtnActionPerformed

    private void reportsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new ReportsUI(), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_reportsBtnActionPerformed

    private void customerBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerBtnFocusGained
        // TODO add your handling code here:


    }//GEN-LAST:event_customerBtnFocusGained

    private void customerBtnFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customerBtnFocusLost
        // TODO add your handling code here:
//        customerBtn.setBackground(new Color(255,0,51));
//        customerBtn.setForeground(Color.white);
    }//GEN-LAST:event_customerBtnFocusLost

    private void categoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBtnActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.add(new CategoryUI(this.controller), BorderLayout.CENTER);
        mainPanel.validate();
    }//GEN-LAST:event_categoryBtnActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        POSController.expireSession();
    }//GEN-LAST:event_button1ActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        controller.expireSession();
        
    }//GEN-LAST:event_closeMouseClicked

     

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.Button button1;
    private javax.swing.JButton categoryBtn;
    private javax.swing.JLabel close;
    private javax.swing.JButton customerBtn;
    private javax.swing.JButton employeeBtn;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton invoiceBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane menuPanel;
    private javax.swing.JButton productBtn;
    private javax.swing.JButton reportsBtn;
    private javax.swing.JButton saleBtn;
    private javax.swing.JButton supplierBtn;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

    
}
