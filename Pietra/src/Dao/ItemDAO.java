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
public class ItemDAO {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    
    public void InserirItem(Item obj){        
        Conecta.connect();
                
        Conecta.inserir("INSERT Into Item (idItem,descricao, SiglaUnidade, precoUnit,"
            + "qtdeEmbalagem,precoTotal,promocao,precoUnitPromocao) VALUES ("
            + obj.getIdItem()+ ",'"
            + obj.getDescricao().replace("'", "$") + "','"
            + obj.getSiglaUnidade() + "',"
            + obj.getPrecoUnit() + ","                
            + obj.getQtdeEmbalagem() + ","
            + obj.getPrecoTotal() + ","
            + obj.getPromocao() + ","
            + obj.getPrecoUnitPromocao()+ ")");                     
        
        Conecta.disconnect();
    }
    
    public boolean DeletarItem (Item obj) {        
        int liCount = 0;
        
        Conecta.connect();
        
        rs = Conecta.executar("Select 1 From itemPedido where idItem = " + obj.getIdItem());        
        try {
            while (rs.next()) {
                liCount++;
            }
        } catch (SQLException ex) {
            return false;
        } 
                    
        if(liCount == 0){
            Conecta.inserir("Delete From Item Where idItem = " + obj.getIdItem());
        }            

        Conecta.disconnect();
        return (liCount == 0);
    }
    
    public void AlterarItem (Item obj) {
        Conecta.connect();            
        
        Conecta.inserir("Update Item set"
            + " descricao = '"        + obj.getDescricao().replace("'", "$")     + "',"
            + " SiglaUnidade = '"         + obj.getSiglaUnidade() + "',"
            + " precoUnit = "         + obj.getPrecoUnit()     + ","
            + " qtdeEmbalagem = "     + obj.getQtdeEmbalagem() + ","
            + " precoTotal = "        + obj.getPrecoTotal()    + ","
            + " promocao = "          + obj.getPromocao()      + ","
            + " precoUnitPromocao = " + obj.getPrecoUnitPromocao()            
            + " Where idItem = " + obj.getIdItem());            
                
        Conecta.disconnect();
    }
    
    public List<Item> pPreencheListItem () {
        List<Item> ObjList = new ArrayList<>();
        
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Item");
                
        try {
            while (rs.next()) {
                Item s = new Item();                
                s.setIdItem(rs.getInt("idItem"));
                s.setDescricao(rs.getString("Descricao"));
                s.setPrecoTotal(rs.getDouble("precoTotal"));
                s.setPrecoUnit(rs.getDouble("precoUnit"));
                s.setPrecoUnitPromocao(rs.getDouble("PrecoUnitPromocao"));
                s.setPromocao(rs.getInt("Promocao"));
                s.setQtdeEmbalagem(rs.getInt("QtdeEmbalagem"));
                s.setSiglaUnidade(rs.getString("SiglaUnidade"));
                
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }
    
    public Item buscaItemByID (int idItem) {
        Item obj = new Item();        
   
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Item Where idItem = " + idItem);
                
        try {
            if(rs != null && rs.next()){
                obj.setIdItem(rs.getInt("idItem"));                
                obj.setDescricao(rs.getString("Descricao"));
                obj.setPrecoTotal(rs.getDouble("PrecoTotal"));
                obj.setPrecoUnit(rs.getDouble("PrecoUnit"));
                obj.setPrecoUnitPromocao(rs.getDouble("PrecoUnitPromocao"));
                obj.setPromocao(rs.getInt("promocao"));                
                obj.setQtdeEmbalagem(rs.getInt("qtdeEmbalagem"));
                obj.setSiglaUnidade(rs.getString("SiglaUnidade"));
            } else {
                obj.setIdItem(-1);
            }
        } catch (SQLException ex) {            
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return (obj);
    }
}