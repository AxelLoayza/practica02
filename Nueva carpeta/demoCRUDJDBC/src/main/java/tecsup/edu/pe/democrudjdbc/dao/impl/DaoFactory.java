package tecsup.edu.pe.democrudjdbc.dao.impl;
import  tecsup.edu.pe.democrudjdbc.dao.CursoDAO;
public class DaoFactory {
    public static CursoDAO getCursoDao() {
        return new CursoDAO(); // Instancia única de CursoDAO con JDBC
    }
}

