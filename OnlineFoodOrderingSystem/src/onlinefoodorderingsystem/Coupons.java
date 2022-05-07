/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinefoodorderingsystem;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mahmo
 */
public class Coupons extends javax.swing.JFrame 
{

    static public Admin tempAdmin = new Admin();

    /**
     * Creates new form Coupons
     */
    public Coupons(Admin a) 
    {
        initComponents();
        DB_Connection_Assem conn = new DB_Connection_Assem();
        CoupounsData = conn.displayCoupons(CoupounsData);
        tempAdmin = a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CoupounsData = new javax.swing.JTable();
        AddCopoun = new javax.swing.JButton();
        DeleteCopoun = new javax.swing.JButton();
        UpdateCopoun = new javax.swing.JButton();
        IdLabel = new javax.swing.JTextField();
        CodeLabel = new javax.swing.JTextField();
        DescLabel = new javax.swing.JTextField();
        DateLabel = new javax.swing.JTextField();
        DiscLabel = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Admin Menu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("Coupons Menu");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        CoupounsData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Coupon ID", "Coupon Code", "Coupon Description", "Expiry Date", "Discount Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CoupounsData.getTableHeader().setReorderingAllowed(false);
        CoupounsData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoupounsDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CoupounsData);
        if (CoupounsData.getColumnModel().getColumnCount() > 0) {
            CoupounsData.getColumnModel().getColumn(0).setResizable(false);
            CoupounsData.getColumnModel().getColumn(1).setResizable(false);
            CoupounsData.getColumnModel().getColumn(3).setResizable(false);
            CoupounsData.getColumnModel().getColumn(4).setResizable(false);
        }

        AddCopoun.setText("Add Copoun");
        AddCopoun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCopounActionPerformed(evt);
            }
        });

        DeleteCopoun.setText("Delete Copoun");
        DeleteCopoun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCopounActionPerformed(evt);
            }
        });

        UpdateCopoun.setText("Update Copoun");
        UpdateCopoun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCopounActionPerformed(evt);
            }
        });

        IdLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdLabelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 346, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BackButton)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(314, 314, 314))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(AddCopoun, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(149, 149, 149))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(IdLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(CodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DescLabel)
                                    .addComponent(DeleteCopoun, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addComponent(UpdateCopoun))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DiscLabel))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiscLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddCopoun)
                    .addComponent(DeleteCopoun)
                    .addComponent(UpdateCopoun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(BackButton)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        AdminMenu menu = new AdminMenu(tempAdmin);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void AddCopounActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCopounActionPerformed
        // TODO add your handling code here:
        CreateCoupon create = new CreateCoupon(tempAdmin);
        create.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_AddCopounActionPerformed

    private void DeleteCopounActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCopounActionPerformed
        // TODO add your handling code here: 
        DB_Connection_Assem con = new DB_Connection_Assem();
        if (IdLabel.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please select a coupon to update first");
        } else
        {
            tempAdmin.getM_FoodOrderingSysCoupons().Remove_Coupon(Integer.valueOf(CodeLabel.getText()));
            this.dispose();
            Coupons newMenu = new Coupons(tempAdmin);
            newMenu.setVisible(true);
            
        }
        

    }//GEN-LAST:event_DeleteCopounActionPerformed

    private void UpdateCopounActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCopounActionPerformed
        // TODO add your handling code here:
        DB_Connection_Assem con = new DB_Connection_Assem();
        if (IdLabel.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Please select a coupon to update first");
        } else 
        {
            UpdateCouponForm form = new UpdateCouponForm(Integer.parseInt(IdLabel.getText()), tempAdmin);
            form.setVisible(true);
            this.dispose();
        }


    }//GEN-LAST:event_UpdateCopounActionPerformed

    private void IdLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdLabelActionPerformed

    private void CoupounsDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoupounsDataMouseClicked
        // TODO add your handling code here:]
        int index = CoupounsData.getSelectedRow();
        DefaultTableModel dft = (DefaultTableModel) CoupounsData.getModel();
        IdLabel.setText(dft.getValueAt(index, 0).toString());
        CodeLabel.setText(dft.getValueAt(index, 1).toString());
        DescLabel.setText(dft.getValueAt(index, 2).toString());
        DateLabel.setText(dft.getValueAt(index, 3).toString());
        DiscLabel.setText(dft.getValueAt(index, 4).toString());
    }//GEN-LAST:event_CoupounsDataMouseClicked

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
            java.util.logging.Logger.getLogger(Coupons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Coupons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Coupons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Coupons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Coupons(tempAdmin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCopoun;
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField CodeLabel;
    private javax.swing.JTable CoupounsData;
    private javax.swing.JTextField DateLabel;
    private javax.swing.JButton DeleteCopoun;
    private javax.swing.JTextField DescLabel;
    private javax.swing.JTextField DiscLabel;
    private javax.swing.JTextField IdLabel;
    private javax.swing.JButton UpdateCopoun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
