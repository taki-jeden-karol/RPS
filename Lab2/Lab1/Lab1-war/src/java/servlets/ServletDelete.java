/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.MasterDAO;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Алиса
 */
public class ServletDelete extends HttpServlet{
    @EJB 
    private MasterDAO dao;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       dao.delete(Integer.parseInt(request.getQueryString()));
       response.sendRedirect("master");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       dao.delete(Integer.parseInt(request.getQueryString()));
       response.sendRedirect("master");
    }

    @Override
    public String getServletInfo() {
        return "";
    }
}
