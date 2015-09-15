/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import pietra.SqlServer;
import pietra.Erros;

/**
 *
 * @author viniciusfurlanetto
 */
public class ComissaoModel {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    Erros MostraErros = new Erros();
        
    private int idRepres;
    private double ValorTotal;
    private String nome;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public SqlServer getConecta() {
        return Conecta;
    }

    public void setConecta(SqlServer Conecta) {
        this.Conecta = Conecta;
    }

    public int getIdRepres() {
        return idRepres;
    }

    public void setIdRepres(int idRepres) {
        this.idRepres = idRepres;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }   

    public List<ComissaoModel> pPreencheList (String psDataIni,String psDataFim) {
        
        List<ComissaoModel> ObjList = new ArrayList<>();
        
        String sDataIni = "";
        String sDataFim = "";
        
        java.util.Date DataIni;
        try {
            DataIni = new SimpleDateFormat("dd/MM/yyyy").parse(psDataIni);
            sDataIni = new SimpleDateFormat("yyyy-MM-dd").format(DataIni);
        } catch (ParseException ex) {
            MostraErros.pMostraErro("Ocorreu um erro com as datas, verifique a data inicial digitada.", "Erro");
        }        
        
        java.util.Date DataFim;
        try {
            DataFim = new SimpleDateFormat("dd/MM/yyyy").parse(psDataFim);
            sDataFim = new SimpleDateFormat("yyyy-MM-dd").format(DataFim);
        } catch (ParseException ex) {
            MostraErros.pMostraErro("Ocorreu um erro com as datas, verifique a data final digitada.", "Erro");
        }
        
        Conecta.connect();
        rs = Conecta.executar
            ("Select pedido.idRepres, representante.nome, sum(pedido.valorTotal * representante.perComissao / 100.00) as valorTotal"
                + " From Pedido "
                + " inner join Representante on pedido.idRepres = representante.idRepres"
                + " where DtEmissao Between '" + sDataIni + "' And '" + sDataFim + "'"
                + " Group By pedido.idRepres, representante.nome"    
        );                
                
        try {                  
            while (rs.next()) {
                ComissaoModel s = new ComissaoModel();
                s.setIdRepres(rs.getInt("idRepres"));                  
                s.setValorTotal(rs.getDouble("valorTotal"));
                s.setNome(rs.getString("nome"));
                
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            MostraErros.pMostraErro("Ocorreu um erro com a geração do relatório. verifique os dados digitados.", "Erro");
        }
       
        Conecta.disconnect();
        
        return ObjList;
    }
}