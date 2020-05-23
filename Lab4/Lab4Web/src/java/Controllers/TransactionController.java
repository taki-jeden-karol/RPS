/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beab.TransactionBeabLocal;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Алиса
 */
public class TransactionController extends HttpServlet {
    @EJB
    TransactionBeabLocal transactionBeabLocal;

}
