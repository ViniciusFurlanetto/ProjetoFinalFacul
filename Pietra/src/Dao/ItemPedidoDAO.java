/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pietra.SqlServer;
import pietra.TelaUsuario;

/**
 *
 * @author viniciusfurlanetto
 */
public class ItemPedidoDAO {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    
    public void InserirItemP(ItemPedido obj){        
        Conecta.connect();
                
        Conecta.inserir("INSERT Into ItemPedido (idPedido, "
            + " quantidade, valorBase, valorTotal,idItem) VALUES ("
            + obj.getIdPedido()+ ","
            + obj.getQuantidade()+ ","
            + obj.getValorBase()+ ","
            + (obj.getQuantidade() * obj.getValorBase()) + ","
            + obj.getIdItem()+ ")");
        
        Conecta.disconnect();
    }
    
    public void DeletarItemP (ItemPedido obj) {
        Conecta.connect();
            
        Conecta.inserir("Delete From ItemPedido Where seq = " + obj.getSeq());
        
        Conecta.disconnect();
    }
    
    public void AlterarItemP (ItemPedido obj) {
        Conecta.connect();            
        
        Conecta.inserir        
            ("Update ItemPedido set"
            + " quantidade = " + obj.getQuantidade()+ ","
            + " valorBase = "  + obj.getValorBase()+ ","
            + " valorTotal = " + (obj.getQuantidade() * obj.getValorBase())
            + " Where seq = "  + obj.getSeq()
        );
                
        Conecta.disconnect();
    }
    
    public List<ItemPedido> pPreencheListItemP () {
        List<ItemPedido> ObjList = new ArrayList<>();        
   
        Conecta.connect();
            
        rs = Conecta.executar("Select * From ItemPedido");
                
        try {
            while (rs.next()) {
                ItemPedido s = new ItemPedido();       
                
                s.setIdPedido(rs.getInt("IdPedido"));
                s.setIdItem(rs.getInt("IdItem"));
                s.setQuantidade(rs.getDouble("Quantidade"));
                s.setValorBase(rs.getDouble("ValorBase"));
                s.setValorTotal(rs.getDouble("ValorTotal"));
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }
    
    public ItemPedido pBuscaItemPById (int piSeq) {
        ItemPedido obj = new ItemPedido();
        Conecta.connect();
            
        rs = Conecta.executar("Select * From ItemPedido"
                + " where seq = " + piSeq);
                
        try {
            if(rs != null && rs.next()){
                obj.setIdPedido(rs.getInt("IdPedido"));
                obj.setIdItem(rs.getInt("IdItem"));
                obj.setQuantidade(rs.getDouble("Quantidade"));
                obj.setValorBase(rs.getDouble("ValorBase"));
                obj.setValorTotal(rs.getDouble("ValorTotal"));
                obj.setSeq(rs.getInt("seq"));
            } else {
                obj.setIdItem(-1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return obj;
    }
}