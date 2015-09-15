/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Dao.Item;
import Dao.ItemDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pietra.Erros;
import TelaPesquisa.ItemIniSL;
import TelaPesquisa.ItemFimSL;
import java.awt.Desktop;
import java.io.File;

/**
 *
 * baseado no tutorial encontrado em 
 * http://codigofonte.uol.com.br/artigos/tutorial-criando-relatorios-com-jasperreports-primeiros-passos
 */
public class RelatorioItens extends javax.swing.JFrame {
    private final String pathToReportPackage = caminhoPadrao.psCaminhoPadrao;
    ItemDAO objDAO = new ItemDAO();
    Erros MostraErro = new Erros();
    Item it;
    ItemDAO itDao = new ItemDAO();
    
    public RelatorioItens() {
        initComponents();
        setLocationRelativeTo(null);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGerar = new javax.swing.JButton();
        jtfIdItemIni = new javax.swing.JTextField();
        jtfIdItemFim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfDescricaoIni = new javax.swing.JTextField();
        jtfDescricaoFim = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        BtnPesquisar = new javax.swing.JButton();
        BtnPesquisar1 = new javax.swing.JButton();

        setTitle("Relatório de itens");

        BtnGerar.setText("Gerar");
        BtnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGerarActionPerformed(evt);
            }
        });

        jtfIdItemIni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfIdItemInipSetaItem(evt);
            }
        });

        jtfIdItemFim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfIdItemFimpSetaItem(evt);
            }
        });

        jLabel1.setText("Item inicial:");

        jLabel2.setText("Item final:");

        jtfDescricaoIni.setEditable(false);
        jtfDescricaoIni.setFocusable(false);

        jtfDescricaoFim.setEditable(false);
        jtfDescricaoFim.setFocusable(false);

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnGerar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfIdItemIni, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfIdItemFim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(BtnCancelar)
                        .addGap(0, 113, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDescricaoFim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(jtfDescricaoIni, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCancelar, BtnGerar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jtfIdItemIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescricaoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jtfIdItemFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescricaoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGerar)
                    .addComponent(BtnCancelar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar, jtfIdItemIni});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar1, jtfIdItemFim});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getPathToReportPackage() {
        return this.pathToReportPackage;
    }
    
    private void BtnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGerarActionPerformed
        int ItemIni = Integer.parseInt(this.jtfIdItemIni.getText());
        int ItemFim = Integer.parseInt(this.jtfIdItemFim.getText());
        
        if ((!"".equals(this.jtfIdItemIni.getText())) & (!"".equals(this.jtfIdItemFim.getText()))) {
            if (fValidaItemIni() & fValidaItemFim()) {
                it = objDAO.buscaItemByID(ItemIni);

                if (it.getIdItem() == -1) {
                    MostraErro.pMostraErro("Item inicial inválido!", "Erro");            
                } else {
                    it = objDAO.buscaItemByID(ItemFim);
                    if (it.getIdItem() == -1) {
                        MostraErro.pMostraErro("Item final inválido!", "Erro");            
                    } else {
                        List<ItemModel> ItemList = new ArrayList<>();
                        ItemModel ItM = new ItemModel();

                        ItemList = ItM.pPreencheList(ItemIni, ItemFim);

                        try {
                            this.imprimir(ItemList);
                        } catch (Exception ex) {
                            ex.printStackTrace();                            
//                            Logger.getLogger(RelatorioItens.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        } else {
            MostraErro.pMostraErro("Itens devem ser preechidos!", "Erro");
        }
    }//GEN-LAST:event_BtnGerarActionPerformed

    private void jtfIdItemInipSetaItem(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfIdItemInipSetaItem
        if (!"".equals(this.jtfIdItemIni.getText())) {
            this.pSetaItemIni(Integer.parseInt(this.jtfIdItemIni.getText()));
        }
    }//GEN-LAST:event_jtfIdItemInipSetaItem
            
    private void jtfIdItemFimpSetaItem(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfIdItemFimpSetaItem
        if (!"".equals(this.jtfIdItemFim.getText())) {
            this.pSetaItemFim(Integer.parseInt(this.jtfIdItemFim.getText()));            
        }
    }//GEN-LAST:event_jtfIdItemFimpSetaItem
    public void pSetaItemIni(int piItem){
        it = objDAO.buscaItemByID(piItem);
        if (it.getIdItem() != -1) {
            this.jtfIdItemIni.setText(String.valueOf(it.getIdItem()));
            this.jtfDescricaoIni.setText(it.getDescricao());
        }
    }
    
    public void pSetaItemFim(int piItem){
        it = objDAO.buscaItemByID(piItem);
        if (it.getIdItem() != -1) {
            this.jtfIdItemFim.setText(String.valueOf(it.getIdItem()));
            this.jtfDescricaoFim.setText(it.getDescricao());
        }
    }
    
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        ItemIniSL lookup = new ItemIniSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void BtnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisar1ActionPerformed
        ItemFimSL lookup = new ItemFimSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar1ActionPerformed

    public boolean fValidaItemIni () {
        ItemDAO iDao = new ItemDAO();
        Item it = iDao.buscaItemByID(Integer.parseInt(this.jtfIdItemIni.getText()));
        
        if (it.getIdItem() == -1) MostraErro.pMostraErro("Item inválido!", "Erro");
        
        return (it.getIdItem() != -1);
    }
    
    public boolean fValidaItemFim () {
        ItemDAO iDao = new ItemDAO();
        Item it = iDao.buscaItemByID(Integer.parseInt(this.jtfIdItemFim.getText()));
        
        if (it.getIdItem() == -1) MostraErro.pMostraErro("Item inválido!", "Erro");
        
        return (it.getIdItem() != -1);
    }
    
    public void imprimir(List<ItemModel> itens) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Itens.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(itens));
        JasperExportManager.exportReportToPdfFile(print, this.getPathToReportPackage() + "RelatorioDeItens.pdf");
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(this.getPathToReportPackage() + "RelatorioDeItens.pdf"));        
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
            java.util.logging.Logger.getLogger(RelatorioItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioItens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGerar;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnPesquisar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtfDescricaoFim;
    private javax.swing.JTextField jtfDescricaoIni;
    private javax.swing.JTextField jtfIdItemFim;
    private javax.swing.JTextField jtfIdItemIni;
    // End of variables declaration//GEN-END:variables
}
