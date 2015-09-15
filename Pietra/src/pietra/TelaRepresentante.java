/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pietra;

import Dao.Representante;
import Dao.RepresentanteDAO;
import TelaPesquisa.RepresSL;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import java.text.DecimalFormat;

/**
 *
 * @author vinicius furlanetto
 */
public class TelaRepresentante extends javax.swing.JFrame {
    List<Representante> ObjList;
    RepresentanteDAO ObjDAO = new RepresentanteDAO ();
    IterableList<Representante> ObjIterableList;
    Representante Obj;
    Erros MostraErro = new Erros();    
    DecimalFormat DecNum = new DecimalFormat("#0.00");

    public TelaRepresentante() {
        initComponents();
        setLocationRelativeTo(null);
        
        try {
            MaskFormatter maskTelefone = new MaskFormatter("(##) #####-####");
            maskTelefone.install(jtfTelefone);
            
            MaskFormatter maskCelular = new MaskFormatter("(##) #####-####");
            maskCelular.install(jtfCelular);            
            
            MaskFormatter maskPerc = new MaskFormatter("##.##");
            maskPerc.install(jtfPercComissao);
            
            MaskFormatter maskId = new MaskFormatter("######");
            maskId.install(jtfIdRepresentante);
            
            this.pLimpaTela();            
        } catch (ParseException ex) {
            Logger.getLogger(TelaRepresentante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfPercComissao = new javax.swing.JFormattedTextField();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jtfCelular = new javax.swing.JFormattedTextField();
        BtnInserirRepres = new javax.swing.JButton();
        BtnAlterarRepres = new javax.swing.JButton();
        BtnExcluirRepresentante = new javax.swing.JButton();
        BtnLimparTela1 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        BtnPesquisar = new javax.swing.JButton();
        BtnPrimeiro = new javax.swing.JButton();
        BtnAnterior = new javax.swing.JButton();
        BtnProximo = new javax.swing.JButton();
        BtnUltimo = new javax.swing.JButton();
        jtfIdRepresentante = new javax.swing.JFormattedTextField();

        setTitle("Cadastro de representante");

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Celular:");

        jLabel5.setText("Perc. comissão:");

        jtfPercComissao.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        BtnInserirRepres.setText("Inserir");
        BtnInserirRepres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInserirRepresActionPerformed(evt);
            }
        });

