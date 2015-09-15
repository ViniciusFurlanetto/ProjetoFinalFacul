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
public class ItemPromoModel {
    private int idItem;
    private String descricao;
    private String siglaUnidade;
    private double precoUnit;
    private int qtdeEmbalagem;
    private double precoTotal;

    SqlServer Conecta = new SqlServer();
    ResultSet rs;
    
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getSiglaUnidade() {
        return siglaUnidade;
    }

    public void setSiglaUnidade(String siglaUnidade) {
        this.siglaUnidade = siglaUnidade;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public int getQtdeEmbalagem() {
        return qtdeEmbalagem;
    }

    public void setQtdeEmbalagem(int qtdeEmbalagem) {
        this.qtdeEmbalagem = qtdeEmbalagem;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
        
	
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }	
    
    public List<ItemPromoModel> pPreencheList (int piItemIni, int piItemFim) {
        List<ItemPromoModel> ObjList = new ArrayList<>();
        double lnpreco = 0;
        double lnqtde = 0;
        
        Conecta.connect();
            
        rs = Conecta.executar("Select * From Item "
                + " where idItem between " + piItemIni + " and " + piItemFim
                + " and promocao = 1");
                
        try {
            while (rs.next()) {
                ItemPromoModel s = new ItemPromoModel();                
                s.setIdItem(rs.getInt("idItem"));
                s.setDescricao(rs.getString("Descricao"));
                lnpreco = rs.getDouble("PrecoUnitPromocao");
                lnqtde = rs.getDouble("QtdeEmbalagem");
                s.setPrecoTotal(lnpreco * lnqtde);
                s.setPrecoUnit(rs.getDouble("PrecoUnitPromocao"));
                s.setQtdeEmbalagem(rs.getInt("QtdeEmbalagem"));
                s.setSiglaUnidade(rs.getString("siglaUnidade"));
                
                ObjList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Conecta.disconnect();
        
        return ObjList;
    }
}

