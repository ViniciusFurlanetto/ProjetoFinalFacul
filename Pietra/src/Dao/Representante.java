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
@Table(name = "Representante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representante.findAll", query = "SELECT r FROM Representante r"),
    @NamedQuery(name = "Representante.findByIdRepres", query = "SELECT r FROM Representante r WHERE r.idRepres = :idRepres"),
    @NamedQuery(name = "Representante.findByNome", query = "SELECT r FROM Representante r WHERE r.nome = :nome"),
    @NamedQuery(name = "Representante.findByTelefone", query = "SELECT r FROM Representante r WHERE r.telefone = :telefone"),
    @NamedQuery(name = "Representante.findByCelular", query = "SELECT r FROM Representante r WHERE r.celular = :celular"),
    @NamedQuery(name = "Representante.findByPerComissao", query = "SELECT r FROM Representante r WHERE r.perComissao = :perComissao")})
public class Representante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRepres")
    private Integer idRepres;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "perComissao")
    private Double perComissao;

    public Representante() {
    }

    public Representante(Integer idRepres) {
        this.idRepres = idRepres;
    }

    public Integer getIdRepres() {
        return idRepres;
    }

    public void setIdRepres(Integer idRepres) {
        this.idRepres = idRepres;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Double getPerComissao() {
        return perComissao;
    }

    public void setPerComissao(Double perComissao) {
        this.perComissao = perComissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepres != null ? idRepres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representante)) {
            return false;
        }
        Representante other = (Representante) object;
        if ((this.idRepres == null && other.idRepres != null) || (this.idRepres != null && !this.idRepres.equals(other.idRepres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dao.Representante[ idRepres=" + idRepres + " ]";
    }
    
}
