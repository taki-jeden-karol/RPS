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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Алиса
 */
@Entity
@Table(name="PetSchool")
public class PetSchool implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name="id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name="name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Column(name="place")
    private String place;
    
    public PetSchool(){
    }
    
    public PetSchool(Integer id){
        this.id=id;
    }
    
    public PetSchool(Integer id, String name, String place){
        this.id=id;
        this.name=name;
        this.place=place;
    }
    
    public static long getSerialVersionID(){
        return serialVersionUID;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    
    @Override
    public String toString(){
        return "PetSchool{" + "id=" + id + ", name=" + name + ", place=" +place + "}";
    }

    
}