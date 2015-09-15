/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Dao.Cliente;
import Dao.ClienteDAO;
import TelaPesquisa.ClienteFimPSL;
import TelaPesquisa.ClienteIniPSL;
import java.text.ParseException;
import java.util.List;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pietra.Erros;
import javax.swing.text.MaskFormatter;
import java.awt.Desktop;
import java.io.File;
/**
 *
 * baseado no tutorial encontrado em 
 * http://codigofonte.uol.com.br/artigos/tutorial-criando-relatorios-com-jasperreports-primeiros-passos
 */
public class RelatorioPedidos extends javax.swing.JFrame {
    private final String pathToReportPackage = caminhoPadrao.psCaminhoPadrao;
    ClienteDAO objDAO = new ClienteDAO();
    Erros MostraErro = new Erros();
    Cliente obj;
    
    public RelatorioPedidos() {
        initComponents();
        setLocationRelativeTo(null);
        
        MaskFormatter maskData;
        MaskFormatter maskData1;
        try {
            maskData = new MaskFormatter("##/##/####");
            maskData1 = new MaskFormatter("##/##/####");
            maskData.install(jtfDataEmissaoIni);            
            maskData1.install(jtfDataEmissaoFim);
        } catch (ParseException ex) {
            MostraErro.pMostraErro("Ocorreu um erro ao setar a máscara de datas.", "Erro");
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGerar = new javax.swing.JButton();
        jtfIdClienteIni = new javax.swing.JTextField();
        jtfIdClienteFim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfRazaoIni = new javax.swing.JTextField();
        jtfRazaoFim = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        BtnPesquisar = new javax.swing.JButton();
        BtnPesquisar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtfDataEmissaoIni = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfDataEmissaoFim = new javax.swing.JFormattedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();

        setTitle("Relatório de pedidos");

        BtnGerar.setText("Gerar");
        BtnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGerarActionPerformed(evt);
            }
        });

        jtfIdClienteIni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaDescricaoIni(evt);
            }
        });

        jtfIdClienteFim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaDescricaoFim(evt);
            }
        });

        jLabel1.setText("Cliente inicial:");

        jLabel2.setText("Cliente final:");

        jtfRazaoIni.setEditable(false);
        jtfRazaoIni.setFocusable(false);

        jtfRazaoFim.setEditable(false);
        jtfRazaoFim.setFocusable(false);

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

        jLabel3.setText("Data inicial:");

        jLabel4.setText("Data final:");

        jCheckBox1.setText("Mostrar encaminhados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jtfIdClienteIni, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfIdClienteFim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfDataEmissaoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfRazaoIni)
                                    .addComponent(jtfRazaoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfDataEmissaoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGerar)
                .addGap(85, 85, 85)
                .addComponent(BtnCancelar)
                .addGap(111, 111, 111))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCancelar, BtnGerar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfIdClienteIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jtfRazaoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jtfIdClienteFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfRazaoFim)
                    .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfDataEmissaoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfDataEmissaoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGerar)
                    .addComponent(BtnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getPathToReportPackage() {
        return this.pathToReportPackage;
    }
    
    private void BtnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGerarActionPerformed
        int ClienteIni = Integer.parseInt(this.jtfIdClienteIni.getText());
        int ClienteFim = Integer.parseInt(this.jtfIdClienteFim.getText());
        String sDataIni = this.jtfDataEmissaoIni.getText();
        String sDataFim = this.jtfDataEmissaoFim.getText();
        boolean bEncaminhado = this.jCheckBox1.isSelected();
        
        if ((!"".equals(this.jtfIdClienteIni.getText())) & (!"".equals(this.jtfIdClienteFim.getText()))) {
            obj = objDAO.buscaClienteByID(ClienteIni);

            if (obj.getIdCliente()== -1) {
                MostraErro.pMostraErro("Cliente inicial inválido!", "Erro");            
            } else {
                obj = objDAO.buscaClienteByID(ClienteFim);
                if (obj.getIdCliente() == -1) {
                    MostraErro.pMostraErro("Cliente final inválido!", "Erro");            
                } else {                
                    if (fValidaData()) {
                        List<PedidoModel> PedidoList;
                        PedidoModel Ped = new PedidoModel();

                        PedidoList = Ped.pPreencheList(ClienteIni, ClienteFim, sDataIni, sDataFim, bEncaminhado);

                        try {
                            this.imprimir(PedidoList);
                        } catch (Exception ex) {
                            MostraErro.pMostraErro("Ocorreu um erro ao gerar o relatório! Verifique os dados.", "Erro");
                        }
                    }
                }
            }
        } else {
            MostraErro.pMostraErro("Clientes devem ser preechidos!", "Erro");
        }
    }//GEN-LAST:event_BtnGerarActionPerformed

    private void pSetaDescricaoIni(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaDescricaoIni
        if (!"".equals(this.jtfIdClienteIni.getText())) {
            this.pSetaClienteIni(Integer.parseInt(this.jtfIdClienteIni.getText()));
        }
    }//GEN-LAST:event_pSetaDescricaoIni

    private void pSetaDescricaoFim(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaDescricaoFim
        if (!"".equals(this.jtfIdClienteFim.getText())) {
            this.pSetaClienteFim(Integer.parseInt(this.jtfIdClienteFim.getText()));
        }
    }//GEN-LAST:event_pSetaDescricaoFim

    public void pSetaClienteIni(int piCLiente){
        obj = objDAO.buscaClienteByID(piCLiente);
        if (obj.getIdCliente() != -1) {
            this.jtfIdClienteIni.setText(String.valueOf(obj.getIdCliente()));
            this.jtfRazaoIni.setText(obj.getRazaoSocial());
        }
    }
    
    public void pSetaClienteFim(int piCLiente){
        obj = objDAO.buscaClienteByID(piCLiente);
        if (obj.getIdCliente() != -1) {
            this.jtfIdClienteFim.setText(String.valueOf(obj.getIdCliente()));
            this.jtfRazaoFim.setText(obj.getRazaoSocial());
        }
    }
    
    public boolean fValidaData () {
        if ("".equals(this.jtfDataEmissaoIni.getText())) {
            MostraErro.pMostraErro("Data inicial inválida!", "Erro");
            return false;
        }
        if ("".equals(this.jtfDataEmissaoFim.getText())) {
            MostraErro.pMostraErro("Data final inválida!", "Erro");
            return false;
        }                
        
        return true;
    }
    
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        ClienteIniPSL lookup = new ClienteIniPSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void BtnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisar1ActionPerformed
        ClienteFimPSL lookup = new ClienteFimPSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar1ActionPerformed

    
    public void imprimir(List<PedidoModel> itens) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Pedidos.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(itens));
        JasperExportManager.exportReportToPdfFile(print, this.getPathToReportPackage() + "RelatorioPedido.pdf");
                    
        Desktop desktop = Desktop.getDesktop();    
        desktop.open(new File(this.getPathToReportPackage() + "RelatorioPedido.pdf")); 
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
            java.util.logging.Logger.getLogger(RelatorioPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGerar;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnPesquisar1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField jtfDataEmissaoFim;
    private javax.swing.JFormattedTextField jtfDataEmissaoIni;
    private javax.swing.JTextField jtfIdClienteFim;
    private javax.swing.JTextField jtfIdClienteIni;
    private javax.swing.JTextField jtfRazaoFim;
    private javax.swing.JTextField jtfRazaoIni;
    // End of variables declaration//GEN-END:variables
}
