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
public class MunicipioDAO {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
        
    public List<Municipio> pPreencheListMunicipio () {
        List<Municipio> ObjList = new ArrayList<>();
        
        Conecta.connect();
            
        rs = Conecta.executar("Select IdMunicipio, municipio.nome, municipio.idRepres,"
                + " municipio.siglaPais, municipio.uf, coalesce(representante.nome,'')"
                + " From Municipio"
                + " Left join representante on municipio.idRepres = representante.idRepres");
              
        try {            
            while (rs.next()) {
                Municipio s = new Municipio();                
                s.setIdMunicipio(rs.getInt("IdMunicipio"));
                s.setNome(rs.getString("municipio.Nome"));                
                s.setIdRepres(rs.getInt("municipio.idRepres"));
                s.setSiglaPais(rs.getString("municipio.SiglaPais"));
                s.setUf(rs.getString("municipio.Uf"));
                s.setNomeRepres(rs.getString("coalesce(representante.nome,'')"));
                
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }
    
    public Municipio buscaMunicipioByID (int pIdMunicipio) {
        Municipio obj = new Municipio();        
   
        Conecta.connect();
        
        rs = Conecta.executar("Select IdMunicipio, municipio.nome, municipio.idRepres,"
                + " municipio.siglaPais, municipio.uf, coalesce(representante.nome,'')"
                + " From Municipio"
                + " left join representante on municipio.idRepres = representante.idRepres"
                + " Where IdMunicipio = " + pIdMunicipio);       
                                
        try {
            if(rs != null && rs.next()){
                obj.setIdMunicipio(rs.getInt("IdMunicipio"));
                obj.setNome(rs.getString("Nome"));                
                obj.setIdRepres(rs.getInt("idRepres"));
                obj.setSiglaPais(rs.getString("SiglaPais"));
                obj.setUf(rs.getString("Uf"));
                obj.setNomeRepres(rs.getString("coalesce(representante.nome,'')"));
            } else {
                obj.setIdMunicipio(-1);                
            }
        } catch (SQLException ex) {            
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return (obj);
    }
    
    public void VinculaRepresentante (Municipio obj) {
        Conecta.connect();            

        Conecta.inserir("Update Municipio set"
            + " idRepres = "          + obj.getIdRepres()
            + " Where idMunicipio = "  + obj.getIdMunicipio()
        );            
                
        Conecta.disconnect();
    }
}