        BtnAlterarRepres.setText("Alterar");
        BtnAlterarRepres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarRepresActionPerformed(evt);
            }
        });

        BtnExcluirRepresentante.setText("Excluir");
        BtnExcluirRepresentante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirRepresentanteActionPerformed(evt);
            }
        });

        BtnLimparTela1.setText("Limpar");
        BtnLimparTela1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparTela1ActionPerformed(evt);
            }
        });

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

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

        jtfIdRepresentante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfIdRepresentante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaRepresentante(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPercComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfIdRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfNome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jtfTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(BtnInserirRepres)
                .addGap(18, 18, 18)
                .addComponent(BtnAlterarRepres)
                .addGap(18, 18, 18)
                .addComponent(BtnExcluirRepresentante)
                .addGap(18, 18, 18)
                .addComponent(BtnLimparTela1)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jtfIdRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jtfPercComissao, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInserirRepres)
                    .addComponent(BtnAlterarRepres)
                    .addComponent(BtnLimparTela1)
                    .addComponent(BtnExcluirRepresentante))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnInserirRepresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInserirRepresActionPerformed
        if (this.pTesta("I")) {
            double lnPerc = Double.parseDouble(this.jtfPercComissao.getText());            
            Obj = new Representante();

            Obj.setIdRepres(Integer.parseInt(this.jtfIdRepresentante.getText().trim()));
            Obj.setNome(this.jtfNome.getText());
            Obj.setTelefone(this.jtfTelefone.getText());
            Obj.setCelular(this.jtfCelular.getText());
            Obj.setPerComissao(lnPerc);        

            ObjDAO.InserirRepres(Obj);

            this.pLimpaTela();
        }
    }//GEN-LAST:event_BtnInserirRepresActionPerformed

    private void BtnAlterarRepresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarRepresActionPerformed
        if (this.pTesta("A")) {
            double lnPerc = Double.parseDouble(this.jtfPercComissao.getText());

            Obj = new Representante();

            Obj.setIdRepres(Integer.parseInt(this.jtfIdRepresentante.getText().trim()));
            Obj.setNome(this.jtfNome.getText());
            Obj.setTelefone(this.jtfTelefone.getText());
            Obj.setCelular(this.jtfCelular.getText());
            Obj.setPerComissao(lnPerc);

            if (this.jtfIdRepresentante.getText().trim().length() > 0) {
                ObjDAO.AlterarRepres(Obj);
            }                
            this.pLimpaTela();
        }
    }//GEN-LAST:event_BtnAlterarRepresActionPerformed

    private void BtnExcluirRepresentanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirRepresentanteActionPerformed
        boolean lbRet;
        
        if (!"".equals(this.jtfIdRepresentante.getText().trim())) {
            Obj = ObjDAO.buscaRepresByID(Integer.parseInt(this.jtfIdRepresentante.getText().trim()));
            if (Obj.getIdRepres()== -1) {
                MostraErro.pMostraErro("Representante não cadastrado no banco de dados.", "Erro");
            } else {
                lbRet = ObjDAO.DeletarRepres(Obj);
                if (!lbRet) MostraErro.pMostraErro("Não é possível excluir. Já existem pedidos para esse representante.", "Erro");
                this.pLimpaTela();
            }
        } else {
            MostraErro.pMostraErro("Nenhum representante selecionado.", "Erro");
        }
    }//GEN-LAST:event_BtnExcluirRepresentanteActionPerformed
    
    private void BtnLimparTela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparTela1ActionPerformed
        this.pLimpaTela();
    }//GEN-LAST:event_BtnLimparTela1ActionPerformed
    
    public boolean pTesta (String psTipo){        
        if ("".equals(this.jtfIdRepresentante.getText().trim())) {
            MostraErro.pMostraErro("Código (ID) inválido!", "Erro");
            return false;
        } else if ("I".equals(psTipo)){
            Obj = ObjDAO.buscaRepresByID(Integer.parseInt(this.jtfIdRepresentante.getText().trim()));
            if (Obj.getIdRepres() != -1) {
                MostraErro.pMostraErro("Código (ID) já cadastrado!", "Erro");
                return false;
            }
        }
        if ("".equals(this.jtfNome.getText())) {
            MostraErro.pMostraErro("Nome inválido!", "Erro");
            return false;
        }
        
        try {  
            Double.parseDouble(this.jtfPercComissao.getText());  
        } catch (Exception e) {
            MostraErro.pMostraErro("Percentual de comissão inválido!", "Erro");
            return false;
        }
                
        return true;
    }
    
    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        RepresSL lookup = new RepresSL(this);
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

    private void pSetaRepresentante(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaRepresentante
        if (!"".equals(this.jtfIdRepresentante.getText().trim())) {
            Obj = ObjDAO.buscaRepresByID(Integer.parseInt(this.jtfIdRepresentante.getText().trim()));
            this.pPreenchetela(Obj);
        }
    }//GEN-LAST:event_pSetaRepresentante

    public void pLimpaTela(){
        this.jtfIdRepresentante.setText("");
        this.jtfNome.setText("");
        this.jtfCelular.setText("");
        this.jtfPercComissao.setText("");
        this.jtfTelefone.setText("");
        
        ObjList = ObjDAO.pPreencheListRepres();
        ObjIterableList = new IterableList <> (ObjList);
    }
    
    public void pPreenchetela(Representante obj){
        if (obj.getIdRepres() != -1) {
            this.jtfPercComissao.setText(DecNum.format(obj.getPerComissao()).replace(',', '.'));
            this.jtfIdRepresentante.setText(Integer.toString(obj.getIdRepres()));
            this.jtfNome.setText(obj.getNome());
            this.jtfCelular.setText(obj.getCelular());
            this.jtfTelefone.setText(obj.getTelefone());
        }
    }
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
            java.util.logging.Logger.getLogger(TelaRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRepresentante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaRepresentante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlterarRepres;
    private javax.swing.JButton BtnAnterior;
    private javax.swing.JButton BtnExcluirRepresentante;
    private javax.swing.JButton BtnInserirRepres;
    private javax.swing.JButton BtnLimparTela1;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnPrimeiro;
    private javax.swing.JButton BtnProximo;
    private javax.swing.JButton BtnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JFormattedTextField jtfCelular;
    private javax.swing.JFormattedTextField jtfIdRepresentante;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JFormattedTextField jtfPercComissao;
    private javax.swing.JFormattedTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
}
