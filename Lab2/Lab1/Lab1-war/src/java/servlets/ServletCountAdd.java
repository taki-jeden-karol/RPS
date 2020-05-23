/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beabs.IStfBeab;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sin.MasterCount;

/**
 *
 * @author Алиса
 */
public class ServletCountAdd extends HttpServlet{
    @EJB 
    private MasterCount countMaster;
    
    @EJB
    private IStfBeab sb;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("addcount", countMaster.getCount());
       List<String> list =sb.returnList();
       request.setAttribute("nameAdd", list);
       request.getRequestDispatcher("addcount.jsp").forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "";
    }
}
