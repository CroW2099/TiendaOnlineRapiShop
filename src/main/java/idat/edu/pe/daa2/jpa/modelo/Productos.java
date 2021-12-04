/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *
 * @author man
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.pro_id = :pro_id")
    , @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.pro_nom = :pro_nom")
    , @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.pro_desc = :pro_desc")
    , @NamedQuery(name = "Productos.findByCantidad", query = "SELECT p FROM Productos p WHERE p.pro_cant = :pro_cant")
    , @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.pro_prec = :pro_prec")
    , @NamedQuery(name = "Productos.findByStock", query = "SELECT p FROM Productos p WHERE p.pro_stock = :pro_stock")
    , @NamedQuery(name = "Productos.findByEnOrden", query = "SELECT p FROM Productos p WHERE p.pro_enorden = :pro_enorden")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_id")
    private Integer pro_id;
    @Basic(optional = false)
    @Column(name = "pro_nom")
    private String pro_nom;
    @Column(name = "pro_desc")
    private String pro_desc;
    @Column(name = "pro_cant")
    private Integer pro_cant;
    @Column(name = "pro_prec")
    private Double pro_prec;
    @Column(name = "pro_stock")
    private Integer pro_stock;
    @Column(name = "pro_enorden")
    private Integer pro_enorden;
    @JoinColumn(name = "categoria", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "proveedor", referencedColumnName = "prov_id")
    @ManyToOne(optional = false)
    private Proveedor proveedor;

    public Productos() {
    }

    public Productos(Integer pro_id, String pro_nom, String pro_desc, Integer pro_cant, Double pro_prec, Integer pro_stock, Integer pro_enorden) {
        this.pro_id = pro_id;
    }

    public Productos(Integer pro_id, String pro_nom) {
        this.pro_id = pro_id;
        this.pro_nom = pro_nom;
    }

    public Productos(String pro_nom, String pro_desc, Integer pro_cant, Double pro_prec, Integer pro_stock, Integer pro_enorden) {
		super();
		this.pro_nom = pro_nom;
		this.pro_desc = pro_desc;
		this.pro_cant = pro_cant;
		this.pro_prec = pro_prec;
		this.pro_stock = pro_stock;
		this.pro_enorden = pro_enorden;
	}

	public Integer getpro_id() {
        return pro_id;
    }

    public void setpro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public String getpro_nom() {
        return pro_nom;
    }

    public void setpro_nom(String pro_nom) {
        this.pro_nom = pro_nom;
    }

    public String getpro_desc() {
        return pro_desc;
    }

    public void setpro_desc(String pro_desc) {
        this.pro_desc = pro_desc;
    }

    public Integer getpro_cant() {
        return pro_cant;
    }

    public void setpro_cant(Integer pro_cant) {
        this.pro_cant = pro_cant;
    }

    public Double getpro_prec() {
        return pro_prec;
    }

    public void setpro_prec(Double pro_prec) {
        this.pro_prec = pro_prec;
    }

    public Integer getpro_stock() {
        return pro_stock;
    }

    public void setpro_stock(Integer pro_stock) {
        this.pro_stock = pro_stock;
    }

    public Integer getpro_enorden() {
        return pro_enorden;
    }

    public void setpro_enorden(Integer pro_enorden) {
        this.pro_enorden = pro_enorden;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pro_id != null ? pro_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.pro_id == null && other.pro_id != null) || (this.pro_id != null && !this.pro_id.equals(other.pro_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Productos[ pro_id=" + pro_id + " ]";
    }

	public Productos buscarPorID(int i) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
