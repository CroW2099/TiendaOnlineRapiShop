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



/**
 *
 * @author man
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT f FROM Proveedor f")
    , @NamedQuery(name = "Proveedor.findByIdProveedor", query = "SELECT f FROM Proveedor f WHERE f.prov_id = :prov_id")
    , @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT f FROM Proveedor f WHERE f.prov_nom = :prov_nom")
    , @NamedQuery(name = "Proveedor.findByDireccion", query = "SELECT f FROM Proveedor f WHERE f.prov_dir = :prov_dir")
    , @NamedQuery(name = "Proveedor.findByCelular", query = "SELECT f FROM Proveedor f WHERE f.prov_cel = :prov_cel")
    , @NamedQuery(name = "Proveedor.findByEmail", query = "SELECT f FROM Proveedor f WHERE f.prov_email = :prov_email")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prov_id")
    private Integer prov_id;
    @Basic(optional = false)
    @Column(name = "prov_nom")
    private String prov_nom;
    @Basic(optional = false)
    @Column(name = "prov_dir")
    private String prov_dir;
    @Basic(optional = false)
    @Column(name = "prov_cel")
    private String prov_cel;
    @Basic(optional = false)
    @Column(name = "prov_email")
    private String prov_email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    //@JsonBackReference(value="cat_pro")
    private List<Productos> productosList;
    
    public Proveedor() {
    }

    public Proveedor(Integer prov_id) {
        this.prov_id = prov_id;
    }

    public Proveedor(Integer prov_id, String prov_nom, String prov_dir, String prov_cel, String prov_email) {
        this.prov_id = prov_id;
        this.prov_nom = prov_nom;
        this.prov_dir = prov_dir;
        this.prov_cel = prov_cel;
        this.prov_email = prov_email;
    }

    public Integer getprov_id() {
        return prov_id;
    }

    public void setprov_id(Integer prov_id) {
        this.prov_id = prov_id;
    }

    public String getprov_nom() {
        return prov_nom;
    }

    public void setprov_nom(String prov_nom) {
        this.prov_nom = prov_nom;
    }

    public String getprov_dir() {
        return prov_dir;
    }

    public void setprov_dir(String prov_dir) {
        this.prov_dir = prov_dir;
    }

    public String getprov_cel() {
        return prov_cel;
    }

    public void setprov_cel(String prov_cel) {
        this.prov_cel = prov_cel;
    }

    public String getprov_email() {
        return prov_email;
    }

    public void setprov_email(String prov_email) {
        this.prov_email = prov_email;
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
        hash += (prov_id != null ? prov_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.prov_id == null && other.prov_id != null) || (this.prov_id != null && !this.prov_id.equals(other.prov_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Proveedor[ prov_id=" + prov_id + " ]";
    }
    
}
