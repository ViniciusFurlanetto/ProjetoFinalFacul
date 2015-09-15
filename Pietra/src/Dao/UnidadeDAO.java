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
public class UnidadeDAO {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
        
    public List<Unidade> pPreencheListUnidade () {
        List<Unidade> ObjList = new ArrayList<>();
        
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Unidade");
                
        try {
            while (rs.next()) {
                Unidade s = new Unidade();                
                s.setSiglaUnidade(rs.getString("SiglaUnidade"));
                s.setDescricao(rs.getString("Descricao"));
                
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }
    
    public Unidade buscaUnidadeBySigla (String psUnidade) {
        Unidade obj = new Unidade();        
   
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Unidade Where siglaUnidade = '" + psUnidade + "'");
                
        try {
            if(rs != null && rs.next()){
                obj.setSiglaUnidade(rs.getString("siglaUnidade"));                
                obj.setDescricao(rs.getString("Descricao"));                
            } else {
                obj.setSiglaUnidade("-1");
            }
        } catch (SQLException ex) {            
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return (obj);
    }
}