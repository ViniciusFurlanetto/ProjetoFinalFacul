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
 * @author viniciusfurlanetto
 */
public class ClienteDAO {    
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    Erros MostraErros;
    
    public void InserirCliente(Cliente cliente){        
        if (cliente.getIdBairro() != -1) {
            Conecta.connect();

            Conecta.inserir("INSERT INTO Cliente (idCLiente,razaoSocial,telefone,"
                + "celular, endereco, idBairro, status, observacao) VALUES ("
                + cliente.getIdCliente() + ",'"
                + cliente.getRazaoSocial().replace("'", "$") + "','"
                + cliente.getTelefone().replace("'", "$")+ "','"
                + cliente.getCelular().replace("'", "$")+ "','"                
                + cliente.getEndereco().replace("'", "$")+ "',"
                + cliente.getIdBairro()+ ",'"
                + cliente.getStatus()+ "','"                
                + cliente.getObservacao().replace("'", "$")+ "')");

            Conecta.disconnect();
        } else {
            MostraErros.pMostraErro("Bairro inválido!", "Erro");
        }
    }
    
    public boolean DeletarCliente (Cliente cliente) {        
        int liCount = 0;
        
        Conecta.connect();
        
        rs = Conecta.executar("Select 1 From pedido where idCliente = " + cliente.getIdCliente());        
        try {
            while (rs.next()) {
                liCount++;
            }
        } catch (SQLException ex) {
            return false;
        } 
                    
        if(liCount == 0){
            Conecta.inserir("Delete From Cliente Where idCliente = " + cliente.getIdCliente());                
        }            

        Conecta.disconnect();
        return (liCount == 0);
    }
    
    public void AlterarCliente (Cliente cliente) {
        if (cliente.getIdBairro() != -1) {        
            Conecta.connect();
                
            Conecta.inserir("Update Cliente set"
            + " razaoSocial = '" + cliente.getRazaoSocial().replace("'", "$")+ "',"
            + " telefone = '"    + cliente.getTelefone().replace("'", "$")   + "',"
            + " celular = '"     + cliente.getCelular().replace("'", "$")    + "',"
            + " endereco = '"    + cliente.getEndereco().replace("'", "$")   + "',"
            + " idBairro = "      + cliente.getIdBairro()     + ","
            + " status = '"      + cliente.getStatus()     + "',"
            + " observacao = '"  + cliente.getObservacao().replace("'", "$") + "'"
            + " Where idCliente = " + cliente.getIdCliente());            
                
            Conecta.disconnect();
        } else {
            MostraErros.pMostraErro("Bairro inválido!", "Erro");
        }
    }
    
    public List<Cliente> pPreencheListCliente () {
        List<Cliente> ObjList = new ArrayList<>();
        
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Cliente");
                
        try {
            while (rs.next()) {
                Cliente Clt = new Cliente();                
                
                Clt.setIdCliente(rs.getInt("IdCliente"));                
                Clt.setRazaoSocial(rs.getString("RazaoSocial"));
                Clt.setTelefone(rs.getString("Telefone"));
                Clt.setCelular(rs.getString("Celular"));                
                Clt.setIdBairro(rs.getInt("idBairro"));                
                Clt.setStatus(rs.getString("Status"));
                Clt.setObservacao(rs.getString("Observacao"));
                Clt.setEndereco(rs.getString("Endereco"));
                
                ObjList.add(Clt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }
    
    public Cliente buscaClienteByID (int idCliente) {
        Cliente Clt = new Cliente();        
   
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Cliente Where idCliente = " + idCliente);
                
        try {
            if(rs != null && rs.next()){
                Clt.setIdCliente(rs.getInt("IdCliente"));                
                Clt.setRazaoSocial(rs.getString("RazaoSocial"));
                Clt.setTelefone(rs.getString("Telefone"));
                Clt.setCelular(rs.getString("Celular"));
                Clt.setIdBairro(rs.getInt("idBairro"));                
                Clt.setStatus(rs.getString("Status"));
                Clt.setObservacao(rs.getString("Observacao"));
                Clt.setEndereco(rs.getString("Endereco"));
            } else {
                Clt.setIdCliente(-1);
            }
        } catch (SQLException ex) {            
            Logger.getLogger(TelaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return (Clt);
    }
}