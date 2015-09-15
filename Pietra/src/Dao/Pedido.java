/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author viniciusfurlanetto
 */
@Entity
@Table(name = "Pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByPrazo", query = "SELECT p FROM Pedido p WHERE p.prazo = :prazo"),
    @NamedQuery(name = "Pedido.findByValorTotal", query = "SELECT p FROM Pedido p WHERE p.valorTotal = :valorTotal"),
    @NamedQuery(name = "Pedido.findByEncaminhado", query = "SELECT p FROM Pedido p WHERE p.encaminhado = :encaminhado"),
    @NamedQuery(name = "Pedido.findByDtEmissao", query = "SELECT p FROM Pedido p WHERE p.dtEmissao = :dtEmissao"),
    @NamedQuery(name = "Pedido.findByIdCliente", query = "SELECT p FROM Pedido p WHERE p.idCliente = :idCliente"),
    @NamedQuery(name = "Pedido.findByIdRepresentante", query = "SELECT p FROM Pedido p WHERE p.idRepresentante = :idRepresentante")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPedido")
    private Integer idPedido;
    @Basic(optional = false)
    @Column(name = "prazo")
    private String prazo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorTotal")
    private Double valorTotal;
    @Column(name = "encaminhado")
    private Integer encaminhado;
    @Column(name = "dtEmissao")
    @Temporal(TemporalType.DATE)
    private Date dtEmissao;
    @Column(name = "idCliente")
    private Integer idCliente;
    @Column(name = "idRepres")
    private Integer idRepres;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, String prazo) {
        this.idPedido = idPedido;
        this.prazo = prazo;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getEncaminhado() {
        return encaminhado;
    }

    public void setEncaminhado(Integer encaminhado) {
        this.encaminhado = encaminhado;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdRepres() {
        return idRepres;
    }

    public void setIdRepres(Integer idRepres) {
        this.idRepres = idRepres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dao.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
