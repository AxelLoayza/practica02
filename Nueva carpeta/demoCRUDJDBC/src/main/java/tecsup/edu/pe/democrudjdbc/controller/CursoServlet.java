package tecsup.edu.pe.democrudjdbc.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tecsup.edu.pe.democrudjdbc.model.Curso;
import tecsup.edu.pe.democrudjdbc.service.CursoService;

import java.io.IOException;
import java.util.List;



public class CursoServlet extends HttpServlet {
    private final CursoService cursoService = new CursoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String vista = "lista.jsp";

        List<Curso> cursos = cursoService.listarCursos();
        req.setAttribute("cursos", cursos);

        switch (action != null ? action : "list") {
            case "buscar":
                Curso curso = cursoService.buscarPorCodigo(req.getParameter("codigo"));
                req.setAttribute("curso", curso);
                vista = "editar.jsp";
                break;
            case "nuevo":
                vista = "editar.jsp";
                break;
            case "eliminar":
                vista = "eliminar.jsp";
                break;
        }

        req.getRequestDispatcher(vista).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        Curso curso = new Curso();
        curso.setCodigo(req.getParameter("codigo"));
        curso.setNombre(req.getParameter("nombre"));
        try {
            curso.setCreditos(Integer.parseInt(req.getParameter("creditos")));
        } catch (NumberFormatException e) {
            curso.setCreditos(0);
        }

        switch (action != null ? action : "") {
            case "insert":
                cursoService.insertarCurso(curso);
                break;
            case "update":
                cursoService.actualizarCurso(curso);
                break;
            case "eliminar":
                cursoService.eliminarCurso(req.getParameter("codigo"));
                break;
        }

        resp.sendRedirect("lista?action=list"); // Redirección corregida
    }
}
