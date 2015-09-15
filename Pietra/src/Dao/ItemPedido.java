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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ItemPedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemPedido.findAll", query = "SELECT i FROM ItemPedido i"),
    @NamedQuery(name = "ItemPedido.findBySeq", query = "SELECT i FROM ItemPedido i WHERE i.seq = :seq"),
    @NamedQuery(name = "ItemPedido.findByIdPedido", query = "SELECT i FROM ItemPedido i WHERE i.idPedido = :idPedido"),
    @NamedQuery(name = "ItemPedido.findByIdItem", query = "SELECT i FROM ItemPedido i WHERE i.idItem = :idItem"),
    @NamedQuery(name = "ItemPedido.findByQuantidade", query = "SELECT i FROM ItemPedido i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItemPedido.findByValorBase", query = "SELECT i FROM ItemPedido i WHERE i.valorBase = :valorBase"),
    @NamedQuery(name = "ItemPedido.findByValorTotal", query = "SELECT i FROM ItemPedido i WHERE i.valorTotal = :valorTotal")})
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seq")
    private Integer seq;
    @Basic(optional = false)
    @Column(name = "idPedido")
    private int idPedido;
    @Basic(optional = false)
    @Column(name = "idItem")
    private int idItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "valorBase")
    private Double valorBase;
    @Column(name = "valorTotal")
    private Double valorTotal;

    public ItemPedido() {
    }

    public ItemPedido(Integer seq) {
        this.seq = seq;
    }

    public ItemPedido(Integer seq, int idPedido, int idItem) {
        this.seq = seq;
        this.idPedido = idPedido;
        this.idItem = idItem;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seq != null ? seq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPedido)) {
            return false;
        }
        ItemPedido other = (ItemPedido) object;
        return !((this.seq == null && other.seq != null) || (this.seq != null && !this.seq.equals(other.seq)));
    }

    @Override
    public String toString() {
        return "Dao.ItemPedido[ seq=" + seq + " ]";
    }
    
}
