package view;

import control.ClienteControl;
import control.memento.ClienteExcluido;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luiz
 */
public class ClienteListWin extends javax.swing.JDialog {

    ClienteControl ctr = ClienteControl.getInstance();
    int row_selected;
    int opt_select;
    int selected;
    String selected_nome;

    /**
     * Com essa variável é possivel recuperar um cliente que foi excluído
     */
    ClienteExcluido cliente_excluido = new ClienteExcluido();

    public ClienteListWin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            // Loading files in the table
            ctr.loadTable(table);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
    }

    public ClienteListWin(java.awt.Frame parent, boolean modal, boolean select) {
        super(parent, modal);
        initComponents();

        try {
            // Loading files in the table
            ctr.loadTable(table);

            // Select option
            if (select) {
                opt_select = 1;
                btn_select.setEnabled(true);
                btn_delete.setEnabled(false);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_select = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_desfazer_exc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "E-mail", "Nascimento", "Telefone", "Celular", "Endereço", "Nº", "Bairro", "Cidade", "UF", "Complemento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btn_select.setText("Selecionar");
        btn_select.setEnabled(false);
        btn_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectActionPerformed(evt);
            }
        });

        btn_delete.setText("Excluir");
        btn_delete.setEnabled(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_desfazer_exc.setText("Desfazer Exclusão");
        btn_desfazer_exc.setEnabled(false);
        btn_desfazer_exc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desfazer_excActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_desfazer_exc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_select))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_select)
                    .addComponent(btn_delete)
                    .addComponent(btn_desfazer_exc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectActionPerformed

        this.selected = Integer.parseInt(table.getValueAt(this.row_selected, 0).toString());
        this.selected_nome = table.getValueAt(this.row_selected, 1).toString();

        this.setVisible(false);

    }//GEN-LAST:event_btn_selectActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed

        try {

            int file_id = Integer.parseInt(table.getValueAt(this.row_selected, 0).toString());

            cliente_excluido.addCliente(file_id);

            ctr.delete(file_id);

            btn_desfazer_exc.setEnabled(true);

            this.refresh();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        this.row_selected = table.getSelectedRow();

        if (this.row_selected >= 0) {

            // Enable buttons
            btn_delete.setEnabled(true);

            if (this.opt_select == 1) {
                btn_select.setEnabled(true);
            }
        }

    }//GEN-LAST:event_tableMouseClicked

    private void btn_desfazer_excActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desfazer_excActionPerformed

        try {

            if (cliente_excluido.desfazerCliente()) {
                
                ctr.insert(cliente_excluido.getClienteNome(), cliente_excluido.getClienteEmail(), "0000-00-00", "", "", "", "", "", "", "", Integer.toString(0));

                this.refresh();
            } else {
                btn_desfazer_exc.setEnabled(false);
            }

        } catch (Exception ex) {
            Logger.getLogger(ClienteListWin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_desfazer_excActionPerformed

    public void refresh() throws Exception {

        // Clean selection
        table.clearSelection();

        // Clean table
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) table.getModel()).removeRow(i);
        }

        // Load table
        ctr.loadTable(table);

        // Check list is empty 
        if (table.getRowCount() == 0) {
            btn_delete.setEnabled(false);
            btn_select.setEnabled(false);
        }

    }

    public int getSelected() {
        return selected;
    }

    public String getSelected_nome() {
        return selected_nome;
    }

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
            java.util.logging.Logger.getLogger(ClienteListWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteListWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteListWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteListWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteListWin dialog = new ClienteListWin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_desfazer_exc;
    private javax.swing.JButton btn_select;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
