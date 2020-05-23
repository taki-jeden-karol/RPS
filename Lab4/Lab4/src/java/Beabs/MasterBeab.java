package Beabs;

import Model.Master;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Алиса
 */
public class MasterBeab implements MasterSessionLocal {

    @PersistenceContext(unitName = "Lab3Ch2")
    private EntityManager eM;
    
    @Override
    @TransactionAttribute(REQUIRES_NEW)
    public void add(Master masta) {
        eM.persist(masta);
        if (masta.getName().equals("ImmaException"))
            throw new EJBException();
    }

    @Override
    public void update(Master masta) {
        eM.merge(masta);
    }

    @Override
    public void remove(Master masta) {
        eM.remove(eM.merge(masta));
    }

    @Override
    public List<Master> getAll() {
        return eM.createQuery("select m from Master m").getResultList();
    }

    @Override
    public Master getById(Long id) {
        return eM.find(Master.class, id);
    }
    
}
