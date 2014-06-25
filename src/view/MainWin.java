package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class MainWin extends javax.swing.JFrame {

    
    public MainWin() {
        initComponents();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        opt_exit = new javax.swing.JMenuItem();
        opt_produto = new javax.swing.JMenu();
        opt_c_produto = new javax.swing.JMenuItem();
        opt_l_produto = new javax.swing.JMenuItem();
        opt_cliente = new javax.swing.JMenu();
        opt_cliente_c = new javax.swing.JMenuItem();
        opt_cliente_l = new javax.swing.JMenuItem();
        opt_funcionario = new javax.swing.JMenu();
        opt_funcionario_c = new javax.swing.JMenuItem();
        opt_funcionario_l = new javax.swing.JMenuItem();
        opt_pedido = new javax.swing.JMenu();
        opt_pedido_c = new javax.swing.JMenuItem();
        opt_pedido_l = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Vendas");
        setResizable(false);

        jLabel2.setText("Sistema deVendas v0.0.2");

        jMenu1.setText("File");

        opt_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        opt_exit.setText("Sair");
        opt_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_exitActionPerformed(evt);
            }
        });
        jMenu1.add(opt_exit);

        jMenuBar1.add(jMenu1);

        opt_produto.setText("Produto");

        opt_c_produto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        opt_c_produto.setText("Cadastrar Produto");
        opt_c_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_c_produtoActionPerformed(evt);
            }
        });
        opt_produto.add(opt_c_produto);

        opt_l_produto.setText("Lista de Produtos");
        opt_l_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_l_produtoActionPerformed(evt);
            }
        });
        opt_produto.add(opt_l_produto);

        jMenuBar1.add(opt_produto);

        opt_cliente.setText("Cliente");

        opt_cliente_c.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        opt_cliente_c.setText("Cadastrar Cliente");
        opt_cliente_c.setToolTipText("");
        opt_cliente_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_cliente_cActionPerformed(evt);
            }
        });
        opt_cliente.add(opt_cliente_c);

        opt_cliente_l.setText("Lista de Clientes");
        opt_cliente_l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_cliente_lActionPerformed(evt);
            }
        });
        opt_cliente.add(opt_cliente_l);

        jMenuBar1.add(opt_cliente);

        opt_funcionario.setText("Funcionário");

        opt_funcionario_c.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        opt_funcionario_c.setText("Cadastrar funcionário");
        opt_funcionario_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_funcionario_cActionPerformed(evt);
            }
        });
        opt_funcionario.add(opt_funcionario_c);

        opt_funcionario_l.setText("Lista de Funcionários");
        opt_funcionario_l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_funcionario_lActionPerformed(evt);
            }
        });
        opt_funcionario.add(opt_funcionario_l);

        jMenuBar1.add(opt_funcionario);

        opt_pedido.setText("Pedido");

        opt_pedido_c.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        opt_pedido_c.setText("Cadastrar Pedido");
        opt_pedido_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_pedido_cActionPerformed(evt);
            }
        });
        opt_pedido.add(opt_pedido_c);

        opt_pedido_l.setText("Lista de Pedidos");
        opt_pedido_l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_pedido_lActionPerformed(evt);
            }
        });
        opt_pedido.add(opt_pedido_l);

        jMenuBar1.add(opt_pedido);

        jMenu5.setText("Ferramentas");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(858, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(569, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opt_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_exitActionPerformed
        
        //Fechar Programa
        if ( JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Sair do programa",
                JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION  ) {
            System.exit(0);
        }
        
    }//GEN-LAST:event_opt_exitActionPerformed

    private void opt_c_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_c_produtoActionPerformed
        
        ProdutoWin win = new ProdutoWin(this, true);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        
    }//GEN-LAST:event_opt_c_produtoActionPerformed

    private void opt_l_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_l_produtoActionPerformed
        
        ProdutoListWin win = new ProdutoListWin(this, true);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        
    }//GEN-LAST:event_opt_l_produtoActionPerformed

    private void opt_cliente_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_cliente_cActionPerformed
        
        ClienteWin win = new ClienteWin(this, true);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        
    }//GEN-LAST:event_opt_cliente_cActionPerformed

    private void opt_cliente_lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_cliente_lActionPerformed
        
        ClienteListWin win = new ClienteListWin(this, true);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        
    }//GEN-LAST:event_opt_cliente_lActionPerformed

    private void opt_pedido_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_pedido_cActionPerformed
        
        PedidoWin win = new PedidoWin(this, true);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        
    }//GEN-LAST:event_opt_pedido_cActionPerformed

    private void opt_funcionario_lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_funcionario_lActionPerformed
        
        FuncionarioListWin win = new FuncionarioListWin(this, true);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        
    }//GEN-LAST:event_opt_funcionario_lActionPerformed

    private void opt_funcionario_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_funcionario_cActionPerformed
        
        FuncionarioWin win = new FuncionarioWin(this, true);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        
    }//GEN-LAST:event_opt_funcionario_cActionPerformed

    private void opt_pedido_lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_pedido_lActionPerformed
        
        PedidoListWin win = new PedidoListWin(this, true);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        
    }//GEN-LAST:event_opt_pedido_lActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWin win = new MainWin();
                win.setLocationRelativeTo(null);
                win.setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem opt_c_produto;
    private javax.swing.JMenu opt_cliente;
    private javax.swing.JMenuItem opt_cliente_c;
    private javax.swing.JMenuItem opt_cliente_l;
    private javax.swing.JMenuItem opt_exit;
    private javax.swing.JMenu opt_funcionario;
    private javax.swing.JMenuItem opt_funcionario_c;
    private javax.swing.JMenuItem opt_funcionario_l;
    private javax.swing.JMenuItem opt_l_produto;
    private javax.swing.JMenu opt_pedido;
    private javax.swing.JMenuItem opt_pedido_c;
    private javax.swing.JMenuItem opt_pedido_l;
    private javax.swing.JMenu opt_produto;
    // End of variables declaration//GEN-END:variables
}
