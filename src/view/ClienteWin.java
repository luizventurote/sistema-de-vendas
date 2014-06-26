package view;

import control.ClienteControl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class ClienteWin extends javax.swing.JDialog {
    
    ClienteControl ctr = ClienteControl.getInstance();
    int selected;
    int save_opt = 0;

    // Campos
    int id;
    String nome;
    String email;
    String nasc;
    String end;
    String bairro;
    String cidade;
    String comp;
    String uf;
    String num;
    String tel;
    String cel;
    
    public ClienteWin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        // Valores padrão
        input_nome.setText("");
        input_email.setText( "" );
        input_nasc.setText( "0000-00-00" );
        input_end.setText( "" );
        input_bairro.setText( "" );
        input_cidade.setText( "" );
        input_comp.setText( "" );
        input_uf.setText( "" );
        input_num.setText( Integer.toString(0) );
        input_tel.setText( "" );
        input_cel.setText( "" );
        
        // Carrega o ID
        input_id.setText( Integer.toString( ctr.getTheNextID() ) );
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        input_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        input_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        input_email = new javax.swing.JTextField();
        input_nasc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_produtos = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        input_tel = new javax.swing.JTextField();
        input_cel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        input_end = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        input_bairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        input_num = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        input_cidade = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        input_uf = new javax.swing.JTextField();
        input_comp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");
        setResizable(false);

        jLabel1.setText("Nome");

        jLabel2.setText("ID");

        input_id.setEnabled(false);

        jLabel3.setText("E-mail");

        jLabel5.setText("Data de Nascimento");

        btn_save.setText("Cadastrar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_produtos.setText("...");
        btn_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produtosActionPerformed(evt);
            }
        });

        jLabel7.setText("Telefone Fixo");

        jLabel8.setText("Celular");

        jLabel9.setText("Endereço");

        jLabel10.setText("Bairro");

        jLabel11.setText("Número");

        jLabel12.setText("Cidade");

        jLabel13.setText("UF");

        jLabel14.setText("Complemento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(input_nome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(input_id, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(input_email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(input_cel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_end)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(input_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(0, 51, Short.MAX_VALUE))
                                    .addComponent(input_num)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_save))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(input_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(input_comp))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_produtos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_cel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_save)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produtosActionPerformed
        
        try {
            ClienteListWin win = new ClienteListWin(null, true, true);
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
        
    }//GEN-LAST:event_btn_produtosActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        
        try {
            
            this.nome = input_nome.getText();
            this.email = input_email.getText();
            this.nasc = input_nasc.getText();
            this.end = input_end.getText();
            this.bairro = input_bairro.getText();
            this.cidade = input_cidade.getText();
            this.comp = input_comp.getText();
            this.uf = input_uf.getText();
            this.num = input_num.getText();
            this.tel = input_tel.getText();
            this.cel = input_cel.getText();
            
            if(this.save_opt == 1) {
                ctr.update(this.id, this.nome, this.email, this.nasc, this.tel, this.cel, this.end, this.bairro, this.cidade, this.uf, this.comp, this.num );
            } else {
                ctr.insert(this.nome, this.email, this.nasc, this.tel, this.cel, this.end, this.bairro, this.cidade, this.uf, this.comp, this.num );
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            }
            this.setVisible(false);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro! " + ex);
        }
        
    }//GEN-LAST:event_btn_saveActionPerformed

    public void setId(int id) {
        this.id = id;
        input_id.setText( Integer.toString(id) );
    }
    
    public void setNome(String nome) {
        this.nome = nome;
        input_nome.setText( nome );
    }

    public void setEmail(String email) {
        this.email = email;
        input_email.setText( email );
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
        input_nasc.setText( nasc );
    }

    public void setEnd(String end) {
        this.end = end;
        input_end.setText( end );
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
        input_bairro.setText( bairro );
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
        input_cidade.setText( cidade );
    }

    public void setComp(String comp) {
        this.comp = comp;
        input_comp.setText( comp );
    }

    public void setUf(String uf) {
        this.uf = uf;
        input_uf.setText( uf );
    }

    public void setNum(String num) {
        this.num = num;
        input_num.setText( num );
    }

    public void setTel(String tel) {
        this.tel = tel;
        input_tel.setText( tel );
    }

    public void setCel(String cel) {
        this.cel = cel;
        input_cel.setText( cel );
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
            java.util.logging.Logger.getLogger(ClienteWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteWin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteWin dialog = new ClienteWin(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_produtos;
    private javax.swing.JButton btn_save;
    private javax.swing.JTextField input_bairro;
    private javax.swing.JTextField input_cel;
    private javax.swing.JTextField input_cidade;
    private javax.swing.JTextField input_comp;
    private javax.swing.JTextField input_email;
    private javax.swing.JTextField input_end;
    private javax.swing.JTextField input_id;
    private javax.swing.JTextField input_nasc;
    private javax.swing.JTextField input_nome;
    private javax.swing.JTextField input_num;
    private javax.swing.JTextField input_tel;
    private javax.swing.JTextField input_uf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
