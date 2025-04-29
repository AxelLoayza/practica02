package tecsup.edu.pe.democrudjdbc.service;

import tecsup.edu.pe.democrudjdbc.dao.CursoDAO;
import tecsup.edu.pe.democrudjdbc.dao.impl.DaoFactory;
import tecsup.edu.pe.democrudjdbc.model.Curso;
import java.util.List;

public class CursoService {
    private final CursoDAO dao;

    public CursoService() {
        this.dao = DaoFactory.getCursoDao();
    }

    public List<Curso> listarCursos() { return dao.listar(); }
    public boolean insertarCurso(Curso curso) { return dao.insertar(curso); }
    public boolean actualizarCurso(Curso curso) { return dao.actualizar(curso); }
    public boolean eliminarCurso(String codigo) { return dao.eliminar(codigo); }
    public Curso buscarPorCodigo(String codigo) { return dao.buscarPorCodigo(codigo); }
}
