/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pietra;

import Dao.Item;
import Dao.ItemDAO;
import java.text.DecimalFormat;
import java.util.List;
import TelaPesquisa.ItemSL;
import TelaPesquisa.UnidadeSL;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author viniciusfurlanetto
 */
public class TelaItem extends javax.swing.JFrame {
    List<Item> ObjList;
    ItemDAO objDAO = new ItemDAO();
    IterableList<Item> ObjIterableList;
    Item Obj;
    Erros MostraErro = new Erros();
    DecimalFormat DecNum = new DecimalFormat("#######00.00");
    
    public TelaItem() {
        initComponents();
        setLocationRelativeTo(null);
        
        this.pLimpaTela();
        
        BtnInserirItem.setVisible(TelaLogin.piIsDiretor == 1);
        BtnAlterarItem.setVisible(TelaLogin.piIsDiretor == 1);
        BtnExcluirItem.setVisible(TelaLogin.piIsDiretor == 1);
        BtnLimparTela.setVisible (TelaLogin.piIsDiretor == 1);
        
        try {
            MaskFormatter maskId      = new MaskFormatter("######");
            MaskFormatter masknumber1 = new MaskFormatter("##.##");
            MaskFormatter masknumber2 = new MaskFormatter("##.##");
            MaskFormatter masknumber3 = new MaskFormatter("##.##");
            
            maskId.install(jtfIdItem);
            masknumber3.install(jtfPrecoPromo);
            masknumber1.install(jtfPrecoTotal);
            masknumber2.install(jtfPrecoUnit);
            
        } catch (ParseException ex) {
            Logger.getLogger(TelaItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbPromocao = new javax.swing.JCheckBox();
        jtfDescricao = new javax.swing.JTextField();
        jtfUnidade = new javax.swing.JTextField();
        jtfQtde = new javax.swing.JTextField();
        BtnInserirItem = new javax.swing.JButton();
        BtnAlterarItem = new javax.swing.JButton();
        BtnExcluirItem = new javax.swing.JButton();
        BtnLimparTela = new javax.swing.JButton();
        jtfPrecoUnit = new javax.swing.JFormattedTextField();
        jtfPrecoTotal = new javax.swing.JFormattedTextField();
        jtfPrecoPromo = new javax.swing.JFormattedTextField();
        jToolBar2 = new javax.swing.JToolBar();
        BtnPesquisar = new javax.swing.JButton();
        BtnPrimeiro = new javax.swing.JButton();
        BtnAnterior = new javax.swing.JButton();
        BtnProximo = new javax.swing.JButton();
        BtnUltimo = new javax.swing.JButton();
        BtnPesquisar1 = new javax.swing.JButton();
        jtfIdItem = new javax.swing.JFormattedTextField();

        setTitle("Cadastro de item");

        jLabel1.setText("ID:");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Unidade:");

        jLabel4.setText("Preço unitário:");

        jLabel5.setText("Qtde. emb.:");

        jLabel6.setText("Preço total:");

        jLabel8.setText("Preco promoção:");

        jcbPromocao.setText("Em promoção");

        jtfUnidade.setEditable(false);
        jtfUnidade.setFocusable(false);

        jtfQtde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaValorTotal(evt);
            }
        });

