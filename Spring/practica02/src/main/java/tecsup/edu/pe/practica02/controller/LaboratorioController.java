package tecsup.edu.pe.practica02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tecsup.edu.pe.practica02.model.Laboratorio;
import tecsup.edu.pe.practica02.service.LaboratorioService;

import java.util.List;

@RestController
@RequestMapping("/laboratorios")
public class LaboratorioController {

    private final LaboratorioService laboratorioService;

    @Autowired
    public LaboratorioController(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    @GetMapping
    public List<Laboratorio> listar() {
        return laboratorioService.listar();
    }

    @GetMapping("/{codLab}")
    public Laboratorio obtener(@PathVariable Long codLab) {
        return laboratorioService.obtener(codLab);
    }

    @PostMapping
    public void crear(@RequestBody Laboratorio laboratorio) {
        laboratorioService.crear(laboratorio);
    }

    @PutMapping("/{codLab}")
    public void actualizar(@PathVariable Long codLab, @RequestBody Laboratorio laboratorio) {
        laboratorio.setCodLab(codLab);
        laboratorioService.actualizar(laboratorio);
    }

    @DeleteMapping("/{codLab}")
    public void eliminar(@PathVariable Long codLab) {
        laboratorioService.eliminar(codLab);
    }
}