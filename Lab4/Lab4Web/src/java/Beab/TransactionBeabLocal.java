/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beab;

import Beabs.MasterSessionLocal;
import Beabs.MasterBeab;
import Beabs.PetSchoolSessionLocal;
import Beabs.PetSchoolBeab;
import Model.Master;
import Model.PetSchool;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;


/**
 *
 * @author Алиса
 */
@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class TransactionBeabLocal implements TransactionBeab {

    List<Master> mastas = new ArrayList<>();
    List<PetSchool> petschools = new ArrayList<>();
    
    @EJB
    private MasterSessionLocal masterEjb;
    
    @EJB
    private PetSchoolSessionLocal petschoolEjb;
    
    @Resource
    javax.transaction.UserTransaction userTransaction;
    
    @Override
    public void transactionMasters() {
        try {
            userTransaction.begin();
            for (Master master : mastas){
                masterEjb.add(master);
            }
            userTransaction.commit();
        }
        catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e){
            Logger.getLogger(TransactionBeabLocal.class.getName()).log(Level.SEVERE, null, e);
        }
        mastas = new ArrayList<>();
    }

    @Override
    public void transactionPetSchool() {
        try {
            userTransaction.begin();
            for (PetSchool petschool : petschools){
                petschoolEjb.add(petschool);
            }
            userTransaction.commit();
        }
        catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e){
            Logger.getLogger(TransactionBeabLocal.class.getName()).log(Level.SEVERE, null, e);
        }
        petschools = new ArrayList<>();
    }

    @Override
    public void putIntoMastersList(Master masta) {
        mastas.add(masta);
    }

    @Override
    public void putIntoPetSchoolsList(PetSchool petschool) {
        petschools.add(petschool);
    }
    
}