        BtnInserirItem.setText("Inserir");
        BtnInserirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInserirItemActionPerformed(evt);
            }
        });

        BtnAlterarItem.setText("Alterar");
        BtnAlterarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarItemActionPerformed(evt);
            }
        });

        BtnExcluirItem.setText("Excluir");
        BtnExcluirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirItemActionPerformed(evt);
            }
        });

        BtnLimparTela.setText("Limpar");
        BtnLimparTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparTelaActionPerformed(evt);
            }
        });

        jtfPrecoUnit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfPrecoUnit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaFormatoPreco1(evt);
            }
        });

        jtfPrecoTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfPrecoTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaFormatoPreco2(evt);
            }
        });

        jtfPrecoPromo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

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

        jtfIdItem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfIdItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfIdItempSetaRepresentante(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfPrecoPromo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfPrecoTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfPrecoUnit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jcbPromocao)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnInserirItem)
                .addGap(18, 18, 18)
                .addComponent(BtnAlterarItem)
                .addGap(18, 18, 18)
                .addComponent(BtnExcluirItem)
                .addGap(18, 18, 18)
                .addComponent(BtnLimparTela)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jtfIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jtfUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfPrecoUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jtfQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jcbPromocao)
                    .addComponent(jLabel8)
                    .addComponent(jtfPrecoPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtnInserirItem)
                    .addComponent(BtnAlterarItem)
                    .addComponent(BtnExcluirItem)
                    .addComponent(BtnLimparTela))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar1, jtfUnidade});

        pack();
    }// </editor-fold>//GEN-END:initComponents
            
    private void BtnInserirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInserirItemActionPerformed
        Obj = new Item();
        
        if (this.pTesta("I")) {
            double lnPrecoUnit = 0;
            double lnPrecoTotal = 0;
            double lnPrecoUnitPromo = 0;
            
            if (!this.jtfPrecoUnit.getText().equals("  .  ")) {
                lnPrecoUnit = Double.parseDouble(this.jtfPrecoUnit.getText());
            }            
            if (!this.jtfPrecoTotal.getText().equals("  .  ")) {
                lnPrecoTotal = Double.parseDouble(this.jtfPrecoTotal.getText());
            }            
            if (!this.jtfPrecoPromo.getText().equals("  .  ")) {
                lnPrecoUnitPromo = Double.parseDouble(this.jtfPrecoPromo.getText());
            }
            
            int liPromo = 0;
            boolean promo = this.jcbPromocao.isSelected();
            if (promo) liPromo = 1;

            Obj.setIdItem(Integer.parseInt(this.jtfIdItem.getText().trim().trim()));
            Obj.setDescricao(this.jtfDescricao.getText());
            Obj.setSiglaUnidade(this.jtfUnidade.getText());
            Obj.setPrecoUnit(lnPrecoUnit);
            Obj.setQtdeEmbalagem(Integer.parseInt(this.jtfQtde.getText()));
            Obj.setPrecoTotal(lnPrecoTotal);
            Obj.setPromocao(liPromo);
            Obj.setPrecoUnitPromocao(lnPrecoUnitPromo);

            objDAO.InserirItem(Obj);

            this.pLimpaTela();
        }
    }//GEN-LAST:event_BtnInserirItemActionPerformed
    
    public boolean pTesta (String psTipo){        
        if ("".equals(this.jtfIdItem.getText().trim().trim())) {
            MostraErro.pMostraErro("Código (ID) inválido!", "Erro");
            return false;
        } else if ("I".equals(psTipo)){
            Obj = objDAO.buscaItemByID(Integer.parseInt(this.jtfIdItem.getText().trim().trim()));
            if (Obj.getIdItem() != -1) {
                MostraErro.pMostraErro("Código (ID) já cadastrado!", "Erro");
                return false;
            }
        }
        if ("".equals(this.jtfDescricao.getText())) {
            MostraErro.pMostraErro("Descrição inválida!", "Erro");
            return false;
        }
        if ("".equals(this.jtfUnidade.getText())) {
            MostraErro.pMostraErro("Unidade inválida!", "Erro");
            return false;
        }
        this.pSetaBrancos();

        return true;
    }
    
    public void pSetaBrancos (){
        if ("".equals(this.jtfPrecoUnit.getText())) {
            this.jtfPrecoUnit.setText("00.00");
        }
        if ("".equals(this.jtfPrecoTotal.getText())) {
            this.jtfPrecoTotal.setText("00.00");
        }
        if ("".equals(this.jtfPrecoPromo.getText())) {
            this.jtfPrecoPromo.setText("00.00");
        }
        if ("".equals(this.jtfQtde.getText())) {
            this.jtfQtde.setText("0");
        }
    }


    private void BtnAlterarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarItemActionPerformed
        Obj = new Item();
        
        if (this.pTesta("A")) {
            double lnPrecoUnit = 0;
            double lnPrecoTotal = 0;
            double lnPrecoUnitPromo = 0;
            
            if (!this.jtfPrecoUnit.getText().equals("  .  ")) {
                lnPrecoUnit = Double.parseDouble(this.jtfPrecoUnit.getText());
            }            
            if (!this.jtfPrecoTotal.getText().equals("  .  ")) {
                lnPrecoTotal = Double.parseDouble(this.jtfPrecoTotal.getText());
            }            
            if (!this.jtfPrecoPromo.getText().equals("  .  ")) {
                lnPrecoUnitPromo = Double.parseDouble(this.jtfPrecoPromo.getText());
            }

            int liPromo = 0;
            boolean promo = this.jcbPromocao.isSelected();
            if (promo) liPromo = 1;

            Obj.setIdItem(Integer.parseInt(this.jtfIdItem.getText().trim().trim()));
            Obj.setDescricao(this.jtfDescricao.getText());
            Obj.setSiglaUnidade(this.jtfUnidade.getText());
            Obj.setPrecoUnit(lnPrecoUnit);
            Obj.setQtdeEmbalagem(Integer.parseInt(this.jtfQtde.getText()));
            Obj.setPrecoTotal(lnPrecoTotal);
            Obj.setPromocao(liPromo);
            Obj.setPrecoUnitPromocao(lnPrecoUnitPromo);

            objDAO.AlterarItem(Obj);

            this.pLimpaTela();
        }
    }//GEN-LAST:event_BtnAlterarItemActionPerformed

    private void BtnExcluirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirItemActionPerformed
        boolean lbRet;
        
        if (!"".equals(this.jtfIdItem.getText().trim().trim())) {
            Obj = objDAO.buscaItemByID(Integer.parseInt(this.jtfIdItem.getText().trim().trim()));
            if (Obj.getIdItem() == -1) {
                MostraErro.pMostraErro("Item não cadastrado no banco de dados.", "Erro");
            } else {
                lbRet = objDAO.DeletarItem(Obj);
                if (!lbRet) MostraErro.pMostraErro("Não é possível excluir. Já existem pedidos com esse item.", "Erro");
                this.pLimpaTela();
            }
        } else {
            MostraErro.pMostraErro("Nenhum item selecionado.", "Erro");
        }
    }//GEN-LAST:event_BtnExcluirItemActionPerformed

    private void BtnLimparTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparTelaActionPerformed
        this.pLimpaTela();
    }//GEN-LAST:event_BtnLimparTelaActionPerformed

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        ItemSL lookup = new ItemSL(this);
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

    private void pSetaFormatoPreco1(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaFormatoPreco1
//        double lnPreco = Double.valueOf(this.jtfPrecoUnit.getText().replace(',', '.'));
//        this.jtfPrecoUnit.setText(DecNum.format(lnPreco).replace(',', '.'));
    }//GEN-LAST:event_pSetaFormatoPreco1

    private void pSetaFormatoPreco2(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaFormatoPreco2
//        double lnPreco = Double.valueOf(this.jtfPrecoTotal.getText().replace(',', '.'));
//        this.jtfPrecoTotal.setText(DecNum.format(lnPreco).replace(',', '.'));
    }//GEN-LAST:event_pSetaFormatoPreco2

    private void pSetaValorTotal(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaValorTotal
        if (!"".equals(this.jtfQtde.getText())){
            if (!"".equals(this.jtfIdItem.getText().trim())) {
                double lnValor = Double.valueOf(this.jtfQtde.getText()) * 
                                 Double.valueOf(this.jtfPrecoUnit.getText());

                this.jtfPrecoTotal.setText(DecNum.format(lnValor).replace(',', '.'));
            }
        }
    }//GEN-LAST:event_pSetaValorTotal

    private void BtnPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisar1ActionPerformed
        UnidadeSL lookup = new UnidadeSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar1ActionPerformed

    private void jtfIdItempSetaRepresentante(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfIdItempSetaRepresentante
        if (!"".equals(this.jtfIdItem.getText().trim())) {
            Obj = objDAO.buscaItemByID(Integer.parseInt(this.jtfIdItem.getText().trim()));
            if (Obj.getIdItem() == -1) {
                this.pSetaBrancos();
            }
        } else {
            this.pSetaBrancos();
        }
    }//GEN-LAST:event_jtfIdItempSetaRepresentante

    public void pLimpaTela(){
        this.jtfIdItem.setText("");
        this.jtfDescricao.setText("");
        this.jtfQtde.setText("");
        this.jtfUnidade.setText("");
        this.jcbPromocao.setSelected(false);        
        this.jtfPrecoUnit.setText("");
        this.jtfPrecoTotal.setText("");
        this.jtfPrecoPromo.setText("");
                        
        ObjList = objDAO.pPreencheListItem();
        ObjIterableList = new IterableList <> (ObjList);
    }
    
    public void pPreenchetela(Item obj){    
        int liPromo;
        boolean lbPromo = false;
        
        this.jtfIdItem.setText(Integer.toString(obj.getIdItem()));
        this.jtfDescricao.setText(obj.getDescricao());
        this.jtfQtde.setText(Integer.toString(obj.getQtdeEmbalagem()));
        this.jtfUnidade.setText(obj.getSiglaUnidade());
        liPromo = obj.getPromocao();
        if (liPromo == 1) lbPromo = true;
        this.jcbPromocao.setSelected(lbPromo);
        this.jtfPrecoUnit.setText(DecNum.format(obj.getPrecoUnit()).replace(',', '.'));
        this.jtfPrecoTotal.setText(DecNum.format(obj.getPrecoTotal()).replace(',', '.'));
        this.jtfPrecoPromo.setText(DecNum.format(obj.getPrecoUnitPromocao()).replace(',', '.'));
    }
    
    public void pSetaUnidade (String psUnidade) {
        this.jtfUnidade.setText(psUnidade);
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
            java.util.logging.Logger.getLogger(TelaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlterarItem;
    private javax.swing.JButton BtnAnterior;
    private javax.swing.JButton BtnExcluirItem;
    private javax.swing.JButton BtnInserirItem;
    private javax.swing.JButton BtnLimparTela;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnPesquisar1;
    private javax.swing.JButton BtnPrimeiro;
    private javax.swing.JButton BtnProximo;
    private javax.swing.JButton BtnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JCheckBox jcbPromocao;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JFormattedTextField jtfIdItem;
    private javax.swing.JFormattedTextField jtfPrecoPromo;
    private javax.swing.JFormattedTextField jtfPrecoTotal;
    private javax.swing.JFormattedTextField jtfPrecoUnit;
    private javax.swing.JTextField jtfQtde;
    private javax.swing.JTextField jtfUnidade;
    // End of variables declaration//GEN-END:variables
}
