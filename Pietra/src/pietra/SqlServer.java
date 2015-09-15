/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietra;


//retirado do site
//http://www.devmedia.com.br/java-classes-de-conexao-com-banco-de-dados-sql-server/23706#comentariosArtigo
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServer {
    Erros MostraErro = new Erros();
    
    private String host;
    private String user;
    private String pass;
    private String database;
    
    public Connection c;
    
    /**
     * Construtor da classe
     *
     * @param host Host em que se deseja conectar
     * @param database Nome do database em que se deseja conectar
     * @param user Nome do usuário
     * @param pass Senha do usuário
     */
    public SqlServer () {
        this.pass = "root";
        this.user = "root";
        this.host = "localhost:8889"; //mac
//        this.host = "localhost:3306"; //windows
        this.database = "pietra";
    }
   
    public boolean connect() {
        boolean isConnected = false;
        String url;
        
        url = "jdbc:mysql://"+this.host+"/"
              +this.database+"?"
              +"user="+this.user
              +"&password="+this.pass;
              
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();            
            this.c = DriverManager.getConnection(url);
            isConnected = true;
        } catch( SQLException e ) {
            e.printStackTrace();
            MostraErro.pMostraErro("Ocorreu um erro na conexão com o banco! Verifique se o mesmo está disponível.", "Erro");
            isConnected = false;
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
            MostraErro.pMostraErro("Não foi encontrado a classe de conexão com o banco. Reinstale o conector", "Erro");
            isConnected = false;
        } catch ( InstantiationException e ) {
            e.printStackTrace();
            MostraErro.pMostraErro(e.getMessage(), "Erro");
            isConnected = false;
        } catch ( IllegalAccessException e ) {
            e.printStackTrace();
            MostraErro.pMostraErro(e.getMessage(), "Erro");
            isConnected = false;
        }
        
        return isConnected;
    }

    
    /**
     * Método que estabelece a desconexão com o banco de dados
     *
     * @return True se conseguir desconectar, falso em caso contrário.
     */
    public boolean disconnect() {
        boolean isConnected = false;
       
        String url;
        url = "jdbc:mysql://"+this.host+"/"
              +this.database+"?"
              +"user="+this.user
              +"&password="+this.pass;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();            
            this.c = DriverManager.getConnection(url);
            this.c.close();
            isConnected = true;
        } catch( SQLException e ) {
            MostraErro.pMostraErro(e.getMessage(), "Erro");
            isConnected = false;
        } catch ( ClassNotFoundException e ) {
            MostraErro.pMostraErro(e.getMessage(), "Erro");
            isConnected = false;
        } catch ( InstantiationException e ) {
            MostraErro.pMostraErro(e.getMessage(), "Erro");
            isConnected = false;
        } catch ( IllegalAccessException e ) {
            MostraErro.pMostraErro(e.getMessage(), "Erro");
            isConnected = false;
        }
       
        return isConnected;
    }

    /**
     * Esse método executa a query dada, e retorna um ResultSet
     * Talvez fosse melhor idéia fazer esse método lançar uma exception
     * a faze-lo retornar null como eu fiz, porém isso é apenas um exemplo
     * para demonstrar a funcionalidade do comando execute
     *
     * @param query String contendo a query que se deseja executar
     * @return ResultSet em caso de estar tudo Ok, null em caso de erro.
     */
    public ResultSet executar( String query ) {
        Statement st;
        ResultSet rs;
       
        try {
            st = this.c.createStatement();
            rs = st.executeQuery(query);            
            return rs;
        } catch ( SQLException e ) {            
            MostraErro.pMostraErro("Erro na execução do comando, verifique os dados inseridos.", "Erro");
        }
       
        return null;
    }
   
    /**
     * Executa uma query como update, delete ou insert.
     * Retorna o número de registros afetados quando falamos de um update ou delete
     * ou retorna 1 quando o insert é bem sucedido. Em outros casos retorna -1
     *
     * @param query A query que se deseja executar
     * @return 0 para um insert bem sucedido. -1 para erro
     */
    public int inserir( String query ) {
        Statement st;
        int result = -1;         
       
        try {
            st = this.c.createStatement();
            result = st.executeUpdate(query);
        } catch ( SQLException e ) {
            MostraErro.pMostraErro("Erro na execução do comando, verifique os dados inseridos.", "Erro");
        }
       
        return result;
    }        
}