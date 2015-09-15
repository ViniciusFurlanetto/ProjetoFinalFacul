package pietra;

import Dao.Pedido;
import Dao.ItemPedido;
import Dao.PedidoDAO;
import Dao.ItemPedidoDAO;
import Dao.Cliente;
import Dao.ClienteDAO;
import Dao.Representante;
import Dao.RepresentanteDAO;
import Dao.Item;
import Dao.ItemDAO;
import TelaPesquisa.ItempedSL;
import TelaPesquisa.PedidoSL;
import TelaPesquisa.CliPedSL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.SwingConstants;

/**
 *
 * @author viniciusfurlanetto
 */
public class TelaPedido extends javax.swing.JFrame {
    PedidoDAO objDAO = new PedidoDAO();
    ClienteDAO CltDao = new ClienteDAO();
    ItemPedidoDAO ItempDAO = new ItemPedidoDAO();    
    List<Pedido> ObjList;
    List<ItemPedido> ItempedList;
    IterableList<Pedido> ObjIterableList;
    IterableList<ItemPedido> ObjIterableItemped;
    Pedido Obj;
    Cliente Clt;
    ItemPedido Itemp;    
    Erros MostraErro = new Erros();    
    DecimalFormat DecNum = new DecimalFormat("#####00.00");
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    
    public TelaPedido() {
        initComponents();
        setLocationRelativeTo(null);
        
        try {
            MaskFormatter maskData = new MaskFormatter("##/##/####");
            maskData.install(jtfDataEmissao);
            
            MaskFormatter maskQtde = new MaskFormatter("##.##");
            maskQtde.install(jtfQtdeItemped);
            
            this.pLimpaTela();
            this.pLimpaItemped();
        } catch (ParseException ex) {
            Logger.getLogger(TelaPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        BtnPesquisar = new javax.swing.JButton();
        BtnPrimeiro = new javax.swing.JButton();
        BtnAnterior = new javax.swing.JButton();
        BtnProximo = new javax.swing.JButton();
        BtnUltimo = new javax.swing.JButton();
        jtfIdPedido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfDataEmissao = new javax.swing.JFormattedTextField();
        jtfVlTotalPedido = new javax.swing.JFormattedTextField();
        jtfIdCliente = new javax.swing.JTextField();
        jtfRazaoSocial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbPrazo = new javax.swing.JComboBox();
        BtnInserirPedido = new javax.swing.JButton();
        BtnAlterarPedido = new javax.swing.JButton();
        BtnExcluirPedido = new javax.swing.JButton();
        BtnLimparPedido = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jtfIdItemPed = new javax.swing.JTextField();
        jtfDescricaoItemped = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfQtdeItemped = new javax.swing.JFormattedTextField();
        jtfVlUnitItemped = new javax.swing.JFormattedTextField();
        jtfVlTotalItemped = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfUnItem = new javax.swing.JTextField();
        BtnInserirItemped = new javax.swing.JButton();
        BtnAlterarItemped = new javax.swing.JButton();
        BtnExcluirItemped = new javax.swing.JButton();
        BtnLimparItemped = new javax.swing.JButton();
        BtnPesquisar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableItens = new javax.swing.JTable();
        BtnPesquisar2 = new javax.swing.JButton();
        jtfSeq = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setTitle("Cadastro de pedido");
        setMinimumSize(new java.awt.Dimension(623, 513));

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

        jtfIdPedido.setEditable(false);
        jtfIdPedido.setFocusable(false);
        jtfIdPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaPedido(evt);
            }
        });

        jLabel1.setText("Pedido:");

