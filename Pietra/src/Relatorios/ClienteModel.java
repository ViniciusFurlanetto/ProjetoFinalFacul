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
import java.util.logging.Level;
import java.util.logging.Logger;
import pietra.SqlServer;

/**
 *
 * @author viniciusfurlanetto
 */
public class ClienteModel {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    
    private int idCliente;
    private String razaoSocial;
    private String telefone;
    private String celular;
    private String endereco;
    private String status;
    private String observacao;   

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }  

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<ClienteModel> pPreencheList (int piClienteIni, int piClienteFim, String psStatus, int piMunicipio) {
        List<ClienteModel> ObjList = new ArrayList<>();
        
        String psFiltro = "";
        if (!"Todos".equals(psStatus)) psFiltro = " and status = '" + psStatus +  "'";
        
        if (piMunicipio != 0) {
            psFiltro = (psFiltro + " and Bairro.idMunicipio = " + piMunicipio);
        }
        
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Cliente "
                + " inner join Bairro on Cliente.idBairro = Bairro.idBairro"
                + " where idCliente between " + piClienteIni + " and " + piClienteFim
                + psFiltro
        );                
                
        try {
            while (rs.next()) {
                ClienteModel s = new ClienteModel();                
                s.setIdCliente(rs.getInt("idCliente"));  
                s.setRazaoSocial(rs.getString("razaoSocial"));
                s.setTelefone(rs.getString("telefone"));
                s.setCelular(rs.getString("celular"));
                s.setEndereco(rs.getString("endereco"));
                s.setStatus(rs.getString("status"));
                s.setObservacao(rs.getString("observacao"));
                
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }
}