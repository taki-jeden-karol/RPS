package Beabs;

import Model.Pet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Алиса
 */
public class PetBeab implements PetSessionLocal {
    
    @PersistenceContext(unitName = "Lab3Ch2")
    private EntityManager eM;

    @Override
    public void add(Pet pet) {
        eM.persist(pet);
    }

    @Override
    public void update(Pet pet) {
        eM.merge(pet);
    }

    @Override
    public void remove(Pet pet) {
        eM.remove(eM.merge(pet));
    }

    @Override
    public List<Pet> getAll() {
        return eM.createQuery("select p from Pet p").getResultList();
    }

    @Override
    public Pet getById(Long id) {
        return eM.find(Pet.class, id);
    }
    
}
