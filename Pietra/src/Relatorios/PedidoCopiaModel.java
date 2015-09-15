/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pietra.SqlServer;
import pietra.Erros;

/**
 *
 * @author viniciusfurlanetto
 */
public class PedidoCopiaModel {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    Erros MostraErros = new Erros();
    
    private int idItem;    
    private double ValorTotal;
    private double ValorBase;
    private double quantidade;
    private String descricao;    
    
    public double getValorBase() {
        return ValorBase;
    }

    public void setValorBase(double ValorBase) {
        this.ValorBase = ValorBase;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public SqlServer getConecta() {
        return Conecta;
    }

    public void setConecta(SqlServer Conecta) {
        this.Conecta = Conecta;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }   

    public List<PedidoCopiaModel> pPreencheList (int pnNroPedido) {
        List<PedidoCopiaModel> ObjList = new ArrayList<>();
                
               
        Conecta.connect();
        rs = Conecta.executar
            ("Select item.idItem, descricao, valorBase,"
                + " quantidade, valorTotal"
                + " From ItemPedido "
                + " inner join Item on itempedido.idItem = item.idItem"
                + " where ItemPedido.idPedido = " + pnNroPedido                
        );                
                
        try {                  
            while (rs.next()) {
                PedidoCopiaModel s = new PedidoCopiaModel();
                s.setIdItem(rs.getInt("idItem"));
                s.setDescricao(rs.getString("descricao"));
                s.setValorTotal(rs.getDouble("valorTotal"));
                s.setQuantidade(rs.getDouble("quantidade"));
                s.setValorBase(rs.getDouble("valorBase"));                
                
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            MostraErros.pMostraErro("Ocorreu um erro com a geração do relatório. verifique os dados digitados.", "Erro");
        }
       
        Conecta.disconnect();
        
        return ObjList;
    }
}