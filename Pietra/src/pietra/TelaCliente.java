/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pietra;

import Dao.Cliente;
import Dao.ClienteDAO;
import Dao.Bairro;
import Dao.BairroDAO;
import TelaPesquisa.BairroSL;
import TelaPesquisa.ClienteSL;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import java.util.List;

/**
 *
 * @author viniciusfurlanetto
 */
public class TelaCliente extends javax.swing.JFrame {    
    List<Cliente> ObjList;
    ClienteDAO objDAO = new ClienteDAO();
    IterableList<Cliente> ObjIterableList;
    Cliente Obj;
    Erros MostraErro = new Erros();
    BairroDAO bDao = new BairroDAO();    
    int piIdBairro;
    
    public TelaCliente() {
        initComponents();
        setLocationRelativeTo(null);        
        
        MaskFormatter maskTelefone;
        MaskFormatter maskCelular;
        try {
            maskTelefone = new MaskFormatter("(##) #####-####");
            maskCelular = new MaskFormatter("(##) #####-####");
            maskCelular.install(jtfCelular); 
            maskTelefone.install(jtfTelefone); 
            
            MaskFormatter maskId = new MaskFormatter("######");
            maskId.install(jtfIdCliente);
            
            piIdBairro = 0;
            
            
            BtnInserirCliente.setVisible(TelaLogin.piIsDiretor == 1);
            BtnAlterarCliente.setVisible(TelaLogin.piIsDiretor == 1);
            BtnExcluirCliente.setVisible(TelaLogin.piIsDiretor == 1);
            BtnLimparTela.setVisible(TelaLogin.piIsDiretor == 1);
                                    
            this.pLimpaTela();
        } catch (ParseException ex) {
            Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }                        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfRazaoSocial = new javax.swing.JTextField();
        jtfEndereco = new javax.swing.JTextField();
        jtfCidade = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox();
        BtnInserirCliente = new javax.swing.JButton();
        BtnAlterarCliente = new javax.swing.JButton();
        BtnExcluirCliente = new javax.swing.JButton();
        BtnLimparTela = new javax.swing.JButton();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jtfCelular = new javax.swing.JFormattedTextField();
        jToolBar2 = new javax.swing.JToolBar();
        BtnPesquisar = new javax.swing.JButton();
        BtnPrimeiro = new javax.swing.JButton();
        BtnAnterior = new javax.swing.JButton();
        BtnProximo = new javax.swing.JButton();
        BtnUltimo = new javax.swing.JButton();
        BtnPesquisar2 = new javax.swing.JButton();
        jtfIdCliente = new javax.swing.JFormattedTextField();

        setTitle("Cadastro de cliente");

        jtfCidade.setEditable(false);
        jtfCidade.setFocusable(false);

        jtfBairro.setEditable(false);
        jtfBairro.setFocusable(false);

        jLabel1.setText("ID:");

        jLabel2.setText("Razão social:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Celular:");

        jLabel5.setText("Endereço:");

        jLabel6.setText("Município:");

        jLabel7.setText("Bairro:");

        jLabel8.setText("Status:");

        jLabel9.setText("Observação:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo", "Arquivado" }));

        BtnInserirCliente.setText("Inserir");
        BtnInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInserirClienteActionPerformed(evt);
            }
        });

        BtnAlterarCliente.setText("Alterar");
        BtnAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarClienteActionPerformed(evt);
            }
        });

        BtnExcluirCliente.setText("Excluir");
        BtnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirClienteActionPerformed(evt);
            }
        });

        BtnLimparTela.setText("Limpar");
        BtnLimparTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparTelaActionPerformed(evt);
            }
        });

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setPreferredSize(new java.awt.Dimension(205, 20));

        BtnPesquisar.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        BtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/find.png"))); // NOI18N
        BtnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnPesquisar.setFocusable(false);
        BtnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnPesquisar.setPreferredSize(new java.awt.Dimension(43, 20));
        BtnPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPesquisarActionPerformed(evt);
            }
        });
        jToolBar2.add(BtnPesquisar);

        BtnPrimeiro.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        BtnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/first.png"))); // NOI18N
        BtnPrimeiro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnPrimeiro.setFocusable(false);
        BtnPrimeiro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnPrimeiro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrimeiroActionPerformed(evt);
            }
        });
        jToolBar2.add(BtnPrimeiro);

        BtnAnterior.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        BtnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/previous.png"))); // NOI18N
        BtnAnterior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnAnterior.setFocusable(false);
        BtnAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAnterior.setPreferredSize(new java.awt.Dimension(43, 20));
        BtnAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnteriorActionPerformed(evt);
            }
        });
        jToolBar2.add(BtnAnterior);

        BtnProximo.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        BtnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/next.png"))); // NOI18N
        BtnProximo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnProximo.setFocusable(false);
        BtnProximo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnProximo.setPreferredSize(new java.awt.Dimension(43, 20));
        BtnProximo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProximoActionPerformed(evt);
            }
        });
        jToolBar2.add(BtnProximo);

        BtnUltimo.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        BtnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/last.png"))); // NOI18N
        BtnUltimo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnUltimo.setFocusable(false);
        BtnUltimo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnUltimo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUltimoActionPerformed(evt);
            }
        });
        jToolBar2.add(BtnUltimo);

        BtnPesquisar2.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        BtnPesquisar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/find.png"))); // NOI18N
        BtnPesquisar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnPesquisar2.setFocusable(false);
        BtnPesquisar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnPesquisar2.setPreferredSize(new java.awt.Dimension(43, 20));
        BtnPesquisar2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnPesquisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPesquisar2ActionPerformed(evt);
            }
        });

        jtfIdCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfIdCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfIdClientepSetaRepresentante(evt);
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
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnInserirCliente)
                                .addGap(61, 61, 61)
                                .addComponent(BtnAlterarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(BtnExcluirCliente)
                                .addGap(62, 62, 62)
                                .addComponent(BtnLimparTela)
                                .addGap(59, 59, 59))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfRazaoSocial)
                            .addComponent(jtfEndereco)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfCidade)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAlterarCliente)
                    .addComponent(BtnInserirCliente)
                    .addComponent(BtnExcluirCliente)
                    .addComponent(BtnLimparTela))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar2, jtfBairro});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInserirClienteActionPerformed
        if (this.pTesta("I")) {
            Cliente Clt = new Cliente();

            Clt.setIdCliente(Integer.parseInt(this.jtfIdCliente.getText().trim()));
            Clt.setRazaoSocial(this.jtfRazaoSocial.getText());
            Clt.setTelefone(this.jtfTelefone.getText());
            Clt.setCelular(this.jtfCelular.getText());
            Clt.setEndereco(this.jtfEndereco.getText());
            Clt.setStatus(this.jComboBox1.getSelectedItem() + "");
            Clt.setObservacao(this.jTextArea1.getText());
            Clt.setIdBairro(piIdBairro);

            objDAO.InserirCliente(Clt);

            this.pLimpaTela();
        }
    }//GEN-LAST:event_BtnInserirClienteActionPerformed

    private void BtnAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarClienteActionPerformed
        if (this.pTesta("A")) {
            Cliente Clt = new Cliente();

            Clt.setIdCliente(Integer.parseInt(this.jtfIdCliente.getText().trim()));
            Clt.setRazaoSocial(this.jtfRazaoSocial.getText());
            Clt.setTelefone(this.jtfTelefone.getText());
            Clt.setCelular(this.jtfCelular.getText());
            Clt.setEndereco(this.jtfEndereco.getText());
            Clt.setStatus(this.jComboBox1.getSelectedItem() + "");
            Clt.setObservacao(this.jTextArea1.getText());
            Clt.setIdBairro(piIdBairro);

            objDAO.AlterarCliente(Clt);                

            this.pLimpaTela();
        }
    }//GEN-LAST:event_BtnAlterarClienteActionPerformed

    private void BtnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirClienteActionPerformed
        boolean lbRet;
        
        if (!"".equals(this.jtfIdCliente.getText().trim())) {
            Obj = objDAO.buscaClienteByID(Integer.parseInt(this.jtfIdCliente.getText().trim()));
            if (Obj.getIdCliente()== -1) {
                MostraErro.pMostraErro("Cliente não cadastrado no banco de dados.", "Erro");
            } else {
                lbRet = objDAO.DeletarCliente(Obj);
                if (!lbRet) MostraErro.pMostraErro("Não é possível excluir. Já existem pedidos para esse cliente.", "Erro");
                this.pLimpaTela();
            }
        } else {
            MostraErro.pMostraErro("Nenhum cliente selecionado.", "Erro");
        }
    }//GEN-LAST:event_BtnExcluirClienteActionPerformed

    private void BtnLimparTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparTelaActionPerformed
        this.pLimpaTela();
    }//GEN-LAST:event_BtnLimparTelaActionPerformed

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        ClienteSL lookup = new ClienteSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void BtnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrimeiroActionPerformed
        Obj = ObjIterableList.first();
        this.pPreenchetela(Obj);
    }//GEN-LAST:event_BtnPrimeiroActionPerformed

    private void BtnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnteriorActionPerformed
        Obj = ObjIterableList.previous();
        this.pPreenchetela(Obj);
    }//GEN-LAST:event_BtnAnteriorActionPerformed

    private void BtnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProximoActionPerformed
        Obj = ObjIterableList.next();
        this.pPreenchetela(Obj);
    }//GEN-LAST:event_BtnProximoActionPerformed

    private void BtnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUltimoActionPerformed
        Obj = ObjIterableList.last();
        this.pPreenchetela(Obj);
    }//GEN-LAST:event_BtnUltimoActionPerformed

    private void BtnPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisar2ActionPerformed
        BairroSL lookup = new BairroSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar2ActionPerformed

    private void jtfIdClientepSetaRepresentante(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfIdClientepSetaRepresentante
        if (!"".equals(this.jtfIdCliente.getText().trim())) {
            Obj = objDAO.buscaClienteByID(Integer.parseInt(this.jtfIdCliente.getText().trim()));
            this.pPreenchetela(Obj);
        }
    }//GEN-LAST:event_jtfIdClientepSetaRepresentante

    public void pPreencheBairro (Bairro obj) {        
        piIdBairro = obj.getIdBairro();
        if (obj.getIdBairro() != -1) {            
            this.jtfBairro.setText(obj.getNome());
            this.jtfCidade.setText(obj.getNomeMunicipio());            
        }
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
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCliente().setVisible(true);
            }
        });
    }
    
    public boolean pTesta (String psTipo){        
        if ("".equals(this.jtfIdCliente.getText().trim())) {
            MostraErro.pMostraErro("Código (ID) inválido!", "Erro");
            return false;
        } else if ("I".equals(psTipo)){
            Obj = objDAO.buscaClienteByID(Integer.parseInt(this.jtfIdCliente.getText().trim()));
            if (Obj.getIdCliente()!= -1) {
                MostraErro.pMostraErro("Código (ID) já cadastrado!", "Erro");
                return false;
            }
        }
        if ("".equals(this.jtfRazaoSocial.getText())) {
            MostraErro.pMostraErro("Razão social inválida!", "Erro");
            return false;
        }
        if ("".equals(this.jtfBairro.getText())) {
            MostraErro.pMostraErro("Bairro inválido!", "Erro");
            return false;
        }
        this.pSetaBrancos();

        return true;
    }
    
    public void pSetaBrancos (){
        if ("".equals(this.jtfEndereco.getText())) {
            this.jtfEndereco.setText(" ");
        }
        if ("".equals(this.jTextArea1.getText())) {
            this.jTextArea1.setText(" ");
        }
        
    }
    
    public void pLimpaTela(){
        this.jtfIdCliente.setText("");
        this.jtfBairro.setText("");
        this.jtfCelular.setText("");
        this.jtfCidade.setText("");
        this.jtfEndereco.setText("");
        this.jtfRazaoSocial.setText("");
        this.jtfTelefone.setText("");
        this.jTextArea1.setText("");
        this.jComboBox1.setSelectedItem("Ativo");
        
        ObjList = objDAO.pPreencheListCliente();
        ObjIterableList = new IterableList <> (ObjList);
    }
    
    public void pPreenchetela(Cliente obj){
        if (obj.getIdCliente() != -1){
            this.jtfIdCliente.setText(Integer.toString(obj.getIdCliente()));
            this.jtfBairro.setText(Integer.toString(obj.getIdBairro()));
            this.jtfCelular.setText(obj.getCelular());
            this.jtfEndereco.setText(obj.getEndereco());
            this.jtfRazaoSocial.setText(obj.getRazaoSocial());
            this.jtfTelefone.setText(obj.getTelefone());
            this.jTextArea1.setText(obj.getObservacao());
            this.jComboBox1.setSelectedItem(obj.getStatus());
            
            Bairro b =  bDao.buscaBairroByID(obj.getIdBairro());
            this.pPreencheBairro(b);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlterarCliente;
    private javax.swing.JButton BtnAnterior;
    private javax.swing.JButton BtnExcluirCliente;
    private javax.swing.JButton BtnInserirCliente;
    private javax.swing.JButton BtnLimparTela;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnPesquisar2;
    private javax.swing.JButton BtnPrimeiro;
    private javax.swing.JButton BtnProximo;
    private javax.swing.JButton BtnUltimo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JFormattedTextField jtfCelular;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JFormattedTextField jtfIdCliente;
    private javax.swing.JTextField jtfRazaoSocial;
    private javax.swing.JFormattedTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
}
