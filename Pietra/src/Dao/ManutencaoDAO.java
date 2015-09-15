package Dao;

import pietra.SqlServer;

/**
 *
 * @author viniciusfurlanetto
 */
public class ManutencaoDAO {
    SqlServer Conecta = new SqlServer();
    
    public void pExportaDB() {
        Conecta.connect();
            
        Conecta.inserir("mysqldump -u root -p root pietra > pietra.sql");
        
        Conecta.disconnect();
    }
}