        jtfDataEmissao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pSetaData(evt);
            }
        });

        jtfVlTotalPedido.setEditable(false);
        jtfVlTotalPedido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfVlTotalPedido.setFocusable(false);

        jtfIdCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaRazaoSocial(evt);
            }
        });

        jtfRazaoSocial.setEditable(false);
        jtfRazaoSocial.setFocusable(false);

        jLabel2.setText("Prazo:");

        jLabel3.setText("Data de emissão:");

        jLabel4.setText("Cliente:");

        jLabel5.setText("Vl. Total:");

        jcbPrazo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A vista", "7 dias", "14 dias", "28 dias" }));

        BtnInserirPedido.setText("Inserir");
        BtnInserirPedido.setFocusable(false);
        BtnInserirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInserirPedidoActionPerformed(evt);
            }
        });

        BtnAlterarPedido.setText("Alterar");
        BtnAlterarPedido.setFocusable(false);
        BtnAlterarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarPedidoActionPerformed(evt);
            }
        });

        BtnExcluirPedido.setText("Excluir");
        BtnExcluirPedido.setFocusable(false);
        BtnExcluirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirPedidoActionPerformed(evt);
            }
        });

        BtnLimparPedido.setText("Limpar");
        BtnLimparPedido.setFocusable(false);
        BtnLimparPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparPedidoActionPerformed(evt);
            }
        });

        jLabel6.setText("Item:");

        jtfIdItemPed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaInfoItem(evt);
            }
        });

        jtfDescricaoItemped.setEditable(false);
        jtfDescricaoItemped.setFocusable(false);

        jLabel8.setText("Qtde:");

        jtfQtdeItemped.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfQtdeItemped.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pSetaValorTotal(evt);
            }
        });

        jtfVlUnitItemped.setEditable(false);
        jtfVlUnitItemped.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfVlUnitItemped.setFocusable(false);

        jtfVlTotalItemped.setEditable(false);
        jtfVlTotalItemped.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfVlTotalItemped.setFocusable(false);

        jLabel9.setText("Vl. unit.:");

        jLabel10.setText("Vl. total:");

        jLabel11.setText("Un.:");

        jtfUnItem.setEditable(false);
        jtfUnItem.setFocusable(false);

        BtnInserirItemped.setText("Inserir item");
        BtnInserirItemped.setFocusable(false);
        BtnInserirItemped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInserirItempedActionPerformed(evt);
            }
        });

        BtnAlterarItemped.setText("Alterar item");
        BtnAlterarItemped.setFocusable(false);
        BtnAlterarItemped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarItempedActionPerformed(evt);
            }
        });

        BtnExcluirItemped.setText("Excluir item");
        BtnExcluirItemped.setFocusable(false);
        BtnExcluirItemped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirItempedActionPerformed(evt);
            }
        });

        BtnLimparItemped.setText("Limpar item");
        BtnLimparItemped.setFocusable(false);
        BtnLimparItemped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparItempedActionPerformed(evt);
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

        jTableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Seq", "Item", "Descrição", "Quantidade", "Valor unitário", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableItens.setColumnSelectionAllowed(true);
        jTableItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pClicouNaGrid(evt);
            }
        });
        jScrollPane1.setViewportView(jTableItens);
        jTableItens.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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

        jtfSeq.setEditable(false);
        jtfSeq.setFocusable(false);

        jLabel12.setText("Seq:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbPrazo, 0, 109, Short.MAX_VALUE)
                                    .addComponent(jtfIdPedido)))
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnInserirPedido)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(BtnAlterarPedido))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(148, 148, 148)
                                        .addComponent(BtnExcluirPedido)))
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfVlTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnLimparPedido))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnInserirItemped)
                                .addGap(18, 18, 18)
                                .addComponent(BtnAlterarItemped)
                                .addGap(18, 18, 18)
                                .addComponent(BtnExcluirItemped)
                                .addGap(18, 18, 18)
                                .addComponent(BtnLimparItemped))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfQtdeItemped, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(jtfIdItemPed))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfDescricaoItemped))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfVlUnitItemped, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfVlTotalItemped, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfUnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BtnAlterarItemped, BtnExcluirItemped, BtnInserirItemped, BtnLimparItemped});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(jcbPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jtfDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfVlTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInserirPedido)
                    .addComponent(BtnAlterarPedido)
                    .addComponent(BtnExcluirPedido)
                    .addComponent(BtnLimparPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jtfIdItemPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jtfDescricaoItemped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jtfUnItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jtfQtdeItemped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jtfVlUnitItemped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtfVlTotalItemped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jtfSeq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(BtnInserirItemped)
                    .addComponent(BtnAlterarItemped)
                    .addComponent(BtnExcluirItemped)
                    .addComponent(BtnLimparItemped))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BtnPesquisar2, jtfIdCliente});

    }// </editor-fold>//GEN-END:initComponents

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        PedidoSL lookup = new PedidoSL(this);
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
        ItempedSL lookup = new ItempedSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar1ActionPerformed

    private void BtnInserirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInserirPedidoActionPerformed
        Pedido obj = new Pedido();
        TelaLogin TelaLogin = new TelaLogin();        
        Representante objR;
        RepresentanteDAO objRD = new RepresentanteDAO();
        
        objR = objRD.buscaRepresByID(TelaLogin.piRepresUsuario);
        
        if (objR.getIdRepres() != -1) {         
            try {
                if (this.fValidaCliente()) {
                    java.util.Date DataNascFr = new SimpleDateFormat("dd/MM/yyyy").parse(this.jtfDataEmissao.getText());
                    String DataNascDb = new SimpleDateFormat("yyyy-MM-dd").format(DataNascFr);

                    obj.setPrazo(this.jcbPrazo.getSelectedItem() + "");
                    obj.setDtEmissao(Date.valueOf(DataNascDb));
                    obj.setIdCliente(Integer.parseInt(this.jtfIdCliente.getText()));
                    obj.setIdRepres(TelaLogin.piRepresUsuario);
                    objDAO.InserirPedido(obj);

                    this.pLimpaTela();
                    Obj = ObjIterableList.last();
                    this.pPreenchetela(Obj);
                }

            } catch (ParseException ex) {
                MostraErro.pMostraErro("Data inválida!", "Erro");
            }
        } else {
            MostraErro.pMostraErro("Usuário não tem um representante vinculado!", "Erro");
        }
    }//GEN-LAST:event_BtnInserirPedidoActionPerformed

    private void BtnAlterarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarPedidoActionPerformed
        Pedido obj = new Pedido();
        
        try {
            if (this.fValidaCliente()) {
                java.util.Date DataNascFr = new SimpleDateFormat("dd/MM/yyyy").parse(this.jtfDataEmissao.getText());
                String DataNascDb = new SimpleDateFormat("yyyy-MM-dd").format(DataNascFr);

                obj.setIdPedido(Integer.parseInt(this.jtfIdPedido.getText()));
                obj.setPrazo(this.jcbPrazo.getSelectedItem() + "");
                obj.setDtEmissao(Date.valueOf(DataNascDb));
                obj.setIdCliente(Integer.parseInt(this.jtfIdCliente.getText()));            
                objDAO.AlterarPedido(obj);

                this.pLimpaTela();
            }
        } catch (ParseException ex) {
            MostraErro.pMostraErro("Data inválida!", "Erro");
        }
    }//GEN-LAST:event_BtnAlterarPedidoActionPerformed

    private void BtnExcluirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirPedidoActionPerformed
        Pedido obj = new Pedido();
                
        obj.setIdPedido(Integer.parseInt(this.jtfIdPedido.getText()));

        objDAO.DeletarPedido(obj);
        
        this.pLimpaTela();
    }//GEN-LAST:event_BtnExcluirPedidoActionPerformed

    private void BtnLimparPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparPedidoActionPerformed
        this.pLimpaTela();
        this.pLimpaItemped();
        BtnInserirPedido.setEnabled(true);
        BtnAlterarPedido.setEnabled(true);
        BtnExcluirPedido.setEnabled(true);
        BtnInserirItemped.setEnabled(true);
        BtnAlterarItemped.setEnabled(true);
        BtnExcluirItemped.setEnabled(true);
        BtnLimparItemped.setEnabled (true);            
    }//GEN-LAST:event_BtnLimparPedidoActionPerformed

    private void BtnInserirItempedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInserirItempedActionPerformed
        if ("".equals(this.jtfSeq.getText())) {
            if (!"".equals(this.jtfIdPedido.getText())) {
                if (fValidaItem() & fValidaQtde()) {
                    ItemPedido obj = new ItemPedido();

                    double lnQtde = Double.parseDouble(this.jtfQtdeItemped.getText());
                    double lnValorBase = Double.parseDouble(this.jtfVlUnitItemped.getText());
                    double lnValorTotal = Double.parseDouble(this.jtfVlTotalItemped.getText());

                    obj.setIdPedido(Integer.parseInt(this.jtfIdPedido.getText()));
                    obj.setIdItem(Integer.parseInt(this.jtfIdItemPed.getText()));
                    obj.setQuantidade(lnQtde);
                    obj.setValorBase(lnValorBase);
                    obj.setValorTotal(lnValorTotal);
                    ItempDAO.InserirItemP(obj);

                    this.pAtualizaValor();

                    this.pLimpaItemped();
                }
            } else {
                MostraErro.pMostraErro("Pedido ainda não gravado! Clique no botão Inserir ou posicione um pedido!", "Aviso");
            }
        } else {
            MostraErro.pMostraErro("Item já gravado no pedido", "Aviso");
        }
    }//GEN-LAST:event_BtnInserirItempedActionPerformed

    private void BtnAlterarItempedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarItempedActionPerformed
        if ((!"".equals(this.jtfSeq.getText())) & (!"".equals(this.jtfIdPedido.getText()))) {
            if (fValidaItem() & fValidaQtde()) {
                ItemPedido obj = new ItemPedido();                

                double lnQtde = Double.parseDouble(this.jtfQtdeItemped.getText());
                double lnValorBase = Double.parseDouble(this.jtfVlUnitItemped.getText());
                double lnValorTotal = Double.parseDouble(this.jtfVlTotalItemped.getText());

                obj.setIdPedido(Integer.parseInt(this.jtfIdPedido.getText()));
                obj.setSeq(Integer.parseInt(this.jtfSeq.getText()));
                obj.setIdItem(Integer.parseInt(this.jtfIdItemPed.getText()));
                obj.setQuantidade(lnQtde);
                obj.setValorBase(lnValorBase);
                obj.setValorTotal(lnValorTotal);

                ItempDAO.AlterarItemP(obj);

                this.pLimpaItemped();
                this.pAtualizaValor();
            }
        } else {
            MostraErro.pMostraErro("Selecione um item para a operação!", "Erro");
        }
    }//GEN-LAST:event_BtnAlterarItempedActionPerformed

    private void BtnExcluirItempedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirItempedActionPerformed
        if ((!"".equals(this.jtfSeq.getText())) & (!"".equals(this.jtfIdPedido.getText()))) {         
            ItemPedido obj = new ItemPedido();

            obj.setIdPedido(Integer.parseInt(this.jtfIdPedido.getText()));
            obj.setSeq(Integer.parseInt(this.jtfSeq.getText()));

            ItempDAO.DeletarItemP(obj);
            this.pLimpaItemped();
            this.pAtualizaValor();
        } else {
            MostraErro.pMostraErro("Selecione um item para a operação!", "Erro");
        }
    }//GEN-LAST:event_BtnExcluirItempedActionPerformed

    private void BtnLimparItempedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparItempedActionPerformed
        this.pLimpaItemped();
    }//GEN-LAST:event_BtnLimparItempedActionPerformed

    private void pSetaRazaoSocial(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaRazaoSocial
        if (!"".equals(this.jtfIdCliente.getText())){
            try {
                Integer.parseInt(this.jtfIdCliente.getText());
            } catch (Exception e) {
                MostraErro.pMostraErro("Código do cliente deve ser numérico!", "Erro");
                return;
            }        
        
            Clt = CltDao.buscaClienteByID(Integer.parseInt(this.jtfIdCliente.getText()));
            this.pPreencheCliente(Clt);
        }
    }//GEN-LAST:event_pSetaRazaoSocial

    public void pPreencheCliente (Cliente Obj) {
        if (Obj.getIdCliente() != -1) {
            this.jtfIdCliente.setText(String.valueOf(Obj.getIdCliente()));
            this.jtfRazaoSocial.setText(Obj.getRazaoSocial());
        }        
    }
    
    private void pSetaPedido(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaPedido
        if (!"".equals(this.jtfIdPedido.getText())){
            Obj = objDAO.buscaPedidoByID(Integer.parseInt(this.jtfIdPedido.getText()));                                    
            this.pPreenchetela(Obj);
        }
    }//GEN-LAST:event_pSetaPedido

    private void pSetaValorTotal(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaValorTotal
        if (!"".equals(this.jtfIdItemPed.getText())) {
            try {
                Double.parseDouble(this.jtfQtdeItemped.getText());
            } catch (Exception e) {
                return;
            }
        
            double lnQtde = Double.valueOf(this.jtfQtdeItemped.getText().replace(',', '.'));
            this.jtfQtdeItemped.setText(DecNum.format(lnQtde).replace(',', '.'));

            double lnValor = Double.valueOf(this.jtfQtdeItemped.getText()) * 
                             Double.valueOf(this.jtfVlUnitItemped.getText());

            this.jtfVlTotalItemped.setText(DecNum.format(lnValor).replace(',', '.'));
        }
    }//GEN-LAST:event_pSetaValorTotal

    private void pSetaInfoItem(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaInfoItem
        if (!this.jtfIdItemPed.getText().equals("")) {
            try {
                Integer.parseInt(this.jtfIdItemPed.getText());
            } catch (Exception e) {
                MostraErro.pMostraErro("Código do item deve ser numérico!", "Erro");
                return;
            }        
        
            Item it;
            ItemDAO itDao = new ItemDAO();
            it = itDao.buscaItemByID(Integer.parseInt(this.jtfIdItemPed.getText()));
            this.pPreencheItem(it, true);
        }
    }//GEN-LAST:event_pSetaInfoItem

    private void pSetaData(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pSetaData
        if (jtfDataEmissao.getText().equals("  /  /    ")) {
            jtfDataEmissao.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
        }
    }//GEN-LAST:event_pSetaData

    private void pClicouNaGrid(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pClicouNaGrid
        int i = jTableItens.getSelectedRow();
        ItemPedido obj;
        if (i != -1) {
            obj = ItempDAO.pBuscaItemPById((Integer.parseInt(String.valueOf(jTableItens.getValueAt(i, 0)))));
            
            this.pPreencheItemped(obj);
        }
    }//GEN-LAST:event_pClicouNaGrid

    private void BtnPesquisar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisar2ActionPerformed
        CliPedSL lookup = new CliPedSL(this);
        lookup.setVisible(true);
    }//GEN-LAST:event_BtnPesquisar2ActionPerformed
    
    public void pLimpaItemped(){
        this.jtfDescricaoItemped.setText("");
        this.jtfUnItem.setText("");        
        this.jtfIdItemPed.setText("");
        this.jtfQtdeItemped.setText("");
        this.jtfVlTotalItemped.setText("");
        this.jtfVlUnitItemped.setText("");
        this.jtfSeq.setText("");
        this.pPreencheGrid();
    }
    
    public void pLimpaTela(){
        this.jtfIdPedido.setText("");
        this.jtfIdItemPed.setText("");
        this.jtfIdCliente.setText("");
        this.jtfRazaoSocial.setText("");
        this.jtfVlTotalPedido.setText("");
        this.jcbPrazo.setSelectedIndex(0);
        this.jtfDataEmissao.setText("");
        
        ObjList = objDAO.pPreencheListPedido();
        ObjIterableList = new IterableList <> (ObjList);
    }
    
    public void pPreenchetela(Pedido obj){
        if (obj.getIdPedido() != -1) {
            BtnInserirPedido.setEnabled(Obj.getEncaminhado() == 0);
            BtnAlterarPedido.setEnabled(Obj.getEncaminhado() == 0);
            BtnExcluirPedido.setEnabled(Obj.getEncaminhado() == 0);
            BtnInserirItemped.setEnabled(Obj.getEncaminhado() == 0);
            BtnAlterarItemped.setEnabled(Obj.getEncaminhado() == 0);
            BtnExcluirItemped.setEnabled(Obj.getEncaminhado() == 0);
            BtnLimparItemped.setEnabled (Obj.getEncaminhado() == 0);
            
            this.jtfIdPedido.setText(Integer.toString(obj.getIdPedido()));
            this.jtfIdCliente.setText(Integer.toString(obj.getIdCliente()));
            this.jcbPrazo.setSelectedItem(obj.getPrazo());
            this.jtfDataEmissao.setText(new SimpleDateFormat("dd/MM/yyyy").format(obj.getDtEmissao()));
            this.pSetaRazaoSocial(null);
            this.jtfVlTotalPedido.setText(DecNum.format(obj.getValorTotal()).replace(',', '.'));
            this.pPreencheGrid();
        }
    }
    
    public void pPreencheItem(Item obj, boolean pbValor){        
        double lnValor;
        if (obj.getIdItem() != -1) {
            this.jtfIdItemPed.setText(Integer.toString(obj.getIdItem()));
            this.jtfDescricaoItemped.setText(obj.getDescricao());
            if (obj.getPromocao() == 0) {
                lnValor = (obj.getPrecoUnit() * obj.getQtdeEmbalagem());
            } else {
                lnValor = (obj.getPrecoUnitPromocao() * obj.getQtdeEmbalagem());            
            }
            if (pbValor) {
                this.jtfVlUnitItemped.setText(DecNum.format(lnValor).replace(',', '.'));
            }
            this.jtfUnItem.setText(obj.getSiglaUnidade());
        }
    }
    
    public void pPreencheItemped(ItemPedido obj){
        double lnValorTotal = obj.getValorTotal();
        double lnValorUnit = obj.getValorBase();
        double lnValorQtde = obj.getQuantidade();
        
        this.jtfIdItemPed.setText(Integer.toString(obj.getIdItem()));
        this.jtfVlTotalItemped.setText(DecNum.format(lnValorTotal).replace(',', '.'));
        this.jtfVlUnitItemped.setText(DecNum.format(lnValorUnit).replace(',', '.'));
        this.jtfQtdeItemped.setText(DecNum.format(lnValorQtde).replace(',', '.'));
        this.jtfSeq.setText(Integer.toString(obj.getSeq()));
        this.pSetaInfoItem(null);
    }
    
    public void pAtualizaValor(){
        int iPedido = Integer.parseInt(this.jtfIdPedido.getText());
        objDAO.atualizaValorTotal(iPedido);
        
        Obj = objDAO.buscaPedidoByID(iPedido);
        
        this.pLimpaTela();        
        this.pPreenchetela(Obj);
    }
    
    public void pPreencheGrid () {
        DefaultTableModel model = (DefaultTableModel) jTableItens.getModel();  
        
        model.setNumRows(0);         
        
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();  
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();  
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();  

        esquerda.setHorizontalAlignment(SwingConstants.LEFT);  
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);  
        direita.setHorizontalAlignment(SwingConstants.RIGHT);  

        jTableItens.getColumnModel().getColumn(3).setCellRenderer(direita);
        jTableItens.getColumnModel().getColumn(4).setCellRenderer(direita);
        jTableItens.getColumnModel().getColumn(5).setCellRenderer(direita);
        
        if (!"".equals(this.jtfIdPedido.getText())) {
            Conecta.connect();
            
            rs = Conecta.executar("Select itempedido.seq, item.iditem, item.descricao, "
                    + " itempedido.valorTotal, itempedido.valorbase, itempedido.quantidade"
                    + " From itempedido "
                    + " inner join item on itempedido.idItem = item.idItem"
                    + " where idPedido = " + this.jtfIdPedido.getText()
                    + " order By seq");            
            
                try {
                    while (rs.next()) {
                        model.addRow(new Object[]{rs.getString("seq"),  
                        rs.getString("idItem"),
                        rs.getString("descricao"),
                        DecNum.format(rs.getDouble("quantidade")).replace(',', '.'),
                        DecNum.format(rs.getDouble("valorbase")).replace(',', '.'),
                        DecNum.format(rs.getDouble("valorTotal")).replace(',', '.')
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(TelaPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            Conecta.disconnect();
        }
    }
    
    public boolean fValidaItem () {
        double lnValor = 0;
        
        if ("".equals(this.jtfIdItemPed.getText())) {
            MostraErro.pMostraErro("Nenhum item informado!", "Erro");
            return false;
        }
        try {
            Integer.parseInt(this.jtfIdItemPed.getText());
        } catch (Exception e) {
            MostraErro.pMostraErro("Código do item deve ser numérico!", "Erro");
            return false;
        }
        
        ItemDAO iDao = new ItemDAO();
        Item it = iDao.buscaItemByID(Integer.parseInt(this.jtfIdItemPed.getText()));
        
        if (it.getIdItem() == -1) {
            MostraErro.pMostraErro("Item inválido!", "Erro");
            return false;
        }
        
        if (it.getPrecoUnit()== -1) {
            MostraErro.pMostraErro("Item inválido!", "Erro");
            return false;
        }
        
        if (it.getPromocao() == 0) {
            lnValor = it.getPrecoUnit();
        } else {
            lnValor = it.getPrecoUnitPromocao();            
        }
        
        if (lnValor == 0) {
            MostraErro.pMostraErro("Item sem valor e/ou não disponível em estoque!", "Erro");
            return false;
        }
        
        return true;
    }
    
    public boolean fValidaCliente () {
        try {
            Integer.parseInt(this.jtfIdCliente.getText());
        } catch (Exception e) {
            MostraErro.pMostraErro("Código do cliente deve ser numérico!", "Erro");
            return false;
        }
        
        ClienteDAO cDao = new ClienteDAO();
        Cliente c = cDao.buscaClienteByID(Integer.parseInt(this.jtfIdCliente.getText()));
        
        if (c.getIdCliente() == -1) { 
            MostraErro.pMostraErro("Cliente inválido!", "Erro");
            return false;
        }
        
        if (!"Ativo".equals(c.getStatus())) {
            MostraErro.pMostraErro("Cliente deve estar ativo!", "Erro");
            return false;
        }
        
        return true;
    }
    
    public boolean fValidaQtde () {
        try {
            Double.parseDouble(this.jtfQtdeItemped.getText());
        } catch (Exception e) {
            MostraErro.pMostraErro("Quantidade deve ser numérico!", "Erro");
            return false;
        }
        
        double lnQtde = Double.valueOf(this.jtfQtdeItemped.getText());
        if (lnQtde <= 0) MostraErro.pMostraErro("Quantidade inválida!", "Erro");
        
        return (lnQtde > 0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlterarItemped;
    private javax.swing.JButton BtnAlterarPedido;
    private javax.swing.JButton BtnAnterior;
    private javax.swing.JButton BtnExcluirItemped;
    private javax.swing.JButton BtnExcluirPedido;
    private javax.swing.JButton BtnInserirItemped;
    private javax.swing.JButton BtnInserirPedido;
    private javax.swing.JButton BtnLimparItemped;
    private javax.swing.JButton BtnLimparPedido;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JButton BtnPesquisar1;
    private javax.swing.JButton BtnPesquisar2;
    private javax.swing.JButton BtnPrimeiro;
    private javax.swing.JButton BtnProximo;
    private javax.swing.JButton BtnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableItens;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JComboBox jcbPrazo;
    private javax.swing.JFormattedTextField jtfDataEmissao;
    private javax.swing.JTextField jtfDescricaoItemped;
    private javax.swing.JTextField jtfIdCliente;
    private javax.swing.JTextField jtfIdItemPed;
    private javax.swing.JTextField jtfIdPedido;
    private javax.swing.JFormattedTextField jtfQtdeItemped;
    private javax.swing.JTextField jtfRazaoSocial;
    private javax.swing.JTextField jtfSeq;
    private javax.swing.JTextField jtfUnItem;
    private javax.swing.JFormattedTextField jtfVlTotalItemped;
    private javax.swing.JFormattedTextField jtfVlTotalPedido;
    private javax.swing.JFormattedTextField jtfVlUnitItemped;
    // End of variables declaration//GEN-END:variables
}
