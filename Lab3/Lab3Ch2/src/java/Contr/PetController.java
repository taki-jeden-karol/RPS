package Contr;

import Beabs.MasterSessionLocal;
import Beabs.PetSessionLocal;
import Model.Pet;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Алиса
 */
public class PetController {
    @EJB
    private PetSessionLocal petSessionLocal;

        
    private Pet pet = new Pet();
    
        protected void goGet(HttpServletRequest request,
            HttpServletResponse response) 
                throws ServletException, IOException {
        request.setAttribute("master", petSessionLocal.getAll());
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
            pet.setName(request.getParameter("nameUpdate"));
            pet.setRace(request.getParameter("raceUpdate"));
            petSessionLocal.update(pet);
            dispatcher =
                request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            break;
        case ("Create"):
            pet = new Pet();
            pet.setName(request.getParameter("nameUpdate"));
            pet.setRace(request.getParameter("raceUpdate"));
            petSessionLocal.add(pet);
            dispatcher =
                request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            break;
        case ("Delete"):
            petSessionLocal.remove(pet);
            break;
        default:
            dispatcher=request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
    }
    }
}
