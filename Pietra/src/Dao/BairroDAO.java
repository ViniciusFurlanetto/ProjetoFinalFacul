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
public class BairroDAO {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
        
    public List<Bairro> pPreencheListBairro () {
        List<Bairro> ObjList = new ArrayList<>();
        
        Conecta.connect();
            
        rs = Conecta.executar("Select bairro.idBairro, bairro.nome, municipio.idMunicipio, municipio.nome From bairro "
                + " inner join municipio on municipio.idMunicipio = bairro.idMunicipio"
                + " order By idBairro");
                
        try {
            while (rs.next()) {
                Bairro obj = new Bairro();                
                obj.setIdMunicipio(rs.getInt("municipio.IdMunicipio"));
                obj.setNome(rs.getString("bairro.Nome"));                
                obj.setIdBairro(rs.getInt("idBairro"));
                obj.setNomeMunicipio(rs.getString("municipio.nome"));
                
                ObjList.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }
    
    public Bairro buscaBairroByID (int pIdBairro) {
        Bairro obj = new Bairro();        
   
        Conecta.connect();
            
        rs = Conecta.executar("Select idBairro, bairro.nome, municipio.idMunicipio, municipio.nome From bairro "
                + " inner join municipio on municipio.idMunicipio = bairro.idMunicipio"
                + " Where IdBairro = " + pIdBairro);
                
        try {
            if(rs != null && rs.next()){
                obj.setIdMunicipio(rs.getInt("municipio.IdMunicipio"));
                obj.setNome(rs.getString("bairro.Nome"));                
                obj.setIdBairro(rs.getInt("idBairro"));
                obj.setNomeMunicipio(rs.getString("municipio.nome"));
            } else {
                obj.setIdBairro(-1);                
            }
        } catch (SQLException ex) {            
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return (obj);
    }
}