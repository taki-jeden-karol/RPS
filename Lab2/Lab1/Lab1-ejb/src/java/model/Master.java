/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
/**
 *
 * @author Алиса
 */
public class Master implements Serializable {
    private int id;
    private String name;
    private String address;
    private String petname;
    
    public Master(int id, String name, String address, String petname) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.petname = petname;
    }

    public Master() {
    }
    
     /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
        
    /**
     * @return the petname
     */
    public String getPetname() {
        return petname;
    }

    /**
     * @param address the address to set
     */
    public void setPetname(String petname) {
        this.petname = petname;
    }
    
}
