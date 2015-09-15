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
import pietra.TelaLogin;

/**
 *
 * @author viniciusfurlanetto
 */
public class PedidoModel {
    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    Erros MostraErros = new Erros();
    
    private int idPedido;
    private int idCliente;
    private int idRepresentante;
    private String prazo;
    private double ValorTotal;
    private String RazaoSocial;
    
    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }
    
    public SqlServer getConecta() {
        return Conecta;
    }

    public void setConecta(SqlServer Conecta) {
        this.Conecta = Conecta;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(int idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }   

    public List<PedidoModel> pPreencheList (int piClienteIni, int piClienteFim, String psDataIni,
            String psDataFim, boolean pbEncaminhado
            ) {
        
        List<PedidoModel> ObjList = new ArrayList<>();
        
        String sEncaminhados = "";
        String sDataIni = "";
        String sDataFim = "";
        String lsSQL = "";
        
        if (pbEncaminhado) sEncaminhados = " and encaminhado = 1";  
        
        if (TelaLogin.piIsDiretor == 0) {
            lsSQL = (" and idRepres = " + TelaLogin.piRepresUsuario);
        }
        
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
            ("Select idPedido, pedido.idCliente, idRepres,"
                + "prazo, encaminhado, valorTotal, DtEmissao, razaoSocial"
                + " From Pedido "
                + " inner join cliente on pedido.idCliente = cliente.idCliente"
                + " where pedido.idCliente between " + piClienteIni + " and " + piClienteFim
                + " and DtEmissao Between '" + sDataIni + "' And '" + sDataFim + "'"
                + sEncaminhados + lsSQL
                
        );                
                
        try {                  
            while (rs.next()) {
                PedidoModel s = new PedidoModel();
                s.setIdPedido(rs.getInt("idPedido"));
                s.setIdCliente(rs.getInt("idCliente"));
                s.setIdRepresentante(rs.getInt("idRepres"));                  
                s.setPrazo(rs.getString("prazo"));
                s.setValorTotal(rs.getDouble("valorTotal"));
                s.setRazaoSocial(rs.getString("razaoSocial"));
                
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            MostraErros.pMostraErro("Ocorreu um erro com a geração do relatório. verifique os dados digitados.", "Erro");
        }
       
        Conecta.disconnect();
        
        return ObjList;
    }
}