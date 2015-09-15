/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Dao.Cliente;
import Dao.ClienteDAO;
import Dao.Municipio;
import Dao.MunicipioDAO;
import TelaPesquisa.ClienteFimSL;
import TelaPesquisa.ClienteIniSL;
import java.awt.Desktop;
import java.io.File;
import java.util.List;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pietra.Erros;
import TelaPesquisa.MunicipioRelSL;

/**
 *
 * baseado no tutorial encontrado em 
 * http://codigofonte.uol.com.br/artigos/tutorial-criando-relatorios-com-jasperreports-primeiros-passos
 */
public class RelatorioClientes extends javax.swing.JFrame {
    private final String pathToReportPackage = caminhoPadrao.psCaminhoPadrao;
    ClienteDAO objDAO = new ClienteDAO();
    Erros MostraErro = new Erros();
    Cliente obj;
    
    public RelatorioClientes() {
        initComponents();
        setLocationRelativeTo(null);
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
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        BtnPesquisar = new javax.swing.JButton();
        BtnPesquisar1 = new javax.swing.JButton();
        jtfIdMunicipio = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        BtnPesquisar2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setTitle("Relatório de clientes");

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Ativo", "Inativo", "Arquivado" }));

        jLabel3.setText("Status:");

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

        jtfIdMunicipio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfIdMunicipiopSetaMunicipio(evt);
            }
        });

        jtfNome.setEditable(false);
        jtfNome.setFocusable(false);

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

        jLabel4.setText("Município:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGerar)
                .addGap(97, 97, 97)
                .addComponent(BtnCancelar)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfIdClienteIni, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIdClienteFim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfIdMunicipio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfRazaoIni)
                    .addComponent(jtfRazaoFim, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jtfNome))
                .addGap(3, 3, 3))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnCancelar, BtnGerar});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtfIdClienteFim, jtfIdClienteIni});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jtfIdClienteIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRazaoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jtfIdClienteFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRazaoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jtfIdMunicipio)
                    .addComponent(BtnPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGerar)
                    .addComponent(BtnCancelar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar, jtfIdClienteIni, jtfRazaoIni});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar1, jtfIdClienteFim, jtfRazaoFim});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar2, jtfIdMunicipio, jtfNome});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getPathToReportPackage() {
        return this.pathToReportPackage;
    }
    
    private void BtnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGerarActionPerformed
        String psStatus = (this.jComboBox1.getSelectedItem() + "");
        int idMunic;
        
        if (fTesta()) {            
            List<ClienteModel> ClienteList;
            ClienteModel Clt = new ClienteModel();

            int ClienteIni = Integer.parseInt(this.jtfIdClienteIni.getText());
            int ClienteFim = Integer.parseInt(this.jtfIdClienteFim.getText());
            if ("".equals(this.jtfIdMunicipio.getText())) {
                idMunic = 0;
            } else {
                idMunic =  Integer.parseInt(this.jtfIdMunicipio.getText());
            }
            ClienteList = Clt.pPreencheList(ClienteIni, ClienteFim, psStatus, idMunic);

            try {
                this.imprimir(ClienteList);
            } catch (Exception ex) {
                MostraErro.pMostraErro("Ocorreu um erro na geração do relatório!", "Erro");                        
            }
        }
    }//GEN-LAST:event_BtnGerarActionPerformed

    public boolean fTesta() {
        int idMunic;
        Municipio munic;
        MunicipioDAO municDao = new MunicipioDAO();
        
        if ((!"".equals(this.jtfIdClienteIni.getText())) & (!"".equals(this.jtfIdClienteFim.getText()))) {
            int ClienteIni = Integer.parseInt(this.jtfIdClienteIni.getText());
            int ClienteFim = Integer.parseInt(this.jtfIdClienteFim.getText());
            
            obj = objDAO.buscaClienteByID(ClienteIni);
            if (obj.getIdCliente()== -1) {
                MostraErro.pMostraErro("Cliente inicial inválido!", "Erro");
                return false;
            } 
            obj = objDAO.buscaClienteByID(ClienteFim);
            if (obj.getIdCliente() == -1) {
                MostraErro.pMostraErro("Cliente final inválido!", "Erro");
                return false;
            }
        } else {
            MostraErro.pMostraErro("Clientes devem ser preechidos!", "Erro");
            return false;
        }
        
        if (!"".equals(this.jtfIdMunicipio.getText())) {
            idMunic =  Integer.parseInt(this.jtfIdMunicipio.getText());
            munic = municDao.buscaMunicipioByID(idMunic);
            if (munic.getIdMunicipio() == -1) {
                MostraErro.pMostraErro("Município inválido, para selecionar todos deixe o campo em branco!", "Erro");
                return false;
            }
        }
        
        return true;
    }
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
    
    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        ClienteIniSL lookup = new ClienteIniSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void BtnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisar1ActionPerformed
        ClienteFimSL lookup = new ClienteFimSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar1ActionPerformed

    private void jtfIdMunicipiopSetaMunicipio(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfIdMunicipiopSetaMunicipio
        if (!"".equals(this.jtfIdMunicipio.getText())) {
            MunicipioDAO objdao2 = new MunicipioDAO();
        
            Municipio Obj2 = objdao2.buscaMunicipioByID(Integer.parseInt(this.jtfIdMunicipio.getText()));
            this.pSetaMunicipio(Obj2);
        }
    }//GEN-LAST:event_jtfIdMunicipiopSetaMunicipio
    
    public void pSetaMunicipio (Municipio piObj) {
        if (piObj.getIdMunicipio() != -1) {
            this.jtfIdMunicipio.setText(Integer.toString(piObj.getIdMunicipio()));
            this.jtfNome.setText(piObj.getNome());
        }
    } 
    
    private void BtnPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisar2ActionPerformed
        MunicipioRelSL lookup = new MunicipioRelSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar2ActionPerformed

    
    public void imprimir(List<ClienteModel> itens) throws Exception {
        JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Clientes.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(itens));
        JasperExportManager.exportReportToPdfFile(print, this.getPathToReportPackage() + "RelatorioCliente.pdf");
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(this.getPathToReportPackage() + "RelatorioCliente.pdf"));
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
            java.util.logging.Logger.getLogger(RelatorioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGerar;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnPesquisar1;
    private javax.swing.JButton BtnPesquisar2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jtfIdClienteFim;
    private javax.swing.JTextField jtfIdClienteIni;
    private javax.swing.JTextField jtfIdMunicipio;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfRazaoFim;
    private javax.swing.JTextField jtfRazaoIni;
    // End of variables declaration//GEN-END:variables
}
