package tecsup.edu.pe.practica02.service;

import org.springframework.stereotype.Service;
import tecsup.edu.pe.practica02.model.OrdenCompra;

import java.util.List;

@Service
public interface OrdenCompraService {
    List<OrdenCompra> listar();
    OrdenCompra obtener(Long nroOrdenC);
    void crear(OrdenCompra ordenCompra);
    void actualizar(OrdenCompra ordenCompra);
    void eliminar(Long nroOrdenC);
}