package view;

import control.PedidoControl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class PedidoWin extends javax.swing.JDialog {
    
    PedidoControl ctr = PedidoControl.getInstance();
    int selected;
    int save_opt = 0;

    // Campos
    int id;
    int id_cliente = 0;
    int id_funcionario = 1;
    String data_pedido;
    int status;
    
    public PedidoWin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        // Data atual
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        
        // Valores padrão
        input_data.setText( dateFormat.format(date) );
        
        // Carrega o ID
        input_id.setText( Integer.toString( ctr.getTheNextID() ) );
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opt_status = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        input_id = new javax.swing.JTextField();
        input_data = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_select = new javax.swing.JButton();
        btn_pagamento = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_produtos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        input_cliente = new javax.swing.JTextField();
        btn_select_cliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        input_vendedor = new javax.swing.JTextField();
        btn_select_vendedor = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        radio_cancel = new javax.swing.JRadioButton();
        radio_pen = new javax.swing.JRadioButton();
        radio_confirm = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido");
        setResizable(false);

        jLabel2.setText("ID");

        input_id.setEnabled(false);

        input_data.setEnabled(false);

        jLabel5.setText("Data do Pedido");

        btn_save.setText("Cadastrar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_select.setText("...");
        btn_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectActionPerformed(evt);
            }
        });

        btn_pagamento.setText("Efetuar Pagamento");
        btn_pagamento.setEnabled(false);
        btn_pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagamentoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_produtos.setText("Adicionar Produtos");
        btn_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produtosActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        input_cliente.setEnabled(false);

        btn_select_cliente.setText("Selecionar Cliente");
        btn_select_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_select_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(input_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_select_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(input_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_select_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Vendedor"));

        input_vendedor.setEnabled(false);

        btn_select_vendedor.setText("Selecionar Vendedor");
        btn_select_vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_select_vendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(input_vendedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_select_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(input_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_select_vendedor))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        opt_status.add(radio_cancel);
        radio_cancel.setText("Cancelado");
        radio_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_cancelActionPerformed(evt);
            }
        });

        opt_status.add(radio_pen);
        radio_pen.setSelected(true);
        radio_pen.setText("Pendente");
        radio_pen.setDoubleBuffered(true);
        radio_pen.setFocusCycleRoot(true);
        radio_pen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_penActionPerformed(evt);
            }
        });

        opt_status.add(radio_confirm);
        radio_confirm.setText("Confirmado");
        radio_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(radio_cancel)
            .addComponent(radio_pen)
            .addComponent(radio_confirm)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radio_cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_pen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radio_confirm))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_produtos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_pagamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_save))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(input_id, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_select, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(input_data))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(input_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_select))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_pagamento)
                    .addComponent(btn_produtos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectActionPerformed
        
        try {
            PedidoListWin win = new PedidoListWin(null, true, true);
            win.setLocationRelativeTo(null);
            win.setVisible(true);

            // Pega o objeto selecionado
            this.selected = win.getSelected();
            
            if(this.selected > 0) {
                // Altera a opção de salvar
                btn_save.setText("Salvar");
                this.save_opt = 1;
            
                // Carrega os dados
                ctr.loadValuesByID(this, this.selected);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro! " + ex);
        }
        
    }//GEN-LAST:event_btn_selectActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        
        try {
            
            // Verifica se o cliente e o funcionário foram selecionados
            if( this.id_cliente > 0 && this.id_funcionario > 0) {
                
                this.data_pedido = input_data.getText();

                // Radio Button
                if( radio_confirm.isSelected() ) {
                    this.status = 1;
                }
                if( radio_pen.isSelected() ) {
                    this.status = 0;
                }
                if( radio_cancel.isSelected() ) {
                    this.status = 2;
                }

                if(this.save_opt == 1) {
                    //ctr.update(this.id, this.nome, this.email, this.nasc, this.tel, this.cel, this.end, this.bairro, this.cidade, this.uf, this.comp, this.num );
                } else {
                    //ctr.insert();
                }
                this.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Selecione um cliente e um vendedor!");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro! " + ex);
        }
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_select_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_select_clienteActionPerformed
        
        try {
            
            ClienteListWin win = new ClienteListWin(null, true, true);
            win.setLocationRelativeTo(null);
            win.setVisible(true);

            // Pega o objeto selecionado
            this.id_cliente = win.getSelected();
            
            // Altera o valor do input
            input_cliente.setText( win.getSelected_nome() );

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro! " + ex);
        }
        
    }//GEN-LAST:event_btn_select_clienteActionPerformed

    private void btn_select_vendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_select_vendedorActionPerformed
        
        try {
            
//            VendedorListWin win = new VendedorListWin(null, true, true);
//            win.setLocationRelativeTo(null);
//            win.setVisible(true);

            // Pega o objeto selecionado
            //this.id_cliente = win.getSelected();
            this.id_cliente = 1;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro! " + ex);
        }
                
    }//GEN-LAST:event_btn_select_vendedorActionPerformed

    private void radio_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_confirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio_confirmActionPerformed

    private void radio_penActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_penActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio_penActionPerformed

    private void radio_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_cancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio_cancelActionPerformed

    private void btn_pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pagamentoActionPerformed

    private void btn_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produtosActionPerformed
        
        try {
            
            ProdutoListWin win = new ProdutoListWin(null, true, true);
            win.setLocationRelativeTo(null);
            win.enableListSelect();
            win.setVisible(true);
            
            // Adiciona os itens selecionados na lista
            ctr.addItemTable(table, win.getList());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro! " + ex);
        }
        
    }//GEN-LAST:event_btn_produtosActionPerformed

    public void setId(int id) {
        this.id = id;
        input_id.setText( Integer.toString(id) );
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
            java.util.logging.Logger.getLogger(PedidoWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PedidoWin dialog = new PedidoWin(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_pagamento;
    private javax.swing.JButton btn_produtos;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_select;
    private javax.swing.JButton btn_select_cliente;
    private javax.swing.JButton btn_select_vendedor;
    private javax.swing.JTextField input_cliente;
    private javax.swing.JTextField input_data;
    private javax.swing.JTextField input_id;
    private javax.swing.JTextField input_vendedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup opt_status;
    private javax.swing.JRadioButton radio_cancel;
    private javax.swing.JRadioButton radio_confirm;
    private javax.swing.JRadioButton radio_pen;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
