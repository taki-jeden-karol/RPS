package Beabs;

import Model.Pet;
import java.util.List;

/**
 *
 * @author Алиса
 */
public interface PetSessionLocal {
    public void add(Pet pet);
    
    public void update(Pet masta);
    
    public void remove(Pet masta);
    
    public List<Pet> getAll();
    
    public Pet getById(Long id);
}
