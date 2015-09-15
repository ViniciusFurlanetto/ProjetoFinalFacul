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
import pietra.Erros;
import pietra.SqlServer;
import pietra.TelaLogin;

/**
 *
 * @author viniciusfurlanetto
 */
public class PedidoDAO {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;    
    Erros MostraErro = new Erros();
    
    public void InserirPedido(Pedido obj){        
        Conecta.connect();
                
        Conecta.inserir("INSERT Into Pedido (prazo, "
            + " dtEmissao, idCliente, idRepres) VALUES ('"
            + obj.getPrazo().replace("'", "$") + "','"
            + obj.getDtEmissao() + "',"
            + obj.getIdCliente()+ ","                
            + obj.getIdRepres()+ ")");
        
        Conecta.disconnect();
    }
    
    public void DeletarPedido (Pedido obj) {
        Conecta.connect();
            
        Conecta.inserir("Delete From Pedido Where idPedido = " + obj.getIdPedido());
        
        Conecta.disconnect();
    }
    
    public void AlterarPedido (Pedido obj) {
        Conecta.connect();            

        Conecta.inserir("Update Pedido set"
            + " prazo = '"          + obj.getPrazo().replace("'", "$")      + "',"
            + " dtEmissao = '"      + obj.getDtEmissao()  + "',"
            + " idCliente = "       + obj.getIdCliente()
            + " Where idPedido = "  + obj.getIdPedido()
        );            
                
        Conecta.disconnect();
    }
    
    public List<Pedido> pPreencheListPedido () {
        List<Pedido> ObjList = new ArrayList<>();
        String lsSQL = ("Select * From Pedido");       
        
        Conecta.connect();
                
        
        if (TelaLogin.piIsDiretor == 0) {
            lsSQL = (lsSQL + " where idRepres = " + TelaLogin.piRepresUsuario);
        }
        rs = Conecta.executar(lsSQL);
        try {
            while (rs.next()) {
                Pedido s = new Pedido();                
                s.setIdPedido(rs.getInt("idPedido"));
                s.setIdCliente(rs.getInt("idCliente"));
                s.setIdRepres(rs.getInt("idRepres"));
                s.setDtEmissao(rs.getDate("DtEmissao"));
                s.setEncaminhado(rs.getInt("encaminhado"));
                s.setPrazo(rs.getString("prazo"));
                s.setValorTotal(rs.getDouble("ValorTotal"));
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            MostraErro.pMostraErro("Erro na sintaxe de SQL, verifique os dados inseridos!", "Erro");
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }    
    
    public void atualizaValorTotal (int id) {
        Conecta.connect();            

        Conecta.inserir("Update PEDIDO set"
            + " VALORTOTAL = (select coalesce(Sum(ITEMPEDIDO.VALORTOTAL),0) "
            + " From ITEMPEDIDO "
            + " Where ITEMPEDIDO.idPedido = PEDIDO.idPedido)"
            + " Where idPedido = " + id
        );            
                
        Conecta.disconnect();
    }
    
    public Pedido buscaPedidoByID (int idPedido) {
        Pedido Obj = new Pedido();        
   
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Pedido Where idPedido = " + idPedido);
                
        try {
            if(rs != null && rs.next()){                
                Obj.setIdCliente(rs.getInt("IdCliente"));
                Obj.setDtEmissao(rs.getDate("DtEmissao"));
                Obj.setEncaminhado(rs.getInt("encaminhado"));
                Obj.setIdPedido(rs.getInt("idPedido"));
                Obj.setIdRepres(rs.getInt("idRepres"));
                Obj.setPrazo(rs.getString("prazo"));                
                Obj.setValorTotal(rs.getDouble("ValorTotal"));                
            } else {
                Obj.setIdPedido(-1);
            }
        } catch (SQLException ex) {            
            MostraErro.pMostraErro("Erro na sintaxe de SQL, verifique os dados inseridos!", "Erro");
        }
        
        Conecta.disconnect();
        
        return (Obj);
    }
}