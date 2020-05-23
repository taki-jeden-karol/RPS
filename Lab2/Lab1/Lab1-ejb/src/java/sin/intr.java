/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sin;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.interceptor.InvocationContext;
/**
 *
 * @author Алиса
 */
public class intr implements Serializable {

    @EJB
    MasterCount masterCount;
    
    public Object addInterceptor(InvocationContext context) throws Exception {
        masterCount.add();
        return context.proceed();
    }
}
