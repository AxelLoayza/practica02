package tecsup.edu.pe.practica02.dao;

import org.springframework.stereotype.Repository;
import tecsup.edu.pe.practica02.model.Laboratorio;

import java.util.List;

@Repository
public interface LaboratorioDAO {

    List<Laboratorio> listar();
    Laboratorio buscarPorId(Long codLab);
    void guardar(Laboratorio laboratorio);
    void actualizar(Laboratorio laboratorio);
    void eliminar(Long codLab);
}