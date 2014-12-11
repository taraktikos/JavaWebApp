package main.controller;

import main.dao.CountryDao;
import main.model.Country;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountryController extends HttpServlet {
    private static String INSERT_OR_EDIT = "/country/form.jsp";
    private static String LIST = "/country/index.jsp";
    private CountryDao dao;

    public CountryController() {
        super();
        dao = new CountryDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            forward = LIST;
            request.setAttribute("countries", dao.getAll());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Country country = dao.getById(id);
            request.setAttribute("country", country);
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST;
            request.setAttribute("countries", dao.getAll());
        } else {
            forward = LIST;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Country country = new Country();
        country.setName(request.getParameter("name"));
        country.setCode(request.getParameter("code"));
        country.setLongCode(request.getParameter("long_code"));
        String id = request.getParameter("id");
        if(id == null || id.isEmpty())
        {
            dao.add(country);
        }
        else
        {
            country.setId(Integer.parseInt(id));
            dao.update(country);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST);
        request.setAttribute("countries", dao.getAll());
        view.forward(request, response);
    }
}
