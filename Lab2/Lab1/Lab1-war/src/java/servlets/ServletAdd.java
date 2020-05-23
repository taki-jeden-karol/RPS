/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beabs.IStfBeab;
import dao.MasterDAO;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Master;
import sin.MasterCount;

/**
 *
 * @author Алиса
 */
public class ServletAdd extends HttpServlet{
    @EJB 
    private MasterDAO dao;
    
    @EJB
    private IStfBeab sb;
    
    @EJB 
    private MasterCount countMasta;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try { 
            request.getRequestDispatcher("add.jsp").forward(request, response);
        } catch (Exception e) { 
            throw new ServletException(e.getLocalizedMessage()); 
        } 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        try {
            Master master = new Master();
            master.setName(request.getParameter("name"));
            sb.addName(master.getName());
            master.setAddress(request.getParameter("address"));
            master.setPetname(request.getParameter("petname"));
            dao.create(master);
            countMasta.add();
            response.sendRedirect("master");
        } catch (Exception e) {
            throw new ServletException(e.getLocalizedMessage());       
        }
    }
    
    @Override
    public String getServletInfo() {
        return "";
    }
}
