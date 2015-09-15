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
@Table(name = "Unidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidade.findAll", query = "SELECT u FROM Unidade u"),
    @NamedQuery(name = "Unidade.findBySiglaUnidade", query = "SELECT u FROM Unidade u WHERE u.siglaUnidade = :siglaUnidade"),
    @NamedQuery(name = "Unidade.findByDescricao", query = "SELECT u FROM Unidade u WHERE u.descricao = :descricao")})
public class Unidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SiglaUnidade")
    private String siglaUnidade;
    @Column(name = "Descricao")
    private String descricao;

    public Unidade() {
    }

    public Unidade(String siglaUnidade) {
        this.siglaUnidade = siglaUnidade;
    }

    public String getSiglaUnidade() {
        return siglaUnidade;
    }

    public void setSiglaUnidade(String siglaUnidade) {
        this.siglaUnidade = siglaUnidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siglaUnidade != null ? siglaUnidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
        if ((this.siglaUnidade == null && other.siglaUnidade != null) || (this.siglaUnidade != null && !this.siglaUnidade.equals(other.siglaUnidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dao.Unidade[ siglaUnidade=" + siglaUnidade + " ]";
    }
    
}
