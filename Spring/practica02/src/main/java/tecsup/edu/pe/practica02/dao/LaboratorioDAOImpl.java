package tecsup.edu.pe.practica02.dao;


import org.springframework.stereotype.Repository;
import tecsup.edu.pe.practica02.model.Laboratorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LaboratorioDAOImpl implements LaboratorioDAO {

    private final Map<String, Laboratorio> baseDatos = new HashMap<>();
    private long idActual = 1;

    @Override
    public List<Laboratorio> listar() {
        return new ArrayList<>(baseDatos.values());
    }

    @Override
    public Laboratorio buscarPorId(Long codLab) {
        return baseDatos.get(codLab.toString());
    }

    @Override
    public void guardar(Laboratorio laboratorio) {
        laboratorio.setCodLab(idActual++);
        baseDatos.put(laboratorio.getCodLab().toString(), laboratorio);
    }

    @Override
    public void actualizar(Laboratorio laboratorio) {
        baseDatos.put(laboratorio.getCodLab().toString(), laboratorio);
    }

    @Override
    public void eliminar(Long codLab) {
        baseDatos.remove(codLab.toString());
    }
}