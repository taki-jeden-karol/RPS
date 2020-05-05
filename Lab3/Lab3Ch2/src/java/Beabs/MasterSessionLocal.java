package Beabs;

import Model.Master;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Алиса
 */
@Local
public interface MasterSessionLocal {
    public void add(Master masta);
    
    public void update(Master masta);
    
    public void remove(Master masta);
    
    public List<Master> getAll();
    
    public Master getById(Long id);

}
