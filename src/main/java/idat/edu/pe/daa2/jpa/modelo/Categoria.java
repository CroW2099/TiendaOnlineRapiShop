/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.cat_id = :cat_id")
    , @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.cat_nom = :cat_nom")
    , @NamedQuery(name = "Categoria.findByDescripcion", query = "SELECT c FROM Categoria c WHERE c.cat_desc = :cat_desc")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Integer cat_id;
    @Basic(optional = false)
    @Column(name = "cat_nom")
    private String cat_nom;
    @Basic(optional = false)
    @Column(name = "cat_desc")
    private String cat_desc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    //@JsonBackReference(value="cat_pro")
    private List<Productos> productosList;

    public Categoria() {
    }

    public Categoria(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public Categoria(Integer cat_id, String cat_nom, String cat_desc) {
        this.cat_id = cat_id;
        this.cat_nom = cat_nom;
        this.cat_desc = cat_desc;
    }

    public Integer getcat_id() {
        return cat_id;
    }

    public void setcat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getcat_nom() {
        return cat_nom;
    }

    public void setcat_nom(String cat_nom) {
        this.cat_nom = cat_nom;
    }

    public String getcat_desc() {
        return cat_desc;
    }

    public void setcat_desc(String cat_desc) {
        this.cat_desc = cat_desc;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cat_id != null ? cat_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.cat_id == null && other.cat_id != null) || (this.cat_id != null && !this.cat_id.equals(other.cat_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Categoria[ cat_id=" + cat_id + " ]";
    }
    
}
