package Beabs;

import Model.PetSchool;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Алиса
 */
@Local
public interface PetSchoolSessionLocal {
    
    public void add(PetSchool petschool);
    
    public void update(PetSchool petschool);
    
    public void remove(PetSchool petschool);
    
    public List<PetSchool> getAll();
    
    public PetSchool getById(Long id);

}
