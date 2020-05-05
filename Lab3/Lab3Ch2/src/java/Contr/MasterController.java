package Contr;

import Beabs.MasterSessionLocal;
import Beabs.PetSessionLocal;
import Model.Master;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Алиса
 */
public class MasterController extends HttpServlet {
    @EJB
    private MasterSessionLocal mastaSessionLocal;
    @EJB
    private PetSessionLocal petSessionLocal;

        
    private Master master = new Master();
    
    protected void goGet(HttpServletRequest request,
            HttpServletResponse response) 
                throws ServletException, IOException {
        request.setAttribute("master", mastaSessionLocal.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) 
            throws ServletException, IOException {
    String act = request.getParameter("act");
    RequestDispatcher dispatcher;
    switch (act){
        case ("Update"):
            master.setName(request.getParameter("nameUpdate"));
            master.setAddress(request.getParameter("addressUpdate"));
            master.setPetrace(petSessionLocal.getById(Long.parseLong(
                    request.getParameter("petraceUpdate"))));
            mastaSessionLocal.update(master);
            dispatcher =
                request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            break;
        case ("Create"):
            master = new Master();
            master.setName(request.getParameter("nameCreate"));
            master.setAddress(request.getParameter("addressCreate"));
            master.setPetrace(petSessionLocal.getById(Long.parseLong(
                    request.getParameter("petraceUpdate"))));
            mastaSessionLocal.add(master);
            dispatcher =
                request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            break;
        case ("Delete"):
            mastaSessionLocal.remove(master);
            break;
        default:
            dispatcher=request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
    }
    }

}
