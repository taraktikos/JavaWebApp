package main.controller;

import main.dao.CountryDao;
import main.model.Country;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountryController extends HttpServlet {
    private static String INSERT_OR_EDIT = "/country/form.jsp";
    private static String LIST = "/country/index.jsp";
    private CountryDao dao;

    public CountryController() {
        super();
        dao = new CountryDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward;
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            response.sendRedirect("CountryController?action=list");
            return;
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Country model = dao.getById(id);
            request.setAttribute("model", model);
            request.setAttribute("errors", new HashMap<String, String>());
        } else if (action.equalsIgnoreCase("list")){
            forward = LIST;
            request.setAttribute("countries", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Country model = new Country();
        int id;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0;
        }
        model.setId(id);
        model.setName(request.getParameter("name"));
        model.setCode(request.getParameter("code"));
        model.setLongCode(request.getParameter("longCode"));
        Map<String, String> errors = dao.validate(model);
        RequestDispatcher view;
        if (errors.size() == 0) {
            if (model.getId() == 0) {
                dao.add(model);
            } else {
                dao.update(model);
            }
            response.sendRedirect("CountryController?action=list");
        } else {
            view = request.getRequestDispatcher(INSERT_OR_EDIT);
            request.setAttribute("errors", errors);
            request.setAttribute("model", model);
            view.forward(request, response);
        }
    }
}
