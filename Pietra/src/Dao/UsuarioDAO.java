package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pietra.Erros;
import pietra.SqlServer;

public class UsuarioDAO {    
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    Erros MostraErro = new Erros();
    
    public void InserirUsuario(Usuario usuario){        
        Conecta.connect();
        
        Conecta.inserir("INSERT INTO Usuario (nome,senha, idRepres,"
            + "diretor) VALUES ('"
            + usuario.getNome().replace("'", "$") + "','"
            + usuario.getSenha().replace("'", "$") + "',"
            + usuario.getIdRepres() + ","
            + usuario.getDiretor() + ")");                
        
        Conecta.disconnect();
    }
    
    public void DeletarUsuario (Usuario usuario) {
        Conecta.connect();
            
        Conecta.inserir("Delete From Usuario Where idUsuario = " + usuario.getIdUsuario());
        
        Conecta.disconnect();
    }
    
    public void AlterarUsuario (Usuario usuario) {
        String lsSenha = usuario.getSenha().replace("'", "$");
        if (lsSenha.length() > 0) {
            lsSenha = " senha = ' " + lsSenha + "',";
        } else {
            lsSenha = "";
        }
                
        Conecta.connect();
                        
        Conecta.inserir("Update Usuario"            
            + " set nome = '" + usuario.getNome().replace("'", "$") + "',"
            + lsSenha
            + " idRepres = " + usuario.getIdRepres()+ ","
            + " diretor = " + usuario.getDiretor()
            + " Where idUsuario = " + usuario.getIdUsuario());                    
        
        Conecta.disconnect();
    }
    
    public Usuario BuscaUsuarioById(int piId){
        Usuario Usr = new Usuario();
        Conecta.connect();
                
        if (piId != 0) {
            Conecta.connect();

            rs = Conecta.executar("Select * From Usuario Where idUsuario = " + piId);

            try {
                if(rs != null && rs.next()){  
                    Usr.setIdUsuario(piId);
                    Usr.setNome(rs.getString("nome"));
                    Usr.setIdRepres(rs.getInt("idRepres"));
                    Usr.setSenha(rs.getString("senha"));
                    Usr.setDiretor(rs.getInt("diretor"));                                        
                } else {
                    Usr.setIdUsuario(-1);
                }
            }
            catch (SQLException ex) {
                MostraErro.pMostraErro("Não foi possível se conectar ao banco!", "Erro");                
            }
            Conecta.disconnect();
        }
                
        return Usr;
    }
    
    public Usuario BuscaUsuarioByNome(String psNome){
        Usuario Usr = new Usuario();
        Conecta.connect();
                
        if (!"".equals(psNome)) {
            Conecta.connect();
            rs = Conecta.executar("Select * From Usuario Where nome = '" + psNome.replace("'", "$") + "'");                       
            
            try {
                if(rs != null && rs.next()){
                    Usr.setIdUsuario(rs.getInt("idUsuario"));
                    Usr.setNome(rs.getString("nome"));
                    Usr.setIdRepres(rs.getInt("idRepres"));
                    Usr.setSenha(rs.getString("senha"));
                    Usr.setDiretor(rs.getInt("diretor"));                                        
                } else {
                    Usr.setIdUsuario(-1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            Conecta.disconnect();
        }
                
        return Usr;
    } 
    
    public List<Usuario> pPreencheListUsuario () {
        List<Usuario> UsrList = new ArrayList<>();        
   
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Usuario where idUsuario > 0 order by idUsuario");
                
        try {
            while (rs.next()) {
                Usuario s = new Usuario();                
                s.setIdUsuario(rs.getInt("idUsuario"));
                s.setNome(rs.getString("nome"));
                s.setIdRepres(rs.getInt("idRepres"));
                s.setDiretor(rs.getInt("diretor"));
                s.setSenha(rs.getString("senha"));
                UsrList.add(s);
            }
        } catch (SQLException ex) {
            MostraErro.pMostraErro("Não foi possível se conectar ao banco!", "Erro");
        }
        
        Conecta.disconnect();
        
        return UsrList;
    }        
}