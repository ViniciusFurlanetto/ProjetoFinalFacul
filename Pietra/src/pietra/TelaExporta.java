/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietra;
import Relatorios.caminhoPadrao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.text.SimpleDateFormat;  

/**
 * baseado no algoritmo disponibilizado em: 
 * http://www.guj.com.br/java/268786-ler-e-escrever-arquivo-txt
 */
public class TelaExporta extends javax.swing.JFrame {
    Erros MostraErro = new Erros();
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    
    private final String pathToReportPackage = caminhoPadrao.psCaminhoPadrao;
    
    public TelaExporta() {
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

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnGerar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        jtfDataEmissaoIni = new javax.swing.JFormattedTextField();
        jtfDataEmissaoFim = new javax.swing.JFormattedTextField();

        setTitle("Exporta dados");

        jLabel3.setText("Data inicial:");

        jLabel4.setText("Data inicial:");

        BtnGerar.setText("Exportar");
        BtnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGerarActionPerformed(evt);
            }
        });

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
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
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDataEmissaoIni, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnGerar)
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDataEmissaoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(BtnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jtfDataEmissaoIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDataEmissaoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGerar)
                    .addComponent(BtnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    public void WriteFiles(String psArquivo) {          
        try {
            BufferedWriter writer = null;
                        
            File file = new File(pathToReportPackage+ psArquivo + ".txt");
            writer = new BufferedWriter(new FileWriter(file));
            
            if ("pedido".equals(psArquivo)) {
                try {
                    while (rs.next()) {
                        writer.write(rs.getString("idPedido"));
                        writer.write(",");
                        writer.write(rs.getString("prazo"));
                        writer.write(",");
                        writer.write(rs.getString("valorTotal"));
                        writer.write(",");
                        writer.write(rs.getString("dtEmissao"));
                        writer.write(",");
                        writer.write(rs.getString("idCliente"));
                        writer.write(",");
                        writer.write(rs.getString("idRepres"));
                        writer.newLine();
                    }            
                } catch (SQLException ex) {
                    MostraErro.pMostraErro("Ocorreu um erro na consulta, verifique os dados.", "Erro");                
                }
            } else {
                try {
                    while (rs.next()) {
                        writer.write(rs.getString("idPedido"));
                        writer.write(",");
                        writer.write(rs.getString("seq"));
                        writer.write(",");
                        writer.write(rs.getString("idItem"));
                        writer.write(",");
                        writer.write(rs.getString("quantidade"));
                        writer.write(",");
                        writer.write(rs.getString("valorBase"));
                        writer.write(",");
                        writer.write(rs.getString("valorTotal"));
                        writer.newLine();
                    }            
                } catch (SQLException ex) {
                    MostraErro.pMostraErro("Ocorreu um erro na consulta, verifique os dados.", "Erro");                
                }
            }
            
            //Criando o conteúdo do arquivo
            writer.flush();            
            //Fechando conexão e escrita do arquivo.
            writer.close();  
            
            MostraErro.pMostraAviso(("Arquivo " + psArquivo + ".txt gravado em: " + pathToReportPackage), "Aviso");
        } catch (IOException ex) {
            MostraErro.pMostraErro("Problema ao gravar o arquivo.", "Erro");            
        }        
    }  
    
    public boolean fValidaData () {
        if ("  /  /    ".equals(this.jtfDataEmissaoIni.getText())) {
            MostraErro.pMostraErro("Data inicial inválida!", "Erro");
            return false;
        }
        if ("  /  /    ".equals(this.jtfDataEmissaoFim.getText())) {
            MostraErro.pMostraErro("Data final inválida!", "Erro");
            return false;
        }                
        
        return true;
    }
    
    private void BtnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGerarActionPerformed
        String sDataIni = this.jtfDataEmissaoIni.getText();
        String sDataFim = this.jtfDataEmissaoFim.getText();
        
        System.out.println("1");                
        
        if (fValidaData()) {            
            java.util.Date DataIni;
            try {
                DataIni = new SimpleDateFormat("dd/MM/yyyy").parse(sDataIni);
                sDataIni = new SimpleDateFormat("yyyy-MM-dd").format(DataIni);
            } catch (ParseException ex) {
                MostraErro.pMostraErro("Ocorreu um erro com as datas, verifique a data inicial digitada.", "Erro");
            }        

            java.util.Date DataFim;
            try {
                DataFim = new SimpleDateFormat("dd/MM/yyyy").parse(sDataFim);
                sDataFim = new SimpleDateFormat("yyyy-MM-dd").format(DataFim);
            } catch (ParseException ex) {
                MostraErro.pMostraErro("Ocorreu um erro com as datas, verifique a data final digitada.", "Erro");
            }                        
            
            Conecta.connect();
            
            rs = Conecta.executar("Select *"
                + " From pedido "
                + " where dtEmissao between '" + sDataIni + "' And '" + sDataFim +"' "
                + " and encaminhado = 0"
                + " order By idPedido");
            
            this.WriteFiles("pedido");
            

            rs = Conecta.executar("Select *"
                + " From ItemPedido "
                + " Inner Join Pedido on ItemPedido.idPedido = Pedido.idPedido"
                + " where pedido.dtEmissao between '" + sDataIni + "' And '" + sDataFim +"' "
                + " and encaminhado = 0"
                + " order By pedido.idPedido");
            
            this.WriteFiles("itensPedido");                        
            
            Conecta.inserir("Update Pedido"
                + " Set encaminhado = 1 "
                + " where dtEmissao between '" + sDataIni + "' And '" + sDataFim +"' "
                + " and encaminhado = 0");                
            
            Conecta.disconnect();                        
        }                
    }//GEN-LAST:event_BtnGerarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaExporta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExporta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExporta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExporta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExporta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGerar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JFormattedTextField jtfDataEmissaoFim;
    private javax.swing.JFormattedTextField jtfDataEmissaoIni;
    // End of variables declaration//GEN-END:variables
}
