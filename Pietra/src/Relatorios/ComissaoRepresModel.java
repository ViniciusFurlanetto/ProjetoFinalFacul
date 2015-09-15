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
import java.util.logging.Level;
import java.util.logging.Logger;
import pietra.SqlServer;
import pietra.Erros;
import pietra.TelaLogin;

/**
 *
 * @author viniciusfurlanetto
 */
public class ComissaoRepresModel {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    Erros MostraErros = new Erros();
        
    private int idCliente;
    private int idPedido;
    private double ValorTotal;
    private String razaoSocial;
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }    
    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public SqlServer getConecta() {
        return Conecta;
    }

    public void setConecta(SqlServer Conecta) {
        this.Conecta = Conecta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }   

    public List<ComissaoRepresModel> pPreencheList (String psDataIni,String psDataFim) {
        
        List<ComissaoRepresModel> ObjList = new ArrayList<>();
        TelaLogin TelaLogin = new TelaLogin();
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
            ("Select pedido.idCliente, cliente.razaoSocial, pedido.idpedido, (pedido.valorTotal * representante.perComissao / 100.00) as valorTotal"
                + " From Pedido "
                + " inner join Representante on pedido.idRepres = representante.idRepres"
                + " inner join cliente on pedido.idCliente = cliente.idCliente"
                + " where DtEmissao Between '" + sDataIni + "' And '" + sDataFim + "'"
                + " and pedido.idRepres = " + TelaLogin.piRepresUsuario
                + " order by pedido.idCliente, idPedido"
        );                
                
        try {                  
            while (rs.next()) {
                ComissaoRepresModel s = new ComissaoRepresModel();
                s.setIdCliente(rs.getInt("idCliente"));                  
                s.setValorTotal(rs.getDouble("valorTotal"));
                s.setRazaoSocial(rs.getString("razaoSocial"));
                s.setIdPedido(rs.getInt("idPedido"));
                
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioComissaoRepres.class.getName()).log(Level.SEVERE, null, ex);
//            MostraErros.pMostraErro("Ocorreu um erro com a geração do relatório. verifique os dados digitados.", "Erro");
        }
       
        Conecta.disconnect();
        
        return ObjList;
    }
}