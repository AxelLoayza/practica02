package tecsup.edu.pe.practica02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tecsup.edu.pe.practica02.dao.LaboratorioDAO;
import tecsup.edu.pe.practica02.model.Laboratorio;

import java.util.List;

@Service
public class LaboratorioServiceImpl implements LaboratorioService {

    private final LaboratorioDAO laboratorioDAO;

    @Autowired
    public LaboratorioServiceImpl(LaboratorioDAO laboratorioDAO) {
        this.laboratorioDAO = laboratorioDAO;
    }

    @Override
    public List<Laboratorio> listar() {
        return laboratorioDAO.listar();
    }

    @Override
    public Laboratorio obtener(Long codLab) {
        return laboratorioDAO.buscarPorId(codLab);
    }

    @Override
    public void crear(Laboratorio laboratorio) {
        laboratorioDAO.guardar(laboratorio);
    }

    @Override
    public void actualizar(Laboratorio laboratorio) {
        laboratorioDAO.actualizar(laboratorio);
    }

    @Override
    public void eliminar(Long codLab) {
        laboratorioDAO.eliminar(codLab);
    }
}