package Beabs;

import Model.PetSchool;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Алиса
 */
@Stateless
public class PetSchoolBeab implements PetSchoolSessionLocal {

    @PersistenceContext(unitName = "Lab4Ch2")
    private EntityManager eM;
    
    @Resource
    private SessionContext context;
    
    //условия отмены транзакции
    @Override
    @TransactionAttribute(NOT_SUPPORTED)
    public void add(PetSchool petschool) {
        eM.persist(petschool);
        if (petschool.getName().length() > 25) {
            context.setRollbackOnly();
        }
    }

    @Override
    public void update(PetSchool petschool) {
        eM.merge(petschool);
    }

    @Override
    public void remove(PetSchool petschool) {
        eM.remove(eM.merge(petschool));
    }

    @Override
    public List<PetSchool> getAll() {
        List <PetSchool> petSchoolList=eM.createQuery("select petschool from PetSchool petschool").getResultList();
        return petSchoolList;
    }

    @Override
    public PetSchool getById(Long id) {
        return eM.find(PetSchool.class, id);
    }
    
}
