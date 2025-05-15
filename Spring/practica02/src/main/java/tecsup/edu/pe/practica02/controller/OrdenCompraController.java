package tecsup.edu.pe.practica02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecsup.edu.pe.practica02.model.OrdenCompra;
import tecsup.edu.pe.practica02.service.OrdenCompraService;

import java.util.List;

@RestController
@RequestMapping("/ordenes-compra")
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    @Autowired
    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        this.ordenCompraService = ordenCompraService;
    }

    @GetMapping
    public List<OrdenCompra> listar() {
        return ordenCompraService.listar();
    }

    @GetMapping("/{nroOrdenC}")
    public OrdenCompra obtener(@PathVariable Long nroOrdenC) {
        return ordenCompraService.obtener(nroOrdenC);
    }

    @PostMapping
    public void crear(@RequestBody OrdenCompra ordenCompra) {
        ordenCompraService.crear(ordenCompra);
    }

    @PutMapping("/{nroOrdenC}")
    public void actualizar(@PathVariable Long nroOrdenC, @RequestBody OrdenCompra ordenCompra) {
        ordenCompra.setNroOrdenC(nroOrdenC);
        ordenCompraService.actualizar(ordenCompra);
    }

    @DeleteMapping("/{nroOrdenC}")
    public void eliminar(@PathVariable Long nroOrdenC) {
        ordenCompraService.eliminar(nroOrdenC);
    }
}