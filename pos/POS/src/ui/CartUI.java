/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.POSController;
import model.POSFactory;
import model.dto.CustomerDTO;
import model.dto.ProductDTO;
import model.dto.Response;
import model.dto.SaleDTO;


public class
CartUI extends javax.swing.JPanel {

    private POSController controller;
    private ArrayList<ProductDTO> productsList;
    private ArrayList<CustomerDTO> customersList;
    SaleDTO sale;
    /**
     * Creates new form SalesUI
     * @param controller
     */
    public CartUI(POSController controller) {
        this.controller = controller;
        initComponents();
        populateProductsData();
        customersList = this.controller.getCustomers(new Response());
        updateTableDataIntoCustomers(customersList);
        
        sale=new SaleDTO();
        productsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    handleRowSelection();
                }
            }
        });
        initializeCart();
        populateDataIntoCustomers();
        searchHandlerProducts();
        searchHandlerCustomers();
    }
    
    private void searchHandlerCustomers(){
        searchCustomerByName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Handle text insertion
                customersList=controller.searchCustomersByName(searchCustomerByName.getText(),new Response());
        updateTableDataIntoCustomers(customersList);
        
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Handle text removal
                 customersList=controller.searchCustomersByName(searchCustomerByName.getText(),new Response());
        updateTableDataIntoCustomers(customersList);
        
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Handle change in attributes (unlikely for text fields)
            }
        });
    }
    private void searchHandlerProducts(){
        searchByname.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Handle text insertion
                handleSearchTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Handle text removal
                handleSearchTextChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Handle change in attributes (unlikely for text fields)
            }
        });
    }

    private void handleSearchTextChanged() {
        String searchText = searchByname.getText();
        if (!searchText.isEmpty()) {
            Response res = POSFactory.getInstanceOfResponse();
            productsList = controller.searchProductsByName(searchText, res);
             updateProductsTableData(productsList);
        } else {
            // If search field is empty, show all categories
            populateProductsData();
        }
    }

    private void initializeCart() {
        String[] columnNames = {"Name", "Price", "Quantity", "Total"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        cartTable.setModel(defaultTableModel);
    }

    private void updateProductsTableData(ArrayList<ProductDTO> searchResults) {
        String[] columnNames = {"Name", "Price", "Stock"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        for (ProductDTO product : searchResults) {
            Object[] rowData = {product.getProductName(),
                product.getPrice(), product.getStockQuantity()};
            defaultTableModel.addRow(rowData);
        }
        productsTable.setModel(defaultTableModel);
    }

    private void updateTableDataIntoCustomers(ArrayList<CustomerDTO> searchResults) {
        String[] columnNames =  {"Name","Phone No"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        for (CustomerDTO customer : searchResults) {
            Object[] rowData = { customer.getName(),customer.getPhoneNumber()};
            defaultTableModel.addRow(rowData);
        }
        customerTable.setModel(defaultTableModel);
    }

    private void handleRowSelection() {

    }

    private void populateProductsData() {
        Response res = POSFactory.getInstanceOfResponse();
        productsList = controller.getProducts(res);

        String[] columnNames = {"Name", "Price", "Stock"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        for (ProductDTO product : productsList) {
            Object[] rowData = {product.getProductName(), product.getPrice(), product.getStockQuantity()};
            defaultTableModel.addRow(rowData);
        }
        productsTable.setModel(defaultTableModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        cartList = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new rojerusan.RSTableMetro();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        removeItem = new ui.components.Button();
        productList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new rojerusan.RSTableMetro();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchByname = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        addToCartBtn = new ui.components.Button();
        quantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        controls = new javax.swing.JPanel();
        create_invoice = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        totalofcart = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        discountInTotal = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        customerTable = new rojerusan.RSTableMetro();
        searchCustomerByName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        footer = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(255, 0, 51));
        header.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Process Sale");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.add(header, java.awt.BorderLayout.NORTH);

        cartList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTable.setAltoHead(20);
        cartTable.setColorBackgoundHead(new java.awt.Color(0, 0, 204));
        cartTable.setColorBordeFilas(new java.awt.Color(255, 0, 51));
        cartTable.setColorBordeHead(new java.awt.Color(255, 0, 51));
        cartTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        cartTable.setColorFilasForeground1(new java.awt.Color(255, 0, 51));
        cartTable.setColorFilasForeground2(new java.awt.Color(255, 0, 51));
        cartTable.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        cartTable.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cartTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(cartTable);

        jPanel5.setBackground(new java.awt.Color(255, 0, 51));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sale Items");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 0, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        removeItem.setForeground(new java.awt.Color(255, 0, 51));
        removeItem.setText("Remove Item");
        removeItem.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(removeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cartListLayout = new javax.swing.GroupLayout(cartList);
        cartList.setLayout(cartListLayout);
        cartListLayout.setHorizontalGroup(
            cartListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cartListLayout.setVerticalGroup(
            cartListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartListLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        productList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productsTable.setAltoHead(20);
        productsTable.setColorBackgoundHead(new java.awt.Color(255, 0, 51));
        productsTable.setColorBordeFilas(new java.awt.Color(255, 0, 51));
        productsTable.setColorBordeHead(new java.awt.Color(255, 0, 51));
        productsTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        productsTable.setColorFilasForeground1(new java.awt.Color(255, 0, 51));
        productsTable.setColorFilasForeground2(new java.awt.Color(255, 0, 51));
        productsTable.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        productsTable.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        productsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(productsTable);

        jPanel6.setBackground(new java.awt.Color(255, 0, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search  By Name :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(searchByname, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchByname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        addToCartBtn.setForeground(new java.awt.Color(255, 0, 51));
        addToCartBtn.setText("Add to Cart");
        addToCartBtn.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        addToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartBtnActionPerformed(evt);
            }
        });

        quantity.setText("1");
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantity:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addToCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addToCartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout productListLayout = new javax.swing.GroupLayout(productList);
        productList.setLayout(productListLayout);
        productListLayout.setHorizontalGroup(
            productListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        productListLayout.setVerticalGroup(
            productListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productListLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        controls.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        create_invoice.setText("create invoice");
        create_invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_invoiceActionPerformed(evt);
            }
        });

        jButton2.setText("Pay");

        jLabel6.setText("Total:");

        totalofcart.setText("0");

        jLabel7.setText("Discount:");

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.setAltoHead(20);
        customerTable.setColorBackgoundHead(new java.awt.Color(255, 0, 51));
        customerTable.setColorBordeFilas(new java.awt.Color(255, 0, 51));
        customerTable.setColorBordeHead(new java.awt.Color(255, 0, 51));
        customerTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        customerTable.setColorFilasForeground1(new java.awt.Color(255, 0, 51));
        customerTable.setColorFilasForeground2(new java.awt.Color(255, 0, 51));
        customerTable.setColorSelBackgound(new java.awt.Color(255, 0, 51));
        customerTable.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        customerTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(customerTable);

        searchCustomerByName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchCustomerByNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchCustomerByNameKeyTyped(evt);
            }
        });

        jLabel8.setText("Search Customer");

        jLabel3.setText("Paid Amount:");

        jLabel10.setText("Pending Amount:");

        javax.swing.GroupLayout controlsLayout = new javax.swing.GroupLayout(controls);
        controls.setLayout(controlsLayout);
        controlsLayout.setHorizontalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsLayout.createSequentialGroup()
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(controlsLayout.createSequentialGroup()
                            .addComponent(create_invoice)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlsLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(controlsLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(totalofcart))
                                .addGroup(controlsLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(discountInTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(controlsLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchCustomerByName))
                    .addGroup(controlsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlsLayout.setVerticalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchCustomerByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(discountInTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(totalofcart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create_invoice)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                .addComponent(productList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cartList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(controls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cartList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(productList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(body, java.awt.BorderLayout.CENTER);

        footer.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton5.setText("jButton4");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel4");

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap(667, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(353, 353, 353))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jPanel2.add(footer, java.awt.BorderLayout.SOUTH);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartBtnActionPerformed
        int selectedRowIndex = productsTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            ProductDTO selectedProduct = productsList.get(selectedRowIndex);
            DefaultTableModel cartTableModel = (DefaultTableModel) cartTable.getModel();
            Object[] rowData = {selectedProduct.getProductName(), selectedProduct.getPrice(), quantity.getText(), selectedProduct.getPrice() * Integer.parseInt(quantity.getText())};
            cartTableModel.addRow(rowData);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to add to the cart.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        calculateTotal();
        productsTable.clearSelection();
    }//GEN-LAST:event_addToCartBtnActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_quantityActionPerformed
    private void calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < cartTable.getRowCount(); i++) {
            // Extract price and quantity of each item
            double totalPrice = Double.parseDouble(cartTable.getValueAt(i, 3).toString());
            total += totalPrice;
        }
        totalofcart.setText(String.valueOf(total));
    }
    private void create_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_invoiceActionPerformed
        // TODO add your handling code here:
        int rowIndex=customerTable.getSelectedRow();
        if(rowIndex!=-1){
            CustomerDTO customer=customersList.get(rowIndex);
            sale.setCustomer(customer);
        }
        StringBuilder invoice = new StringBuilder();
        invoice.append("--------------------------------------------------------------\n");
        invoice.append("|                          INVOICE                           |\n");
        invoice.append("--------------------------------------------------------------\n\n");

        // Add invoice details
        invoice.append("Invoice Number: ").append(generateInvoiceNumber()).append("\n");
        invoice.append("Date: ").append(getCurrentDateTime()).append("\n");
        invoice.append("Customer: "+sale.getCustomer().getName()+"\n\n"); // You can replace [Customer Name] with actual customer name

        // Add table header
        invoice.append(String.format("| %-30s | %-10s | %-10s | %-10s |\n", "Product Name", "Quantity", "Unit Price", "Total Price"));
        invoice.append("--------------------------------------------------------------\n");

        // Iterate over each row in the cart table to add product details to the invoice
        for (int i = 0; i < cartTable.getRowCount(); i++) {
            String productName = cartTable.getValueAt(i, 0).toString();
            String quantity = cartTable.getValueAt(i, 2).toString();
            String unitPrice = cartTable.getValueAt(i, 1).toString();
            double totalUnitPrice = Double.parseDouble(unitPrice) * Double.parseDouble(quantity);
            invoice.append(String.format("| %-30s | %-10s | %-10s | %-10s |\n", productName, quantity, unitPrice, totalUnitPrice));
        }

        // Add total to the invoice
        invoice.append("--------------------------------------------------------------\n");
        invoice.append(String.format("| %-50s | %-10s |\n", "Total:", totalofcart.getText()));
        invoice.append("--------------------------------------------------------------\n");

        // Display the invoice
        JOptionPane.showMessageDialog(this, "<html><pre>" + invoice.toString() + "</pre></html>", "Invoice", JOptionPane.INFORMATION_MESSAGE);

        // Optionally, you can reset the cart after creating the invoice
        resetCart();
        customerTable.clearSelection();
    }//GEN-LAST:event_create_invoiceActionPerformed

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = cartTable.getSelectedRow();
        // Check if a row is selected
        if (selectedRowIndex != -1) {
            DefaultTableModel cartTableModel = (DefaultTableModel) cartTable.getModel();
            cartTableModel.removeRow(selectedRowIndex);
            calculateTotal();
        }
    }//GEN-LAST:event_removeItemActionPerformed

    private void searchCustomerByNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCustomerByNameKeyPressed
        // TODO add your handling code here:
        customersList=this.controller.searchCustomersByName(searchCustomerByName.getText(),new Response());
        this.updateTableDataIntoCustomers(customersList);
        
    }//GEN-LAST:event_searchCustomerByNameKeyPressed

    private void searchCustomerByNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCustomerByNameKeyTyped
        // TODO add your handling code here:
         
    }//GEN-LAST:event_searchCustomerByNameKeyTyped
    private String generateInvoiceNumber() {
        // Generate a random invoice number or use a sequence generator
        return "INV-" + Math.round(Math.random() * 10000);
    }

    private String getCurrentDateTime() {
        // Get the current date and time in a desired format
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        return now.format(formatter);
    }

    private void resetCart() {
        DefaultTableModel cartTableModel = (DefaultTableModel) cartTable.getModel();
        cartTableModel.setRowCount(0); // Clear cart table
        totalofcart.setText("0"); // Reset total
    }

    private void populateDataIntoCustomers() {
        Response res = POSFactory.getInstanceOfResponse();

        String[] columnNames = {"Name", "Phone No"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null, columnNames);
        customersList=controller.getCustomers(res);
        for (CustomerDTO customer : customersList) {
            Object[] rowData = {customer.getName(), customer.getPhoneNumber()};
            defaultTableModel.addRow(rowData);
        }
        customerTable.setModel(defaultTableModel);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.components.Button addToCartBtn;
    private javax.swing.JPanel body;
    private javax.swing.JPanel cartList;
    private rojerusan.RSTableMetro cartTable;
    private javax.swing.JPanel controls;
    private javax.swing.JButton create_invoice;
    private rojerusan.RSTableMetro customerTable;
    private javax.swing.JTextField discountInTotal;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel productList;
    private rojerusan.RSTableMetro productsTable;
    private javax.swing.JTextField quantity;
    private ui.components.Button removeItem;
    private javax.swing.JTextField searchByname;
    private javax.swing.JTextField searchCustomerByName;
    private javax.swing.JLabel totalofcart;
    // End of variables declaration//GEN-END:variables
}
