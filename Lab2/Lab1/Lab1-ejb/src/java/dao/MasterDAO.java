/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Алиса
 * @param <Masta>
 */
@Remote
public interface MasterDAO <Masta>{
    
    public List<Masta> listAllMasters();
    
    public Masta getMaster(int id);
    
    public void delete(int id);
    
    public void update(Masta model);
    
    public Masta create(Masta model);
}
