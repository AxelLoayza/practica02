package tecsup.edu.pe.practica02.dao;

import org.springframework.stereotype.Repository;
import tecsup.edu.pe.practica02.model.OrdenCompra;

import java.util.List;

@Repository
public interface OrdenCompraDAO {
    List<OrdenCompra> listar();
    OrdenCompra buscarPorId(Long nroOrdenC);
    void guardar(OrdenCompra ordenCompra);
    void actualizar(OrdenCompra ordenCompra);
    void eliminar(Long nroOrdenC);
}