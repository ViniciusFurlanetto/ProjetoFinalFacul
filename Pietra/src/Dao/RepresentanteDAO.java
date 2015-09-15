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
import pietra.Erros;

/**
 *
 * @author viniciusfurlanetto
 */
public class RepresentanteDAO {    
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    Erros MostraErros;
    
    public void InserirRepres(Representante obj){        
        Conecta.connect();
                        
        Conecta.inserir("INSERT INTO Representante (idRepres,nome,telefone,"
            + "celular,perComissao) VALUES ("
            + obj.getIdRepres()+ ",'"
            + obj.getNome().replace("'", "$") + "','"
            + obj.getTelefone().replace("'", "$") + "','"
            + obj.getCelular().replace("'", "$") + "',"                
            + obj.getPerComissao()+ ")");                
        
        Conecta.disconnect();
    }
    
    public boolean DeletarRepres (Representante obj) {                
        int liCount = 0;
        
        Conecta.connect();
        
        rs = Conecta.executar("Select 1 From pedido where idRepres = " + obj.getIdRepres());        
        try {
            while (rs.next()) {
                liCount++;
            }
        } catch (SQLException ex) {
            return false;
        } 
                    
        if(liCount == 0){
            Conecta.inserir("Delete From Representante Where idRepres = " + obj.getIdRepres());
        }      
                      
        Conecta.disconnect();
        
        return (liCount == 0);
    }
    
    public void AlterarRepres (Representante obj) {
        Conecta.connect();
                
        Conecta.inserir("Update Representante set"
            + " nome = '"          + obj.getNome().replace("'", "$") + "',"
            + " telefone = '"      + obj.getTelefone().replace("'", "$")   + "',"
            + " celular = '"       + obj.getCelular().replace("'", "$")    + "',"
            + " perComissao = "    + obj.getPerComissao()
            + " Where idRepres = " + obj.getIdRepres());            
                
        Conecta.disconnect();
    }
    
    public List<Representante> pPreencheListRepres () {
        List<Representante> ObjList = new ArrayList<>();

        Conecta.connect();
            
        rs = Conecta.executar("Select * From Representante");
                
        try {
            while (rs.next()) {
                Representante s = new Representante();                
                s.setIdRepres(rs.getInt("idRepres"));
                s.setNome(rs.getString("nome"));
                s.setCelular(rs.getString("celular"));
                s.setPerComissao(rs.getDouble("PerComissao"));
                s.setTelefone(rs.getString("telefone"));
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }        
    
    public Representante buscaRepresByID (int idRepres) {
        Representante s = new Representante();        
   
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Representante Where idRepres = " + idRepres);
                
        try {
            if(rs != null && rs.next()){                
                s.setIdRepres(rs.getInt("idRepres"));
                s.setNome(rs.getString("nome"));
                s.setCelular(rs.getString("celular"));
                s.setPerComissao(rs.getDouble("PerComissao"));
                s.setTelefone(rs.getString("telefone"));
            } else {
                s.setIdRepres(-1);
            }
        } catch (SQLException ex) {            
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return (s);
    }
}

