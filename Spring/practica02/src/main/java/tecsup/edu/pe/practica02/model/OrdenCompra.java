package tecsup.edu.pe.practica02.model;


public class OrdenCompra {
    private Long nroOrdenC;      // Identificador único
    private String fechaEmision; // Fecha de emisión
    private String situacion;    // Estado de la orden
    private Double total;        // Monto total de la orden
    private Laboratorio laboratorio; // Relación con Laboratorio
    private String nroFacturaProv; // Factura del proveedor



    // Constructor con parámetros
    public OrdenCompra(Long nroOrdenC, String fechaEmision, String situacion, Double total, Laboratorio laboratorio, String nroFacturaProv) {
        this.nroOrdenC = nroOrdenC;
        this.fechaEmision = fechaEmision;
        this.situacion = situacion;
        this.total = total;
        this.laboratorio = laboratorio;
        this.nroFacturaProv = nroFacturaProv;

    public Long getNroOrdenC() { return nroOrdenC; }
    public void setNroOrdenC(Long nroOrdenC) { this.nroOrdenC = nroOrdenC; }

    public String getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(String fechaEmision) { this.fechaEmision = fechaEmision; }

    public String getSituacion() { return situacion; }
    public void setSituacion(String situacion) { this.situacion = situacion; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public Laboratorio getLaboratorio() { return laboratorio; }
    public void setLaboratorio(Laboratorio laboratorio) { this.laboratorio = laboratorio; }

    public String getNroFacturaProv() { return nroFacturaProv; }
    public void setNroFacturaProv(String nroFacturaProv) { this.nroFacturaProv = nroFacturaProv; }
}