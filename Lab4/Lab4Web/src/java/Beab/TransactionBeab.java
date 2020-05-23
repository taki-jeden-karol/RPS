/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beab;

import Model.Master;
import Model.PetSchool;
import javax.ejb.Local;

/**
 *
 * @author Алиса
 */
@Local
public interface TransactionBeab {
    public void transactionMasters();

    public void transactionPetSchool();

    public void putIntoMastersList(Master masta);

    public void putIntoPetSchoolsList(PetSchool petschool);
}
