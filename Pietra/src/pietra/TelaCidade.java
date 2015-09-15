/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pietra;

import Dao.Municipio;
import Dao.MunicipioDAO;
import Dao.Representante;
import Dao.RepresentanteDAO;
import TelaPesquisa.MunicipioSL;
import TelaPesquisa.RepresCitySL;
import java.util.List;

/**
 *
 * @author viniciusfurlanetto
 */
public class TelaCidade extends javax.swing.JFrame {    
    List<Municipio> ObjList;
    MunicipioDAO objDAO = new MunicipioDAO();
    IterableList<Municipio> ObjIterableList;
    Municipio Obj;
    Erros MostraErro = new Erros();
    RepresentanteDAO bDao = new RepresentanteDAO();       
    
    public TelaCidade() {
        initComponents();
        setLocationRelativeTo(null);
            
        this.pLimpaTela();        
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdMunicipio = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnAlterarRepMun = new javax.swing.JButton();
        BtnLimparTela = new javax.swing.JButton();
        jtfIdRepres = new javax.swing.JFormattedTextField();
        jtfNomeRepres = new javax.swing.JFormattedTextField();
        jToolBar2 = new javax.swing.JToolBar();
        BtnPesquisar = new javax.swing.JButton();
        BtnPrimeiro = new javax.swing.JButton();
        BtnAnterior = new javax.swing.JButton();
        BtnProximo = new javax.swing.JButton();
        BtnUltimo = new javax.swing.JButton();
        BtnPesquisar1 = new javax.swing.JButton();

        setTitle("Vincula Representante ao Município");

        jtfIdMunicipio.setEditable(false);
        jtfIdMunicipio.setFocusable(false);
        jtfIdMunicipio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaMunicipio(evt);
            }
        });

        jtfNome.setEditable(false);
        jtfNome.setFocusable(false);

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Representante");

        BtnAlterarRepMun.setText("Salvar");
        BtnAlterarRepMun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarRepMunActionPerformed(evt);
            }
        });

        BtnLimparTela.setText("Limpar");
        BtnLimparTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparTelaActionPerformed(evt);
            }
        });

        jtfIdRepres.setEditable(false);
        jtfIdRepres.setFocusable(false);

        jtfNomeRepres.setEditable(false);
        jtfNomeRepres.setFocusable(false);

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

        BtnPesquisar1.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
        BtnPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/find.png"))); // NOI18N
        BtnPesquisar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnPesquisar1.setFocusable(false);
        BtnPesquisar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnPesquisar1.setPreferredSize(new java.awt.Dimension(43, 20));
        BtnPesquisar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPesquisar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAlterarRepMun)
                        .addGap(87, 87, 87)
                        .addComponent(BtnLimparTela)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfIdRepres, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNomeRepres))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jtfNome))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jtfIdMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jtfIdRepres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNomeRepres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAlterarRepMun)
                    .addComponent(BtnLimparTela))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar1, jtfIdRepres});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAlterarRepMunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarRepMunActionPerformed
        if (!"".equals(this.jtfIdMunicipio.getText())) {
            Municipio Clt = new Municipio();

            Clt.setIdMunicipio(Integer.parseInt(this.jtfIdMunicipio.getText()));
            if (this.jtfIdRepres.getText().equals("")) {
                Clt.setIdRepres(0);
            } else {
                Clt.setIdRepres(Integer.parseInt(this.jtfIdRepres.getText()));
            }

            objDAO.VinculaRepresentante(Clt);                

            this.pLimpaTela();                        
        } else {
            MostraErro.pMostraErro("Município inválido!", null);
        }
    }//GEN-LAST:event_BtnAlterarRepMunActionPerformed

    private void pSetaMunicipio(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaMunicipio
        if (!"".equals(this.jtfIdMunicipio.getText())) {
            Obj = objDAO.buscaMunicipioByID(Integer.parseInt(this.jtfIdMunicipio.getText()));
            this.pPreenchetela(Obj);
        }
    }//GEN-LAST:event_pSetaMunicipio

    private void BtnLimparTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparTelaActionPerformed
        this.pLimpaTela();
    }//GEN-LAST:event_BtnLimparTelaActionPerformed

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        MunicipioSL lookup = new MunicipioSL(this);
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

    private void BtnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisar1ActionPerformed
        RepresCitySL lookup = new RepresCitySL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCidade().setVisible(true);
            }
        });
    }
    
    public void pLimpaTela(){
        this.jtfIdMunicipio.setText("");
        this.jtfNomeRepres.setText("");
        this.jtfNome.setText("");
        this.jtfIdRepres.setText("");
        
        ObjList = objDAO.pPreencheListMunicipio();
        ObjIterableList = new IterableList <> (ObjList);
    }
    
    public void pPreenchetela(Municipio obj){
        if (obj.getIdMunicipio()!= -1){
            this.jtfIdMunicipio.setText(Integer.toString(obj.getIdMunicipio()));
            this.jtfNome.setText(obj.getNome());
            this.jtfNomeRepres.setText(obj.getNomeRepres());
            this.jtfIdRepres.setText(Integer.toString(obj.getIdRepres()));                                
        }
    }
    
    public void pPreencheRepres (Representante obj) {
        if (obj.getIdRepres() != -1) {
            this.jtfIdRepres.setText(String.valueOf(obj.getIdRepres()));
            this.jtfNomeRepres.setText(obj.getNome());
        } else {
            this.jtfIdRepres.setText("0");
            this.jtfNomeRepres.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlterarRepMun;
    private javax.swing.JButton BtnAnterior;
    private javax.swing.JButton BtnLimparTela;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnPesquisar1;
    private javax.swing.JButton BtnPrimeiro;
    private javax.swing.JButton BtnProximo;
    private javax.swing.JButton BtnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField jtfIdMunicipio;
    private javax.swing.JFormattedTextField jtfIdRepres;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JFormattedTextField jtfNomeRepres;
    // End of variables declaration//GEN-END:variables
}
