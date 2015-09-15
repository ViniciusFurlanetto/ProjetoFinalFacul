package pietra;

import Dao.Representante;
import Dao.RepresentanteDAO;
import Dao.Usuario;
import Dao.UsuarioDAO;
import TelaPesquisa.UsuarioSL;
import java.util.List;
import TelaPesquisa.RepresUserSL;

/**
 *
 * @author viniciusfurlanetto
 */
public class TelaUsuario extends javax.swing.JFrame {
    UsuarioDAO ObjDAO = new UsuarioDAO ();
    RepresentanteDAO RepDAO = new RepresentanteDAO ();
    
    List<Usuario> ObjList;
    IterableList<Usuario> ObjIterableList;
    Usuario Obj;
    Erros MostraErro = new Erros();
    
    public TelaUsuario() {
        initComponents();
                
        setLocationRelativeTo(null);
        this.pLimpaTela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jtfIdUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbDiretor = new javax.swing.JCheckBox();
        jtfNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jpsSenha = new javax.swing.JPasswordField();
        jtfRepresentante = new javax.swing.JTextField();
        BtnInserirUsuario = new javax.swing.JButton();
        BtnAlterarUsuario = new javax.swing.JButton();
        BtnExcluirUsuario = new javax.swing.JButton();
        BtnLimparTela = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        BtnPesquisar = new javax.swing.JButton();
        BtnPrimeiro = new javax.swing.JButton();
        BtnAnterior = new javax.swing.JButton();
        BtnProximo = new javax.swing.JButton();
        BtnUltimo = new javax.swing.JButton();
        BtnPesquisar1 = new javax.swing.JButton();
        jtfRepresNome = new javax.swing.JTextField();

        setTitle("Cadastro de usuário");

        jtfIdUsuario.setEditable(false);
        jtfIdUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaUsuario(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Senha:");

        jcbDiretor.setText("Diretor");

        jLabel5.setText("Repres.:");

        jtfRepresentante.setEditable(false);
        jtfRepresentante.setFocusable(false);

        BtnInserirUsuario.setText("Inserir");
        BtnInserirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInserirUsuarioActionPerformed(evt);
            }
        });

        BtnAlterarUsuario.setText("Alterar");
        BtnAlterarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarUsuarioActionPerformed(evt);
            }
        });

        BtnExcluirUsuario.setText("Excluir");
        BtnExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirUsuarioActionPerformed(evt);
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

        jtfRepresNome.setEditable(false);
        jtfRepresNome.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpsSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfRepresNome, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbDiretor)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(BtnInserirUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(BtnAlterarUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(BtnExcluirUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(BtnLimparTela)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jtfIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDiretor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jpsSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfRepresentante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jtfRepresNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInserirUsuario)
                    .addComponent(BtnAlterarUsuario)
                    .addComponent(BtnExcluirUsuario)
                    .addComponent(BtnLimparTela))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar1, jtfRepresentante});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pSetaUsuario(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaUsuario
        if (!"".equals(this.jtfIdUsuario.getText())) {
            Obj = ObjDAO.BuscaUsuarioById(Integer.parseInt(this.jtfIdUsuario.getText()));
            this.pPreenchetela(Obj);
        }
    }//GEN-LAST:event_pSetaUsuario
       
    private void BtnInserirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInserirUsuarioActionPerformed
        if (this.pTesta("I")) {
            Usuario User = new Usuario();

            int liDiretor = 0;
            boolean diretor = this.jcbDiretor.isSelected();
            if (diretor) liDiretor = 1;

            User.setNome(this.jtfNome.getText());
            User.setSenha(EncriptaSenha.encripta(String.copyValueOf(jpsSenha.getPassword())));
            if (!this.jtfRepresentante.getText().equals("")) User.setIdRepres(Integer.parseInt(this.jtfRepresentante.getText()));
            else User.setIdRepres(0);
            User.setDiretor(liDiretor);

            ObjDAO.InserirUsuario(User);                

            this.pLimpaTela();
        }
    }//GEN-LAST:event_BtnInserirUsuarioActionPerformed

    private void BtnExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirUsuarioActionPerformed
        if (!"".equals(this.jtfIdUsuario.getText())) {
            Obj = ObjDAO.BuscaUsuarioById(Integer.parseInt(this.jtfIdUsuario.getText()));
            if (Obj.getIdRepres()== -1) {
                MostraErro.pMostraErro("Usuário não cadastrado no banco de dados.", "Erro");
            } else {
                ObjDAO.DeletarUsuario(Obj);
                this.pLimpaTela();
            }
        } else {
            MostraErro.pMostraErro("Nenhum usuário selecionado.", "Erro");
        }
    }//GEN-LAST:event_BtnExcluirUsuarioActionPerformed

    private void BtnAlterarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarUsuarioActionPerformed
        if (this.pTesta("A")) {
            Usuario User = new Usuario();
            String lsTam = String.copyValueOf(jpsSenha.getPassword());
        
            int liDiretor = 0;
            boolean diretor = this.jcbDiretor.isSelected();
            if (diretor) liDiretor = 1;
            
            User.setIdUsuario(Integer.parseInt(this.jtfIdUsuario.getText()));
            User.setNome(this.jtfNome.getText());
            
            if (lsTam.length() > 0) {
                User.setSenha(EncriptaSenha.encripta(String.copyValueOf(jpsSenha.getPassword())));
            } else {
                User.setSenha("");
            }
            
            if (!this.jtfRepresentante.getText().equals("")) User.setIdRepres(Integer.parseInt(this.jtfRepresentante.getText()));
            User.setDiretor(liDiretor);
            ObjDAO.AlterarUsuario(User);
            this.pLimpaTela();
        }
    }//GEN-LAST:event_BtnAlterarUsuarioActionPerformed

    private void BtnLimparTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparTelaActionPerformed
        this.pLimpaTela();
    }//GEN-LAST:event_BtnLimparTelaActionPerformed
            
    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        UsuarioSL lookup = new UsuarioSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void BtnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProximoActionPerformed
        Obj = ObjIterableList.next();
        this.pPreenchetela(Obj);
    }//GEN-LAST:event_BtnProximoActionPerformed

    private void BtnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUltimoActionPerformed
        Obj = ObjIterableList.last();
        this.pPreenchetela(Obj);
    }//GEN-LAST:event_BtnUltimoActionPerformed

    private void BtnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrimeiroActionPerformed
        Obj = ObjIterableList.first();
        this.pPreenchetela(Obj);
    }//GEN-LAST:event_BtnPrimeiroActionPerformed

    private void BtnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnteriorActionPerformed
        Obj = ObjIterableList.previous();
        this.pPreenchetela(Obj);
    }//GEN-LAST:event_BtnAnteriorActionPerformed

    private void BtnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisar1ActionPerformed
        RepresUserSL lookup = new RepresUserSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar1ActionPerformed
    
    public void pLimpaTela(){
        this.jtfIdUsuario.setText("");
        this.jtfNome.setText("");
        this.jtfRepresentante.setText("");
        this.jcbDiretor.setSelected(false);
        this.jpsSenha.setText("");
        this.jtfRepresNome.setText("");
        
        ObjList = ObjDAO.pPreencheListUsuario();
        ObjIterableList = new IterableList <> (ObjList);
    }
    
    public void pPreenchetela(Usuario Usr){
        int liDiretor;
        boolean lbDiretor = false;
        if (Usr.getIdUsuario() != -1) {
            this.jtfIdUsuario.setText(Integer.toString(Usr.getIdUsuario()));
            
            this.jtfNome.setText(Usr.getNome());
            liDiretor = Usr.getDiretor();
            if (liDiretor == 1) lbDiretor = true;
            jcbDiretor.setSelected(lbDiretor);
            this.pSetaRepres(Usr.getIdRepres());
        }
    }
    
    public void pSetaRepres (int piRepres) {
        Representante obj; 
        obj = RepDAO.buscaRepresByID(piRepres);
        if (obj.getIdRepres() != -1) {
            this.jtfRepresentante.setText(Integer.toString(obj.getIdRepres()));
            this.jtfRepresNome.setText(obj.getNome());
        } else {
            this.jtfRepresentante.setText("");
            this.jtfRepresNome.setText("");
        }        
    }
    
    public boolean pTesta (String psTipo){        
        if ("A".equals(psTipo)) {
            if ("".equals(this.jtfIdUsuario.getText())) {
                MostraErro.pMostraErro("Código (ID) inválido!", "Erro");
                return false;
            }
        } else {
            if ("".equals(String.copyValueOf(jpsSenha.getPassword()))) {
                MostraErro.pMostraErro("Senha inválida!", "Erro");
                return false;
            }
        }
        
        if ("".equals(this.jtfNome.getText())) {
            MostraErro.pMostraErro("Nome inválido!", "Erro");
            return false;
        } else if (psTipo.equals("I")) {
            Obj = ObjDAO.BuscaUsuarioByNome(this.jtfNome.getText());
            if (Obj.getIdUsuario() != -1) {
                MostraErro.pMostraErro("Nome já cadastrado!", "Erro");
                return false;
            }
        }
                
        return true;
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
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaUsuario().setVisible(true);
            }
        });
    }        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlterarUsuario;
    private javax.swing.JButton BtnAnterior;
    private javax.swing.JButton BtnExcluirUsuario;
    private javax.swing.JButton BtnInserirUsuario;
    private javax.swing.JButton BtnLimparTela;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnPesquisar1;
    private javax.swing.JButton BtnPrimeiro;
    private javax.swing.JButton BtnProximo;
    private javax.swing.JButton BtnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JCheckBox jcbDiretor;
    private javax.swing.JPasswordField jpsSenha;
    private javax.swing.JTextField jtfIdUsuario;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfRepresNome;
    private javax.swing.JTextField jtfRepresentante;
    // End of variables declaration//GEN-END:variables
}
