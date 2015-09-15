/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author viniciusfurlanetto
 */
@Entity
@Table(name = "Item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIdItem", query = "SELECT i FROM Item i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "Item.findByDescricao", query = "SELECT i FROM Item i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "Item.findBySiglaUnidade", query = "SELECT i FROM Item i WHERE i.siglaUnidade = :siglaUnidade"),
    @NamedQuery(name = "Item.findByPrecoUnit", query = "SELECT i FROM Item i WHERE i.precoUnit = :precoUnit"),
    @NamedQuery(name = "Item.findByQtdeEmbalagem", query = "SELECT i FROM Item i WHERE i.qtdeEmbalagem = :qtdeEmbalagem"),
    @NamedQuery(name = "Item.findByPrecoTotal", query = "SELECT i FROM Item i WHERE i.precoTotal = :precoTotal"),
    @NamedQuery(name = "Item.findByPromocao", query = "SELECT i FROM Item i WHERE i.promocao = :promocao"),
    @NamedQuery(name = "Item.findByPrecoUnitPromocao", query = "SELECT i FROM Item i WHERE i.precoUnitPromocao = :precoUnitPromocao")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idItem")
    private Integer idItem;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "SiglaUnidade")
    private String siglaUnidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precoUnit")
    private Double precoUnit;
    @Column(name = "qtdeEmbalagem")
    private Integer qtdeEmbalagem;
    @Column(name = "precoTotal")
    private Double precoTotal;
    @Column(name = "promocao")
    private Integer promocao;
    @Column(name = "precoUnitPromocao")
    private Double precoUnitPromocao;

    public Item() {
    }

    public Item(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSiglaUnidade() {
        return siglaUnidade;
    }

    public void setSiglaUnidade(String siglaUnidade) {
        this.siglaUnidade = siglaUnidade;
    }

    public Double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(Double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public Integer getQtdeEmbalagem() {
        return qtdeEmbalagem;
    }

    public void setQtdeEmbalagem(Integer qtdeEmbalagem) {
        this.qtdeEmbalagem = qtdeEmbalagem;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Integer getPromocao() {
        return promocao;
    }

    public void setPromocao(Integer promocao) {
        this.promocao = promocao;
    }

    public Double getPrecoUnitPromocao() {
        return precoUnitPromocao;
    }

    public void setPrecoUnitPromocao(Double precoUnitPromocao) {
        this.precoUnitPromocao = precoUnitPromocao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dao.Item[ idItem=" + idItem + " ]";
    }
    
}
