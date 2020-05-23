/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.MasterDAO;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Master;

/**
 *
 * @author Алиса
 */
public class ServletMasta extends HttpServlet{
    @EJB 
    private MasterDAO dao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try { 
            List<Master> master = dao.listAllMasters();
            request.setAttribute("master", master);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (Exception e) { 
            throw new ServletException(e.getLocalizedMessage()); 
        }    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        try{
            request.getRequestDispatcher("list.jsp")
                    .forward(request,response);
        }catch (Exception e) { 
            throw new ServletException(e.getMessage()); 
        }    
    }

    @Override
    public String getServletInfo() {
        return "";
    }
}
