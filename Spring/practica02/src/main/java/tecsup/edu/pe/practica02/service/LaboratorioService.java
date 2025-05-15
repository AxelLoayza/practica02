package tecsup.edu.pe.practica02.service;

import org.springframework.stereotype.Service;
import tecsup.edu.pe.practica02.model.Laboratorio;

import java.util.List;

@Service
public interface LaboratorioService {
    List<Laboratorio> listar();
    Laboratorio obtener(Long codLab);
    void crear(Laboratorio laboratorio);
    void actualizar(Laboratorio laboratorio);
    void eliminar(Long codLab);
}