/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Алиса
 */
@Entity
@Table(name = "master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Master.findAll", query = "SELECT m FROM Master m")
    , @NamedQuery(name = "Master.findById", query = "SELECT m FROM Master m WHERE m.id = :id")
    , @NamedQuery(name = "Master.findByName", query = "SELECT m FROM Master m WHERE m.name = :name")
    , @NamedQuery(name = "Master.findByAddress", query = "SELECT m FROM Master m WHERE m.address = :address")
    , @NamedQuery(name = "Master.findByPetname", query = "SELECT m FROM Master m WHERE m.petname = :petname")})
public class Master implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "petname")
    private String petname;

    public Master() {
    }

    public Master(Integer id) {
        this.id = id;
    }

    public Master(Integer id, String name, String address, String petname) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.petname = petname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Master)) {
            return false;
        }
        Master other = (Master) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Master[ id=" + id + " ]";
    }
    
}
